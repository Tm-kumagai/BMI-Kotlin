package com.example.bmiapplication

import android.os.Bundle
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_input -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, InputFragment())
                    .commit()

                setTitle("入力")
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_record -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, RecordFragment())
                    .commit()

                setTitle("履歴")
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        input.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        record.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        // 初期表示
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, InputFragment())
            .commit()

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

        var titlebar = ""

        // タイトル変更
//        val title = headerFragment as? HeaderFragment
//        title?.setTitle("入力")

//        // 履歴用フラグメントを隠す処理
//        val recordF = RecordFragment()
//        val fragmentManager = this.getSupportFragmentManager()
//        val fragmentTransaction = fragmentManager.beginTransaction()
//        fragmentTransaction.remove(recordFragment)
//            .commit()

//        val json = """{"height":$inputHeight,"weight":$inputWeight,"bmi":$inputBmi}""""
//        val bmijson = mapper.readValue<RecordData>(json)
//        memo.setText(dateFormat.format(date) + bmijson.height + bmijson.weight + bmijson.bmi)

//        height.setText(inputHeight)
//        weight.setText(inputWeight)
//        bmi.setText(inputBmi)

        // 入力ボタン押下処理
        input.setOnClickListener {
//            title?.setTitle("入力")
//            onInputTapped()
        }

        // 履歴ボタン押下処理
        record.setOnClickListener {
//            title?.setTitle("履歴")
//            onRecordTapped()
        }
    }

    // 入力ボタン押下処理メソッド
    private fun onInputTapped() {
        val inputFragment = InputFragment()

        val fragmentManager = this.getSupportFragmentManager()
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container, inputFragment)
            .addToBackStack(null)
            .commit()
    }

    // 履歴ボタン押下処理メソッド
    private fun onRecordTapped() {
        val recordFragment = RecordFragment()

        val fragmentManager = this.getSupportFragmentManager()
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.remove(recordFragment)//.remove(headerFragment)
            .add(R.id.container, recordFragment)
            .commit()

    }
}