package gursahibsingh.workoutassistant;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class IntroActivity extends AppCompatActivity {
    private static final String TAG="appmessages";
    Button chestButton;
    Button backButton;
    Button bicepButton;
    Button tricepButton;
    Button shoulderButton;
    Button legButton;


    public void init(){
        chestButton=(Button)findViewById(R.id.button_chest);
        chestButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent toy=new Intent(IntroActivity.this,ChestActivity.class);
                startActivity(toy);
            }
        });
        backButton=(Button)findViewById(R.id.button_back);
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent toy=new Intent(IntroActivity.this,BackActivity.class);
                startActivity(toy);
            }
        });
        /*
        bicepButton=(Button)findViewById(R.id.button_bicep);
        bicepButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent toy=new Intent(IntroActivity.this,BicepActivity.class);
                startActivity(toy);
            }
        });
        tricepButton=(Button)findViewById(R.id.button_tricep);
        tricepButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent toy=new Intent(IntroActivity.this,TricepActivity.class);
                startActivity(toy);
            }
        });

        legButton=(Button)findViewById(R.id.button_leg);
        legButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent toy=new Intent(IntroActivity.this,LegActivity.class);
                startActivity(toy);
            }
        });
        */
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        init();
        Log.i(TAG,"onCreate");
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
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"onResume");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState");
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "onRestoreInstanceState");
    }


}
