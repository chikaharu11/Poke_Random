package com.example.poke_random

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import org.json.JSONObject
import java.net.URL
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private var largeImage = ""

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layoutView =findViewById<ConstraintLayout>(R.id.layoutView)
        val webView = findViewById<WebView>(R.id.webView)
        val button = findViewById<Button>(R.id.button)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val button4 = findViewById<Button>(R.id.button4)
        val button5 = findViewById<Button>(R.id.button5)
        val button6 = findViewById<Button>(R.id.button6)


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

        val sets = arrayOf(
            "base1",
            "base2",
            "basep",
            "base3",
            "base4",
            "base5",
            "gym1",
            "gym2",
            "neo1",
            "neo2",
            "si1",
            "neo3",
            "neo4",
            "base6",
            "ecard1",
            "ecard2",
            "ecard3",
            "ex1",
            "ex2",
            "ex3",
            "np",
            "ex4",
            "ex5",
            "ex6",
            "pop1",
            "ex7",
            "ex8",
            "ex9",
            "ex10",
            "pop2",
            "ex11",
            "ex12",
            "pop3",
            "ex13",
            "ex14",
            "pop4",
            "ex15",
            "pop5",
            "ex16",
            "dp1",
            "dpp",
            "dp2",
            "pop6",
            "dp3",
            "dp4",
            "pop7",
            "dp5",
            "dp6",
            "pop8",
            "dp7",
            "pl1",
            "pop9",
            "pl2",
            "pl3",
            "pl4",
            "ru1",
            "hgss1",
            "hsp",
            "hgss2",
            "hgss3",
            "hgss4",
            "col1",
            "bwp",
            "bw1",
            "mcd11",
            "bw2",
            "bw3",
            "bw4",
            "bw5",
            "mcd12",
            "bw6",
            "dv1",
            "bw7",
            "bw8",
            "bw9",
            "bw10",
            "xyp",
            "bw11",
            "xy0",
            "xy1",
            "xy2",
            "xy3",
            "xy4",
            "xy5",
            "dc1",
            "xy6",
            "xy7",
            "xy8",
            "xy9",
            "g1",
            "xy10",
            "xy11",
            "mcd16",
            "xy12",
            "sm1",
            "smp",
            "sm2",
            "sm3",
            "sm35",
            "sm4",
            "sm5",
            "sm6",
            "sm7",
            "sm75",
            "sm8",
            "sm9",
            "det1",
            "sm10",
            "sm11",
            "sm115",
            "sma",
            "mcd19",
            "sm12",
            "swshp",
            "swsh1",
            "swsh2",
            "swsh3",
            "swsh35",
            "swsh4",
            "swsh45",
            "swsh45sv",
            "swsh5",
            "swsh6"
        )

        val setsV = arrayOf(
            "swshp",
            "swsh1",
            "swsh2",
            "swsh3",
            "swsh35",
            "swsh4",
            "swsh45",
            "swsh45sv",
            "swsh5",
            "swsh6"
        )

        val setsEX = arrayOf(
            "bwp",
            "bw1",
            "bw2",
            "bw3",
            "bw4",
            "bw5",
            "bw6",
            "bw7",
            "bw8",
            "bw9",
            "bw10",
            "xyp",
            "bw11",
            "xy1",
            "xy2",
            "xy3",
            "xy4",
            "xy5",
            "dc1",
            "xy6",
            "xy7",
            "xy8",
            "xy9",
            "g1",
            "xy10",
            "xy11",
            "xy12"
        )

        val setsGX = arrayOf(
            "sm1",
            "smp",
            "sm2",
            "sm3",
            "sm35",
            "sm4",
            "sm5",
            "sm6",
            "sm7",
            "sm75",
            "sm8",
            "sm9",
            "sm10",
            "sm11",
            "sm115",
            "sma",
            "sm12"
        )

        webView.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                layoutView.visibility = View.VISIBLE
                webView.visibility = View.INVISIBLE
            }
            false
        }



        button.setOnClickListener{
            thread {
                val api = URL("https://api.pokemontcg.io/v2/cards?q=set.id:${sets.random()} supertype:Pokémon").readText()
                val json = JSONObject(api)
                val index = json.getJSONArray("data").length()
                val data = json.getJSONArray("data").getJSONObject((0 until index).random())
                largeImage = data.getJSONObject("images").getString("large")
            }.join()

            layoutView.visibility = View.INVISIBLE
            webView.visibility = View.VISIBLE
            webView.loadUrl(largeImage)
        }
        button2.setOnClickListener{
            thread {
                val api = URL("https://api.pokemontcg.io/v2/cards?q=set.id:${setsV.random()} subtypes:v").readText()
                val json = JSONObject(api)
                val index = json.getJSONArray("data").length()
                val data = json.getJSONArray("data").getJSONObject((0 until index).random())
                largeImage = data.getJSONObject("images").getString("large")
            }.join()
            layoutView.visibility = View.INVISIBLE
            webView.visibility = View.VISIBLE
            webView.loadUrl(largeImage)
        }
        button3.setOnClickListener{
            thread {
                val api = URL("https://api.pokemontcg.io/v2/cards?q=subtypes:vmax").readText()
                val json = JSONObject(api)
                val index = json.getJSONArray("data").length()
                val data = json.getJSONArray("data").getJSONObject((0 until index).random())
                largeImage = data.getJSONObject("images").getString("large")
            }.join()
            layoutView.visibility = View.INVISIBLE
            webView.visibility = View.VISIBLE
            webView.loadUrl(largeImage)
        }
        button4.setOnClickListener{
            thread {
                val api = URL("https://api.pokemontcg.io/v2/cards?q=set.id:${setsEX.random()} subtypes:EX").readText()
                val json = JSONObject(api)
                val index = json.getJSONArray("data").length()
                val data = json.getJSONArray("data").getJSONObject((0 until index).random())
                largeImage = data.getJSONObject("images").getString("large")
            }.join()
            layoutView.visibility = View.INVISIBLE
            webView.visibility = View.VISIBLE
            webView.loadUrl(largeImage)
        }
        button5.setOnClickListener{
            thread {
                val api = URL("https://api.pokemontcg.io/v2/cards?q=set.id:${setsGX.random()} subtypes:GX -subtypes:TAG").readText()
                val json = JSONObject(api)
                val index = json.getJSONArray("data").length()
                val data = json.getJSONArray("data").getJSONObject((0 until index).random())
                largeImage = data.getJSONObject("images").getString("large")
            }.join()
            layoutView.visibility = View.INVISIBLE
            webView.visibility = View.VISIBLE
            webView.loadUrl(largeImage)
        }
        button6.setOnClickListener{
            thread {
                val api = URL("https://api.pokemontcg.io/v2/cards?q=subtypes:TAG").readText()
                val json = JSONObject(api)
                val index = json.getJSONArray("data").length()
                val data = json.getJSONArray("data").getJSONObject((0 until index).random())
                largeImage = data.getJSONObject("images").getString("large")
            }.join()
            layoutView.visibility = View.INVISIBLE
            webView.visibility = View.VISIBLE
            webView.loadUrl(largeImage)
        }
    }
}