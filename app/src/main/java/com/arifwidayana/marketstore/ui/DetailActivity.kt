package com.arifwidayana.marketstore.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import com.arifwidayana.marketstore.R
import com.arifwidayana.marketstore.data.DataMarketStore
import com.arifwidayana.marketstore.databinding.ActivityDetailBinding
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onClick()
        onView()
    }

    private fun onView() {
        binding.apply {
            tvName.text = parsingBundle(DataMarketStore.NAME_PRODUCT).toString()
            tvExpired.text = parsingBundle(DataMarketStore.EXPIRED_PRODUCT).toString()
            tvDescription.text = parsingBundle(DataMarketStore.DESC_PRODUCT).toString()
            Glide.with(root)
                .load(parsingBundle(int = DataMarketStore.IMAGE_PRODUCT))
                .centerCrop()
                .into(ivProduct)
        }
    }

    private fun onClick() {
        binding.apply {
            onBackPressedDispatcher.addCallback(object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    startActivity(Intent(this@DetailActivity, MainActivity::class.java))
                    finish()
                }
            })
            ivBack.setOnClickListener {
                startActivity(Intent(this@DetailActivity, MainActivity::class.java))
                finish()
            }
            actionShare.setOnClickListener {
                val shareIntent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TITLE, parsingBundle(DataMarketStore.NAME_PRODUCT).toString())
                    putExtra(Intent.EXTRA_TEXT, parsingBundle(DataMarketStore.DESC_PRODUCT).toString())
                    flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
                    type = "text/plain"
                }
                startActivity(Intent.createChooser(shareIntent, resources.getString(R.string.share_product_to)))
            }
        }
    }

    private fun parsingBundle(string: String? = null, int: String? = null): Any? {
        val getBundle = intent.extras?.getBundle(DataMarketStore.DATA_PRODUCT)
        when {
            !string.isNullOrEmpty() -> {
                return getBundle?.getString(string)
            }
            !int.isNullOrEmpty() -> {
                return getBundle?.getInt(int)
            }
        }
        return null
    }
}