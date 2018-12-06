package gursahibsingh.workoutassistant;

import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
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
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Spinner;

public class ChestActivity extends AppCompatActivity  {

    Button addButton;
    EditText newExe;
    String exe="";
    Spinner spinnerChest;
    ArrayList<String> chestExercises = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_chest);
        final RecyclerView programmingList=(RecyclerView) findViewById(R.id.programmingList);
        programmingList.setLayoutManager(new LinearLayoutManager(this));
        //programmingList.setAdapter(new programmingAdapter(exercises));
        final programmingAdapter tempAdapter=new programmingAdapter(chestExercises);
        programmingList.setAdapter(tempAdapter);
        newExe=(EditText) findViewById(R.id.newExe_Chest);
        addButton=(Button) findViewById(R.id.addButton_Chest);
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


        //Next Activity Spinner
        spinnerChest=(Spinner)findViewById(R.id.spinner_Chest);
        String[] nextFromChest={"Next","Back","Bicep","Tricep","Shoulder","Legs"};
        ArrayAdapter<String> adap=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,nextFromChest);
        adap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerChest.setAdapter(adap);
        spinnerChest.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    case 1:
                        Intent intent = new Intent(ChestActivity.this, BackActivity.class);
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