import javafx.application.Application;
import javafx.stage.Stage;
import view.PersonController;

public class Main extends Application {
    //!!!
    //Um das Programm nutzen zu können muss eine Derby-Datenbank auf dem Port 1527 laufen
    //Die library derbyclient.jar muss vorhanden sein.
    //Das Programm erzeugt (wenn noch nich vohanden) die Datenbank "PersonDB"
    public static void main(String[] args) {
        launch(args);    
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
//        Database.getInstance().getallData();
        PersonController.show(primaryStage);
    }


}
