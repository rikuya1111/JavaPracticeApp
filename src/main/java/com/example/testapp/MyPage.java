package com.example.testapp;

import com.example.testapp.component.Login_Info;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.testapp.MainApp.Info;

public class MyPage extends Login_Info {
    public Button Logout;
    public Button Home;
    @FXML
    private Label WelcomeName;
    @FXML
    private Label WelcomeEmail;
    public void initialize() {
        if (Info != null && Info.get("login") != null && (boolean) Info.get("login")) {
            /*
             *グローバル変数(Info)から名前とメールアドレスを取得
             * fxmlファイル(LoginNow.fxml)のlabelにデータを表示
             */
            String name = (String) MainApp.Info.get("name");
            String email = (String) MainApp.Info.get("email");
            WelcomeName.setText("Name: " + name);
            WelcomeEmail.setText("Email: " + email);
        }
    }



    public void goToLogout(ActionEvent actionEvent) {
        /*
         *グローバル変数(Info)にログイン情報を追加。
         */
        setUserLogout();
        try {
            /*
             * fxmlファイル(SecondScreen.fxml)の読み込み
             */
            FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
            Parent root = loader.load();
            Scene secondScene = new Scene(root);

            /*
             * 現在のウィンドウのStageオブジェクトを取得
             */
            Stage stage = (Stage) Logout.getScene().getWindow();
            /*
             * 新しいシーンを設定
             */
            stage.setScene(secondScene);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void goToHome(ActionEvent actionEvent) {try {
        /*
         * fxmlファイル(SecondScreen.fxml)の読み込み
         * */
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
        Parent root = loader.load();
        Scene secondScene = new Scene(root);
        /*
         * 現在のウィンドウのStageオブジェクトを取得
         */
        Stage stage = (Stage) Logout.getScene().getWindow();
        /*
         * 新しいシーンを設定
         */
        stage.setScene(secondScene);
    } catch (IOException e) {
        e.printStackTrace();
    }

    }
}
