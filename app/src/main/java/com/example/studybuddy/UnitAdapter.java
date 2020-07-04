package com.example.studybuddy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UnitAdapter extends RecyclerView.Adapter<UnitAdapter.UnitViewHolder>{
private Context myContext;
private List<Unit>unitList;

    public UnitAdapter(Context myContext, List<Unit> unitList) {
        this.myContext = myContext;
        this.unitList = unitList;
    }

    @NonNull
    @Override
    public UnitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(myContext);
        View view=layoutInflater.inflate(R.layout.unit_layout, null);
        return new UnitViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UnitViewHolder holder, int position) {
        Unit unit=unitList.get(position);

        holder.textViewTitle.setText(unit.getUnitTitle());
        holder.textViewLec.setText(unit.getUnitLec());
        holder.textViewEmail.setText(unit.getLecEmail());
        holder.textViewProgress.setText(unit.getUnitProgress());
        holder.textViewObjectives.setText(unit.getUnitObjectives());

    }

    @Override
    public int getItemCount() {
        return unitList.size();
    }

    class UnitViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView textViewTitle;
        TextView textViewLec;
        TextView textViewEmail;
        TextView textViewProgress;
        TextView textViewObjectives;
        public UnitViewHolder(@NonNull View itemView) {

            super(itemView);

            imageView=itemView.findViewById(R.id.unit_image);
            textViewTitle=itemView.findViewById(R.id.unit_title);
            textViewLec=itemView.findViewById(R.id.unit_lec);
            textViewEmail=itemView.findViewById(R.id.unit_lec_email);
            textViewProgress=itemView.findViewById(R.id.unit_progress);
            textViewObjectives=itemView.findViewById(R.id.unit_objectives);
        }
    }
}
