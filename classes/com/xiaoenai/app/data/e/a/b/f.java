package com.xiaoenai.app.data.e.a.b;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class f
{
  private final com.xiaoenai.app.data.b.a.a a;
  private d b;
  private a c;
  private final com.xiaoenai.app.data.d.c.a d;
  
  @Inject
  public f(com.xiaoenai.app.data.b.a.a parama, com.xiaoenai.app.data.d.c.a parama1)
  {
    this.a = parama;
    this.d = parama1;
  }
  
  public e a()
  {
    if (this.c == null) {
      this.c = new a(this.d);
    }
    return this.c;
  }
  
  public e b()
  {
    if (this.b == null) {
      this.b = new d(this.a);
    }
    return this.b;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\data\e\a\b\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */