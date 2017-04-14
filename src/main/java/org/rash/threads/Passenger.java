/**
 * 
 */
package org.rash.threads;

/**
 * @author Ammi
 */
public class Passenger extends Thread {

	private int seatsNeeded;

	public Passenger(String name, Runnable target, int seatsRequired) {
		super(target, name);
		this.seatsNeeded = seatsRequired;
	}

	/**
	 * @return the seatsNeeded
	 */
	public int getSeatsNeeded() {
		return seatsNeeded;
	}

	/**
	 * @param seatsNeeded
	 *            the seatsNeeded to set
	 */
	public void setSeatsNeeded(int seatsNeeded) {
		this.seatsNeeded = seatsNeeded;
	}

}
