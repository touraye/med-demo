package alert;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Error extends Application {

    public void start(Stage stage){

        Alert err = new Alert(Alert.AlertType.ERROR);
        err.setTitle("Error");
        err.setContentText("This is a Error Dialog");
        ButtonType btnType = new ButtonType("CLOSE", ButtonBar.ButtonData.CANCEL_CLOSE);
        err.getDialogPane().getButtonTypes().add(btnType);

        Text txt = new Text("Click to show alert");

        Button showAlert = new Button("Show dialog");
        showAlert.setOnAction(e->{
            err.showAndWait();
        });

        HBox pane = new HBox(15);
        pane.setPadding(new Insets(50, 150, 50, 60));

        Scene scene = new Scene(pane, 200,200);
        stage.setTitle("Alert");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args){
        launch(args);
    }

}
