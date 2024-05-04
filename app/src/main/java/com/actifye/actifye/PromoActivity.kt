package com.actifye.actifye

import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class PromoActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var menuIcon: ImageView
    private lateinit var profileIcon: ImageView
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var logoIcon: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_promo)

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
                    val intent = Intent(this@PromoActivity, PaymentActivity::class.java)
                    startActivity(intent)
                    finish()
                }

                R.id.nav_promo -> {
                    // Handle profile action
                    val intent = Intent(this@PromoActivity, PromoActivity::class.java)
                    startActivity(intent)
                    finish()
                }

                R.id.nav_history -> {
                    // Handle profile action
                    val intent = Intent(this@PromoActivity, HistoryActivity::class.java)
                    startActivity(intent)
                    finish()
                }

                R.id.nav_support -> {
                    // Handle profile action
                    val intent = Intent(this@PromoActivity, SupportActivity::class.java)
                    startActivity(intent)
                    finish()
                }

                R.id.nav_about_us -> {
                    // Handle profile action
                    val intent = Intent(this@PromoActivity, AboutUsActivity::class.java)
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
        val promoCodeInput: EditText = findViewById(R.id.promoCodeInput)
        val submitButton: Button = findViewById(R.id.submitPromoCode)

        // Predefined list of valid promo codes
        val validPromoCodes = listOf("1234-5678", "2288-4200", "8800-5553")

        // Set an OnClickListener to the button
        submitButton.setOnClickListener {
            // Retrieve the input from the EditText
            val enteredCode = promoCodeInput.text.toString().trim()

            // Check if the entered code is in the list of valid codes
            if (enteredCode in validPromoCodes) {
                // Success: Promo code is valid
                Toast.makeText(this, "Success! Promo code applied.", Toast.LENGTH_LONG).show()
            } else {
                // Failure: Promo code is not valid
                Toast.makeText(this, "Error: Invalid promo code.", Toast.LENGTH_LONG).show()
            }
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
