package main.java.eletra.view;

import java.util.ArrayList;
import main.java.eletra.Main;
import eletra.model.Products;
import eletra.model.SystemService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TitledPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
 
	public class InterfaceController {
	SystemService systemService = new SystemService();

	@FXML
    private TitledPane tpaneLine;

    @FXML
    private ComboBox<String> comboBoxLine;

    @FXML
    private TitledPane tpaneModel;

    @FXML
    private TreeView<String> modelTree;

    @SuppressWarnings("unused")
	private Main main;
    
	
	public void setMain(Main main) {
    	this.main = main;
    }
	
	private ArrayList<Products> listProd = new ArrayList<Products>(systemService.findAll());
	private ObservableList<String> lines = FXCollections.observableArrayList();	
	
	private void loadLine() {
		tpaneModel.setDisable(true); 
	 
	for(Products temp : listProd) {
		if(lines.contains(temp.getLinha())) {
		}
		else {
			String box = temp.getLinha();
			lines.add(box);
		}
	}
	 
	comboBoxLine.setItems(lines);
 	} 

 
    @FXML
    private void initialize() {
    	loadLine();
    	
    }
 	
    
    @FXML
    void loadModel(ActionEvent event) { 
    	
    	ObservableList<String> catgs = FXCollections.observableArrayList();
		TreeItem<String> rootitem = new TreeItem<String> (comboBoxLine.getSelectionModel().getSelectedItem());
		modelTree.setRoot(rootitem);
		
		for(Products temp : listProd) {			
			if(temp.getLinha().equals(comboBoxLine.getSelectionModel().getSelectedItem())) {
				if(catgs.contains(temp.getCategoria())) {
				}
				else {
					String tree = temp.getCategoria();
					catgs.add(tree);
				}
			}
		}
		for(String c : catgs) {
			TreeItem<String> treeitem = new TreeItem<String>(c);
			rootitem.getChildren().add(treeitem);
			for(Products temps : listProd) {
				if(temps.getCategoria().equals(c)) {
				TreeItem<String> treebranch = new TreeItem<String>(temps.getModelo());
				treeitem.getChildren().add(treebranch);
				}
			}
		}
    	tpaneModel.setDisable(false);
    }  
	
    
    
}
