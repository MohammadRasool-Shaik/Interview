/**
 *
 */
package org.rash.marker;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author Ammi
 */
public class Serilization {

    public static void main(String args[]) {
        MySerilization ms = new MySerilization();

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("temp.ser");

            oos = new ObjectOutputStream(fos);
            oos.writeObject(ms);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

class MySerilization implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -3346288539105303514L;

    private int sid;

    private String sname;

    /**
     * @return the serialversionuid
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    /**
     * @return the sid
     */
    public int getSid() {
        return sid;
    }

    /**
     * @param sid
     *            the sid to set
     */
    public void setSid(int sid) {
        this.sid = sid;
    }

    /**
     * @return the sname
     */
    public String getSname() {
        return sname;
    }

    /**
     * @param sname
     *            the sname to set
     */
    public void setSname(String sname) {
        this.sname = sname;
    }

}
