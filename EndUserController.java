package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
/**
 * Controls the end users fxml class
 * @author yatinarora
 *
 */
public class EndUserController  {
	end_user end=new end_user();
	private storehouse_administrator s;
	@FXML
	private ListView<String> listcat; 
	@FXML
	private ListView<Integer> Quantitylist; 
	@FXML
	private ListView<Integer> pricelist; 
	@FXML
	private TextField f;
	@FXML 
	private TextField ftemp;
	@FXML
	private TextField product_name;
	@FXML
	private TextField quantity;
	@FXML
	private ListView<String> listproduct;
	private String root="root";
	private ArrayList<String> cat=new ArrayList<String>();
	/**
	 * Browses through categories
	 */
	public void browse() {
		String res=ftemp.getText();
		ArrayList<storehouse> tt=system1.superstore.getStorehouses();
		for(storehouse ss:tt) {
			if(ss.getName().equals(res)) {
				this.s=ss.getStorehouseadministrator();
				break;
			}
		}
		cat=new ArrayList<String>();
		cat.add("root");
		ArrayList<String> waaa=s.getStorehouse().getCategories().get(root);
		for(String str:waaa)
		{	if(s.getStorehouse().getMap2().containsKey(str))
		{
		listcat.getItems().clear();
		for(String str1:waaa) {
			this.listproduct.getItems().add(str1);
			this.Quantitylist.getItems().add(s.getStorehouse().getMap2().get(str1).getStock());
			this.pricelist.getItems().add(s.getStorehouse().getMap2().get(str1).getPrice());
		}
		break;
		
		}
		else {	
		this.listcat.getItems().add(str);}
		}
	}
	/**
	 * adds more categories to exisiting ones
	 */
	public void write_categories() {
		this.listcat.getItems().clear();
		ArrayList<String> waaa=s.getStorehouse().getCategories().get(root);
		for(String str:waaa)
		{	if(s.getStorehouse().getMap2().containsKey(str))
		{
			listcat.getItems().clear();
			for(String str1:waaa) {
				this.listproduct.getItems().add(str1);
				this.Quantitylist.getItems().add(s.getStorehouse().getMap2().get(str1).getStock());
				this.pricelist.getItems().add(s.getStorehouse().getMap2().get(str1).getPrice());
			}
			break;
		}
		else {	
		this.listcat.getItems().add(str);}
		}
	}
	/**
	 * changes current category
	 */
	public void updateroot() {
		root=f.getText();
		cat.add(root);
		f.setText("");
		write_categories();
	}
	public void back(ActionEvent event) {
		try {
			        
		        	
				    
		        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainPage.fxml"));
		                Parent root1 = (Parent) fxmlLoader.load();
		                Stage stage = new Stage();
		                stage.close();
		                stage.setScene(new Scene(root1));  
		                ((Node)(event.getSource())).getScene().getWindow().hide();
		                stage.show();
		     
		        } catch(Exception e) {
		           e.printStackTrace();
		          }
			}
	public void add_tocart() {
		this.end.getCart().add(product_name.getText());
		this.end.getQuantity().add(Integer.parseInt(quantity.getText()));
		int ttt=s.getStorehouse().getMap2().get(product_name.getText()).getPrice();
		this.end.getPrice().add(ttt);
		product_name.setText("");
		quantity.setText("");
		listproduct.getItems().clear();
		this.Quantitylist.getItems().clear();
		this.pricelist.getItems().clear();
	}
	public void sort() {
		ArrayList<String> waaa=s.getStorehouse().getCategories().get(root);
		listproduct.getItems().clear();
		this.Quantitylist.getItems().clear();
		this.pricelist.getItems().clear();
		Collections.sort(waaa);
		for(String str1:waaa) {
			this.listproduct.getItems().add(str1);
			this.Quantitylist.getItems().add(s.getStorehouse().getMap2().get(str1).getStock());
			this.pricelist.getItems().add(s.getStorehouse().getMap2().get(str1).getPrice());
		}
	}

}
