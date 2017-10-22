package com.platzi.platzistore

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.any_text_view
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        any_text_view.text = "Hello Android Extensions"

//        customShortToast("Show Short Toast")

        toast("Show Short Toast")

        any_text_view.setOnClickListener {
            startActivity<DetailActivity>("text" to "Hello from Ankor")
        }

    }
}
