package application;
import java.util.*;
import java.io.Serializable;
import java.lang.*;
import java.math.*;
/**
 * Super store class 
 * @author yatinarora
 *
 */
public class super_store implements Serializable{
	/**
	 * arraylist of storehouses
	 */
	private ArrayList<storehouse> storehouses=new ArrayList<storehouse>();
	/**
	 * array list of warehouses
	 */
	private ArrayList<warehouse> warehousees=new ArrayList<warehouse>();
	/**
	 * super user with id 123 and pass 123 abc
	 */
	private super_user superuser;
	/**
	 * constructor
	 * @param name
	 * @param id
	 * @param password
	 */
	super_store(String name,int id,String password){
		superuser=new super_user(this,name,id,password);
	}
	/**
	 * Used to check credentials 
	 * @param id
	 * @param password
	 * @return
	 */
	public boolean check_credentials(int id,String password) {
		if(this.getSuperuser().getId()==id && this.getSuperuser().getPassword().equals(password)) {
			return true;
		}
		else {
			return false;
		}
	}
	/*
	 * getter setters
	 *
	 */
	public ArrayList<storehouse> getStorehouses() {
		return storehouses;
	}
	public void setStorehouses(ArrayList<storehouse> storehouses) {
		this.storehouses = storehouses;
	}
	public ArrayList<warehouse> getWarehousees() {
		return warehousees;
	}
	public void setWarehousees(ArrayList<warehouse> warehousees) {
		this.warehousees = warehousees;
	}
	public super_user getSuperuser() {
		return superuser;
	}
	public void setSuperuser(super_user superuser) {
		this.superuser = superuser;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
	}

}
