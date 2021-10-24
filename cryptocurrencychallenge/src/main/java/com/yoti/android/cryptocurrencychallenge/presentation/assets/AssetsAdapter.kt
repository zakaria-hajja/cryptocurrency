package com.yoti.android.cryptocurrencychallenge.presentation.assets

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yoti.android.cryptocurrencychallenge.databinding.AssetItemBinding

class AssetsAdapter(
    private val assetItems: MutableList<AssetUiItem>,
    private val itemClickCallback: (AssetUiItem) -> Unit
) :
    RecyclerView.Adapter<AssetItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssetItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return AssetItemViewHolder(
            AssetItemBinding.inflate(
                inflater,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AssetItemViewHolder, position: Int) {
        holder.bind(assetItems[position], itemClickCallback)
    }

    override fun getItemCount() = assetItems.size

    fun set(data: List<AssetUiItem>) {
        assetItems.clear()
        assetItems.addAll(data)
        notifyDataSetChanged()
    }
}


class AssetItemViewHolder(private val binding: AssetItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(asset: AssetUiItem, itemClickCallback: (AssetUiItem) -> Unit) {
        binding.textViewAssetCode.text = asset.symbol
        binding.textViewAssetName.text = asset.name
        binding.textViewAssetPrice.text = asset.price
        binding.root.setOnClickListener {
            itemClickCallback(asset)
        }
    }
}
