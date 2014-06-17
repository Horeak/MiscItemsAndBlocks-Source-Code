package com.miscitems.MiscItemsAndBlocks.Items;

import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityPaintBlock;
import com.miscitems.MiscItemsAndBlocks.Utils.References.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;

public class ModItemPaintBrush extends Item{

	IIcon[] icons = new IIcon[6];

			
	
	int Change = 1;
	
	public ModItemPaintBrush() {
		super();

		this.setHasSubtypes(true);
		this.setMaxStackSize(1);
	}
	
	   @SideOnly(Side.CLIENT)
	   public void registerIcons(IIconRegister reg)
	   {
		   this.icons[0] = reg.registerIcon(Reference.Mod_Id + ":" + "PaintBrush");
		   this.icons[1] = reg.registerIcon(Reference.Mod_Id + ":" + "PaintBrushRed");
		   this.icons[2] = reg.registerIcon(Reference.Mod_Id + ":" + "PaintBrushGreen");
		   this.icons[3] = reg.registerIcon(Reference.Mod_Id + ":" + "PaintBrushBlue");
		   this.icons[4] = reg.registerIcon(Reference.Mod_Id + ":" + "PaintBrushCopy");
		   this.icons[5] = reg.registerIcon(Reference.Mod_Id + ":" + "PaintBrushEdit");
		   
	   }

	    public String getUnlocalizedName(ItemStack stack)
    {
        int meta = stack.getItemDamage();

        if(meta == 0)return "item.paintbrush.1";
        if(meta == 1)return "item.paintbrush.2";
        if(meta == 2)return "item.paintbrush.3";
        if(meta == 3)return "item.paintbrush.4";
        if(meta == 4)return "item.paintbrush.5";
        if(meta == 5)return "item.paintbrush.6";



        return null;
    }
	    
	    public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List list)
	    {
	        super.getSubItems(par1, par2CreativeTabs, list);
	        
	        list.add(new ItemStack(par1, 1, 1));
	        list.add(new ItemStack(par1, 1, 2));
	        list.add(new ItemStack(par1, 1, 3));
	        list.add(new ItemStack(par1, 1, 4));
	        list.add(new ItemStack(par1, 1, 5));
	        
	    }
	    
	    public IIcon getIconFromDamage(int meta)
	    {

	    	return icons[meta];

	    }
	    
	    int Max = TileEntityPaintBlock.Max;
	    
	    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10)
	    {
	    	
	    	
	    
	    	
	    	
	    	
	    		
	    		TileEntity tile_e = world.getTileEntity(x, y, z);
	    		
	    		if(tile_e instanceof TileEntityPaintBlock){
	    			TileEntityPaintBlock tile = (TileEntityPaintBlock)tile_e;

	    	    	UpdateBlock(world, x, y, z);
	    			
	    			int Meta = stack.getItemDamage();
	    			
    				
	    			
	    			if(player.isSneaking()){


	    				
	    				
	    			if(Meta == 1){
	    				tile.SetRed(tile.GetRed() - Change);
		    	    	UpdateBlock(world, x, y, z);
	    				return true;
	    			}else if (Meta == 2){
	    				tile.SetGreen(tile.GetGreen() - Change);
		    	    	UpdateBlock(world, x, y, z);
	    				return true;
	    			}else if (Meta == 3){
	    				tile.SetBlue(tile.GetBlue() - Change);
		    	    	UpdateBlock(world, x, y, z);
	    				return true;
	    			}else if (Meta == 0){
	    				tile.SetRed(tile.GetRed() - Change);
	    				tile.SetGreen(tile.GetGreen() - Change);
	    				tile.SetBlue(tile.GetBlue() - Change);
		    	    	UpdateBlock(world, x, y, z);
	    				return true;
	    			}else if (Meta == 4){
	    				
	    				if(stack.stackTagCompound == null){
	    					stack.setTagCompound(new NBTTagCompound());
	    					
	    					stack.stackTagCompound.setInteger("Red", tile.GetRed());
	    					stack.stackTagCompound.setInteger("Green", tile.GetGreen());
	    					stack.stackTagCompound.setInteger("Blue", tile.GetBlue());

	    				}else{
	    					stack.stackTagCompound.setInteger("Red", tile.GetRed());
	    					stack.stackTagCompound.setInteger("Green", tile.GetGreen());
	    					stack.stackTagCompound.setInteger("Blue", tile.GetBlue());
	    				}
    					return true;

	    			}
	    			
	    			
	    			
	    			}else{
	    				
	    				if(Meta == 1 && tile.GetRed() >= Max)
	    					return false;
	    				
	    				if(Meta == 2 && tile.GetGreen() >= Max)
	    					return false;
	    				
	    				if(Meta == 3 && tile.GetBlue() >= Max)
	    					return false;
	    				
		    			if(Meta == 1){
			    			tile.SetRed(tile.GetRed() + Change);
			    	    	UpdateBlock(world, x, y, z);
		    				return true;
		    				
		    			}else if (Meta == 2){
			    			tile.SetGreen(tile.GetGreen() + Change);
			    	    	UpdateBlock(world, x, y, z);
		    				return true;
		    				
		    			}else if (Meta == 3){
		    				tile.SetBlue(tile.GetBlue() + Change);
			    	    	UpdateBlock(world, x, y, z);
		    				return true;
		    			}else if (Meta == 4 || Meta == 5){
		    				
			    	    	UpdateBlock(world, x, y, z);
		    				

		    				if(stack.stackTagCompound == null){
		    					stack.setTagCompound(new NBTTagCompound());
		    					
		    					
		    					
		    					
		    					tile.SetRed(stack.stackTagCompound.getInteger("Red"));
		    					tile.SetGreen(stack.stackTagCompound.getInteger("Green"));
		    					tile.SetBlue(stack.stackTagCompound.getInteger("Blue"));
		    					
		    				}else{
		    					
		    					tile.SetRed(stack.stackTagCompound.getInteger("Red"));
		    					tile.SetGreen(stack.stackTagCompound.getInteger("Green"));
		    					tile.SetBlue(stack.stackTagCompound.getInteger("Blue"));
		    					
		    				}
			    	    	UpdateBlock(world, x, y, z);
	    					return true;
	    			}
	    			
	    			
	    			
	    			
	    		
	    			}
	    		
	    	}
	    	
	    	
	    	
	    	
	    	
	        return false;
	    }
	    
	    public void UpdateBlock(World world, int x, int y, int z){
	    	world.markBlockForUpdate(x, y, z);
	    	world.setBlockMetadataWithNotify(x, y, z, 0, 2);

	    	

	    	
	    }
	    
	    @Override
	    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
	    {
	    	if(itemstack.getItemDamage() == 4 || itemstack.getItemDamage() == 5){
	    		
	    		
	    		if(itemstack.stackTagCompound == null){
	    			itemstack.setTagCompound(new NBTTagCompound());
	    			  list.add(StatCollector.translateToLocal("words.red") + ": " + itemstack.stackTagCompound.getInteger("Red"));
	    			  list.add(StatCollector.translateToLocal("words.green") + ": " + itemstack.stackTagCompound.getInteger("Green"));
	    			  list.add(StatCollector.translateToLocal("words.blue") + ": " + itemstack.stackTagCompound.getInteger("Blue"));
	    			
	    			
	    		}else{
	    			  list.add(StatCollector.translateToLocal("words.red") + ": " + itemstack.stackTagCompound.getInteger("Red"));
	    			  list.add(StatCollector.translateToLocal("words.green") + ": " + itemstack.stackTagCompound.getInteger("Green"));
	    			  list.add(StatCollector.translateToLocal("words.blue") + ": " + itemstack.stackTagCompound.getInteger("Blue"));
	    		}

	    			  

	    			  
	    		
	    		
	    		
	    	}
	    	
	    	
	    }
	    
	    
	    public void ReciveColors(int Red, int Green, int Blue, ItemStack stack){
	    	
	    	
	    	if(Red < 0)
	    		Red = 0;
	    	
	    	if(Green < 0)
	    		Green = 0;
	    	
	    	if(Blue < 0)
	    		Blue = 0;
	    	
			if(stack.stackTagCompound == null){
				stack.setTagCompound(new NBTTagCompound());
				
				stack.stackTagCompound.setInteger("Red", Red);
				stack.stackTagCompound.setInteger("Green", Green);
				stack.stackTagCompound.setInteger("Blue", Blue);

			}else{
				stack.stackTagCompound.setInteger("Red", Red);
				stack.stackTagCompound.setInteger("Green", Green);
				stack.stackTagCompound.setInteger("Blue", Blue);
			}

		}
	    

	    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player){
	    	
	    	if(player.isSneaking())
	    	if(item.getItemDamage() == 5){
				player.openGui(Main.instance, 1, world, 0, 0, 0);
	    	}
	    	
	    	return item;
	    }
	    

}
