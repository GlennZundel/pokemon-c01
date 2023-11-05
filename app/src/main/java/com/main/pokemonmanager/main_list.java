package com.main.pokemonmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.main.pokemonmanager.adapter.SimpleStringAdapter;
import java.util.List;
import java.util.Arrays;
import android.os.Bundle;

public class main_list extends AppCompatActivity {

    private RecyclerView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list);
        list = findViewById(R.id.list);
        setupList();
    }

    private static List<Pokemon> createSampleData() {
        Pokemon p1 = new Pokemon("Shiggy", Type.WATER, true);
        Pokemon p2 = new Pokemon("Rettan", Type.POISON, true);
        Pokemon p3 = new Pokemon("Glurak", Type.FIRE, true);
        Trainer t1 = new Trainer("Glenn","Zundel");
        Trainer t2 = new Trainer("Julia","Rohrer");
        t1.linkPokemonToTrainer(p1);
        t1.linkPokemonToTrainer(p3);
        t2.linkPokemonToTrainer(p2);
        Competition c1 = new Competition();
        c1.execute(p3,p2);
        Pokemon[] output = {p1, p2, p3};
        return Arrays.asList(output);
    }

    private RecyclerView.LayoutManager createLayoutManager() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        return manager;
    }

    private void setupList() {
        List<Pokemon> data = createSampleData();
        SimpleStringAdapter adapter = new SimpleStringAdapter(this, data);
        final RecyclerView.LayoutManager manager = createLayoutManager();

        list.setLayoutManager(manager);
        list.setAdapter(adapter);
    }
}