package application;
import java.util.ArrayList;


import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
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
 * its a controller class controlling  update product fxml file
 * Updates product 
 * @author yatinarora
 *
 */
public class update_product_controller {
	/**
	 * current warehouse administrator
	 */
	private warehouse_administrator w=WarehouseloginAdmincontroller.w;
	/**
	 * List of categories
	 */
	@FXML
	private ListView<String> listcat; 
	@FXML
	private TextField f1;
	@FXML
	private TextField f2;
	@FXML
	private ListView<String> listproduct; 
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
	 * Browses through categories
	 */
	public void browse() {
		cat.add("root");
		ArrayList<String> waaa=w.getWarehouse().getCategories().get(root);
		for(String str:waaa)
		{	if(w.getWarehouse().getMap2().containsKey(str))
		{f2.setText("select and modify product");
		listcat.getItems().clear();
		for(String str1:waaa) {
			this.listproduct.getItems().add(str1);
		}
		break;
		
		}
		else {	
		this.listcat.getItems().add(str);}
		}
	}
	public void write_categories() {
		this.listcat.getItems().clear();
		ArrayList<String> waaa=w.getWarehouse().getCategories().get(root);
		for(String str:waaa)
		{	if(w.getWarehouse().getMap2().containsKey(str))
		{f2.setText("select and modify product");
			listcat.getItems().clear();
			for(String str1:waaa) {
				this.listproduct.getItems().add(str1);
			}
			break;
		}
		else {	
		this.listcat.getItems().add(str);}
		}
	}
	public void updateroot() {
		root=f1.getText();
		cat.add(root);
		f1.setText("");
		write_categories();
	}
	public void update_product(ActionEvent event) {
		w.modifyProduct(name.getText(), Integer.parseInt(id.getText()), Integer.parseInt(price.getText()), Integer.parseInt(stock.getText()),Integer.parseInt(D.getText()), Integer.parseInt(H.getText()),Integer.parseInt(K.getText()));
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

