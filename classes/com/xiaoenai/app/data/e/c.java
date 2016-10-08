package com.xiaoenai.app.data.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import java.io.File;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class c
{
  public final String a;
  public final String b;
  public final String c;
  private final Context d;
  
  @Inject
  public c(Context paramContext)
  {
    this.d = paramContext.getApplicationContext();
    this.a = (Environment.getExternalStorageDirectory() + File.separator + ".com.xiaoenai");
    this.b = (this.a + File.separator + ".image");
    this.c = (this.a + File.separator + ".voice");
  }
  
  private SharedPreferences a()
  {
    return this.d.getSharedPreferences("xiaoenai", 0);
  }
  
  public Integer a(String paramString, Integer paramInteger)
  {
    return Integer.valueOf(a().getInt(paramString, paramInteger.intValue()));
  }
  
  public String a(String paramString1, String paramString2)
  {
    return a().getString(paramString1, paramString2);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\data\e\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */