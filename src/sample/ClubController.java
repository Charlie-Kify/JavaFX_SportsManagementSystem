package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ClubController implements Initializable {

    @FXML PieChart pieChart;
    @FXML TableView<Stats> tableStats;

    @FXML private TableColumn<Stats, String> rankCol;
    @FXML private TableColumn<Stats, String> clubCol;
    @FXML private TableColumn<Stats, String> gpCol;
    @FXML private TableColumn<Stats, String> gsCol;
    @FXML private TableColumn<Stats, String> gcCol;
    @FXML private TableColumn<Stats, String> pointsCol;

    ObservableList<Stats> clubStats = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Bayern 59%", 59),
                new PieChart.Data("Rivals 41%", 41));



        pieChart.setData(pieChartData);

        rankCol.setCellValueFactory(new PropertyValueFactory<Stats, String>("rank"));
        clubCol.setCellValueFactory(new PropertyValueFactory<Stats, String>("club"));
        gpCol.setCellValueFactory(new PropertyValueFactory<Stats, String>("gp"));
        gsCol.setCellValueFactory(new PropertyValueFactory<Stats, String>("gs"));
        gcCol.setCellValueFactory(new PropertyValueFactory<Stats, String>("gc"));
        pointsCol.setCellValueFactory(new PropertyValueFactory<Stats, String>("points"));

        tableStats.setItems(clubStats);

        clubStats.add(new Stats(1,"FC Bayern",20, 58,26,48));
        clubStats.add(new Stats(2,"RB Leipzig",19,32,17,38));
        clubStats.add(new Stats(3,"FC Bayern",19,30,30,35));
    }

    public static class Stats {

        private Integer rank;
        private SimpleStringProperty club;
        private Integer gp, gs, gc, points;

        public Integer getRank() {
            return rank;
        }

        public void setRank(Integer rank) {
            this.rank = rank;
        }

        public String getClub() {
            return club.get();
        }

        public SimpleStringProperty clubProperty() {
            return club;
        }

        public void setClub(String club) {
            this.club.set(club);
        }

        public Integer getGp() {
            return gp;
        }

        public void setGp(Integer gp) {
            this.gp = gp;
        }

        public Integer getGs() {
            return gs;
        }

        public void setGs(Integer gs) {
            this.gs = gs;
        }

        public Integer getGc() {
            return gc;
        }

        public void setGc(Integer gc) {
            this.gc = gc;
        }

        public Integer getPoints() {
            return points;
        }

        public void setPoints(Integer points) {
            this.points = points;
        }

        public Stats(int rank, String club, int gp, int gs, int gc, int points){
            this.rank = new Integer(rank);
            this.club = new SimpleStringProperty(club);
            this.gp = new Integer(gp);
            this.gs = new Integer(gs);
            this.gc = new Integer(gc);
            this.points = new Integer(points);
        }
    }

}
