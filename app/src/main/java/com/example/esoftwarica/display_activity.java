package com.example.esoftwarica;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.esoftwarica.Model.Students;
import com.example.esoftwarica.ui.dashboard.DashboardFragment;
import com.example.esoftwarica.ui.home.HomeFragment;
import com.example.esoftwarica.ui.notifications.NotificationsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.ArrayList;
import java.util.List;

public class display_activity extends AppCompatActivity {
    public static List<Students> StudentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_activity);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();

        getSupportActionBar().hide();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);


        StudentList = new ArrayList<>();

        StudentList.add(new Students("Asmita Adhikari", "Kathmandu", "Female", 21, R.drawable.female));
    }

       private BottomNavigationView.OnNavigationItemSelectedListener navListner=
               new BottomNavigationView.OnNavigationItemSelectedListener() {
                   @Override
                   public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                       Fragment selectFragment = null;
                       switch (item.getItemId()) {
                           case R.id.navigation_home:
                               selectFragment = new HomeFragment();
                               break;
                           case R.id.navigation_dashboard:
                               selectFragment = new DashboardFragment();
                               break;
                           case R.id.navigation_notifications:
                               selectFragment = new NotificationsFragment();
                               break;
                       }
                       getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,
                               selectFragment).commit();
                       return true;
                   }
               };
    }
