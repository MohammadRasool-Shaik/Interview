/**
 *
 */
package org.rash.marker;

/**
 * @author Ammi
 */

public class Order implements Cloneable {
    private int oid;
    private String oname;

    /**
     * @return the oid
     */
    public int getOid() {
        return oid;
    }

    /**
     * @param oid
     *            the oid to set
     */
    public void setOid(int oid) {
        this.oid = oid;
    }

    /**
     * @return the oname
     */
    public String getOname() {
        return oname;
    }

    /**
     * @param oname
     *            the oname to set
     */
    public void setOname(String oname) {
        this.oname = oname;
    }

    @Override
    public String toString() {
        return this.getOid() + " " + this.getOname();
    }

    @Override
    public Order clone() throws CloneNotSupportedException {
        return (Order) super.clone();
    }
}
