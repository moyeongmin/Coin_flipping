package com.example.coin_flipping

import android.animation.Animator
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import android.view.animation.AnimationUtils
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.coin_flipping.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val anim: Animation = AnimationUtils.loadAnimation(this, R.anim.coin_tossing)
        binding.animPoint1.addAnimatorListener(object : Animator.AnimatorListener{
            override fun onAnimationStart(p0: Animator) {
                TODO("Not yet implemented")
            }

            override fun onAnimationEnd(p0: Animator) {
                TODO("Not yet implemented")
            }

            override fun onAnimationCancel(p0: Animator) {
                TODO("Not yet implemented")
            }

            override fun onAnimationRepeat(p0: Animator) {
                TODO("Not yet implemented")
            }
        })


        setContentView(binding.root)
        val tossbtn = binding.buttonToss
        val coinimg = binding.coinImg
        val coinchar = binding.mainCharacter
        var state = 0
        tossbtn.setOnClickListener {
            coinimg.startAnimation(anim)
            tossbtn.isEnabled = false
            Handler(Looper.getMainLooper()).postDelayed( {

                //val media = MediaPlayer.create(this@MainActivity,효과음)
                state = (0..1).random()
                if (state == 0) {

                    coinimg.setImageResource(R.drawable.coin_back)
                  //  media?.start()
                } else {
                    coinimg.setImageResource(R.drawable.coin_front)

                    //media?.start()

                }
            }, 2000)

            Handler(Looper.getMainLooper()).postDelayed({
                when(state)
                {
                    0 -> {coinchar.setImageResource(R.drawable.img_no)

                        binding.maintext.setImageResource(R.drawable.img_text_no)}
                    else -> {coinchar.setImageResource(R.drawable.img_yes)

                        binding.maintext.setImageResource(R.drawable.img_text_do)}
                }
                tossbtn.isEnabled = true

            }, 3000)

        }

    }
}