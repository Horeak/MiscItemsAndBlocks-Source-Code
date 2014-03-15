	package com.miscitems.MiscItemsAndBlocks.Smelting;

import com.miscitems.MiscItemsAndBlocks.Items.ModItems;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = SmeltingRecipe.MODID, version = SmeltingRecipe.VERSION)
public class SmeltingRecipe
{
    public static final String MODID = "SmeltingRecipe";
    public static final String VERSION = "1.0";
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		// smelting recipe
        GameRegistry.addSmelting(ModItems.RawPenguinMeat, new ItemStack(ModItems.CookedPenguin), 20F);
    }
}
