package com.example.testapp.component;

import static com.example.testapp.MainApp.Info;

    public class Login_Info {
        public void setUserLogin(String user_Name,String user_Email) {
            /*
             *グローバル変数(Info)にログイン情報を追加。
             */
            Info.put("name", user_Name);
            Info.put("email", user_Email);
            Info.put("login", true);
        }

        public void setUserLogout() {
            /*
             *グローバル変数(Info)にログイン情報を追加。
             */
                Info.remove("name");
                Info.remove("email");
                Info.put("login", false);
        }
}
