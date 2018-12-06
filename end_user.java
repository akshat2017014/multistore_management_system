package application;
import java.util.*;
import java.io.*;
import java.lang.*;
/**
 * Performs end users tasks
 * @author yatinarora
 *
 */
public class end_user implements Serializable{
	/**
	 * Arraylist of cart
	 */
	private ArrayList<String> cart=new ArrayList<>(); 
	private ArrayList<Integer> quantity=new ArrayList<>();
	private ArrayList<Integer> price=new ArrayList<>();
	private storehouse store;
	public void assign_store(storehouse h) {
		this.store=h;
	}
	public ArrayList<String> getCart() {
		return cart;
	}
	public void setCart(ArrayList<String> cart) {
		this.cart = cart;
	}
	public ArrayList<Integer> getQuantity() {
		return quantity;
	}
	public void setQuantity(ArrayList<Integer> quantity) {
		this.quantity = quantity;
	}
	public ArrayList<Integer> getPrice() {
		return price;
	}
	public void setPrice(ArrayList<Integer> price) {
		this.price = price;
	}
	public storehouse getStore() {
		return store;
	}
	public void setStore(storehouse store) {
		this.store = store;
	}
	public void partial_search(String temp) {
		for(product p:store.getMap2().values()) {
			if(p.getName().contains(temp)) {
				System.out.println(p.getName());
			}
		}
	}
	public void add_to_cart(String p) {
		cart.add(p);
	}
	public void checkout() {
		cart=new ArrayList<String>();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	}

}
