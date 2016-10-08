package com.alipay.sdk.widget;

import android.app.Activity;
import android.app.ProgressDialog;

public final class a
{
  Activity a;
  ProgressDialog b;
  
  public a(Activity paramActivity)
  {
    this.a = paramActivity;
  }
  
  private void a(CharSequence paramCharSequence)
  {
    c();
    paramCharSequence = new b(this, paramCharSequence);
    if ((this.a != null) && (!this.a.isFinishing())) {
      this.a.runOnUiThread(paramCharSequence);
    }
  }
  
  public final boolean a()
  {
    return (this.b != null) && (this.b.isShowing());
  }
  
  public final void b()
  {
    c();
    b localb = new b(this, "正在加载");
    if ((this.a != null) && (!this.a.isFinishing())) {
      this.a.runOnUiThread(localb);
    }
  }
  
  public final void c()
  {
    c localc = new c(this);
    if ((this.a != null) && (!this.a.isFinishing())) {
      this.a.runOnUiThread(localc);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\sdk\widget\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */