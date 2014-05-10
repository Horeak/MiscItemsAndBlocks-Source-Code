package com.miscitems.MiscItemsAndBlocks.TileEntity;

import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.Network.PacketTileWithItemUpdate;
import com.miscitems.MiscItemsAndBlocks.Utils.Block.BlockUtil;
import com.miscitems.MiscItemsAndBlocks.Utils.Inventory.Utils;
import com.miscitems.MiscItemsAndBlocks.Utils.ItemHelper;
import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.Packet;
import net.minecraftforge.common.util.Constants;

import java.util.List;

public class TileEntityMiningChamber extends TileEntityPowerInv{

	public TileEntityMiningChamber() {
		super(1, "Mining Chamber", 64);
	}
	
	int Power = this.GetPower();
	int PowerTime = 0;
	int Time = 0;
	int MinedY = 0;
	int GenerateTime = 0;
	boolean CanMine = true;
	boolean Ready = false;
	
	public boolean Running;
	
	int Fortune = 0;
	int MiningTime = 0;
	
	public static int ToolSlot = 0;
	
	 int LastY = 0;
	 
	 
	 // Hole size = SizexSize
	 public int Size = 3;
	 public static int MaxSize = 11;
	 
	 public int NumberX = 0;
	 public int NumberZ = 0;
	
	
	public int GetSize(){
		return Size;
	}
	
	public void SetSize(int i){
		if(i > MaxSize){
			i = MaxSize;
		}
		Size = i;
	}
	
	public int GetPower(){
		return Power;
	}
	
	public void SetPower(int i){
		Power = i;
	}
	
	
	public int GetMinedY(){
		return MinedY;
	}
	
	public int GetLastY(){
		return LastY;
	}
	
	public boolean Ready(){
		return Ready;
	}
	
	public boolean IsRunning(){
		return Running;
	}
	
	public boolean CanMine(){
		return CanMine;
	}

	
	public void SetMinedY(int i){
		MinedY = i;
	}
	
	public void SetLastY(int i){
		LastY = i;
	}
	
	
    @Override
	public void writeToNBT(NBTTagCompound compound){
		super.writeToNBT(compound);
		this.nbt = compound;
		
		NBTTagList Items = new NBTTagList();
		
		for (int i = 0; i < getSizeInventory(); i++){
			
			ItemStack stack = getStackInSlot(i);
			if(stack != null){
				
				NBTTagCompound item = new NBTTagCompound();
				item.setByte("Slot", (byte)i);
				stack.writeToNBT(item);
				Items.appendTag(item);
			}
		}

		
		compound.setTag("Items", Items);
		compound.setInteger("Power", Power);
		
		compound.setInteger("Y", MinedY);
		
		compound.setInteger("LastY", LastY);
		
		compound.setBoolean("Can", CanMine);
		compound.setBoolean("Ready", Ready);
		
		
		compound.setInteger("Luck", Fortune);
		compound.setInteger("MiningTime", MiningTime);
		
		compound.setInteger("NumZ", NumberZ);
		compound.setInteger("NumX", NumberX);
		
		compound.setInteger("Size", Size);

		
		
		
		
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		this.nbt = compound;
		

		NBTTagList items = compound.getTagList("Items", Constants.NBT.TAG_COMPOUND);
		
		for(int i = 0; i < items.tagCount(); i++){
			
			NBTTagCompound item = (NBTTagCompound)items.getCompoundTagAt(i);
			int slot = item.getByte("Slot");
			
			if(slot >= 0 && slot < getSizeInventory()){
				setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(item));
				
			}
			

		}
		
		Power = compound.getInteger("Power");
		
		MinedY = compound.getInteger("Y");
		
		LastY = compound.getInteger("LastY");
		
		CanMine = compound.getBoolean("Can");
		Ready = compound.getBoolean("Ready");
		
		
		Fortune = compound.getInteger("Luck");
		MiningTime = compound.getInteger("MiningTime");
		
		NumberZ = compound.getInteger("NumZ");
		NumberX = compound.getInteger("NumX");
		
		Size = compound.getInteger("Size");

		
		
		
	}
	
    public void updateEntity()
    {
    	
    	
    	if(MinedY == 0)
    		MinedY = this.yCoord - 1;
    	
    	int Eff = EnchantmentHelper.getEnchantmentLevel(32, this.getStackInSlot(ToolSlot));
    	int Luck = EnchantmentHelper.getEnchantmentLevel(35, this.getStackInSlot(ToolSlot));
    	
    	
    	
    	if(Eff > 0){
    		int t = Eff * 3;
    		this.MiningTime = 50 - t;
    	}else{
    		this.MiningTime = 80;
    	}
    	
    	
    	if(Luck > 0){
    		Fortune = Luck;
    	}
    	
    	
    	if(!this.worldObj.isRemote){
    	if(this.getStackInSlot(ToolSlot) != null ){
    		if(Power > 0){
    		if(this.getStackInSlot(ToolSlot).getItem() instanceof ItemPickaxe){
    			int DamageLeft = this.getStackInSlot(ToolSlot).getMaxDamage() - this.getStackInSlot(ToolSlot).getItemDamage();
    			if(DamageLeft > 1){
    			
    			if(Ready){
    				SetValue(1);
    			}else{
    				SetValue(3);
    				return;
    			}
    			
    			}else{
    				SetValue(2);
    				return;
    			}
    	    	
    		}else{
    			SetValue(2);
    			return;
    		}
    	}else{
    		SetValue(0);
    		return;
    	}
    		
    	}else{
	    		SetValue(0);
	    		return;
	    	}
    		
    	}
    	
    	
    	
    	
    	if(MinedY <= LastY){
    		SetValue(0);
    		Ready = false;
    		return;
    	}
    	
    	
    	
    	
    	
    	
    	if(GetValue() == 1){
    	
    	if(Time == MiningTime){
    		Time = 0;
    		
    		
    		if(!this.worldObj.isRemote){
    		MineBlock((this.xCoord + NumberX) - (int)Size / 2, MinedY, (this.zCoord + NumberZ) - (int)Size / 2);
    		
    		
    		
    		NumberX++;
    		
    		
    		if(NumberX >= Size){

    			if(NumberZ >= Size - 1){
    				MinedY--;
    				NumberZ = 0;
    				NumberX = 0;
    			}else{

    				
    				NumberX = 0;
    				NumberZ++;
    				}
    			
    		}

    		
    	}
    		
    		
    		
    		
    	}else{
    		Time++;
    		return;
    	}
    	
    	
    	}

    		
    		


    	
    }
    
    public void SetValue(int i){
    	if(GetValue() != i){
		this.worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, i, 2);
    	}

    }
    
    public int GetValue(){
    	return this.worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
    }
    
    
    
    public void MineBlock(int x, int y, int z){


    	if(this.worldObj.getBlock(x, y, z) != Blocks.air){
    	if(this.worldObj.getBlock(x, y, z).getBlockHardness(this.worldObj, x, y, z) != -1){
    	

        List<ItemStack> stacks = BlockUtil.getItemStackFromBlock(worldObj, x, y, z, Fortune);

        if (stacks != null) {
                for (ItemStack s : stacks) {
                        if (s != null) {
                                mineStack(s);
                        }
                }
        
        
        
    	}
                this.SetPower(this.GetPower() - 1);
                this.getStackInSlot(ToolSlot).attemptDamageItem(1, this.worldObj.rand);
                
                if (!worldObj.isRemote)
                    worldObj.playAuxSFX(2001, x, y, z, Block.getIdFromBlock(worldObj.getBlock(x, y, z)) + (worldObj.getBlockMetadata(x, y, z) << 12));
       
    	
                this.worldObj.setBlock(x, y, z, Blocks.air);
                
                Time = 0;
    	
    	}
    }
    	
    }
    	
    

	





    public void receiveButtonEvent(byte buttonId) {
	
    	
    	switch(buttonId){
    	
    		
    	case 1:
    		if(LastY > 0)
    			LastY--;
    		
    		
    		CanMine = true;
    		Ready = false;
    		break;
    		
    	case 2:
    		if(LastY + 1 < yCoord)
    		LastY += 1;
    		
    		CanMine = true;
    		Ready = false;
    		break;
    		
    	case 3:
    		if(Ready)
    			Ready = false;
    		else
    			Ready = true;
    		break;
    	
    	case 4:
    		LastY = this.yCoord - 1;
    		MinedY = 0;
    		
    		CanMine = true;
    		Ready = false;
    		break;
    		
    //Size +
    	case 5:
    		if(Size + 2 > 11)
    			Size = 11;
    		else
    			Size = Size + 2;
    		break;
    		
    		// Size -
    		
    	case 6:
    		if(Size - 2 < 1)
    			Size = 1;
    		else
    			Size = Size - 2;
    		
    		break;
    		
    		
    	}
    	
    	

    	
    }
    

    @Override
    public Packet getDescriptionPacket() {

        ItemStack itemStack = getStackInSlot(0);

        if (itemStack != null && itemStack.stackSize > 0)
            return Main.NETWORK_MANAGER.populatePacket(new PacketTileWithItemUpdate(xCoord, yCoord, zCoord, orientation, state, customName, itemStack.getItem().getIdFromItem(itemStack.getItem()), itemStack.getItemDamage(), itemStack.stackSize, ItemHelper.getColor(itemStack)));
        else
            return super.getDescriptionPacket();
    }
	
    private void mineStack(ItemStack stack) {
    	
    	
        // First, try to add to a nearby chest
        stack.stackSize -= Utils.addToRandomInventoryAround(worldObj, xCoord, yCoord, zCoord, stack);


        // Lastly, throw the object away
        if (stack.stackSize > 0) {
                float f = worldObj.rand.nextFloat() * 0.8F + 0.1F;
                float f1 = worldObj.rand.nextFloat() * 0.8F + 0.1F;
                float f2 = worldObj.rand.nextFloat() * 0.8F + 0.1F;

                EntityItem entityitem = new EntityItem(worldObj, xCoord + f, yCoord + f1 + 0.5F, zCoord + f2, stack);

                entityitem.lifespan =  1200;
                entityitem.delayBeforeCanPickup = 10;

                float f3 = 0.05F;
                entityitem.motionX = (float) worldObj.rand.nextGaussian() * f3;
                entityitem.motionY = (float) worldObj.rand.nextGaussian() * f3 + 1.0F;
                entityitem.motionZ = (float) worldObj.rand.nextGaussian() * f3;
                worldObj.spawnEntityInWorld(entityitem);
        }
}

	@Override
	public boolean CanAcceptPower() {
		return true;
	}

	@Override
	public int GetMaxPower() {
		return 100;
	}
    
	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {

		return false;
		
		
	}


   
}
