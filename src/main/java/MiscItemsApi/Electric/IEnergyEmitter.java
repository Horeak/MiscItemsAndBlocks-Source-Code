package MiscItemsApi.Electric;

public interface IEnergyEmitter {

    public abstract void OnSendEnergy(PowerPacket packet);
    public abstract void SentEnergySuccessfully(PowerPacket packet);
}
