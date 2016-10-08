package com.xiaoenai.app.utils.h;

import android.annotation.TargetApi;
import android.media.MediaRecorder;
import android.os.Build.VERSION;
import com.xiaoenai.app.classes.chat.messagelist.message.model.o;
import com.xiaoenai.app.utils.e;
import java.io.File;

public class k
{
  private MediaRecorder a = null;
  private String b = "";
  
  @TargetApi(10)
  private void f()
  {
    if (this.a == null)
    {
      this.a = new MediaRecorder();
      this.a.setAudioSource(1);
      if (Build.VERSION.SDK_INT < 10) {
        break label104;
      }
      this.a.setOutputFormat(3);
    }
    File localFile;
    for (;;)
    {
      this.a.setAudioEncoder(1);
      this.a.setMaxDuration(60000);
      localFile = new File(e.d);
      if (!localFile.exists()) {
        break;
      }
      if (!localFile.isDirectory())
      {
        localFile.delete();
        new File(e.d).mkdirs();
      }
      return;
      label104:
      this.a.setOutputFormat(1);
    }
    localFile.mkdirs();
  }
  
  public void a(int paramInt)
  {
    int i = paramInt;
    if (paramInt > 60) {
      i = 60;
    }
    o localo = new o();
    localo.b(1);
    localo.b(Integer.valueOf(-1));
    localo.c(Integer.valueOf(i));
    localo.c(this.b);
    localo.j();
  }
  
  public boolean a()
  {
    this.b = (e.d + File.separator + System.currentTimeMillis() + ".amr");
    try
    {
      f();
      this.a.setOutputFile(this.b);
      this.a.prepare();
      this.a.start();
      return true;
    }
    catch (Exception localException)
    {
      if (this.a != null)
      {
        this.a.reset();
        this.a.release();
      }
      this.a = null;
      localException.printStackTrace();
    }
    return false;
  }
  
  public void b()
  {
    if (this.a != null) {}
    try
    {
      this.a.stop();
      this.a.reset();
      this.a.release();
      this.a = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public MediaRecorder c()
  {
    return this.a;
  }
  
  public boolean d()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.b != null)
    {
      File localFile = new File(this.b);
      bool1 = bool2;
      if (localFile.exists())
      {
        bool1 = bool2;
        if (localFile.length() > 6L) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void e()
  {
    File localFile = new File(this.b);
    if (localFile.exists()) {
      localFile.delete();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\utils\h\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */