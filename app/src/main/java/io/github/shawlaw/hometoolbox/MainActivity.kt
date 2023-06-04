package io.github.shawlaw.hometoolbox

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import io.github.shawlaw.hometoolbox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupActions()
    }

    private fun setupActions() {
        binding.btnOpenShareScreen.setOnClickListener {
            val openIntent = Intent()
            openIntent.setPackage(getString(R.string.pkg_color_os_12_share_screen))
            openIntent.setClassName(getString(R.string.pkg_color_os_12_share_screen), getString(R.string.component_color_os_12_share_screen))
            openIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            val cn = openIntent.resolveActivity(packageManager)
            if (cn != null) {
                startActivity(openIntent)
            } else {
                Toast.makeText(this, getString(R.string.failed_to_find_sharescreen_app), Toast.LENGTH_LONG).show()
            }
        }
    }
}