package application;

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
 *Deletes category
 */
public class deletecategorycontroller {
	
	private String root="root";
	private ArrayList<String> cat=new ArrayList<String>();
	private warehouse_administrator w=WarehouseloginAdmincontroller.w;
	@FXML
	private TextField f;
	@FXML
	private TextField f1;
	@FXML
	private ListView<String> listcat; 
	/**
	 * browses through the categories
	 */
	public void browse() {
		cat.add("root");
		ArrayList<String> waaa=w.getWarehouse().getCategories().get(root);
		for(String str:waaa)
		{if(w.getWarehouse().getMap2().containsKey(str)) {
			f1.setText("no more categories");
			break;
		}
		else {
		this.listcat.getItems().add(str);}}
	}
	public void write_categories() {
		this.listcat.getItems().clear();
		ArrayList<String> waaa=w.getWarehouse().getCategories().get(root);
		for(String str:waaa)
		{if(w.getWarehouse().getMap2().containsKey(str)) {
			f1.setText("no more categories");
			break;
		}
		else {
		this.listcat.getItems().add(str);}}
	}
	public void nextcategory() {
		root=f.getText();
		cat.add(root);
		f.setText("");
		write_categories();
	}
	/**
	 * selected category is deleted on button clicked
	 * @param event
	 */
	public void deletecategory(ActionEvent event) {
		root=f.getText();
		cat.add(root);
		w.deleteCategory(cat.toArray(new String[cat.size()]));
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
	 * goes back to warehouse on button clicked
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
