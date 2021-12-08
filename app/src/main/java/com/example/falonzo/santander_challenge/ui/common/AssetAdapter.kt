package com.example.falonzo.santander_challenge.ui.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.falonzo.santander_challenge.databinding.AssetItemBinding
import com.example.falonzo.santander_challenge.extension.load
import com.example.falonzo.santander_challenge.model.Asset

class AssetAdapter: RecyclerView.Adapter<AssetAdapter.ViewHolder>() {

    private val assetList = mutableListOf<Asset>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(AssetItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(assetList.get(position))
    }

    override fun getItemCount() = assetList.size

    fun setAssetList(assetList: List<Asset>) {
        this.assetList.addAll(assetList)
        notifyDataSetChanged()
    }

    class ViewHolder(
        private val binding: AssetItemBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(asset: Asset) {
            binding.imageView.load(asset.getImage())
            binding.title.text = asset.getName()
        }

    }
}