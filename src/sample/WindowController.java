package sample;


import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WindowController implements Initializable {

    @FXML
    Button playerBtn;
    @FXML
    Button statsBtn;
    @FXML
    Button titlesBtn;
    @FXML
    Button stadiumBtn;


    public void handleButtonClicks(Event mouseEvent) {

        if (mouseEvent.getSource() == playerBtn) {
            loadStages("Player.fxml");
        }
        else if (mouseEvent.getSource() == statsBtn) {
            loadStages("Club.fxml");
        } else if (mouseEvent.getSource() == titlesBtn) {
            loadStages("Titles.fxml");
        } else if (mouseEvent.getSource() == stadiumBtn) {
            loadStages("Stadium.fxml");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private void loadStages(String fxml) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxml));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

