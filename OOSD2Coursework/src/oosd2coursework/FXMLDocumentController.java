/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oosd2coursework;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.StringJoiner;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.*;
import javafx.stage.StageStyle;
import javafx.util.Pair;

/**
 *
 * @author nik_3
 */
public class FXMLDocumentController implements Initializable {

    ArrayList<Team> teamListsuperior;

    //FXMLDocumentController(){
    //teamListsuperior< = new ArrayList<>();
    //}
    @FXML
    private Label homeTeamLabel;
    @FXML
    private Label awayTeamLabel;
    @FXML
    private TextField adminTeamNameTextbox;
    @FXML
    private TextField adminPlayerNameTextbox;
    @FXML
    ChoiceBox addTeamListBox;
    @FXML
    ChoiceBox homeChoice;
    @FXML
    ChoiceBox choiceHomePlayer1;
    @FXML
    ChoiceBox choiceHomePlayer2;
    @FXML
    ChoiceBox choiceAwayPlayer1;
    @FXML
    ChoiceBox choiceAwayPlayer2;
    @FXML
    Match newMatch;
    @FXML
    GridPane scoreSheetGridPane;
    @FXML
    GridPane scoreSheetGridPane2;
    @FXML
    Button chooseTeamButton;

    @FXML
    private TextField box_11set1;
    @FXML
    private TextField box_11set2;
    @FXML
    private TextField box_11set3;
    @FXML
    private TextField box_12set1;
    @FXML
    private TextField box_12set2;
    @FXML
    private TextField box_12set3;
    @FXML
    private TextField box_21set1;
    @FXML
    private TextField box_21set2;
    @FXML
    private TextField box_21set3;
    @FXML
    private TextField box_22set1;
    @FXML
    private TextField box_22set2;
    @FXML
    private TextField box_22set3;
    @FXML
    private TextField box_Dset1;
    @FXML
    private TextField box_Dset2;
    @FXML
    private TextField box_Dset3;
    @FXML
    private TextArea resultField;
    @FXML
    private  TextArea aResultField;

    @FXML
    private void logoAboutButtonAction(ActionEvent event) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Sports Score System (S₃)");
        alert.setContentText("Created by Nikesh Purohit \n Vanne Cabahug \n Karl Sartorio");

        alert.showAndWait();
    }

    @FXML
    private void fixtureGenButtonAction(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle(" ");
        alert.setHeaderText("Continue with operation?");
        alert.setContentText("Generating new fixtures will delete previously generated fixtures.");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {
            //OOSD2Coursework.fixtureList.add(OOSD2Coursework.GenerateFixtures());
            OOSD2Coursework.GenerateFixtures();
            System.out.println("MANUALLY GENERATE FIXUTRES: ");
            for (int i = 0; i < OOSD2Coursework.fixtureList.size(); i++) {
                OOSD2Coursework.fixtureList.get(i).viewFixture();
            }
        } else {
            // ... user chose CANCEL or closed the dialog do none
        }
    }

    @FXML
    private void newScoreSheetButtonAction(ActionEvent event) {
        newMatch = null; //reset the match object
        newMatch = new Match();
        scoreSheetGridPane.setDisable(false);
        scoreSheetGridPane2.setDisable(false);
        chooseTeamButton.setDisable(false);
        box_11set1.clear();
        box_11set2.clear();
        box_11set3.clear();
        box_12set1.clear();
        box_12set2.clear();
        box_12set3.clear();
        box_21set1.clear();
        box_21set2.clear();
        box_21set3.clear();
        box_22set1.clear();
        box_22set2.clear();
        box_22set3.clear();
        box_Dset1.clear();
        box_Dset2.clear();
        box_Dset3.clear();

    }

    @FXML
    private void saveScoreSheetButtonAction(ActionEvent event) {
        boolean saved = false;
        chooseTeamButton.setDisable(true);

        List<String> scoreValues = new ArrayList<String>();
        scoreValues.add(box_11set1.getText());
        scoreValues.add(box_11set2.getText());
        scoreValues.add(box_11set3.getText());
        scoreValues.add(box_12set1.getText());
        scoreValues.add(box_12set2.getText());
        scoreValues.add(box_12set3.getText());
        scoreValues.add(box_21set1.getText());
        scoreValues.add(box_21set2.getText());
        scoreValues.add(box_21set3.getText());
        scoreValues.add(box_22set1.getText());
        scoreValues.add(box_22set2.getText());
        scoreValues.add(box_22set3.getText());
        scoreValues.add(box_Dset1.getText());
        scoreValues.add(box_Dset2.getText());
        scoreValues.add(box_Dset3.getText());

        newMatch.setScore(scoreValues);
        newMatch.getScores();
        newMatch.linkFixture();
        newMatch.calculateScores();
        for (int p = 0; p < newMatch.getHomeTeam().getPlayers().size(); p++) {
            if (newMatch.getHomeTeam().getPlayers().get(p).toString() == choiceHomePlayer1.getValue().toString()) {
                newMatch.setPlayers("home", 1, newMatch.getHomeTeam().getPlayers().get(p));
            }
            if (newMatch.getHomeTeam().getPlayers().get(p).toString() == choiceHomePlayer2.getValue().toString()) {
                newMatch.setPlayers("home", 2, newMatch.getHomeTeam().getPlayers().get(p));
            }
        }
        for (int q = 0; q < newMatch.getAwayTeam().getPlayers().size(); q++) {
            if (newMatch.getAwayTeam().getPlayers().get(q).toString() == choiceAwayPlayer1.getValue().toString()) {
                newMatch.setPlayers("away", 1, newMatch.getAwayTeam().getPlayers().get(q));
            }
            if (newMatch.getAwayTeam().getPlayers().get(q).toString() == choiceAwayPlayer2.getValue().toString()) {
                newMatch.setPlayers("away", 2, newMatch.getAwayTeam().getPlayers().get(q));
            }
        }

        for (int i = 0; i < OOSD2Coursework.matchList.size(); i++) {
            System.out.println((OOSD2Coursework.matchList.get(i).toString() + " " + newMatch.toString()));
            if (OOSD2Coursework.matchList.get(i).toString().equals(newMatch.toString())) {
                OOSD2Coursework.matchList.set(i, newMatch);
                saved = true;
                System.out.println("saving to existing scoresheet");
            }
        }

        if (saved == false) {
            System.out.println("new scoresheet created");
            OOSD2Coursework.matchList.add(newMatch);
            saved = true;
        }

        //System.out.println(newMatch.getAwayTeam());
        if (saved == true) {
            System.out.println("this match has been saved");
            //newMatch.getHomeTeam().resetSetsWon();
            //newMatch.getAwayTeam().resetSetsWon();
        }

    }

    @FXML
    private void modifyScoresheetButtonAction(ActionEvent event) {

        Dialog dialog = new Dialog<>();
        dialog.setTitle("Choose Scoresheet");
        dialog.setHeaderText("Please select scoresheet you wish to modify:");
        dialog.setResizable(true);

        Label label1 = new Label("Scoresheet: ");
        ChoiceBox sheetChoice = new ChoiceBox();
        sheetChoice.getItems().setAll(OOSD2Coursework.matchList);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        grid.add(label1, 0, 0);
        grid.add(sheetChoice, 1, 0);

        dialog.getDialogPane().setContent(grid);

        ButtonType buttonTypeOk = new ButtonType("OK", ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().add(buttonTypeOk);

        dialog.showAndWait();
        List<String> scoreValueList = newMatch.getScores();
        String home = "n/a", away = "n/a";
        List<Player> pListh = new ArrayList<Player>();
        List<Player> pLista = new ArrayList<Player>();

        for (int i = 0; i < OOSD2Coursework.matchList.size(); i++) {
            if (sheetChoice.getValue().toString().equals(OOSD2Coursework.matchList.get(i).toString())) { //compared chosen object to all in the list to find the chosen team.
                scoreValueList = OOSD2Coursework.matchList.get(i).getScores();
                home = OOSD2Coursework.matchList.get(i).getHomeTeam().toString();
                away = OOSD2Coursework.matchList.get(i).getAwayTeam().toString();
                pListh = OOSD2Coursework.matchList.get(i).getHomeTeam().getPlayers();
                pLista = OOSD2Coursework.matchList.get(i).getAwayTeam().getPlayers();
                //System.out.println("MATCH FOUND FOR MODIFY");
                choiceAwayPlayer1.setValue(OOSD2Coursework.matchList.get(i).getAwayPlayer1());
                choiceAwayPlayer2.setValue(OOSD2Coursework.matchList.get(i).getAwayPlayer2());
                choiceHomePlayer1.setValue(OOSD2Coursework.matchList.get(i).getHomePlayer1());
                choiceHomePlayer2.setValue(OOSD2Coursework.matchList.get(i).getHomePlayer2());
            }
        }

        choiceAwayPlayer1.getItems().setAll(pLista);
        choiceAwayPlayer2.getItems().setAll(pLista);
        choiceHomePlayer1.getItems().setAll(pListh);
        choiceHomePlayer2.getItems().setAll(pListh);
        homeTeamLabel.setText(home);
        awayTeamLabel.setText(away);
        box_11set1.setText(scoreValueList.get(0));
        box_11set2.setText(scoreValueList.get(1));
        box_11set3.setText(scoreValueList.get(2));
        box_12set1.setText(scoreValueList.get(3));
        box_12set2.setText(scoreValueList.get(4));
        box_12set3.setText(scoreValueList.get(5));
        box_21set1.setText(scoreValueList.get(6));
        box_21set2.setText(scoreValueList.get(7));
        box_21set3.setText(scoreValueList.get(8));
        box_22set1.setText(scoreValueList.get(9));
        box_22set2.setText(scoreValueList.get(10));
        box_22set3.setText(scoreValueList.get(11));
        box_Dset1.setText(scoreValueList.get(12));
        box_Dset2.setText(scoreValueList.get(13));
        box_Dset3.setText(scoreValueList.get(14));

    }

    @FXML
    private void chooseTeamButtonAction(ActionEvent event) {
        Dialog dialog = new Dialog<>();
        dialog.setTitle("Choose teams...");
        dialog.setHeaderText("Please choose the home and away teams:");
        dialog.setResizable(true);

        Label label1 = new Label("Home: ");
        Label label2 = new Label("Away: ");
        ChoiceBox homeChoice = new ChoiceBox();
        homeChoice.getItems().setAll(OOSD2Coursework.teamList);
        //homeChoice.getItems().add("<home team>");
        ChoiceBox awayChoice = new ChoiceBox();
        awayChoice.getItems().setAll(OOSD2Coursework.teamList);
        //awayChoice.getItems().add("<away team>");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        grid.add(label1, 0, 0);
        grid.add(homeChoice, 1, 0);
        grid.add(label2, 0, 1);
        grid.add(awayChoice, 1, 1);
        dialog.getDialogPane().setContent(grid);

        ButtonType buttonTypeOk = new ButtonType("OK", ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().add(buttonTypeOk);

        dialog.showAndWait();

        for (int i = 0; i < OOSD2Coursework.teamList.size(); i++) {
            if (homeChoice.getValue().toString() == OOSD2Coursework.teamList.get(i).toString()) { //compared chosen object to all in the list to find the chosen team.
                newMatch.setHomeTeam(OOSD2Coursework.teamList.get(i));
            }
        }
        for (int e = 0; e < OOSD2Coursework.teamList.size(); e++) {
            if (awayChoice.getValue().toString() == OOSD2Coursework.teamList.get(e).toString()) { //compared chosen object to all in the list to find the chosen team.
                newMatch.setAwayTeam(OOSD2Coursework.teamList.get(e));
            }
        }

        homeTeamLabel.setText(newMatch.getHomeTeam().toString());
        awayTeamLabel.setText(newMatch.getAwayTeam().toString());
        choiceAwayPlayer1.getItems().setAll(newMatch.getAwayTeam().getPlayers());
        choiceAwayPlayer2.getItems().setAll(newMatch.getAwayTeam().getPlayers());
        choiceHomePlayer1.getItems().setAll(newMatch.getHomeTeam().getPlayers());
        choiceHomePlayer2.getItems().setAll(newMatch.getHomeTeam().getPlayers());
        //OOSD2Coursework.matchList.add(newMatch); NEED TO SAVE MATCH
        //homeChoice.getValue()
        //awayChoice.getValue()

    }

    @FXML
    private void addTeamButtonAction(ActionEvent event) {
        String t;
        t = adminTeamNameTextbox.getText().toString();
        System.out.println(t);
        Team tempTeam = new Team(adminTeamNameTextbox.getText().toString());
        //OOSD2Coursework.teamList.add(tempTeam);
        OOSD2Coursework.teamList.add(tempTeam);
        System.out.println(OOSD2Coursework.teamList);

        addTeamListBox.getItems().setAll(OOSD2Coursework.teamList);
        timer();

    }

    @FXML
    private void addPlayerButtonAction(ActionEvent event) {
        Object tempTeam = addTeamListBox.getSelectionModel().getSelectedItem();
        tempTeam.toString();

        for (int i = 0; i < OOSD2Coursework.teamList.size(); i++) {
            if (tempTeam.toString() == OOSD2Coursework.teamList.get(i).toString()) { //compared chosen object to all in the list to find the chosen team.
                OOSD2Coursework.teamList.get(i).addPlayer(adminPlayerNameTextbox.getText().toString());
            }

        }
        System.out.println(addTeamListBox.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void finishGameButtonAction(ActionEvent event) {
        //newMatch.getFixture().resetScore();

        //newMatch.getFixture().homeTeamScore = 0;
        //newMatch.getFixture().awayTeamScore = 0;
        newMatch.getFixture().homeTeam.increaseMatchesPlayed();
        newMatch.getFixture().awayTeam.increaseMatchesPlayed();
        if (newMatch.getFixture().calculateWinner().equals(newMatch.getFixture().homeTeam.toString())) {
            newMatch.getFixture().homeTeam.increaseMatchesWon();
            System.out.println("home won this game");
        }
        if (newMatch.getFixture().calculateWinner().equals(newMatch.getFixture().awayTeam.toString())) {
            newMatch.getFixture().awayTeam.increaseMatchesWon();
            System.out.println("away won this game");

            saveScoreSheetButtonAction(event);
            newMatch.getHomeTeam().resetSetsWon();
            newMatch.getAwayTeam().resetSetsWon();
            newMatch.calculateScores();
        }
    }

    @FXML
    private void teamStatsButtonAction(ActionEvent event) {
        StringJoiner joiner = new StringJoiner("\n");
        for (int i = 0; i < OOSD2Coursework.teamList.size(); i++) {
            joiner
                    .add("Team: " + OOSD2Coursework.teamList.get(i).toString() + "  --  "
                            + "  Matches Played:  " + String.valueOf(OOSD2Coursework.teamList.get(i).getMatchesPlayed())
                            + "  Matches Won: " + String.valueOf(OOSD2Coursework.teamList.get(i).getMatchesWon())
                            + "  Sets Won: " + String.valueOf(OOSD2Coursework.teamList.get(i).getWonSets()));

        }

        resultField.setText("\n" + joiner.toString());
    }

    @FXML
    private void resultFixtureAction(ActionEvent event) {
        StringJoiner joiner = new StringJoiner("\n");
        for (int i = 0; i < OOSD2Coursework.fixtureList.size(); i++) {
            joiner
                    .add(OOSD2Coursework.fixtureList.get(i).toString() + " Score:  "
                            + String.valueOf(OOSD2Coursework.fixtureList.get(i).getHomeScore())
                            + "-"
                            + String.valueOf(OOSD2Coursework.fixtureList.get(i).getAwayScore()))
                    .add(String.valueOf("Winner is: " + OOSD2Coursework.fixtureList.get(i).calculateWinner()))
                    .add("\n");
        }

        resultField.setText("\n" + joiner.toString());
    }

    @FXML
    private void teamRankingsButtonAction(ActionEvent event) {
        List<Team> rankList = OOSD2Coursework.teamList;
        Comparator<Team> bySetsWon = (sets1, sets2) -> Integer.compare(sets2.getWonSets(), sets1.getWonSets());
        StringJoiner joiner = new StringJoiner("\n");
        Collections.sort(rankList, bySetsWon);
        for (int i = 0; i < OOSD2Coursework.teamList.size(); i++) {
            joiner.add(String.valueOf(i + 1)
                    + ".  Team: " + OOSD2Coursework.teamList.get(i).toString()
                    + "  Sets won: " + String.valueOf(OOSD2Coursework.teamList.get(i).getWonSets()));
        }
        resultField.setText("\n" + joiner.toString());

    }

    @FXML
    private void matchScoresButtonAction(ActionEvent event) {
        Dialog dialog = new Dialog<>();
        dialog.setTitle("Choose a Match");
        dialog.setHeaderText("Please select a match that you wish to display the scores for:");
        dialog.setResizable(true);

        Label label1 = new Label("Match: ");
        ChoiceBox sheetChoice = new ChoiceBox();
        sheetChoice.getItems().setAll(OOSD2Coursework.matchList);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        grid.add(label1, 0, 0);
        grid.add(sheetChoice, 1, 0);

        dialog.getDialogPane().setContent(grid);

        ButtonType buttonTypeOk = new ButtonType("OK", ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().add(buttonTypeOk);

        dialog.showAndWait();
        StringJoiner joiner = new StringJoiner("\n");
        StringJoiner joiner2 = new StringJoiner(" ");
        StringJoiner joiner3 = new StringJoiner(" ");
        StringJoiner joiner4 = new StringJoiner(" ");
        StringJoiner joiner5 = new StringJoiner(" ");
        StringJoiner joiner6 = new StringJoiner(" ");
        for (int i = 0; i < OOSD2Coursework.matchList.size(); i++) {
            if (sheetChoice.getValue().toString().equals(OOSD2Coursework.matchList.get(i).toString())) {
                joiner.add("Match:  " + OOSD2Coursework.matchList.get(i).toString())
                        .add("  ====Single sets====");
                List<String> set = OOSD2Coursework.matchList.get(i).getSet(1);
                joiner2.add("Set 1: ");
                joiner2.add(OOSD2Coursework.matchList.get(i).getHomePlayer1() + " vs. " + OOSD2Coursework.matchList.get(i).getAwayPlayer1() + " : ");
                for (int a = 0; a < 3; a++) {
                    joiner2.add(set.get(a));
                }
                joiner.add(joiner2.toString());

                set = OOSD2Coursework.matchList.get(i).getSet(2);
                joiner3.add("Set 2: ");
                joiner3.add(OOSD2Coursework.matchList.get(i).getHomePlayer1() + " vs. " + OOSD2Coursework.matchList.get(i).getAwayPlayer2() + " : ");
                for (int a = 0; a < 3; a++) {
                    joiner3.add(set.get(a));
                }
                joiner.add(joiner3.toString());

                set = OOSD2Coursework.matchList.get(i).getSet(3);
                joiner4.add("Set 3: ");
                joiner4.add(OOSD2Coursework.matchList.get(i).getHomePlayer2() + " vs. " + OOSD2Coursework.matchList.get(i).getAwayPlayer1() + " : ");
                for (int a = 0; a < 3; a++) {
                    joiner4.add(set.get(a));
                }
                joiner.add(joiner4.toString());

                set = OOSD2Coursework.matchList.get(i).getSet(4);
                joiner5.add("Set 4: ");
                joiner5.add(OOSD2Coursework.matchList.get(i).getHomePlayer2() + " vs. " + OOSD2Coursework.matchList.get(i).getAwayPlayer2() + " : ");
                for (int a = 0; a < 3; a++) {
                    joiner5.add(set.get(a));
                }
                joiner.add(joiner5.toString());

                joiner.add("  ====Double sets====");
                set = OOSD2Coursework.matchList.get(i).getSet(5);
                joiner6.add("Double set: ");
                joiner6.add("(" + OOSD2Coursework.matchList.get(i).getHomePlayer1() + " & " + OOSD2Coursework.matchList.get(i).getHomePlayer2() + ")"
                        + "  vs.  " + "(" + OOSD2Coursework.matchList.get(i).getAwayPlayer1() + " & " + OOSD2Coursework.matchList.get(i).getAwayPlayer2() + ")" + " : ");
                for (int a = 0; a < 3; a++) {
                    joiner6.add(set.get(a));
                }
                joiner.add(joiner6.toString());
                joiner.add("final score: " + OOSD2Coursework.matchList.get(i).getHomeTeam().getWonSets() + " : " + OOSD2Coursework.matchList.get(i).getAwayTeam().getWonSets());

            }
        }
        resultField.setText("\n" + joiner.toString());

    }

    @FXML
    public void generateReportButtonAction(ActionEvent event) {
        System.out.println("generate report");
        StringJoiner joiner = new StringJoiner("\n");
        for (int i = 0; i < OOSD2Coursework.teamList.size(); i++) {
            joiner
                    .add("Team: " + OOSD2Coursework.teamList.get(i).toString() + "  --  "
                            + "  Matches Played:  " + String.valueOf(OOSD2Coursework.teamList.get(i).getMatchesPlayed())
                            + "  Matches Won: " + String.valueOf(OOSD2Coursework.teamList.get(i).getMatchesWon())
                            + "  Sets Won: " + String.valueOf(OOSD2Coursework.teamList.get(i).getWonSets()));

        }

        aResultField.setText("\n" + joiner.toString());
    }

    Timer timer = new Timer();

    public void timer() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    public void run() {
                        autoGen();
                    }
                }
                );
            }
        }, 100000, 100000); //Every 100 seconds
    }

    public void autoGen() {
        System.out.println("automatically generated report");
        StringJoiner joiner = new StringJoiner("\n");
        for (int i = 0; i < OOSD2Coursework.teamList.size(); i++) {
            joiner
                    .add("Team: " + OOSD2Coursework.teamList.get(i).toString() + "  --  "
                            + "  Matches Played:  " + String.valueOf(OOSD2Coursework.teamList.get(i).getMatchesPlayed())
                            + "  Matches Won: " + String.valueOf(OOSD2Coursework.teamList.get(i).getMatchesWon())
                            + "  Sets Won: " + String.valueOf(OOSD2Coursework.teamList.get(i).getWonSets()));

        }

        aResultField.setText("\n" + joiner.toString());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        addTeamListBox.getItems().setAll(OOSD2Coursework.teamList);
    }

}
