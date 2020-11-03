package com.example.pharmacydesign;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.pharmacydesign.Orders_Map.MapFr;
import com.example.pharmacydesign.Orders_Map.OrdersDrFragment;
import com.example.pharmacydesign.Orders_Map.Orders_Done;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    MeowBottomNavigation bottomNavigation;
    Toolbar toolbar;
    NavigationView navView;
    DrawerLayout drawerLayout;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        bottomNavigation.setOnClickMenuListener(model -> {
            switch (model.getId()) {
                case 1:
                    goToFragment(new Orders_Done(), "Order Done");
                    break;
                case 2:
                    goToFragment(new MapFr(),"Map");
                    break;
            }
            return null;
        });
        goToFragment(new Orders_Done(), "Order Done");

        bottomNavigation.show(1, false);
    }

    private void init() {
        bottomNavigation = findViewById(R.id.bottonNav);
        navView = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);

        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_orders));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_map));
        bottomNavigation.show(1, true);

        setSupportActionBar(toolbar);
        navView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
            bottomNavigation.setVisibility(View.VISIBLE);
        } else {
            super.onBackPressed();
        }
    }

    private void goToFragment(Fragment fragment, String tag) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment, tag)
                .addToBackStack(tag)
                .commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.Orders:
                goToFragment(new OrdersDrFragment(), "Order Dr");
                bottomNavigation.setVisibility(View.GONE);
                break;
            case R.id.Profile:
                goToFragment(new ProfileFragment(), "Profile");
                bottomNavigation.setVisibility(View.GONE);
                break;
            case R.id.Faq:
                Toast.makeText(this, "Faq", Toast.LENGTH_SHORT).show();
                break;
            case R.id.AboutUs:
                Toast.makeText(this, "About Us", Toast.LENGTH_SHORT).show();
                break;
            case R.id.SignOut:
                Toast.makeText(this, "Sign Out", Toast.LENGTH_SHORT).show();
                break;

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}