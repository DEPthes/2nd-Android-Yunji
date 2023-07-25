package com.example.androidbasicstudy_week7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.LayoutInflater
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.Chronometer
import com.example.androidbasicstudy_week7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    var running: Boolean = false
    var isStart: Boolean = false
    var pauseTime = 0L

    var records = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        TimerThread().start()
    }

    inner class TimerThread: Thread(){
        override fun run(){
            val chronometer: Chronometer = binding.chronometer
            var adapter = ArrayAdapter(this@MainActivity, android.R.layout.simple_dropdown_item_1line, records)
            binding.listRecord.adapter = adapter
            //시작 & 정지
            binding.btnPlay.setOnClickListener{
                if(!running){
                    chronometer.base = SystemClock.elapsedRealtime() - pauseTime
                    chronometer.start()
                    binding.btnPlay.setImageResource(R.drawable.baseline_pause_24)
                    running = true
                    isStart = true
                }
                else{
                    chronometer.stop()
                    pauseTime = SystemClock.elapsedRealtime() - chronometer.base
                    binding.btnPlay.setImageResource(R.drawable.baseline_play_arrow_24)
                    running = false
                }
            }

            //초기화
            binding.btnRefresh.setOnClickListener{
                chronometer.base = SystemClock.elapsedRealtime()
                pauseTime = 0L
                chronometer.stop()
                binding.btnPlay.setImageResource(R.drawable.baseline_play_arrow_24)
                records.clear()
                runOnUiThread{
                    //binding.listRecord.adapter = ArrayAdapter(this@MainActivity, android.R.layout.simple_dropdown_item_1line, records)
                    adapter.notifyDataSetChanged()
                }
                //adapter.notifyDataSetChanged()
                running = false
                isStart = false
            }

            //기록
            binding.btnTimer.setOnClickListener{
                if(isStart){
                    val time = SystemClock.elapsedRealtime() - chronometer.base
                    var sec = time/1000 % 60
                    var milliSec = ((time - time/1000 * 1000)*0.1).toInt()
                    records.add("$sec.$milliSec")
//                    runOnUiThread{
//                        //binding.listRecord.adapter = ArrayAdapter(this@MainActivity, android.R.layout.simple_dropdown_item_1line, records)
//                        adapter.notifyDataSetChanged()
//                    }
                    adapter.notifyDataSetChanged()
                }
            }
        }

    }
}