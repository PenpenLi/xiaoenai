package com.xiaoenai.app.feature.photopreview.view.impl;

import android.os.Bundle;
import com.xiaoenai.app.feature.photopreview.a.a;
import com.xiaoenai.app.feature.photopreview.a.b;
import com.xiaoenai.app.feature.photopreview.view.ImageViewPagerWidget;
import com.xiaoenai.app.feature.photopreview.view.PreviewActivity;

public class ImageViewPager
  extends PreviewActivity
{
  private void g()
  {
    this.o = ((ImageViewPagerWidget)findViewById(a.a.image_pager));
    c();
  }
  
  public int d()
  {
    return a.b.preview_image_viewpager;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    g();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\feature\photopreview\view\impl\ImageViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */