package com.example.quizapp.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.quizapp.Adapters.CategoryAdapter;
import com.example.quizapp.Fragments.HomeFragment;
import com.example.quizapp.Fragments.LeaderboardsFragment;
import com.example.quizapp.Fragments.ProfileFragment;
import com.example.quizapp.Fragments.WalletFragment;
import com.example.quizapp.Models.CategoryModel;
import com.example.quizapp.R;
import com.example.quizapp.databinding.ActivityMainBinding;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

import me.ibrahimsn.lib.OnItemReselectedListener;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    //FirebaseFirestore database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
       //setSupportActionBar(binding.toolbar);
        //database = FirebaseFirestore.getInstance();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, new HomeFragment());
        transaction.commit();

        binding.bottomBar.setOnItemReselectedListener(new OnItemReselectedListener() {
            @Override
            public void onItemReselect(int i) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                switch (i){
                    case 0:
                        transaction.replace(R.id.content, new HomeFragment());
                        transaction.commit();
                       // Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        transaction.replace(R.id.content, new LeaderboardsFragment());
                        transaction.commit();
                       // Toast.makeText(MainActivity.this, "Rank", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        transaction.replace(R.id.content, new WalletFragment());
                        transaction.commit();
                        //Toast.makeText(MainActivity.this, "Wallet", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        transaction.replace(R.id.content, new ProfileFragment());
                        transaction.commit();
                        break;
                }
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.wallet){
            Toast.makeText(this, "Wallet is clicked.", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
}