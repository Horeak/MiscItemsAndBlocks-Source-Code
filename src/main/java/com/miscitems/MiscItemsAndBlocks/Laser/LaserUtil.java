package com.miscitems.MiscItemsAndBlocks.Laser;

import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.Network.Packet.PacketHandler;
import com.miscitems.MiscItemsAndBlocks.Network.Packet.Server.ServerSetBlockPacket;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityLaserReciver;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Facing;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.List;

public class LaserUtil {
	
	/**
	 * @author ProPercivalalb <https://github.com/ProPercivalalb/LaserMod>
	 */

public static int TICK_RATE = 2;
public static double LASER_SIZE = 0.4D; 

public static int getOrientation(int meta) {
return meta & 7;
}

public static ILaserReciver getFirstReciver(ILaserProvider laserProvider, int meta) {
int orientation = getOrientation(meta);

for(int distance = 1; distance <= laserProvider.GetLensStrength(); distance++) {
int xTemp = laserProvider.getX() + ForgeDirection.VALID_DIRECTIONS[orientation].offsetX * distance;
int yTemp = laserProvider.getY() + ForgeDirection.VALID_DIRECTIONS[orientation].offsetY * distance;
int zTemp = laserProvider.getZ() + ForgeDirection.VALID_DIRECTIONS[orientation].offsetZ * distance;


Block block = laserProvider.getWorld().getBlock(xTemp, yTemp, zTemp);
int blockMeta = laserProvider.getWorld().getBlockMetadata(xTemp, yTemp, zTemp);
TileEntity tileEntity = laserProvider.getWorld().getTileEntity(xTemp, yTemp, zTemp);

if(tileEntity instanceof ILaserReciver)
return (ILaserReciver)tileEntity;

if(!LaserWhitelist.canLaserPassThrought(block, blockMeta))
break;
}

        return null;
}

public static boolean isValidSourceOfPowerOnSide(ILaserProvider laserProvider, ILaserReciver laserReciver, int side) {
for(int distance = 1; distance <= laserProvider.GetLensStrength(); distance++) {
int xTemp = laserReciver.getX() + ForgeDirection.VALID_DIRECTIONS[side].offsetX * distance;
int yTemp = laserReciver.getY() + ForgeDirection.VALID_DIRECTIONS[side].offsetY * distance;
int zTemp = laserReciver.getZ() + ForgeDirection.VALID_DIRECTIONS[side].offsetZ * distance;


Block block = laserReciver.getWorld().getBlock(xTemp, yTemp, zTemp);
int blockMeta = laserReciver.getWorld().getBlockMetadata(xTemp, yTemp, zTemp);
TileEntity tileEntity = laserReciver.getWorld().getTileEntity(xTemp, yTemp, zTemp);

if(!LaserWhitelist.canLaserPassThrought(block, blockMeta))
if(tileEntity instanceof ILaserProvider)
return ((ILaserProvider)tileEntity).isSendingSignalFromSide(laserReciver.getWorld(), laserReciver.getX(), laserReciver.getY(), laserReciver.getZ(), Facing.oppositeSide[side]);
else
break;
}

     return false;
}


@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
public static AxisAlignedBB getLaserOutline(ILaserProvider laserProvider, int meta, double renderX, double renderY, double renderZ) {
int orientation = getOrientation(meta);
double offsetMin = 0.5D - LASER_SIZE / 2;
double offsetMax = 0.5D + LASER_SIZE / 2;
AxisAlignedBB boundingBox = AxisAlignedBB.getBoundingBox(renderX + offsetMin, renderY + offsetMin, renderZ + offsetMin, renderX + offsetMax, renderY + offsetMax, renderZ + offsetMax);

double[] extra = new double[ForgeDirection.VALID_DIRECTIONS.length];

for(int distance = 1; distance <= laserProvider.GetLensStrength(); distance++) {
int xTemp = laserProvider.getX() + ForgeDirection.VALID_DIRECTIONS[orientation].offsetX * distance;
int yTemp = laserProvider.getY() + ForgeDirection.VALID_DIRECTIONS[orientation].offsetY * distance;
int zTemp = laserProvider.getZ() + ForgeDirection.VALID_DIRECTIONS[orientation].offsetZ * distance;



Block block = laserProvider.getWorld().getBlock(xTemp, yTemp, zTemp);
int blockMeta = laserProvider.getWorld().getBlockMetadata(xTemp, yTemp, zTemp);
TileEntity tile = laserProvider.getWorld().getTileEntity(xTemp, yTemp, zTemp);

AxisAlignedBB aabb = AxisAlignedBB.getAABBPool().getAABB(xTemp, yTemp, zTemp, xTemp + offsetMax, yTemp + offsetMax, zTemp + offsetMax);

List ents = laserProvider.getWorld().getEntitiesWithinAABB(Entity.class, aabb);
if(ents.size() > 0){

	extra[orientation] += 1.3 - offsetMax + 0.01D;
	
	break;
}
	



if(LaserWhitelist.canLaserPassThrought(block, blockMeta) || !block.isOpaqueCube() && !block.hasTileEntity(blockMeta))
extra[orientation] += 1;

else if (laserProvider.getWorld().getTileEntity(xTemp, yTemp, zTemp) instanceof TileEntityLaserReciver){
	

	int Meta = laserProvider.getWorld().getBlockMetadata(xTemp, yTemp, zTemp);
	int Ont = orientation;
	
	if(Meta == 3 && Ont == 2 || Meta == 4 && Ont == 5 || Meta == 2 && Ont == 3 || Meta == 5 && Ont == 4){
	extra[orientation] += 1.9 - offsetMax + 0.01D;

	
	break;
	
	
	}else{
		extra[orientation] += 1;
		continue;
	}
		
}
else {
extra[orientation] += 1 - offsetMax + 0.01D;


if(block != null)
if(laserProvider.GetLensPower() >= block.getBlockHardness(laserProvider.getWorld(), xTemp, yTemp, zTemp) && block.getBlockHardness(laserProvider.getWorld(), xTemp, yTemp, zTemp) > -1 && laserProvider.GetLensPower() > 0){
	if(!block.hasTileEntity(blockMeta)){


		

		PacketHandler.INSTANCE.sendToServer(new ServerSetBlockPacket(laserProvider.getWorld().getWorldInfo().getVanillaDimension(), xTemp, yTemp, zTemp, Blocks.air));
		
		
	}
}


break;
}

}

        boundingBox.setBounds(boundingBox.minX - extra[4], boundingBox.minY - extra[0], boundingBox.minZ - extra[2], boundingBox.maxX + extra[5], boundingBox.maxY + extra[1], boundingBox.maxZ + extra[3]);
        

        
        
        return boundingBox;
}

}