package com.unionpay.uppay;

import android.os.Bundle;
import com.unionpay.mobile.android.nocard.utils.UPPayEngine;
import com.unionpay.mobile.android.plugin.BaseActivity;
import com.unionpay.mobile.android.pro.views.c;
import com.unionpay.mobile.android.utils.l;

public final class PayActivity
  extends BaseActivity
{
  private com.unionpay.mobile.android.pro.pboc.engine.b c = null;
  private l d;
  
  static
  {
    System.loadLibrary("entryexstd");
  }
  
  public final com.unionpay.mobile.android.nocard.views.b a(int paramInt, com.unionpay.mobile.android.model.d paramd)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return new c(this);
    }
    return new com.unionpay.mobile.android.pro.views.d(this, paramd);
  }
  
  public final Object a(String paramString)
  {
    if (com.unionpay.mobile.android.pro.pboc.engine.b.class.toString().equalsIgnoreCase(paramString))
    {
      if (this.c == null) {
        this.c = new com.unionpay.mobile.android.pro.pboc.engine.b(this, c());
      }
      return this.c;
    }
    return super.a(paramString);
  }
  
  public final UPPayEngine d()
  {
    this.d = new l(this);
    return this.d;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  protected final void onDestroy()
  {
    super.onDestroy();
    if (this.c != null)
    {
      this.c.a();
      this.c = null;
    }
    this.d.f();
    this.d = null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\unionpay\uppay\PayActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */