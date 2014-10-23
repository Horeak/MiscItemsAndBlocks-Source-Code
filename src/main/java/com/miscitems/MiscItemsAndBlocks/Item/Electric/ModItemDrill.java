package com.miscitems.MiscItemsAndBlocks.Item.Electric;

import MiscUtils.Handlers.ChatMessageHandler;
import com.google.common.collect.Sets;
import com.miscitems.MiscItemsAndBlocks.Utils.References.Reference;
import cpw.mods.fml.relauncher.ReflectionHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import java.util.List;
import java.util.Set;

public class ModItemDrill extends ModItemPowerTool{

	int MaxCharge = 750;
	
	IIcon Drill;
	IIcon DrillGreen;
	IIcon DrillYellow;
	IIcon DrillOrange;
	IIcon DrillRed;
	
    private static final Set field_150916_c = Sets.newHashSet(new Block[] {Blocks.grass, Blocks.dirt, Blocks.sand, Blocks.gravel, Blocks.snow_layer, Blocks.snow, Blocks.clay, Blocks.farmland, Blocks.soul_sand, Blocks.mycelium});
    
    private static final Set field_150915_c = Sets.newHashSet(new Block[] {Blocks.cobblestone, Blocks.double_stone_slab, Blocks.stone_slab, Blocks.stone, Blocks.sandstone, Blocks.mossy_cobblestone, Blocks.iron_ore, Blocks.iron_block, Blocks.coal_ore, Blocks.gold_block, Blocks.gold_ore, Blocks.diamond_ore, Blocks.diamond_block, Blocks.ice, Blocks.netherrack, Blocks.lapis_ore, Blocks.lapis_block, Blocks.redstone_ore, Blocks.lit_redstone_ore, Blocks.rail, Blocks.detector_rail, Blocks.golden_rail, Blocks.activator_rail});
	
    static Set Mineable = Sets.newHashSet(field_150915_c, field_150916_c);
    
	
	
	public ModItemDrill(ToolMaterial par2) {
		super(0, par2, Mineable);
		this.setMaxStackSize(1);
		this.efficiencyOnProperMaterial = 10;
        ReflectionHelper.setPrivateValue(ItemTool.class, this, "pickaxe", "toolClass");
	}
	
	
	@Override
    public IIcon getIcon(ItemStack stack, int pass)
    {



        double Charge = CurrentPower(stack);

    	if(Charge >= MaxCharge / 4 * 3){
    		return DrillGreen;
    	}
    	
    	if(Charge >= MaxCharge / 4 * 2 && Charge < MaxCharge / 4 * 3){
    		return DrillYellow;
    	}
    	
    	if(Charge > 0 && Charge < MaxCharge / 4 * 2){
    		return DrillOrange;
    	}
    	
    	if(Charge <= 0){
    		return DrillRed;
    	}
    	
    	
    	return Drill;
    	
    }
	
    public boolean canHarvestBlock(Block par1Block)
    {
        return par1Block == Blocks.obsidian ? this.toolMaterial.getHarvestLevel() == 3 : (par1Block != Blocks.diamond_block && par1Block != Blocks.diamond_ore ? (par1Block != Blocks.emerald_ore && par1Block != Blocks.emerald_block ? (par1Block != Blocks.gold_block && par1Block != Blocks.gold_ore ? (par1Block != Blocks.iron_ore ? (par1Block != Blocks.lapis_block && par1Block != Blocks.lapis_ore ? (par1Block != Blocks.redstone_ore ? (par1Block.getMaterial() == Material.rock ? true : (par1Block.getMaterial() == Material.iron ? true : par1Block.getMaterial() == Material.anvil)) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 2);
    }

	
    @Override
    public float getDigSpeed(ItemStack par1ItemStack, Block par2Blocks, int metadata)
    {
        if(CurrentPower(par1ItemStack) <= 0)
            return 0;
    	
        return par2Blocks != null && (par2Blocks.getMaterial() == Material.iron || par2Blocks.getMaterial() == Material.anvil || par2Blocks.getMaterial() == Material.rock || par2Blocks.getMaterial() == Material.wood || par2Blocks.getMaterial() == Material.plants || par2Blocks.getMaterial() == Material.vine) ? this.efficiencyOnProperMaterial : super.getDigSpeed(par1ItemStack, par2Blocks, metadata);
    }
    
    public boolean onBlockDestroyed(ItemStack stack, World p_150894_2_, Block p_150894_3_, int p_150894_4_, int p_150894_5_, int p_150894_6_, EntityLivingBase p_150894_7_)
    {
        if ((double)p_150894_3_.getBlockHardness(p_150894_2_, p_150894_4_, p_150894_5_, p_150894_6_) != 0.0D)
        {

            RemovePower(stack, 1);

        }

        return true;
    }
    
    
    
	   @SideOnly(Side.CLIENT)
	   public void registerIcons(IIconRegister par1IconRegister)
	   {
		   this.Drill = par1IconRegister.registerIcon(Reference.Mod_Id + ":Drill");
		   this.DrillGreen = par1IconRegister.registerIcon(Reference.Mod_Id + ":DrillGreen");
		   this.DrillYellow = par1IconRegister.registerIcon(Reference.Mod_Id + ":DrillYellow");
		   this.DrillOrange = par1IconRegister.registerIcon(Reference.Mod_Id + ":DrillOrange");
		   this.DrillRed = par1IconRegister.registerIcon(Reference.Mod_Id + ":DrillRed");

           itemIcon = Drill;
		   
	   }
	   
	    @SuppressWarnings({ "unchecked", "rawtypes" })
		@Override
	    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
	    {
	    	
	            list.add(StatCollector.translateToLocal("items.desc.drill.mode.1"));
	            list.add(StatCollector.translateToLocal("items.desc.drill.mode.2"));
	            list.add(StatCollector.translateToLocal("items.desc.drill.mode.3"));
	            list.add(StatCollector.translateToLocal("items.desc.drill.1"));

	            
	    			  
	            if(HasInfo(itemstack)){
	    			  NBTTagCompound Compound = itemstack.getTagCompound().getCompoundTag("Data");
		    		list.add(EnumChatFormatting.GOLD + StatCollector.translateToLocal("items.desc.drill.2") + ": " + StatCollector.translateToLocal("items.desc.drill.mode. + " + Compound.getString("Mode")));
	            }else{

	            	list.add(EnumChatFormatting.GOLD + StatCollector.translateToLocal("items.desc.drill.2_normal"));
	            	
	            }


            super.addInformation(itemstack,player,list,par4);
	            
	    }
	    

	    
	    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player)
	    {
	    	
	        NBTTagCompound stackCompound = item.hasTagCompound() ? item.getTagCompound() : new NBTTagCompound();
	        NBTTagCompound compound = new NBTTagCompound();

	        
	        
	    	
	    	if(player.isSneaking()){

	    		if(!HasInfo(item)){
	    			compound.setInteger("Mode", 2);
	    		if(world.isRemote)
	    			ChatMessageHandler.sendChatToPlayer(player, StatCollector.translateToLocal("items.drill.change.2"));
	    		}
	    		
	    		if(HasInfo(item)){
	    			  NBTTagCompound Compound = item.getTagCompound().getCompoundTag("Data");
	    			  
	    			  if(Compound.getInteger("Mode") == 1){
	    				  
	    				  compound.setInteger("Mode", 2);
	    		    		if(world.isRemote)
	    		    			ChatMessageHandler.sendChatToPlayer(player, StatCollector.translateToLocal("items.drill.change.2"));
	    				  
	    			  }else if (Compound.getInteger("Mode") == 2){
	    				  compound.setInteger("Mode",3);
	    		    		if(world.isRemote)
	    		    			ChatMessageHandler.sendChatToPlayer(player, StatCollector.translateToLocal("items.drill.change.3"));
	    				  
	    			  }else if (Compound.getInteger("Mode") == 3){
	    				  compound.setInteger("Mode", 1);
	    		    		if(world.isRemote)
	    		    			ChatMessageHandler.sendChatToPlayer(player, StatCollector.translateToLocal("items.drill.change.1"));
	    				  
	    			  }else{
	    				  compound.setInteger("Mode", 2);
	    			  }
	    		
	    		}
	    		
	    		
	    		
	    		
	    		
	            stackCompound.setTag("Data", compound);
	            item.setTagCompound(stackCompound);

	    	
	    	}
	    	
	    	return item;
	    }
	    


	    
	    @SuppressWarnings("unused")
		public boolean onBlockStartBreak(ItemStack itemstack, int x, int y, int z, EntityPlayer player)
	    {
	    	
            if(HasInfo(itemstack)){
  			  NBTTagCompound Compound = itemstack.getTagCompound().getCompoundTag("Data");
  			  
  			  
  	        World world = player.worldObj;
  	        final Block block = world.getBlock(x, y, z);
  	        final int meta = world.getBlockMetadata(x, y, z);
  	      float blockHardness = block.getBlockHardness(world, x, y, z);
  	      

  	      if(itemstack.canEditBlocks()){
  	        
  	        if (block == null)
  	            return super.onBlockStartBreak(itemstack, x, y, z, player);
  			  

	    			
	    			if(CurrentPower(itemstack) < 9){
	    			
	    				return false;
	    				
	    			}else{
	    			 MovingObjectPosition mop = raytraceFromEntity(world, player, true, 5.0D);
	    		        if (mop == null)
	    		            return super.onBlockStartBreak(itemstack, x, y, z, player);

	    		        
	    		        int xRange = 0;
	    		        int yRange = 0;
	    		        int zRange = 0;
	    	    		
	    	    		if(Compound.getInteger("Mode") == 2){
	    	    			
		    		        xRange = 1;
		    		        yRange = 1;
		    		        zRange = 1;
	    	            
	    	    		}else if (Compound.getInteger("Mode") == 3){
	    	    			
		    		        xRange = 2;
		    		        yRange = 2;
		    		        zRange = 2;
	    	    		}
	    		        

	    		        switch (mop.sideHit)
	    		        {
	    		        case 0:
	    		        case 1:
	    		            yRange = 0;
	    		            break;
	    		        case 2:
	    		        case 3:
	    		            zRange = 0;
	    		            break;
	    		        case 4:
	    		        case 5:
	    		            xRange = 0;
	    		            break;
	    		        }


	    			
	    			for (int xPos = x - xRange; xPos <= x + xRange; xPos++)
	    	        {
	    	            for (int yPos = y - yRange; yPos <= y + yRange; yPos++)
	    	            {
	    	                for (int zPos = z - zRange; zPos <= z + zRange; zPos++)
	    	                {
	    	                	Block localBlock = world.getBlock(xPos, yPos, zPos);
	    	                        
	    	                        int localMeta = world.getBlockMetadata(xPos, yPos, zPos);
	    	                        float localHardness = localBlock == null ? Float.MAX_VALUE : localBlock.getBlockHardness(world, xPos, yPos, zPos);


	    	                        
	    	                        
	    	                                if (localBlock != null && !(localHardness < 0) && localHardness <= blockHardness)
	    	                                {
	
	    	                                            if (!player.capabilities.isCreativeMode)
	    	                                            {
	    	                                                if (localBlock.removedByPlayer(world, player, xPos, yPos, zPos))
	    	                                                {
	    	                                                	localBlock.onBlockDestroyedByPlayer(world, xPos, yPos, zPos, localMeta);
	    	                                                }
	    	                                                localBlock.harvestBlock(world, player, xPos, yPos, zPos, localMeta);
	    	                                                localBlock.onBlockHarvested(world, xPos, yPos, zPos, localMeta, player);
	    	                                                if (blockHardness > 0f)
	    	                                                    onBlockDestroyed(itemstack, world, localBlock, xPos, yPos, zPos, player);
	    	                                            }
	    	                                            else
	    	                                            {
	    	                                                world.setBlockToAir(xPos, yPos, zPos);
	    	                                            
	    	                                        }
	    	                                    
	    	                                
	    	                            }
	    	                        }


	    	        }
	    	        }
            if (!world.isRemote)
                world.playAuxSFX(2001, x, y, z, Block.getIdFromBlock(block) + (meta << 12));
            return true;
	    		
            
	    		}
            }
            }
            
	        return false;

	    }
	    
	    public boolean HasInfo(ItemStack stack) {
	        return stack.hasTagCompound() && stack.getTagCompound().hasKey("Data");
	    }

	    
	    public static MovingObjectPosition raytraceFromEntity (World world, Entity player, boolean par3, double range)
	    {
	        float f = 1.0F;
	        float f1 = player.prevRotationPitch + (player.rotationPitch - player.prevRotationPitch) * f;
	        float f2 = player.prevRotationYaw + (player.rotationYaw - player.prevRotationYaw) * f;
	        double d0 = player.prevPosX + (player.posX - player.prevPosX) * (double) f;
	        double d1 = player.prevPosY + (player.posY - player.prevPosY) * (double) f + 1.62D - (double) player.yOffset;
	        double d2 = player.prevPosZ + (player.posZ - player.prevPosZ) * (double) f;
	        Vec3 vec3 = Vec3.createVectorHelper(d0, d1, d2);
	        float f3 = MathHelper.cos(-f2 * 0.017453292F - (float) Math.PI);
	        float f4 = MathHelper.sin(-f2 * 0.017453292F - (float) Math.PI);
	        float f5 = -MathHelper.cos(-f1 * 0.017453292F);
	        float f6 = MathHelper.sin(-f1 * 0.017453292F);
	        float f7 = f4 * f5;
	        float f8 = f3 * f5;
	        double d3 = range;
	        if (player instanceof EntityPlayerMP)
	        {
	            d3 = ((EntityPlayerMP) player).theItemInWorldManager.getBlockReachDistance();
	        }
	        Vec3 vec31 = vec3.addVector((double) f7 * d3, (double) f6 * d3, (double) f8 * d3);
	        return world.func_147447_a(vec3, vec31, par3, !par3, false);
	    }
	    
	    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
	    {
	        return false;
	    }
	    


		@Override
		public double MaxPower(ItemStack stack) {
			return MaxCharge;
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
