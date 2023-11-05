package com.main.pokemonmanager.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.util.List;

import com.main.pokemonmanager.Pokemon;
import com.main.pokemonmanager.R;

public class SimpleStringAdapter extends Adapter<SimpleStringHolder> {
    private LayoutInflater inflater;
    private List<Pokemon> originalData;

    public SimpleStringAdapter(Context context, List<Pokemon> originalData) {
        this.inflater = LayoutInflater.from(context);
        this.originalData = originalData;
    }

    @NonNull
    @Override
    public SimpleStringHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SimpleStringHolder(inflater.inflate(R.layout.listitem_string, parent, false), 2, 3);
    }

    @Override
    public void onBindViewHolder(@NonNull SimpleStringHolder holder, int position) {
        Pokemon temp = originalData.get(position);
        holder.setTextForTable(temp.getName(), 1, 1);
        holder.setTextForTable(temp.getType().toString(), 1, 2);
        holder.setTextForTable("#"+temp.getNumber(), 1, 3);
        holder.setTextForTable(temp.getOwner().toString(), 2, 1);
        holder.setTextForTable("Swaps: "+temp.getSwaps().toArray().length, 2, 2);
        holder.setTextForTable("Competitions: "+temp.getCompetitions().toArray().length, 2, 3);
    }

    @Override
    public int getItemCount() {
        return originalData.size();
    }
}

class SimpleStringHolder extends ViewHolder {

    //private TextView textView;
    private int _columns;
    private TextView[] textViewForTable;
    private int[] itemViews = {R.id.r1c1, R.id.r1c2, R.id.r1c3, R.id.r2c1, R.id.r2c2, R.id.r2c3};


    /*public SimpleStringHolder(@NonNull View itemView) {
        super(itemView);
    }*/

    public SimpleStringHolder(@NonNull View itemView, int rows, int columns) {
        super(itemView);
        _columns = columns;
        textViewForTable = new TextView[rows*columns];
    }

   /* public void setText(String text) {
        textView = itemView.findViewById(id);
        //itemView.setTag(this);
        this.textView.setText(text);
    }*/

    public void setTextForTable(String text, int r, int c) {
        textViewForTable[(r-1)*_columns + c - 1] = itemView.findViewById(itemViews[(r-1)*_columns + c - 1]);
        //itemView.setTag(this);
        this.textViewForTable[(r-1)*_columns + c - 1].setText(text);
    }
}