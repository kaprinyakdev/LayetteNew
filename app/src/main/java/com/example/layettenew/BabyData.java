package com.example.layettenew;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class BabyData extends AppCompatActivity {

    FloatingActionButton addNewBabyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baby_data);

        addNewBabyButton = findViewById(R.id.addNewBabyButton);

        addNewBabyButton.setOnClickListener(v -> {
            Toast.makeText(this,"asd",Toast.LENGTH_SHORT).show();
        });
    }
}
