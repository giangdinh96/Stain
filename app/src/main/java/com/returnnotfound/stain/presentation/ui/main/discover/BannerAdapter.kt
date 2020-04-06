package com.returnnotfound.stain.presentation.ui.main.discover

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.returnnotfound.stain.R
import com.returnnotfound.stain.base.extension.loadImage

class BannerAdapter : RecyclerView.Adapter<BannerAdapter.BannerViewHolder>() {
  val items = listOf(
    "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__340.jpg"
    , "https://cdn.pixabay.com/photo/2015/02/24/15/41/dog-647528__340.jpg"
    , "https://cdn.shopify.com/s/files/1/1327/6929/files/Greece-Zakynthos-Ionian-Islands-960x600_1024x1024.jpg?v=1521125276"
    , "https://i.etsystatic.com/13906434/r/il/bb5d11/1415398468/il_570xN.1415398468_9o91.jpg"
  )

  class BannerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var imageView: ImageView = view.findViewById(R.id.image_iv)
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.item_banner, parent, false);
    return BannerViewHolder(view)
  }

  override fun getItemCount() = items.size

  override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
    holder.imageView.loadImage(items[position])
  }
}