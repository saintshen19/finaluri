package com.example.game

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.MotionEvent
import android.view.Window
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class Level1 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.universal)
        var numLeft: Int
        var numRight: Int
        val arrayoffiles = ArrayOfFiles
        val random = Random()
        var count = 0


        //Dialog start
        val dialog: Dialog
        dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.previewdialog)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCancelable(false)

        val btnclose = dialog.findViewById(R.id.btnclose) as TextView

        btnclose.setOnClickListener() {
            val intent = Intent(this, levelsactivity::class.java)
            startActivity(intent)
            finish()
            dialog.dismiss()

        }

        var btncontinue = dialog.findViewById(R.id.btncontinue) as Button
        btncontinue.setOnClickListener() {
            dialog.dismiss()

        }

        dialog.show()
        //dialog end


        //dialogEnd
        val dialogEnd = Dialog(this)
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialogEnd.setContentView(R.layout.dialogend)
        dialogEnd.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialogEnd.setCancelable(false)

        val btncontinue2 = dialogEnd.findViewById(R.id.btncontinue) as Button
        btncontinue2.setOnClickListener {
            val intent = Intent(this@Level1, Level2::class.java)
            startActivity(intent)
            finish()
            dialogEnd.dismiss()
        }

        val btnmenu = dialogEnd.findViewById(R.id.btnmenu) as Button
        btnmenu.setOnClickListener {
            val intent = Intent(this@Level1, levelsactivity::class.java)
            startActivity(intent)
            finish()
        }


        //dialogEnd


        findViewById<Button>(R.id.btn_back).setOnClickListener {
            val intent = Intent(this, levelsactivity::class.java)
            startActivity(intent)
            finish()
        }

        //ANIMATION CONNECTING
        val a = AnimationUtils.loadAnimation(this@Level1, R.anim.alpha)
        //ANIMATION

        //Progress
        val progress = intArrayOf(
            R.id.point1,
            R.id.point2,
            R.id.point3,
            R.id.point4,
            R.id.point5,
            R.id.point6,
            R.id.point7,
            R.id.point8,
            R.id.point9,
            R.id.point10,
            R.id.point11,
            R.id.point12,
            R.id.point13,
            R.id.point14,
            R.id.point15,
            R.id.point16,
            R.id.point17,
            R.id.point18,
            R.id.point19,
            R.id.point20
        )

        //Progress


        //random numbers start

        numLeft = random.nextInt(10)
        findViewById<ImageView>(R.id.img_left).setImageResource(arrayoffiles.images1[numLeft]) //random number generator
        findViewById<TextView>(R.id.text_left).text = arrayoffiles.texts1[numLeft]

        numRight = random.nextInt(10)

        //to prevent same numbers
        while (numLeft == numRight) {
            numRight = random.nextInt(10)

            //random numbers end

        }
        findViewById<ImageView>(R.id.img_right).setImageResource(arrayoffiles.images1[numRight])
        findViewById<ImageView>(R.id.img_right).startAnimation(a)
        findViewById<TextView>(R.id.text_right).text = arrayoffiles.texts1[numRight]

        findViewById<ImageView>(R.id.img_left).setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                findViewById<ImageView>(R.id.img_right).isEnabled = false
                if (numLeft > numRight) {
                    findViewById<ImageView>(R.id.img_left).setImageResource(R.drawable.correct_answer)
                } else {
                    findViewById<ImageView>(R.id.img_left).setImageResource(R.drawable.false_answer)
                }
            } else if (event.action == MotionEvent.ACTION_UP) {
                //if left is bigger
                if (numLeft > numRight) {
                    if (count < 20) {
                        count = count + 1
                    }
                    //coloring progress
                    for (i in 0..19) {
                        val tv = findViewById<TextView>(progress[i])
                        tv.setBackgroundResource(R.drawable.style_points_gray)
                    }

                    for (i in 0 until count) {
                        val tv = findViewById<TextView>(progress[i])
                        tv.setBackgroundResource(R.drawable.style_points_green)
                        //green
                    }


                } else {
                    //if left is lower
                    if (count > 0) {
                        if (count == 1) {
                            count = 0

                        } else {
                            count = count - 2
                        }

                    }
                    for (i in 0..18) {
                        val tv = findViewById<TextView>(progress[i])
                        tv.setBackgroundResource(R.drawable.style_points_gray)


                    }

                    for (i in 0 until count) {
                        val tv = findViewById<TextView>(progress[i])
                        tv.setBackgroundResource(R.drawable.style_points_green)
                        //green


                    }
                }

                if (count == 20) {

                    //levelquit
                    dialogEnd.show()
                    //levequit

                } else {
                    //random numbers start
                    numLeft = random.nextInt(10)
                    findViewById<ImageView>(R.id.img_left).setImageResource(arrayoffiles.images1[numLeft]) //random number generator
                    findViewById<ImageView>(R.id.img_left).startAnimation(a)
                    findViewById<TextView>(R.id.text_left).setText(arrayoffiles.texts1[numLeft])

                    numRight = random.nextInt(10)
                    while (numLeft == numRight) {
                        numRight = random.nextInt(10)
                    }
                    findViewById<ImageView>(R.id.img_right).setImageResource(arrayoffiles.images1[numRight])
                    findViewById<ImageView>(R.id.img_right).startAnimation(a)
                    findViewById<TextView>(R.id.text_right).setText(arrayoffiles.texts1[numRight])
                    //randend2

                    findViewById<ImageView>(R.id.img_right).setEnabled(true) //turning on rightclick
                }
            }
            true
        }

        //rightclick start
        findViewById<ImageView>(R.id.img_right).setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                findViewById<ImageView>(R.id.img_left).isEnabled = false
                if (numLeft < numRight) {
                    findViewById<ImageView>(R.id.img_right).setImageResource(R.drawable.correct_answer)
                } else {
                    findViewById<ImageView>(R.id.img_right).setImageResource(R.drawable.false_answer)
                }
            } else if (event.action == MotionEvent.ACTION_UP) {
                //if left is bigger
                if (numLeft < numRight) {
                    if (count < 20) {
                        count = count + 1
                    }
                    //coloring progress
                    for (i in 0..19) {
                        val tv = findViewById<TextView>(progress[i])
                        tv.setBackgroundResource(R.drawable.style_points_gray)
                    }

                    for (i in 0 until count) {
                        val tv = findViewById<TextView>(progress[i])
                        tv.setBackgroundResource(R.drawable.style_points_green)
                        //green
                    }


                } else {
                    //if left is lower
                    if (count > 0) {
                        if (count == 1) {
                            count = 0
                        } else {
                            count = count - 2
                        }
                    }
                    for (i in 0..18) {
                        val tv = findViewById<TextView>(progress[i])
                        tv.setBackgroundResource(R.drawable.style_points_gray)
                    }

                    for (i in 0 until count) {
                        val tv = findViewById<TextView>(progress[i])
                        tv.setBackgroundResource(R.drawable.style_points_green)
                    }
                }

                if (count == 20) {
                    dialogEnd.show()
                } else {
                    //random numbers start
                    numLeft = random.nextInt(10)
                    findViewById<ImageView>(R.id.img_left).setImageResource(arrayoffiles.images1[numLeft]) //random number generator
                    findViewById<ImageView>(R.id.img_left).startAnimation(a)
                    findViewById<TextView>(R.id.text_left).setText(arrayoffiles.texts1[numLeft])
                    numRight = random.nextInt(10)
                    while (numLeft == numRight) {
                        numRight = random.nextInt(10)
                    }
                    findViewById<ImageView>(R.id.img_right).setImageResource(arrayoffiles.images1[numRight])
                    findViewById<ImageView>(R.id.img_right).startAnimation(a)
                    findViewById<TextView>(R.id.text_right).setText(arrayoffiles.texts1[numRight])
                    findViewById<ImageView>(R.id.img_left).setEnabled(true) //turning on rightclick
                }
            }
            true
        }
    }
}
