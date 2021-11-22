package com.example.abm_products_mvp_sqlite.MainView.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.example.abm_products_mvp_sqlite.ABMProducts.view.MenuProductView;
import com.example.abm_products_mvp_sqlite.R;
import com.example.abm_products_mvp_sqlite.databinding.ActivityMainViewBinding;
import com.example.abm_products_mvp_sqlite.databinding.ToolbarBinding;
import com.google.android.material.navigation.NavigationView;

/**
 * Clase que infla la actividad principal de la app.
 * @version 21/11/2021
 */
public class MainView extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private NavigationView mainNavigationView;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_view);

        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.view_drawer_layout);
        mainNavigationView = findViewById(R.id.main_navigation_view);
        mainNavigationView.setNavigationItemSelectedListener(this);
        toolbar = findViewById(R.id.toolbar);

        toggle = setUpToggle();
        drawerLayout.addDrawerListener(toggle);
    }

    private ActionBarDrawerToggle setUpToggle() {
        return new ActionBarDrawerToggle(this,
                drawerLayout,
                toolbar,
                R.string.drawer_open,
                R.string.drawer_close);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        selectedItemNav(item);
        return true;
    }

    private void selectedItemNav(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.nav_abm_products:
                Intent i = new Intent(this, MenuProductView.class);
                startActivity(i);
                break;
            case R.id.nav_abm_product_type:
                break;
            case R.id.nav_abm_um:
                break;

        }
        drawerLayout.closeDrawers();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }
}