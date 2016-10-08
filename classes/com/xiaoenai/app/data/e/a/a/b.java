package com.xiaoenai.app.data.e.a.a;

import android.content.Context;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class b
{
  private final Context a;
  private final com.xiaoenai.app.data.a.a b;
  
  @Inject
  public b(Context paramContext, com.xiaoenai.app.data.a.a parama)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("Constructor parameters cannot be null!!!");
    }
    this.a = paramContext.getApplicationContext();
    this.b = parama;
  }
  
  public a a()
  {
    return new d(this.b);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\data\e\a\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */