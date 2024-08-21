package app.yoshida.saryu.sound

import android.media.MediaPlayer
import android.os.Bundle
import android.view.MotionEvent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import app.yoshida.saryu.sound.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        val drumSound: MediaPlayer = MediaPlayer.create(this, R.raw.drum_sound)
        binding.drumImage.setOnTouchListener { view, motionEvent ->

            if (motionEvent.action == MotionEvent.ACTION_DOWN) {
                binding.drumImage.setImageResource(R.drawable.drum_playing_image) //写真を置き換えてる
                drumSound.seekTo(0) //←これ書いたら連続で音出る(具体的になんで？？？知りたい！！)
                drumSound.start()
            }
            else if (motionEvent.action == MotionEvent.ACTION_UP) {
                binding.drumImage.setImageResource(R.drawable.drum_image)
            }
            true
        }
//        binding.drumImage.setOnClickListener {
//            drumSound.seekTo(0)
//            drumSound.start()
//        }
    }
}