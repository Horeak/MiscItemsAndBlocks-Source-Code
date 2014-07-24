package com.miscitems.MiscItemsAndBlocks.Utils.MagicUtils;

import com.miscitems.MiscItemsAndBlocks.Network.Client.MagicReciveParticleEffects;
import com.miscitems.MiscItemsAndBlocks.Network.PacketHandler;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Interfaces.Magic.MagicReceiver;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Interfaces.Magic.MagicSender;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.WorldServer;

import java.util.ArrayList;
import java.util.List;

public class MagicUtils {


    private static ArrayList craftingRecipes = new ArrayList();

    public static List getCraftingRecipes()
    {
        return craftingRecipes;
    }

    public static InfusionRecipe RegisterInfusionRecipe(Object result, ItemStack input, Object[] recipe, double Energy)
    {
        if ((!(result instanceof ItemStack)) && (!(result instanceof Object[]))) {
            return null;
        }

        ItemStack[] stacks = new ItemStack[recipe.length];

        for(int i = 0; i < recipe.length; i++){
            ItemStack stack = null;

            if(recipe[i] instanceof Block)
                stack = new ItemStack((Block)recipe[i]);

            if(recipe[i] instanceof Item)
                stack = new ItemStack((Item)recipe[i]);

            if(recipe[i] instanceof ItemStack)
                stack = (ItemStack)recipe[i];

            stacks[i] = stack;
        }

        InfusionRecipe r = new InfusionRecipe(result, input, stacks, Energy);
        craftingRecipes.add(r);
        return r;
    }

    public static InfusionRecipe GetInfusionRecipe(ArrayList<ItemStack> items, ItemStack input)
    {
        InfusionRecipe var13 = null;
        for (Object var11 : getCraftingRecipes()) {
            if (((var11 instanceof InfusionRecipe)))
            {
                if(((InfusionRecipe) var11).item.getItem() == input.getItem() && ((InfusionRecipe) var11).item.getItemDamage() == input.getItemDamage()){

                    if(items.size() == ((InfusionRecipe) var11).stacks.length){


                        boolean HasAllItems = false;
                        for(int i = 0; i < ((InfusionRecipe) var11).stacks.length; i++){
                            boolean t = false;

                            for(int g = 0; g < items.size(); g++){
                                if(items.get(g).getItem() == ((InfusionRecipe) var11).stacks[i].getItem() &&
                                        items.get(g).getItemDamage() == ((InfusionRecipe) var11).stacks[i].getItemDamage()){
                                    t = true;
                                }
                            }
                                HasAllItems = t;

                            if(HasAllItems == false)
                                return null;

                        }

                        if(HasAllItems) {
                            var13 = (InfusionRecipe) var11;
                            return var13;
                        }




                    }

                }

            }
        }
        return var13;
    }


    static int Radius = 8;

    public static void SendPower(MagicSender sender, TileEntity tile){

            if (!tile.getWorldObj().isRemote) {
                WorldServer world = (WorldServer) tile.getWorldObj();

                double Rad = 0;
                MagicReceiver recc = null;

                List list = world.func_147486_a(tile.xCoord - Radius, tile.yCoord - Radius, tile.zCoord - Radius, tile.xCoord + Radius, tile.yCoord + Radius, tile.zCoord + Radius);

                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) instanceof TileEntity) {
                        TileEntity tilee = (TileEntity) list.get(i);

                        if (tilee instanceof MagicReceiver) {
                            MagicReceiver rec = (MagicReceiver) tilee;

                            if (rec.CanReceiveEnergyAmount(sender.GetEnergyPacketSize())) {

                                if(tilee.xCoord != tile.xCoord || tilee.yCoord != tile.yCoord || tilee.zCoord != tile.zCoord) {

                                    if (Rad == 0) {
                                        Rad = tilee.getDistanceFrom(tile.xCoord, tile.yCoord, tile.zCoord);
                                        recc = rec;

                                    } else if (Rad > 0 && tilee.getDistanceFrom(tile.xCoord, tile.yCoord, tile.zCoord) < Rad) {
                                        Rad = tilee.getDistanceFrom(tile.xCoord, tile.yCoord, tile.zCoord);
                                        recc = rec;

                                    }
                                }else
                                continue;

                                break;

                            }else
                                continue;


                        } else
                            continue;

                    }

                }



                if(recc != null){
                    if(sender.CanSendEnergyAmount(sender.GetEnergyPacketSize())) {
                        sender.SendEnergy(recc, sender.GetEnergyPacketSize());
                    }
                }


            }
        }


    public static void ReceiveEnergy(TileEntity tile){
        PacketHandler.sendToDimension(new MagicReciveParticleEffects(tile.xCoord, tile.yCoord, tile.zCoord), tile.getWorldObj().provider.dimensionId);

    }

}
