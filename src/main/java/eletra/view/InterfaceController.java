package main.java.eletra.view;

import java.util.ArrayList;
import java.util.List;

import main.java.eletra.Main;
import eletra.model.Products;
import eletra.model.SystemService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
    void updateDatabase(ActionEvent event) {
    	comboBoxLine.getSelectionModel().select(null);
    	loadLine();
    }
	
	private void loadLine() {
		tpaneLine.setExpanded(false);
		tpaneModel.setExpanded(false);;
		tpaneModel.setDisable(true);
		listProd = systemService.findAll();
		
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
				if(!catgs.contains(temp.getCategoria())) {
					String tree = temp.getCategoria();
					catgs.add(tree);
				}
			}
		}

		for(String c : catgs) {
			TreeItem<String> treeitem = new TreeItem<String>(c);
			rootitem.getChildren().add(treeitem);
			for(Products temps : listProd) {
				if(temps.getLinha().equals(comboBoxLine.getSelectionModel().getSelectedItem())) {
					if(temps.getCategoria().equals(c)) {
						TreeItem<String> treebranch = new TreeItem<String>(temps.getModelo());
						treeitem.getChildren().add(treebranch);
					}
				}
			}
		}
		
		tpaneModel.setDisable(false);  	
    } 
    
}
