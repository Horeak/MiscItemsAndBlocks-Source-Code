package com.miscitems.MiscItemsAndBlocks.Block;

import com.miscitems.MiscItemsAndBlocks.Lib.ChatMessageHandler;
import com.miscitems.MiscItemsAndBlocks.Lib.Refrence;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityGhostBlock;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class ModBlockGhostBlock extends BlockContainer{

	protected ModBlockGhostBlock() {
		super(Material.glass);
		this.setStepSound(soundTypeCloth);
	
	}
	

	
	IIcon defaultTexture;
	
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityGhostBlock();
	}

    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase ent, ItemStack stack) {


        if(ent instanceof EntityPlayer){
            EntityPlayer player = (EntityPlayer)ent;
            if(world.getTileEntity(z, y, z) instanceof TileEntityGhostBlock){
                TileEntityGhostBlock tile = (TileEntityGhostBlock)world.getTileEntity(x, y, z);

                System.out.println(3);
                tile.Placer = player.getDisplayName();

            }else{
                world.setTileEntity(x, y, z, this.createNewTileEntity(world, stack.getItemDamage()));
                TileEntityGhostBlock tile = (TileEntityGhostBlock)world.getTileEntity(x, y, z);
                tile.Placer = player.getDisplayName();

            }

        }


    }


    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
    	
    	if(world.getTileEntity(x, y, z) instanceof TileEntityGhostBlock){
    		TileEntityGhostBlock tile = (TileEntityGhostBlock)world.getTileEntity(x, y, z);

    		if(player.getHeldItem() != null && !player.isSneaking()){
    			if(player.getHeldItem().getItem() instanceof ItemBlock){
    				Block block = Block.getBlockById(Item.getIdFromItem(player.getHeldItem().getItem()));
    				if(!block.isOpaqueCube())
                        return true;


    				if(block != null && block != Blocks.air){
                        if(tile.Locked){
                            if(tile.Placer == "" || player.getDisplayName().equalsIgnoreCase(tile.Placer)){

                                tile.Id = Block.getIdFromBlock(block);
                                tile.Meta = player.getHeldItem().getItemDamage();


                                world.setBlockMetadataWithNotify(x, y, z, 0, 3);
                                world.markBlockForUpdate(x, y, z);
                                return true;
                            }
                        }else{

    					tile.Id = Block.getIdFromBlock(block);
    					tile.Meta = player.getHeldItem().getItemDamage();
    					

                        world.setBlockMetadataWithNotify(x, y, z, 0, 3);
    	    			world.markBlockForUpdate(x, y, z);
    					return true;
                        }
    				}
    				
    			}
    		}else{
                if(!world.isRemote)
                if(player.isSneaking()){
                    if(tile.Placer == "" || player.getDisplayName().equalsIgnoreCase(tile.Placer) || player.capabilities.isCreativeMode){


                    tile.Locked ^= true;


                    ChatMessageHandler.sendChatToPlayer(player, "Ghost block " + (tile.Locked ? "is now Locked" : "is no longer locked"));
                    }else{
                        ChatMessageHandler.sendChatToPlayer(player, "You cant change " + tile.Placer + "`s Ghost block");
                    }




                }else{

                    if(tile.Placer == "" || player.getDisplayName().equalsIgnoreCase(tile.Placer) || player.capabilities.isCreativeMode){

                        tile.Id = 0;
                        tile.Meta = 0;


                        world.setBlockMetadataWithNotify(x, y, z, 0, 3);
                        world.markBlockForUpdate(x, y, z);
                        return true;
                    }
                }else{

                    tile.Id = 0;
                    tile.Meta = 0;


                    world.setBlockMetadataWithNotify(x, y, z, 0, 3);
                    world.markBlockForUpdate(x, y, z);
                    return true;
                }

                }
    		}
    		

    	
    	
        return false;
    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
    {
        return null;
    }
    public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side)
    {
    	if(world.getTileEntity(x, y, z) instanceof TileEntityGhostBlock){
    		TileEntityGhostBlock tile = (TileEntityGhostBlock)world.getTileEntity(x, y, z);


    		if(tile.Id != 0){
                Block block = Block.getBlockById(tile.Id);
    			
    			return block.getIcon(side, tile.Meta);
    		}
    		
    	}
    	
    	return defaultTexture;
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
    	
    	return defaultTexture;
    }
    
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
    	defaultTexture = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "GhostBlock");
    	
    }
    
    public int getRenderBlockPass()
    {
        return 1;
    }
    

   public boolean renderAsNormalBlock()
   {
       return false;
   }
   
	
   public boolean isOpaqueCube()
   {
       return false;
   }
   
   
    
}
