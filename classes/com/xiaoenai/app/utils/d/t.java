package com.xiaoenai.app.utils.d;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class t
{
  private static int a = 0;
  private static int b = 0;
  
  public static int a(Context paramContext)
  {
    if (a == 0)
    {
      if ((paramContext == null) || (!(paramContext instanceof Activity))) {
        break label28;
      }
      a((Activity)paramContext);
    }
    for (;;)
    {
      return a;
      label28:
      c(paramContext);
    }
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public static void a(Activity paramActivity)
  {
    if ((a == 0) || (b == 0))
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
      b = localDisplayMetrics.widthPixels;
      a = localDisplayMetrics.heightPixels;
    }
  }
  
  public static int b(Context paramContext)
  {
    if (b == 0)
    {
      if ((paramContext == null) || (!(paramContext instanceof Activity))) {
        break label28;
      }
      a((Activity)paramContext);
    }
    for (;;)
    {
      return b;
      label28:
      c(paramContext);
    }
  }
  
  public static void c(Context paramContext)
  {
    Point localPoint = new Point();
    if (Build.VERSION.SDK_INT >= 13)
    {
      ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getSize(localPoint);
      b = localPoint.x;
      a = localPoint.y;
      return;
    }
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    b = paramContext.getWidth();
    a = paramContext.getHeight();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\utils\d\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */