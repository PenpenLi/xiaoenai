package com.alibaba.mtl.appmonitor;

import com.alibaba.mtl.appmonitor.a.e;
import com.alibaba.mtl.appmonitor.a.f;
import com.alibaba.mtl.appmonitor.b.b;
import com.alibaba.mtl.appmonitor.d.m;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.log.e.i;

public class TransactionDelegate
{
  private static void a(Transaction paramTransaction)
  {
    if (paramTransaction == null) {}
    while (paramTransaction.b == null) {
      return;
    }
    e.a().a(paramTransaction.r, paramTransaction.a, paramTransaction.o, paramTransaction.p, DimensionValueSet.create().addValues(paramTransaction.b));
  }
  
  public static void begin(Transaction paramTransaction, String paramString)
  {
    try
    {
      if (!AppMonitorDelegate.i) {
        return;
      }
      if (paramTransaction != null)
      {
        i.a("TransactionDelegate", new Object[] { "statEvent begin. module: ", paramTransaction.o, " monitorPoint: ", paramTransaction.p, " measureName: ", paramString });
        if ((f.d.isOpen()) && ((AppMonitorDelegate.IS_DEBUG) || (m.a(f.d, paramTransaction.o, paramTransaction.p))))
        {
          e.a().a(paramTransaction.r, paramTransaction.a, paramTransaction.o, paramTransaction.p, paramString);
          a(paramTransaction);
          return;
        }
      }
    }
    catch (Throwable paramTransaction)
    {
      b.a(paramTransaction);
    }
  }
  
  public static void end(Transaction paramTransaction, String paramString)
  {
    try
    {
      if (!AppMonitorDelegate.i) {
        return;
      }
      if (paramTransaction != null)
      {
        i.a("TransactionDelegate", new Object[] { "statEvent end. module: ", paramTransaction.o, " monitorPoint: ", paramTransaction.p, " measureName: ", paramString });
        if ((f.d.isOpen()) && ((AppMonitorDelegate.IS_DEBUG) || (m.a(f.d, paramTransaction.o, paramTransaction.p))))
        {
          a(paramTransaction);
          e.a().a(paramTransaction.r, paramString, false);
          return;
        }
      }
    }
    catch (Throwable paramTransaction)
    {
      b.a(paramTransaction);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\TransactionDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */