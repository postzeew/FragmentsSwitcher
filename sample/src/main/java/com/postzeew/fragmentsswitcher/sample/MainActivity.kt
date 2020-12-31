package com.postzeew.fragmentsswitcher.sample

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.postzeew.fragmentsswitcher.FragmentSwitcher
import com.postzeew.fragmentsswitcher.sample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var fragmentSwitcher: FragmentSwitcher

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fragmentSwitcher = FragmentSwitcher(MainFragmentFactory(), R.id.fragmentsContainer)

        findViewById<Button>(R.id.home).setOnClickListener {
            fragmentSwitcher.switchTo(HomeFragment::class.java.name, supportFragmentManager)
        }

        findViewById<Button>(R.id.map).setOnClickListener {
            fragmentSwitcher.switchTo(MapFragment::class.java.name, supportFragmentManager)
        }

        findViewById<Button>(R.id.settings).setOnClickListener {
            fragmentSwitcher.switchTo(SettingsFragment::class.java.name, supportFragmentManager)
        }
    }
}