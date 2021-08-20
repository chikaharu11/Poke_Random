package com.example.poke_random

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import org.json.JSONObject
import java.net.URL
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private var largeImage = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val webView = findViewById<WebView>(R.id.webView)
        val button = findViewById<Button>(R.id.button)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)

        webView.settings.loadWithOverviewMode = true
        webView.settings.useWideViewPort = true
        webView.setInitialScale(1)
        webView.loadUrl("file:///android_asset/card_back.html")

        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?,
            ): Boolean {
                return false
            }
        }

        button.setOnClickListener{
            thread {
                val random = (1..893).random()
                val api = URL("https://api.pokemontcg.io/v2/cards?q=nationalPokedexNumbers:$random").readText()
                println(random)
                val json = JSONObject(api)
                val index = json.getJSONArray("data").length()
                val data = json.getJSONArray("data").getJSONObject((0 until index).random())
                largeImage = data.getJSONObject("images").getString("large")
            }.join()
            webView.loadUrl(largeImage)
        }
    }
}