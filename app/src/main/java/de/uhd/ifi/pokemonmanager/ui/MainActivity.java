package de.uhd.ifi.pokemonmanager.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import de.uhd.ifi.pokemonmanager.R;
import de.uhd.ifi.pokemonmanager.data.Pokemon;
import de.uhd.ifi.pokemonmanager.data.Trainer;
import de.uhd.ifi.pokemonmanager.data.Type;
import de.uhd.ifi.pokemonmanager.storage.SerialStorage;
import de.uhd.ifi.pokemonmanager.ui.adapter.PokemonAdapter;
import de.uhd.ifi.pokemonmanager.ui.util.RecyclerViewUtil;

/**
 * Main Android activity for this app. Needs to be run to start the app.
 */
public class MainActivity extends AppCompatActivity {
    public static final String DETAIL_POKEMON = "detail_pokemon";
    private static final SerialStorage STORAGE = SerialStorage.getInstance();

    // UI widget to show a list of pokemons
    private RecyclerView pokemonList;
    private PokemonAdapter pokemonAdapter;

    private FloatingActionButton addPokemonButton;

    private FloatingActionButton deleteButton;

    private TextView TextPokemonName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pokemonList = findViewById(R.id.pokemonList);
        addPokemonButton = findViewById(R.id.addPokemonButton);

        STORAGE.loadAll(this);
        setupList();
        initUI();
    }

    private void setupList() {
        createSampleDataIfNecessary();
        List<Pokemon> pokemons = STORAGE.getAllPokemons();
        pokemonAdapter = new PokemonAdapter(this, pokemons);
        RecyclerView.LayoutManager manager = RecyclerViewUtil.createLayoutManager(this);

        pokemonList.setLayoutManager(manager);
        pokemonList.setAdapter(pokemonAdapter);
    }

    public void openDialog()  {
        create_pokemon_dialogue create_dialogue = new create_pokemon_dialogue();
        create_dialogue.show(getSupportFragmentManager(), "create pokemon");
    }
    private void initUI() {
        addPokemonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openDialog();
                //TODO: implement create Pokemon.

                // The pokemon needs to be added to the storage.
                // Don't forget to refresh pokemonAdapter.
                pokemonAdapter.refresh();
                //BONUS: if no Trainers are in Storage the App kinda crashes - how do we prevent that
            }
        });



        deleteButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                builder.setMessage("Do you want to delete this Pokemon?").setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        List<Pokemon> pokemon = STORAGE.getAllPokemons();
                        TextView id = view.findViewById(R.id.pokemonId);
                        STORAGE.remove(pokemon.get(Integer.parseInt((String) id.getText())));
                        pokemonAdapter.refresh();
                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //
                    }
                });
                AlertDialog mDialog = builder.create();
                mDialog.show();
            }
        });
    }


    /**
     * Creates three sample {@link Pokemon} if none are in storage.
     */
    private void createSampleDataIfNecessary() {
        if (STORAGE.getAllPokemons().isEmpty()) {
            STORAGE.clear(this);

            Trainer t1 = new Trainer("Alisa", "Traurig");
            Trainer t2 = new Trainer("Petra", "Lustig");
            Pokemon p1 = new Pokemon("Shiggy", Type.WATER);
            Pokemon p2 = new Pokemon("Rettan", Type.POISON);
            Pokemon p3 = new Pokemon("Glurak", Type.FIRE);

            t1.addPokemon(p1);
            t1.addPokemon(p2);
            t2.addPokemon(p3);

            STORAGE.save(p1);
            STORAGE.save(p2);
            STORAGE.save(p3);
            STORAGE.save(t1);
            STORAGE.save(t2);
            STORAGE.saveAll(this);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        STORAGE.loadAll(this);
        createSampleDataIfNecessary();
        pokemonAdapter.refresh();
    }

    @Override
    protected void onPause() {
        super.onPause();
        STORAGE.saveAll(this);
    }
}
