package br.dev.joaobussolotto.mobile.quantofaltaprameformar.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.dev.joaobussolotto.mobile.quantofaltaprameformar.R;
import br.dev.joaobussolotto.mobile.quantofaltaprameformar.helper.Util;
import br.dev.joaobussolotto.mobile.quantofaltaprameformar.model.Subject;
import br.dev.joaobussolotto.mobile.quantofaltaprameformar.model.UniversityActivity;

public class AdapterSubjectList extends RecyclerView.Adapter<AdapterSubjectList.MyViewHolder>{


    private List<UniversityActivity> list;


    public AdapterSubjectList(List<UniversityActivity> list){
        this.list = list;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_subject_list,
                parent, false);



        return new MyViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        UniversityActivity activity = list.get(position);
        System.out.println(activity.getDescription() + activity.getId());
            holder.textViewDescription.setText(activity.getDescription());
            holder.textViewDate.setText(activity.dateFormated());
            if(activity instanceof Subject) {
                holder.textViewFinalGrade.setText("Média: " + Util.doubleValueToString(((Subject) activity).getFinalGrade()));
            }
            else {
                holder.textViewFinalGrade.setVisibility(View.INVISIBLE);
            }
            holder.textViewWorkload.setText(String.valueOf(activity.getWorkload()) + "h");
        }


    @Override
    public int getItemCount() {
        return this.list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textViewDescription;
        TextView textViewDate;
        TextView textViewWorkload;
        TextView textViewFinalGrade;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewDescription = itemView.findViewById(R.id.textViewUniActivityDesc);
            textViewDate = itemView.findViewById(R.id.textViewUniActivityDate);
            textViewFinalGrade = itemView.findViewById(R.id.textViewCcrGrade);
            textViewWorkload = itemView.findViewById(R.id.textViewWorkload);
        }
    }

}
