package a.a.a.a;

import a.a.a.d.g;
import a.a.a.e;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

class b
  implements Handler.Callback, Runnable
{
  private static ExecutorService a = ;
  private final BlockingQueue<a> b = new LinkedBlockingQueue();
  private volatile boolean c;
  private volatile int d = 50;
  private volatile d e;
  private volatile d f;
  private volatile int g = 50;
  private int h;
  private int i;
  private Handler j;
  
  private void a(a parama)
  {
    parama.d();
    d locald = this.e;
    if (locald != null) {
      locald.a(parama);
    }
    if (this.f != null)
    {
      if (this.j == null) {
        this.j = new Handler(Looper.getMainLooper(), this);
      }
      parama = this.j.obtainMessage(1, parama);
      this.j.sendMessage(parama);
    }
    try
    {
      this.i += 1;
      if (this.i == this.h) {
        notifyAll();
      }
      return;
    }
    finally {}
  }
  
  private void a(a parama1, a parama2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(parama1);
    localArrayList.add(parama2);
    parama1 = parama1.b();
    parama1.beginTransaction();
    int k = 0;
    for (;;)
    {
      try
      {
        if (k < localArrayList.size())
        {
          a locala = (a)localArrayList.get(k);
          c(locala);
          bool = locala.c();
          if (bool) {
            bool = false;
          }
          return;
        }
      }
      finally
      {
        try
        {
          parama1.endTransaction();
          if (bool)
          {
            k = localArrayList.size();
            parama1 = localArrayList.iterator();
            if (!parama1.hasNext()) {
              break label327;
            }
            parama2 = (a)parama1.next();
            parama2.i = k;
            a(parama2);
            continue;
            if (k != localArrayList.size() - 1) {
              break label334;
            }
            parama2 = (a)this.b.peek();
            if ((k < this.d) && (locala.a(parama2)))
            {
              locala = (a)this.b.remove();
              if (locala != parama2)
              {
                throw new a.a.a.d("Internal error: peeked op did not match removed op");
                parama2 = finally;
              }
            }
          }
        }
        catch (RuntimeException parama1)
        {
          try
          {
            parama1.endTransaction();
            throw parama2;
            localArrayList.add(locala);
            break label334;
            parama1.setTransactionSuccessful();
            bool = true;
            continue;
            parama1 = parama1;
            e.a("Async transaction could not be ended, success so far was: " + bool, parama1);
            bool = false;
          }
          catch (RuntimeException parama1)
          {
            e.a("Async transaction could not be ended, success so far was: " + false, parama1);
            continue;
          }
          e.b("Reverted merged transaction because one of the operations failed. Executing operations one by one instead...");
          parama1 = localArrayList.iterator();
          if (parama1.hasNext())
          {
            parama2 = (a)parama1.next();
            parama2.e();
            b(parama2);
            continue;
          }
        }
      }
      label327:
      boolean bool = false;
      continue;
      label334:
      k += 1;
    }
  }
  
  private void b(a parama)
  {
    c(parama);
    a(parama);
  }
  
  private void c(a parama)
  {
    parama.e = System.currentTimeMillis();
    for (;;)
    {
      try
      {
        switch (c.a[parama.a.ordinal()])
        {
        case 1: 
          throw new a.a.a.d("Unsupported operation: " + parama.a);
        }
      }
      catch (Throwable localThrowable)
      {
        parama.g = localThrowable;
        parama.f = System.currentTimeMillis();
        return;
      }
      parama.b.delete(parama.c);
      continue;
      parama.b.deleteInTx((Iterable)parama.c);
      continue;
      parama.b.deleteInTx((Object[])parama.c);
      continue;
      parama.b.insert(parama.c);
      continue;
      parama.b.insertInTx((Iterable)parama.c);
      continue;
      parama.b.insertInTx((Object[])parama.c);
      continue;
      parama.b.insertOrReplace(parama.c);
      continue;
      parama.b.insertOrReplaceInTx((Iterable)parama.c);
      continue;
      parama.b.insertOrReplaceInTx((Object[])parama.c);
      continue;
      parama.b.update(parama.c);
      continue;
      parama.b.updateInTx((Iterable)parama.c);
      continue;
      parama.b.updateInTx((Object[])parama.c);
      continue;
      d(parama);
      continue;
      e(parama);
      continue;
      parama.h = ((g)parama.c).b().c();
      continue;
      parama.h = ((g)parama.c).b().d();
      continue;
      parama.b.deleteByKey(parama.c);
      continue;
      parama.b.deleteAll();
      continue;
      parama.h = parama.b.load(parama.c);
      continue;
      parama.h = parama.b.loadAll();
      continue;
      parama.h = Long.valueOf(parama.b.count());
      continue;
      parama.b.refresh(parama.c);
    }
  }
  
  private void d(a parama)
  {
    SQLiteDatabase localSQLiteDatabase = parama.b();
    localSQLiteDatabase.beginTransaction();
    try
    {
      ((Runnable)parama.c).run();
      localSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
  }
  
  private void e(a parama)
  {
    SQLiteDatabase localSQLiteDatabase = parama.b();
    localSQLiteDatabase.beginTransaction();
    try
    {
      parama.h = ((Callable)parama.c).call();
      localSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    d locald = this.f;
    if (locald != null) {
      locald.a((a)paramMessage.obj);
    }
    return false;
  }
  
  public void run()
  {
    label175:
    for (;;)
    {
      a locala3;
      try
      {
        locala1 = (a)this.b.poll(1L, TimeUnit.SECONDS);
        if (locala1 != null) {
          break label175;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        a locala1;
        localInterruptedException = localInterruptedException;
        e.b(Thread.currentThread().getName() + " was interruppted", localInterruptedException);
        return;
      }
      finally
      {
        this.c = false;
      }
      b(locala2);
      b(locala3);
      continue;
      b(locala2);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\a\a\a\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */