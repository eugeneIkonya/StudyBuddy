package com.example.studybuddy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class UnitAdapter extends RecyclerView.Adapter<UnitAdapter.UnitViewHolder>
{
    private Context mContext;
    private List<Units> unitList;

    public UnitAdapter(Context mContext, List<Units> unitList) {
        this.mContext = mContext;
        this.unitList = unitList;
    }

    @NonNull
    @Override
    public UnitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view=inflater.inflate(R.layout.unit_layout, null);
        return new UnitViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull UnitViewHolder holder, int position) {
        Units unit=unitList.get(position);
        holder.textViewUnitName.setText(unit.getUnit_name());
        holder.textViewLecturer.setText(unit.getLecturer());
        holder.textViewLecturerEmail.setText(unit.getLecturer_email());
        holder.textViewUnitProgress.setText(unit.getUnit_progress());
        Glide.with(mContext)
                .load(unit.getImage())
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return unitList.size();
    }

    class UnitViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView textViewUnitName, textViewLecturer, textViewLecturerEmail, textViewUnitProgress;


        public UnitViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.imageView);
            textViewUnitName=itemView.findViewById(R.id.textViewTitle);
            textViewLecturer=itemView.findViewById(R.id.textViewLec);
            textViewLecturerEmail=itemView.findViewById(R.id.textViewEmail);
            textViewUnitProgress=itemView.findViewById(R.id.textViewProgress);
        }
    }
}
