package com.xiaoenai.app.classes.forum.presenter;

import com.xiaoenai.app.h.b.b.b;
import com.xiaoenai.app.h.b.d;
import com.xiaoenai.app.utils.f.a;
import java.util.List;

class ar
  extends b
{
  ar(ap paramap, int paramInt) {}
  
  public void a(String paramString)
  {
    super.a(paramString);
    ap.b(this.b, null);
    a.c("categoryId = {} add AdFeed fail {}", new Object[] { Integer.valueOf(this.a), paramString });
  }
  
  public void a(String paramString, List<d> paramList)
  {
    super.a(paramString, paramList);
    if (paramList != null)
    {
      ap.b(this.b, paramList);
      a.c("mFeedAdInfos size = {} mLoadEnd = {}", new Object[] { Integer.valueOf(ap.e(this.b).size()), Boolean.valueOf(ap.d(this.b)) });
      if (ap.d(this.b)) {
        ap.a(this.b, paramList);
      }
    }
    a.c("categoryId = {} add AdFeed success {}", new Object[] { Integer.valueOf(this.a), paramString });
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\forum\presenter\ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */