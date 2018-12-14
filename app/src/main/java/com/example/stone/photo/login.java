package com.example.stone.photo;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import android.net.Uri;

public class login extends Activity {

    private EditText accountEdit;
    private EditText passwordEdit;
    private Button login;
    private TextView call;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.login);

        //播放音乐
        MediaPlayer mediaPlayer=MediaPlayer.create(this,R.raw.backgroundmusic);
        try {
            mediaPlayer.prepare();
        }
        catch (IllegalStateException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        mediaPlayer.start();
        mediaPlayer.setLooping(true);

        //拨打电话
        call =(TextView)findViewById(R.id.call);
        call.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:13945973608"));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });


        //登录
        accountEdit = (EditText) findViewById(R.id.login_input_username);
        passwordEdit = (EditText) findViewById(R.id.login_input_password);
        login = (Button) findViewById(R.id.login_btn);

        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String account = accountEdit.getText().toString();
                String password = passwordEdit.getText().toString();

                // 如果账号是xujian且密码是123456，就认为登录成功
                if (account.equals("xujian") && password.equals("123456")) {
                    Intent intent = new Intent(login.this,listview.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(login.this, "登录密码不正确或账户不存在！",
                            Toast.LENGTH_SHORT).show();
                }
            }

        }  );//登录

    }
}
