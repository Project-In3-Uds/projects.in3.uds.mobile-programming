package com.example.metsanouuds;

import com.example.metsanouuds.R;
import com.google.android.material.navigation.NavigationView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public static TextView cartCountText;
    public static int cartCount = 0;

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        // Setup Drawer
        drawerLayout = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        );
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.bringToFront();

        // Charger le fragment d'accueil par défaut
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new HomeFragment())
                    .commit();
        }

    }
    // Lier le menu toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar_icons, menu);

        //Initialiser le TextView pour afficher le nombre d'articles dans le panier
        MenuItem item = menu.findItem(R.id.action_cart);
        View actionView = item.getActionView();
        MainActivity.cartCountText = actionView.findViewById(R.id.cartCountText);
        MainActivity.cartCountText.setText(String.valueOf(cartCount));

        return true;
    }

    //Gérer les cliques sur les element du toolbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Fragment selectedFragment = null;

        int id = item.getItemId();

        if (id == R.id.action_home) {
            selectedFragment = new HomeFragment();
        } else if (id == R.id.action_fruits) {
            selectedFragment = new FruitsFragment();
        } else if (id == R.id.action_legumes) {
            selectedFragment = new LegumesFragment();
        } else if (id == R.id.action_autres) {
            selectedFragment = new AutresFragment();
        } /*else if (id == R.id.action_cart) {
            selectedFragment = new PanierFragment();
        }*/

        if (selectedFragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, selectedFragment)
                    .commit();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //gestion du clic sur les éléments du menu lattéral
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_logout) {
            showLogoutConfirmationDialog();
            return true;
        }

        // ... autres cas comme nav_home, nav_user, etc.

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


    private void showLogoutConfirmationDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Déconnexion")
                .setMessage("Voulez-vous vraiment vous déconnecter ?")
                .setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        logoutUser();
                    }
                })
                .setNegativeButton("Annuler", null)
                .show();
    }

    private void logoutUser() {
        // Par exemple, nettoyer la session utilisateur ici

        // Revenir à l'activité de login
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); // Efface la stack
        startActivity(intent);
        finish(); // Termine l'activité principale
    }


}
