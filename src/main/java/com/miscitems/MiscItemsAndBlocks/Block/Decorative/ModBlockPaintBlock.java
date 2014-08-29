package com.miscitems.MiscItemsAndBlocks.Block.Decorative;

import MiscUtils.Block.ModBlockContainer;
import com.miscitems.MiscItemsAndBlocks.Main.ModBlocks;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Decorative.TileEntityPaintBlock;
import com.miscitems.MiscItemsAndBlocks.Utils.References.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class ModBlockPaintBlock extends ModBlockContainer{


    public ModBlockPaintBlock() {
		super(Material.cloth);
		this.setStepSound(soundTypeCloth);
		this.setHardness(1);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntityPaintBlock();
	}
	
	   @SideOnly(Side.CLIENT)
	   public void registerBlockIcons(IIconRegister par1IconRegister)
	   {
		   this.blockIcon = par1IconRegister.registerIcon(Reference.Mod_Id + ":PaintBlock");
		   
	   }
	   

	   
	   
	    public int colorMultiplier(IBlockAccess block, int x, int y, int z)
	    {
	    	//(Red)(Red)(Green)(Green)(Blue)(Blue)
	    	//0xrrggbb
	    	// Defualt : 0xFFFFFF
	    	
	    	TileEntity tile_e = block.getTileEntity(x, y, z);
	    	
	    	if(tile_e instanceof TileEntityPaintBlock){
	    		TileEntityPaintBlock tile = (TileEntityPaintBlock)tile_e;
	    		
	    		if(tile.GetRed() == 0 && tile.GetBlue() == 0 && tile.GetGreen() == 0){

	    		}else{
	    			return tile.GetHex();
	    		}
	    	}
	    	return 0xFFFFFF;
	    	
	    }





    @Override
    public void breakBlock(World World, int x, int y, int z, Block id, int meta) {

        TileEntity tile_e = World.getTileEntity(x, y, z);

        if (tile_e != null && tile_e instanceof TileEntityPaintBlock) {
            TileEntityPaintBlock tile = (TileEntityPaintBlock) tile_e;

            ItemStack stack = new ItemStack(ModBlocks.PaintBlock);

            stack.setTagCompound(new NBTTagCompound());

            if(tile.Red > 0 || tile.Green > 0 || tile.Blue > 0) {
                stack.stackTagCompound.setInteger("Red", tile.Red);
                stack.stackTagCompound.setInteger("Green", tile.Green);
                stack.stackTagCompound.setInteger("Blue", tile.Blue);
            }else {
                stack.setTagCompound(null);
            }



            if (stack != null) {
                float spawnX = x + World.rand.nextFloat();
                float spawnY = y + World.rand.nextFloat();
                float spawnZ = z + World.rand.nextFloat();


                EntityItem droppedItem = new EntityItem(World, spawnX, spawnY, spawnZ, stack);

                float mult = 0.05F;

                droppedItem.motionX = (-0.5 + World.rand.nextFloat()) * mult;
                droppedItem.motionY = (4 + World.rand.nextFloat()) * mult;
                droppedItem.motionZ = (-0.5 + World.rand.nextFloat()) * mult;


                World.spawnEntityInWorld(droppedItem);
                super.breakBlock(World, x, y, z, id, meta);
            }


        }


    }

}
