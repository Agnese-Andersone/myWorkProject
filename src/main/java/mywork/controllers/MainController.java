package mywork.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML private BorderPane content;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Main controller initialized!");
    }

    @FXML
    public void switchPanel(ActionEvent event) throws Exception {
        Pane pane = FXMLLoader.load(getClass().getResource("/ui/task/list_tasks.fxml"));
        content.setCenter(pane);
    }
}
