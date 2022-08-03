package com.sdk.audiobook.activity

import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.sdk.audiobook.R
import com.sdk.audiobook.activity.main.MainActivity
import com.sdk.audiobook.manager.CheckBroadcastManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class IntroActivity : AppCompatActivity() {
    private lateinit var checkBroadcastManager: CheckBroadcastManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        checkBroadcastManager = CheckBroadcastManager()
        CoroutineScope(Dispatchers.Main).launch {
            delay(1000)
            initViews()
        }
    }

    private fun initViews() {
        installReceiver()

        object : CountDownTimer(1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {}

            override fun onFinish() {
                if (checkBroadcastManager.hasInternet(this@IntroActivity)) {
                    val intent = Intent(this@IntroActivity, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }.start()
    }

    private fun installReceiver() {
        val intent = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        registerReceiver(checkBroadcastManager, intent)
    }
}