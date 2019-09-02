package com.example.bmiapplication


import android.os.Bundle
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_input.*
import java.text.SimpleDateFormat
import java.util.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class InputFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_input, container, false)
    }

    override fun onStart() {
        super.onStart()

        // BMIボタン押下処理
        bmiButton.setOnClickListener {

            // BMI計算処理
            if (height.text.isNotEmpty() && weight.text.isNotEmpty()) {
                val inputHeight = height.text.toString().toDouble()
                val inputWeight = weight.text.toString().toDouble()
                val resultBmi = inputWeight / (inputHeight / 100 * inputHeight / 100)
                bmi.setText("%.1f".format(resultBmi))
            }
        }

        // 保存ボタン押下処理
        save.setOnClickListener {
            val pref = PreferenceManager.getDefaultSharedPreferences(activity)

            val recordData = RecordData()
            recordData.date
            recordData.height = height.text.toString()
            recordData.weight = weight.text.toString()
            recordData.bmi = bmi.text.toString()

            val today = Date()
            val dateFormat = SimpleDateFormat("yyyyMMdd")
            val fileName = "recordData" + dateFormat.format(today)

            val gson = Gson()
            gson.toJson(recordData)
            pref.edit().putString("$fileName", gson.toJson(recordData)).commit()
        }
    }
}