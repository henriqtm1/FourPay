package com.example.fourpay.activitys;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.navigation.fragment.NavHostFragment;

import com.example.fourpay.R;
import com.example.fourpay.fragments.HomeFragment;


public class HomeActivity extends AppCompatActivity {

    public static final String KEY_ID = "ID";

    private FragmentContainerView fragmentContainerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        fragmentContainerView = findViewById(R.id.fragmentContainerView);

        Intent getIntent = getIntent();
        Long id = getIntent.getLongExtra(KEY_ID, -1);
        Bundle args = new Bundle();
        args.putLong(HomeFragment.KEY_ID, id);

        NavHostFragment finalHost = NavHostFragment.create(R.navigation.nav_graph_home, args);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainerView, finalHost)
                .setPrimaryNavigationFragment(finalHost)// this is the equivalent to app:defaultNavHost="true"
                .commit();
    }

}



