package com.alibaba.wireless.security.open;

import android.content.Context;
import android.content.ContextWrapper;
import com.taobao.wireless.security.adapter.dynamicupdatelib.DynamicUpdateLibAdapter;
import java.util.ArrayList;
import java.util.List;

public final class a
{
  private static a a;
  private List b;
  
  private a(Context paramContext)
  {
    b(paramContext);
  }
  
  public static a a(Context paramContext)
  {
    if (a == null) {
      a = new a(paramContext);
    }
    return a;
  }
  
  private void b(Context paramContext)
  {
    this.b = new ArrayList(16);
    int i = 0;
    while (i < 16)
    {
      this.b.add(null);
      i += 1;
    }
    DynamicUpdateLibAdapter.setApplicationContext(paramContext.getApplicationContext());
    this.b.set(1, new com.alibaba.wireless.security.open.securesignature.a((ContextWrapper)paramContext));
    this.b.set(2, new com.alibaba.wireless.security.open.dynamicdatastore.a((ContextWrapper)paramContext));
    this.b.set(3, new com.alibaba.wireless.security.open.staticdatastore.a());
    this.b.set(5, new com.alibaba.wireless.security.open.datacollection.a((ContextWrapper)paramContext));
    this.b.set(6, new com.alibaba.wireless.security.open.staticdataencrypt.a());
    this.b.set(7, new com.alibaba.wireless.security.open.dynamicdataencrypt.a((ContextWrapper)paramContext));
    this.b.set(9, new com.alibaba.wireless.security.open.statickeyencrypt.a());
    this.b.set(10, new com.alibaba.wireless.security.open.opensdk.a());
    this.b.set(11, new com.alibaba.wireless.security.open.umid.a((ContextWrapper)paramContext));
    this.b.set(12, new com.alibaba.wireless.security.open.pkgvaliditycheck.a((ContextWrapper)paramContext));
    this.b.set(13, null);
    this.b.set(14, null);
    this.b.set(8, null);
  }
  
  public final IComponent a(int paramInt)
  {
    return (IComponent)this.b.get(paramInt);
  }
  
  public final com.alibaba.wireless.security.open.umid.a a()
  {
    return (com.alibaba.wireless.security.open.umid.a)this.b.get(11);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\wireless\security\open\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */