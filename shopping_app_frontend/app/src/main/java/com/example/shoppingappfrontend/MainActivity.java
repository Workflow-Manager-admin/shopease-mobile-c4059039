package com.example.shoppingappfrontend;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.MenuItem;
import androidx.annotation.NonNull;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // will be updated to a navigation shell

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view); // sliding menu
        bottomNavigationView = findViewById(R.id.bottom_navbar);

        // Show Home by default
        loadFragment(new HomeFragment());

        // Bottom navigation bar: Home, Cart, Orders, Account
        bottomNavigationView.setOnNavigationItemSelectedListener(
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment fragment = null;
                    int id = item.getItemId();
                    if (id == R.id.nav_home) {
                        fragment = new HomeFragment();
                    } else if (id == R.id.nav_cart) {
                        fragment = new CartFragment();
                    } else if (id == R.id.nav_orders) {
                        fragment = new OrdersFragment();
                    } else if (id == R.id.nav_account) {
                        fragment = new ProfileFragment();
                    }
                    if (fragment == null) {
                        fragment = new HomeFragment();
                    }
                    loadFragment(fragment);
                    return true;
                }
            }
        );

        // Navigation drawer (categories and actions)
        navigationView.setNavigationItemSelectedListener(
            new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    // Handle navigation drawer item clicks here.
                    // e.g., open category fragment, show About, Contact, etc.
                    drawerLayout.closeDrawers();
                    return true;
                }
            }
        );
    }

    // Loads fragment into the main content frame
    private void loadFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container, fragment);
        ft.commit();
    }
}
