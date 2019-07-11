package com.example.bmiapplication

import android.os.Bundle
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_common.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 入力値用変数宣言
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val inputHeight = pref.getString("HEIGHT", "")
        val inputWeight = pref.getString("WEIGHT", "")
        val inputBmi = pref.getString("BMI", "")
        val today = Date()
        val dateFormat = SimpleDateFormat("dd日 ")

//        // データクラス宣言
//        data class RecordData(
//            val date: String = "",
//            val height: String? = "",
//            val weight: String? = "",
//            val bmi: String? = ""
//        )
//
//        val bmiRecord = RecordData(
//            date = dateFormat.format(today),
//            height = inputHeight,
//            weight = inputWeight,
//            bmi = inputBmi
//        )
//        val mapper = jacksonObjectMapper()
//        val jsonString = mapper.writeValueAsString(bmiRecord)
//        println(jsonString)

        // タイトル変更
        val title = commonFragment as? CommonFragment
        title?.setTitle("入力")

        // 履歴用フラグメントを隠す処理
        val recordF = RecordFragment()
        val fragmentManager = this.getSupportFragmentManager()
        val fragmentTransaction = fragmentManager.beginTransaction()
//        fragmentTransaction.hide(recordFragment)
//            .commit()

//        val json = """{"height":$inputHeight,"weight":$inputWeight,"bmi":$inputBmi}""""
//        val bmijson = mapper.readValue<RecordData>(json)
//        memo.setText(dateFormat.format(date) + bmijson.height + bmijson.weight + bmijson.bmi)

//        height.setText(inputHeight)
//        weight.setText(inputWeight)
//        bmi.setText(inputBmi)

        // BMIボタン押下処理
        bmiButton.setOnClickListener {
            onBmiTapped()
            onSaveTapped()
        }

        // 入力ボタン押下処理
        input.setOnClickListener {
            title?.setTitle("入力")
            onInputTapped()
        }

        // 履歴ボタン押下処理
        record.setOnClickListener {
            title?.setTitle("履歴")
            onRecordTapped()
        }
    }

    // BMI計算メソッド
    private fun onBmiTapped() {
        if (height.text.isNotEmpty() && weight.text.isNotEmpty()) {
            val inputHeight = height.text.toString().toDouble()
            val inputWeight = weight.text.toString().toDouble()
            val resultBmi = inputWeight / (inputHeight / 100 * inputHeight / 100)
            bmi.setText("%.1f".format(resultBmi))
        }
    }

    // 保存メソッド
    private fun onSaveTapped() {
        val pref = PreferenceManager.getDefaultSharedPreferences(this)

        val recordData = RecordData()
        recordData.date
        recordData.height = height.text.toString()
        recordData.weight = weight.text.toString()
        recordData.bmi = bmi.text.toString()

        val today = Date()
        val dateFormat = SimpleDateFormat("yyyy/MM/dd")
        val fileName = "recordData" + dateFormat.format(today)

        val gson = Gson()
        gson.toJson(recordData)
        pref.edit().putString("$fileName", gson.toJson(recordData)).commit()

//        pref.edit {
//            putString("HEIGHT", height.text.toString())
//            putString("WEIGHT", weight.text.toString())
//            putString("BMI", bmi.text.toString())
//        }
    }

    // 入力ボタン押下処理メソッド
    private fun onInputTapped() {
        val record = RecordFragment()
        val fragmentManager = this.getSupportFragmentManager()
        val fragmentTransaction = fragmentManager.beginTransaction()
//        fragmentTransaction.hide(recordFragment)
//            .commit()
    }

    // 履歴ボタン押下処理メソッド
    private fun onRecordTapped() {
        // 履歴用データの出力処理
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        println(pref.all)

//        val gson = Gson()
//        val recordData = gson.fromJson(pref.getString("", ""), RecordData::class.java)

//        height_data.setText("身長：" + "" + "cm")
//        weight_data.setText("体重：" + "" + "kg")
//        bmi_data.setText("BMI：" + "")

        val record = RecordFragment()
        val fragmentManager = this.getSupportFragmentManager()
        val fragmentTransaction = fragmentManager.beginTransaction()
//        fragmentTransaction.show(recordFragment)
//            .commit()
    }
}