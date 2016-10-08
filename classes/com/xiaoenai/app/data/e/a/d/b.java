package com.xiaoenai.app.data.e.a.d;

import android.content.Context;
import com.xiaoenai.app.data.d.j;
import com.xiaoenai.app.data.d.m;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class b
{
  protected final j a;
  protected final m b;
  private final Context c;
  private final com.xiaoenai.app.data.a.b d;
  
  @Inject
  public b(Context paramContext, com.xiaoenai.app.data.a.b paramb, j paramj, m paramm)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("Constructor parameters cannot be null!!!");
    }
    this.c = paramContext;
    this.d = paramb;
    this.a = paramj;
    this.b = paramm;
  }
  
  public a a()
  {
    return new a(this.d);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\data\e\a\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */