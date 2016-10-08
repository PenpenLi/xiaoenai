package com.xiaoenai.app.h.c;

import com.meiqia.core.c.e;
import java.util.List;

class d
  implements com.meiqia.core.d.d
{
  d(a parama, com.xiaoenai.app.h.c.a.a parama1) {}
  
  public void a(int paramInt, String paramString)
  {
    com.xiaoenai.app.utils.f.a.c("setClientOnlineWithClientId onFailure i = {}  s = {}", new Object[] { Integer.valueOf(paramInt), paramString });
    if (this.a != null) {
      this.a.a(paramInt, paramString);
    }
  }
  
  public void a(com.meiqia.core.c.a parama, String paramString, List<e> paramList)
  {
    com.xiaoenai.app.utils.f.a.c("setClientOnlineWithClientId onSuccess conversationId = {}  messageListSize = {}", new Object[] { paramString, Integer.valueOf(paramList.size()) });
    if (this.a != null) {
      this.a.a(com.xiaoenai.app.h.c.b.a.a.a(parama), paramString, com.xiaoenai.app.h.c.b.a.a.a(paramList));
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\h\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */