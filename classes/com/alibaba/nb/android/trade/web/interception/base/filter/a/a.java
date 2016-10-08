package com.alibaba.nb.android.trade.web.interception.base.filter.a;

import android.os.Looper;
import android.text.TextUtils;
import com.alibaba.nb.android.trade.AliTradeContext;
import com.alibaba.nb.android.trade.web.interception.base.filter.AliTradeFilterInfo.ActionInfo;
import com.alibaba.nb.android.trade.web.interception.base.filter.b;
import com.alibaba.nb.android.trade.web.interception.base.filter.c;
import com.alibaba.nb.android.trade.web.register.AliTradeServiceRegistry;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Map;

public final class a
  implements b
{
  private AliTradeFilterInfo.ActionInfo a;
  private Method b;
  private WeakReference<?> c;
  private Map<String, String> d;
  private Class<?> e;
  private String f;
  private boolean g;
  private boolean h;
  private Field[] i;
  private String[] j;
  private Method[] k;
  private int l;
  private boolean m;
  
  public a(AliTradeFilterInfo.ActionInfo paramActionInfo)
  {
    this.a = paramActionInfo;
    this.m = a();
  }
  
  private Object a(Object paramObject)
  {
    int i1 = this.j.length;
    int n = 0;
    while (n < i1)
    {
      if (paramObject == null) {
        return null;
      }
      Field localField2 = this.i[n];
      Field localField1 = localField2;
      if (localField2 == null)
      {
        localField1 = com.alibaba.nb.android.trade.utils.f.a.a(paramObject.getClass(), this.j[n]);
        if (localField1 == null) {
          return null;
        }
        this.i[n] = localField1;
      }
      paramObject = localField1.get(paramObject);
      n += 1;
    }
    return paramObject;
  }
  
  private boolean a()
  {
    localObject2 = null;
    localObject1 = (String)this.a.parameters.get("serviceInterface");
    if (localObject1 == null) {
      return false;
    }
    this.e = com.alibaba.nb.android.trade.utils.f.a.a((String)localObject1);
    if (this.e == null) {
      return false;
    }
    localObject1 = (String)this.a.parameters.get("filterKey");
    Object localObject3 = (String)this.a.parameters.get("filterValue");
    if ((localObject1 != null) && (localObject3 != null)) {
      this.d = Collections.singletonMap(localObject1, localObject3);
    }
    this.f = ((String)this.a.parameters.get("attributeKey"));
    this.g = "true".equals(this.a.parameters.get("uiThread"));
    this.h = "true".equals(this.a.parameters.get("syncInvoke"));
    localObject1 = (String)this.a.parameters.get("retMode");
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      this.l = 3;
    }
    while (this.l != 3)
    {
      localObject1 = (String)this.a.parameters.get("retPattern");
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        return false;
        this.l = Integer.parseInt((String)localObject1);
      }
      else
      {
        this.j = ((String)localObject1).split("[\\.]");
        if (this.l != 2) {
          break label295;
        }
        this.i = new Field[this.j.length];
      }
    }
    for (;;)
    {
      localObject4 = (String)this.a.parameters.get("method");
      if (localObject4 != null) {
        break;
      }
      return false;
      label295:
      if (this.l == 1) {
        this.k = new Method[this.j.length];
      }
    }
    try
    {
      this.b = this.e.getMethod((String)localObject4, new Class[0]);
      if (this.b == null) {}
      try
      {
        if (this.c != null)
        {
          localObject3 = this.c.get();
          localObject1 = localObject3;
          if (localObject3 != null) {}
        }
        else
        {
          localObject1 = AliTradeContext.serviceRegistry.getService(this.e, this.d);
          this.c = new WeakReference(localObject1);
        }
        if (localObject1 != null) {
          this.b = com.alibaba.nb.android.trade.utils.f.a.a(localObject1.getClass(), (String)localObject4, new Class[0]);
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          StringBuilder localStringBuilder;
          localObject4 = new StringBuilder("fail to initialize the action method ");
          localObject1 = localObject2;
          if (this.a != null) {
            localObject1 = this.a.parameters;
          }
          com.alibaba.nb.android.trade.utils.d.a.c("ui", localObject1 + ", the error message is " + localException2.getMessage());
        }
      }
      return true;
    }
    catch (Exception localException1)
    {
      localStringBuilder = new StringBuilder("fail to initialize the action method ");
      if (this.a != null) {}
      for (localObject1 = this.a.parameters;; localObject1 = null)
      {
        com.alibaba.nb.android.trade.utils.d.a.c("ui", localObject1 + ", the error message is " + localException1.getMessage());
        break;
      }
    }
  }
  
  private Object b(Object paramObject)
  {
    int i1 = this.j.length;
    int n = 0;
    while (n < i1)
    {
      if (paramObject == null) {
        return null;
      }
      Method localMethod2 = this.k[n];
      Method localMethod1 = localMethod2;
      if (localMethod2 == null)
      {
        localMethod1 = com.alibaba.nb.android.trade.utils.f.a.a(paramObject.getClass(), this.j[n], new Class[0]);
        if (localMethod1 == null) {
          return null;
        }
        this.k[n] = localMethod1;
      }
      paramObject = localMethod1.invoke(paramObject, new Object[0]);
      n += 1;
    }
    return paramObject;
  }
  
  public final boolean a(c paramc)
  {
    Object localObject1;
    if (!this.m)
    {
      localObject1 = new StringBuilder("The filter action ");
      if (this.a != null) {}
      for (paramc = this.a.name;; paramc = null)
      {
        com.alibaba.nb.android.trade.utils.d.a.c("ui", paramc + " is ignored");
        return false;
      }
    }
    try
    {
      if (this.c != null)
      {
        localObject2 = this.c.get();
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = AliTradeContext.serviceRegistry.getService(this.e, this.d);
        this.c = new WeakReference(localObject1);
      }
    }
    catch (Exception paramc)
    {
      Object localObject2;
      com.alibaba.nb.android.trade.utils.d.a.a("ui", "Fail to invoke the service method, the error message is " + paramc.getMessage(), paramc);
      return false;
    }
    if (this.b == null)
    {
      this.b = com.alibaba.nb.android.trade.utils.f.a.a(localObject1.getClass(), (String)this.a.parameters.get("method"), new Class[0]);
      if (this.b == null) {
        return false;
      }
    }
    if (Looper.myLooper() == Looper.getMainLooper()) {}
    for (int n = 1;; n = 0)
    {
      if ((n != 0) && (!this.g))
      {
        paramc = this.b;
        return false;
      }
      localObject2 = this.b.invoke(localObject1, new Object[0]);
      if (localObject2 != null)
      {
        if (this.l == 2) {
          localObject1 = a(localObject2);
        }
        while (localObject1 != null)
        {
          paramc.setContextParameter(this.f, localObject1.toString());
          break;
          localObject1 = localObject2;
          if (this.l == 1) {
            localObject1 = b(localObject2);
          }
        }
      }
      return false;
      if (localObject1 != null) {
        break;
      }
      return false;
    }
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\web\interception\base\filter\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */