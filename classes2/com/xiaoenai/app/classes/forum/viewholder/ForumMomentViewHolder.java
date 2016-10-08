package com.xiaoenai.app.classes.forum.viewholder;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.marshalchen.ultimaterecyclerview.f;
import com.xiaoenai.app.classes.forum.model.MomentInfo;
import com.xiaoenai.app.model.ImageInfo;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.ak;
import com.xiaoenai.app.utils.e.b;

public class ForumMomentViewHolder
  extends f<MomentInfo>
{
  @BindView(2131559250)
  ImageView mImg;
  @BindView(2131559251)
  TextView mIngFlag;
  @BindView(2131559253)
  TextView mTime;
  @BindView(2131559252)
  TextView mTitle;
  
  public ForumMomentViewHolder(View paramView)
  {
    super(paramView);
    ButterKnife.bind(this, paramView);
  }
  
  public void a(MomentInfo paramMomentInfo)
  {
    ImageInfo localImageInfo;
    int j;
    int k;
    if (paramMomentInfo != null)
    {
      localImageInfo = paramMomentInfo.getImage_info();
      if (localImageInfo != null)
      {
        j = ab.b() - ab.a(30.0F);
        i = localImageInfo.get_width().intValue();
        k = localImageInfo.get_height().intValue();
        if ((i <= 0) || (k <= 0)) {
          break label225;
        }
      }
    }
    label225:
    for (int i = k * j / i;; i = j * 417 / 1152)
    {
      localImageInfo.setViewScale(j, i);
      ViewGroup.LayoutParams localLayoutParams = this.mImg.getLayoutParams();
      localLayoutParams.width = j;
      localLayoutParams.height = i;
      this.mImg.setImageResource(2131493206);
      b.a(this.mImg, localImageInfo.getCommonUrl());
      this.mTitle.setText(paramMomentInfo.getTitle());
      this.mTime.setText(ak.k(paramMomentInfo.getStart_ts()) + " - " + ak.k(paramMomentInfo.getEnd_ts()));
      switch (paramMomentInfo.getStatus())
      {
      default: 
        this.mIngFlag.setText(this.itemView.getResources().getString(2131100615));
        this.mIngFlag.setBackgroundResource(2130838442);
        return;
      }
    }
    this.mIngFlag.setText(this.itemView.getResources().getString(2131100615));
    this.mIngFlag.setBackgroundResource(2130838442);
    return;
    this.mIngFlag.setText(this.itemView.getResources().getString(2131100144));
    this.mIngFlag.setBackgroundResource(2130838441);
    return;
    this.mIngFlag.setText(this.itemView.getResources().getString(2131101634));
    this.mIngFlag.setBackgroundResource(2130838445);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\forum\viewholder\ForumMomentViewHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */