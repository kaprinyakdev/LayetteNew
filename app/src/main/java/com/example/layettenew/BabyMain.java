package com.example.layettenew;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.example.layettenew.Fragments.BabyDataFragment;
import com.example.layettenew.Fragments.NewBabyFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class BabyMain extends AppCompatActivity {

    FloatingActionButton addNewBabyButton;
    Fragment baby_list, baby_new;
    FragmentManager fragmentManager;
    FrameLayout contentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baby_data);

        addNewBabyButton = findViewById(R.id.addNewBabyButton);
        baby_list = new BabyDataFragment();
        baby_new = new NewBabyFragment();
        fragmentManager = getFragmentManager();
        contentView = findViewById(R.id.frame);

        fragmentManager.beginTransaction()
                .replace(contentView.getId(), baby_list)
                .addToBackStack(null)
                .commit();

        addNewBabyButton.setOnClickListener(v -> {

            fragmentManager.beginTransaction()
                    .replace(contentView.getId(), baby_new)
                    .addToBackStack(null)
                    .commit();
        });
    }

}
