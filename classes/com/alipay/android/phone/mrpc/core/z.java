package com.alipay.android.phone.mrpc.core;

import android.os.Looper;
import com.alipay.android.phone.mrpc.core.a.c;
import com.alipay.android.phone.mrpc.core.a.d;
import com.alipay.android.phone.mrpc.core.a.e;
import com.alipay.android.phone.mrpc.core.a.f;
import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.ResetCookie;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class z
{
  private static final ThreadLocal<Object> a = new ThreadLocal();
  private static final ThreadLocal<Map<String, Object>> b = new ThreadLocal();
  private byte c = 0;
  private AtomicInteger d;
  private x e;
  
  public z(x paramx)
  {
    this.e = paramx;
    this.d = new AtomicInteger();
  }
  
  public final Object a(Method paramMethod, Object[] paramArrayOfObject)
  {
    boolean bool = true;
    if ((Looper.myLooper() != null) && (Looper.myLooper() == Looper.getMainLooper())) {}
    for (int i = 1; i != 0; i = 0) {
      throw new IllegalThreadStateException("can't in main thread call rpc .");
    }
    Object localObject = (OperationType)paramMethod.getAnnotation(OperationType.class);
    if (paramMethod.getAnnotation(ResetCookie.class) != null) {}
    Type localType;
    for (;;)
    {
      localType = paramMethod.getGenericReturnType();
      paramMethod.getAnnotations();
      a.set(null);
      b.set(null);
      if (localObject != null) {
        break;
      }
      throw new IllegalStateException("OperationType must be set.");
      bool = false;
    }
    localObject = ((OperationType)localObject).value();
    i = this.d.incrementAndGet();
    try
    {
      if (this.c == 0)
      {
        paramArrayOfObject = new e(i, (String)localObject, paramArrayOfObject);
        if (b.get() != null) {
          paramArrayOfObject.a(b.get());
        }
        paramArrayOfObject = paramArrayOfObject.a();
        paramMethod = (byte[])new j(this.e.a(), paramMethod, i, (String)localObject, paramArrayOfObject, bool).a();
        b.set(null);
        paramMethod = new d(localType, paramMethod).a();
        if (localType != Void.TYPE) {
          a.set(paramMethod);
        }
      }
      return a.get();
    }
    catch (RpcException paramMethod)
    {
      paramMethod.setOperationType((String)localObject);
      throw paramMethod;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\android\phone\mrpc\core\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */