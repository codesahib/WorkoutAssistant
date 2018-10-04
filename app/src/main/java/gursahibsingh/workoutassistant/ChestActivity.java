package gursahibsingh.workoutassistant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ChestActivity extends AppCompatActivity {
    public Button nextButton;
    public Button b1;
    public Button b2;
    public Button b3;
    public Button b4;
    public Button b5;
    int set;
    int vol;
    int rep;
    int weight;

    public void init(){
        nextButton=(Button)findViewById(R.id.chest_next_button);
        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent toy=new Intent(ChestActivity.this,BackActivity.class);
                startActivity(toy);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_chest);
        init();
        b1=(Button)findViewById(R.id.chest_ex1_button);
        b2=(Button)findViewById(R.id.chest_ex2_button);
        b3=(Button)findViewById(R.id.chest_ex3_button);
        b4=(Button)findViewById(R.id.chest_ex4_button);
        b5=(Button)findViewById(R.id.chest_ex5_button);

        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                TextView txtView=(TextView)findViewById(R.id.chest_ex1_vol);
                EditText t1 = (EditText) findViewById(R.id.chest_ex1_rep);
                EditText t2 = (EditText) findViewById(R.id.chest_ex1_weight);
                EditText t3 = (EditText) findViewById(R.id.chest_ex1_set);

                rep=Integer.parseInt(t1.getText().toString());
                weight=Integer.parseInt(t2.getText().toString());
                set=Integer.parseInt(t3.getText().toString());
                vol=rep*weight;

                if(set==1){txtView.setText(String.valueOf(vol));}
                else{
                    int vol_temp;
                    vol_temp=Integer.parseInt(txtView.getText().toString());
                    vol=vol+vol_temp;
                    txtView.setText(String.valueOf(vol));
                }
                t1.setText("");
                t2.setText("");
                t3.setText("");

            }
        });

    }
}
