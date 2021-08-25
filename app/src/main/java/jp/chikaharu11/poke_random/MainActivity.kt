package jp.chikaharu11.poke_random

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import org.json.JSONObject
import java.net.URL
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private var largeImage = ""
    private var grass = ""
    private var fire = ""
    private var water = ""
    private var lightning = ""
    private var fighting = ""
    private var psychic = ""
    private var colorless = ""
    private var darkness = ""
    private var metal = ""
    private var dragon = ""
    private var fairy = ""



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
        val imageView = findViewById<ImageView>(R.id.imageView)
        val imageView2 = findViewById<ImageView>(R.id.imageView2)
        val imageView3 = findViewById<ImageView>(R.id.imageView3)
        val imageView4 = findViewById<ImageView>(R.id.imageView4)
        val imageView5 = findViewById<ImageView>(R.id.imageView5)
        val imageView6 = findViewById<ImageView>(R.id.imageView6)
        val imageView7 = findViewById<ImageView>(R.id.imageView7)
        val imageView8 = findViewById<ImageView>(R.id.imageView8)
        val imageView9 = findViewById<ImageView>(R.id.imageView9)
        val imageView10 = findViewById<ImageView>(R.id.imageView10)
        val imageView11 = findViewById<ImageView>(R.id.imageView11)
        val imageView12 = findViewById<ImageView>(R.id.imageView12)
        val checkBox = findViewById<CheckBox>(R.id.checkBox)
        val checkBox2 = findViewById<CheckBox>(R.id.checkBox2)
        val checkBox3 = findViewById<CheckBox>(R.id.checkBox3)
        val checkBox4 = findViewById<CheckBox>(R.id.checkBox4)
        val checkBox5 = findViewById<CheckBox>(R.id.checkBox5)
        val checkBox6 = findViewById<CheckBox>(R.id.checkBox6)
        val checkBox7 = findViewById<CheckBox>(R.id.checkBox7)
        val checkBox8 = findViewById<CheckBox>(R.id.checkBox8)
        val checkBox9 = findViewById<CheckBox>(R.id.checkBox9)
        val checkBox10 = findViewById<CheckBox>(R.id.checkBox10)
        val checkBox11 = findViewById<CheckBox>(R.id.checkBox11)


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

        MobileAds.initialize(this) {}

        val adView = findViewById<AdView>(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)

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

        imageView.setOnClickListener {
            if (!checkBox.isChecked) {
                imageView.setImageResource(R.drawable.grass2)
                checkBox.performClick()
                grass = "types:grass or "
            } else if (checkBox.isChecked) {
                imageView.setImageResource(R.drawable.grass)
                checkBox.performClick()
                grass = ""
            }
        }
        imageView2.setOnClickListener {
            if (!checkBox2.isChecked) {
                imageView2.setImageResource(R.drawable.fire2)
                checkBox2.performClick()
                fire = "types:fire or "
            } else if (checkBox2.isChecked) {
                imageView2.setImageResource(R.drawable.fire)
                checkBox2.performClick()
                fire = ""
            }
        }
        imageView3.setOnClickListener {
            if (!checkBox3.isChecked) {
                imageView3.setImageResource(R.drawable.water2)
                checkBox3.performClick()
                water = "types:water or "
            } else if (checkBox3.isChecked) {
                imageView3.setImageResource(R.drawable.water)
                checkBox3.performClick()
                water = ""
            }
        }
        imageView4.setOnClickListener {
            if (!checkBox4.isChecked) {
                imageView4.setImageResource(R.drawable.lightning2)
                checkBox4.performClick()
                lightning = "types:lightning or "
            } else if (checkBox4.isChecked) {
                imageView4.setImageResource(R.drawable.lightning)
                checkBox4.performClick()
                lightning = ""
            }
        }
        imageView5.setOnClickListener {
            if (!checkBox5.isChecked) {
                imageView5.setImageResource(R.drawable.fighting2)
                checkBox5.performClick()
                fighting = "types:fighting or "
            } else if (checkBox5.isChecked) {
                imageView5.setImageResource(R.drawable.fighting)
                checkBox5.performClick()
                fighting = ""
            }
        }
        imageView6.setOnClickListener {
            if (!checkBox6.isChecked) {
                imageView6.setImageResource(R.drawable.psychic2)
                checkBox6.performClick()
                psychic = "types:psychic or "
            } else if (checkBox6.isChecked) {
                imageView6.setImageResource(R.drawable.psychic)
                checkBox6.performClick()
                psychic = ""
            }
        }
        imageView7.setOnClickListener {
            if (!checkBox7.isChecked) {
                imageView7.setImageResource(R.drawable.colorless2)
                checkBox7.performClick()
                colorless = "types:colorless or "
            } else if (checkBox7.isChecked) {
                imageView7.setImageResource(R.drawable.colorless)
                checkBox7.performClick()
                colorless = ""
            }
        }
        imageView8.setOnClickListener {
            if (!checkBox8.isChecked) {
                imageView8.setImageResource(R.drawable.darkness2)
                checkBox8.performClick()
                darkness = "types:darkness or "
            } else if (checkBox8.isChecked) {
                imageView8.setImageResource(R.drawable.darkness)
                checkBox8.performClick()
                darkness = ""
            }
        }
        imageView9.setOnClickListener {
            if (!checkBox9.isChecked) {
                imageView9.setImageResource(R.drawable.metal2)
                checkBox9.performClick()
                metal = "types:metal or "
            } else if (checkBox9.isChecked) {
                imageView9.setImageResource(R.drawable.metal)
                checkBox9.performClick()
                metal = ""
            }
        }
        imageView10.setOnClickListener {
            if (!checkBox10.isChecked) {
                imageView10.setImageResource(R.drawable.dragon2)
                checkBox10.performClick()
                dragon = "types:dragon or "
            } else if (checkBox10.isChecked) {
                imageView10.setImageResource(R.drawable.dragon)
                checkBox10.performClick()
                dragon = ""
            }
        }
        imageView11.setOnClickListener {
            if (!checkBox11.isChecked) {
                imageView11.setImageResource(R.drawable.fairy2)
                checkBox11.performClick()
                fairy = "types:fairy or "
            } else if (checkBox11.isChecked) {
                imageView11.setImageResource(R.drawable.fairy)
                checkBox11.performClick()
                fairy = ""
            }
        }
        imageView12.setOnClickListener {
            finish()
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
                if (
                    !checkBox.isChecked &&
                    !checkBox2.isChecked &&
                    !checkBox3.isChecked &&
                    !checkBox4.isChecked &&
                    !checkBox5.isChecked &&
                    !checkBox6.isChecked &&
                    !checkBox7.isChecked &&
                    !checkBox8.isChecked &&
                    !checkBox9.isChecked &&
                    !checkBox10.isChecked &&
                    !checkBox11.isChecked
                ) {
                    val api = URL("https://api.pokemontcg.io/v2/cards?q=subtypes:vmax").readText()
                    val json = JSONObject(api)
                    val index = json.getJSONArray("data").length()
                    val data = json.getJSONArray("data").getJSONObject((0 until index).random())
                    largeImage = data.getJSONObject("images").getString("large")
                } else {
                    val api = URL("https://api.pokemontcg.io/v2/cards?q=subtypes:vmax ($grass$fire$water$lightning$fighting$psychic$colorless$darkness$metal$dragon$fairy)".removeSuffix(" or )") + ")").readText()
                    val json = JSONObject(api)
                    val index = json.getJSONArray("data").length()
                    val data = json.getJSONArray("data").getJSONObject((0 until index).random())
                    largeImage = data.getJSONObject("images").getString("large")
                }
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