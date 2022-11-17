package com.bircanozmen.basicseekbarapplicationkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val initialTextViewTranslationY = textView.translationY


        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                textView.text=p1.toString()
                val translationDistance = (initialTextViewTranslationY +
                        p1 * resources.getDimension(R.dimen.text_anim_step) * -1)
                textView.animate().translationY(translationDistance)
                if (!p2)
                    textView.animate().setDuration(500).rotationBy(360f)
                        .translationY(initialTextViewTranslationY)

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

        })
    }

    fun reset(view: View){
        seekBar.progress = 0
    }
}