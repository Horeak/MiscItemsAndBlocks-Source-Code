package MiscItemsApi.Electric;


public interface IPowerCable{


    /** Gets the current power amount from the calbe
     *
     * @return the amount of power stored
     */
    public double GetPower();

    /** Gets the max amount of power the cable can store
     *
     * @return the max amount of power that can be stored
     */
    public double GetMaxPower();

    /** Sets the max amount of power that can be stored in the cable
     *
     * @param i max amount of power
     */
    public void SetMaxPower(double i);

    /** Sets the current amount of power in the cable
     *
     * @param Amount the amount of power
     */
    public void SetPower(double Amount);

    /** Adds power to the cable
     *
     * @param Amount the amount of power to add
     */
    public void AddPower(double Amount);

}
