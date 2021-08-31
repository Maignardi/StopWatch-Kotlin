package com.example.stopwatch

import android.os.Bundle
import android.os.SystemClock
import androidx.appcompat.app.AppCompatActivity
import com.example.stopwatch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var running = false
    var pause: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        commandsStopwatch()
    }

    private fun commandsStopwatch() {
        binding.let {
            it.btStart.setOnClickListener {
                startStopwatch()
            }
            it.btPause.setOnClickListener {
                pauseStopWatch()
            }
            it.btReset.setOnClickListener {
                resetStopWatch()
            }
        }
    }

    private fun startStopwatch() {
        if (!running) {
            binding.chNumberStopWatch.base = SystemClock.elapsedRealtime() - pause
            binding.chNumberStopWatch.start()
            running = true
        }
    }

    private fun pauseStopWatch() {
        if(running){
            binding.chNumberStopWatch.stop()
            pause = SystemClock.elapsedRealtime() - binding.chNumberStopWatch.base
            running = false
        }
    }
    private fun resetStopWatch(){
        binding.chNumberStopWatch.base = SystemClock.elapsedRealtime()
        pause = 0
    }
}