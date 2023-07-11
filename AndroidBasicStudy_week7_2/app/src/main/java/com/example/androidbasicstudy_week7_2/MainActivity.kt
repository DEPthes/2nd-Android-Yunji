package com.example.androidbasicstudy_week7_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.androidbasicstudy_week7_2.databinding.ActivityMainBinding
import java.util.Timer
import java.util.TimerTask

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    var time = 0
    var isRunning = false
    var isStart = false
    var timerTask: Timer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        TimerThread().start()
    }
    inner class TimerThread:Thread(){

        override fun run() {
            //super.run()
            var sec:Int
            var milli:Int
            //시작 & 정지
            binding.btnPlay.setOnClickListener{
                isRunning = !isRunning
                if(isRunning){
                    isStart = true
                    timerTask = kotlin.concurrent.timer(period = 10) {
                        time++ // 0.01초마다 time 1씩 증가
                        sec = time / 100
                        milli = time % 100

                        runOnUiThread {
                            binding.textSec.text = "$sec"
                            binding.textMilli.text = "$milli"
                        }
                    }
                    binding.btnPlay.setImageResource(R.drawable.baseline_pause_24)
                }
                else{
                    timerTask?.cancel()
                    binding.btnPlay.setImageResource(R.drawable.baseline_play_arrow_24)
                }
            }
            //기록
            binding.btnTimer.setOnClickListener{
                if(isStart){
                    val textView = TextView(this@MainActivity).apply{
                        setTextSize(20f)
                    }
                    textView.text = "${time/100}.${time%100}"

                    binding.listRecord.addView(textView,0)
                }
            }
            //초기화
            binding.btnRefresh.setOnClickListener{
                timerTask?.cancel()
                time = 0
                isRunning = false
                isStart = false
                binding.textSec.text = "0"
                binding.textMilli.text = "00"
                binding.btnPlay.setImageResource(R.drawable.baseline_play_arrow_24)
                binding.listRecord.removeAllViews()
            }
        }
    }

}