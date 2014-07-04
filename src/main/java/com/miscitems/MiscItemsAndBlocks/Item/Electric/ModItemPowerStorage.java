package com.miscitems.MiscItemsAndBlocks.Item.Electric;

import com.miscitems.MiscItemsAndBlocks.Utils.References.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;

public abstract class ModItemPowerStorage extends ModItemPowerTool{




	public ModItemPowerStorage() {
		super(0, ToolMaterial.IRON, null);
		this.setMaxStackSize(1);
        this.setMaxDamage(MaxPower(new ItemStack(this)));
	}


	
    @Override
    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
    {
    	int Damage = itemstack.getMaxDamage() - itemstack.getItemDamage();
    	int MaxDamage = itemstack.getMaxDamage();
    	
    	list.add(StatCollector.translateToLocal("words.power") + ": " + Damage + "/" + MaxDamage);
    	
    	
    }
    
    
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
    {
        return false;
    }
    
    public void onCreated(ItemStack item, World par2World, EntityPlayer par3EntityPlayer) {
    	
    	item.setItemDamage(item.getMaxDamage());
    	
    }

    public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, int par3, int par4, int par5, int par6, EntityLivingBase par7EntityLivingBase)
    {
    	
    	return false;
    }

	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List list)
    {
        super.getSubItems(par1, par2CreativeTabs, list);
        
        
        list.add(new ItemStack(par1, 1, par1.getMaxDamage()));
        
    }



    public IIcon getIcon(ItemStack stack, int pass)
    {

        int left = stack.getMaxDamage() - stack.getItemDamage();


        if(pass == 1){
        if(left > 0 && left <= MaxPower(stack) / 4)
            return Charge_1;

        else if(left > (MaxPower(stack) / 4) && left <= ((MaxPower(stack) / 4) * 2))
            return Charge_2;

        else if(left > (((MaxPower(stack) / 4) * 2)) && left <= ((MaxPower(stack) / 4) * 3) || left > ((MaxPower(stack) / 4) * 3) && left < MaxPower(stack))
            return Charge_3;

        else if(left == MaxPower(stack) || stack.getItemDamage() == 0)
            return Charge_4;



        }


    return itemIcon;

    }


    @SideOnly(Side.CLIENT)
    public boolean requiresMultipleRenderPasses()
    {
        return true;
    }


    public int getRenderPasses(int metadata)
    {
        return 2;
    }

    IIcon Charge_1;
    IIcon Charge_2;
    IIcon Charge_3;
    IIcon Charge_4;


    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister)
    {

        Charge_1 = par1IconRegister.registerIcon(Reference.Mod_Id + ":B_1");
        Charge_2 = par1IconRegister.registerIcon(Reference.Mod_Id + ":B_2");
        Charge_3 = par1IconRegister.registerIcon(Reference.Mod_Id + ":B_3");
        Charge_4 = par1IconRegister.registerIcon(Reference.Mod_Id + ":B_4");


    }



    @Override
    public int getTier(ItemStack itemStack) {
        return 1;
    }

    @Override
    public int getTransferLimit(ItemStack itemStack) {
        return 10;
    }
}
