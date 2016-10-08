package com.xiaoenai.app.h.c;

import com.meiqia.core.d.m;
import com.xiaoenai.app.h.c.a.d;

class b
  implements m
{
  b(a parama, d paramd) {}
  
  public void a(int paramInt, String paramString)
  {
    com.xiaoenai.app.utils.f.a.c("Meiqia SDK init onFailure code:{} msg :{}", new Object[] { Integer.valueOf(paramInt), paramString });
    if (this.a != null) {
      this.a.a(paramInt, paramString);
    }
  }
  
  public void a(String paramString)
  {
    com.xiaoenai.app.utils.f.a.c("Meiqia SDK init onSuccess clientId:{}", new Object[] { paramString });
    if (this.a != null) {
      this.a.a(paramString);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\h\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */