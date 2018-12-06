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

public class store_addcategoryController {
	private String root="root";
	private ArrayList<String> cat=new ArrayList<String>();
	private storehouse_administrator s=StoreHouseLoginController.s;
	@FXML
	private TextField f1;
	@FXML
	private TextField f2;
	@FXML
	private ListView<String> listcat; 
	public void browse() {
		
		cat.add("root");
		ArrayList<String> waaa=s.getStorehouse().getCategories().get(root);
		for(String str:waaa)
		{
		this.listcat.getItems().add(str);}
	}
	public void write_categories() {
		this.listcat.getItems().clear();
		ArrayList<String> waaa=s.getStorehouse().getCategories().get(root);
		for(String str:waaa)
		{
		this.listcat.getItems().add(str);}
	}
	public void nextcategory() {
		root=f1.getText();
		cat.add(root);
		f1.setText("");
		f2.setText("");
		f1.setText("");
		write_categories();
	}
	public void addcategory() {
		System.out.println("t");
		String temp=f2.getText();
		cat.add(temp);
		this.listcat.getItems().clear();
		this.listcat.getItems().add(temp);
		f2.setText("");
		f1.setText("");
	}
	public void back(ActionEvent event) {
		
		s.addCategory(cat.toArray(new String[cat.size()]));
		String[] arr=cat.toArray(new String[cat.size()]);
		for(int i=0;i<cat.size();i++) {
			System.out.println(arr[i]);
		}
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
