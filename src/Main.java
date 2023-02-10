import javafx.application.Application;
import javafx.stage.Stage;
import view.PersonController;

public class Main extends Application {
    //!!!
    //Um das Programm nutzen zu können muss eine Derby-Datenbank auf dem Port 1527 laufen

    public static void main(String[] args) {
        launch(args);    
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        PersonController.show(primaryStage);
    }


}
