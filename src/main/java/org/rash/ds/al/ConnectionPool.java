/**
 * 
 */
package org.rash.ds.al;

/**
 * @author Admin
 */
public class ConnectionPool {

	private static final int MAX = 2;

	private static int counter = 0;

	private static ConnectionPool myPool;

	private ConnectionPool() {

	}

	public static ConnectionPool getInstance() {

		if (counter <= MAX) {
			myPool = new ConnectionPool();
			counter++;
		}
		return myPool;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#finalize()
	 */
	@Override
	public void finalize() throws Throwable {
		counter--;
		super.finalize();
	}

	public static void main(String[] args) {
		ConnectionPool instance = ConnectionPool.getInstance();
		ConnectionPool instance1 = ConnectionPool.getInstance();
		ConnectionPool instance2 = ConnectionPool.getInstance();
		ConnectionPool instance3 = ConnectionPool.getInstance();
		ConnectionPool instance4 = ConnectionPool.getInstance();
		ConnectionPool instance5 = ConnectionPool.getInstance();

	}

}
