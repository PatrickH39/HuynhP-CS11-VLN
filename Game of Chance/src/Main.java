import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml")); // Loads the FXML file
        primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("/icon.png"))); // Adds an icon to the window
        primaryStage.setTitle("scuffed genshun impacc Primogem Simulaotr™ \uD83D\uDE31"); // Adds the title to the window
        primaryStage.setScene(new Scene(root, 600, 433)); // Set window size
        primaryStage.setResizable(false); // Disallow resizing of window
        primaryStage.show();
        root.requestFocus(); // Do not highlight the input box
    }

    public static void main(String[] args) {
        launch(args);
    }
}