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
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide

class HistoryActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var menuIcon: ImageView
    private lateinit var profileIcon: ImageView
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var logoIcon: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

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
                    val intent = Intent(this@HistoryActivity, PaymentActivity::class.java)
                    startActivity(intent)
                    finish()
                }

                R.id.nav_promo -> {
                    // Handle profile action
                    val intent = Intent(this@HistoryActivity, PromoActivity::class.java)
                    startActivity(intent)
                    finish()
                }

                R.id.nav_history -> {
                    // Handle profile action
                    val intent = Intent(this@HistoryActivity, HistoryActivity::class.java)
                    startActivity(intent)
                    finish()
                }

                R.id.nav_support -> {
                    // Handle profile action
                    val intent = Intent(this@HistoryActivity, SupportActivity::class.java)
                    startActivity(intent)
                    finish()
                }

                R.id.nav_about_us -> {
                    // Handle profile action
                    val intent = Intent(this@HistoryActivity, AboutUsActivity::class.java)
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
        val placesContainer: LinearLayout = findViewById(R.id.placesContainer)

        // Example data for places (name, address, image URL)
        val places = listOf(
            Triple("Arēna Rīga", "Riga, Latvia", "https://lh3.googleusercontent.com/p/AF1QipO-VC6tmThvy41FlG0xb2rQCBknUnexC-J1Jnl9=s680-w680-h510"),
            Triple("Gym! Riga Origo", "Riga, Latvia", "https://lh3.googleusercontent.com/p/AF1QipOYRCVDGDmvsJBzQpRu4hU-gBOO2NiheSfXNNZZ=s680-w680-h510"),
            Triple("Centra sporta kvartāls", "Riga, Latvia", "https://lh3.googleusercontent.com/p/AF1QipNIVxp-kMjVRh8EHBw3P5daxQNZpluy4x4ul8TU=s680-w680-h510"),
            Triple("Ozo Golf Club", "Riga, Latvia", "https://lh3.googleusercontent.com/p/AF1QipMGiGrr51Y5QYplbGr4tW7YzOqFDPMzddPoDPTa=s680-w680-h510"),
            Triple("Grīziņkalna parks", "Riga, Latvia", "https://lh3.googleusercontent.com/p/AF1QipMxwes7tKYufGUsxEvKUrOLoeYzNJeS-5UWz_8=s680-w680-h510")

        )

        // Loop through the places and inflate individual items
        for ((name, address, imageUrl) in places) {
            // Inflate the custom item layout
            val itemView = LayoutInflater.from(this).inflate(R.layout.place_item, placesContainer, false)

            // Set place name and address
            val nameTextView: TextView = itemView.findViewById(R.id.placeName)
            val addressTextView: TextView = itemView.findViewById(R.id.placeAddress)
            val imageView: ImageView = itemView.findViewById(R.id.placeImage)

            nameTextView.text = name
            addressTextView.text = address

            // Load the image using Glide or any other image loading library
            Glide.with(this).load(imageUrl).into(imageView)

            // Add the view to the container
            placesContainer.addView(itemView)
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
