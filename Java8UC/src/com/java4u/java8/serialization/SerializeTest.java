/**
 * 
 */
package com.java4u.java8.serialization;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.OutputStream;
import java.io.Serializable;

/**
 * @author Bharath
 *
 */

class SingletonClass implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private static SingletonClass INSTANCE = null;
    private int i=10;
    //method returns instance of Singleton class.
    public static SingletonClass getInstance() {
        if (INSTANCE == null) {
           synchronized (SingletonClass.class) {
                  INSTANCE = new SingletonClass();
                  }         
        }
        return INSTANCE;
    }
 
    //constructor
    private SingletonClass() {}
 
    /**
     *customize Serialization process.
     */
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
       System.out.println("in readObject()");
           ois.defaultReadObject();
        synchronized (SingletonClass.class) {
         if (INSTANCE == null) {
               INSTANCE = this;
         }
        }
    }
 
    /**
     * Method ensures that we don't break singleton pattern during DeSerialization process- method must not be called other than DeSerialization time.
     */
    private Object readResolve() throws ObjectStreamException {
       System.out.println("in readResolve()");
       return INSTANCE;
    }
} 

class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;

	public Employee(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}

}

public class SerializeTest {

	public void serialize(Serializable obj) {
	    

         try {
                OutputStream fout = new FileOutputStream("ser.txt");
                ObjectOutput oout = new ObjectOutputStream(fout);
                System.out.println("Serialization process has started, serializing employee objects...");
                oout.writeObject(obj);
                  oout.close();
                System.out.println("Object Serialization completed.");
                
         } catch (IOException ioe) {
                ioe.printStackTrace();
         }

  }
	

	public Serializable deSerialize() {
		  InputStream fin;
		  Serializable emp = null;
          try {
                 fin = new FileInputStream("ser.txt");
                 ObjectInput oin = new ObjectInputStream(fin);

                 System.out.println("DeSerialization process has started, "
                              + "displaying employee objects...");
                 emp = (Serializable) oin.readObject(); 
                 oin.close();
                
          } catch (EOFException e) {
                 System.out.println("File ended");
          }  catch (FileNotFoundException e) {
                 e.printStackTrace();
          } catch (IOException e) {
                 e.printStackTrace();
          } catch (ClassNotFoundException e) {
                 e.printStackTrace();
          }
          System.out.println("Object DeSerialization completed.");
          return emp;
      

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Employee employee = new Employee(1, "amy");
		 SingletonClass singClass = SingletonClass.getInstance();
         SerializeTest test = new SerializeTest();
         test.serialize(singClass);
         SingletonClass empDes = (SingletonClass)test.deSerialize();
System.out.println("point check ---->"+(singClass==empDes));
	}

}
