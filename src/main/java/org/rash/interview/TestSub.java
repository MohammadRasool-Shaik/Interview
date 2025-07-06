/**
 *
 */
package org.rash.interview;

import java.io.Serializable;

/**
 * @author mshai9
 *
 */
public class TestSub implements Cloneable, Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -1457786894082392844L;

    static {
        System.out.println("static block");
    }

    private int t;

    {
        System.out.println("instance block");
    }

    /**
     *
     */
	/*public TestSub() {
		System.out.println("subC");
	}*/
    public TestSub(int t) {
        this.t = t;
        System.out.println("subC " + t);
    }

    public TestSub clone() {
        TestSub testSub = null;
        try {
            testSub = (TestSub) super.clone();
            System.out.println("in clone");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return testSub;
    }

    /**
     * @return the t
     */
    public int getT() {
        return t;
    }

    /**
     * @param t
     *            the t to set
     */
    public void setT(int t) {
        this.t = t;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TestSub [t=" + t + "]";
    }


}
