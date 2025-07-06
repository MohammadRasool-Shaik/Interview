package org.rash.threads;

import java.util.ArrayList;
import java.util.List;

public class ThreadSafe implements Runnable {

    List<Integer> employees = new ArrayList<Integer>();

    public ThreadSafe() {
        for (int i = 1; i < 20; i++) {
            employees.add(i);
        }
    }

    public void removeEmployee() {
        for (int i = 2; i < 10; i++) {
            try {
                System.out.println(Thread.currentThread().getName() + " Remove" + i);
                employees.remove(i);
                Thread.sleep(100);
            } catch (InterruptedException ie) {
                System.out.println("Eroor");
            }
        }
    }

    public void fetchEmployee() {
        for (int i = 4; i < 20; i++) {
            try {
                System.out.println(Thread.currentThread().getName() + i + " Read " + employees.get(i));
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                System.out.println("Eroor");
            }
        }
    }

    /**
     * @param threadName
     */

    public void run() {
        if (Thread.currentThread().getName().equalsIgnoreCase("First Thread")) {
            fetchEmployee();
        } else {
            removeEmployee();
        }
    }
}
