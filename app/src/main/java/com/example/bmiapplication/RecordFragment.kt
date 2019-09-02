package com.example.bmiapplication

import android.os.Bundle
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import kotlinx.android.synthetic.main.bmi1item.*
import kotlinx.android.synthetic.main.fragment_record.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class RecordFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_record, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = bmirecord_list
        val adapter = ViewAdapter(createDataList())

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter
    }

    private fun createDataList(): List<RecordData> {

        // 履歴用データの出力処理
        val pref = PreferenceManager.getDefaultSharedPreferences(activity)
        val gson = Gson()
        val bmiRecordList: MutableList<RecordData> = mutableListOf()

        pref.all.forEach {
            // println("${it}") // JSON形式そのもの
            // println("${it.key}") // JSONで登録したkey

            it.value?.let {
                val jsonString = it as String
                val objRecordData = gson.fromJson(jsonString, RecordData::class.java)

                // println("${objRecordData}") // RecordData内データ確認用

                bmiRecordList.add(objRecordData)
            }
        }
        return bmiRecordList
    }
}