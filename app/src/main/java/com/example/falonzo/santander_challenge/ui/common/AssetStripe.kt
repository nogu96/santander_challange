package com.example.falonzo.santander_challenge.ui.common

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.text.TextPaint
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.falonzo.santander_challenge.R
import com.example.falonzo.santander_challenge.databinding.SampleAssetStripeBinding
import com.example.falonzo.santander_challenge.model.Asset
import org.koin.core.KoinApplication.Companion.init

class AssetStripe @JvmOverloads constructor(context : Context,
                                            attributeSet: AttributeSet? = null,
                                            defStyle: Int = 0 )
    : FrameLayout(context, attributeSet, defStyle)  {

    val binding = SampleAssetStripeBinding.inflate(LayoutInflater.from(context), this, true)
    val assetAdapter = AssetAdapter()

    init {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = assetAdapter
        }
    }

    fun setTitle(title: String) {
        binding.stripeTitle.text = title
    }

    fun setList(assetList: List<Asset>) {
        assetAdapter.setAssetList(assetList)
    }

}