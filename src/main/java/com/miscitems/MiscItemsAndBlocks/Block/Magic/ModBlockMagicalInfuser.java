package com.miscitems.MiscItemsAndBlocks.Block.Magic;

import com.miscitems.MiscItemsAndBlocks.Block.Utils.ModBlockContainer;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Magic.TileEntityMagicalInfuser;
import com.miscitems.MiscItemsAndBlocks.Utils.References.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ModBlockMagicalInfuser extends ModBlockContainer {

    public ModBlockMagicalInfuser(){
        super(Material.iron);
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntityMagicalInfuser();
    }


    IIcon Top;
    IIcon Side;
    IIcon Bottom;

    public void registerBlockIcons(IIconRegister icon)
    {
        Top = icon.registerIcon(Reference.Mod_Id + ":MagicalInfuserTop");
        Side = icon.registerIcon(Reference.Mod_Id + ":MagicalInfuserSide");
        Bottom = icon.registerIcon(Reference.Mod_Id + ":MagicalInfuserBottom");

    }

    public IIcon getIcon(int par1, int par2)
    {
        return par1 == 1 ? Top : (par1 == 0 ? Bottom : Side);
    }

}
