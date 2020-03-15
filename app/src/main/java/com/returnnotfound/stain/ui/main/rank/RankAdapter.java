package com.returnnotfound.stain.ui.main.rank;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.returnnotfound.stain.R;
import com.returnnotfound.stain.data.model.AnimeTop;
import com.returnnotfound.stain.utils.DimensionUtils;
import com.returnnotfound.stain.widget.image.ImageUtils;

public class RankAdapter extends BaseQuickAdapter<AnimeTop, BaseViewHolder> {

  public RankAdapter(int layoutResId) {
    super(layoutResId);
  }

  @Override
  protected void convert(@NonNull BaseViewHolder helper, AnimeTop item) {
    ImageUtils.getRequestBuilderDefault(helper.getView(R.id.image_iv))
        .placeholder(null)
        .transform(new CenterCrop(), new RoundedCorners(DimensionUtils.dpToPx(mContext, 5)))
        .load(item.getImageUrl())
        .into((ImageView) helper.getView(R.id.image_iv));
    helper.setText(R.id.rank_tv, String.valueOf(item.getRank()));
    helper.setText(R.id.name_tv, item.getTitle())
        .setText(R.id.date_tv, item.getStartDate());

    Drawable backgroundRankColor = ImageUtils.getDrawable(DimensionUtils.dpToPx(mContext, 24), item.getRankColor());
    helper.getView(R.id.rank_tv).setBackground(backgroundRankColor);
  }
}