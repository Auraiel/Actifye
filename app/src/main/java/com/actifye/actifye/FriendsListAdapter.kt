package com.actifye.actifye
// FriendsListAdapter.kt

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.actifye.actifye.data.Friend

class FriendsListAdapter(private val context: Context, private val friends: List<Friend>) : BaseAdapter() {

    override fun getCount(): Int {
        return friends.size
    }

    override fun getItem(position: Int): Any {
        return friends[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        if (view == null) {
            val inflater = LayoutInflater.from(context)
            view = inflater.inflate(R.layout.friend_list_item, parent, false)
        }

        // Retrieve friend item
        val friend = getItem(position) as Friend

        // Populate view elements
        val nameTextView = view!!.findViewById<TextView>(R.id.friendName)
        val lastVisitTextView = view.findViewById<TextView>(R.id.lastVisitTime)

        nameTextView.text = friend.name
        lastVisitTextView.text = "Last visit: ${friend.lastVisit}"

        return view
    }
}
