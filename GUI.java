import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class GUI extends Application{
    @Override
    public void start(Stage stage) {
        
        Label labelNama = new Label("Nama");
        TextField textNama = new TextField();
        
        Button submit = new Button("Submit");
        Label labelHasil = new Label();

        submit.setOnAction(e -> {
            String nama = textNama.getText();
            labelHasil.setText("Haiii " + nama);
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(15));
        layout.getChildren().addAll(
            labelNama, textNama, submit, labelHasil
        );

        Scene scene = new Scene(layout, 300, 200);

        stage.setTitle("Form Ucapan");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
