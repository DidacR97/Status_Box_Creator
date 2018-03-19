package model;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;

import com.sun.javafx.application.HostServicesDelegate;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.StageStyle;
import javafx.scene.control.Alert.AlertType;
import javafx.util.converter.IntegerStringConverter;

public class SBC_Controller implements Initializable{
	
	private static String DEFAULT_TAB_VALUE = "2";

	@FXML
    private CheckBox disconnected;

    @FXML
    private TextField statusNumber;
    
    @FXML
    private TextArea svgViewer;

    @FXML
    private TextField ellipsesNumber;

    @FXML
    private Button getCode;
    
    @FXML
    private CheckBox defCheckTab;
    
    @FXML
    private TextField defTab;
    
    @FXML
    private Button help;
    
    @FXML
    private Button about;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	
    }
    @FXML
    public void onClickButton() {
    	 //Bolean value for desc ellipses
    	Boolean defaultDescEllip = false;
    	if(disconnected.isSelected())defaultDescEllip = true;
    	
    	String statusS = statusNumber.getText().toString();
    	String ellipsesS = ellipsesNumber.getText().toString();
    	String tabs = defTab.getText().toString();

    	Integer ellipses = 0;
    	Integer status = 0;
    	Integer defaultTabs = 0;

    	try {
    		ellipses = Integer.valueOf(ellipsesS);
    		status = Integer.valueOf(statusS);
    		defaultTabs = Integer.valueOf(tabs);
    		if(ellipses <= 0 || status <= 0 || defaultTabs <= 0)throw new Exception("Invalid Input");

    	}catch(Exception e) {
    		showAlertBadInput();
    	}
    	fillTArea();
    }

    public void showAlertBadInput() {
    	Alert errorInteger = new Alert(AlertType.ERROR);
    	errorInteger.setTitle("EXCEPTION PARSING INPUTS");
    	errorInteger.setContentText("The introduced numbers can't be empty and must be possitive integers");
    	errorInteger.setHeaderText(null);
    	errorInteger.initStyle(StageStyle.UTILITY);
		errorInteger.showAndWait();
    }
    
    public void fillTArea() {
    	svgViewer.setText(Container.svgCreator(1,1));
    }
    @FXML
    public void onClickCheckBoxDefTab() {
    	if(defTab.isDisabled()) {
    		defTab.setDisable(false);
    	}else {
    		defTab.setDisable(true);
    		defTab.setText(DEFAULT_TAB_VALUE);
    	}
    }
    @FXML
    public void showAlertInfo() {
    	
    	char ch = 9654;
    	
    	String info = ch+"Number of status: Number of status to build the box. Can't be empty, negative or 0"+System.lineSeparator();
    	info += ch+"Number of ellipses per status: Number of ellipses per status. Can't be empty, negative or 0"+System.lineSeparator();
    	info += ch+"Default Tab: If is checked, SBC will use the default value for tabulations, if not, "
    			+ "the user can introduce a custom value for it. Can't be empty, negative or 0"+System.lineSeparator();
    	info += ch+"Disconneted Ellipse: If checked, SBC will add disconnected ellipses to the Status Box"+System.lineSeparator();
    	Alert infoAlert = new Alert(AlertType.INFORMATION);
    	infoAlert.setTitle("Overview");
    	infoAlert.setContentText(info);
    	infoAlert.setHeaderText(null);
    	infoAlert.initStyle(StageStyle.UTILITY);
		infoAlert.showAndWait();
    }
    @FXML
    public void openBrowser() {
    	try {
			java.awt.Desktop.getDesktop().browse(new URI("http://geprom.com/"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
