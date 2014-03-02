package com.miscitems.MiscItemsAndBlocks.Block;

import static net.minecraftforge.common.util.ForgeDirection.UP;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import com.miscitems.MiscItemsAndBlocks.Items.ModItems;
import com.miscitems.MiscItemsAndBlocks.Lib.Refrence;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModBlockTomatoPlant extends BlockCrops {

	
	
	IIcon[] IconArray = new IIcon[5];
	
	
	public ModBlockTomatoPlant() {
		super();
        float f = 0.5F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
        this.setTickRandomly(true);
	}
	
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
        return null;
    }
       
    public int getRenderType() {
        return 6;
    }
   
    public boolean isOpaqueCube() {
        return false;
    }
    
    @Override
    public IIcon getIcon(int par1, int par2)
    {

    	
        if (par2 < 0 || par2 > 4)
        {
            par2 = 4;
        }

        
        return this.IconArray[par2];


    }
    
	   @SideOnly(Side.CLIENT)
	   public void registerBlockIcons(IIconRegister par1IconRegister)
	   {
		   
		   IconArray[0] = par1IconRegister.registerIcon(Refrence.Mod_Id + ":TomatoPlant0");
		   IconArray[1] = par1IconRegister.registerIcon(Refrence.Mod_Id + ":TomatoPlant1");
		   IconArray[2] = par1IconRegister.registerIcon(Refrence.Mod_Id + ":TomatoPlant2");
		   IconArray[3] = par1IconRegister.registerIcon(Refrence.Mod_Id + ":TomatoPlant3");
		   IconArray[4] = par1IconRegister.registerIcon(Refrence.Mod_Id + ":TomatoPlant4");
		   
		   
		   
	   }
	   
	   @Override
	    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
	    {
	        super.updateTick(par1World, par2, par3, par4, par5Random);

	        if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9)
	        {
	            int l = par1World.getBlockMetadata(par2, par3, par4);

	            if (l < 5)
	            {
	                float f = this.func_149875_n(par1World, par2, par3, par4);

	                if (par5Random.nextInt((int)(25.0F / f) + 1) == 0)
	                {
	                    ++l;
	                    par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
	                }
	            }
	        }
	    }
	   
	   @Override
	   public void onNeighborBlockChange (World world, int x, int y, int z,
	           Block neighborId) {
	       if (!canBlockStay(world, x, y, z)) {
	           dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
	           world.setBlockToAir(x, y, z);
	       }
	   }
	   
	   @Override
	   public boolean canBlockStay (World world, int x, int y, int z) {
	       Block soil = world.getBlock(x, y - 1, z);
	       return (world.getFullBlockLightValue(x, y, z) >= 8 ||
	               world.canBlockSeeTheSky(x, y, z)) &&
	               (soil != null && soil.canSustainPlant(world, x, y - 1, z,
	                     ForgeDirection.UP, ModItems.TomatoSeeds));
	   }
	   
	   @Override
	    public Item getItemDropped(int par1, Random par2Random, int par3)
	    {
	       return par1 >= 4 ? this.getCropItem() : this.getSeedItem();
	   }
	   
	    
	   private float func_149875_n(World p_149875_1_, int p_149875_2_, int p_149875_3_, int p_149875_4_)
	    {
	        float f = 1.0F;
	        Block block = p_149875_1_.getBlock(p_149875_2_, p_149875_3_, p_149875_4_ - 1);
	        Block block1 = p_149875_1_.getBlock(p_149875_2_, p_149875_3_, p_149875_4_ + 1);
	        Block block2 = p_149875_1_.getBlock(p_149875_2_ - 1, p_149875_3_, p_149875_4_);
	        Block block3 = p_149875_1_.getBlock(p_149875_2_ + 1, p_149875_3_, p_149875_4_);
	        Block block4 = p_149875_1_.getBlock(p_149875_2_ - 1, p_149875_3_, p_149875_4_ - 1);
	        Block block5 = p_149875_1_.getBlock(p_149875_2_ + 1, p_149875_3_, p_149875_4_ - 1);
	        Block block6 = p_149875_1_.getBlock(p_149875_2_ + 1, p_149875_3_, p_149875_4_ + 1);
	        Block block7 = p_149875_1_.getBlock(p_149875_2_ - 1, p_149875_3_, p_149875_4_ + 1);
	        boolean flag = block2 == this || block3 == this;
	        boolean flag1 = block == this || block1 == this;
	        boolean flag2 = block4 == this || block5 == this || block6 == this || block7 == this;

	        for (int l = p_149875_2_ - 1; l <= p_149875_2_ + 1; ++l)
	        {
	            for (int i1 = p_149875_4_ - 1; i1 <= p_149875_4_ + 1; ++i1)
	            {
	                Block block8 = p_149875_1_.getBlock(l, p_149875_3_ - 1, i1);
	                float f1 = 0.0F;

	                if (block8.canSustainPlant(p_149875_1_, l, p_149875_3_ - 1, i1, UP, this))
	                {
	                    f1 = 1.0F;

	                    if (block8.isFertile(p_149875_1_, l, p_149875_3_ - 1, i1))
	                    {
	                        f1 = 3.0F;
	                    }
	                }

	                if (l != p_149875_2_ || i1 != p_149875_4_)
	                {
	                    f1 /= 4.0F;
	                }

	                f += f1;
	            }
	        }

	        if (flag2 || flag && flag1)
	        {
	            f /= 2.0F;
	        }

	        return f;
	    }
	    
	    protected Item getSeedItem()
	    {
	        return ModItems.TomatoSeeds;
	    }


	    protected Item getCropItem()
	    {
	        return ModItems.Tomato;
	    }

	    
	    public void fertilize(World par1World, int par2, int par3, int par4)
	    {
	        int l = par1World.getBlockMetadata(par2, par3, par4) + MathHelper.getRandomIntegerInRange(par1World.rand, 2, 5);

	        if (l > 4)
	        {
	            l = 4;
	        }

	        par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
	    }
	    
	    @SideOnly(Side.CLIENT)
	    public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_)
	    {
	        return this.getSeedItem();
	    }


}
