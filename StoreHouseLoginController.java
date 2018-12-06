package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.util.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.ListView;
import java.io.Serializable;
import java.lang.*;
import java.math.*;
/**
 * Controller class for storehouse login 
 * @author yatinarora
 *
 */
public class StoreHouseLoginController {
    /**
     * Textfields defined in fxml file
     */
	@FXML private TextField tf1;
	@FXML private TextField tf2;
	static storehouse_administrator s=null;
	/**
     * Exits the Program
     * @param event
     */
	public void exit(ActionEvent event)throws Exception
	{
		System.exit(0);
		system1.serialize();
	}
	
	/**
     * Opens store house fxml file (GUI)
     * @param event
     * @throws Exception
     */
	public void openStorehouse(ActionEvent event) throws Exception {               
        try {
        	
        	String id1 = tf1.getText();
        	int id = Integer.parseInt(id1);
        	String password = tf2.getText();
        	boolean check=false;
			ArrayList<storehouse> shh=system1.superstore.getStorehouses();
			for(storehouse temp:shh) {
				if(temp.check_credentials(id, password)) {
					check=true;
					this.s=temp.getStorehouseadministrator();
				}
			}
			System.out.println(check);
			System.out.println(s!=null);
        	if(check)
        	{
        
        		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("StoreHouse.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.close();
                stage.setScene(new Scene(root1));  
                ((Node)(event.getSource())).getScene().getWindow().hide();
                stage.show();}
        	else
        	{
        		
        		tf2.setStyle("-fx-border-color: #ff0000");
        	}
        	}
        
        catch(Exception e) {
           e.printStackTrace();
          
        }
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
	
}
