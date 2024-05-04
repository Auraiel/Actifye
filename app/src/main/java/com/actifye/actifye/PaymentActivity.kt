package com.actifye.actifye

import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import android.content.Intent
import android.widget.Toast

class PaymentActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var menuIcon: ImageView
    private lateinit var profileIcon: ImageView
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var logoIcon: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        menuIcon = findViewById(R.id.menu_icon)
        profileIcon = findViewById(R.id.profile_icon)
        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        menuIcon.setOnClickListener {
            if (!drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.openDrawer(GravityCompat.START)
            } else {
                drawerLayout.closeDrawer(GravityCompat.START)
            }
        }

        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_payment -> {
                    // Handle home action
                    val intent = Intent(this@PaymentActivity, PaymentActivity::class.java)
                    startActivity(intent)
                    finish()
                }

                R.id.nav_promo -> {
                    // Handle profile action
                    val intent = Intent(this@PaymentActivity, PromoActivity::class.java)
                    startActivity(intent)
                    finish()
                }

                R.id.nav_history -> {
                    // Handle profile action
                    val intent = Intent(this@PaymentActivity, HistoryActivity::class.java)
                    startActivity(intent)
                    finish()
                }

                R.id.nav_support -> {
                    // Handle profile action
                    val intent = Intent(this@PaymentActivity, SupportActivity::class.java)
                    startActivity(intent)
                    finish()
                }

                R.id.nav_about_us -> {
                    // Handle profile action
                    val intent = Intent(this@PaymentActivity, AboutUsActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
        logoIcon = findViewById(R.id.logo_icon)

        logoIcon.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        val profileIcon: ImageView = findViewById(R.id.profile_icon)

        // Set an OnClickListener to the profile icon
        profileIcon.setOnClickListener {
            // Create an Intent to navigate to FriendsListActivity
            val intent = Intent(this, FriendsListActivity::class.java)
            startActivity(intent)
            finish()
        }
        val card1 = findViewById<androidx.cardview.widget.CardView>(R.id.subscription1)
        val card2 = findViewById<androidx.cardview.widget.CardView>(R.id.subscription2)
        val card3 = findViewById<androidx.cardview.widget.CardView>(R.id.subscription3)

        card1.setOnClickListener {
            Toast.makeText(this, "Clicked on Bolt Plus (Latvia)", Toast.LENGTH_SHORT).show()
        }

        card2.setOnClickListener {
            Toast.makeText(this, "Clicked on Pro Week Ride", Toast.LENGTH_SHORT).show()
        }

        card3.setOnClickListener {
            Toast.makeText(this, "Clicked on Elite Package for a Week", Toast.LENGTH_SHORT).show()
        }
    }
    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

}
