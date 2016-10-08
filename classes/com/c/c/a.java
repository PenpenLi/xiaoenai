package com.c.c;

import android.view.View;

public final class a
{
  public static float a(View paramView)
  {
    if (com.c.c.a.a.a) {
      return com.c.c.a.a.a(paramView).m();
    }
    return a.a(paramView);
  }
  
  public static void a(View paramView, float paramFloat)
  {
    if (com.c.c.a.a.a)
    {
      com.c.c.a.a.a(paramView).a(paramFloat);
      return;
    }
    a.a(paramView, paramFloat);
  }
  
  public static float b(View paramView)
  {
    if (com.c.c.a.a.a) {
      return com.c.c.a.a.a(paramView).n();
    }
    return a.b(paramView);
  }
  
  public static void b(View paramView, float paramFloat)
  {
    if (com.c.c.a.a.a)
    {
      com.c.c.a.a.a(paramView).i(paramFloat);
      return;
    }
    a.b(paramView, paramFloat);
  }
  
  private static final class a
  {
    static float a(View paramView)
    {
      return paramView.getX();
    }
    
    static void a(View paramView, float paramFloat)
    {
      paramView.setAlpha(paramFloat);
    }
    
    static float b(View paramView)
    {
      return paramView.getY();
    }
    
    static void b(View paramView, float paramFloat)
    {
      paramView.setTranslationX(paramFloat);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\c\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */