package com.inmobi.rendering.mraid;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.inmobi.commons.core.utilities.info.DisplayInfo;
import com.inmobi.commons.core.utilities.info.c;
import com.inmobi.rendering.CustomView;
import com.inmobi.rendering.CustomView.SwitchIconType;
import com.inmobi.rendering.RenderView;

public final class k
{
  private static final String a = k.class.getSimpleName();
  private RenderView b;
  private ViewGroup c;
  private int d;
  
  public k(RenderView paramRenderView)
  {
    this.b = paramRenderView;
  }
  
  private RelativeLayout.LayoutParams a(String paramString, float paramFloat)
  {
    paramString = a(paramString);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)(50.0F * paramFloat), (int)(50.0F * paramFloat));
    if ((paramString.equals("top-right")) || (paramString.equals("bottom-right"))) {
      localLayoutParams.addRule(11);
    }
    if ((paramString.equals("bottom-right")) || (paramString.equals("bottom-left")) || (paramString.equals("bottom-center")))
    {
      localLayoutParams.addRule(12);
      localLayoutParams.addRule(4);
    }
    if ((paramString.equals("bottom-center")) || (paramString.equals("top-center")) || (paramString.equals("center"))) {
      localLayoutParams.addRule(13);
    }
    if (paramString.equals("top-center")) {
      localLayoutParams.addRule(10);
    }
    return localLayoutParams;
  }
  
  private String a(String paramString)
  {
    String str;
    if ((paramString == null) || (paramString.length() == 0)) {
      str = "top-right";
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return str;
                  str = paramString;
                } while (paramString.equals("top-left"));
                str = paramString;
              } while (paramString.equals("top-right"));
              str = paramString;
            } while (paramString.equals("bottom-left"));
            str = paramString;
          } while (paramString.equals("bottom-right"));
          str = paramString;
        } while (paramString.equals("top-center"));
        str = paramString;
      } while (paramString.equals("bottom-center"));
      str = paramString;
    } while (paramString.equals("center"));
    return "top-right";
  }
  
  private void a(ViewGroup paramViewGroup, String paramString)
  {
    float f = DisplayInfo.a().c();
    CustomView localCustomView = new CustomView(this.b.getRenderViewContext(), f, CustomView.SwitchIconType.CLOSE_TRANSPARENT);
    localCustomView.setId(65531);
    localCustomView.setOnClickListener(new k.1(this));
    paramViewGroup.addView(localCustomView, a(paramString, f));
  }
  
  private void a(FrameLayout paramFrameLayout1, FrameLayout paramFrameLayout2, m paramm)
  {
    float f = DisplayInfo.a().c();
    int i = (int)(paramm.b * f + 0.5F);
    int j = (int)(paramm.c * f + 0.5F);
    int k = (int)(paramm.d * f + 0.5F);
    int m = (int)(f * paramm.e + 0.5F);
    int[] arrayOfInt1 = new int[2];
    int[] arrayOfInt2 = new int[2];
    this.c.getLocationOnScreen(arrayOfInt1);
    paramFrameLayout1.getLocationOnScreen(arrayOfInt2);
    arrayOfInt1[1] -= arrayOfInt2[1];
    arrayOfInt1[0] -= arrayOfInt2[0];
    arrayOfInt1[0] = (k + arrayOfInt1[0]);
    arrayOfInt1[1] = (m + arrayOfInt1[1]);
    if (!paramm.f)
    {
      if (i > paramFrameLayout1.getWidth() - arrayOfInt1[0]) {
        arrayOfInt1[0] = (paramFrameLayout1.getWidth() - i);
      }
      if (j > paramFrameLayout1.getHeight() - arrayOfInt1[1]) {
        arrayOfInt1[1] = (paramFrameLayout1.getHeight() - j);
      }
      if (arrayOfInt1[0] < 0) {
        arrayOfInt1[0] = 0;
      }
      if (arrayOfInt1[1] < 0) {
        arrayOfInt1[1] = 0;
      }
    }
    paramFrameLayout1 = new FrameLayout.LayoutParams(i, j);
    paramFrameLayout1.leftMargin = arrayOfInt1[0];
    paramFrameLayout1.topMargin = arrayOfInt1[1];
    paramFrameLayout1.gravity = 8388611;
    paramFrameLayout2.setLayoutParams(paramFrameLayout1);
  }
  
  private void a(m paramm)
  {
    float f = DisplayInfo.a().c();
    int i = (int)(paramm.b * f + 0.5F);
    int j = (int)(f * paramm.c + 0.5F);
    FrameLayout localFrameLayout1 = (FrameLayout)this.c.getRootView().findViewById(16908290);
    FrameLayout localFrameLayout2 = new FrameLayout(this.b.getRenderViewContext());
    FrameLayout.LayoutParams localLayoutParams1 = new FrameLayout.LayoutParams(-1, -1);
    RelativeLayout localRelativeLayout = new RelativeLayout(this.b.getRenderViewContext());
    FrameLayout.LayoutParams localLayoutParams2 = new FrameLayout.LayoutParams(i, j);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, j);
    localFrameLayout2.setId(65534);
    if (this.b.getParent() != null) {
      ((ViewGroup)this.b.getParent()).removeAllViews();
    }
    localRelativeLayout.addView(this.b, localLayoutParams);
    a(localRelativeLayout, paramm.a);
    localFrameLayout2.addView(localRelativeLayout, localLayoutParams2);
    localFrameLayout1.addView(localFrameLayout2, localLayoutParams1);
    a(localFrameLayout1, localFrameLayout2, paramm);
    localFrameLayout2.setBackgroundColor(0);
  }
  
  private void c()
  {
    FrameLayout localFrameLayout = new FrameLayout(this.b.getRenderViewContext());
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(this.b.getWidth(), this.b.getHeight());
    localFrameLayout.setId(65535);
    this.c.addView(localFrameLayout, this.d, localLayoutParams);
    this.c.removeView(this.b);
  }
  
  public void a()
  {
    if (this.c == null)
    {
      this.c = ((ViewGroup)this.b.getParent());
      this.d = this.c.indexOfChild(this.b);
    }
    m localm = this.b.getResizeProperties();
    c();
    a(localm);
  }
  
  public void b()
  {
    ViewGroup localViewGroup = (ViewGroup)this.b.getParent();
    View localView1 = localViewGroup.getRootView().findViewById(65534);
    View localView2 = this.c.getRootView().findViewById(65535);
    ((ViewGroup)localView1.getParent()).removeView(localView1);
    ((ViewGroup)localView2.getParent()).removeView(localView2);
    localViewGroup.removeView(this.b);
    this.c.addView(this.b, this.d, new RelativeLayout.LayoutParams(this.c.getWidth(), this.c.getHeight()));
    this.b.m();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\rendering\mraid\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */