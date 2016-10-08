package com.xiaoenai.app.h.c;

import com.meiqia.core.d.k;
import com.xiaoenai.app.h.c.a.c;
import java.util.List;

class e
  implements k
{
  e(a parama, c paramc) {}
  
  public void a(int paramInt, String paramString)
  {
    com.xiaoenai.app.utils.f.a.c("getMessageFromDatabase onFailure i = {}  s = {}", new Object[] { Integer.valueOf(paramInt), paramString });
    if (this.a != null) {
      this.a.a(paramInt, paramString);
    }
  }
  
  public void a(List<com.meiqia.core.c.e> paramList)
  {
    if (this.a != null) {
      this.a.a(com.xiaoenai.app.h.c.b.a.a.a(paramList));
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\h\c\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */