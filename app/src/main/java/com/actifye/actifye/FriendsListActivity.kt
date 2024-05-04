package com.actifye.actifye

import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import android.content.Intent
import com.actifye.actifye.data.Friend
import android.widget.ListView


class FriendsListActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var menuIcon: ImageView
    private lateinit var profileIcon: ImageView
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var logoIcon: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friends_list)

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
                    val intent = Intent(this@FriendsListActivity, PaymentActivity::class.java)
                    startActivity(intent)
                    finish()
                }

                R.id.nav_promo -> {
                    // Handle profile action
                    val intent = Intent(this@FriendsListActivity, PromoActivity::class.java)
                    startActivity(intent)
                    finish()
                }

                R.id.nav_history -> {
                    // Handle profile action
                    val intent = Intent(this@FriendsListActivity, HistoryActivity::class.java)
                    startActivity(intent)
                    finish()
                }

                R.id.nav_support -> {
                    // Handle profile action
                    val intent = Intent(this@FriendsListActivity, SupportActivity::class.java)
                    startActivity(intent)
                    finish()
                }

                R.id.nav_about_us -> {
                    // Handle profile action
                    val intent = Intent(this@FriendsListActivity, FriendsListActivity::class.java)
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
        val friendsListView = findViewById<ListView>(R.id.friendsListView)

        // Sample data for friends
        val friends = listOf(
            Friend("Alex", "Online"),
            Friend("Max", "April 16, 2024, 10:15 AM"),
            Friend("Arsenijs", "April 29, 2024, 8:45 AM")
        )

        // Set the adapter with the data
        val adapter = FriendsListAdapter(this, friends)
        friendsListView.adapter = adapter
    }
        override fun onBackPressed() {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                super.onBackPressed()
            }
        }

}