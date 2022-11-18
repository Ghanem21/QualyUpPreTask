package com.example.qualyuppretask


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView


class CountryAdapter(private val countries: List<Country>) :
    BaseAdapter(){
    override fun getCount(): Int {
        return countries.size
    }

    override fun getItem(position: Int): Any {
        return countries[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = LayoutInflater.from(parent?.context)
            .inflate(R.layout.custum_spinner, parent, false);

        val image: ImageView = view.findViewById(R.id.imageView)
        image.setImageResource(countries[position].image);

        return view
    }


}
