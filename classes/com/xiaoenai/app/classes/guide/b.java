package com.xiaoenai.app.classes.guide;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.xiaoenai.app.model.UserConfig;

public class b
{
  public static GuideBaseView a = null;
  private static RelativeLayout b = null;
  private static View[] c = new View[4];
  
  public static GuideBaseView a(Context paramContext)
  {
    paramContext = new GuideBaseView(paramContext);
    paramContext.a(2130838491, 1);
    return paramContext;
  }
  
  private static GuideBaseView a(Context paramContext, int paramInt)
  {
    paramContext = new GuideBaseView(paramContext);
    paramContext.a();
    switch (paramInt)
    {
    default: 
      return paramContext;
    case 0: 
      paramContext.b();
      return paramContext;
    case 1: 
      paramContext.c();
      return paramContext;
    case 2: 
      paramContext.e();
      return paramContext;
    }
    paramContext.d();
    return paramContext;
  }
  
  public static void a(Context paramContext, RelativeLayout paramRelativeLayout)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    paramContext = a(paramContext);
    if (a != null)
    {
      paramRelativeLayout.removeView(a);
      a = null;
    }
    a = paramContext;
    paramContext.setSureBtnListener(new c(paramRelativeLayout, paramContext));
    paramRelativeLayout.addView(paramContext, localLayoutParams);
  }
  
  public static void a(Context paramContext, RelativeLayout paramRelativeLayout, int paramInt)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    GuideBaseView localGuideBaseView = a(paramContext, paramInt);
    if (c[paramInt] != null)
    {
      paramRelativeLayout.removeView(c[paramInt]);
      c[paramInt] = null;
    }
    c[paramInt] = localGuideBaseView;
    localGuideBaseView.requestLayout();
    localGuideBaseView.setOnClickListener(new d(paramInt, paramRelativeLayout, localGuideBaseView, paramContext));
    if (b == null)
    {
      b = new RelativeLayout(paramContext);
      b.setOnClickListener(new e());
      paramRelativeLayout.addView(b, localLayoutParams);
    }
    paramRelativeLayout.addView(localGuideBaseView, localLayoutParams);
  }
  
  public static void a(RelativeLayout paramRelativeLayout)
  {
    if (a != null) {
      paramRelativeLayout.removeView(a);
    }
    int i = 0;
    while (i < c.length)
    {
      if (c[i] != null) {
        paramRelativeLayout.removeView(c[i]);
      }
      i += 1;
    }
    if (b != null) {
      paramRelativeLayout.removeView(b);
    }
  }
  
  public static boolean a()
  {
    return UserConfig.getBoolean("first_in_home_single", Boolean.valueOf(true)).booleanValue();
  }
  
  public static boolean b()
  {
    return UserConfig.getBoolean("first_in_home_connect", Boolean.valueOf(true)).booleanValue();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\guide\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */