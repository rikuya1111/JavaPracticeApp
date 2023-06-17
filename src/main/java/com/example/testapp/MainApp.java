package com.example.testapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.HashMap;

/*
* Applicationクラスを継承
*/
public class MainApp extends Application {
    /*
    * グローバル関数の配列を作成
    * 使用用途 : ログイン情報の管理に使用
    * */
    public static HashMap<String, Object> Info = new HashMap<>();
    /*
    * start()メソッドがApplicationクラスの抽象メソッドであるstart(Stage primaryStage)をオーバーライドしているため、@Overrideアノテーションを使用している。
    * 最初に読み込むページ（FirstScreen.fxml）を設定し、そのページを表示するためのシーンを作成し、primaryStageに設定している。
    */
    @Override
    public void start(Stage primaryStage) {
        try {
//          最初に読み込むページの設定
            FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
            Parent root = loader.load();
//            FirstScreenController controller = loader.getController();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
    *launch(args)メソッドはJavaFXアプリケーションスレッドを開始し、Applicationクラスのstart(Stage primaryStage)メソッドを呼び出す。
    */
    public static void main(String[] args) {
        launch(args);
    }
}