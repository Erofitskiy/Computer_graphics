
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppLauncher extends Application {

	public static void main(String[] args) {
		Application.launch(AppLauncher.class, args);
	}

	@Override
	public void start(Stage stage) {
		try {
			final Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("lab1.fxml"));
			final Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Computer graphics lab1");

			stage.setWidth(1200);
			stage.setHeight(1000);


			stage.show();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
}
