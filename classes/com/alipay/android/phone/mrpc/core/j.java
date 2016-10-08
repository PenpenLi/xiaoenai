package com.alipay.android.phone.mrpc.core;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

public final class j
  extends a
{
  private g g;
  
  public j(g paramg, Method paramMethod, int paramInt, String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    super(paramMethod, paramInt, paramString, paramArrayOfByte, "application/x-www-form-urlencoded", paramBoolean);
    this.g = paramg;
  }
  
  public final Object a()
  {
    Object localObject1 = new o(this.g.a());
    ((o)localObject1).a(this.b);
    ((o)localObject1).a(this.e);
    ((o)localObject1).a(this.f);
    ((o)localObject1).a("id", String.valueOf(this.d));
    ((o)localObject1).a("operationType", this.c);
    ((o)localObject1).a("gzip", String.valueOf(this.g.d()));
    ((o)localObject1).a(new BasicHeader("uuid", UUID.randomUUID().toString()));
    Object localObject2 = this.g.c().b();
    if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((o)localObject1).a((Header)((Iterator)localObject2).next());
      }
    }
    new StringBuilder("threadid = ").append(Thread.currentThread().getId()).append("; ").append(((o)localObject1).toString());
    try
    {
      localObject1 = (u)this.g.b().a((t)localObject1).get();
      if (localObject1 == null) {
        throw new RpcException(Integer.valueOf(9), "response is null");
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      throw new RpcException(Integer.valueOf(13), "", localInterruptedException);
      byte[] arrayOfByte = localInterruptedException.b();
      return arrayOfByte;
    }
    catch (ExecutionException localExecutionException)
    {
      localObject2 = localExecutionException.getCause();
      HttpException localHttpException;
      if ((localObject2 != null) && ((localObject2 instanceof HttpException)))
      {
        localHttpException = (HttpException)localObject2;
        int i = localHttpException.getCode();
        switch (i)
        {
        }
        for (;;)
        {
          throw new RpcException(Integer.valueOf(i), localHttpException.getMsg());
          i = 4;
          continue;
          i = 7;
          continue;
          i = 8;
          continue;
          i = 6;
          continue;
          i = 5;
          continue;
          i = 3;
          continue;
          i = 2;
          continue;
          i = 16;
          continue;
          i = 15;
        }
      }
      throw new RpcException(Integer.valueOf(9), "", localHttpException);
    }
    catch (CancellationException localCancellationException)
    {
      throw new RpcException(Integer.valueOf(13), "", localCancellationException);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\android\phone\mrpc\core\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */