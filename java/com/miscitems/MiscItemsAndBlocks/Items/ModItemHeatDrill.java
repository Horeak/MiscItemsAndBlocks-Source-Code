package com.miscitems.MiscItemsAndBlocks.Items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import com.miscitems.MiscItemsAndBlocks.Block.ModBlocks;
import com.miscitems.MiscItemsAndBlocks.Lib.Refrence;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModItemHeatDrill extends ModItemPowerTool{

	//private static Block[] MineableBlocks = new Block[]{Block.stone, Block.dirt, Block.gravel, Block.sand, Block.oreCoal, Block.oreDiamond, Block.oreEmerald, Block.oreGold, Block.oreIron, Block.oreLapis, Block.oreNetherQuartz, Block.oreRedstone, Block.oreRedstoneGlowing, Block.grass, ModBlocks.SilverOre, Block.obsidian, Block.cobblestone, Block.stoneDoubleSlab, Block.stoneSingleSlab, Block.stone, Block.sandStone, Block.cobblestoneMossy, Block.oreIron, Block.oreCoal, Block.blockGold, Block.oreGold, Block.oreDiamond, Block.blockDiamond, Block.ice, Block.netherrack, Block.oreLapis, Block.blockLapis, Block.oreRedstone, Block.oreRedstoneGlowing, Block.rail, Block.railDetector, Block.railPowered, Block.planks, Block.bookShelf, Block.wood, Block.chest, Block.stoneDoubleSlab, Block.stoneSingleSlab, Block.pumpkin, Block.pumpkinLantern, Block.grass, Block.dirt, Block.sand, Block.gravel, Block.snow, Block.blockSnow, Block.blockClay, Block.tilledField, Block.slowSand, Block.mycelium,};
	
	
	public ModItemHeatDrill() {
		super(0.1F, ToolMaterial.EMERALD, null);
		
		this.efficiencyOnProperMaterial = 8;
		this.setMaxDamage(930);
	}
	
	 public boolean canHarvestBlock(Block par1Block)
	    {
	        return par1Block == Blocks.obsidian ? this.toolMaterial.getHarvestLevel() == 3 : (par1Block != Blocks.diamond_block && par1Block != Blocks.diamond_ore ? (par1Block != Blocks.emerald_ore && par1Block != Blocks.emerald_block ? (par1Block != Blocks.gold_block && par1Block != Blocks.gold_ore ? (par1Block != Blocks.iron_ore ? (par1Block != Blocks.lapis_block && par1Block != Blocks.lapis_ore ? (par1Block != Blocks.redstone_ore ? (par1Block.getMaterial() == Material.rock ? true : (par1Block.getMaterial() == Material.iron ? true : par1Block.getMaterial() == Material.anvil)) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 2);
	    }

		
	    @Override
	    public float getDigSpeed(ItemStack par1ItemStack, Block par2Blocks, int metadata)
	    {
	    	if(par1ItemStack.getItemDamage() == par1ItemStack.getMaxDamage())
	    		return 0;
	    	
	        return par2Blocks != null && (par2Blocks.getMaterial() == Material.iron || par2Blocks.getMaterial() == Material.anvil || par2Blocks.getMaterial() == Material.rock || par2Blocks.getMaterial() == Material.wood || par2Blocks.getMaterial() == Material.plants || par2Blocks.getMaterial() == Material.vine) ? this.efficiencyOnProperMaterial : super.getDigSpeed(par1ItemStack, par2Blocks, metadata);
	    }
	    
	    public boolean onBlockDestroyed(ItemStack p_150894_1_, World p_150894_2_, Block p_150894_3_, int p_150894_4_, int p_150894_5_, int p_150894_6_, EntityLivingBase p_150894_7_)
	    {
	        if ((double)p_150894_3_.getBlockHardness(p_150894_2_, p_150894_4_, p_150894_5_, p_150894_6_) != 0.0D)
	        {
	        	p_150894_1_.damageItem(1, p_150894_7_);
	        }

	        return true;
	    }
	    
    
	public boolean onBlockStartBreak(ItemStack itemstack, int x, int y, int z, EntityPlayer player)
    {
		
		if(!player.worldObj.isRemote){
    	int Luck = EnchantmentHelper.getEnchantmentLevel(35, player.inventory.getCurrentItem());
		
		
		Block block = player.worldObj.getBlock(x, y, z);
		
		if(block != null){
			
	        List<ItemStack> stacks = block.getDrops(player.worldObj, x, y, z, player.worldObj.getBlockMetadata(x, y, z), Luck);

	        if (stacks != null) {
	                for (ItemStack s : stacks) {
	                        if (s != null) {

	                        	Smelt(s, x, y, z, player.worldObj, player);
	                        
	                        }
	                }
	       }
		}
		


		player.worldObj.setBlock(x, y, z, Blocks.air);
		this.onBlockDestroyed(itemstack,  player.worldObj, block, x, y, z, player);
		}
		return true;
    }
    
    
	   @SideOnly(Side.CLIENT)
	   public void registerIcons(IIconRegister par1IconRegister)
	   {
		   this.itemIcon = par1IconRegister.registerIcon(Refrence.Mod_Id + ":HeatDrill");
		   
	   }
	   
	   @Override
	    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
	    {
	    	int i = itemstack.getMaxDamage() - itemstack.getItemDamage();
	    	

	            list.add(StatCollector.translateToLocal("items.desc.string.powerleft") + ": " + i);
	            if(itemstack.getItemDamage() == itemstack.getMaxDamage())
	            	list.add(EnumChatFormatting.RED + StatCollector.translateToLocal("items.desc.string.outofpowerrecharge"));

	            
	    }
	   
	public void Smelt(ItemStack stack, int x, int y, int z, World world, EntityPlayer player){

			ItemStack result = FurnaceRecipes.smelting().getSmeltingResult(stack);
			if(result != null){
				ItemStack smeltingStack;
				if(result.stackSize > 1){
					   smeltingStack = new ItemStack(result.getItem(), result.stackSize, result.getItemDamage());
				}else{
			   smeltingStack = new ItemStack(result.getItem(), 1, result.getItemDamage());
				}
				
				EntityItem item = new EntityItem(world, x, y, z, smeltingStack);
				world.spawnEntityInWorld(item);
			}else{

				EntityItem item = new EntityItem(world, x, y, z, stack);
				world.spawnEntityInWorld(item);

				
			

			}
	   }
	   
	    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10)
	    {
	    	int Luck = EnchantmentHelper.getEnchantmentLevel(35, player.inventory.getCurrentItem());
	    	
	    	
  	        final Block block = world.getBlock(x, y, z);
  	        final int meta = world.getBlockMetadata(x, y, z);
  	      float blockHardness = block.getBlockHardness(world, x, y, z);
	    	
	    	if(block != null){
		        List<ItemStack> stacks = block.getDrops(player.worldObj, x, y, z, player.worldObj.getBlockMetadata(x, y, z), Luck);
		        
		        ItemStack stack1 = new ItemStack(block);
    			ItemStack result1 = FurnaceRecipes.smelting().getSmeltingResult(stack1);

		        if (stacks != null) {
		                for (ItemStack s : stacks) {
		                        if (s != null) {
		                        	
	                    			ItemStack result = FurnaceRecipes.smelting().getSmeltingResult(s);
	                    			if(result != null){

		                        	
	                    				
	                    				//TODO Remove .itemID before 1.7
		                        	if(result.getItem() instanceof ItemBlock){


		                        		ItemBlock t = (ItemBlock)result.getItem();

		                    				
		                    				world.setBlock(x, y, z, block.getBlockById(t.getIdFromItem(t)));
		                    				player.inventory.getCurrentItem().damageItem(1, player);
		                    				
		                    			}
		                        
		                        
	                    			}else{
	                    				if(result1 != null){
	    		                        	if(result1.getItem() instanceof ItemBlock){

	    		                        		ItemBlock t = (ItemBlock)result.getItem();
			                    				
			                    				world.setBlock(x, y, z, block.getBlockById(t.getIdFromItem(t)));
			                    				player.inventory.getCurrentItem().damageItem(1, player);
			                    				
			                    			}
	                    				}
	
		
		    	}
		    		}

		                        
            
		                }
            
	    	}
	            return true;
	    	}
	    	
	    	
	        return true;
	    }


		@Override
		public int MaxPower(ItemStack stack) {
			return 930;
		}


		@Override
		public int ChargeAmount(ItemStack stack) {
			return 1;
		}
	    
	    
		@Override
		public boolean CanBackpackRecharge(ItemStack stack) {
			return true;
		}

}
