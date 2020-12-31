package com.postzeew.fragmentsswitcher.sample

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.postzeew.fragmentsswitcher.FragmentsSwitcher
import com.postzeew.fragmentsswitcher.sample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var fragmentsSwitcher: FragmentsSwitcher

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fragmentsSwitcher = FragmentsSwitcher(MainFragmentFactory(), R.id.fragmentsContainer)

        findViewById<Button>(R.id.home).setOnClickListener {
            fragmentsSwitcher.switchTo(HomeFragment::class.java.name, supportFragmentManager)
        }

        findViewById<Button>(R.id.map).setOnClickListener {
            fragmentsSwitcher.switchTo(MapFragment::class.java.name, supportFragmentManager)
        }

        findViewById<Button>(R.id.settings).setOnClickListener {
            fragmentsSwitcher.switchTo(SettingsFragment::class.java.name, supportFragmentManager)
        }
    }
}