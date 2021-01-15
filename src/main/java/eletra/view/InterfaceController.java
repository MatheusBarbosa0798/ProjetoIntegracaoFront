package main.java.eletra.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import main.java.eletra.model.Meters;
import main.java.eletra.connection.URLConnecta;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TitledPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import main.java.eletra.Main;
 
	public class InterfaceController {
	URLConnecta urlConnecta = new URLConnecta();

	@FXML
    public TitledPane tpaneLine;

    @FXML
    public ComboBox<String> comboBoxLine;

    @FXML
    public TitledPane tpaneModel;

    @FXML
    public TreeView<String> modelTree;
    
    @FXML
    public Button updateButton;

    @SuppressWarnings("unused")
	private Main main;
    
	
	public void setMain(Main main) {
    	this.main = main;
    }
	
	public List<Meters> listProd = new ArrayList<Meters>();
	public List<String> lines = new ArrayList<String>();
	
    @FXML
    public void updateDatabase() throws IOException {
		tpaneLine.setExpanded(false);
    	comboBoxLine.getSelectionModel().select(null);
    	loadLine();
    }
	
	public void loadLine() throws IOException {
		tpaneModel.setExpanded(false);
		tpaneModel.setDisable(true);
		listProd = URLConnecta.sendGET();
		
	for(Meters temp : listProd) {
		if(lines.contains(temp.getLine())) {
		}
		else {
			String box = temp.getLine();
			lines.add(box);
		}
	}
	 
	comboBoxLine.setItems(FXCollections.observableArrayList(lines));
 	} 

 
    @FXML
    public void initialize() throws IOException {
    	loadLine();
    	
    }
 	
    
    @FXML
    public void loadModel() { 
    	
    	ObservableList<String> catgs = FXCollections.observableArrayList();
		TreeItem<String> rootitem = new TreeItem<String> (comboBoxLine.getSelectionModel().getSelectedItem());
		modelTree.setRoot(rootitem);

		for(Meters temp : listProd) {			
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
			for(Meters temps : listProd) {
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
