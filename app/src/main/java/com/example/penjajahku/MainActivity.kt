package com.example.penjajahku


import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private lateinit var rvColonizer: RecyclerView
    private val list = ArrayList<Colonizer>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvColonizer = findViewById(R.id.RV_colonizer)
        rvColonizer.setHasFixedSize(true)

        list.addAll(getListColonizer())
        showRecyclerList()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                rvColonizer.layoutManager = LinearLayoutManager(this)
            }
            R.id.action_grid -> {
                rvColonizer.layoutManager = GridLayoutManager(this, 2)
            }
            R.id.about -> {
                val intent = Intent(this, AboutActivity::class.java).apply {
                    putExtra(AboutActivity.ABOUT_TITLE, R.string.title)
                    putExtra(AboutActivity.ABOUT_IMAGE, R.drawable.pic)
                    putExtra(AboutActivity.ABOUT_NAME, R.string.name)
                    putExtra(AboutActivity.ABOUT_EMAIL, R.string.email)
                }
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListColonizer(): ArrayList<Colonizer> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val listColonizer = ArrayList<Colonizer>()

        for (i in dataName.indices) {
            val colonizer = Colonizer(dataName[i], dataDescription[i], dataPhoto[i])
            listColonizer.add(colonizer)
        }
        return listColonizer
    }

    private fun showRecyclerList() {
        rvColonizer.layoutManager = LinearLayoutManager(this)
        val listColonizerAdapter = ListColonizerAdapter(list)
        rvColonizer.adapter = listColonizerAdapter

        listColonizerAdapter.setOnItemClickCallback(object : ListColonizerAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Colonizer) {
                showSelectedColonizer(data)
            }
        })
    }

    private fun showSelectedColonizer(colonizer: Colonizer) {
        val intent = Intent(this, ColonizerDetailActivity::class.java)
        intent.putExtra(ColonizerDetailActivity.EXTRA_IMAGE, colonizer.photo)
        intent.putExtra(ColonizerDetailActivity.EXTRA_NAME, colonizer.name)
        intent.putExtra(ColonizerDetailActivity.EXTRA_DESCRIPTION, colonizer.description)
        startActivity(intent)

        Toast.makeText(this, "kamu memilih " + colonizer.name, Toast.LENGTH_SHORT).show()
    }
}