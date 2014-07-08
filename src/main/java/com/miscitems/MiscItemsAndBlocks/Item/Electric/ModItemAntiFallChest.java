package com.miscitems.MiscItemsAndBlocks.Item.Electric;

import com.miscitems.MiscItemsAndBlocks.Utils.References.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ModItemAntiFallChest extends ModItemElArmor{

	public ModItemAntiFallChest(int RenderIndex, int ArmorType) {
		super(RenderIndex, ArmorType);
	}

	
	   @SideOnly(Side.CLIENT)
	    @Override
	    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	    {
	    	
	    		return Reference.Mod_Id + ":" + "textures/models/armor/AntiFallArmor_layer_1.png";

	    	
	    }





    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
    {

			if(player.capabilities.isCreativeMode == false){
				if(CurrentPower(player.inventory.armorInventory[2]) > 0){
						if(player.fallDistance > 2 && player.motionY < 0) {
                            player.fallDistance = 2;
                            if (!player.isSneaking())
                                player.motionY = -0.35;
                            if (player.worldObj.rand.nextInt(50) == 1)
                                    RemovePower(player.inventory.armorInventory[2], 1);


                        }

				}

				
			}
	    	
	    }



	    
		@Override
		public double MaxPower(ItemStack stack) {
			return 2453;
		}


		@Override
		public double ChargeAmount(ItemStack stack) {
			return 2;
		}


		@Override
		public boolean CanBackpackRecharge(ItemStack stack) {
			return false;
		}

    @Override
    public int getTier(ItemStack itemStack) {
        return 1;
    }
}
