package sample;

import javafx.event.Event;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class PlayerController implements Initializable {

    @FXML
    private TableView<Player> tableView;
    @FXML
    private TableColumn<Player, String> playerNameCol;
    @FXML
    private TableColumn<Player, String> playerPositionCol;
    @FXML
    private TableColumn<Player, String> playerClubCol;
    @FXML
    private TableColumn<Player, String> playerNumberCol;
    @FXML
    private TableColumn<Player, String> playerDominantFootCol;
    @FXML
    private TableColumn<Player, String> playerAgeCol;
    @FXML
    private TableColumn<Player, String> playerRatingCol;
    @FXML
    private TextField addPlayerName;
    @FXML
    private TextField addPlayerPosition;
    @FXML
    private TextField addPlayerClub;
    @FXML
    private TextField addPlayerNumber;
    @FXML
    private TextField addPlayerDominantFoot;
    @FXML
    private TextField addPlayerAge;
    @FXML
    private TextField addPlayerRating;

    @FXML
    private Button addBtn;

    private final ObservableList<Player> people = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        playerNameCol.setCellValueFactory(new PropertyValueFactory<Player, String>("playerName"));
        playerPositionCol.setCellValueFactory(new PropertyValueFactory<Player, String>("playerPosition"));
        playerClubCol.setCellValueFactory(new PropertyValueFactory<Player, String>("playerClub"));
        playerNumberCol.setCellValueFactory(new PropertyValueFactory<Player, String>("playerNumber"));
        playerDominantFootCol.setCellValueFactory(new PropertyValueFactory<Player, String>("playerDominantFoot"));
        playerAgeCol.setCellValueFactory(new PropertyValueFactory<Player, String>("playerAge"));
        playerRatingCol.setCellValueFactory(new PropertyValueFactory<Player, String>("playerRating"));


        tableView.setItems(people);

        people.add(new Player("Robert Lewandowski", "ST", "Bayern", "9", "Right", "31", "92"));
        people.add(new Player("Serch Gnabry", "LM", "Bayern", "7", "Right", "25", "87"));
        people.add(new Player("Manuel Neuer", "BK", "Bayern", "1", "Right", "34", "89"));
    }

    @FXML public void handleButtonAction(Event e){

        people.add(new Player(addPlayerName.getText(),
                addPlayerPosition.getText(),
                addPlayerClub.getText(),
                addPlayerNumber.getText(),
                addPlayerDominantFoot.getText(),
                addPlayerAge.getText(),
                addPlayerRating.getText()));

        addPlayerName.clear();
        addPlayerPosition.clear();
        addPlayerClub.clear();
        addPlayerNumber.clear();
        addPlayerDominantFoot.clear();
        addPlayerAge.clear();
        addPlayerRating.clear();
    }

    public static class Player {

        private SimpleStringProperty playerName, playerPosition, playerClub, playerNumber, playerDominantFoot, playerAge, playerRating;

        public Player(String playerName, String playerPosition, String playerClub, String playerNumber,
                      String playerDominantFoot, String playerAge, String playerRating) {

            this.playerName = new SimpleStringProperty(playerName);
            this.playerPosition = new SimpleStringProperty(playerPosition);
            this.playerClub = new SimpleStringProperty(playerClub);
            this.playerNumber = new SimpleStringProperty(playerNumber);
            this.playerDominantFoot = new SimpleStringProperty(playerDominantFoot);
            this.playerRating = new SimpleStringProperty(playerRating);

        }

        public String getPlayerName() {
            return playerName.get();
        }

        public void setPlayerName(SimpleStringProperty playerName) {
            this.playerName = playerName;
        }

        public String getPlayerPosition() {
            return playerPosition.get();
        }

        public void setPlayerPosition(SimpleStringProperty playerPosition) {
            this.playerPosition = playerPosition;
        }

        public String getPlayerClub() {
            return playerClub.get();
        }

        public void setPlayerClub(SimpleStringProperty playerClub) {
            this.playerClub = playerClub;
        }

        public String getPlayerNumber() {
            return playerNumber.get();
        }

        public void setPlayerNumber(SimpleStringProperty playerNumber) {
            this.playerNumber = playerNumber;
        }

        public String getPlayerDominantFoot() {
            return playerDominantFoot.get();
        }

        public void setPlayerDominantFoot(SimpleStringProperty playerDominantFoot) {
            this.playerDominantFoot = playerDominantFoot;
        }

        public String getPlayerAge() {
            return playerAge.get();
        }

        public void setPlayerAge(SimpleStringProperty playerAge) {
            this.playerAge = playerAge;
        }

        public String getPlayerRating() {
            return playerRating.get();
        }

        public void setPlayerRating(SimpleStringProperty playerRating) {
            this.playerRating = playerRating;
        }
    }
}
