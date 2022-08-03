package com.sdk.audiobook.activity.no_internet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.card.MaterialCardView
import com.sdk.audiobook.R
import com.sdk.audiobook.activity.main.MainActivity
import com.sdk.audiobook.util.NetworkHelper
import com.sdk.audiobook.util.toast

class NoInternetActivity : AppCompatActivity() {
    private lateinit var networkHelper: NetworkHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_no_internet)
        networkHelper = NetworkHelper(this)
        val btnCard: MaterialCardView = findViewById(R.id.btnCard)
        btnCard.setOnClickListener {
            if (networkHelper.isNetworkConnected()) {
                intent()
            } else {
                toast(getString(R.string.no_internet))
            }
        }
    }

    override fun onBackPressed() {
        if (networkHelper.isNetworkConnected()) {
            intent()
        } else
            finishAffinity()
    }
    private fun intent() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finishAffinity()
    }
}