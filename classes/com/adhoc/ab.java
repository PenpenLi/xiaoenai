package com.adhoc;

import android.content.Context;
import com.adhoc.adhocsdk.AdhocTracker;
import java.math.BigDecimal;
import java.security.InvalidParameterException;
import java.util.ArrayList;

public class ab
{
  public static boolean a = false;
  private static ab b = null;
  private ArrayList<a> c = new ArrayList();
  private a d = null;
  private a e = null;
  
  public static ab a()
  {
    a = true;
    if (b == null) {
      b = new ab();
    }
    return b;
  }
  
  private void e(Context paramContext)
  {
    if (this.c != null) {
      this.d = ((a)this.c.get(this.c.size() - 1));
    }
    if (this.d != null)
    {
      double d1 = new BigDecimal((float)(System.currentTimeMillis() - a.b(this.d)) / 1000.0F).setScale(3, 4).doubleValue();
      AdhocTracker.incrementStat(paramContext, "Staytime-" + a.c(this.d), d1);
    }
  }
  
  public void a(Context paramContext)
  {
    if (paramContext == null) {
      throw new InvalidParameterException("error! need Activity context");
    }
    if (this.c.size() > 1) {
      this.d = ((a)this.c.get(this.c.size() - 2));
    }
    this.e = ((a)this.c.get(this.c.size() - 1));
    if (this.d != null) {
      if (a.a(this.d) != a.a(this.e))
      {
        if (a.b(this.e) - a.b(this.d) < 200L) {
          return;
        }
        fl.a("from " + a.c(this.d) + "id:" + a.a(this.d));
        double d1 = new BigDecimal((float)(a.b(this.e) - a.b(this.d)) / 1000.0F).setScale(3, 4).doubleValue();
        AdhocTracker.incrementStat(paramContext, "Staytime-" + a.c(this.d), d1);
        AdhocTracker.incrementStat(paramContext, "Event-" + a.c(this.d) + "-" + a.c(this.e), 1);
      }
    }
    for (;;)
    {
      fl.a("to " + a.c(this.e) + "id:" + a.a(this.e));
      return;
      fl.a("from  null");
      AdhocTracker.incrementStat(paramContext, "Event-null-" + a.c(this.e), 1);
    }
  }
  
  public void b(Context paramContext)
  {
    try
    {
      a locala = new a();
      a.a(locala, paramContext.getClass().getSimpleName());
      a.a(locala, System.currentTimeMillis());
      a.a(locala, paramContext.hashCode());
      if (this.c == null) {
        this.c = new ArrayList();
      }
      this.c.add(locala);
      a(paramContext);
      return;
    }
    catch (Throwable paramContext)
    {
      fl.a(paramContext);
    }
  }
  
  public void c(Context paramContext) {}
  
  public void d(Context paramContext)
  {
    e(paramContext);
    this.c.clear();
    this.c = null;
    this.d = null;
    this.e = null;
    a = false;
  }
  
  final class a
  {
    private String b;
    private long c;
    private int d;
    
    a() {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */