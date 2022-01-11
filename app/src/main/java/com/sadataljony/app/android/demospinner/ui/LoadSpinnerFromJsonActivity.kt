package com.sadataljony.app.android.demospinner.ui

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.sadataljony.app.android.demospinner.model.DemoModel
import com.sadataljony.demospinner.databinding.ActivityMainBinding

class LoadSpinnerFromJsonActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        getProductOwnersInfoFromDummy()
    }

    private fun getProductOwnersInfoFromDummy() {
        val productOwnerRawJson = "[\n" +
                "    {\n" +
                "      \"productOwnerName\": \"Nuruzzaman Luther\",\n" +
                "      \"productOwnersPin\": 10001,\n" +
                "      \"appCode\": \"12312edwdf\",\n" +
                "      \"isOwner\": true\n" +
                "    },\n" +
                "    {\n" +
                "      \"productOwnerName\": \"Kamrul Islam\",\n" +
                "      \"productOwnersPin\": 10002,\n" +
                "      \"appCode\": \"12312edwdg\",\n" +
                "      \"isOwner\": true\n" +
                "    },\n" +
                "    {\n" +
                "      \"productOwnerName\": \"Moinul Islam\",\n" +
                "      \"productOwnersPin\": 10003,\n" +
                "      \"appCode\": \"12312edwdh\",\n" +
                "      \"isOwner\": true\n" +
                "    }\n" +
                "  ]"

        val gson = Gson()

        val productOwnersList: List<DemoModel> =
            gson.fromJson(productOwnerRawJson, Array<DemoModel>::class.java).toList()

        val productOwnersAdapter: ArrayAdapter<DemoModel> =
            ArrayAdapter<DemoModel>(
                this,
                android.R.layout.simple_spinner_item,
                productOwnersList
            )

        productOwnersAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.sp.adapter = productOwnersAdapter

        binding.sp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                Toast.makeText(
                    applicationContext, binding.sp.selectedItem.toString(), Toast
                        .LENGTH_SHORT
                )
                    .show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Another interface callback
            }
        }
    }
}