package com.meiqia.core;

import android.text.TextUtils;
import com.meiqia.core.b.j;
import com.meiqia.core.d.c;
import com.meiqia.core.d.q;

class cj
  implements c
{
  cj(ah paramah, String paramString1, String paramString2, String paramString3, q paramq) {}
  
  public void a()
  {
    if (TextUtils.isEmpty(this.a))
    {
      String str = ah.a(this.e).r();
      ah.a(this.e).l(this.b);
      ah.a(this.e).j(this.c);
      ah.a(this.e).l(str);
    }
    for (;;)
    {
      if (this.d != null) {
        ah.a(this.e, new ck(this));
      }
      return;
      ah.a(this.e).j(this.c);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.d != null) {
      this.d.a(paramInt, paramString);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\meiqia\core\cj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */