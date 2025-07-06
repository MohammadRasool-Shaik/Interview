/**
 *
 */
package org.rash.threads;

/**
 * @author Ammi
 *
 */
public class MultiThreadRoadRashDemo implements Runnable {
    private static String winner;

    public static void main(String arg[]) {
        Thread t = new Thread(new MultiThreadRoadRashDemo(), "Mara");
        t.start();
        Thread t1 = new Thread(new MultiThreadRoadRashDemo(), " Mari");
        t1.start();
    }

    @Override
    public void run() {
        race();
    }

    private void race() {
        for (int i = 1; i <= 1000; i++) {
            try {
                System.out.println(Thread.currentThread().getName() + " Traveled " + i + " Meters");
                if (isAnyOneWon(i)) {
                    break;
                }
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }

    private boolean isAnyOneWon(int totalDistanceTravelled) {
        if (winner == null && totalDistanceTravelled == 100) {
            winner = Thread.currentThread().getName();
            System.out.println(winner + "\t won");
            return true;
        } else if (winner != null) {
            return true;
        }
        return false;
    }
}
