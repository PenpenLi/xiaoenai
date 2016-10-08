package com.xiaoenai.app.data.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.j;
import com.xiaoenai.app.data.entity.AppModelEntity;
import com.xiaoenai.app.utils.d.f;
import java.io.File;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONObject;

@Singleton
public class a
  implements com.xiaoenai.app.data.a.a
{
  private final Context a;
  private AppModelEntity b = null;
  
  @Inject
  public a(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
  }
  
  private AppModelEntity c()
  {
    Object localObject2 = null;
    Object localObject1;
    if ((this.b == null) || (TextUtils.isEmpty(this.b.getToken())))
    {
      Object localObject3 = f.a(this.a, "app.dat");
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (((File)localObject3).exists())
        {
          localObject3 = f.b((File)localObject3);
          j localj = new j();
          localObject1 = localObject2;
          if (localObject3 != null) {
            localObject1 = (AppModelEntity)localj.a(((JSONObject)localObject3).toString(), AppModelEntity.class);
          }
        }
      }
      this.b = ((AppModelEntity)localObject1);
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new AppModelEntity();
      }
      return (AppModelEntity)localObject2;
      localObject1 = this.b;
    }
  }
  
  public AppModelEntity a()
  {
    return c();
  }
  
  public void b()
  {
    this.b = null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\data\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */