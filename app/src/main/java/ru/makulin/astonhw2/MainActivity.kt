package ru.makulin.astonhw2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import ru.makulin.astonhw2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        with(binding) {
            btnWebSite.setOnClickListener { openWeb() }
            btnLocation.setOnClickListener { openLocation() }
            btnShareText.setOnClickListener { shareText() }
            btnTakePicture.setOnClickListener { }
        }
    }

    private fun openWeb() {
        val url = binding.etWebSite.text.toString()
        val uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        try {
            startActivity(intent)
        } catch (e: Exception) {
            makeToast(e.message)
        }
    }

    private fun openLocation() {
        val location = binding.etLocation.text.toString()
        val uri = Uri.parse("geo:0,0?q=$location")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        try {
            startActivity(intent)
        } catch (e: Exception) {
            makeToast(e.message)
        }
    }

    private fun shareText() {
        val text = binding.etShareText.text.toString()
        val mimeType = "text/plain"
        ShareCompat.IntentBuilder(this)
            .setText(mimeType)
            .setChooserTitle(R.string.share_text_with)
            .setText(text)
            .startChooser()
    }

    private fun makeToast(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}