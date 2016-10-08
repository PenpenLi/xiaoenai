package com.nostra13.universalimageloader.a.a.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.nostra13.universalimageloader.b.b;
import com.nostra13.universalimageloader.b.b.a;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public abstract class a
  implements com.nostra13.universalimageloader.a.a.a
{
  public static final Bitmap.CompressFormat a = Bitmap.CompressFormat.PNG;
  protected final File b;
  protected final File c;
  protected final com.nostra13.universalimageloader.a.a.b.a d;
  protected int e = 32768;
  protected Bitmap.CompressFormat f = a;
  protected int g = 100;
  
  public a(File paramFile1, File paramFile2, com.nostra13.universalimageloader.a.a.b.a parama)
  {
    if (paramFile1 == null) {
      throw new IllegalArgumentException("cacheDir argument must be not null");
    }
    if (parama == null) {
      throw new IllegalArgumentException("fileNameGenerator argument must be not null");
    }
    this.b = paramFile1;
    this.c = paramFile2;
    this.d = parama;
  }
  
  public File a(String paramString)
  {
    return c(paramString);
  }
  
  public void a() {}
  
  public boolean a(String paramString, Bitmap paramBitmap)
  {
    File localFile = c(paramString);
    paramString = new File(localFile.getAbsolutePath() + ".tmp");
    BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(new FileOutputStream(paramString), this.e);
    try
    {
      boolean bool1 = paramBitmap.compress(this.f, this.g, localBufferedOutputStream);
      b.a(localBufferedOutputStream);
      boolean bool2 = bool1;
      if (bool1)
      {
        bool2 = bool1;
        if (!paramString.renameTo(localFile)) {
          bool2 = false;
        }
      }
      if (!bool2) {
        paramString.delete();
      }
      paramBitmap.recycle();
      return bool2;
    }
    finally
    {
      b.a(localBufferedOutputStream);
      paramString.delete();
    }
  }
  
  public boolean a(String paramString, InputStream paramInputStream, b.a parama)
  {
    File localFile1 = c(paramString);
    File localFile2 = new File(localFile1.getAbsolutePath() + ".tmp");
    boolean bool1;
    boolean bool2;
    try
    {
      paramString = new BufferedOutputStream(new FileOutputStream(localFile2), this.e);
      try
      {
        bool1 = b.a(paramInputStream, paramString, parama, this.e);
        paramString = finally;
      }
      finally
      {
        try
        {
          b.a(paramString);
          bool2 = bool1;
          if (bool1)
          {
            bool2 = bool1;
            if (!localFile2.renameTo(localFile1)) {
              bool2 = false;
            }
          }
          if (!bool2) {
            localFile2.delete();
          }
          return bool2;
        }
        finally {}
        paramInputStream = finally;
        b.a(paramString);
      }
      bool2 = bool1;
    }
    finally
    {
      bool1 = false;
    }
    if (bool1)
    {
      bool2 = bool1;
      if (!localFile2.renameTo(localFile1)) {
        bool2 = false;
      }
    }
    if (!bool2) {
      localFile2.delete();
    }
    throw paramString;
  }
  
  public void b()
  {
    File[] arrayOfFile = this.b.listFiles();
    if (arrayOfFile != null)
    {
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        arrayOfFile[i].delete();
        i += 1;
      }
    }
  }
  
  public boolean b(String paramString)
  {
    return c(paramString).delete();
  }
  
  protected File c(String paramString)
  {
    String str = this.d.a(paramString);
    File localFile = this.b;
    paramString = localFile;
    if (!this.b.exists())
    {
      paramString = localFile;
      if (!this.b.mkdirs())
      {
        paramString = localFile;
        if (this.c != null) {
          if (!this.c.exists())
          {
            paramString = localFile;
            if (!this.c.mkdirs()) {}
          }
          else
          {
            paramString = this.c;
          }
        }
      }
    }
    return new File(paramString, str);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\nostra13\universalimageloader\a\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */