package com.miscitems.MiscItemsAndBlocks.Items;

import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.Main.ModBlocks;
import cpw.mods.fml.common.Optional.Method;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;

public class ModItemFloatBlockPlacer extends ModItemPowerTool{

    public ModItemFloatBlockPlacer() {
		super(0, ToolMaterial.WOOD, Main.EmptyToolSet);
		this.setMaxDamage(325);
		
		
	}
	
    
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
    {
    	return false;
    	
    }
    
    

    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
    	if(!world.isRemote){
    		if(!player.isSneaking()){
    		
    	SetBlock((int)player.posX - 1, (int)player.posY - 2, (int)player.posZ, world);
    		
        	SetBlock((int)player.posX - 2, (int)player.posY - 2, (int)player.posZ, world);
        	
        	SetBlock((int)player.posX, (int)player.posY - 2, (int)player.posZ  , world);
        	
        	SetBlock((int)player.posX - 1, (int)player.posY - 2, (int)player.posZ + 1, world);
        	
        	SetBlock((int)player.posX - 2, (int)player.posY - 2, (int)player.posZ + 1, world);
        	
        	SetBlock((int)player.posX, (int)player.posY - 2, (int)player.posZ + 1, world);
        	
        	SetBlock((int)player.posX - 2, (int)player.posY - 2, (int)player.posZ - 1, world);
        	
        	SetBlock((int)player.posX - 1, (int)player.posY - 2, (int)player.posZ - 1, world);
        	
        	SetBlock((int)player.posX, (int)player.posY - 2, (int)player.posZ - 1, world);
        	
    	
    	player.fallDistance = 0;
    	player.motionY = 0;
    	
    	stack.attemptDamageItem(1, world.rand);
    		}
    	}
    	
    
    	
        return stack;
    }
    
    public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
    {
    	
    	return 0;
    }
    
    public void SetBlock(int x, int y, int z, World world){
		if(world.getBlock(x, y, z) == Blocks.air)
		world.setBlock(x, y , z, ModBlocks.TimedBlock);
    }

    
    public int getItemEnchantability()
    {
        return -1;
    }


    @Override
    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
    {
            list.add(StatCollector.translateToLocal("items.desc.floatblockplacer.1"));
            list.add(EnumChatFormatting.RED + StatCollector.translateToLocal("items.desc.floatblockplacer.2"));
    }


	@Override
	public int MaxPower(ItemStack stack) {
		return 325;
	}


	@Override
	public int ChargeAmount(ItemStack stack) {
		return 1;
	}


	@Override
	public boolean CanBackpackRecharge(ItemStack stack) {
		return true;
	}

    @Method(modid = "IC2")
    @Override
    public int getTier(ItemStack itemStack) {
        return 2;
    }
}
