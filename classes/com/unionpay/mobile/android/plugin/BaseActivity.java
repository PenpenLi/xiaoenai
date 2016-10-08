package com.unionpay.mobile.android.plugin;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.nfc.tech.IsoDep;
import android.nfc.tech.NfcF;
import android.nfc.tech.NfcV;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.unionpay.mobile.android.nocard.utils.UPPayEngine;
import com.unionpay.mobile.android.nocard.views.l;
import com.unionpay.mobile.android.utils.h;
import com.unionpay.mobile.android.widgets.m;
import java.util.ArrayList;

public abstract class BaseActivity
  extends Activity
  implements a, b
{
  public static String[][] a;
  public static IntentFilter[] b;
  private static int g = 0;
  private ArrayList<com.unionpay.mobile.android.nocard.views.b> c = null;
  private l d = null;
  private a e = null;
  private m f = null;
  
  static
  {
    try
    {
      String str1 = IsoDep.class.getName();
      String str2 = NfcV.class.getName();
      String str3 = NfcF.class.getName();
      a = new String[][] { { str1 }, { str2 }, { str3 } };
      b = new IntentFilter[] { new IntentFilter("android.nfc.action.TECH_DISCOVERED", "*/*") };
      return;
    }
    catch (Exception localException) {}
  }
  
  public Object a(String paramString)
  {
    com.unionpay.mobile.android.model.b localb = null;
    if (paramString == null) {
      localb = this.e.a;
    }
    do
    {
      return localb;
      if (paramString.equalsIgnoreCase(UPPayEngine.class.toString())) {
        return this.e.b;
      }
    } while (!paramString.equalsIgnoreCase(m.class.toString()));
    return this.f;
  }
  
  public final void a()
  {
    int i = this.c.size();
    if (i > 0)
    {
      this.c.remove(i - 1);
      if (this.c.size() != 0) {
        setContentView((View)this.c.get(this.c.size() - 1));
      }
    }
  }
  
  public final void a(int paramInt)
  {
    int i = this.c.size() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        com.unionpay.mobile.android.nocard.views.b localb = (com.unionpay.mobile.android.nocard.views.b)this.c.get(i);
        if (localb.h() == paramInt) {
          setContentView(localb);
        }
      }
      else
      {
        return;
      }
      this.c.remove(i);
      i -= 1;
    }
  }
  
  public final void a(com.unionpay.mobile.android.nocard.views.b paramb)
  {
    this.c.add(paramb);
    setContentView(paramb);
  }
  
  public final void b()
  {
    this.c.clear();
    this.d.x();
    this.d = null;
    com.unionpay.mobile.android.languages.c.by = null;
    int i = g - 1;
    g = i;
    if (i == 0) {
      com.unionpay.mobile.android.resource.c.a(this).a();
    }
    this.f.c();
    this.f = null;
    this.e.b = null;
    this.e.a = null;
    this.e = null;
    ((ViewGroup)getWindow().getDecorView().findViewById(16908290)).removeAllViews();
  }
  
  public final String c()
  {
    return this.e.a.a;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.d != null)
    {
      this.d.u();
      this.d = null;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    h.a("uppay", "PayActivityEx.onCreate() +++");
    com.unionpay.mobile.android.languages.c.a();
    com.unionpay.mobile.android.global.a.a(this);
    this.c = new ArrayList(1);
    this.e = new a(d());
    this.f = new m(this);
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    this.d = ((l)a(1, null));
    setContentView(this.d);
    g += 1;
    h.a("uppay", "PayActivityEx.onCreate() ---");
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (this.c.size() > 0) {
        ((com.unionpay.mobile.android.nocard.views.b)this.c.get(this.c.size() - 1)).l();
      }
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.f.a()) {
      this.f.b();
    }
  }
  
  private final class a
  {
    public com.unionpay.mobile.android.model.b a = null;
    public UPPayEngine b = null;
    
    public a(UPPayEngine paramUPPayEngine)
    {
      this.b = paramUPPayEngine;
      this.b.a(this.a);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\unionpay\mobile\android\plugin\BaseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */