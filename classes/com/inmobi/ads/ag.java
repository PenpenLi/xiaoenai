package com.inmobi.ads;

import android.content.Context;
import android.support.annotation.NonNull;
import java.lang.ref.WeakReference;

final class ag
  extends NativeStrandContainerLayout
{
  private WeakReference<q> a;
  
  ag(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  q a()
  {
    return (q)this.a.get();
  }
  
  void a(@NonNull q paramq)
  {
    this.a = new WeakReference(paramq);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */