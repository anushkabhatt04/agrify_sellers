package com.example.agrifysellers.activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.agrifysellers.R;
import com.example.agrifysellers.activity.fragments.StoreFragment;
import com.example.agrifysellers.activity.fragments.profileFragment;
import com.example.agrifysellers.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    StoreFragment store;
    profileFragment profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Use the MenuItem given by this library and not the default one.
        //First parameter is the title of the menu item and then the second parameter is the image which will be the background of the menu item.

        ActivityMainBinding bind = DataBindingUtil.setContentView(this, R.layout.activity_main);

        store = new StoreFragment();
        profile = new profileFragment();
        loadFragment(store);      //default load Store fragment

        bind.bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment = null;


                switch (menuItem.getItemId()) {
                    case R.id.storeItem:
                        fragment = store;
                        break;

                    case R.id.wishlistItem:

                        break;

                    case R.id.chatItem:

                        break;

                    case R.id.notificationItem:

                        break;
                    case R.id.aboutItem:
                        fragment = profile;
                        break;
                }

                return loadFragment(fragment);
            }
        });

    }


    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    public static class editProfile extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

        }

    }


}
