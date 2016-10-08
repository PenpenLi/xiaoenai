package com.xiaoenai.app.data.d.d;

import com.xiaoenai.app.data.d.i;
import com.xiaoenai.app.data.entity.ImageResultEntity;
import com.xiaoenai.app.net.http.base.a.c;
import com.xiaoenai.app.net.http.base.a.c.a;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import rx.a.a;
import rx.k;

class e
  implements a.a<ImageResultEntity>
{
  e(a parama, String paramString1, String paramString2) {}
  
  public void a(k<? super ImageResultEntity> paramk)
  {
    Object localObject = new File(this.a);
    if (((File)localObject).exists())
    {
      paramk = new f(this, a.e(this.c), paramk);
      HashMap localHashMap = new HashMap();
      localHashMap.put("token", this.b);
      localObject = new com.xiaoenai.app.net.http.base.a.a("file", ((File)localObject).getName(), (File)localObject);
      a.f(this.c).a(i.a().b()).b().a(paramk).a((com.xiaoenai.app.net.http.base.a.a)localObject).a(localHashMap).c().a(a.g(this.c));
      com.xiaoenai.app.utils.f.a.c("file exists :file {}", new Object[] { this.a });
      return;
    }
    com.xiaoenai.app.utils.f.a.a(true, "file isnot exists :file {}", new Object[] { this.a });
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\data\d\d\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */