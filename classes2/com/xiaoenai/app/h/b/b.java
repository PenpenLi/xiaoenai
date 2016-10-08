package com.xiaoenai.app.h.b;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;

public final class b
  implements com.xiaoenai.app.h.b.b.a
{
  private List<d> a = new ArrayList();
  private int b = 0;
  private com.xiaoenai.app.h.b.b.b c;
  private Activity d;
  private int e;
  private int f;
  private int g = 0;
  
  public b(Activity paramActivity, int paramInt1, int paramInt2, com.xiaoenai.app.h.b.b.b paramb)
  {
    this.c = paramb;
    this.d = paramActivity;
    this.e = paramInt1;
    this.f = paramInt2;
  }
  
  public void a()
  {
    com.xiaoenai.app.utils.f.a.c("1 create count = {} offset = {}", new Object[] { Integer.valueOf(this.b), Integer.valueOf(this.g) });
    if (this.b > 0)
    {
      com.xiaoenai.app.utils.f.a.c("2 create count = {} offset = {}", new Object[] { Integer.valueOf(this.b), Integer.valueOf(this.g) });
      a.a(this.d, this.g, this.e, this.f, this);
      this.g += 1;
    }
    this.b -= 1;
    com.xiaoenai.app.utils.f.a.c("3 create count = {} offset = {}", new Object[] { Integer.valueOf(this.b), Integer.valueOf(this.g) });
  }
  
  public void a(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void a(String paramString)
  {
    com.xiaoenai.app.utils.f.a.c("onFail slotid = {} count = {}", new Object[] { paramString, Integer.valueOf(this.b) });
    a();
    if ((this.b < 0) && (this.c != null))
    {
      if (this.a.isEmpty()) {
        this.c.a(paramString);
      }
    }
    else {
      return;
    }
    this.c.a(paramString, this.a);
  }
  
  public void a(String paramString, List<d> paramList)
  {
    com.xiaoenai.app.utils.f.a.c("onSuccess slotid = {} list = {} count = {}", new Object[] { paramString, paramList, Integer.valueOf(this.b) });
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      com.xiaoenai.app.utils.f.a.c("onSuccess add slotid = {} list size = {} count = {}", new Object[] { paramString, Integer.valueOf(paramList.size()), Integer.valueOf(this.b) });
      this.a.add(paramList.get(0));
      com.xiaoenai.app.utils.f.a.c("onSuccess mList = {} count = {}", new Object[] { Integer.valueOf(this.a.size()), Integer.valueOf(this.b) });
    }
    a();
    if ((this.b < 0) && (this.c != null))
    {
      com.xiaoenai.app.utils.f.a.c("onSuccess mList = {} count = {}", new Object[] { Integer.valueOf(this.a.size()), Integer.valueOf(this.b) });
      this.c.a(paramString, this.a);
    }
  }
  
  public void b(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void b(String paramString)
  {
    com.xiaoenai.app.utils.f.a.c("onClicked slotid = {}", new Object[] { paramString });
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\h\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */