/**
 *
 */
package org.rash.marker;

import org.rash.inheritance.ParentMine;

/**
 * @author Ammi
 */

class Test {
    private String temp;

    /**
     * @return the temp
     */
    public String getTemp() {
        return temp;
    }

    /**
     * @param temp
     *            the temp to set
     */
    public void setTemp(String temp) {
        this.temp = temp;
    }

}

class Parent implements Cloneable {
    public String two;
    private String one;
    private ParentMine test;

    public Parent() {
        System.out.println("parent");
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void print() {

    }

    /**
     * @return the one
     */
    public String getOne() {
        return one;
    }

    /**
     * @param one
     *            the one to set
     */
    public void setOne(String one) {
        this.one = one;
    }

}

class Child extends Parent {

    public Child() {

    }

    public Child(String str) {
        System.out.println("Child" + two);
    }

    public void print() {

    }

    /**
     * @return the two
     */
    public String getTwo() {
        return two;
    }

    /**
     * @param two
     *            the two to set
     */
    public void setTwo(String two) {
        this.two = two;
    }

}

public class Temp extends Child {
    private String three;
    private String one;

    public static void main(String arg[]) throws CloneNotSupportedException {
        // new SubChild("temp");

        Parent p = new Parent();
        p.clone();

        Temp t = new Temp();
        System.out.println(t.one);
    }

    public void print() {
    }

    /**
     * @return the three
     */
    public String getThree() {
        return three;
    }

    /**
     * @param three
     *            the three to set
     */
    public void setThree(String three) {
        this.three = three;
    }

}

class toi {

    public Parent test() {
        return null;
    }

    public void test(int a) {

    }

    private int test(int a, int b) {
        return 2;
    }

    private void test(String a) {

    }

    protected Number temp() throws ArrayIndexOutOfBoundsException {
        return null;
    }

}

class tiss extends toi {
    @Override
    protected Double temp() throws RuntimeException {
        return null;
    }

    public Child test() {

        return null;
    }

    @Override
    protected Object clone() {
        return null;
    }

    @Override
    public String toString() {
        return "test";
    }

}




