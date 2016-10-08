package com.xiaoenai.app.data.b;

import android.content.Context;
import android.os.Environment;
import com.xiaoenai.app.database.a.c.a;
import java.io.File;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public final class a
{
  private com.xiaoenai.app.database.a a;
  private com.xiaoenai.app.database.a b;
  private int c;
  private Context d;
  private final com.xiaoenai.app.domain.e.a e;
  
  @Inject
  public a(Context paramContext, com.xiaoenai.app.domain.e.a parama)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("Constructor parameters cannot be null!!!");
    }
    this.e = parama;
    this.c = this.e.a().c();
    this.d = paramContext;
  }
  
  private File a(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getApplicationContext().getDir("user-" + paramInt, 0);
    if ((!paramContext.exists()) || (!paramContext.isDirectory())) {
      paramContext.mkdir();
    }
    return paramContext;
  }
  
  private File b(Context paramContext)
  {
    paramContext = paramContext.getApplicationContext().getDir("user-common", 0);
    if ((!paramContext.exists()) || (!paramContext.isDirectory())) {
      paramContext.mkdir();
    }
    return paramContext;
  }
  
  public d a()
  {
    if ((this.c == this.e.a().c()) && (this.a != null)) {
      return new d(this.a);
    }
    this.c = this.e.a().c();
    this.a = new com.xiaoenai.app.database.a(new c.a(this.d).a(a(this.d, this.c).getAbsolutePath()).b("-database.db").a());
    return new d(this.a);
  }
  
  public File a(Context paramContext)
  {
    boolean bool = true;
    Object localObject = Environment.getExternalStorageDirectory() + File.separator + ".com.xiaoenai";
    File localFile1 = new File((String)localObject);
    if ((!localFile1.exists()) || (!localFile1.isDirectory())) {
      bool = localFile1.mkdirs();
    }
    File localFile2 = new File((String)localObject, ".enai_log.db");
    localObject = new File((String)localObject, ".enai_log.db-journal");
    if (localFile2.exists()) {
      localFile2.delete();
    }
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
    if (!bool) {
      return b(paramContext);
    }
    return localFile1;
  }
  
  public d b()
  {
    if (this.b != null) {
      return new d(this.b);
    }
    this.b = new com.xiaoenai.app.database.a(new c.a(this.d).a(a(this.d).getAbsolutePath()).b(".log.db").a());
    return new d(this.b);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\data\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */