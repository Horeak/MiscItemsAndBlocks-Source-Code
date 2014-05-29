package MiscItemsApi.Electric;


public interface IPowerCable{


    /** Gets the current power amount from the calbe
     *
     * @return the amount of power stored
     */
    public int GetPower();

    /** Gets the max amount of power the cable can store
     *
     * @return the max amount of power that can be stored
     */
    public int GetMaxPower();

    /** Sets the max amount of power that can be stored in the cable
     *
     * @param i max amount of power
     */
    public void SetMaxPower(int i);

    /** Sets the current amount of power in the cable
     *
     * @param Amount the amount of power
     */
    public void SetPower(int Amount);

    /** Adds power to the cable
     *
     * @param Amount the amount of power to add
     */
    public void AddPower(int Amount);

}
