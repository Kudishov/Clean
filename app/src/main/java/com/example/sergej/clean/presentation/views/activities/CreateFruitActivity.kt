package com.example.sergej.clean.presentation.views.activities

import android.os.Bundle
import com.example.sergej.clean.R
import com.example.sergej.clean.domain.Fruit
import com.example.sergej.clean.generateId
import com.example.sergej.clean.presentation.ICreateFruitView
import com.example.sergej.clean.presentation.presenters.CreateFruitPresenter
import com.example.sergej.clean.presentation.views.dialogs.buildOneButtonDialog
import kotlinx.android.synthetic.main.activity_create_fruit.*

class CreateFruitActivity : BaseActivity(), ICreateFruitView {
    private val presenter = CreateFruitPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_fruit)
        initToolbar(getString(R.string.fruit_create))
        setBackButton()
        presenter.attachView(this)
        etAddFruitUpdateDate.setOnEditorActionListener { _, _, _ ->
            btnCreateFruit.performClick()
        }
        btnCreateFruit.setOnClickListener {
            presenter.createFruit(
                    Fruit(generateId(),
                            etAddFruitName.text.toString(),
                            etAddFruitColor.text.toString(),
                            etAddFruitWeight.text.toString(),
                            etAddFruitDelicious.text.toString(),
                            etAddFruitCreateDate.text.toString(),
                            etAddFruitUpdateDate.text.toString())
            )
        }
    }

    override fun onFruitCreated() {
        buildOneButtonDialog(this, getString(R.string.gj), getString(R.string.on_fruct_created), getString(R.string.great), { super.onBackPressed() }).show()
    }
}