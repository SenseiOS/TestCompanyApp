package com.example.testcompanyapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testcompanyapp.R
import com.example.testcompanyapp.ui.fragments.CategoriesFragment.Companion.newInstance
import com.example.testcompanyapp.ui.fragments.DataFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container_fragments, DataFragment.newInstance())
            .commit()
    }
}