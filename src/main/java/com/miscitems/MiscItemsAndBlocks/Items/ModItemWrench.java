package com.miscitems.MiscItemsAndBlocks.Items;

import MiscItemsApi.Electric.IWrenchAble;
import buildcraft.api.tools.IToolWrench;
import com.miscitems.MiscItemsAndBlocks.Utils.References.Reference;
import cpw.mods.fml.common.Optional;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

@Optional.Interface(iface = "buildcraft.api.tools.IToolWrench", modid =  "BuilCraft|Core", striprefs = true)
public class ModItemWrench extends Item implements IToolWrench {


	
	   @SideOnly(Side.CLIENT)

	   public void registerIcons(IIconRegister par1IconRegister)
	   {
		   this.itemIcon = par1IconRegister.registerIcon(Reference.Mod_Id + ":Wrench");
		   
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

    public boolean canWrench(EntityPlayer player, int x, int y, int z) {
        return player.worldObj.getTileEntity(x,y,z) instanceof IWrenchAble;
    }

    public void wrenchUsed(EntityPlayer player, int x, int y, int z) {

        ((IWrenchAble)player.worldObj.getTileEntity(x,y,z)).OnWrenched(player,x,y,z);
    }
}
