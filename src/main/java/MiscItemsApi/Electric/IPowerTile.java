package MiscItemsApi.Electric;

public interface IPowerTile {


    /** Gets the current amount of power stored
     *
     * @return the amount of power
     */
	public int GetPower();

    /** Gets the current max amount of power that can be stored
     *
     * @return the max amount of power
     */
	public int GetMaxPower();

    /** Sets the max amount of power that can be stored
     *
     * @param i the amount of power
     */
	public void SetMaxPower(int i);

    /** Sets the current amount of power stored
     *
     * @param Amount the amount of power
     */
	public void SetPower(int Amount);

    /** Adds power to the current amount
     *
     * @param Amount the amount to add
     */
	public void AddPower(int Amount);

    /** Decides if the machine accepts power from other sources
     *
     * @return accepts power
     */
	public boolean AcceptsPower();

    /** Decides if the machine can connect to cables
     *
     * @return connects to cables
     */
	public boolean ConnectsToCables();
	
	
}
