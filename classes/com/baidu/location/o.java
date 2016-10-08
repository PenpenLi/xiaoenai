package com.baidu.location;

import android.os.Handler;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.http.message.BasicNameValuePair;

class o
  extends s
{
  public static final int db = 1;
  static o dd = null;
  private int da = 0;
  private a dc = null;
  boolean de = false;
  int df = 0;
  long dg = 0L;
  long dh = 0L;
  ArrayList di = null;
  private Handler dj = null;
  
  public o()
  {
    this.cT = new ArrayList();
    this.c0 = 2;
  }
  
  public static o ac()
  {
    if (dd == null) {
      dd = new o();
    }
    return dd;
  }
  
  private void ad()
  {
    if ((cY < 6) && (this.da < 10) && (aw.jdMethod_do().jdMethod_int()))
    {
      this.da += 1;
      if (!ab()) {
        this.da = 0;
      }
      return;
    }
    this.da = 0;
  }
  
  void T()
  {
    this.cT.add(new BasicNameValuePair("qt", "cltr"));
    try
    {
      this.cT.add(new BasicNameValuePair("info", Jni.i(az.cn().co())));
      int i = 0;
      while (i < this.di.size())
      {
        this.cT.add(new BasicNameValuePair("cltr[" + i + "]", (String)this.di.get(i)));
        i += 1;
      }
      String str = String.format(Locale.CHINA, "%d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      this.cT.add(new BasicNameValuePair("trtm", str));
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public boolean ab()
  {
    boolean bool = true;
    if (!ar.bU()) {
      bool = false;
    }
    do
    {
      return bool;
      if (this.dc.c7 > 2)
      {
        a locala = this.dc;
        locala.c7 -= 1;
        return jdMethod_for(true);
      }
    } while (this.dc.aa());
    return jdMethod_for(true);
  }
  
  public void jdMethod_do(int paramInt)
  {
    this.dj.sendEmptyMessageDelayed(paramInt, 500L);
  }
  
  void jdMethod_do(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.cS != null)) {
      if (this.di != null) {
        this.di.clear();
      }
    }
    for (;;)
    {
      if (this.cT != null) {
        this.cT.clear();
      }
      this.de = false;
      this.dj.sendEmptyMessageDelayed(1, 1500L);
      return;
      this.dg = 0L;
    }
  }
  
  public boolean jdMethod_for(boolean paramBoolean)
  {
    if (this.de) {
      return true;
    }
    if (System.currentTimeMillis() - this.dg < 7200000L) {
      return false;
    }
    if (System.currentTimeMillis() - this.dh > 3600000L) {
      this.df = 0;
    }
    if ((this.df > 5) && (paramBoolean)) {
      return false;
    }
    if (!ar.bU()) {
      return false;
    }
    if ((!aw.jdMethod_do().jdMethod_int()) && (paramBoolean)) {
      return false;
    }
    if ((this.di == null) || (this.di.size() < 1))
    {
      String str1 = c.jdMethod_byte();
      if (str1 != null)
      {
        int i = 0;
        while (i < 2)
        {
          String str2 = Jni.k(str1);
          if (str2 != null)
          {
            if (this.di == null) {
              this.di = new ArrayList();
            }
            this.di.add(str2);
            i += 1;
          }
          else
          {
            this.dg = System.currentTimeMillis();
          }
        }
      }
    }
    else
    {
      if ((this.di == null) || (this.di.size() <= 0)) {
        break label217;
      }
      this.df += 1;
      this.dh = System.currentTimeMillis();
      this.de = true;
      N();
      return true;
    }
    return false;
    label217:
    return false;
  }
  
  class a
    extends s
  {
    int c7 = 0;
    boolean c8 = false;
    String c9 = null;
    
    a() {}
    
    void T()
    {
      this.cW = this.c9;
      this.cR = (c.jdMethod_do() + "?&qt=state&trtm=" + System.currentTimeMillis());
      this.c0 = 2;
    }
    
    public boolean aa()
    {
      if (this.c8) {
        return true;
      }
      this.c9 = ad.cM().cG();
      if (this.c9 == null) {
        return false;
      }
      this.c8 = true;
      R();
      return true;
    }
    
    void jdMethod_do(boolean paramBoolean)
    {
      if (paramBoolean) {}
      try
      {
        new File(this.c9).delete();
        for (this.c7 = 0;; this.c7 += 2)
        {
          this.c9 = null;
          this.c8 = false;
          o.jdMethod_do(o.this).sendEmptyMessageDelayed(1, 1500L);
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\baidu\location\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */