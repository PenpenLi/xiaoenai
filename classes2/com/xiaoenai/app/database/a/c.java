package com.xiaoenai.app.database.a;

import android.content.Context;
import android.support.annotation.NonNull;
import java.io.File;

public class c
{
  public final String a;
  public final String b;
  public final Context c;
  
  private c(a parama)
  {
    this.a = a.a(parama);
    this.b = a.b(parama);
    this.c = a.c(parama).getApplicationContext();
  }
  
  public static class a
  {
    private String a;
    private String b;
    private Context c;
    
    public a(@NonNull Context paramContext)
    {
      this.c = paramContext;
    }
    
    private void b()
    {
      if (this.b == null) {
        this.b = "default_database.db";
      }
      if (this.a == null) {
        this.a = this.c.getCacheDir().getAbsolutePath();
      }
    }
    
    public a a(String paramString)
    {
      File localFile = new File(paramString);
      if ((!localFile.exists()) || (localFile.isDirectory())) {
        localFile.mkdirs();
      }
      this.a = paramString;
      return this;
    }
    
    public c a()
    {
      b();
      return new c(this, null);
    }
    
    public a b(String paramString)
    {
      this.b = paramString;
      return this;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\database\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */