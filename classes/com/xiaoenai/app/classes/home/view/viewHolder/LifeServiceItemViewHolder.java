package com.xiaoenai.app.classes.home.view.viewHolder;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.xiaoenai.app.classes.home.model.HomeDiscoverItem;
import com.xiaoenai.app.model.ImageInfo;
import com.xiaoenai.app.model.RedHintsInfo;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.ae;
import com.xiaoenai.app.utils.e.b;
import com.xiaoenai.app.widget.remindButton.RemindButton;
import com.xiaoenai.app.widget.remindButton.a;

public class LifeServiceItemViewHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private a a;
  @BindView(2131558577)
  ImageView mIconImg;
  @BindView(2131559568)
  RemindButton mRemindButton;
  @BindView(2131558578)
  TextView mTitleTxt;
  
  public LifeServiceItemViewHolder(View paramView, a parama)
  {
    super(paramView);
    this.a = parama;
    ButterKnife.bind(this, paramView);
    paramView.setOnClickListener(this);
  }
  
  public void a(HomeDiscoverItem paramHomeDiscoverItem)
  {
    if ((paramHomeDiscoverItem == null) || ((paramHomeDiscoverItem.getIcon() == null) && (ae.a(paramHomeDiscoverItem.getTitle()))))
    {
      this.mIconImg.setVisibility(8);
      this.mTitleTxt.setVisibility(8);
      this.itemView.setBackgroundColor(this.itemView.getResources().getColor(2131493206));
    }
    for (;;)
    {
      this.itemView.setTag(paramHomeDiscoverItem);
      return;
      this.mIconImg.setVisibility(0);
      this.mTitleTxt.setVisibility(0);
      b.a(this.mIconImg, paramHomeDiscoverItem.getIcon().getCommonUrl());
      this.mTitleTxt.setText(paramHomeDiscoverItem.getTitle());
      this.itemView.setBackgroundResource(2130839054);
      Object localObject = paramHomeDiscoverItem.getRedHintsInfo();
      if (localObject != null)
      {
        a.a().a(this.mRemindButton, (RedHintsInfo)localObject);
        if (((RedHintsInfo)localObject).getStyle() == 0)
        {
          localObject = (RelativeLayout.LayoutParams)this.mRemindButton.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).topMargin = ab.a(10.0F);
          ((RelativeLayout.LayoutParams)localObject).rightMargin = ab.a(20.0F);
          this.mRemindButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        else
        {
          localObject = (RelativeLayout.LayoutParams)this.mRemindButton.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).topMargin = ab.a(1.0F);
          ((RelativeLayout.LayoutParams)localObject).rightMargin = ab.a(1.0F);
          this.mRemindButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      else
      {
        this.mRemindButton.b();
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if ((paramView != null) && (this.a != null)) {
      this.a.a(paramView);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(View paramView);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\home\view\viewHolder\LifeServiceItemViewHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */