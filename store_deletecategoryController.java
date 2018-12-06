package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * its a controller class
 * Deletes categories 
 * @author yatinarora
 *
 */
public class store_deletecategoryController {
	/**
	 * new categories are added to root 
	 */
	private String root="root";
	private ArrayList<String> cat=new ArrayList<String>();
	private storehouse_administrator s=StoreHouseLoginController.s;
	@FXML
	private TextField f;
	@FXML
	private TextField f1;
	@FXML
	private ListView<String> listcat; 
	/**
	 * Browses categories
	 */
	public void browse() {
		cat.add("root");
		ArrayList<String> waaa=s.getStorehouse().getCategories().get(root);
		for(String str:waaa)
		{if(s.getStorehouse().getMap2().containsKey(str)) {
			f1.setText("no more categories");
			break;
		}
		else {
		this.listcat.getItems().add(str);}}
	}
	/**
	 * Writes categories
	 */
	public void write_categories() {
		this.listcat.getItems().clear();
		ArrayList<String> waaa=s.getStorehouse().getCategories().get(root);
		for(String str:waaa)
		{if(s.getStorehouse().getMap2().containsKey(str)) {
			f1.setText("no more categories");
			break;
		}
		else {
		this.listcat.getItems().add(str);}}
	}
	/*
	 * fn to go to next  category
	 */
	public void nextcategory() {
		root=f.getText();
		cat.add(root);
		f.setText("");
		write_categories();
	}
	/**
	 * used to delete category once when clicked
	 * @param event
	 */
	public void deletecategory(ActionEvent event) {
		root=f.getText();
		cat.add(root);
		s.deleteCategory(cat.toArray(new String[cat.size()]));
try {
	        
        	
		    
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("StoreHouse.fxml"));
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
	        
        	
		    
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("StoreHouse.fxml"));
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
