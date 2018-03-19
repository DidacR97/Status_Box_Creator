package model;

import java.io.File;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class StatusBoxCreator extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("window.fxml"));
		stage.setTitle("Geprom Status Box Creator");
		stage.getIcons().add(new Image("/model/justLogo.png")); 
		Scene scene = new Scene(root,600,400);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
