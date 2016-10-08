package com.xiaoenai.app.data.e.a.b;

import com.xiaoenai.app.database.bean.LogEntity;
import java.util.List;

public class d
  implements e
{
  private final com.xiaoenai.app.data.b.a.a a;
  private int b = 0;
  
  public d(com.xiaoenai.app.data.b.a.a parama)
  {
    this.a = parama;
  }
  
  public long a()
  {
    return this.a.a();
  }
  
  public List<LogEntity> a(int paramInt)
  {
    return this.a.a(paramInt);
  }
  
  public rx.a<String> a(String paramString)
  {
    return null;
  }
  
  public void a(int paramInt, String paramString)
  {
    paramString = com.xiaoenai.app.utils.b.a.b(paramString);
    long l = this.a.a(paramInt, paramString);
    if ((10 < this.b) && (0L < l - 10000L))
    {
      this.a.a(l - 10000L);
      this.b = 0;
    }
    this.b += 1;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\data\e\a\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */