/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oosd2coursework;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author nik_3
 */
public class OOSD2Coursework extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

        Scene scene = new Scene(root, 800, 600);

        stage.setScene(scene);
        stage.show();
    }

    public static List<Team> teamList = new ArrayList<Team>();
    public static List<Fixtures> fixtureList = new ArrayList<Fixtures>();
    public static List<Match> matchList = new ArrayList<Match>();

    /**
     * @param args the command line arguments
     */


    public static void main(String[] args) {
        //Timer timer = new Timer(true);
        //timer.schedule(new autoGen(), 0, 5000);
        launch(args);
        //Team qwer = new Team("qwer");
        //teamList.add(qwer);

    }

    private void getScores(TextField box, Match match, String value) {
        box.getText().toString();
    }

    public static void GenerateFixtures() {
        fixtureList.clear();
        for (int i = 0; i < OOSD2Coursework.teamList.size(); i++) {
            for (int z = 0; z < OOSD2Coursework.teamList.size(); z++) {
                if (i != z) {
                    Fixtures tempFixture = new Fixtures(OOSD2Coursework.teamList.get(i), OOSD2Coursework.teamList.get(z));
                    fixtureList.add(tempFixture);
                    //tempFixture.viewFixture();
                }
            }
        }
    }

}
