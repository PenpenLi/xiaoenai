package com.xiaoenai.app.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.ImageView;

public class BannerView
  extends ImageView
{
  public BannerView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public BannerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public BannerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    setBackgroundColor(getResources().getColor(2131493177));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\widget\BannerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */