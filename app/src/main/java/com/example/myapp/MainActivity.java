package com.example.myapp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.myapp.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.example.myapp/dex-files/0.dex */
public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private AppBarConfiguration mAppBarConfiguration;

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    //  Disable Night Mode Globally
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        this.binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(this.binding.getRoot());
        setSupportActionBar(this.binding.appBarMain.toolbar);

        // Ensure hamburger icon shows without title
        getSupportActionBar().setDisplayShowTitleEnabled(false); // No title

        // Set the custom red hamburger icon
//        this.binding.appBarMain.toolbar.setNavigationIcon(R.drawable.ic_hamburger);
//        // Remove any default tint applied to the navigation icon
//        if (this.binding.appBarMain.toolbar.getNavigationIcon() != null) {
//            this.binding.appBarMain.toolbar.getNavigationIcon().setTintList(null);
//        }
//        Drawable navIcon = this.binding.appBarMain.toolbar.getNavigationIcon();
//        if (navIcon != null) {
//            navIcon.setTintList(null); // Ensure no tint is applied
//        }

        ImageView ic_profile = findViewById(R.id.ic_profile);
        ic_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        DrawerLayout drawer = this.binding.drawerLayout;
        NavigationView navigationView = this.binding.navView;
        this.mAppBarConfiguration = new AppBarConfiguration.Builder(new int[]{R.id.nav_home, R.id.nav_order, R.id.nav_offer,
                R.id.nav_wallet, R.id.nav_complains, R.id.nav_contact_us,}).setOpenableLayout(drawer).build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, this.mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

    }
//    private void openRateApp() {
//        String appPackageName = "com.nasil.userapp"; // Actual app package name
//        String appPlayStoreLink = "https://play.google.com/store/apps/details?id=" + appPackageName;
//        // Redirect user to the Play Store to rate the app
//        try {
//            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName));
//            startActivity(intent);
//        } catch (Exception e) {
//            // Fallback if Play Store is not installed
//            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(appPlayStoreLink));
//            startActivity(intent);
//        }
//    }
//    private void inviteFriend() {
//        // Share the app link with friends
//        Intent shareIntent = new Intent(Intent.ACTION_SEND);
//        shareIntent.setType("text/plain");
//
//        // Dynamic message with localization support
//        String shareMessage = getString(R.string.share_message) + " " + "https://play.google.com/store/apps/details?id=com.nasil.userapp";
//
//        shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
//        startActivity(Intent.createChooser(shareIntent, "Share via"));
//    }
//
//    private void openProviderApp() {
//        String appPackageName = "com.nasil.companyapp"; // Actual app package name
//        String appPlayStoreLink = "https://play.google.com/store/apps/details?id=" + appPackageName;
//        // Redirect user to the Play Store to rate the app
//        try {
//            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName));
//            startActivity(intent);
//        } catch (Exception e) {
//            // Fallback if Play Store is not installed
//            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(appPlayStoreLink));
//            startActivity(intent);
//        }
//    }

    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, this.mAppBarConfiguration) || super.onSupportNavigateUp();
    }
}
