package com.b.a.a;

import android.os.Looper;
import java.lang.ref.WeakReference;

public class p
{
  private final WeakReference<e> a;
  
  public p(e parame)
  {
    this.a = new WeakReference(parame);
  }
  
  public boolean a()
  {
    e locale = (e)this.a.get();
    return (locale == null) || (locale.b());
  }
  
  public boolean a(boolean paramBoolean)
  {
    e locale = (e)this.a.get();
    if (locale != null)
    {
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        new Thread(new q(this, locale, paramBoolean)).start();
        return true;
      }
      return locale.a(paramBoolean);
    }
    return false;
  }
  
  public boolean b()
  {
    e locale = (e)this.a.get();
    return (locale == null) || (locale.a());
  }
  
  public boolean c()
  {
    if ((b()) || (a())) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        this.a.clear();
      }
      return bool;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\b\a\a\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */