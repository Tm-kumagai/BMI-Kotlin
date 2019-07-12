package com.example.bmiapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
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

        val dataList = mutableListOf<RecordData>()
        for (i in 0..49) {
            val data: RecordData = RecordData().also {
                it.height = "タイトル" + i + "だよ"
                it.weight = "詳細" + i + "個目だよ"
                it.bmi = "BMI" + i + "番目"
            }
            dataList.add(data)
        }
        return dataList
        /*
        val bmiRecordList = MainActivity().onRecordTapped()
        for (i in 0..bmiRecordList.size) {
            val data: RecordData = RecordData().also {
                it.date = bmiRecordList[i].date
                it.height = bmiRecordList[i].height
                it.weight = bmiRecordList[i].weight
                it.bmi = bmiRecordList[i].bmi
            }
            bmiRecordList.add(data)
        }
        return bmiRecordList*/
    }
}