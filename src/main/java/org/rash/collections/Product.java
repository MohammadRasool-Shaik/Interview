/**
 * 
 */
package org.rash.collections;

/**
 * @author Ammi
 *
 */
public class Product extends Object implements Comparable<Product> {

	private int pid;
	private String pname;

	/**
	 * @return the pid
	 */
	public int getPid() {
		return pid;
	}

	/**
	 * @param pid
	 *            the pid to set
	 */
	public void setPid(int pid) {
		this.pid = pid;
	}

	/**
	 * @return the pname
	 */
	public String getPname() {
		return pname;
	}

	/**
	 * @param pname
	 *            the pname to set
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		Product p = (Product) obj;
		return p.getPid() == this.getPid() && p.getPname().equals(this.getPname());
	}

	public int hashCode() {
		int hash = 7;

		hash = hash * 31 + this.getPid();

		hash = hash + (this.getPname() == null ? 0 : this.getPname().hashCode());

		return hash;
	}

	public int compareTo(Product p) {

		int t = p.getPname().compareTo(this.getPname());

		if (t == 0) {
			return p.getPid() < this.getPid() ? -1 : p.getPid() > this.getPid() ? 1 : 0;
		}
		return t;

	}

	public void selectionSort(int a[]) {
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++)
				if (a[i] > a[j])
					swapNumbers(a, i, j);
		}
	}

	/*
	 * In Bubble Sort, n-1 comparisons will be done in 1st pass, n-2 in 2nd
	 * pass, n-3 in 3rd pass and so on. So the total number of comparisons will
	 * be (n-1)+(n-2)+(n-3)+.....+3+2+1 Sum = n(n-1)/2 i.e O(n2)
	 */
	public void bubbleSort(int a[]) {
		for (int i = 0; i < a.length; i++) {
			boolean swap = false;
			for (int j = 0; j < a.length - i - 1; j++) {
				if (a[j] > a[j + 1]) {
					swapNumbers(a, j, j + 1);
					swap = true;
				}
			}
			if (swap == false)
				break;
		}
	}

	public static void main(String args[]) {
		/*
		 * Product p = new Product(); int[] a = { 4, 1, 5, 3, 6, 2 };
		 * p.bubbleSort(a); for (int i = 0; i < a.length; i++) {
		 * System.out.println(a[i]); }
		 */

		/*
		 * for (int i = 1; i <= 6; i++) { for (int j = 1; j <= 6; j++) {
		 * System.out.print(j); } System.out.println(); }
		 */

		for (int i = 1, k = 6; i <= 6; i++, k--) {
			for (int j = 1; j <= 6; j++) {
				if (j >= k)
					System.out.print("#");
				else
					System.out.print(" ");

			}
			System.out.println();
		}

	}

	public void swapNumbers(int a[], int i, int j) {
		a[i] = a[i] + a[j];
		a[j] = a[i] - a[j];
		a[i] = a[i] - a[j];
	}

}
