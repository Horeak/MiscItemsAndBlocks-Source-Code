package com.miscitems.MiscItemsAndBlocks.Block.Magic;

import com.miscitems.MiscItemsAndBlocks.Block.Utils.ModBlockContainer;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Magic.TileEntityMagicalDecontructor;
import com.miscitems.MiscItemsAndBlocks.Utils.References.Reference;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ModBlockMagicalDeconstructor extends ModBlockContainer{

    public ModBlockMagicalDeconstructor() {
        super(Material.iron);
        this.setHardness(3F);
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntityMagicalDecontructor();
    }

    IIcon IconTop;
    IIcon IconSide;
    IIcon IconBottom;

    public void registerBlockIcons(IIconRegister par1IconRegister)
    {

        this.IconTop = par1IconRegister.registerIcon(Reference.Mod_Id + ":" + "MagicalDeconstructorTop");
        this.IconSide = par1IconRegister.registerIcon(Reference.Mod_Id + ":" + "MagicalDeconstructorSide");
        this.IconBottom = par1IconRegister.registerIcon(Reference.Mod_Id + ":" + "MagicalDeconstructorBottom");

        blockIcon = IconSide;

    }


    public IIcon getIcon(int par1, int par2)
    {
        return par1 == 1 ? IconTop : (par1 == 0 ? IconBottom : IconSide );
    }


    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        if (par1World.isRemote)
        {

            return true;
        }
        else
        {


            FMLNetworkHandler.openGui(par5EntityPlayer, Main.instance, 0, par1World, par2, par3, par4);
            return true;
        }
    }
}
