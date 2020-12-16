package eletra.project.view;



import eletra.project.Main;
import eletra.project.model.Linha;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TitledPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class fxmlProjectController {

	@FXML
    private Label labelLinha;

    @FXML
    private TitledPane acordLinha;

    @FXML
    private ComboBox<Linha> comboBoxLinha;
    
    @FXML
    private TitledPane acordModelo;
    
    @FXML
    private TreeView<String> modelTree;
	

	
 	
 // Reference to the main application.
 	@SuppressWarnings("unused")
	private Main main;
 	
 	
	private ObservableList<Linha> linha = FXCollections.observableArrayList();
 
 	private void loadLinha() {
 		Linha linha1 = new Linha("Ares");
		Linha linha2 = new Linha("Zeus");
		
		linha.add(linha1);
		linha.add(linha2);
		
		comboBoxLinha.setItems(linha);
		acordModelo.setDisable(true);
	
 	}
 	
 	
 	@FXML
    private void initialize() {
		loadLinha();
    }
 	
 	  
 	@FXML
 	private void loadModel() {
 		
 		if (comboBoxLinha.getSelectionModel().getSelectedItem().toString().equals("Ares")) {
 				TreeItem<String> rootitem = new TreeItem<String> ("Linha ARES");
 	 			TreeItem<String> arestarifabranca = new TreeItem<String>("Ares Tarifa Branca");
 	 			TreeItem<String> aresths = new TreeItem<String>("Ares THS");
 	 			
 	 			modelTree.setRoot(rootitem);
 	 			rootitem.getChildren().addAll(arestarifabranca, aresths);
 	 			
 	 			TreeItem<String> tarifabranca1 = new TreeItem<String>("Ares 7021");
 	 			TreeItem<String> tarifabranca2 = new TreeItem<String>("Ares 7023");
 	 			TreeItem<String> tarifabranca3 = new TreeItem<String>("Ares 7031");
 	 			arestarifabranca.getChildren().addAll(tarifabranca1, tarifabranca2, tarifabranca3);
 	 			
 	 			TreeItem<String> aresths1 = new TreeItem<String>("Ares 8023 15");
 	 			TreeItem<String> aresths2 = new TreeItem<String>("Ares 8023 200");
 	 			TreeItem<String> aresths3 = new TreeItem<String>("Ares 8023 2,5");
 	 			aresths.getChildren().addAll(aresths1, aresths2, aresths3);
 	 	 	 	acordModelo.setDisable(false);
 	 			return;
 	 		}
 		
 	 	if (comboBoxLinha.getSelectionModel().getSelectedItem().toString().equals("Zeus")) {
 	 			TreeItem<String> rootitem = new TreeItem<String> ("Linha ZEUS");
 	 			TreeItem<String> zeusdireto = new TreeItem<String>("Zeus DIRETO");
 	 			TreeItem<String> zeusindireto = new TreeItem<String>("Zeus INDIRETO");
 	 			
 	 			modelTree.setRoot(rootitem);
 	 			rootitem.getChildren().addAll(zeusdireto, zeusindireto);
 	 			
 	 			TreeItem<String> zeusdireto1 = new TreeItem<String>("Zeus 8021");
 	 			TreeItem<String> zeusdireto2 = new TreeItem<String>("Zeus 8023");
 	 			TreeItem<String> zeusdireto3 = new TreeItem<String>("Zeus 8031");
 	 			zeusdireto.getChildren().addAll(zeusdireto1, zeusdireto2, zeusdireto3);
 	 			
 	 			TreeItem<String> zeusindireto1 = new TreeItem<String>("Zeus 8023 2,5");
 	 			
 	 			zeusindireto.getChildren().add(zeusindireto1);
 	 	 	 	acordModelo.setDisable(false);
 	 			return;
 	 		}
 	 	
 		}
 		
 	
 	public void setMain(Main main) {
        this.main = main;
    }
}
