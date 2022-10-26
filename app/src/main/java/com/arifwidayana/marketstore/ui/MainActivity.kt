package com.arifwidayana.marketstore.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arifwidayana.marketstore.adapter.ListItemAdapter
import com.arifwidayana.marketstore.data.ListStoreResponse
import com.arifwidayana.marketstore.data.DataMarketStore
import com.arifwidayana.marketstore.data.DataMarketStore.data
import com.arifwidayana.marketstore.databinding.ActivityMainBinding
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var list: ArrayList<ListStoreResponse> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list.addAll(data)
        onClickAdapter(list)
        onClick()
    }

    private fun onClick() {
        binding.aboutPage.setOnClickListener {
            startActivity(Intent(this, AboutActivity::class.java))
            finish()
        }
    }

    private fun onClickAdapter(listProduct: ArrayList<ListStoreResponse>) {
        binding.apply {
            val adapter = ListItemAdapter {
                val bundle = Bundle()
                bundle.apply {
                    putString(DataMarketStore.NAME_PRODUCT, it.name)
                    putInt(DataMarketStore.IMAGE_PRODUCT, it.image)
                    putString(DataMarketStore.EXPIRED_PRODUCT, it.expired)
                    putString(DataMarketStore.DESC_PRODUCT, it.desc)
                }
                startActivity(Intent(this@MainActivity, DetailActivity::class.java)
                    .putExtra(DataMarketStore.DATA_PRODUCT, bundle)
                )
                finish()
            }
            adapter.submitList(listProduct)
            rvProduct.adapter = adapter
        }
    }
}