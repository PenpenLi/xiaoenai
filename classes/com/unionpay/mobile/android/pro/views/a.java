package com.unionpay.mobile.android.pro.views;

import android.content.Context;
import com.unionpay.mobile.android.nocard.views.l;
import com.unionpay.mobile.android.plugin.c;
import com.unionpay.mobile.android.utils.h;
import com.unionpay.mobile.android.utils.i;
import org.simalliance.openmobileapi.Reader;
import org.simalliance.openmobileapi.SEService;

public class a
  extends l
{
  public a(Context paramContext)
  {
    super(paramContext);
  }
  
  protected final void r()
  {
    try
    {
      Class.forName("org.simalliance.openmobileapi.SEService");
      com.unionpay.mobile.android.model.b localb1 = this.a;
      com.unionpay.mobile.android.model.b.aQ = true;
      new i(this.d, this);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      com.unionpay.mobile.android.model.b localb2 = this.a;
      com.unionpay.mobile.android.model.b.aQ = false;
      s();
    }
  }
  
  public final void v()
  {
    for (;;)
    {
      try
      {
        h.c("uppay-pro", "checkAndGetSDCardsList +++");
        if ("00".equalsIgnoreCase(this.a.D.c)) {
          break label102;
        }
        if (!"95".equalsIgnoreCase(this.a.D.c)) {
          break label107;
        }
      }
      finally {}
      com.unionpay.mobile.android.pro.pboc.engine.b localb = z();
      b localb1 = new b(this);
      if (localb != null)
      {
        z().a(localb1, bool);
        h.c("uppay-pro", "checkAndGetSDCardsList ---");
        return;
      }
      localb1.a(null);
      continue;
      label102:
      boolean bool = true;
      continue;
      label107:
      bool = false;
    }
  }
  
  public final void y()
  {
    StringBuffer localStringBuffer = new StringBuffer("000");
    Object localObject = null;
    com.unionpay.mobile.android.model.b localb = this.a;
    if (com.unionpay.mobile.android.model.b.aQ) {
      localObject = new i();
    }
    if ((localObject != null) && (i.a() != null) && (i.a().isConnected()))
    {
      localObject = i.a().getReaders();
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        localb = localObject[i];
        if (localb != null)
        {
          if (localb.getName().toLowerCase().startsWith("sim")) {
            localStringBuffer.setCharAt(0, '1');
          }
          if (localb.getName().toLowerCase().startsWith("ese")) {
            localStringBuffer.setCharAt(1, '1');
          }
          if (localb.getName().toLowerCase().startsWith("sd")) {
            localStringBuffer.setCharAt(2, '1');
          }
        }
        i += 1;
      }
    }
    d(localStringBuffer.toString());
  }
  
  public com.unionpay.mobile.android.pro.pboc.engine.b z()
  {
    return null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\unionpay\mobile\android\pro\views\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */