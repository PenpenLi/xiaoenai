package com.unionpay.mobile.android.widgets;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.text.InputFilter.LengthFilter;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.inputmethod.InputMethodManager;
import com.unionpay.mobile.android.global.a;
import com.unionpay.mobile.android.utils.h;
import org.json.JSONObject;

public final class UPWidget
  extends z
  implements t.b
{
  private static final int n = a.t / 3;
  private long o;
  private boolean p = true;
  private String q = null;
  private int r = 0;
  private boolean s = false;
  private ViewTreeObserver.OnGlobalLayoutListener t = new av(this);
  private ba u = null;
  private View.OnClickListener v = new aw(this);
  
  public UPWidget(Context paramContext, int paramInt, JSONObject paramJSONObject)
  {
    super(paramContext, paramInt, paramJSONObject);
    u();
    d();
  }
  
  public UPWidget(Context paramContext, long paramLong, int paramInt, JSONObject paramJSONObject)
  {
    super(paramContext, paramInt, paramJSONObject);
    this.o = paramLong;
    u();
    d();
  }
  
  private native void appendOnce(long paramLong, String paramString);
  
  private native void clearAll(long paramLong);
  
  private native void deleteOnce(long paramLong);
  
  private native String getMsg(long paramLong);
  
  private native String getMsgExtra(long paramLong, String paramString);
  
  private void u()
  {
    this.b.a(this);
    this.b.a(new InputFilter.LengthFilter(6));
    this.b.f();
    this.b.d();
  }
  
  private void v()
  {
    if (w() != null) {
      w().getViewTreeObserver().removeGlobalOnLayoutListener(this.t);
    }
    if ((this.u != null) && (this.u.b())) {
      this.u.a();
    }
  }
  
  private View w()
  {
    return ((Activity)this.c).findViewById(8888);
  }
  
  public final String a()
  {
    if (this.p) {
      return getMsgExtra(this.o, this.q);
    }
    return getMsg(this.o);
  }
  
  public final void a(long paramLong)
  {
    this.o = paramLong;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.s = paramBoolean;
    if (paramBoolean)
    {
      ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.b.getWindowToken(), 0);
      int i = 1;
      int j = w().getRootView().getHeight();
      int k = w().getHeight();
      Rect localRect = new Rect();
      getWindowVisibleDisplayFrame(localRect);
      if (j - k != localRect.top) {
        i = 0;
      }
      if (i != 0) {
        k();
      }
      while (i()) {
        return;
      }
      h.a("uppay", "key board is closing..");
      h.a("uppay", "registerKeyboardDissmisslisner() +++");
      if (w() != null) {
        w().getViewTreeObserver().addOnGlobalLayoutListener(this.t);
      }
      h.a("uppay", "registerKeyboardDissmisslisner() ---");
      return;
    }
    v();
  }
  
  public final void a_()
  {
    if ((this.s) && (!i())) {
      k();
    }
  }
  
  public final void b(String paramString)
  {
    this.q = paramString;
  }
  
  public final void b(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  public final boolean b()
  {
    return this.r == 6;
  }
  
  public final boolean c()
  {
    h.a("uppay", "emptyCheck() +++ ");
    h.a("uppay", "mPINCounts =  " + this.r);
    h.a("uppay", "emptyCheck() --- ");
    return this.r != 0;
  }
  
  public final void d()
  {
    if (this.r > 0)
    {
      clearAll(this.o);
      this.r = 0;
    }
  }
  
  public final boolean i()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.u != null)
    {
      bool1 = bool2;
      if (this.u.b()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final void j()
  {
    h.a("uppay", "closeCustomKeyboard() +++");
    if (i()) {
      v();
    }
    h.a("uppay", "closeCustomKeyboard() ---");
  }
  
  public final void k()
  {
    if ((this.s) && (!i()))
    {
      this.u = new ba(getContext(), this.v, this);
      this.u.a(this);
      int j = this.r;
      String str = "";
      int i = 0;
      while (i < j)
      {
        str = str + "*";
        i += 1;
      }
      this.b.c(str);
      this.b.b(str.length());
    }
  }
  
  protected final void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    j();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\unionpay\mobile\android\widgets\UPWidget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */