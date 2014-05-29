
package MiscItemsApi.Electric;

public interface IPowerGeneration {


    /** Gets the amount of power that is generated each tick
     *
     * @return the amount of power generated
     */
	public int GeneratedPower();

    /** Sets the amount of power that should be generated each tick
     *
     * @param i the amount of power
     */
	public void SetGeneratedPower(int i);
	
}
