package com.example.testapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;


import static com.example.testapp.MainApp.Info;

public class FirstScreenController {
    public VBox Home;
    public MenuItem info_help;
    public TextField Email;
    @FXML
    private Button button;
    @FXML
    private TextField Name;

    public void initialize() {
        /*
         * Infoがnullじゃないなら
         * Info.get("login") != nullじゃないなら
         * (boolean) Info.get("login")がtrueなら
         */
        if (Info != null && Info.get("login") != null && (boolean) Info.get("login")) {
            /*
            * 画面遷移のロジック
            * 新しいFXMLファイル(LoginNow.fxml)を読み込んでして画面を遷移
            */
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginNow.fxml"));
                Parent newRoot = loader.load();
                Home.getChildren().setAll(newRoot);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    /*
    * goToSecondScreenを押したときの処理
    */
    protected void goToSecondScreen(ActionEvent event) {
        try {
            /*
            * fxmlファイル(SecondScreen.fxml)の読み込み
            * */
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SecondScreen.fxml"));
            Parent root = loader.load();
            SecondScreenController controller = loader.getController();
            Scene secondScene = new Scene(root);
            /*
            * fxmlファイル(FirstScreen.fxml)のTextFieldからデータの取得
            */
            String user_Name = Name.getText();
            String user_Email = Email.getText();
            /*
            * 遷移先へのテキストの受け渡し
            */
            controller.setUser(user_Name,user_Email);
            /*
            * 現在のウィンドウのStageオブジェクトを取得
            */
            Stage stage = (Stage) button.getScene().getWindow();
            /*
            * 新しいシーンを設定
            */
            stage.setScene(secondScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
