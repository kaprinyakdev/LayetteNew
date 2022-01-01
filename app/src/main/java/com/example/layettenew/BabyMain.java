package com.example.layettenew;

import android.app.Fragment;
import android.app.FragmentManager;
import android.media.Image;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.layettenew.Fragments.BabyDataFragment;
import com.example.layettenew.Fragments.NewBabyFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class BabyMain extends AppCompatActivity {

    FloatingActionButton addNewBabyButton;
    Fragment baby_list, baby_new;
    FragmentManager fragmentManager;
    FrameLayout contentView;
    ImageView currentUserAvatar;
    TextView currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baby_data);

        addNewBabyButton = findViewById(R.id.addNewBabyButton);
        baby_list = new BabyDataFragment();
        baby_new = new NewBabyFragment();
        fragmentManager = getFragmentManager();
        contentView = findViewById(R.id.frame);
        currentUser = findViewById(R.id.currentUser);
        currentUserAvatar = findViewById(R.id.currentUserAvatar);


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

        currentUserAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentUser.getText().length() == 0) {
                    currentUser.setText("asd");
                } else {
                    currentUser.setText("");
                }
            }
        });
    }
}
