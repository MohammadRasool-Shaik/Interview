/**
 * 
 */
package org.rash.marker;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * @author Ammi
 */
public class SerializationExample implements Serializable {
	private static SerializationExample s_instance = null;

	public static synchronized SerializationExample getInstance() {
		if (s_instance == null) {
			s_instance = new SerializationExample();
		}
		return s_instance;
	}

	private SerializationExample() {
		// initialize
	}

	private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
		ois.defaultReadObject();
		synchronized (SerializationExample.class) {
			if (s_instance == null) {
				// re-initialize if needed

				s_instance = this; // only if everything succeeds
			}
		}
	}

	// this function must not be called other than by the deserialization
	// runtime
	private Object readResolve() throws ObjectStreamException {
		assert (s_instance != null);
		return s_instance;
	}

	public static void main(String[] args) {
		assert (getInstance() == getInstance());

		java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
		java.io.ObjectOutputStream oos = null;
		try {
			oos = new java.io.ObjectOutputStream(baos);
			oos.writeObject(getInstance());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		java.io.InputStream is = new java.io.ByteArrayInputStream(baos.toByteArray());
		ObjectInputStream ois=null;
		try {
			ois = new ObjectInputStream(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SerializationExample s;
		try {
			s = (SerializationExample) ois.readObject();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
}