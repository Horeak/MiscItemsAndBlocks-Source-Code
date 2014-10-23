package MiscItemsApi.Electric;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.ForgeDirection;

import javax.vecmath.Vector3d;
import java.util.ArrayList;

public class PowerPacket {

    public double Stored;
    public int LengthTraveled, Timeout;
    public ArrayList<Vector3d> Vectors = new ArrayList<Vector3d>();
    public ForgeDirection SentFrom;
    public boolean Timedout = false;

    public PowerPacket(ForgeDirection from, double Stored, int Timeout){
        this.SentFrom = from;
        this.Stored = Stored;
        this.Timeout = Timeout;

    }

    public void WriteToNBT(NBTTagCompound nbtTagCompound){
        nbtTagCompound.setBoolean("TIMED", Timedout);
        nbtTagCompound.setDouble("Power", Stored);
        nbtTagCompound.setInteger("Length", LengthTraveled);
        nbtTagCompound.setInteger("TimeOut", Timeout);
        nbtTagCompound.setInteger("Dir", SentFrom.ordinal());

    }

    public void LoadFromNBT(NBTTagCompound nbtTagCompound){
        Timedout = nbtTagCompound.getBoolean("TIMED");
        Stored = nbtTagCompound.getDouble("Power");
        LengthTraveled = nbtTagCompound.getInteger("Length");
        Timeout = nbtTagCompound.getInteger("TimeOut");
        SentFrom = ForgeDirection.getOrientation(nbtTagCompound.getInteger("Dir"));


    }

    public void Timeout(){
        Timedout = true;
    }

    public void OnResent(){

        if(Timeout != -1) {
            if (LengthTraveled < Timeout) {
                LengthTraveled += 1;
            } else {
                Timeout();
            }
        }
    }

    public void AddVector(Vector3d vec){
        Vectors.add(vec);
    }

    public void AddVector(int x, int y, int z){
        Vectors.add(new Vector3d(x,y,z));
    }
}
