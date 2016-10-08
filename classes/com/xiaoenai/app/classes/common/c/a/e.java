package com.xiaoenai.app.classes.common.c.a;

import com.xiaoenai.app.classes.common.c.g;

public class e
{
  private g a;
  private String b;
  
  public e(g paramg)
  {
    this.a = paramg;
    if (this.a != null) {
      this.b = this.a.a();
    }
  }
  
  public e(String paramString)
  {
    this.b = paramString;
  }
  
  public d a()
  {
    Object localObject1 = null;
    if (this.b != null)
    {
      d locald = new d();
      Object localObject2 = this.b.split("\\.");
      if (localObject2.length > 0) {
        locald.a = localObject2[0];
      }
      if (localObject2.length > 1)
      {
        locald.b = localObject2[1];
        locald.c = localObject2[1];
      }
      localObject1 = locald;
      if (localObject2.length > 2)
      {
        localObject2 = localObject2[2];
        localObject1 = locald;
        if (localObject2 != null)
        {
          locald.c = ((String)localObject2);
          localObject1 = locald;
        }
      }
    }
    return (d)localObject1;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\c\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */