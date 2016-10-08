package com.xiaoenai.app.classes.store;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.xiaoenai.app.classes.store.a.a;
import com.xiaoenai.app.classes.store.sticker.BaseSticker;
import com.xiaoenai.app.classes.store.sticker.FaceSticker;
import com.xiaoenai.app.classes.store.view.BannerStickerView;
import com.xiaoenai.app.classes.store.view.BaseStickerView;
import com.xiaoenai.app.classes.store.view.FaceStickerView;
import com.xiaoenai.app.classes.store.view.FunnystickerView;

public class ag
  extends BaseAdapter
{
  private Object[] a;
  private Context b;
  private int c = 1;
  
  public ag(Object[] paramArrayOfObject, Context paramContext)
  {
    this.a = paramArrayOfObject;
    this.b = paramContext;
  }
  
  public void a(BaseStickerView paramBaseStickerView, int paramInt, BaseSticker paramBaseSticker)
  {
    paramBaseStickerView.setClickable(true);
    paramBaseStickerView.setDescendantFocusability(393216);
    paramBaseStickerView.setBackgroundResource(2130839054);
    paramBaseStickerView.setOnClickListener(new ah(this, paramBaseSticker, paramInt));
  }
  
  public void a(Object[] paramArrayOfObject, int paramInt)
  {
    this.a = paramArrayOfObject;
    notifyDataSetChanged();
    this.c = paramInt;
  }
  
  public int getCount()
  {
    if (this.a != null) {
      return this.a.length;
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.a != null) {
      return this.a[paramInt];
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = (BaseSticker)this.a[paramInt];
    if (paramView == null) {
      switch (paramViewGroup.getType())
      {
      default: 
        paramView.setTag(paramView);
        label49:
        switch (paramViewGroup.getType())
        {
        }
        break;
      }
    }
    for (;;)
    {
      a((BaseStickerView)paramView, paramViewGroup.getType(), paramViewGroup);
      return paramView;
      paramView = new FaceStickerView(this.b);
      break;
      paramView = new FunnystickerView(this.b);
      break;
      paramView = new BannerStickerView(this.b);
      break;
      paramView = (View)paramView.getTag();
      break label49;
      a.a(this.b, (FaceSticker)paramViewGroup, (FaceStickerView)paramView, this.c);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\store\ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */