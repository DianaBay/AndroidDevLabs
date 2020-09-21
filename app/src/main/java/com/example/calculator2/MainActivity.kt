package com.example.calculator2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    var isNewOperator = true
    var oldNumber = ""
    var op = "+"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun numberEvent(view: View) {
        if(isNewOperator)
            expression.setText("")
        isNewOperator = false
        var buttonClick = expression.text.toString()
        var buttonSelect = view as Button
        when(buttonSelect.id){
            one.id -> {buttonClick += "1"}
            two.id -> {buttonClick += "2"}
            three.id -> {buttonClick += "3"}
            four.id -> {buttonClick += "4"}
            five.id -> {buttonClick += "5"}
            six.id -> {buttonClick += "6"}
            seven.id -> {buttonClick += "7"}
            eight.id -> {buttonClick += "8"}
            nine.id -> {buttonClick += "9"}
            zero.id -> {buttonClick += "0"}
            dot.id -> {buttonClick += "."}
            plusMinus.id -> {buttonClick = "-$buttonClick"}
        }
        expression.setText(buttonClick)
    }

    fun operatorEvent(view: View) {
         isNewOperator = true
         oldNumber = expression.text.toString()
         var buttonSelect = view as Button
         when(buttonSelect.id){
              multiplication.id -> {op = "*"}
              plus.id -> {op = "+"}
              minus.id -> {op = "-"}
              division.id -> {op = "/"}

         }
    }

    fun equalsEvent(view: View) {
        var newNumber = expression.text.toString()
        var res = 0.0
        when(op){
            "+" -> { res = oldNumber.toDouble() + newNumber.toDouble()}
            "-" -> { res = oldNumber.toDouble() - newNumber.toDouble()}
            "*" -> { res = oldNumber.toDouble() * newNumber.toDouble()}
            "/" -> { res = oldNumber.toDouble() / newNumber.toDouble()}
        }
        expression.setText(res.toString())
    }

    fun clearEvent(view: View) {
        expression.setText("0")
        isNewOperator = true

    }

    fun percentEvent(view: View) {
        var num = expression.text.toString().toDouble()/100
        expression.setText(num.toString())
        isNewOperator = true
    }

    fun backEvent(view: View) {
        var string = expression.text.toString()
        if(string.isNotEmpty()){
            expression.text = string.substring(0,string.length-1)
        }
    }
}
