package com.alibaba.wireless.security.open.initialize;

import android.content.Context;
import android.content.ContextWrapper;
import com.alibaba.wireless.security.open.SecException;
import com.taobao.wireless.security.adapter.JNICLibrary;
import com.taobao.wireless.security.adapter.common.SPUtility2;
import com.taobao.wireless.security.adapter.common.d;

public final class b
  implements IInitializeComponent
{
  private static final Object a = new Object();
  private static final Object b = new Object();
  private static volatile boolean c = false;
  private static volatile boolean d = false;
  private static volatile boolean e = false;
  private a f = new a(this);
  
  public static String a()
  {
    return c.a().b();
  }
  
  static String a(ContextWrapper paramContextWrapper)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramContextWrapper != null)
    {
      StringBuilder localStringBuilder = new StringBuilder("/data/data/");
      localObject1 = localObject2;
      if (paramContextWrapper != null) {
        localObject1 = paramContextWrapper.getPackageName();
      }
      localObject1 = (String)localObject1;
    }
    return (String)localObject1;
  }
  
  static boolean a(Context paramContext)
  {
    return c(paramContext);
  }
  
  private static boolean a(String paramString)
  {
    try
    {
      System.loadLibrary(paramString);
      return true;
    }
    catch (Throwable paramString) {}
    return false;
  }
  
  private boolean b(Context paramContext)
  {
    if (!e)
    {
      boolean bool;
      synchronized (a)
      {
        if (e) {
          break label123;
        }
        e = true;
        SPUtility2.init(paramContext);
        com.taobao.wireless.security.adapter.common.c.a(paramContext);
        com.alibaba.wireless.security.open.a.a(paramContext);
        if (!isSoValid(paramContext)) {
          break label113;
        }
        bool = a("securitysdk-3.1.27");
        d = bool;
        if (!bool) {
          throw new SecException(103);
        }
      }
      if (d)
      {
        bool = this.f.a(new ContextWrapper(paramContext));
        d = bool;
        if (!bool)
        {
          throw new SecException(199);
          label113:
          throw new SecException(102);
        }
      }
    }
    label123:
    return d;
  }
  
  private static boolean c(Context paramContext)
  {
    if (!c) {}
    synchronized (b)
    {
      int i;
      if ((!c) && (d))
      {
        i = ((Integer)JNICLibrary.a().doCommandNative(501, null, null, null, new Object[] { paramContext })).intValue();
        if (i != 0) {
          break label81;
        }
      }
      label81:
      for (boolean bool = true;; bool = false)
      {
        c = bool;
        if (!bool) {
          break;
        }
        com.alibaba.wireless.security.open.a.a(paramContext).a().a();
        return c;
      }
      throw new SecException(i);
    }
  }
  
  public final int initialize(Context paramContext)
  {
    a locala = this.f;
    if (paramContext == null) {
      throw new SecException(101);
    }
    if ((d.a == null) && (paramContext != null)) {
      d.a = paramContext.getApplicationContext();
    }
    return locala.a.loadLibrarySync(paramContext);
  }
  
  public final void initializeAsync(Context paramContext)
  {
    try
    {
      loadLibraryAsync(paramContext);
      return;
    }
    catch (SecException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
    finally {}
  }
  
  public final boolean isSoValid(Context paramContext)
  {
    return true;
  }
  
  public final void loadLibraryAsync(Context paramContext)
  {
    if (paramContext == null) {
      try
      {
        throw new SecException(101);
      }
      finally {}
    }
    if (!b(paramContext)) {
      this.f.b();
    }
    for (;;)
    {
      return;
      new Thread(new a.a(this.f, new ContextWrapper(paramContext))).start();
    }
  }
  
  public final int loadLibrarySync(Context paramContext)
  {
    if (paramContext == null) {
      try
      {
        throw new SecException(101);
      }
      finally {}
    }
    if (b(paramContext))
    {
      boolean bool = c(paramContext);
      if (!bool) {}
    }
    for (int i = 0;; i = 1) {
      return i;
    }
  }
  
  public final void registerInitFinishListener(IInitializeComponent.IInitFinishListener paramIInitFinishListener)
  {
    this.f.a(paramIInitFinishListener);
  }
  
  public final void unregisterInitFinishListener(IInitializeComponent.IInitFinishListener paramIInitFinishListener)
  {
    this.f.b(paramIInitFinishListener);
  }
  
  static final class a
  {
    boolean a;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\wireless\security\open\initialize\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */