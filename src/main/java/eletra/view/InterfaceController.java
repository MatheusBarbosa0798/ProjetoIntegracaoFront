package eletra.view;

import java.util.ArrayList;
import java.util.List;

import eletra.Main;
import eletra.model.Products;
import eletra.model.SystemDao;
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
    	tpaneModel.setDisable(false); 
    	
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
		

			
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
 		/*if (comboBoxLine.getSelectionModel().getSelectedItem().toString().equals("Ares")) {
				TreeItem<String> rootitem = new TreeItem<String> ("Linha ARES");
	 			TreeItem<String> arestarifabranca = new TreeItem<String>(systemService.findById(1).getCategoria());
	 			TreeItem<String> aresths = new TreeItem<String>(systemService.findById(4).getCategoria());
	 			
	 			modelTree.setRoot(rootitem);
	 			rootitem.getChildren().addAll(arestarifabranca, aresths);
	 			
	 			TreeItem<String> tarifabranca1 = new TreeItem<String>(systemService.findById(1).getModelo());
	 			TreeItem<String> tarifabranca2 = new TreeItem<String>(systemService.findById(2).getModelo());
	 			TreeItem<String> tarifabranca3 = new TreeItem<String>(systemService.findById(3).getModelo());
	 			arestarifabranca.getChildren().addAll(tarifabranca1, tarifabranca2, tarifabranca3);
	 			
	 			TreeItem<String> aresths1 = new TreeItem<String>(systemService.findById(4).getModelo());
	 			TreeItem<String> aresths2 = new TreeItem<String>(systemService.findById(5).getModelo());
	 			TreeItem<String> aresths3 = new TreeItem<String>(systemService.findById(6).getModelo());
	 			aresths.getChildren().addAll(aresths1, aresths2, aresths3);
	 			tpaneModel.setDisable(false);
	 			return;
	 		}
		
	 	if (comboBoxLine.getSelectionModel().getSelectedItem().toString().equals("Zeus")) {
	 			TreeItem<String> rootitem = new TreeItem<String> ("Linha ZEUS");
	 			TreeItem<String> zeusdireto = new TreeItem<String>(systemService.findById(7).getCategoria());
	 			TreeItem<String> zeusindireto = new TreeItem<String>(systemService.findById(10).getCategoria());
	 			
	 			modelTree.setRoot(rootitem);
	 			rootitem.getChildren().addAll(zeusdireto, zeusindireto);
	 			
	 			TreeItem<String> zeusdireto1 = new TreeItem<String>(systemService.findById(7).getModelo());
	 			TreeItem<String> zeusdireto2 = new TreeItem<String>(systemService.findById(8).getModelo());
	 			TreeItem<String> zeusdireto3 = new TreeItem<String>(systemService.findById(9).getModelo());
	 			zeusdireto.getChildren().addAll(zeusdireto1, zeusdireto2, zeusdireto3);
	 			
	 			TreeItem<String> zeusindireto1 = new TreeItem<String>(systemService.findById(10).getModelo());
	 			
	 			zeusindireto.getChildren().add(zeusindireto1);
	 	 	 	tpaneModel.setDisable(false);
	 	 	 	
	 			return;
	 		}*/
    	
    }  
	
    
    
}
