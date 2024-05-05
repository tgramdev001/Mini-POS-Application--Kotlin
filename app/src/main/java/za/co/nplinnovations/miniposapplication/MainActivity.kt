package za.co.nplinnovations.miniposapplication

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var tvAmtDisplay: TextView
    private lateinit var tvResultDisplay: TextView
    private lateinit var items: ArrayList<Double>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tvAmtDisplay = findViewById(R.id.tvAmtDisplay)
        tvResultDisplay = findViewById(R.id.tvResultDisplay)
        items = ArrayList()
    }

    fun onClickHandle(view: View) {
        when (view.id) {
            R.id.btnOne -> {
                amendDisplayScreenInput(1)
            }
            R.id.btnTwo -> {
                amendDisplayScreenInput(2)
            }
            R.id.btnThree -> {
                amendDisplayScreenInput(3)
            }
            R.id.btnFour -> {
                amendDisplayScreenInput(4)
            }
            R.id.btnFive -> {
                amendDisplayScreenInput(5)
            }
            R.id.btnSix -> {
                amendDisplayScreenInput(6)
            }
            R.id.btnSeven -> {
                amendDisplayScreenInput(7)
            }
            R.id.btnEight -> {
                amendDisplayScreenInput(8)
            }
            R.id.btnNine -> {
                amendDisplayScreenInput(9)
            }
            R.id.btnZero -> {
                amendDisplayScreenInput(0)
            }
        }
    }

    private fun amendDisplayScreenInput(i: Int) {
        // Convert text displayed on screen into a list of Char datatype
        val amount = (tvAmtDisplay.text.toString().removePrefix("R"))
        val newAmount = amount.removeRange((amount.indexOf('.')), amount.indexOf('.') + 1)
        val amountArrayList = newAmount.toMutableList()

        // Remove the first 0 element
        if(amountArrayList[0] == '0')
            amountArrayList.removeFirst()

        // Convert the new integer value to Char and add value to list
        val char = i.toString()
        amountArrayList.add(char[0])

        // Output currency
        var output = "R"

        // Arranging output as newly formed
        for ((index, number) in amountArrayList.withIndex()) {
            output += if (index == amountArrayList.count() - 2)
                ".$number"
            else
                "$number"
        }

        tvAmtDisplay.text = output
    }

    fun onDelete(view: View) {
        val currentText = tvAmtDisplay.text.toString()

        if(currentText.isNotEmpty()) {
            // Convert text displayed on screen into a list of Char datatype
            val amount = currentText.removePrefix("R")
            val newAmount = amount.removeRange((amount.indexOf('.')), amount.indexOf('.') + 1)
            val amountArrayList = newAmount.toMutableList()

            // Remove the last element
            amountArrayList.removeLast()

            if (amountArrayList.count() < 3)
                amountArrayList.add(0, '0')

            // Output currency
            var output = "R"

            // Arranging output as newly formed
            for ((index, number) in amountArrayList.withIndex()) {
                output += if (index == amountArrayList.count() - 2)
                    ".$number"
                else
                    "$number"
            }
            tvAmtDisplay.text = output
        }
    }
    fun onAddClick(view: View) {
        val currentText = tvAmtDisplay.text.toString().removePrefix("R")
        val checkIfNotBlank = currentText.isNotEmpty() && currentText.toDouble() > 0
        if (checkIfNotBlank) {
            items.add(currentText.toDouble())
            updateOutPutUI()
        }
    }

    private fun updateOutPutUI() {
        var totalAmt = 0.00
        var output = ""

        items.forEach { item ->
            totalAmt += item; output += "R" + String.format("%.2f", item) + "\n"
        }

        output += "---------------------------\nR" + String.format("%.2f", totalAmt)

        tvResultDisplay.text = output
        tvAmtDisplay.text = applicationContext.getString(R.string.string_rand_initial_value)
    }
}