/**
 *
 */
package org.rash.inheritance;

/**
 * @author Ammi
 */
public class ChildMine extends ParentMine {
    int salary = 4;

    /**
     * @return the salary
     */
    protected int getSalary() {
        synchronized (this) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("test");
            }
        }
        return 5;
    }


}
