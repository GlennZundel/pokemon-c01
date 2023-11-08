package de.uhd.ifi.pokemonmanager.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import de.uhd.ifi.pokemonmanager.R;

public class inputWindow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_window);

        Button confirmationButton = findViewById(R.id.confirmationButton);
        confirmationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the confirmation button click here
                // You can retrieve input values from EditText fields if needed

                // Example: Get text from EditText fields
                EditText editText1 = findViewById(R.id.editText1);
                EditText editText2 = findViewById(R.id.editText2);

                String input1 = editText1.getText().toString();
                String input2 = editText2.getText().toString();

                // Perform actions with input values
            }
        });
    }
}
