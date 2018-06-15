package com.example.sergej.clean.presentation.views.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.example.sergej.clean.EXTRA_FRUIT_ID
import com.example.sergej.clean.R
import com.example.sergej.clean.domain.Fruit
import com.example.sergej.clean.presentation.IFruitsListView
import com.example.sergej.clean.presentation.presenters.FruitsListPresenter
import com.example.sergej.clean.presentation.views.adapters.FruitsAdapter
import com.example.sergej.clean.presentation.views.dialogs.buildOneButtonDialog
import kotlinx.android.synthetic.main.activity_fruits_list.*

class FruitsListActivity : BaseActivity(), IFruitsListView, FruitsAdapter.OnFruitClickListener {
    private val presenter = FruitsListPresenter()

    private lateinit var mAdapter: FruitsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruits_list)
        initToolbar(getString(R.string.fruits_list_title))
        presenter.attachView(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.add_fruit_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.itemAddFruit -> {
                startActivity(Intent(this, CreateFruitActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun setFruits(list: List<Fruit>) {
        val layoutManager = LinearLayoutManager(applicationContext)
        val dividerItemDecoration = DividerItemDecoration(applicationContext, layoutManager.orientation)
        rvFruits.layoutManager = LinearLayoutManager(applicationContext)
        mAdapter = FruitsAdapter(list, this)
        rvFruits.addItemDecoration(dividerItemDecoration)
        rvFruits.adapter = mAdapter
    }

    override fun onResume() {
        super.onResume()
        presenter.getFruits()
    }

    override fun onFruitClick(fruit: Fruit) {
        val intent = Intent(this, FruitActivity::class.java)
        intent.putExtra(EXTRA_FRUIT_ID, fruit.id)
        startActivity(intent)
    }

    override fun error(message: String) {
        buildOneButtonDialog(this, getString(R.string.error), message, getString(R.string.repeat), { presenter.getFruits() }).show()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }
}