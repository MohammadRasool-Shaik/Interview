package org.rash.threads;

public class PassengerThread extends Thread {

    private int seatsNeeded;

    /**
     *
     */
    public PassengerThread() {
        super();
    }

    public PassengerThread(int seats, Runnable target, String name) {
        super(target, name);
        this.seatsNeeded = seats;
    }

    public static void main(String[] ar) throws InterruptedException {
        Thread pt = new Thread();
        pt.start();
        pt.join();
        pt.start();
    }

    public int getSeatsNeeded() {
        return seatsNeeded;
    }

}
