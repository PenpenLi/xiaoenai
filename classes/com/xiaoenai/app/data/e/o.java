package com.xiaoenai.app.data.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.xiaoenai.app.data.e.a.a.a;
import com.xiaoenai.app.data.e.a.a.b;
import com.xiaoenai.app.data.entity.AppModelEntity;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public final class o
{
  private final String a;
  private final Context b;
  private final b c;
  
  @Inject
  public o(Context paramContext, b paramb)
  {
    this.b = paramContext.getApplicationContext();
    this.a = "user_";
    this.c = paramb;
  }
  
  private SharedPreferences a()
  {
    return this.b.getSharedPreferences(this.a + this.c.a().a().getUserId(), 0);
  }
  
  public boolean a(String paramString, Integer paramInteger)
  {
    SharedPreferences.Editor localEditor = a().edit();
    localEditor.putInt(paramString, paramInteger.intValue());
    return localEditor.commit();
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    SharedPreferences.Editor localEditor = a().edit();
    localEditor.putString(paramString1, paramString2);
    return localEditor.commit();
  }
  
  public Integer b(String paramString, Integer paramInteger)
  {
    return Integer.valueOf(a().getInt(paramString, paramInteger.intValue()));
  }
  
  public String b(String paramString1, String paramString2)
  {
    return a().getString(paramString1, paramString2);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\data\e\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */