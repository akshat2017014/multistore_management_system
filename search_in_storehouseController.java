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

public class search_in_storehouseController {
	private storehouse_administrator s;
	@FXML
	private ListView<String> listcat; 
	@FXML
	private TextField f;
	@FXML 
	private TextField ftemp;
	private ListView<String> listproduct;
	private String root="root";
	private ArrayList<String> cat=new ArrayList<String>();
	public void browse() {
		String res=ftemp.getText();
		ArrayList<storehouse> tt=system1.superstore.getStorehouses();
		for(storehouse ss:tt) {
			if(ss.getName().equals(res)) {
				this.s=ss.getStorehouseadministrator();
				break;
			}
		}
		
		cat.add("root");
		ArrayList<String> waaa=s.getStorehouse().getCategories().get(root);
		for(String str:waaa)
		{	if(s.getStorehouse().getMap2().containsKey(str))
		{
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
		ArrayList<String> waaa=s.getStorehouse().getCategories().get(root);
		for(String str:waaa)
		{	if(s.getStorehouse().getMap2().containsKey(str))
		{
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
		root=f.getText();
		cat.add(root);
		f.setText("");
		write_categories();
	}
	public void back(ActionEvent event) {
		try {
			        
		        	
				    
		        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SuperStore (1).fxml"));
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
