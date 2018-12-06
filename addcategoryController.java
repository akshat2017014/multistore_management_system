package application;

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
 * Controls the add category  of java fxml file
 *  
 * textfields are given unique id
 *
 */
public class addcategoryController {
	private String root="root";
	private ArrayList<String> cat=new ArrayList<String>();
	private warehouse_administrator w=WarehouseloginAdmincontroller.w;
	@FXML
	private TextField f1;
	@FXML
	private TextField f2;
	@FXML
	private ListView<String> listcat;
	/**
	 * It is used to browse through the current categories
	 */
	public void browse() {
		
		cat.add("root");
		ArrayList<String> waaa=w.getWarehouse().getCategories().get(root);
		for(String str:waaa)
		{
		this.listcat.getItems().add(str);}
	}
	/**
	 * It is used for writing categories 
	 * 
	 */
	public void write_categories() {
		this.listcat.getItems().clear();
		ArrayList<String> waaa=w.getWarehouse().getCategories().get(root);
		for(String str:waaa)
		{
		this.listcat.getItems().add(str);}
	}
	/**
	 * It is used for going to next category from the current one
	 */
	public void nextcategory() {
		root=f1.getText();
		cat.add(root);
		f1.setText("");
		f2.setText("");
		f1.setText("");
		write_categories();
	}
	/**
	 * Adds category
	 */
	public void addcategory() {
		System.out.println("t");
		String temp=f2.getText();
		cat.add(temp);
		this.listcat.getItems().clear();
		this.listcat.getItems().add(temp);
		f2.setText("");
		f1.setText("");
	}
	/**
	 * 
	 * @param event
	 * goes back to warehouse
	 */
	public void back(ActionEvent event) {
		
		w.addCategory(cat.toArray(new String[cat.size()]));
		String[] arr=cat.toArray(new String[cat.size()]);
		for(int i=0;i<cat.size();i++) {
			System.out.println(arr[i]);
		}
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
