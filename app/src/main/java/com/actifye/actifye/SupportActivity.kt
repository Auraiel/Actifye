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
import android.webkit.WebView

class SupportActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var menuIcon: ImageView
    private lateinit var profileIcon: ImageView
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var logoIcon: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_support)

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
                    val intent = Intent(this@SupportActivity, PaymentActivity::class.java)
                    startActivity(intent)
                    finish()
                }

                R.id.nav_promo -> {
                    // Handle profile action
                    val intent = Intent(this@SupportActivity, PromoActivity::class.java)
                    startActivity(intent)
                    finish()
                }

                R.id.nav_history -> {
                    // Handle profile action
                    val intent = Intent(this@SupportActivity, HistoryActivity::class.java)
                    startActivity(intent)
                    finish()
                }

                R.id.nav_support -> {
                    // Handle profile action
                    val intent = Intent(this@SupportActivity, SupportActivity::class.java)
                    startActivity(intent)
                    finish()
                }

                R.id.nav_about_us -> {
                    // Handle profile action
                    val intent = Intent(this@SupportActivity, AboutUsActivity::class.java)
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
        val webView: WebView = findViewById(R.id.webView)
        val htmlContent = """
            <html>
            <body>
                <br><br>
                <h2>Rules:</h2>
                <ul>
                    <li><b>Respect and Fair Play:</b> All users must adhere to a code of conduct promoting respect and fair play towards fellow players regardless of skill level or experience.</li>
                    <li><b>Safety Guidelines:</b> Users should adhere to safety guidelines specific to each sport. It's recommended to include general safety tips and reminders.</li>
                    <li><b>Age Restrictions:</b> Specify any age restrictions for participation in certain sports or activities.</li>
                    <li><b>No Discrimination:</b> Discriminatory behavior based on race, gender, ethnicity, or any other factor is strictly prohibited.</li>
                    <li><b>Reporting Mechanism:</b> Provide a clear process for users to report any inappropriate behavior or violations of the app's rules.</li>
                </ul>
                <h2>Information About the App:</h2>
                <ul>
                    <li><b>User Profiles:</b> Users can create detailed profiles highlighting their preferred sports, skill level, availability, and location.</li>
                    <li><b>Search and Filter Options:</b> Incorporate search and filter functions to allow users to find specific sports, locations, skill levels, and time slots.</li>
                    <li><b>Messaging System:</b> Implement a messaging system that enables users to communicate and organize games or events.</li>
                    <li><b>Location Services:</b> Integrate location-based services to help users find nearby sports facilities or players.</li>
                    <li><b>Privacy Settings:</b> Offer privacy settings that allow users to control the visibility of their profile and personal information.</li>
                    <li><b>Feedback Mechanism:</b> Include a feature for users to provide feedback on their experiences, helping to improve the app's functionality and user experience.</li>
                </ul>
                <h2>Points to Add:</h2>
                <ul>
                    <li><b>User Ratings and Reviews:</b> Allow users to rate and review other players based on their experiences, helping to build a trustworthy community.</li>
                    <li><b>Event Creation:</b> Enable users to create and organize their own sporting events or join existing ones.</li>
                    <li><b>Notification System:</b> Implement a notification system to alert users about upcoming games, new messages, or friend requests.</li>
                    <li><b>Integration with Social Media:</b> Provide options for users to share their activities or achievements on social media platforms, encouraging engagement and user acquisition.</li>
                    <li><b>Community Forums:</b> Create discussion forums or groups where users can share tips, tricks, and experiences related to different sports.</li>
                    <li><b>Premium Features:</b> Consider offering premium features such as ad-free browsing, advanced search filters, or priority event listings for a subscription fee.</li>
                </ul>
            </body>
            </html>
        """.trimIndent()

        // Load HTML content in WebView
        webView.loadDataWithBaseURL(null, htmlContent, "text/html", "UTF-8", null)
    }
    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

}
