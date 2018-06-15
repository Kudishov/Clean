package com.example.sergej.clean.presentation.views.activities

import android.os.Bundle
import com.example.sergej.clean.EXTRA_FRUIT_ID
import com.example.sergej.clean.R
import com.example.sergej.clean.domain.Fruit
import com.example.sergej.clean.presentation.IFruitView
import com.example.sergej.clean.presentation.presenters.FruitPresenter
import com.example.sergej.clean.presentation.views.dialogs.buildOneButtonDialog
import kotlinx.android.synthetic.main.activity_fruit.*

class FruitActivity : BaseActivity(), IFruitView {

    private val presenter = FruitPresenter()
    private var fruitId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruit)

        if (savedInstanceState == null) {
            fruitId = intent.getIntExtra(EXTRA_FRUIT_ID, -1)
            if (fruitId != -1) {
                presenter.attachView(this)
                presenter.getFruit(fruitId)
            } else {
                buildOneButtonDialog(this, getString(R.string.error), getString(R.string.error), getString(R.string.repeat), { super.onBackPressed() }).show()
            }
        }
    }

    override fun setFruit(fruit: Fruit) {
        initToolbar(fruit.name)
        setBackButton()
        tvMainFruitId.text = getString(R.string.fruitId, fruit.id.toString())
        tvMainFruitName.text = getString(R.string.fruitName, fruit.name)
        tvMainFruitColor.text = getString(R.string.fruitColor, fruit.color)
        tvMainFruitWeight.text = getString(R.string.fruitWeight, fruit.weight)
        tvMainFruitDelicious.text = getString(R.string.fruitDelicious, fruit.delicious)
        tvMainFruitCreatedAt.text = getString(R.string.fruitCreateAt, fruit.created_at)
        tvMainFruitUpdatedAt.text = getString(R.string.fruitUpdateAt, fruit.updated_at)
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun error(message: String) {
        buildOneButtonDialog(this, getString(R.string.error), message, getString(R.string.repeat), { presenter.getFruit(fruitId) }).show()
    }
}
