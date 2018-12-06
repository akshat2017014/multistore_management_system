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
 * Its a controller class used by addproduct .fxml
 * Adds product to warehouse and stoerhouse accordingly 
 * @author yatinarora
 *
 */
public class store_addproductController {
	private storehouse_administrator s=StoreHouseLoginController.s;
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
	 * Browses through all the categories
	 */
	public void browse() {
		cat.add("root");
		ArrayList<String> waaa=s.getStorehouse().getCategories().get(root);
		for(String str:waaa)
		{	if(s.getStorehouse().getMap2().containsKey(str))
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
	 * Writes to the categories
	 */
	public void write_categories() {
		this.listcat.getItems().clear();
		ArrayList<String> waaa=s.getStorehouse().getCategories().get(root);
		for(String str:waaa)
		{	if(s.getStorehouse().getMap2().containsKey(str))
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
	 * updates root
	 */
	public void updateroot() {
		root=f1.getText();
		cat.add(root);
		f1.setText("");
		write_categories();
	}
	/**
	 * adds products
	 * @param event
	 */
	public void add(ActionEvent event) {

		String temp=name.getText();
		cat.add(temp);
		s.select_product(cat.toArray(new String[cat.size()]),new product(name.getText(), Integer.parseInt(id.getText()), Integer.parseInt(price.getText()), 0,Integer.parseInt(D.getText()), Integer.parseInt(H.getText()),Integer.parseInt(K.getText())));
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
