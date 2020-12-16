package eletra.view;

import eletra.Main;
import eletra.model.EnumCategory;
import eletra.model.EnumLine;
import eletra.model.EnumModel;
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
 		String linha1 = EnumLine.ARES.nomeLinha;
		String linha2 = EnumLine.ZEUS.nomeLinha;
		
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
	 			TreeItem<String> arestarifabranca = new TreeItem<String>(EnumCategory.ARES.catg1);
	 			TreeItem<String> aresths = new TreeItem<String>(EnumCategory.ARES.catg2);
	 			
	 			modelTree.setRoot(rootitem);
	 			rootitem.getChildren().addAll(arestarifabranca, aresths);
	 			
	 			TreeItem<String> tarifabranca1 = new TreeItem<String>(EnumModel.ARESTB1.model);
	 			TreeItem<String> tarifabranca2 = new TreeItem<String>(EnumModel.ARESTB2.model);
	 			TreeItem<String> tarifabranca3 = new TreeItem<String>(EnumModel.ARESTB3.model);
	 			arestarifabranca.getChildren().addAll(tarifabranca1, tarifabranca2, tarifabranca3);
	 			
	 			TreeItem<String> aresths1 = new TreeItem<String>(EnumModel.ARESTHS1.model);
	 			TreeItem<String> aresths2 = new TreeItem<String>(EnumModel.ARESTHS2.model);
	 			TreeItem<String> aresths3 = new TreeItem<String>(EnumModel.ARESTHS3.model);
	 			aresths.getChildren().addAll(aresths1, aresths2, aresths3);
	 			tpaneModel.setDisable(false);
	 			return;
	 		}
		
	 	if (comboBoxLine.getSelectionModel().getSelectedItem().toString().equals("Zeus")) {
	 			TreeItem<String> rootitem = new TreeItem<String> ("Linha ZEUS");
	 			TreeItem<String> zeusdireto = new TreeItem<String>(EnumCategory.ZEUS.catg1);
	 			TreeItem<String> zeusindireto = new TreeItem<String>(EnumCategory.ZEUS.catg2);
	 			
	 			modelTree.setRoot(rootitem);
	 			rootitem.getChildren().addAll(zeusdireto, zeusindireto);
	 			
	 			TreeItem<String> zeusdireto1 = new TreeItem<String>(EnumModel.ZEUSDIRETO1.model);
	 			TreeItem<String> zeusdireto2 = new TreeItem<String>(EnumModel.ZEUSDIRETO2.model);
	 			TreeItem<String> zeusdireto3 = new TreeItem<String>(EnumModel.ZEUSDIRETO3.model);
	 			zeusdireto.getChildren().addAll(zeusdireto1, zeusdireto2, zeusdireto3);
	 			
	 			TreeItem<String> zeusindireto1 = new TreeItem<String>(EnumModel.ZEUSINDIRETO.model);
	 			
	 			zeusindireto.getChildren().add(zeusindireto1);
	 	 	 	tpaneModel.setDisable(false);
	 			return;
	 		}
    	
    } 
	
    
    
}
