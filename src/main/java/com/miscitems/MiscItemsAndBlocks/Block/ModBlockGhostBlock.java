package com.miscitems.MiscItemsAndBlocks.Block;

import MiscUtils.Block.ModBlockContainer;
import MiscUtils.Utils.Handlers.ChatMessageHandler;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityGhostBlock;
import com.miscitems.MiscItemsAndBlocks.Utils.References.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
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

import java.awt.*;

public class ModBlockGhostBlock extends ModBlockContainer {

    public ModBlockGhostBlock() {
		super(Material.glass);
		this.setStepSound(soundTypeCloth);
	
	}



    public int colorMultiplier(IBlockAccess block, int x, int y, int z)
    {
        if(block.getTileEntity(x,y,z) instanceof  TileEntityGhostBlock){
            TileEntityGhostBlock tile = (TileEntityGhostBlock)block.getTileEntity(x,y,z);
            if(tile.Id != 0){
                if(Block.getBlockById(tile.Id) != null && !(Block.getBlockById(tile.Id) instanceof ModBlockGhostBlock))
                return Block.getBlockById(tile.Id).colorMultiplier(block, x,y,z);
            }

        }


        return new Color(255,255,255).getRGB();

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


                    if(block instanceof ModBlockGhostBlock)
                        return false;


    				if(block != null && block != Blocks.air){


                        if(tile.Locked){
                            if(tile.Placer == "" || player.getDisplayName().equalsIgnoreCase(tile.Placer)){

                                tile.Id = Block.getIdFromBlock(block);
                                tile.Meta = player.getHeldItem().getItemDamage();


                                world.setBlockMetadataWithNotify(x, y, z, player.getHeldItem().getItemDamage(), 3);
                                world.setBlockMetadataWithNotify(x, y, z, player.getHeldItem().getItemDamage(), 2);
                                world.markBlockForUpdate(x, y, z);
                                return true;
                            }
                        }else{

    					tile.Id = Block.getIdFromBlock(block);
    					tile.Meta = player.getHeldItem().getItemDamage();

    					

                        world.setBlockMetadataWithNotify(x, y, z, player.getHeldItem().getItemDamage(), 3);
                        world.setBlockMetadataWithNotify(x, y, z, player.getHeldItem().getItemDamage(), 2);
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

                    if(!player.isSneaking())
                    if(tile.Placer == "" || player.getDisplayName().equalsIgnoreCase(tile.Placer) || player.capabilities.isCreativeMode){

                        tile.Id = 0;
                        tile.Meta = 0;


                        world.setBlockMetadataWithNotify(x, y, z, 0, 3);
                        world.markBlockForUpdate(x, y, z);
                        return true;
                    }
                }else{

                    if(!player.isSneaking()) {
                        tile.Id = 0;
                        tile.Meta = 0;


                        world.setBlockMetadataWithNotify(x, y, z, 0, 3);
                        world.markBlockForUpdate(x, y, z);

                        return true;
                    }
                }

                }
    		}
    		

    	
    	
        return false;
    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
    {
        if(world.isBlockIndirectlyGettingPowered(x,y,z))
            return super.getCollisionBoundingBoxFromPool(world,x,y,z);

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
    	defaultTexture = par1IconRegister.registerIcon(Reference.Mod_Id + ":" + "GhostBlock");
    	
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
