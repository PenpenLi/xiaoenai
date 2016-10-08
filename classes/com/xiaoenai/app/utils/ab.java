package com.xiaoenai.app.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.model.AppSettings;

public class ab
{
  private static int a = 0;
  private static int b = 0;
  private static int c = 0;
  private static String d = "screen_brightness";
  private static String e = "screen_brightness_mode";
  private static int f = 1;
  private static int g = 0;
  
  public static float a(Context paramContext, float paramFloat)
  {
    return b(paramContext, a(paramFloat));
  }
  
  public static int a()
  {
    if (b == 0)
    {
      if (com.xiaoenai.app.classes.common.a.a().c() == null) {
        break label28;
      }
      a(com.xiaoenai.app.classes.common.a.a().c());
    }
    for (;;)
    {
      return b;
      label28:
      c();
    }
  }
  
  public static int a(float paramFloat)
  {
    return (int)(Xiaoenai.j().getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public static int a(TextView paramTextView, String paramString)
  {
    Rect localRect = new Rect();
    paramTextView.getPaint().getTextBounds(paramString, 0, paramString.length(), localRect);
    return localRect.width();
  }
  
  public static void a(int paramInt)
  {
    if (a != paramInt) {
      AppSettings.setInt("DEFAULT_KEYBOARD_HEIGHT", Integer.valueOf(paramInt));
    }
    a = paramInt;
  }
  
  public static void a(Activity paramActivity)
  {
    if ((b == 0) || (c == 0))
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
      c = localDisplayMetrics.widthPixels;
      b = localDisplayMetrics.heightPixels;
    }
    com.xiaoenai.app.utils.f.a.c("screenWidth = {}", new Object[] { Integer.valueOf(c) });
    com.xiaoenai.app.utils.f.a.c("screenHeight = {}", new Object[] { Integer.valueOf(b) });
  }
  
  public static void a(Context paramContext, View paramView)
  {
    paramView.requestFocus();
    paramView.postDelayed(new ac(paramContext, paramView), 500L);
  }
  
  public static int b()
  {
    if (c == 0)
    {
      if (com.xiaoenai.app.classes.common.a.a().c() == null) {
        break label28;
      }
      a(com.xiaoenai.app.classes.common.a.a().c());
    }
    for (;;)
    {
      return c;
      label28:
      c();
    }
  }
  
  public static int b(float paramFloat)
  {
    return (int)(paramFloat / Xiaoenai.j().getResources().getDisplayMetrics().density + 0.5F);
  }
  
  public static int b(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat / paramContext.getResources().getDisplayMetrics().scaledDensity + 0.5F);
  }
  
  public static void b(Activity paramActivity)
  {
    if (paramActivity == null) {}
    View localView;
    do
    {
      return;
      localView = paramActivity.getWindow().peekDecorView();
    } while ((localView == null) || (localView.getWindowToken() == null));
    ((InputMethodManager)paramActivity.getSystemService("input_method")).hideSoftInputFromWindow(localView.getWindowToken(), 0);
  }
  
  public static int c(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().scaledDensity * paramFloat + 0.5F);
  }
  
  public static void c()
  {
    Display localDisplay = ((WindowManager)Xiaoenai.j().getSystemService("window")).getDefaultDisplay();
    c = localDisplay.getWidth();
    b = localDisplay.getHeight();
  }
  
  public static int d()
  {
    int i = AppSettings.getInt("DEFAULT_KEYBOARD_HEIGHT", Integer.valueOf(0)).intValue();
    if ((i > 0) && (a != i)) {
      a(i);
    }
    return a;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\utils\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */