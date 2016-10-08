package com.xiaoenai.app.data.e.b;

import com.xiaoenai.app.data.c.c;
import com.xiaoenai.app.data.entity.mapper.MessageEntityDataMapper;
import com.xiaoenai.app.h.c.a.e;
import com.xiaoenai.app.h.c.b.b;

class k
  implements e
{
  k(a parama, rx.k paramk) {}
  
  public void a(b paramb, int paramInt)
  {
    if (paramInt == 19998)
    {
      this.a.a(new c(a.a(this.b).transform(paramb), paramInt, "no agent online"));
      return;
    }
    this.a.a(a.a(this.b).transform(paramb));
    this.a.a();
  }
  
  public void a(b paramb, int paramInt, String paramString)
  {
    this.a.a(new c(a.a(this.b).transform(paramb), paramInt, paramString));
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\data\e\b\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */