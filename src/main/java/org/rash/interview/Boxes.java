/**
 *
 */
package org.rash.interview;

/**
 * @author Admin
 */
public class Boxes {
    public static int minimalNumberOfBoxes(int products, int availableLargeBoxes, int availableSmallBoxes) {
        int maxprs = availableLargeBoxes * 5 + availableSmallBoxes * 1;
        if (products <= maxprs) {
            int t = (availableLargeBoxes * 5) - products;
            if (t < availableSmallBoxes) {
                t += products - availableSmallBoxes;
            }
            return t;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(minimalNumberOfBoxes(12, 3, 3));
    }
}
