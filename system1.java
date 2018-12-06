package application;

import java.io.Serializable;
import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * System class initializing all the variables
 * @author yatinarora
 *
 */
public class system1 implements Serializable{
	
	public static Object out;
	/**
	 * main superstore
	 */
	public static super_store superstore;
	/**
	 * End user when logged in
	 */
	public static end_user enduser;
	/**
	 * Serializing 
	 * @throws IOException
	 */
	public static void serialize()	throws	IOException	{	
		ObjectOutputStream out	=	null;	
		try	{	
					out	=	new	ObjectOutputStream	(	
											new FileOutputStream("out_customer.txt"));	
					out.writeObject(superstore);	
		}	finally	{	
					out.close();	
		}
}

public static void deserialize()throws	IOException,	ClassNotFoundException {	
					ObjectInputStream in=null;	
					try	{	
									in=	new	ObjectInputStream	(	
																new	FileInputStream("out_customer.txt"));	
							superstore=	(super_store)in.readObject();													
					}
					catch(IOException e) {
						System.out.println("You don't have any saved data");
					}
					
}
	
	public static void main(String[] args) throws IOException,ClassNotFoundException{
		// TODO Auto-generated method stub
		
		
	}

}
