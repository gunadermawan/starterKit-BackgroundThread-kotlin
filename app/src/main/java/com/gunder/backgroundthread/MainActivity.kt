package com.gunder.backgroundthread

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gunder.backgroundthread.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.btnStart.setOnClickListener {
//            simulate background process
            try {
                for (i in 1..10) {
                    Thread.sleep(5000)
                    val precentage = i * 10
                    if (precentage == 100) {
                        binding.tvStatus.setText(R.string.task_completed)
                    } else {
                        binding.tvStatus.text =
                            String.format(getString(R.string.compressing), precentage)
                    }
                }

            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
    }
}