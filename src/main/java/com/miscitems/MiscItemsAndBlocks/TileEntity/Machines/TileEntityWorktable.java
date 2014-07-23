package com.miscitems.MiscItemsAndBlocks.TileEntity.Machines;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants;

import java.util.Random;



public class TileEntityWorktable extends TileEntity implements IInventory,ISidedInventory
{
class LocalInventoryCrafting extends InventoryCrafting
{
public LocalInventoryCrafting() {
super(new Container(){
@Override
public boolean canInteractWith(EntityPlayer var1) {
return false;
}
}, 3, 3);
}
public Container eventHandler;
};

private ItemStack[] inv;
private boolean shouldUpdate = false;
public boolean teInit = false;
public boolean containerInit = false;
public boolean initSlots = false;
private boolean recentSync = true;

public IInventory craftResult;
public IInventory craftSupplyMatrix;
public LocalInventoryCrafting craftMatrix;
private ItemStack result = null;
private ItemStack lastResult;
private int sync = 0;
private int supplyMatrixStart = 9;
private int supplyMatrixSize = 18;

public TileEntityWorktable()
{
craftSupplyMatrix = new InventoryBasic("CraftingSupply", true, 18);
craftResult = new InventoryCraftResult();
inv = new ItemStack[27];
shouldUpdate = true;
craftMatrix = new LocalInventoryCrafting();
}
public ItemStack findRecipe(boolean fromPacket)
{
if(worldObj == null)
return null;
lastResult = result;

ItemStack stack = null;
for(int i = 0; i < craftMatrix.getSizeInventory(); ++i)
{
stack = getStackInSlot(i);
craftMatrix.setInventorySlotContents(i, stack);
}

ItemStack recipe = CraftingManager.getInstance().findMatchingRecipe(craftMatrix, worldObj);
setResult(recipe);

if(!ItemStack.areItemStacksEqual(lastResult, result) && !fromPacket && !worldObj.isRemote){
if(!teInit) recentSync = false;
}

return recipe;
}

@Override
public void updateEntity()
    {
super.updateEntity();
sync++;
if(teInit){
findRecipe(false);
teInit = false;
}
if(sync > 200 && !recentSync){
recentSync = true;
}
if(sync > 6000){
sync = 0;
}
    }

public void markShouldUpdate(){
shouldUpdate = true;
}
public void updateResultSlot(){
craftResult.setInventorySlotContents(0, result);
}

public ItemStack getResult()
{
return (result == null) ? null : result.copy();
}
public void setResult(ItemStack stack)
{	
if(stack != null)
result = stack.copy();
else
result = null;

updateResultSlot();
}

@Override
public int getSizeInventory()
{
return inv.length;
}

@Override
public ItemStack getStackInSlot(int slot)
{
return inv[slot];
}

@Override
public ItemStack decrStackSize(int slot, int amount)
{
ItemStack stack = getStackInSlot(slot);
if(stack != null)
{
if(stack.stackSize <= amount)
{
setInventorySlotContents(slot, null);
} else
{
stack = stack.splitStack(amount);
if(stack.stackSize == 0)
{
setInventorySlotContents(slot, null);
}

OnInvChanged();
}
}
return stack;
}

@Override
public ItemStack getStackInSlotOnClosing(int slot)
{
ItemStack stack = getStackInSlot(slot);
if(stack != null)
{
setInventorySlotContents(slot, null);
}
OnInvChanged();
return stack;
}

@Override
public void setInventorySlotContents(int slot, ItemStack stack)
{
inv[slot] = stack;
if(stack != null && stack.stackSize > getInventoryStackLimit())
{
stack.stackSize = getInventoryStackLimit();
}
if(slot < 9 && !initSlots)
markShouldUpdate();
OnInvChanged();
}

public void emptyCraftingMatrix() {
Random rand = new Random();
for(int i = 0; i < 8; i++){
if(inv[i] != null){
float rx = rand.nextFloat() * 0.8F + 0.1F;
float ry = rand.nextFloat() * 0.8F + 0.1F;
float rz = rand.nextFloat() * 0.8F + 0.1F;
EntityItem ei = new EntityItem(worldObj, xCoord + rx, yCoord + ry, zCoord + rz,
new ItemStack(inv[i].getItem(), inv[i].stackSize, inv[i].getItemDamage()));
if(inv[i].hasTagCompound())
ei.getEntityItem().setTagCompound((NBTTagCompound) inv[i].getTagCompound().copy());
float factor = 0.05f;
ei.motionX = rand.nextGaussian() * factor;
ei.motionY = rand.nextGaussian() * factor + 0.2F;
ei.motionZ = rand.nextGaussian() * factor;
if(!worldObj.isRemote)
worldObj.spawnEntityInWorld(ei);
inv[i].stackSize = 0;
}
}
}

@Override
public String getInventoryName()
{
return "CraftingInv";
}

@Override
public int getInventoryStackLimit()
{
return 64;
}

@Override
public boolean isUseableByPlayer(EntityPlayer player)
{
return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this &&
player.getDistanceSq(xCoord +0.5, yCoord +0.5, zCoord +0.5) < 64;
}

public int[] getRecipeStacksForPacket()
{
ItemStack result;
if(shouldUpdate){
result = findRecipe(true);
}
else{
result = this.result;
}
if(result != null)
{
int[] craftingStacks = new int[27];
int index = 0;
for(int i = 0; i < 9; i++)
{
if(inv[i] != null)
{
craftingStacks[index++] = inv[i].getItem().getIdFromItem(inv[i].getItem());
craftingStacks[index++] = inv[i].stackSize;
craftingStacks[index++] = inv[i].getItemDamage();
} else
{
craftingStacks[index++] = 0;
craftingStacks[index++] = 0;
craftingStacks[index++] = 0;
}
}
return craftingStacks;
} else
return null;
}

public void buildResultFromPacket(int[] stacksData)
{
if(stacksData == null)
{
this.setResult(null);
return;
}
if(stacksData.length != 0 && stacksData[0] > 0)
{
	
	
	Block block = Block.getBlockById(stacksData[0]);
			if(block != null){
				this.setResult(new ItemStack(block, stacksData[1], stacksData[2]));
			}else{
				Item item = Item.getItemById(stacksData[0]);
				if(item != null){
					
					this.setResult(new ItemStack(item, stacksData[1], stacksData[2]));
					
				}else{
					this.setResult(new ItemStack(Blocks.air, stacksData[1], stacksData[2]));
				}
				
			}
	
} else
this.setResult(null);
}


    @Override
    public void writeToNBT(NBTTagCompound compound){
        super.writeToNBT(compound);

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





    }

    @Override
    public void readFromNBT(NBTTagCompound compound){
        super.readFromNBT(compound);


        NBTTagList nbttaglist = compound.getTagList("Items", Constants.NBT.TAG_COMPOUND);
        inv = new ItemStack[getSizeInventory()];
        for (int i = 0; i < nbttaglist.tagCount(); i++)
        {
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            int j = nbttagcompound1.getByte("Slot") & 0xff;
            if (j >= 0 && j < inv.length)
            {
                this.setInventorySlotContents(j, ItemStack.loadItemStackFromNBT(nbttagcompound1));
            }
        }

        if(worldObj == null)
            teInit = true;


    }
@Override
public boolean hasCustomInventoryName() {
return false;
}
public int getSupplyMatrixSize(){
return supplyMatrixSize;
}
public int getSupplyMatrixStart(){
return supplyMatrixStart;
}
@Override
public int[] getAccessibleSlotsFromSide(int side) {
int[] slots = null;
switch(side){
case 0:
slots = new int[9];
for(int i = 0; i < slots.length; i++)
slots[i] = i;
return slots;
default:
slots = new int[18];
for(int i = 0; i < slots.length; i++)
slots[i] = i +9;
return slots;
}
}
@Override
public boolean canInsertItem(int i, ItemStack itemstack, int j) {
return true;
}
@Override
public boolean canExtractItem(int i, ItemStack itemstack, int j) {
return true;
}
@Override
public boolean isItemValidForSlot(int i, ItemStack itemstack) {
return true;
}


@Override
public void openInventory() {
	
}
@Override
public void closeInventory() {
	
}


public void OnInvChanged(){
	if(!containerInit && shouldUpdate){
		findRecipe(false);
		shouldUpdate = false;
		}
	
}
}



