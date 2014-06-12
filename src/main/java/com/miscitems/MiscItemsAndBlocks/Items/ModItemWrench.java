package com.miscitems.MiscItemsAndBlocks.Items;

import MiscItemsApi.Electric.IWrenchAble;
import buildcraft.api.tools.IToolWrench;
import com.miscitems.MiscItemsAndBlocks.Utils.Refrence;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ModItemWrench extends Item {


	
	   @SideOnly(Side.CLIENT)

	   public void registerIcons(IIconRegister par1IconRegister)
	   {
		   this.itemIcon = par1IconRegister.registerIcon(Refrence.Mod_Id + ":Wrench");
		   
	   }
	   
	   
	    public boolean doesSneakBypassUse(World world, int x, int y, int z, EntityPlayer player)
	    {
	        return true;
	    }
	    public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10)
	    {

            if(world.getTileEntity(x,y,z) instanceof IWrenchAble) {
                ((IWrenchAble)world.getTileEntity(x,y,z)).OnWrenched(player, x, y, z);

                return true;
            }else{
                return false;
            }


	    }
}
