package org.example.login;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;
import java.sql.*;
import java.sql.Connection;


public class Controller {
    int i=2;
    int ID;
    String username;
    private String password;
    @FXML
    private Button loginB;
    @FXML
    Button SigninB;
    @FXML
    private Circle closeB;
    @FXML
    private Circle maxminB;
    @FXML
    private Circle green;
    @FXML
    private TextField textfield;
    @FXML
    private PasswordField passfield;
    @FXML
    private PasswordField Rpassfield;
    @FXML
    private PasswordField RpassfieldC;
    @FXML
    private TextField Rtextfeild;
    @FXML
    Pane animatedPane;
    @FXML
    Pane SigninPane;
    @FXML
    Button SignupB;
    @FXML
    private Stage stage;


    @FXML
    public void loginButton(ActionEvent e) throws IOException {
         Real_Interface r = new Real_Interface();
        if(!textfield.getText().isEmpty() && !passfield.getText().isEmpty()) {
            getdata();

            if (textfield.getText().equals(username) && passfield.getText().equals(password)) {
                System.out.println("Login Successfull");


                r.real_Interface();
                stage = (Stage) loginB.getScene().getWindow();
                stage.close();


            } else {
                System.out.println("wrong password");
                bringDialogue("Username or Password is wrong");

            }
        }



    }
    public void getdata(){
        Database connectNow = new Database();
        Connection connectDB = connectNow.getDBConnection();

        String connectQuery = "SELECT ID,USERNAME,PASSWORD FROM USER_VARIFICATION";
        Statement statement = null;
        ResultSet queryoutput = null;

        try{

            statement = connectDB.createStatement();
            queryoutput = statement.executeQuery(connectQuery);
                 Boolean a = true;
                while (queryoutput.next() && a) {
                    int id = queryoutput.getInt("ID");
                    String user = queryoutput.getString("USERNAME");
                    String pass = queryoutput.getString("PASSWORD");

                    username = user;
                    password = pass;
                    ID = id;
                    if (user.equals(textfield.getText()) && pass.equals(passfield.getText())){
                        a = false;
                    }

                }


        } catch (Exception a ){
            a.printStackTrace();
        } finally {
            try {
                // Close ResultSet
                if (queryoutput != null) {
                    queryoutput.close();
                }
                // Close Statement
                if (statement != null) {
                    statement.close();
                }
                // Close Connection
                if (connectDB != null) {
                    connectDB.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    public void insertUserData(int id, String username, String password) {
        Database connectNow = new Database();
        Connection connectDB = connectNow.getDBConnection();

        String insertQuery = "INSERT INTO USER_VARIFICATION (ID, USERNAME, PASSWORD) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connectDB.prepareStatement(insertQuery)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, password);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data inserted successfully.");
            } else {
                System.out.println("Failed to insert data.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connectDB.close(); // Close the connection after use
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

    @FXML
    public void bColorchange(MouseEvent a) {
        loginB.setStyle("-fx-background-color: #FFFFFF;");
        loginB.setStyle("-fx-border-color: #16A180;");
        loginB.setTextFill(Color.web("#16A180"));
        loginB.setFocusTraversable(false);

    }

    @FXML
    public void bColorR(MouseEvent a) {


        loginB.setStyle("-fx-background-color: #16A180;");
        loginB.setTextFill(Color.WHITE);

    }


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
    public void SignupP (ActionEvent e){
            if (!isAnimating) {
                isAnimating = true;

                SigninPane.toBack();
                animatedPane.toFront();

                TranslateTransition translate = new TranslateTransition();
                translate.setDuration(Duration.millis(1000));
                translate.setNode(animatedPane);
                translate.setByX(428);
                translate.setOnFinished(event -> isAnimating = false);
                translate.play();
            }

        }
    @FXML
    public void SigninP(ActionEvent e) {
        if (!isAnimating) {
            isAnimating = true;

            SigninPane.toBack();
            animatedPane.toFront();

            TranslateTransition translate = new TranslateTransition();
            translate.setDuration(Duration.millis(1000));
            translate.setNode(animatedPane);
            translate.setByX(-426);
            translate.setOnFinished(event -> isAnimating = false);
            translate.play();
        }
    }

    private boolean isAnimating = false;
    @FXML
    public void Registerpass (ActionEvent e){

            if(!Rtextfeild.getText().isEmpty() && !Rpassfield.getText().isEmpty() && !RpassfieldC.getText().isEmpty()){
              if(Rpassfield.getText().equals(RpassfieldC.getText())){
                  i ++;

                  insertUserData(i,Rtextfeild.getText(),RpassfieldC.getText());
                  System.out.println("Account created successfull");
              }

            }
    }

    @FXML
    public void rbColorR(MouseEvent k) {


        loginB.setStyle("-fx-background-color: #16A180;");
        loginB.setTextFill(Color.WHITE);

    }

    @FXML
    public void rbColorchange(MouseEvent a) {
        loginB.setStyle("-fx-background-color: #FFFFFF;");
        loginB.setStyle("-fx-border-color: #16A180;");
        loginB.setTextFill(Color.web("#16A180"));
        loginB.setFocusTraversable(false);

    }
    public void bringDialogue(String a)  {


            try {


                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("dialogue.fxml"));
                Parent root=fxmlLoader.load();

                Dialogue dialogue=fxmlLoader.getController();

                Dialog<Void> dialog=new Dialog<>();

                dialog.initModality(Modality.APPLICATION_MODAL);
                dialog.getDialogPane().setContent(root);



                dialogue.setLabelD(a);

                //LabelD.setText(LabelText);
                stage=(Stage) dialog.getDialogPane().getScene().getWindow();

//                MacStyleWindowUtil.createMacStyleWindow();
                ((Stage) dialog.getDialogPane().getScene().getWindow()).initStyle(StageStyle.UNDECORATED);

                stage.setResizable(false);
//                stage.initStyle(StageStyle.DECORATED);
                stage.showAndWait();



            }
            catch (Exception e){
                e.printStackTrace();
            }


    }


    }



