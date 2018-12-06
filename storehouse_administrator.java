package application;

import java.io.Serializable;
/**
 * Storehouse admin class
 * @author yatinarora
 *
 */
public class storehouse_administrator implements Serializable{
	/**
	 * Getter setter functions
	 * @return
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public storehouse getStorehouse() {
		return storehouse;
	}
	public void setStorehouse(storehouse storehouse) {
		this.storehouse = storehouse;
	}
	/**
	 * name of admmin
	 */
	private  String name;
	private int id;
	private String password;
	private storehouse storehouse;
	storehouse_administrator(storehouse h,String name,int id,String password){
		this.storehouse=h;
		this.name=name;
		this.id=id;
		this.password=password;
	}
	/**
	 * Checks if the password entered is correct or not
	 * @param id admin id
	 * @param p password
	 * @return
	 */
	public boolean check_credentials(int id,String p) {
		if(this.id==id && this.password.equals(p)) {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * Adds category
	 * @param path
	 */
	public void addCategory(String[] path) {
		if(storehouse.getWarehouse().search(path)==true) {
			storehouse.insert(path,null);
		}
		else {
			System.out.println("category does not exist in the warehouse");
		}
	}
	/**
	 * Selects products from the path
	 * @param path
	 * @param pro
	 */
	public void select_product(String[] path,product pro) {
		if(storehouse.getWarehouse().search(path)) {
			
		storehouse.insert(path, pro);
		storehouse.ask_products();
		}
		else {
			System.out.println("product does not exist in the warehouse");
		}
	}
	/**
	 * Deletes pproduct;
	 * @param path
	 */
	public void deleteProduct(String[] path) {
		storehouse.deletecategory(path);
	}
	public void deleteCategory(String[] path) {
		storehouse.deletecategory(path);
	}
	public void modifyProduct(String name,int id,int price,int D,int H,int K) {
		storehouse.modify(name, id, price, D, H, K);
		storehouse.ask_products();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
