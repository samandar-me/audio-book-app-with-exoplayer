package com.sdk.audiobook.util

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast


fun Context.gotoCom(url: String) {
    val intent = Intent(Intent.ACTION_VIEW)
    intent.data = Uri.parse(url)
    val intentChooser = Intent.createChooser(intent, "Launch")
    startActivity(intentChooser)
}
fun Context.shareThisApp(packageName: String) {
    val intent = Intent(Intent.ACTION_SEND)
    intent.type = "text/plain"
    intent.putExtra(Intent.EXTRA_TEXT, "${Constants.URL}$packageName")
    startActivity(Intent.createChooser(intent, "Share this app"))
}
fun Context.gotoPlayStore(packageName: String) {
    val intent = Intent(Intent.ACTION_VIEW)
    intent.data = Uri.parse("${Constants.URL}$packageName")
    startActivity(intent)
}
fun Context.toast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}