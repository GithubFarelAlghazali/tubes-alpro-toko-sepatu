package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
    private TableView table = new TableView();

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Table View Sample");
        stage.setWidth(1000);
        stage.setHeight(600);
 
        final Label label = new Label("Data Sepatu");
        label.setFont(new Font("Arial", 20));
 
        table.setEditable(true);
 
        TableColumn merkCol = new TableColumn("Merk");
        TableColumn hargaCol = new TableColumn("Harga (Rp)");
        TableColumn jarakCol = new TableColumn("Jarak (km)");
        TableColumn ppnCol = new TableColumn("PPN 11% (Rp)");
        TableColumn totalCol = new TableColumn("Total (Rp)");
        
        table.getColumns().addAll(merkCol, hargaCol, jarakCol, ppnCol, totalCol);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);
 
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
 
        stage.setScene(scene);
        stage.show();
            }

    public static void main(String[] args) {
        launch(args);
    }
}