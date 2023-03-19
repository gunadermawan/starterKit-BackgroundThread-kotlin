package com.gunder.backgroundthread

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.gunder.backgroundthread.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.btnStart.setOnClickListener {
            lifecycleScope.launch(Dispatchers.Default) {
//            simulate background process
                for (i in 1..10) {
                    delay(500)
                    val precentage = i * 10
                    withContext(Dispatchers.Main) {
                        if (precentage == 100) {
                            binding.tvStatus.setText(R.string.task_completed)
                        } else {
                            binding.tvStatus.text =
                                String.format(getString(R.string.compressing), precentage)
                        }
                    }
                }

            }
        }
    }
}