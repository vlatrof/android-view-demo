package com.example.androidviewdemo

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.androidviewdemo.databinding.ActivityMainBinding

@SuppressLint("SetTextI18n")
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //demoSimpleInterface()
        //demoComplexInterface()
        //demoSimpleLayoutInflater()
        //demoSimpleLayoutInflater()
        //demoComplexLayoutInflater()
        demoViewBinding()

    }

    fun demoSimpleInterface() {

        // create view
        val textView = TextView(this@MainActivity)

        // set some attributes to view
        textView.text = "Hello, Android!"
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.toFloat())

        // set created view as content of our activity
        this@MainActivity.setContentView(textView)

    }

    private fun demoComplexInterface() {

        // create ViewGroup (ConstraintLayout)
        val viewGroupConstLayout = ConstraintLayout(this@MainActivity)

        // create and add childs to parent ConstraintLayout
        viewGroupConstLayout.addView(createFirstView())
        viewGroupConstLayout.addView(createSecondView())

        // set our ConstraintLayout as root of interface of MainActivity
        this@MainActivity.setContentView(viewGroupConstLayout)

    }

    private fun createFirstView(): View {

        // create View (TextView) and set some attributes to it
        val textView = TextView(this@MainActivity)
        textView.text = "Looking for job! =)"
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20.toFloat())

        // create ViewGroup.LayoutParams
        val layoutParams = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.WRAP_CONTENT, // width wrap content
            ConstraintLayout.LayoutParams.WRAP_CONTENT  // height wrap content
        ).apply {
            //constraints
            topToTop = ConstraintLayout.LayoutParams.PARENT_ID
            startToStart = ConstraintLayout.LayoutParams.PARENT_ID
            endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
            bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
            verticalBias = 0.33.toFloat()
        }

        // set layout params to view
        textView.layoutParams = layoutParams

        return textView

    }

    private fun createSecondView(): View {

        // create View (Button) and set some attributes to it
        val button = Button(this@MainActivity)
        button.text = "cool button"

        // create ViewGroup.LayoutParams
        val layoutParams = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.WRAP_CONTENT, // width wrap content
            ConstraintLayout.LayoutParams.WRAP_CONTENT  // height wrap content
        ).apply {
            //constraints
            topToTop = ConstraintLayout.LayoutParams.PARENT_ID
            startToStart = ConstraintLayout.LayoutParams.PARENT_ID
            endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
            bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
            verticalBias = 0.66.toFloat()
        }

        // set layout params to view
        button.layoutParams = layoutParams

        return button

    }

    private fun demoSimpleLayoutInflater() {

        // get LayoutInflater from Main Activity context
        val inflater = this@MainActivity.layoutInflater

        // inflate view from text view xml file
        // without any rout
        val textView = inflater.inflate(R.layout.text_view, null)

        // set created view as content of Main Activity
        this@MainActivity.setContentView(textView)

    }

    private fun demoComplexLayoutInflater() {

        // get LayoutInflater from Main Activity context
        val inflater = this@MainActivity.layoutInflater

        // inflate LinearLayout from xml file (layout contains one textview)
        val linearLayout: LinearLayoutCompat = inflater.inflate(
            R.layout.linear_layout, null) as LinearLayoutCompat

        // inflate additional textView from xml file
        val secondTextView = inflater.inflate(R.layout.text_view, null)
        // add additional text view to our linear layout through addView() method
        linearLayout.addView(secondTextView)

        // inflate additional textView from xml file and add this view to existing
        // layout with params root: ViewGroup and attachToRoot: Boolean
        inflater.inflate(R.layout.text_view, linearLayout, true)

        // set created layout (with textview inside) as content of Main Activity
        this@MainActivity.setContentView(linearLayout)

    }

    private fun demoViewBinding() {

        // get LayoutInflater from Main Activity context
        val inflater = this@MainActivity.layoutInflater

        // inflate binding with inflater
        // this makes object of generated binding class from xml file
        val binding = ActivityMainBinding.inflate(inflater)

        // now we have access to generated views which have id's
        binding.tvFirst.text = "Hello!"
        binding.tvSecond.text = "Thank u for visiting my github!"
        binding.tvThird.text = "Looking for job! =)"

        // use binding.root to get root layout
        setContentView(binding.root)

    }

}