package com.example.testapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.testapp.MainApp.Info;

public class Home {

    @FXML
    public Button Mypage;
    @FXML
    public Button Resister;
    @FXML
    public HBox Resister_VBox;
    @FXML
    public HBox Mypage_VBox;

    public void initialize() {
        /*
         * Infoがnullじゃないなら
         * Info.get("login") != nullじゃないなら
         * (boolean) Info.get("login")がtrueなら
         */
        if (Info != null && Info.get("login") != null && (boolean) Info.get("login")) {
            /*
             * 無効化と非表示
             */
            Resister_VBox .setDisable(true);
            Resister.setVisible(false);
        }else{
            /*
             * 無効化と非表示
             */
            Mypage_VBox .setDisable(true);
            Mypage.setVisible(false);
        }
    }

    @FXML
    public void goToMypage(ActionEvent actionEvent) {
        try {
            /*
             * fxmlファイル(SecondScreen.fxml)の読み込み
             * */
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginNow.fxml"));
            Parent root = loader.load();
            Scene secondScene = new Scene(root);
            /*
             * 現在のウィンドウのStageオブジェクトを取得
             */
            Stage stage = (Stage) Mypage.getScene().getWindow();
            /*
             * 新しいシーンを設定
             */
            stage.setScene(secondScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void goToResister(ActionEvent actionEvent) {
        try {
            /*
             * fxmlファイル(SecondScreen.fxml)の読み込み
             * */
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FirstScreen.fxml"));
            Parent root = loader.load();
            Scene secondScene = new Scene(root);
            /*
             * 現在のウィンドウのStageオブジェクトを取得
             */
            Stage stage = (Stage) Resister.getScene().getWindow();
            /*
             * 新しいシーンを設定
             */
            stage.setScene(secondScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
