package com.miscitems.MiscItemsAndBlocks.Item.Electric;

import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.Utils.References.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

import java.util.ArrayList;
import java.util.Random;

public class ModItemElectricShear extends ModItemPowerTool{

	public ModItemElectricShear() {
		super(0, ToolMaterial.IRON, Main.EmptyToolSet);

		this.setMaxStackSize(1);
	}
	
	@Override
    public boolean itemInteractionForEntity(ItemStack itemstack, EntityPlayer player, EntityLivingBase entity)
    {
    	if(CurrentPower(itemstack) > 0){
		
        if (entity.worldObj.isRemote)
        {
            return false;
        }
        if (entity instanceof IShearable)
        {
            IShearable target = (IShearable)entity;
            if (target.isShearable(itemstack, entity.worldObj, (int)entity.posX, (int)entity.posY, (int)entity.posZ))
            {
                ArrayList<ItemStack> drops = target.onSheared(itemstack, entity.worldObj, (int)entity.posX, (int)entity.posY, (int)entity.posZ,
                        EnchantmentHelper.getEnchantmentLevel(Enchantment.fortune.effectId, itemstack));

                Random rand = new Random();
                for(ItemStack stack : drops)
                {
                    EntityItem ent = entity.entityDropItem(stack, 1.0F);
                    ent.motionY += rand.nextFloat() * 0.05F;
                    ent.motionX += (rand.nextFloat() - rand.nextFloat()) * 0.1F;
                    ent.motionZ += (rand.nextFloat() - rand.nextFloat()) * 0.1F;
                }
                RemovePower(itemstack, 1);
            }
            return true;
        }
    	}
        return false;
    }

    @Override
    public boolean onBlockStartBreak(ItemStack itemstack, int x, int y, int z, EntityPlayer player)
    {
    	if(CurrentPower(itemstack) > 0){
    	
        if (player.worldObj.isRemote)
        {
            return false;
        }
        Block id = player.worldObj.getBlock(x, y, z);
        if (id instanceof IShearable)
        {
            IShearable target = (IShearable)id;
            if (target.isShearable(itemstack, player.worldObj, x, y, z))
            {
                ArrayList<ItemStack> drops = target.onSheared(itemstack, player.worldObj, x, y, z,
                        EnchantmentHelper.getEnchantmentLevel(Enchantment.fortune.effectId, itemstack));
                Random rand = new Random();

                for(ItemStack stack : drops)
                {
                    float f = 0.7F;
                    double d  = (double)(rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
                    double d1 = (double)(rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
                    double d2 = (double)(rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
                    EntityItem entityitem = new EntityItem(player.worldObj, (double)x + d, (double)y + d1, (double)z + d2, stack);
                    entityitem.delayBeforeCanPickup = 10;
                    player.worldObj.spawnEntityInWorld(entityitem);
                }

                RemovePower(itemstack, 1);
                player.addStat(StatList.mineBlockStatArray[id.getIdFromBlock(id)], 1);
            }
        }
    	}
        return false;
    }
    
    @Override
    public float getDigSpeed(ItemStack par1ItemStack, Block par2Block, int metadata)
    {
    	if(CurrentPower(par1ItemStack) > 0){
    	
        return par2Block != Blocks.web && par2Block != Blocks.leaves ? (par2Block == Blocks.wool ? 5.0F : super.getDigSpeed(par1ItemStack, par2Block, metadata)) : 15.0F;
    	}else{
    		return 0;
    	}
    	
    	}
    	
    
    public boolean canHarvestBlock(Block par1Block)
    {
        return par1Block == Blocks.web || par1Block == Blocks.redstone_wire || par1Block == Blocks.tripwire;
    }
    
    public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, Block par3, int par4, int par5, int par6, EntityLivingBase par7EntityLivingBase)
    {
    	if(CurrentPower(par1ItemStack) > 0){
    	
        if (par3 != Blocks.leaves && par3 != Blocks.web && par3 != Blocks.grass && par3 != Blocks.vine && par3 != Blocks.tripwire && !(par3 instanceof IShearable))
        {
            return super.onBlockDestroyed(par1ItemStack, par2World, par3, par4, par5, par6, par7EntityLivingBase);
        }
        else
        {
            return true;
        }
    	}else{
    		return false;
    	}
    }
    
	   @SideOnly(Side.CLIENT)
	   public void registerIcons(IIconRegister par1IconRegister)
	   {
		   this.itemIcon = par1IconRegister.registerIcon(Reference.Mod_Id + ":ElShears");
		  
		   
	   }

	    
	    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
	    {
	        return false;
	    }

		@Override
		public double MaxPower(ItemStack stack) {
			return 430;
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
