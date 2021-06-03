package com.example.bottomnavigationtoolbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstfragment = firstFragment()
        val secondfragment = secondFragment()
        val thirdfragment = thirdFragment()

        setFrag(firstfragment)

        btmnav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.mHome -> setFrag(firstfragment)
                R.id.mMessage -> setFrag(secondfragment)
                R.id.mProfile -> setFrag(thirdfragment)
            }
            true
        }

        btmnav.getOrCreateBadge(R.id.mMessage).apply {
            number = 10
            isVisible = true
        }
    }

    private fun setFrag(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.Frame, fragment)
            commit()
        }
}