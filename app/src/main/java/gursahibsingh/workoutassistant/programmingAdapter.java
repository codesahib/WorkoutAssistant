package gursahibsingh.workoutassistant;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Gursahib Singh on 11/6/2018.
 */

public class programmingAdapter extends RecyclerView.Adapter<programmingAdapter.programmingViewHolder>{
    private ArrayList<String> data;

    public programmingAdapter(ArrayList<String> data) {
        this.data=data;
    }

    //view create kita gya and ohde corresponding ViewHolder
    //called only when view is created
    @Override
    public programmingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.list_item_layout,parent,false);
        return new programmingViewHolder(view);
    }

    @Override
    //called repeadedly after view is created
    public void onBindViewHolder(programmingViewHolder holder, int position) {
        String title=data.get(position);
        holder.txtTitle.setText(title);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void addExercise(String newExercise)
    {
        data.add(newExercise);
        notifyDataSetChanged();
    }
    public void deleteExercise(int position) {
        data.remove(position);
        notifyItemRemoved(position);
    }

    public class programmingViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imgIcon;
        TextView txtTitle;
        EditText rep;
        EditText weight;
        TextView vol;
        Button calculate;
        int repCount,weightCount,volCount;

        public programmingViewHolder(View itemView) {
            super(itemView);
            imgIcon=(ImageView) itemView.findViewById(R.id.imgIcon);
            txtTitle=(TextView) itemView.findViewById(R.id.txtTitle);
            rep=(EditText) itemView.findViewById(R.id.rep);
            weight=(EditText) itemView.findViewById(R.id.weight);
            vol=(TextView) itemView.findViewById(R.id.vol);
            calculate=(Button) itemView.findViewById(R.id.calculate);
            calculate.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    String repString=rep.getText().toString();
                    String weightString=weight.getText().toString();
                    if(repString.matches("") && weightString.matches("")){
                        Toast toastRepWeight=Toast.makeText(v.getContext(),"Enter No. of Reps and Weight",Toast.LENGTH_SHORT);
                        toastRepWeight.show();
                    }
                    else if(repString.matches("")){
                        Toast toastRep=Toast.makeText(v.getContext(),"Enter No. of Reps",Toast.LENGTH_SHORT);
                        toastRep.show();
                    }
                    else if(weightString.matches("")){
                        Toast toastWeight=Toast.makeText(v.getContext(),"Enter Weight",Toast.LENGTH_SHORT);
                        toastWeight.show();
                    }
                    else{
                        repCount=Integer.parseInt(repString);
                        weightCount=Integer.parseInt(weightString);
                        volCount=repCount*weightCount;
                        String volString=vol.getText().toString();
                        if(volString.matches("")){vol.setText(String.valueOf(volCount));}
                        else{
                            int vol_temp;
                            vol_temp=Integer.parseInt(volString);
                            volCount=volCount+vol_temp;
                            vol.setText(String.valueOf(volCount));
                        }
                        rep.setText("");
                        weight.setText("");
                    }
                }
            });

            imgIcon.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    vol.setText("");
                    deleteExercise(getAdapterPosition());
                }
            });
        }


        @Override
        public void onClick(View view) {

        }
    }
}
