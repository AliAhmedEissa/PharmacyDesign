package com.example.pharmacydesign;

import android.annotation.SuppressLint;
import android.app.FragmentTransaction;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.pharmacydesign.Orders_Map.MapFr;
import com.example.pharmacydesign.Orders_Map.OrderOnClickFr;
import com.example.pharmacydesign.Orders_Map.Orders;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class MainActivity extends AppCompatActivity {
    MeowBottomNavigation bottomNavigation;
    Toolbar toolbar;
    NavigationView navView;
    DrawerLayout drawerLayout;
    CardView cardView;

    List<String> tabList;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();



        bottomNavigation.setOnClickMenuListener(model -> {
            switch (model.getId()) {
                case 1:
                    Transaction(new Orders());
                    break;
                case 2:
                    Transaction(new MapFr());
                    break;

            }
            return null;
        });
        Transaction(new Orders());

        bottomNavigation.show(1, false);


    }



    private void init() {

        bottomNavigation = findViewById(R.id.bottonNav);
        navView = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);
        cardView = findViewById(R.id.orderitem);


        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_orders));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_map));
        bottomNavigation.show(1, true);

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);

        } else {
            super.onBackPressed();
        }
    }


    private void Transaction(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit();

    }
}