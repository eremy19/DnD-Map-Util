package controllers;

import application.FPADriver;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ConfigureController {
	
	@FXML
	public Button applybutton;
	public TextField att1text;
	public TextField att2text;
	public TextField att3text;
	public TextField att4text;
	public TextField att5text;
	public TextField att6text;

	
	public String[] returnAtts(String name) {
		String[] atts = new String[6];
		atts[0] = FPADriver.AvaliableEntities.get(name).getAttribute1name();
		atts[1] = FPADriver.AvaliableEntities.get(name).getAttribute2name();
		atts[2] = FPADriver.AvaliableEntities.get(name).getAttribute3name();
		atts[3] = FPADriver.AvaliableEntities.get(name).getAttribute4name();
		atts[4] = FPADriver.AvaliableEntities.get(name).getAttribute5name();
		atts[5] = FPADriver.AvaliableEntities.get(name).getAttribute6name();
    
    	if (!att1text.getText().equals("")) {
    		atts[0] = att1text.getText();
		}if (!att2text.getText().equals("")) {
			atts[1] = att2text.getText();
		}if (!att3text.getText().equals("")) {
			atts[2] = att3text.getText();
		}if (!att4text.getText().equals("")) {
			atts[3] = att4text.getText();
		}if (!att5text.getText().equals("")) {
			atts[4] = att5text.getText();
		}if (!att6text.getText().equals("")) {
			atts[5] = att6text.getText();
		}

			FPADriver.AvaliableEntities.get(name).setAttribute1name(atts[0]);
			FPADriver.AvaliableEntities.get(name).setAttribute2name(atts[1]);
			FPADriver.AvaliableEntities.get(name).setAttribute3name(atts[2]);
			FPADriver.AvaliableEntities.get(name).setAttribute4name(atts[3]);
			FPADriver.AvaliableEntities.get(name).setAttribute5name(atts[4]);
			FPADriver.AvaliableEntities.get(name).setAttribute6name(atts[5]);
			return atts;
	}
	
}
