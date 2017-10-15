package com.example.zhang.na;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import java.util.HashMap;

import static com.example.zhang.na.R.id.sign_in_button;

/**
 * Created by 张硕 on 2017/10/13.
 */

public class LoginActiviyt extends Activity{
    private EditText user_text;
    private EditText password_text;
    private Button sign_in;
    private Button sign_up;
    private SharedPreferences setting;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login);
        user_text = (EditText) findViewById(R.id.user);
        password_text = (EditText) findViewById(R.id.password);
        sign_in = (Button) findViewById(sign_in_button);
        sign_up = (Button) findViewById(R.id.sign_up_button);
        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = user_text.getText().toString();
                String password = password_text.getText().toString();
                if(TextUtils.isEmpty(user)){
                    user_text.setError(getString(R.string.user_empty));
                }else if(TextUtils.isEmpty(password)){
                    password_text.setError(getString(R.string.password_empty));
                }else attempt_login_in(user,password);
            }});}
    public void attempt_login_in(String user,String password){

        HashMap<String,String> urlParams = new HashMap<String,String>();
        urlParams.put("user",user);
        urlParams.put("password",user);
        try{
            this.doTaskAsync(C.task.login,C.apilogin,urlParams);
        }catch(Exception e){e.printStackTrace();}

    }
}
