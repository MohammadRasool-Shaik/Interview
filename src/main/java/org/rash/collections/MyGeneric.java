/**
 * 
 */
package org.rash.collections;

/**
 * @author mshai9
 *
 */
public class MyGeneric<T extends Number> {

	public Integer sum(T a, T b) {
		return a.intValue() + b.intValue();
	}

	public Integer sub(T a, T b) {
		return a.intValue() - b.intValue();
	}

	public Integer mul(T a, T b) {
		return a.intValue() * b.intValue();
	}

	public Double div(T a, T b) {
		return a.doubleValue() / b.doubleValue();
	}

}
