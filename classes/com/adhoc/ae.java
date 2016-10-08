package com.adhoc;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import com.adhoc.adhocsdk.AdhocTracker;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

public class ae
{
  public static ArrayList<Object> b = new ArrayList();
  private static ae d = new ae();
  public boolean a;
  private Context c;
  private ArrayList<String> e = null;
  private a f;
  private a g;
  
  public static ae a()
  {
    return d;
  }
  
  private boolean a(Object paramObject, ArrayList<Object> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      if (paramArrayList.next().hashCode() == paramObject.hashCode()) {
        return true;
      }
    }
    return false;
  }
  
  private boolean a(String paramString)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.e.size())
      {
        if (paramString.equals(this.e.get(i))) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private boolean b(Object paramObject)
  {
    Method localMethod1 = fn.b(paramObject.getClass(), "isVisible", "Fragment");
    Method localMethod2 = fn.b(paramObject.getClass(), "getUserVisibleHint", "Fragment");
    try
    {
      bool1 = ((Boolean)localMethod1.invoke(paramObject, new Object[0])).booleanValue();
      boolean bool3;
      return false;
    }
    catch (IllegalAccessException paramObject)
    {
      for (;;)
      {
        try
        {
          bool3 = ((Boolean)localMethod2.invoke(paramObject, new Object[0])).booleanValue();
          bool2 = bool1;
          bool1 = bool3;
          if ((!bool2) || (!bool1)) {
            continue;
          }
          return true;
        }
        catch (Throwable paramObject)
        {
          bool2 = bool1;
          continue;
        }
        catch (IllegalAccessException paramObject)
        {
          boolean bool1;
          boolean bool2 = bool1;
          continue;
        }
        paramObject = paramObject;
        bool2 = false;
        fl.a((Exception)paramObject);
        bool1 = false;
      }
    }
    catch (Throwable paramObject)
    {
      for (;;)
      {
        bool2 = false;
        fl.a((Throwable)paramObject);
        bool1 = false;
      }
    }
  }
  
  private void c()
  {
    ArrayList localArrayList = d();
    Iterator localIterator = b.iterator();
    while (localIterator.hasNext()) {
      if (a(localIterator.next(), localArrayList)) {
        localIterator.remove();
      }
    }
  }
  
  private void c(Context paramContext)
  {
    if (this.f != null)
    {
      fl.a("2 munu send request");
      double d1 = new BigDecimal((float)(System.currentTimeMillis() - a.c(this.f)) / 1000.0F).setScale(3, 4).doubleValue();
      AdhocTracker.incrementStat(paramContext, "Staytime-" + a.a(this.f), d1);
    }
  }
  
  private boolean c(Object paramObject)
  {
    Object localObject = d(paramObject);
    if (localObject != null)
    {
      boolean bool = b(localObject);
      fl.a("father : isvisiable" + bool + " " + paramObject.getClass().getName());
      if (!bool) {
        return false;
      }
      return c(localObject);
    }
    return true;
  }
  
  private Object d(Object paramObject)
  {
    try
    {
      paramObject = fn.a(fn.a(paramObject.getClass(), "mParentFragment", "Fragment"), paramObject);
      return paramObject;
    }
    catch (NoSuchFieldException paramObject)
    {
      fl.a((Exception)paramObject);
      return null;
    }
    catch (Throwable paramObject)
    {
      for (;;)
      {
        fl.a((Throwable)paramObject);
      }
    }
  }
  
  private ArrayList<Object> d()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < b.size())
    {
      Object localObject = d(b.get(i));
      if (localObject != null) {
        localArrayList.add(localObject);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void a(Context paramContext)
  {
    if (this.f != null) {
      fl.a("onBack2Menu : from " + a.a(this.f) + "is null");
    }
    this.g = null;
    c(paramContext);
    this.f = null;
    if (fm.a(paramContext, "com.example.scannertest")) {
      s.a(paramContext).a = true;
    }
  }
  
  public void a(Context paramContext, Object paramObject)
  {
    fl.a("fragment onCreate" + paramObject.getClass().getName());
    this.c = paramContext;
    if ((paramContext instanceof Activity))
    {
      String str = paramContext.getClass().getName();
      fl.a("className is " + str);
      if (!a(str))
      {
        this.e.add(str);
        ((Activity)paramContext).getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new b(null));
      }
    }
    b.add(paramObject);
  }
  
  public void a(Object paramObject)
  {
    b.remove(paramObject);
    if (b.size() == 0)
    {
      fl.a("退出程序clearlistener");
      this.e.clear();
    }
    fl.a("list-----------size : " + b.size());
  }
  
  public void b()
  {
    try
    {
      new Thread(new af(this)).start();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void b(Context paramContext)
  {
    if (this.f != null)
    {
      fl.a("send request to " + a.b(this.g) + " to .name " + a.a(this.g));
      if (a.b(this.f) != a.b(this.g))
      {
        if (a.c(this.g) - a.c(this.f) < 200L) {
          fl.a("小于 200 毫秒 忽略页面跳转");
        }
        fl.a("from " + a.a(this.f) + "id:" + a.b(this.f));
        double d1 = new BigDecimal((float)(a.c(this.g) - a.c(this.f)) / 1000.0F).setScale(3, 4).doubleValue();
        AdhocTracker.incrementStat(paramContext, "Staytime-" + a.a(this.f), d1);
        AdhocTracker.incrementStat(paramContext, "Event-" + a.a(this.f) + "-" + a.a(this.g), 1);
        this.f = this.g;
        fl.a("set from is " + a.a(this.g));
      }
    }
    for (;;)
    {
      fl.a("to " + a.a(this.g) + "id:" + a.b(this.g));
      return;
      fl.a("id 相同");
      continue;
      fl.a("from  null");
      AdhocTracker.incrementStat(paramContext, "Event-null-" + a.a(this.g), 1);
      this.f = this.g;
      fl.a("set from is " + a.a(this.g));
    }
  }
  
  final class a
  {
    private String b;
    private long c;
    private int d;
    
    a() {}
  }
  
  class b
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    long a = 0L;
    
    private b() {}
    
    public void onGlobalLayout()
    {
      fl.a("global view  complete-------------fragment ! ");
      if (System.currentTimeMillis() - this.a > 3000L)
      {
        this.a = System.currentTimeMillis();
        fl.a("to dump ----------------");
        ae.a().b();
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */