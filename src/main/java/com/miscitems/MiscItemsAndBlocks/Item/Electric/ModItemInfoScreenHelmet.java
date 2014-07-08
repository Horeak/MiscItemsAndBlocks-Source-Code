package com.miscitems.MiscItemsAndBlocks.Item.Electric;

import com.miscitems.MiscItemsAndBlocks.Utils.References.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ModItemInfoScreenHelmet extends ModItemElArmor{

	public ModItemInfoScreenHelmet(int RenderIndex, int ArmorType) {
		super(RenderIndex, ArmorType);
	}

	
	   @SideOnly(Side.CLIENT)
	    @Override
	    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	    {
	    	
	    		return Reference.Mod_Id + ":" + "textures/models/armor/InfoScreenHelmet_layer_1.png";

	    		

	    	
	    }
	   
	   
	   
	    @Override
	    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack){
	    	if(CurrentPower(itemStack) > 0 && !player.capabilities.isCreativeMode)
    		if(player.worldObj.rand.nextInt(100) == 1){
			RemovePower(itemStack, 1);
    		}
	    }
	    
	    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	    {
	        int i = EntityLiving.getArmorPosition(par1ItemStack) - 1;
	        ItemStack itemstack1 = par3EntityPlayer.getCurrentArmor(i);

	        if (itemstack1 == null)
	        {
	            par3EntityPlayer.setCurrentItemOrArmor(i + 1, par1ItemStack.copy()); 
	            par1ItemStack.stackSize = 0;
	            
	            par2World.playSoundAtEntity(par3EntityPlayer, "random.click", 1.0F, 0.7F);
	        }

	        return par1ItemStack;
	    }


		@Override
		public double MaxPower(ItemStack stack) {
			return 568;
		}


		@Override
		public double ChargeAmount(ItemStack stack) {
			return 1;
		}
	    
		@Override
		public boolean CanBackpackRecharge(ItemStack stack) {
			return true;
		}

    @Override
    public int getTier(ItemStack itemStack) {
        return 1;
    }
}

