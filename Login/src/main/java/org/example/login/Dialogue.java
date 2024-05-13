package org.example.login;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Dialogue {
    Stage stage;
    @FXML
    Circle closeB;
    @FXML
    Circle maxminB;
    @FXML
    Circle green;
    @FXML
    Label LabelD;
    @FXML
    Button dialogueOK;
    @FXML
    Button dialogueCancel;








@FXML
public void close(MouseEvent k) {
    stage = (Stage) closeB.getScene().getWindow();
    stage.close();

}

@FXML
public void minandmax(MouseEvent m) {
    stage = (Stage) maxminB.getScene().getWindow();
    // if (!stage.isMaximized()) {
    //  stage.setMaximized(true);
    //} else {
    //  stage.setMaximized(false);
    //}
}
@FXML
public void iconify(MouseEvent b) {
    stage = (Stage) green.getScene().getWindow();
    stage.setIconified(true);

}
@FXML
    public void cancel(ActionEvent e){
    stage = (Stage) dialogueCancel.getScene().getWindow();
    stage.close();

}
@FXML
public void oKF(ActionEvent e){
    stage = (Stage) dialogueOK.getScene().getWindow();
    stage.close();

}
public void setLabelD(String labelD){
    this.LabelD=new Label(labelD);
}
}