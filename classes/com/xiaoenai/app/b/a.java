package com.xiaoenai.app.b;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.Parcelable;
import com.xiaoenai.app.utils.d.i;
import java.io.File;

public class a
{
  private static final String a = i.a + File.separator + ".image";
  private final Activity b;
  private String c;
  private a d;
  
  public a(Activity paramActivity)
  {
    this.b = paramActivity;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    File localFile;
    do
    {
      return;
      localFile = new File(a + File.separator + this.c);
      com.xiaoenai.app.utils.f.a.c("getAbsolutePath:" + localFile.getAbsolutePath(), new Object[0]);
    } while (this.d == null);
    this.d.a(localFile);
  }
  
  public void a(a parama)
  {
    this.d = parama;
    this.c = (System.currentTimeMillis() + ".jpg");
    if (Environment.getExternalStorageState().equals("mounted"))
    {
      Object localObject = new File(a);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      parama = new Intent("android.media.action.IMAGE_CAPTURE");
      localObject = Uri.fromFile(new File((File)localObject, this.c));
      parama.putExtra("orientation", 0);
      parama.putExtra("output", (Parcelable)localObject);
      this.b.startActivityForResult(parama, 32);
      return;
    }
    com.xiaoenai.app.utils.f.a.a("take photo error!", new Object[0]);
  }
  
  public static abstract interface a
  {
    public abstract void a(File paramFile);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */