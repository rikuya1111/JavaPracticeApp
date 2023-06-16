package com.example.testapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.testapp.MainApp.Info;

public class SecondScreenController {

    public VBox Home;
    @FXML
    private Button button;
    @FXML
    private String text;
    @FXML
    //    表示
    public void initialize() {
        if (Info != null && Info.get("login") != null && (boolean) Info.get("login")) {
            /*
            * 画面遷移のロジック
            * 例: 新しいFXMLファイルをロードしてUIを切り替える
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
    /*
    * 遷移元からのデータの取得
    */
    public void setUser(String user_Name,String user_Email) {
        /*
        *グローバル変数(Info)にログイン情報を追加。
        */
        Info.put("name", user_Name);
        Info.put("email", user_Email);
        Info.put("login", true);
        /*
        * 遷移元からのデータ(initialize)の取得
        */
        initialize();
    }

    /*
    * goBackを押したときの処理
    */
    @FXML
    protected void goBack(ActionEvent event) {
        try {
            /*
            * 遷移先のfxmlファイルを読み込んでいる。
            * */
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FirstScreen.fxml"));
            Parent root = loader.load();
            FirstScreenController controller = loader.getController();
            Scene firstScene = new Scene(root);
            /*
            *今表示しているウィンドウのデータを取得している。
            */
            Stage stage = (Stage) button.getScene().getWindow();
            /*
            * 遷移先のページの表示
            */
            stage.setScene(firstScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
