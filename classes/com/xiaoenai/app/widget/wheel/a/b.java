package com.xiaoenai.app.widget.wheel.a;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public abstract class b
  extends a
{
  private int a = -15724528;
  protected Context b;
  protected LayoutInflater c;
  protected int d;
  protected int e;
  protected int f;
  private int g = 24;
  
  protected b(Context paramContext)
  {
    this(paramContext, -1);
  }
  
  protected b(Context paramContext, int paramInt)
  {
    this(paramContext, paramInt, 0);
  }
  
  protected b(Context paramContext, int paramInt1, int paramInt2)
  {
    this.b = paramContext;
    this.d = paramInt1;
    this.e = paramInt2;
    this.c = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
  }
  
  private View a(int paramInt, ViewGroup paramViewGroup)
  {
    switch (paramInt)
    {
    default: 
      return this.c.inflate(paramInt, paramViewGroup, false);
    case 0: 
      return null;
    }
    return new TextView(this.b);
  }
  
  private TextView a(View paramView, int paramInt)
  {
    if (paramInt == 0) {}
    try
    {
      if ((paramView instanceof TextView)) {
        return (TextView)paramView;
      }
      if (paramInt != 0)
      {
        paramView = (TextView)paramView.findViewById(paramInt);
        return paramView;
      }
    }
    catch (ClassCastException paramView)
    {
      Log.e("AbstractWheelAdapter", "You must supply a resource ID for a TextView");
      throw new IllegalStateException("AbstractWheelAdapter requires the resource ID to be a TextView", paramView);
    }
    return null;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramInt >= 0) && (paramInt < a()))
    {
      View localView = paramView;
      if (paramView == null) {
        localView = a(this.d, paramViewGroup);
      }
      TextView localTextView = a(localView, this.e);
      if (localTextView != null)
      {
        paramViewGroup = a(paramInt);
        paramView = paramViewGroup;
        if (paramViewGroup == null) {
          paramView = "";
        }
        localTextView.setText(paramView);
        if (this.d == -1) {
          a(localTextView);
        }
      }
      return localView;
    }
    return null;
  }
  
  public View a(View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      paramView = a(this.f, paramViewGroup);
    }
    for (;;)
    {
      if ((this.f == -1) && ((paramView instanceof TextView))) {
        a((TextView)paramView);
      }
      return paramView;
    }
  }
  
  protected abstract CharSequence a(int paramInt);
  
  protected void a(TextView paramTextView)
  {
    paramTextView.setTextColor(this.a);
    paramTextView.setGravity(17);
    paramTextView.setTextSize(this.g);
    paramTextView.setLines(1);
    paramTextView.setTypeface(Typeface.SANS_SERIF, 1);
  }
  
  public void b(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void c(int paramInt)
  {
    this.g = paramInt;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\widget\wheel\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */