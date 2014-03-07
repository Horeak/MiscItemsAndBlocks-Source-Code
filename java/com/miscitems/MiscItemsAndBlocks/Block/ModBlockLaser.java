package com.miscitems.MiscItemsAndBlocks.Block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.miscitems.MiscItemsAndBlocks.Laser.LaserUtil;
import com.miscitems.MiscItemsAndBlocks.Lib.Refrence;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityLaser;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModBlockLaser extends BlockContainer {

public IIcon frontIconoff;
public IIcon sideIconoff;

public IIcon frontIconon;
public IIcon sideIconon;

public ModBlockLaser() {
super(Material.rock);
this.setHardness(1.0F);
this.setCreativeTab(Main.CreativeTab);
}

@Override
public TileEntity createNewTileEntity(World world, int meta) {
return new TileEntityLaser();
}

@Override
@SideOnly(Side.CLIENT)
public void registerBlockIcons(IIconRegister iconRegister) {
this.frontIconoff = iconRegister.registerIcon(Refrence.Mod_Id + ":LaserFront_off");
this.sideIconoff = iconRegister.registerIcon(Refrence.Mod_Id + ":LaserSide_off");

this.frontIconon = iconRegister.registerIcon(Refrence.Mod_Id + ":LaserFront_on");
this.sideIconon = iconRegister.registerIcon(Refrence.Mod_Id + ":LaserSide_on");
}

@Override
public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side) {
int meta = LaserUtil.getOrientation(world.getBlockMetadata(x, y, z));

boolean powered = world.getTileEntity(x, y, z).getWorldObj().isBlockIndirectlyGettingPowered(x, y, z);

if (meta > 5)
return powered ? frontIconon : frontIconoff;
if (side == meta)
return powered ? frontIconon : frontIconoff;
else
	return powered ? sideIconon : sideIconoff;
	
    }

@Override
@SideOnly(Side.CLIENT)
public IIcon getIcon(int side, int meta) {
int rotation = 3;

if (rotation > 5)
return this.frontIconoff;
if (side == rotation)
return this.frontIconoff;
else
return this.sideIconoff;
}

@Override
public void onBlockPlacedBy(World par1World, int x, int y, int z, EntityLivingBase par5EntityLiving, ItemStack par6ItemStack) {
int rotation = BlockPistonBase.determineOrientation(par1World, x, y, z, par5EntityLiving);
par1World.setBlockMetadataWithNotify(x, y, z, rotation, 2);
}


public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
{
    if (par1World.isRemote)
    {
    	
        return true;
    }
    else
    {
    	
    	
    	
    	FMLNetworkHandler.openGui(par5EntityPlayer, Main.instance, 0, par1World, par2, par3, par4);
        return true;
    }
}

@Override
public void breakBlock(World World, int x, int y, int z, Block block, int meta)
{
	TileEntity tile = World.getTileEntity(x, y, z);
	
	if(tile != null && tile instanceof IInventory){
		IInventory inv = (IInventory)tile;
		
		for(int i = 0; i < inv.getSizeInventory(); i++){
			ItemStack stack = inv.getStackInSlotOnClosing(i);
			
			if(stack != null){
				float spawnX = x + World.rand.nextFloat();
				float spawnY = y + World.rand.nextFloat();
				float spawnZ = z + World.rand.nextFloat();
				
				
				EntityItem droppedItem = new EntityItem(World, spawnX, spawnY, spawnZ, stack);
				
				float mult = 0.05F;
				
				droppedItem.motionX = (-0.5 + World.rand.nextFloat()) * mult;
				droppedItem.motionY = (4 + World.rand.nextFloat()) * mult;
				droppedItem.motionZ = (-0.5 + World.rand.nextFloat()) * mult;
				
				World.spawnEntityInWorld(droppedItem);

			}
			
		}
	}
	super.breakBlock(World, x, y, z, block, meta);
}
}