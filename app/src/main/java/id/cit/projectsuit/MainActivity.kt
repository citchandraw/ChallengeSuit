package id.cit.projectsuit

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {

    lateinit var suitBatu1 : ImageView
    lateinit var suitKertas1 : ImageView
    lateinit var suitGunting1 : ImageView
    lateinit var suitBatu2 : ImageView
    lateinit var suitKertas2 : ImageView
    lateinit var suitGunting2 : ImageView
    lateinit var suitHasil : ImageView

    // -1 kosong, 0 batu, 1 kertas, 2 gunting
    var suitTerpilih1 = -1
    var suitTerpilih2 = -1

    val suitBatu = 0
    val suitKertas = 1
    val suitGunting = 2

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        suitBatu1 = findViewById<ImageView>(R.id.view_batu1)
        suitBatu2 = findViewById<ImageView>(R.id.view_batu2)
        suitKertas1 = findViewById<ImageView>(R.id.view_kertas1)
        suitKertas2 = findViewById<ImageView>(R.id.view_kertas2)
        suitGunting1 = findViewById<ImageView>(R.id.view_gunting1)
        suitGunting2 = findViewById<ImageView>(R.id.view_gunting2)

        val suitHasil = findViewById<ImageView>(R.id.view_suitHasil)


        suitBatu1.setOnClickListener {
            Log.d(MainActivity::class.java.simpleName, "Batu 1 Terpilih")
            selectViewPertama(suitBatu1, pilihan = 0)
        }

        suitKertas1.setOnClickListener {
            Log.d(MainActivity::class.java.simpleName, "Kertas 1 Terpilih")
            selectViewPertama(suitKertas1, pilihan = 1)
        }

        suitGunting1.setOnClickListener {
            Log.d(MainActivity::class.java.simpleName, "Gunting 1 Terpilih")
            selectViewPertama(suitGunting1, pilihan = 2)
        }

        suitBatu2.setOnClickListener {
            Log.d(MainActivity::class.java.simpleName, "Batu 2 Terpilih")
            selectViewKedua(suitBatu2, pilihan = 0)
        }

        suitKertas2.setOnClickListener {
            Log.d(MainActivity::class.java.simpleName, "Kertas 2 Terpilih")
            selectViewKedua(suitKertas2, pilihan = 1)
        }

        suitGunting2.setOnClickListener {
            Log.d(MainActivity::class.java.simpleName, "Gunting 2 Terpilih")
            selectViewKedua(suitGunting2, pilihan = 2)
        }

    }

    private fun selectViewPertama(view: ImageView, pilihan: Int) {
        suitTerpilih1 = pilihan
        clearAllVIewPertama()
        view.setImageResource(R.drawable.ic_baseline_done_24)
    }

    private fun selectViewKedua(view: ImageView, pilihan: Int) {
        suitTerpilih2 = pilihan
        clearAllVIewKedua()
        view.setImageResource(R.drawable.ic_baseline_done_24)
    }

    private fun clearAllVIewPertama() {
        suitBatu1.setImageResource(0)
        suitKertas1.setImageResource(0)
        suitGunting1.setImageResource(0)
    }

    private fun clearAllVIewKedua() {
        suitBatu2.setImageResource(0)
        suitKertas2.setImageResource(0)
        suitGunting2.setImageResource(0)
    }

    private fun hasilSuit() {
        if(suitTerpilih1 >=0 && suitTerpilih2 >=0) {
            if(suitTerpilih1 == suitBatu && suitTerpilih2 == suitKertas || suitTerpilih1 == suitKertas && suitTerpilih2 == suitGunting || suitTerpilih1 == suitGunting && suitTerpilih2 == suitBatu) {
                suitHasil
            }
        }
    }
}    