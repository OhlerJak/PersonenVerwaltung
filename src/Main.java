import javafx.application.Application;
import javafx.stage.Stage;
import view.PersonController;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);    
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
//        Database.getInstance().getallData();
        PersonController.show(primaryStage);
    }

    @Override
    public void init() throws Exception {
        super.init();

    }

    @Override
    public void stop() throws Exception {
        super.stop();

    }
}
