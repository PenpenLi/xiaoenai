package com.taobao.wireless.security.adapter.common;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public final class e
{
  private FileChannel a = null;
  private FileLock b = null;
  private RandomAccessFile c = null;
  private File d = null;
  private boolean e = true;
  
  public e(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getFilesDir().getAbsolutePath();
      this.d = new File(paramContext + "/" + paramString);
      if (!this.d.exists()) {
        this.d.createNewFile();
      }
      return;
    }
    catch (Exception paramContext)
    {
      this.e = false;
    }
  }
  
  public final boolean a()
  {
    if (!this.e) {
      return true;
    }
    try
    {
      if (this.d != null)
      {
        this.c = new RandomAccessFile(this.d, "rw");
        this.a = this.c.getChannel();
        this.b = this.a.lock();
        return true;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  public final boolean b()
  {
    bool2 = true;
    bool1 = true;
    if (!this.e) {}
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      try
      {
        if (this.b != null)
        {
          this.b.release();
          this.b = null;
          bool1 = bool2;
        }
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          bool1 = false;
        }
      }
      bool2 = bool1;
      try
      {
        if (this.a != null)
        {
          this.a.close();
          this.a = null;
          bool2 = bool1;
        }
      }
      catch (IOException localIOException3)
      {
        for (;;)
        {
          bool2 = false;
        }
      }
      bool1 = bool2;
      try
      {
        if (this.c == null) {
          continue;
        }
        this.c.close();
        this.c = null;
        return bool2;
      }
      catch (IOException localIOException1)
      {
        return false;
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\wireless\security\adapter\common\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */