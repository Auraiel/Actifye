package com.actifye.actifye

import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker
import android.content.Context
import androidx.core.content.ContextCompat
import com.actifye.actifye.R

class MapMarkersManager(private val mapView: MapView, private val context: Context) {

    fun addMarker(geoPoint: GeoPoint, title: String, snippet: String) {
        val marker = Marker(mapView)
        marker.position = geoPoint
        marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
        marker.title = title
        marker.snippet = snippet
        marker.icon = ContextCompat.getDrawable(context, R.drawable.map_pin)
        mapView.overlays.add(marker)
    }

    fun addMarkers(markersData: List<MarkerData>) {
        for (data in markersData) {
            addMarker(data.geoPoint, data.title, data.snippet)
        }
        mapView.invalidate()
    }
}

data class MarkerData(val geoPoint: GeoPoint, val title: String, val snippet: String)
