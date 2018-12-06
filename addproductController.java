package application;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.ArrayList;

import javafx.event.*;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
/**
 * 
 * @author yatinarora
 * 
 * It controls the addproduct of the addproduct java fxml file
 * basically used to add product to warehouse and storehouse
 * 
 *
 */
public class addproductController {
	
	private warehouse_administrator w=WarehouseloginAdmincontroller.w;
	@FXML
	private ListView<String> listcat; 
	@FXML
	private TextField f1;
	@FXML
	private TextField f2;
	@FXML
	private TextField id;
	@FXML
	private TextField price;
	@FXML
	private TextField H;
	@FXML
	private TextField D;
	@FXML
	private TextField K;
	@FXML
	private TextField stock;
	@FXML
	private TextField name;
	private String root="root";
	private ArrayList<String> cat=new ArrayList<String>();
	/**
	 * Browses through the categories
	 */
	public void browse() {
		cat.add("root");
		ArrayList<String> waaa=w.getWarehouse().getCategories().get(root);
		for(String str:waaa)
		{	if(w.getWarehouse().getMap2().containsKey(str))
		{
			f2.setText("add product");
			break;
		}
		else {	
		this.listcat.getItems().add(str);}
		}
		if(waaa.size()==0) {
			f2.setText("add product");
		}
	}
	/**
	 * Adds product to the categories
	 */
	public void write_categories() {
		this.listcat.getItems().clear();
		ArrayList<String> waaa=w.getWarehouse().getCategories().get(root);
		for(String str:waaa)
		{	if(w.getWarehouse().getMap2().containsKey(str))
		{f2.setText("add product");
		break;
		}
		else {	
		this.listcat.getItems().add(str);}
		}
		if(waaa.size()==0) {
			f2.setText("add product");
		}
	}
	/**
	 * updating the root categories
	 */
	public void updateroot() {
		root=f1.getText();
		cat.add(root);
		f1.setText("");
		write_categories();
	}
	/**
	 * 
	 * @param event
	 * adds product when clicked 
	 */
	public void add(ActionEvent event) {

		String temp=name.getText();
		cat.add(temp);
		w.addProduct(cat.toArray(new String[cat.size()]),new product(name.getText(), Integer.parseInt(id.getText()), Integer.parseInt(price.getText()), Integer.parseInt(stock.getText()),Integer.parseInt(D.getText()), Integer.parseInt(H.getText()),Integer.parseInt(K.getText())));
		try {
	        
        	
		    
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("WareHouse.fxml"));
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
	/**
	 * goes back to warehouse
	 * 
	 * @param event
	 */
	public void back(ActionEvent event) {
		try {
			        
		        	
				    
		        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("WareHouse.fxml"));
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
}
