import javafx.application.Application;
import javafx.stage.Stage;
import view.PersonController;

public class Main extends Application {
    //!!!
    //Um das Programm nutzen zu können muss eine Derby-Datenbank auf dem Port 1527 laufen
    //Diese muss die Datenbank "PersonDB" mit dme Schema APP enthalten
    //Der Rest wird selbst erstellt

    //aktuell: Testdaten müssen über eine andere Schnittstelle eingegeben werden (nur anzeige möglich)
    public static void main(String[] args) {
        launch(args);    
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
//        Database.getInstance().getallData();
        PersonController.show(primaryStage);
    }


}
