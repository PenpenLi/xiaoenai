package com.xiaoenai.app.feature.photoalbum.view.a;

import java.util.ArrayList;
import java.util.Set;

class d
  implements b.b
{
  d(b paramb) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    ((b.a)b.a(this.a).get(paramInt - 1)).d = paramBoolean;
    if (paramBoolean) {
      b.b(this.a).add(Integer.valueOf(paramInt - 1));
    }
    for (;;)
    {
      b.c(this.a);
      return;
      b.b(this.a).remove(Integer.valueOf(paramInt - 1));
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\feature\photoalbum\view\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */