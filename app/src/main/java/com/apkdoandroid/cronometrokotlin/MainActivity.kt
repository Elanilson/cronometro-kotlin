package com.apkdoandroid.cronometrokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import com.apkdoandroid.cronometrokotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private  var running = false
    private var pause : Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonIniciar.setOnClickListener{
            iniciarCronometro()
        }
        binding.buttonPausar.setOnClickListener{
            pauserCronometro()
        }
        binding.buttonZerar.setOnClickListener {
            zeraCronometro()
        }
    }

    private fun zeraCronometro() {
        binding.cronometro.base = SystemClock.elapsedRealtime()
        pause = 0
    }

    private fun pauserCronometro() {
        if(running){
            binding.cronometro.stop()
            pause = SystemClock.elapsedRealtime() - binding.cronometro.base
            running = false

        }
    }

    private fun iniciarCronometro() {
        if(!running){
            binding.cronometro.base = SystemClock.elapsedRealtime() - pause
            binding.cronometro.start()
            running = true

        }
    }
}