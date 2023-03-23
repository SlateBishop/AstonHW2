package ru.makulin.astonhw2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.makulin.astonhw2.databinding.ActivityHelloBinding

class HelloActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHelloBinding

    private var counter = INIT_COUNT

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHelloBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        binding.tvCount.text = counter.toString()
    }

    companion object {
        private const val INIT_COUNT = 0
    }

}