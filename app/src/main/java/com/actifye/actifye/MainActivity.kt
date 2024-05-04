package com.actifye.actifye

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.ImageView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import android.widget.Button
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var menuIcon: ImageView
    private lateinit var profileIcon: ImageView
    private lateinit var mapView: MapView
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var logoIcon: ImageView
    private lateinit var mapMarkersManager: MapMarkersManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
                    val intent = Intent(this@MainActivity, PaymentActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                R.id.nav_promo -> {
                    // Handle profile action
                    val intent = Intent(this@MainActivity, PromoActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                R.id.nav_history -> {
                    // Handle profile action
                    val intent = Intent(this@MainActivity, HistoryActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                R.id.nav_support -> {
                    // Handle profile action
                    val intent = Intent(this@MainActivity, SupportActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                R.id.nav_about_us -> {
                    // Handle profile action
                    val intent = Intent(this@MainActivity, AboutUsActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
        logoIcon = findViewById(R.id.logo_icon)

        logoIcon.setOnClickListener {
            // Переключаемся обратно на MainActivity
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
            val ctx = applicationContext
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx))

        mapView = findViewById(R.id.map)
        mapView.setTileSource(TileSourceFactory.MAPNIK)
        mapView.isTilesScaledToDpi = true
        mapView.setBuiltInZoomControls(false)
        mapView.setMultiTouchControls(true)

        val mapController = mapView.controller
        mapController.setZoom(13.0)
        val startPoint = GeoPoint(56.95812466376375, 24.137680907032394)
        mapController.setCenter(startPoint)
        mapMarkersManager = MapMarkersManager(mapView, this)

        addMultipleMarkers()
        val mainButton = findViewById<Button>(R.id.mainButton)
        val button1 = findViewById<ImageButton>(R.id.button1)
        val button2 = findViewById<ImageButton>(R.id.button2)
        val button3 = findViewById<ImageButton>(R.id.button3)

        // Add click listener to the main button
        mainButton.setOnClickListener {
            val intent = Intent(this, AboutUsActivity::class.java) // Replace with the target activity
            startActivity(intent)
        }

        // Add click listeners to each secondary button
        button1.setOnClickListener {
            val intent = Intent(this, AboutUsActivity::class.java) // Replace with the target activity
            startActivity(intent)
        }

        button2.setOnClickListener {
            val intent = Intent(this, AboutUsActivity::class.java) // Replace with the target activity
            startActivity(intent)
        }

        button3.setOnClickListener {
            val intent = Intent(this, AboutUsActivity::class.java) // Replace with the target activity
            startActivity(intent)
        }


    }
    private fun addMultipleMarkers() {
        val markersData = listOf(
            MarkerData(GeoPoint(56.94698949494629, 24.118841660612702), "Gym! Riga Origo", "Stacijas laukums 2, Centra rajons, Rīga, LV-1050 \n 24/7 \n http://www.gymlatvija.lv/"),
            MarkerData(GeoPoint(56.961828109276645, 24.143283555611255), "Centra sporta kvartāls", " "),
            MarkerData(GeoPoint(56.94932167643814, 24.20537947952711), "Rīgas 84. vidusskolas Sporta komplekss\n", " "),
            MarkerData(GeoPoint(56.967375284983866, 24.124544213363826), "Rimi Olympic Center", " "),
            MarkerData(GeoPoint(56.961593660770184, 24.114883857756407), "Olimpiskā Skonto halle", " "),
            MarkerData(GeoPoint(56.968105627139515, 24.121352715540326), "Arēna Rīga", " "),
            MarkerData(GeoPoint(56.95614338034159, 24.1389084577405), "Outdoor Basketball Court Ziedoņdārzs", " "),
            MarkerData(GeoPoint(56.955274124083864, 24.158786163343116), "Daugavas stadions", " "),
            MarkerData(GeoPoint(56.95810947347362, 24.153326726698676), "Grīziņkalna parks", " "),
            MarkerData(GeoPoint(56.963523517032634, 24.14309450953557), "Daugava Sports complex", " "),
            MarkerData(GeoPoint(57.02972220934265, 24.139649544381307), "Ozo Golf Club", " "),
            MarkerData(GeoPoint(56.95466268733507, 24.068949502150197), "Rīgas Tehniskās universitātes stadions\n", " "),
            // Добавьте другие маркеры здесь
        )
        mapMarkersManager.addMarkers(markersData)
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }
}
