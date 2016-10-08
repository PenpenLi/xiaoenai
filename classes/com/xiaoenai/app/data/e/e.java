package com.xiaoenai.app.data.e;

import com.xiaoenai.app.data.e.a.b.f;
import com.xiaoenai.app.data.entity.mapper.LoggerEntityDataMapper;
import com.xiaoenai.app.domain.e.c;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import rx.a;

@Singleton
public class e
  implements c
{
  private final f a;
  private final LoggerEntityDataMapper b;
  private com.xiaoenai.app.data.e.a.b.e c;
  
  @Inject
  public e(f paramf, LoggerEntityDataMapper paramLoggerEntityDataMapper)
  {
    this.a = paramf;
    this.b = paramLoggerEntityDataMapper;
  }
  
  public a<String> a(int paramInt)
  {
    if (this.c == null) {
      this.c = this.a.b();
    }
    int i = paramInt;
    if (paramInt > ((com.xiaoenai.app.data.e.a.b.d)this.c).a()) {
      i = (int)((com.xiaoenai.app.data.e.a.b.d)this.c).a();
    }
    Object localObject1 = new StringBuilder();
    if (i > 0)
    {
      localObject2 = this.c.a(i);
      localObject2 = this.b.transform((List)localObject2);
      paramInt = 0;
      while (paramInt < ((List)localObject2).size())
      {
        ((StringBuilder)localObject1).append(((com.xiaoenai.app.domain.d)((List)localObject2).get(paramInt)).a());
        paramInt += 1;
      }
    }
    ((StringBuilder)localObject1).append("{\"data\": \"no log\"}");
    localObject1 = ((StringBuilder)localObject1).toString();
    if ((i > 1000) && (((String)localObject1).length() >= 65536))
    {
      this.a.a().a(((String)localObject1).substring(0, 65535)).c();
      localObject2 = this.a.a();
      if (((String)localObject1).length() > 131070) {}
      for (paramInt = 131070;; paramInt = ((String)localObject1).length()) {
        return ((com.xiaoenai.app.data.e.a.b.e)localObject2).a(((String)localObject1).substring(65536, paramInt));
      }
    }
    Object localObject2 = this.a.a();
    if (((String)localObject1).length() >= 65536) {
      localObject1 = ((String)localObject1).substring(0, 65535);
    }
    for (;;)
    {
      return ((com.xiaoenai.app.data.e.a.b.e)localObject2).a((String)localObject1);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.c == null) {
      this.c = this.a.b();
    }
    this.c.a(paramInt, paramString);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\data\e\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */