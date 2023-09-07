package com.sainrahmani.cityofindonesia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sainrahmani.cityofindonesia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), DetailInterface {

    private lateinit var rvCity: RecyclerView
    private val list = ArrayList<City>()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvCity = findViewById(R.id.rv_cities)
        rvCity.setHasFixedSize(true)

        list.addAll(getListCities())
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvCity.layoutManager = LinearLayoutManager(this)
        val listCityAdapter = ListCityAdapter(list, this@MainActivity)
        rvCity.adapter = listCityAdapter
    }

    private fun getListCities(): ArrayList<City> {
        val dataName = resources.getStringArray(R.array.data_city_names)
        val dataDescription = resources.getStringArray(R.array.data_city_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_city_logos)
        val listCity = ArrayList<City>()
        for (i in dataName.indices) {
            val city = City(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listCity.add(city)
        }
        return listCity
    }

    override fun getDetail(nameCity: String, descCity: String, logoCity: Int) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("name", nameCity)
        intent.putExtra("desc", descCity)
        intent.putExtra("poto", logoCity)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent = Intent(this, AboutMeActivity::class.java)
        startActivity(intent)
        return super.onOptionsItemSelected(item)
    }
}