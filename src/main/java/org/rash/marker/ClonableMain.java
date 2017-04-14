/**
 * 
 */
package org.rash.marker;

/**
 * @author Ammi
 */
public class ClonableMain {

	/*
	 * In your custom class, must override clone method 
	 * 
	 * Your custom class should implement Cloneable Marker interface otherwise you will get CloneNotSupportedException
	 * 
	 * Clone method in Object class just know how to copy primitive members of your class it doesn't know about Custom types 
	 * 
	 * If, in your class have any dependency or has a relationship with other class Object, then
	 * when you call clone method it just copy reference or address object and assign to the cloneable object. So both cloneable 
	 * and current both point to the same Object. 
	 * 
	 * So in this case you have to manually copy the el
	 * 
	 */
	public static void main(String args[]) throws CloneNotSupportedException {

		Order order = new Order();
		order.setOid(1);
		order.setOname("myCar");

		Customer cust = new Customer();
		cust.setCid(1);
		cust.setcName("Rasool");
		cust.setOrder(order);

		Customer clone = cust.clone();
		clone.setCid(8);
		clone.getOrder().setOid(9);

		System.out.println(cust);
		System.out.println(clone);

	}

}
