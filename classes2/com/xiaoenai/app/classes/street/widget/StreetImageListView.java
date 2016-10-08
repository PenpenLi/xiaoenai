package com.xiaoenai.app.classes.street.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.xiaoenai.app.classes.street.model.Banner;
import com.xiaoenai.app.classes.street.model.ImageInfo;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.e.b;
import com.xiaoenai.app.utils.f.a;
import java.util.Arrays;

public class StreetImageListView
  extends LinearLayout
{
  private Context a;
  private Banner[] b = null;
  private a c = null;
  private View.OnClickListener d = null;
  
  public StreetImageListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  @TargetApi(11)
  public StreetImageListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a()
  {
    this.d = new i(this);
  }
  
  private void a(Context paramContext)
  {
    this.a = paramContext;
    setOrientation(1);
    setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    setBackgroundResource(2131493119);
    a();
  }
  
  private void b()
  {
    if ((this.b != null) && (this.b.length > 0))
    {
      removeAllViews();
      int j = ab.b();
      a.c("getScreenWidth = {}", new Object[] { Integer.valueOf(j) });
      int k = ab.a(3.0F);
      int i = 0;
      if (i < this.b.length)
      {
        ImageView localImageView;
        int m;
        Object localObject;
        if (this.b[i].getImageInfo() != null)
        {
          localImageView = new ImageView(this.a);
          a.c("getWidth = {}", new Object[] { Integer.valueOf(this.b[i].getImageInfo().getWidth()) });
          a.c("getHeight = {}", new Object[] { Integer.valueOf(this.b[i].getImageInfo().getHeight()) });
          m = this.b[i].getImageInfo().getHeight() * j / this.b[i].getImageInfo().getWidth();
          if (i == 0) {
            break label297;
          }
          localObject = new LinearLayout.LayoutParams(-1, m);
          ((LinearLayout.LayoutParams)localObject).setMargins(0, k, 0, 0);
          localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        for (;;)
        {
          localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
          localImageView.setTag(this.b[i]);
          localImageView.setOnClickListener(this.d);
          localObject = this.b[i].getImageInfo().getUrl() + "?imageView/1/w/" + j + "/h/" + m;
          a.c("url = {}", new Object[] { localObject });
          b.a(localImageView, (String)localObject);
          addView(localImageView);
          i += 1;
          break;
          label297:
          localImageView.setLayoutParams(new LinearLayout.LayoutParams(-1, m));
        }
      }
    }
  }
  
  public void setBanners(Banner[] paramArrayOfBanner)
  {
    if ((this.b != null) && (Arrays.equals(this.b, paramArrayOfBanner))) {
      a.c("setBanners mBanners = banners", new Object[0]);
    }
    while (paramArrayOfBanner == null) {
      return;
    }
    this.b = paramArrayOfBanner;
    b();
  }
  
  public void setOnClickListener(a parama)
  {
    this.c = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a(Banner paramBanner);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\StreetImageListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */