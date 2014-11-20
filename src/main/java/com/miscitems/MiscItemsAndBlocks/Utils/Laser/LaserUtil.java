package com.miscitems.MiscItemsAndBlocks.Utils.Laser;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import javax.vecmath.Vector3d;
import java.util.ArrayList;
import java.util.List;

public class LaserUtil {

public static double LASER_SIZE = 0.3D;

public static int getOrientation(int meta) {
return meta & 7;
}

public static Vector3d getFirstBlockPos(LaserInstance instance) {
int orientation = getOrientation(instance.side);

for(int distance = 1; distance <= instance.strength; distance++) {
int xTemp =  (int)instance.Position.x + ForgeDirection.VALID_DIRECTIONS[orientation].offsetX * distance;
int yTemp =  (int)instance.Position.y + ForgeDirection.VALID_DIRECTIONS[orientation].offsetY * distance;
int zTemp =  (int)instance.Position.z + ForgeDirection.VALID_DIRECTIONS[orientation].offsetZ * distance;

if(!CanLaserPass(instance.world, xTemp, yTemp, zTemp, instance) && EntitiesInLaser(instance).size() <= 0){
    return new Vector3d(xTemp, yTemp, zTemp);
}
}
    return null;
}

    public static void updateForEntities(LaserInstance instance){
        int orientation = getOrientation(instance.side);
        ForgeDirection dir = ForgeDirection.getOrientation(orientation);

        double offsetMax = 0.5D + LASER_SIZE / 2;


        for(int distance = 1; distance <= instance.strength; distance++) {
            int xTemp = (int)instance.Position.x + dir.offsetX * (distance - 1);
            int yTemp = (int)instance.Position.y + dir.offsetY * (distance - 1);
            int zTemp = (int)instance.Position.z + dir.offsetZ * (distance - 1);

            AxisAlignedBB aabb = AxisAlignedBB.getBoundingBox(xTemp, yTemp, zTemp, xTemp + offsetMax, yTemp + offsetMax, zTemp + offsetMax);

            List ents = instance.world.getEntitiesWithinAABB(Entity.class, aabb);

            double minLen = -1;
            Entity entUse = null;

            for(Object r : ents){
                if(r instanceof Entity){
                    Entity ent = (Entity)r;

                    if(minLen == -1 || ent.getDistance(instance.Position.x, instance.Position.y, instance.Position.z) < minLen){
                        minLen = ent.getDistance(instance.Position.x, instance.Position.y, instance.Position.z);
                        entUse = ent;
                    }

                }
            }


            instance.ActionOnEntity(entUse);

            }


        }




public static AxisAlignedBB getLaserOutline(LaserInstance instance, double renderX, double renderY, double renderZ) {

   int orientation = getOrientation(instance.side);
   ForgeDirection dir = ForgeDirection.getOrientation(orientation);

    double offsetMin = 0.5D - LASER_SIZE / 2;
    double offsetMax = 0.5D + LASER_SIZE / 2;

    renderX += dir.offsetX / 1.8;
    renderY += dir.offsetY / 1.8;
    renderZ += dir.offsetZ / 1.8;

AxisAlignedBB boundingBox = AxisAlignedBB.getBoundingBox(renderX + offsetMin, renderY + offsetMin, renderZ + offsetMin, renderX + offsetMax, renderY + offsetMax, renderZ + offsetMax);
double[] extra = new double[ForgeDirection.VALID_DIRECTIONS.length];

    extra[orientation] -= 0.26;

     for(int distance = 1; distance <= instance.strength; distance++) {
       int xTemp = (int)instance.Position.x + dir.offsetX * (distance - 1);
       int yTemp = (int)instance.Position.y + dir.offsetY * (distance - 1);
       int zTemp = (int)instance.Position.z + dir.offsetZ * (distance - 1);

         AxisAlignedBB aabb = AxisAlignedBB.getBoundingBox(xTemp, yTemp, zTemp, xTemp + offsetMax, yTemp + offsetMax, zTemp + offsetMax);
         List ents = instance.world.getEntitiesWithinAABB(Entity.class, aabb);

         if(ents.size() > 0){
             extra[orientation] += 1.3 - offsetMax + 0.01D;
             break;
         }


        //Add offset for blocks
        if (CanLaserPass(instance.world, xTemp, yTemp, zTemp, instance)) {
            extra[orientation] += 1;

        }
        else {

            extra[orientation] += 1;
            break;
        }

}

        boundingBox.setBounds(boundingBox.minX - extra[4], boundingBox.minY - extra[0], boundingBox.minZ - extra[2], boundingBox.maxX + extra[5], boundingBox.maxY + extra[1], boundingBox.maxZ + extra[3]);
        return boundingBox;
}


    public static boolean CanLaserPass(World world, int x, int y, int z, LaserInstance laser){
        Block block = world.getBlock(x, y, z);
        int blockMeta = world.getBlockMetadata(x,y,z);

        if(world.getTileEntity(x,y,z) != null){
            if(world.getTileEntity(x,y,z) instanceof ILaserReciver){
                ILaserReciver ii = (ILaserReciver)world.getTileEntity(x,y,z);

                return ii.CanLaserPass(laser, ForgeDirection.getOrientation(laser.side));
            }else{
                return false;
            }

        }else{

            return !block.isOpaqueCube() && !block.hasTileEntity(blockMeta);
        }


    }

    public static ArrayList<Entity> EntitiesInLaser(LaserInstance instance){
        ArrayList<Entity> List = new ArrayList<Entity>();

        ForgeDirection dir = ForgeDirection.getOrientation( getOrientation(instance.side));
        double offsetMax = 0.5D + LASER_SIZE / 2;

        for(int distance = 1; distance <= instance.strength; distance++) {
            int xTemp = (int) instance.Position.x + dir.offsetX * (distance - 1);
            int yTemp = (int) instance.Position.y + dir.offsetY * (distance - 1);
            int zTemp = (int) instance.Position.z + dir.offsetZ * (distance - 1);

            //Add offset for entities
            AxisAlignedBB aabb = AxisAlignedBB.getBoundingBox(xTemp, yTemp, zTemp, xTemp + offsetMax, yTemp + offsetMax, zTemp + offsetMax);
            List ents = instance.world.getEntitiesWithinAABB(Entity.class, aabb);

            if (ents.size() > 0) {
                for(int i = 0; i < ents.size(); i++){
                    List.add((Entity)ents.get(i));
                }

            }
            }


            return List;
        }

    public static double GetLensPowerUsaeg(int Power, double Strength, boolean Damage, boolean TransferPower, boolean Redstone){

        return (((Power) * 3) + ((Strength / 4))) + (Damage ? 5 : 0) + (TransferPower ? 10 : 0) + (Redstone ? 1 : 0);
    }

}