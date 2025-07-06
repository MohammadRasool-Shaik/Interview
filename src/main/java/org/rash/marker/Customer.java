/**
 *
 */
package org.rash.marker;

/**
 * @author Ammi
 */
public class Customer implements Cloneable {

    private int cid;
    private String cName;
    private Order order;

    /**
     * @return the cid
     */
    public int getCid() {
        return cid;
    }

    /**
     * @param cid
     *            the cid to set
     */
    public void setCid(int cid) {
        this.cid = cid;
    }

    /**
     * @return the cName
     */
    public String getcName() {
        return cName;
    }

    /**
     * @param cName
     *            the cName to set
     */
    public void setcName(String cName) {
        this.cName = cName;
    }

    /**
     * @return the order
     */
    public Order getOrder() {
        return order;
    }

    /**
     * @param order
     *            the order to set
     */
    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    protected Customer clone() throws CloneNotSupportedException {
        Customer clone = (Customer) super.clone();
        clone.setOrder(clone.getOrder().clone());
        return clone;
    }

    @Override
    public String toString() {
        return this.getCid() + " " + this.getcName() + " Order Info " + this.getOrder().toString();
    }
}
