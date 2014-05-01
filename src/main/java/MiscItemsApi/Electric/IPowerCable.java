package MiscItemsApi.Electric;


public interface IPowerCable{


    public int GetPower();
    public int GetMaxPower();

    public void SetMaxPower(int i);

    public void SetPower(int Amount);
    public void AddPower(int Amount);

}
