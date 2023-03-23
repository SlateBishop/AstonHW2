package ru.makulin.astonhw2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.makulin.astonhw2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var counter = INIT_COUNT
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        with(binding) {
            btnCount.setOnClickListener {
                countUp()
            }
            btnSayHello.setOnClickListener {
                val intent = Intent(this@MainActivity, HelloActivity::class.java)
                intent.putExtra(INTENT_EXTRA_KEY, counter)
                startActivity(intent)
            }
            tvCount.text = counter.toString()
        }
    }

    private fun countUp() {
        counter++
        binding.tvCount.text = counter.toString()
    }

    companion object {
        private const val INIT_COUNT = 0
        const val INTENT_EXTRA_KEY = "key"
    }

}