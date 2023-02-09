package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Person;

import java.sql.SQLException;

public class PersonController {
    public ListView lvPersonen;
    public TextField tfID;
    public TextField tfVorname;
    public TextField tfWohnort;
    @FXML
    private Button btRefresh;
    @FXML
    private Button btCancel;
    @FXML
    private Button btSave;

    private Person model;

    public static void show(Stage stage){
        try {
            FXMLLoader loader = new FXMLLoader(PersonController.class.getResource("PersonView.fxml"));

            Parent parent = loader.load();
            stage.setScene(new Scene(parent));
            stage.setTitle("Personen Verwaltung");
            stage.show();
        }catch (Exception e) {
           e.printStackTrace();
        }
    }
    @FXML
    private void initialize(){
        model = new Person();
        
    }

    private void refresh() {

        try {
            lvPersonen.setItems(model.getPersonList());
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void refreshOnAction(ActionEvent actionEvent) {
        refresh();
    }

    public void cancelOnAction(ActionEvent actionEvent) {
    }

    public void saveOnAction(ActionEvent actionEvent) {
    }
}
