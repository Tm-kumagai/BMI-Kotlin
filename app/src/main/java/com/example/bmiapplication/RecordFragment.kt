package com.example.bmiapplication

import android.os.Bundle
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager

import com.google.gson.Gson
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
//        val adapter = ViewAdapter(createDataList())

//        recyclerView.setHasFixedSize(true)
//        recyclerView.layoutManager = LinearLayoutManager(activity)
//        recyclerView.adapter = adapter
//    }

        fun createDataList(): List<RecordData> {
            val pref = PreferenceManager.getDefaultSharedPreferences(activity)
            val gson = Gson()
            val recordData = gson.fromJson(pref.getString("recordData", ""), RecordData::class.java)
            val dataList = mutableListOf<RecordData>()
            for (i in 0..49) {
                val data: RecordData = RecordData().also {
                    it.height = "aaa"
                    it.weight = "bbb"
                }
                dataList.add(data)
            }
            return dataList
        }
    }
}