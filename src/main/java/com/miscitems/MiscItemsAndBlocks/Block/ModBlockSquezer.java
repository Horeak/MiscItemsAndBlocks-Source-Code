package com.miscitems.MiscItemsAndBlocks.Block;

import com.miscitems.MiscItemsAndBlocks.Utils.Refrence;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntitySquezer;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ModBlockSquezer extends BlockContainer{

	public ModBlockSquezer() {
		super(Material.rock);
		this.setHardness(3);
	}
	
	IIcon IconTop;
	IIcon IconSide;
	IIcon IconBottom;
	IIcon IconFront;
	


	
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
    	
        this.IconTop = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "SquezerTop");
        this.IconSide = par1IconRegister.registerIcon("furnace_side");
        this.IconFront = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "SquezerFront");
        this.IconBottom = par1IconRegister.registerIcon("furnace_top");

        
        
        this.blockIcon = IconFront;
        
    }
    
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		boolean isActive = ((metadata >> 3) == 1);
		int facing = (metadata & MASK_DIR);
		
		return (side == getSideFromFacing(facing) ? IconFront : (side == 1  ? this.IconTop : side == 0 ? this.IconBottom : this.IconSide));
	}
    

    
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemStack)
	{
		int metadata = 0;
		int facing = META_DIR_WEST;
		
		int dir = MathHelper.floor_double((double)(entity.rotationYaw * 4f / 360f) + 0.5) & 3;
		if(dir == 0)
			facing = META_DIR_NORTH;
		if(dir == 1)
			facing = META_DIR_EAST;
		if(dir == 2)
			facing = META_DIR_SOUTH;
		if(dir == 3)
			facing = META_DIR_WEST;
		
		metadata |= facing;
		world.setBlockMetadataWithNotify(x, y, z, metadata, 2);
	}


	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntitySquezer();
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
    public void breakBlock(World World, int x, int y, int z, Block id, int meta)
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
    				super.breakBlock(World, x, y, z, id, meta);
					
				}
				
			}
			
		}
    
    }
    
	public static final int META_ISACTIVE = 0x00000008;
	public static final int MASK_DIR = 0x00000007;
	public static final int META_DIR_NORTH = 0x00000001;
	public static final int META_DIR_SOUTH = 0x00000002;
	public static final int META_DIR_EAST = 0x00000003;
	public static final int META_DIR_WEST = 0x00000000;
    
    
	private static int getSideFromFacing(int facing)
	{
		switch(facing)
		{
		case META_DIR_WEST:
			return 4;
			
		case META_DIR_EAST:
			return 5;
			
		case META_DIR_NORTH:
			return 2;
			
		case META_DIR_SOUTH:
			return 3;
			
		default:
			return 4;
		}
	}
    
}
    


