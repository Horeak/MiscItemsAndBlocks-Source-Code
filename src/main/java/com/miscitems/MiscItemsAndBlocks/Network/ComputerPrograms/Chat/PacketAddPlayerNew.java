package com.miscitems.MiscItemsAndBlocks.Network.ComputerPrograms.Chat;

import MiscUtils.Network.AbstractPacket;
import com.miscitems.MiscItemsAndBlocks.Gui.Computer.Programs.Utils.ChannelUtils;
import com.miscitems.MiscItemsAndBlocks.Gui.Computer.Programs.Utils.ChatChannel;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.relauncher.Side;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;

import java.util.ArrayList;

public class PacketAddPlayerNew extends AbstractPacket {

    String id;

    ArrayList<String> Names;

    public PacketAddPlayerNew(){}
    public PacketAddPlayerNew(String id, ArrayList<EntityPlayer> players){
        this.id = id;

        Names = new ArrayList<String>();

        for(EntityPlayer pl : players){
            Names.add(pl.getCommandSenderName());
        }
    }

    @Override
    public void toBytes(ByteBuf buffer, Side side) {

        ByteBufUtils.writeUTF8String(buffer, id);

        NBTTagCompound comp = new NBTTagCompound();

        NBTTagList tagList = new NBTTagList();
        for(int i = 0; i < Names.size(); i++)
        {
            String s = Names.get(i);
            if(s != null)
            {
                NBTTagCompound tag = new NBTTagCompound();
                tag.setString("Name", s);
                tagList.appendTag(tag);
            }
        }

        comp.setTag("PLS", tagList);

        ByteBufUtils.writeTag(buffer, comp);

    }

    @Override
    public void fromBytes(ByteBuf buffer, Side side) {

        this.id = ByteBufUtils.readUTF8String(buffer);


        NBTTagCompound comp = ByteBufUtils.readTag(buffer);

        NBTTagList tagList = comp.getTagList("PLS", Constants.NBT.TAG_COMPOUND);


        for(int i = 0; i < tagList.tagCount(); i++)
        {

            NBTTagCompound tag = tagList.getCompoundTagAt(i);

            if(tag.hasKey("Name")) {

                String s = tag.getString("Name");

                if(Names == null)
                    Names = new ArrayList<String>();

                    Names.add(i, s);
            }
        }

    }

    @Override
    public void onMessage(Side side, EntityPlayer pla) {

        ChatChannel channel = ChannelUtils.GetChannel(id);

        if(channel != null) {

            ArrayList<EntityPlayer> pls = new ArrayList<EntityPlayer>();

            for(int i = 0; i < Names.size(); i++){
                String nm = Names.get(i);


                EntityPlayer pl = null;

                if(nm != null){
                    if(FMLCommonHandler.instance().getSide() == Side.SERVER) {
                        pl = FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().func_152612_a(nm);
                    }else{
                        pl = Main.proxy.getPlayer();
                    }

                }

                System.out.println(pl + " New");

                if(pl != null)
                    pls.add(pl);
            }




            if(pls != null && pls.size() > 0){
                channel.ConnectedPlayers.clear();

                for(EntityPlayer player : pls){
                    if(!channel.ConnectedPlayers.contains(player))
                    channel.ConnectedPlayers.add(player);
                }


            }


         }



    }
}
