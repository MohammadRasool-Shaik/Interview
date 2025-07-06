/**
 *
 */
package org.rash.inheritance;

/**
 * @author Ammi
 */
public class TestInheritance {

    public static void main(String arg[]) {
        One t = new Two();

        System.out.println(t);
    }
}

class One extends Object {
    protected void methodOne() {

    }

    @Override
    public String toString() {
        return "One";
    }


}

class Two extends One {
    public void methodOne() {

    }

    @Override
    public String toString() {
        return "two";
    }


    public void test() {
    }
}
