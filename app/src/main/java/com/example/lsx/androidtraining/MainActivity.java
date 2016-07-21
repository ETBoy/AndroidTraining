package com.example.lsx.androidtraining;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button btOk,btCancel;
    EditText etLoginName,etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        btOk=(Button)findViewById(R.id.content_main_btOk);
        btCancel=(Button) findViewById(R.id.content_main_btCancel);
        btOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etLoginName=(EditText) findViewById(R.id.content_main_etLoginName);
                String strLoginName= etLoginName.getText().toString();
                etPassword = (EditText)findViewById(R.id.content_main_etPassword);
                String strPassword=etPassword.getText().toString();
                if(strLoginName=="Admin" && strPassword=="123456")
                {
                    //Toast.makeText(MainActivity.this, "登录成功！", Toast.LENGTH_SHORT).show();
                    Log.d("MainActivity","用户登录成功，进入系统。");
                }
                else
                {
                    AlertDialog.Builder dialog=new AlertDialog.Builder(MainActivity.this);
                    dialog.setTitle("错误提示");
                    dialog.setMessage("登录帐号或密码有误！请重试！");
                    dialog.setCancelable(false);
                    dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    dialog.setNegativeButton("关闭", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    dialog.show();
                  //  Toast.makeText(MainActivity.this, "登录帐号或密码有误！请重试！", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
