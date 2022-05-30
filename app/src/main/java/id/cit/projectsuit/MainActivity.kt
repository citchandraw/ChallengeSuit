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

        // <ImageView> bisa di hapus karna di atas sudah ada : lateinit var suitHasil : ImageView
        suitBatu1 = findViewById(R.id.view_batu1)
        suitBatu2 = findViewById(R.id.view_batu2)
        suitKertas1 = findViewById(R.id.view_kertas1)
        suitKertas2 = findViewById(R.id.view_kertas2)
        suitGunting1 = findViewById(R.id.view_gunting1)
        suitGunting2 = findViewById(R.id.view_gunting2)

        suitHasil = findViewById(R.id.view_suitHasil)

        val reset =findViewById<ImageView>(R.id.iv_reset)


        suitBatu1.setOnClickListener {
            // plus poin untuk loggingnya, selalu biasakan log agar lebih mudah debug
            Log.d(MainActivity::class.java.simpleName, "Batu 1 Terpilih")
            selectViewPertama(suitBatu1, pilihan = 0)
            selectViewKedua()
        }

        suitKertas1.setOnClickListener {
            Log.d(MainActivity::class.java.simpleName, "Kertas 1 Terpilih")
            selectViewPertama(suitKertas1, pilihan = 1)
            selectViewKedua()
        }

        suitGunting1.setOnClickListener {
            Log.d(MainActivity::class.java.simpleName, "Gunting 1 Terpilih")
            selectViewPertama(suitGunting1, pilihan = 2)
            selectViewKedua()
        }

        reset.setOnClickListener {
            clearVIewPertama()
            clearVIewKedua()
            suitHasil.setBackgroundResource(R.drawable.ic_vs)
        }
    }

    private fun selectViewPertama(view: ImageView, pilihan: Int) {
        suitTerpilih1 = pilihan
        clearVIewPertama()
        // ini ada bug karna ngeset langsung, lupa uncomment kah mas?
        //view.setImageResource(R.drawable.ic_baseline_done_24)
        view.setImageResource(R.drawable.ic_baseline_done_24)
        hasilSuit()
    }

    private fun selectViewKedua() {
        val rnds = (0..2).random()

        suitTerpilih2 = rnds
        clearVIewKedua()
        when(rnds) {
           0 -> suitBatu2.setImageResource(R.drawable.ic_baseline_done_24)
           1 -> suitKertas2.setImageResource(R.drawable.ic_baseline_done_24)
           2 -> suitGunting2.setImageResource(R.drawable.ic_baseline_done_24)
        }

        hasilSuit()
    }

    private fun clearVIewPertama() {
        suitBatu1.setImageResource(0)
        suitKertas1.setImageResource(0)
        suitGunting1.setImageResource(0)
    }

    private fun clearVIewKedua() {
        suitBatu2.setImageResource(0)
        suitKertas2.setImageResource(0)
        suitGunting2.setImageResource(0)
    }

    private fun hasilSuit() {
        if(suitTerpilih1 >=0 && suitTerpilih2 >=0) {
            if(suitTerpilih1 == suitBatu && suitTerpilih2 == suitKertas || suitTerpilih1 == suitKertas && suitTerpilih2 == suitGunting || suitTerpilih1 == suitGunting && suitTerpilih2 == suitBatu) {
                suitHasil.setBackgroundResource(R.drawable.ic_pemain2);
            }else if(suitTerpilih1 == suitBatu && suitTerpilih2 == suitGunting || suitTerpilih1 == suitKertas && suitTerpilih2 == suitBatu || suitTerpilih1 == suitGunting && suitTerpilih2 == suitKertas) {
                suitHasil.setBackgroundResource(R.drawable.ic_pemain1);
            }else if(suitTerpilih1 == suitBatu && suitTerpilih2 == suitBatu || suitTerpilih1 == suitKertas && suitTerpilih2 == suitKertas || suitTerpilih1 == suitGunting && suitTerpilih2 == suitGunting) {
                suitHasil.setBackgroundResource(R.drawable.ic_draw);
            }
        }
    }
}    