/**
 * 
 */
package org.rash.threads;

/**
 * @author Ammi
 */
public class Bus implements Runnable {
	int totalSeats;

	public Bus(int seats) {
		this.totalSeats = seats;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		Thread currentThread = Thread.currentThread();
		int seatsNeeded = ((Passenger) currentThread).getSeatsNeeded();
		String name = currentThread.getName();

		if (bookTicket(name, seatsNeeded)) {
			System.out.println("Congratulations mr " + name);
		} else {
			System.out.println("bad luck mr " + name);
		}
	}

	/**
	 * @param name
	 * @param seatsNeeded
	 */
	private boolean bookTicket(String name, int seatsNeeded) {
		System.out.println("welcome to APSRTS Mr. " + name);
		if (seatsNeeded > totalSeats) {
			return false;
		} else {
			totalSeats = totalSeats - seatsNeeded;
			return true;
		}
	}

	public static void main(String arg[]) {
		Bus bus = new Bus(2);
		Passenger p1 = new Passenger("p1", bus, 2);
		Passenger p2 = new Passenger("p2", bus, 2);

		p1.start();
		p2.start();
	}
}
