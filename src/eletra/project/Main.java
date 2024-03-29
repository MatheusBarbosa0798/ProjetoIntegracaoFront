package eletra.project;

import java.io.IOException;

import eletra.project.view.fxmlProjectController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
	
	 private Stage primaryStage;
	 private AnchorPane rootLayout;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Projeto: Etapa 1");
        
        initfxmlProject();
   
	}
	
	public void initfxmlProject() {
		 try {
	            // Carrega o root layout do arquivo fxml.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(Main.class.getResource("view/fxmlProject.fxml"));
	            rootLayout = (AnchorPane) loader.load();
	            
	            // Mostra a scene (cena) contendo o root layout.
	            Scene scene = new Scene(rootLayout);
	            primaryStage.setScene(scene);
	            primaryStage.show();
	            
	         // D� ao controlador acesso � the main app.
	            fxmlProjectController controller = loader.getController();
	            controller.setMain(this);
	            
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
		 
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
