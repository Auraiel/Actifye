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

class MainActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var menuIcon: ImageView
    private lateinit var profileIcon: ImageView
    private lateinit var mapView: MapView
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView

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
                }
                R.id.nav_promo -> {
                    // Handle profile action
                }
                R.id.nav_history -> {
                    // Handle profile action
                }
                R.id.nav_support -> {
                    // Handle profile action
                }
                R.id.nav_about_us -> {
                    // Handle profile action
                }
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }

        val ctx = applicationContext
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx))

        mapView = findViewById(R.id.map)
        mapView.setTileSource(TileSourceFactory.MAPNIK)
        mapView.isTilesScaledToDpi = true
        mapView.setBuiltInZoomControls(true)
        mapView.setMultiTouchControls(true)

        val mapController = mapView.controller
        mapController.setZoom(13.0)
        val startPoint = GeoPoint(56.9496, 24.1052)
        mapController.setCenter(startPoint)

        addMarker()
    }

    fun addMarker() {
        val geoPoint = GeoPoint(56.94698949494629, 24.118841660612702)
        val marker = Marker(mapView)
        marker.position = geoPoint
        marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
        marker.title = "Gym! Riga Origo"
        marker.snippet = "Stacijas laukums 2, Centra rajons, Rīga, LV-1050 \n 24/7 \n http://www.gymlatvija.lv/"
        marker.icon = ContextCompat.getDrawable(this, R.drawable.map_pin)
        mapView.overlays.add(marker)
        mapView.invalidate()
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
