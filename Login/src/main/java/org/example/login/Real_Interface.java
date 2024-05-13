package org.example.login;

import javafx.animation.TranslateTransition;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class Real_Interface extends MacStyleWindowUtil {
    @FXML
    Button add;
    @FXML
    Circle closeB;
    @FXML
    Circle maxminB;
    @FXML
    Circle green;
    @FXML
    Pane detailsPane;
    @FXML
    Pane AddremovePane;
    @FXML
    Pane Welcome;
    @FXML
    Pane sendthisback;
    @FXML
    Label welcomeL;
    @FXML
    TextField Student_name_textfeild;
    @FXML
    TextField Student_class_textfeild;
    @FXML
    TextField Student_Semester_textfeild;

    @FXML
    private List<TextField> courseNameTextFields = new ArrayList<>();
    @FXML
    private TextField Course1_name_textfield;

    @FXML
    private TextField Course2_name_textfield;

    @FXML
    private TextField Course3_name_textfield;

    @FXML
    private TextField Course4_name_textfield;

    @FXML
    private TextField Course5_name_textfield;

    @FXML
    private TextField Course6_name_textfield;

    @FXML
    private TextField Course7_name_textfield;

    @FXML
    private TextField Course8_name_textfield;

    @FXML
    private List<TextField> totalMarksTextFields = new ArrayList<>();


    @FXML
    private List<TextField> sessionalMarksTextFields = new ArrayList<>();
    @FXML
    private TextField Course1_Tmarks_Textfield;

    @FXML
    private TextField Course2_Tmarks_Textfield;

    @FXML
    private TextField Course3_Tmarks_Textfield;

    @FXML
    private TextField Course4_Tmarks_Textfield;

    @FXML
    private TextField Course5_Tmarks_Textfield;

    @FXML
    private TextField Course6_Tmarks_Textfield;

    @FXML
    private TextField Course7_Tmarks_Textfield;

    @FXML
    private TextField Course8_Tmarks_Textfield;


    @FXML
    private TextField Course1_Smarks_Textfield;

    @FXML
    private TextField Course2_Smarks_Textfield;

    @FXML
    private TextField Course3_Smarks_Textfield;

    @FXML
    private TextField Course4_Smarks_Textfield;

    @FXML
    private TextField Course5_Smarks_Textfield;

    @FXML
    private TextField Course6_Smarks_Textfield;

    @FXML
    private TextField Course7_Smarks_Textfield;

    @FXML
    private TextField Course8_Smarks_Textfield;
    String name;
    Boolean a = true;


    private Stage stage;
    int k ;

    public void real_Interface() throws IOException {

        stage = new Stage();

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("real_Interface.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        String Css = this.getClass().getResource("login.css").toExternalForm();
        scene.getStylesheets().add(Css);
        MacStyleWindowUtil.createMacStyleWindow(stage);

        initialize();


        //stage.setResizable(false);
        stage.setScene(scene);

        stage.show();

    }


    @FXML
    private void initialize() {
        // Add course name text fields
        courseNameTextFields.add(Course1_name_textfield);
        courseNameTextFields.add(Course2_name_textfield);
        courseNameTextFields.add(Course3_name_textfield);
        courseNameTextFields.add(Course4_name_textfield);
        courseNameTextFields.add(Course5_name_textfield);
        courseNameTextFields.add(Course6_name_textfield);
        courseNameTextFields.add(Course7_name_textfield);
        courseNameTextFields.add(Course8_name_textfield);

        // Add total marks text fields
        totalMarksTextFields.add(Course1_Tmarks_Textfield);
        totalMarksTextFields.add(Course2_Tmarks_Textfield);
        totalMarksTextFields.add(Course3_Tmarks_Textfield);
        totalMarksTextFields.add(Course4_Tmarks_Textfield);
        totalMarksTextFields.add(Course5_Tmarks_Textfield);
        totalMarksTextFields.add(Course6_Tmarks_Textfield);
        totalMarksTextFields.add(Course7_Tmarks_Textfield);
        totalMarksTextFields.add(Course8_Tmarks_Textfield);

        // Add sessional marks text fields
        sessionalMarksTextFields.add(Course1_Smarks_Textfield);
        sessionalMarksTextFields.add(Course2_Smarks_Textfield);
        sessionalMarksTextFields.add(Course3_Smarks_Textfield);
        sessionalMarksTextFields.add(Course4_Smarks_Textfield);
        sessionalMarksTextFields.add(Course5_Smarks_Textfield);
        sessionalMarksTextFields.add(Course6_Smarks_Textfield);
        sessionalMarksTextFields.add(Course7_Smarks_Textfield);
        sessionalMarksTextFields.add(Course8_Smarks_Textfield);
    }

    @FXML
    public void close(MouseEvent k) {
        stage = (Stage) closeB.getScene().getWindow();
        stage.close();

    }

    @FXML
    public void minandmax(MouseEvent m) {
        stage = (Stage) maxminB.getScene().getWindow();
        if (!stage.isMaximized()) {
            stage.setMaximized(true);
        } else {
            stage.setMaximized(false);
        }
    }

    @FXML
    public void iconify(MouseEvent b) {
        stage = (Stage) green.getScene().getWindow();
        stage.setIconified(true);

    }

    private boolean isAnimating = false;
    int i = 0;

    @FXML
    public void addCourse(ActionEvent e) {
        if (!isAnimating && i < 7) {
            isAnimating = true;
            i++;


            TranslateTransition translate = new TranslateTransition();
            translate.setDuration(Duration.millis(200));
            translate.setNode(AddremovePane);
            translate.setByY(40);
            translate.setOnFinished(event -> isAnimating = false);
            translate.play();
        }
    }

    @FXML
    public void removeCourse(ActionEvent e) {
        if (!isAnimating && i > 0) {
            isAnimating = true;
            i--;
            TranslateTransition translate = new TranslateTransition();
            translate.setDuration(Duration.millis(200));
            translate.setNode(AddremovePane);
            translate.setByY(-40);
            translate.setOnFinished(event -> isAnimating = false);
            translate.play();
            courseNameTextFields.get(i + 1).clear();
            totalMarksTextFields.get(i + 1).clear();
            sessionalMarksTextFields.get(i + 1).clear();

        }
    }

    public void StudentdetailsPage() {

        Welcome.toBack();
        sendthisback.toBack();
        welcomeL.setText(" ");
        detailsPane.toFront();


    }

    @FXML
    public void submitStudentinTable(ActionEvent e) {
        getData();
        if (a) {
            k++;
            System.out.println(k);
            Database database = new Database();
            Connection connection = database.getDBConnection();
            try (connection) {
                // Retrieve the data from the text fields
                List<String> courseNames = new ArrayList<>();
                List<Integer> totalMarks = new ArrayList<>();
                List<Integer> sessionalMarks = new ArrayList<>();

                for (int J = 0; J <= i; J++) {
                    courseNames.add(courseNameTextFields.get(J).getText());
                    totalMarks.add(Integer.parseInt(totalMarksTextFields.get(J).getText()));
                    sessionalMarks.add(Integer.parseInt(sessionalMarksTextFields.get(J).getText()));

                }
                String insertStudentsSQL = "INSERT INTO STUDENTS(ID, NAME, SEMESTER, CLASS) VALUES (?, ?, ?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(insertStudentsSQL)) {
                    preparedStatement.setInt(1, k);
                    preparedStatement.setString(2, Student_name_textfeild.getText());
                    preparedStatement.setString(3, Student_Semester_textfeild.getText());
                    preparedStatement.setString(4, Student_class_textfeild.getText());
                    preparedStatement.executeUpdate();
                    System.out.println("Student added to the database successfully!");
                }
                // Execute SQL insert statements to add data to the SUBJECTS table
                String insertSubjectsSQL = "INSERT INTO SUBJECTS(ID, COURSE, TOTALMARKS, SMARKS) VALUES (?, ?, ?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(insertSubjectsSQL)) {

                    for (int i = 0; i < courseNames.size(); i++) {

                        preparedStatement.setInt(1, k);
                        preparedStatement.setString(2, courseNames.get(i));
                        preparedStatement.setInt(3, totalMarks.get(i));
                        preparedStatement.setInt(4, sessionalMarks.get(i));
                        preparedStatement.executeUpdate();
                    }
                    System.out.println("Subjects added to the database successfully!");
                }


            } catch (SQLException | NumberFormatException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    connection.close(); // Close the connection after use
                } catch (SQLException a) {
                    a.printStackTrace();
                }
            }

        }else{
            System.out.println("Students already is added");
        }
    }
    public void getData(){
        Database connectNow = new Database();
        Connection connectDB = connectNow.getDBConnection();

        String connectQuery = "SELECT NAME FROM STUDENTS";
        Statement statement = null;
        ResultSet queryoutput = null;

        try{
             a = true;
            statement = connectDB.createStatement();
            queryoutput = statement.executeQuery(connectQuery);

            while (queryoutput.next() && a) {

                String user = queryoutput.getString("NAME");


                name = user;


                if (user.equals(Student_name_textfeild.getText()) ){
                    a = false;
                    System.out.println(user + "FOUND");
                }else{
                    a = true;

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
}
