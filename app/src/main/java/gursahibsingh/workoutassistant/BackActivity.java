package gursahibsingh.workoutassistant;

import android.content.Context;
import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

public class BackActivity extends AppCompatActivity {

    Button addButton;
    Spinner spinnerBack;
    EditText newExe;
    String exe="";
    ArrayList<String> backExercises = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_back);
        final RecyclerView programmingList=(RecyclerView) findViewById(R.id.programmingList);
        programmingList.setLayoutManager(new LinearLayoutManager(this));
        //programmingList.setAdapter(new programmingAdapter(exercises));
        final programmingAdapter tempAdapter=new programmingAdapter(backExercises);
        programmingList.setAdapter(tempAdapter);
        newExe=(EditText) findViewById(R.id.newExe_Back);
        addButton=(Button) findViewById(R.id.addButton_Back);
        addButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                exe = newExe.getText().toString();
                if(exe.matches("")){
                    Toast toast=Toast.makeText(getApplicationContext(),"Enter Exercise Name",Toast.LENGTH_SHORT);
                    toast.show();
                }
                else {
                    newExe.setText("");
                    tempAdapter.addExercise(exe);
                }
            }
        });


        spinnerBack=(Spinner)findViewById(R.id.spinner_Back);
        String[] nextFromBack={"Next","Chest","Bicep","Tricep","Shoulder","Legs"};
        ArrayAdapter<String> adap=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,nextFromBack);
        adap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBack.setAdapter(adap);
        spinnerBack.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    case 1:
                        Intent intent = new Intent(BackActivity.this, ChestActivity.class);
                        startActivity(intent);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

}