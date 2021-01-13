package main.java.eletra.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.products.apirest.models.Products;
import com.products.apirest.resources.URLConnection1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TitledPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import main.java.eletra.Main;
 
	public class InterfaceController {
	URLConnection1 urlConnecta = new URLConnection1();

	@FXML
    private TitledPane tpaneLine;

    @FXML
    private ComboBox<String> comboBoxLine;

    @FXML
    private TitledPane tpaneModel;

    @FXML
    private TreeView<String> modelTree;
    
    @FXML
    private Button updateButton;

    @SuppressWarnings("unused")
	private Main main;
    
	
	public void setMain(Main main) {
    	this.main = main;
    }
	
	private List<Products> listProd = new ArrayList<Products>();
	private ObservableList<String> lines = FXCollections.observableArrayList();	
	
    @FXML
    private void updateDatabase(ActionEvent event) throws IOException {
		tpaneLine.setExpanded(false);
    	comboBoxLine.getSelectionModel().select(null);
    	loadLine();
    }
	
	private void loadLine() throws IOException {
		tpaneModel.setExpanded(false);;
		tpaneModel.setDisable(true);
		listProd = URLConnection1.sendGET();
		
	for(Products temp : listProd) {
		if(lines.contains(temp.getLine())) {
		}
		else {
			String box = temp.getLine();
			lines.add(box);
		}
	}
	 
	comboBoxLine.setItems(lines);
 	} 

 
    @FXML
    private void initialize() throws IOException {
    	loadLine();
    	
    }
 	
    
    @FXML
    void loadModel(ActionEvent event) { 
    	
    	ObservableList<String> catgs = FXCollections.observableArrayList();
		TreeItem<String> rootitem = new TreeItem<String> (comboBoxLine.getSelectionModel().getSelectedItem());
		modelTree.setRoot(rootitem);

		for(Products temp : listProd) {			
			if(temp.getLine().equals(comboBoxLine.getSelectionModel().getSelectedItem())) {
				if(!catgs.contains(temp.getCategory())) {
					String tree = temp.getCategory();
					catgs.add(tree);
				}
			}
		}

		for(String c : catgs) {
			TreeItem<String> treeitem = new TreeItem<String>(c);
			rootitem.getChildren().add(treeitem);
			for(Products temps : listProd) {
				if(temps.getLine().equals(comboBoxLine.getSelectionModel().getSelectedItem())) {
					if(temps.getCategory().equals(c)) {
						TreeItem<String> treebranch = new TreeItem<String>(temps.getModel());
						treeitem.getChildren().add(treebranch);
					}
				}
			}
		}
		
		tpaneModel.setDisable(false);  	
    } 
    
}
