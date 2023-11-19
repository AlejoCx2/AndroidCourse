package com.alejocx2.androidcourse.imccalculator

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.alejocx2.androidcourse.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class ImcCalculatorActivity : AppCompatActivity() {

    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false
    private var currentWeight: Int = 60
    private var currentHeight: Int = 120
    private var currentAge: Int = 22

    private lateinit var cvMale: CardView
    private lateinit var cvFemale: CardView
    private lateinit var tvHeight: TextView
    private lateinit var rsHeight: RangeSlider
    private lateinit var tvWeight: TextView
    private lateinit var btnSubstractWeight: FloatingActionButton
    private lateinit var btnPlusWeight: FloatingActionButton
    private lateinit var tvAge: TextView
    private lateinit var btnSubstractAge: FloatingActionButton
    private lateinit var btnPlusAge: FloatingActionButton
    private lateinit var btnCalculate: Button

    companion object{
        const val IMC_KEY = "IMC_RESULT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_calculator)
        initComponents()
        initListeners()
        initUI()
    }

    private fun initComponents() {
        cvMale = findViewById(R.id.cv_male)
        cvFemale = findViewById(R.id.cv_female)
        tvHeight = findViewById(R.id.tv_Height)
        rsHeight = findViewById(R.id.rs_Height)
        tvWeight = findViewById(R.id.tv_weight)
        btnPlusWeight = findViewById(R.id.btn_plus_weight)
        btnSubstractWeight = findViewById(R.id.btn_substract_weight)
        tvAge = findViewById(R.id.tv_age)
        btnPlusAge = findViewById(R.id.btn_plus_age)
        btnSubstractAge = findViewById(R.id.btn_substract_age)
        btnCalculate = findViewById(R.id.btn_calculate)
    }

    private fun initListeners() {
        cvMale.setOnClickListener {
            changeGender(it)
            setGenderColor()
        }
        cvFemale.setOnClickListener {
            changeGender(it)
            setGenderColor()
        }
        rsHeight.addOnChangeListener { _, value, _ ->
            currentHeight = value.toInt()
            setHeight()
        }
        btnSubstractWeight.setOnClickListener {
            if (currentWeight - 1 >= 0) currentWeight -= 1
            setWeight()
        }
        btnPlusWeight.setOnClickListener {
            if (currentWeight + 1 < 1000) currentWeight += 1
            setWeight()
        }
        btnSubstractAge.setOnClickListener {
            if (currentAge - 1 >= 0) currentAge -= 1
            setAge()
        }
        btnPlusAge.setOnClickListener {
            if (currentAge + 1 <= 100) currentAge += 1
            setAge()
        }
        btnCalculate.setOnClickListener {
            navegatetoResult(calculateIMC())
        }
    }

    private fun navegatetoResult(imcValue: Double) {
        val intent = Intent(this,ResultIMCActivity::class.java)
        intent.putExtra(IMC_KEY,imcValue)
        startActivity(intent)
    }

    private fun calculateIMC(): Double {
        val heightOnMeters = currentHeight.toDouble() / 100
        val df = DecimalFormat("#.##")
        val imc = df.format(currentWeight / (heightOnMeters * heightOnMeters)).toDouble()
        return imc
    }

    private fun setHeight() {
        tvHeight.text = "${currentHeight.toString()} cm"
    }

    private fun setWeight() {
        tvWeight.text = "${currentWeight.toString()} Kg"
    }

    private fun setAge() {
        tvAge.text = currentAge.toString()
    }

    private fun changeGender(viewSelected: View) {
        if (viewSelected == cvMale) {
            isMaleSelected = true
            isFemaleSelected = false
        } else {
            isMaleSelected = false
            isFemaleSelected = true
        }
    }

    private fun setGenderColor() {
        cvMale.setCardBackgroundColor(getCardBackgroundColor(isMaleSelected))
        cvFemale.setCardBackgroundColor(getCardBackgroundColor(isFemaleSelected))
    }

    private fun getCardBackgroundColor(isSelectedComponent: Boolean): Int {
        val colorReference = if (isSelectedComponent) {
            R.color.background_component_selected
        } else {
            R.color.background_component
        }

        return ContextCompat.getColor(this, colorReference)
    }

    private fun initUI() {
        setGenderColor() // Esto no es necesario XDen este caso
        setWeight()
        setHeight()
        setAge()
    }
}