package com.xiaoenai.app.data.a.a;

import android.content.Context;
import com.google.gson.j;
import com.xiaoenai.app.data.a.a;
import com.xiaoenai.app.data.a.b;
import com.xiaoenai.app.data.entity.AppModelEntity;
import com.xiaoenai.app.data.entity.UserEntity;
import com.xiaoenai.app.utils.d.f;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONObject;

@Singleton
public class c
  implements b
{
  private final Context a;
  private final a b;
  private UserEntity c = null;
  
  @Inject
  public c(Context paramContext, a parama)
  {
    this.a = paramContext.getApplicationContext();
    this.b = parama;
  }
  
  private JSONObject a(int paramInt)
  {
    try
    {
      JSONObject localJSONObject = f.b(f.a(this.a, paramInt, "user.dat"));
      return localJSONObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public UserEntity a()
  {
    UserEntity localUserEntity = this.c;
    Object localObject = localUserEntity;
    if (localUserEntity == null)
    {
      localObject = a(this.b.a().getUserId());
      if (localObject != null)
      {
        localUserEntity = (UserEntity)new j().a(((JSONObject)localObject).toString(), UserEntity.class);
        this.c = localUserEntity;
      }
      localObject = localUserEntity;
      if (localUserEntity == null) {
        localObject = new UserEntity();
      }
    }
    return (UserEntity)localObject;
  }
  
  public void b()
  {
    if (this.c != null) {
      this.c = null;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\data\a\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */