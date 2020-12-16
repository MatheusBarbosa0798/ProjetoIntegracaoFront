package eletra.view;

import eletra.Main;
import eletra.model.TestSystem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TitledPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class InterfaceController {

	@FXML
    private TitledPane tpaneLine;

    @FXML
    private ComboBox<String> comboBoxLine;

    @FXML
    private TitledPane tpaneModel;

    @FXML
    private TreeView<String> modelTree;

    private Main main;
    
	private ObservableList<String> linha = FXCollections.observableArrayList();
	
	
	public void setMain(Main main) {
    	this.main = main;
    }
	
 private void loadLine() {
	 String linha1 = TestSystem.getProduct(1).getLinha();
	 String linha2 = TestSystem.getProduct(21).getLinha();
		
		linha.add(linha1);
		linha.add(linha2);
		
		comboBoxLine.setItems(linha);
		tpaneModel.setDisable(true); 
	
 	} 
 	
    @FXML
    private void initialize() {
    	loadLine();
    	
    }
 	
    
    @FXML
    void loadModel(ActionEvent event) {
    	
 		if (comboBoxLine.getSelectionModel().getSelectedItem().toString().equals("Ares")) {
				TreeItem<String> rootitem = new TreeItem<String> ("Linha ARES");
	 			TreeItem<String> arestarifabranca = new TreeItem<String>(TestSystem.getProduct(1).getCategoria());
	 			TreeItem<String> aresths = new TreeItem<String>(TestSystem.getProduct(11).getCategoria());
	 			
	 			modelTree.setRoot(rootitem);
	 			rootitem.getChildren().addAll(arestarifabranca, aresths);
	 			
	 			TreeItem<String> tarifabranca1 = new TreeItem<String>(TestSystem.getProduct(1).getModelo());
	 			TreeItem<String> tarifabranca2 = new TreeItem<String>(TestSystem.getProduct(2).getModelo());
	 			TreeItem<String> tarifabranca3 = new TreeItem<String>(TestSystem.getProduct(3).getModelo());
	 			arestarifabranca.getChildren().addAll(tarifabranca1, tarifabranca2, tarifabranca3);
	 			
	 			TreeItem<String> aresths1 = new TreeItem<String>(TestSystem.getProduct(11).getModelo());
	 			TreeItem<String> aresths2 = new TreeItem<String>(TestSystem.getProduct(12).getModelo());
	 			TreeItem<String> aresths3 = new TreeItem<String>(TestSystem.getProduct(13).getModelo());
	 			aresths.getChildren().addAll(aresths1, aresths2, aresths3);
	 			tpaneModel.setDisable(false);
	 			return;
	 		}
		
	 	if (comboBoxLine.getSelectionModel().getSelectedItem().toString().equals("Zeus")) {
	 			TreeItem<String> rootitem = new TreeItem<String> ("Linha ZEUS");
	 			TreeItem<String> zeusdireto = new TreeItem<String>(TestSystem.getProduct(21).getCategoria());
	 			TreeItem<String> zeusindireto = new TreeItem<String>(TestSystem.getProduct(31).getCategoria());
	 			
	 			modelTree.setRoot(rootitem);
	 			rootitem.getChildren().addAll(zeusdireto, zeusindireto);
	 			
	 			TreeItem<String> zeusdireto1 = new TreeItem<String>(TestSystem.getProduct(21).getModelo());
	 			TreeItem<String> zeusdireto2 = new TreeItem<String>(TestSystem.getProduct(22).getModelo());
	 			TreeItem<String> zeusdireto3 = new TreeItem<String>(TestSystem.getProduct(23).getModelo());
	 			zeusdireto.getChildren().addAll(zeusdireto1, zeusdireto2, zeusdireto3);
	 			
	 			TreeItem<String> zeusindireto1 = new TreeItem<String>(TestSystem.getProduct(31).getModelo());
	 			
	 			zeusindireto.getChildren().add(zeusindireto1);
	 	 	 	tpaneModel.setDisable(false);
	 			return;
	 		}
    	
    }  
	
    
    
}
