package com.inmobi.rendering.mraid;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.inmobi.commons.a.a;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.rendering.InMobiAdActivity;
import com.inmobi.rendering.RenderView;
import com.inmobi.rendering.RenderingProperties;
import com.inmobi.rendering.RenderingProperties.PlacementType;

public final class h
{
  private static final String a = h.class.getSimpleName();
  private RenderView b;
  private boolean c;
  private ViewGroup d;
  private int e;
  
  public h(RenderView paramRenderView)
  {
    this.b = paramRenderView;
    this.c = false;
  }
  
  private void b()
  {
    FrameLayout localFrameLayout = new FrameLayout(this.b.getRenderViewContext());
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(this.b.getWidth(), this.b.getHeight());
    localFrameLayout.setId(65535);
    this.d.addView(localFrameLayout, this.e, localLayoutParams);
    this.d.removeView(this.b);
  }
  
  public void a()
  {
    if (this.b.getOriginalRenderView() == null)
    {
      View localView = this.d.getRootView().findViewById(65535);
      ((ViewGroup)this.b.getParent()).removeView(this.b);
      ((ViewGroup)localView.getParent()).removeView(localView);
      this.d.addView(this.b, this.e, new RelativeLayout.LayoutParams(this.d.getWidth(), this.d.getHeight()));
      this.b.m();
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.d == null)
    {
      this.d = ((ViewGroup)this.b.getParent());
      this.e = this.d.indexOfChild(this.b);
    }
    if (this.b == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Please check if the MRAID processor was initialized correctly.");
      return;
    }
    paramString1 = this.b.getExpandProperties();
    this.c = URLUtil.isValidUrl(paramString2);
    int j;
    if (this.c)
    {
      RenderView localRenderView = new RenderView(this.b.getRenderViewContext(), new RenderingProperties(RenderingProperties.PlacementType.INLINE));
      localRenderView.a(this.b.getListener(), this.b.getRenderingConfig(), this.b.getMraidConfig());
      localRenderView.setOriginalRenderView(this.b);
      localRenderView.loadUrl(paramString2);
      j = InMobiAdActivity.a(localRenderView);
      i = j;
      if (paramString1 != null) {
        localRenderView.setUseCustomClose(this.b.e());
      }
    }
    for (int i = j;; i = InMobiAdActivity.a(this.b))
    {
      paramString1 = new Intent(this.b.getRenderViewContext(), InMobiAdActivity.class);
      paramString1.putExtra("com.inmobi.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_TYPE", 102);
      paramString1.putExtra("com.inmobi.rendering.InMobiAdActivity.EXTRA_AD_RENDERVIEW_INDEX", i);
      a.a(this.b.getRenderViewContext(), paramString1);
      return;
      b();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\rendering\mraid\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */