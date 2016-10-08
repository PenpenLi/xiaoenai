package com.xiaoenai.app.utils;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Environment;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.utils.f.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class e
{
  public static final String a = Environment.getExternalStorageDirectory() + File.separator + ".com.xiaoenai";
  public static String b;
  public static final String c = a + File.separator + ".image";
  public static String d = a + File.separator + ".voice";
  public static String e = a + File.separator + ".tmp";
  
  static
  {
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT < 8) {
          continue;
        }
        b = Environment.getExternalStorageDirectory() + File.separator + Environment.DIRECTORY_DCIM + File.separator + "Xiaoenai" + File.separator;
        localFile1 = new File(a);
        if (!localFile1.exists()) {
          localFile1.mkdirs();
        }
        localFile1 = new File(b);
        if (!localFile1.exists()) {
          localFile1.mkdirs();
        }
      }
      catch (Exception localException)
      {
        File localFile1;
        localException.printStackTrace();
        continue;
        if (!"mounted".equals(Environment.getExternalStorageState())) {
          continue;
        }
        if (localException.mkdirs()) {
          continue;
        }
        File localFile2 = new File(Xiaoenai.j().getCacheDir(), ".voice");
        localFile2.mkdirs();
        d = localFile2.getAbsolutePath();
        return;
        localFile2 = new File(Xiaoenai.j().getCacheDir(), ".voice");
        localFile2.mkdirs();
        d = localFile2.getAbsolutePath();
      }
      localFile1 = new File(d);
      if (!localFile1.exists()) {
        continue;
      }
      if (!localFile1.isDirectory())
      {
        localFile1.delete();
        new File(d).mkdirs();
      }
      return;
      b = Environment.getExternalStorageDirectory() + File.separator + "DCIM/Xiaoenai" + File.separator;
    }
  }
  
  public static int a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new FileInputStream(paramString1);
      paramString2 = new FileOutputStream(paramString2);
      byte[] arrayOfByte = new byte['Ѐ'];
      for (;;)
      {
        int i = paramString1.read(arrayOfByte);
        if (i <= 0) {
          break;
        }
        paramString2.write(arrayOfByte, 0, i);
      }
      paramString1.close();
      paramString2.close();
      return 0;
    }
    catch (Exception paramString1) {}
    return -1;
  }
  
  public static String a(String paramString)
  {
    return c + File.separator + paramString;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    paramString3 = paramString2 + "/" + paramString3;
    paramString2 = new File(paramString2);
    if (!paramString2.exists()) {
      paramString2.mkdir();
    }
    try
    {
      if (new File(paramString3).exists()) {
        return paramString3;
      }
      paramString1 = Xiaoenai.j().getResources().getAssets().open(paramString1);
      paramString2 = new FileOutputStream(paramString3);
      byte[] arrayOfByte = new byte['ᰀ'];
      for (;;)
      {
        int i = paramString1.read(arrayOfByte);
        if (i <= 0) {
          break;
        }
        paramString2.write(arrayOfByte, 0, i);
      }
      paramString2.close();
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      return paramString3;
    }
    paramString1.close();
    return paramString3;
  }
  
  public static void a()
  {
    int j = 0;
    Object localObject = new File(c);
    int k;
    int i;
    if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
    {
      localObject = ((File)localObject).listFiles();
      k = localObject.length;
      i = 0;
      while (i < k)
      {
        localObject[i].delete();
        i += 1;
      }
    }
    localObject = new File(d);
    if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
    {
      localObject = ((File)localObject).listFiles();
      k = localObject.length;
      i = j;
      while (i < k)
      {
        localObject[i].delete();
        i += 1;
      }
    }
  }
  
  public static boolean a(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      String[] arrayOfString = paramFile.list();
      int i = 0;
      while (i < arrayOfString.length)
      {
        if (!a(new File(paramFile, arrayOfString[i]))) {
          return false;
        }
        i += 1;
      }
    }
    return paramFile.delete();
  }
  
  public static String b(String paramString)
  {
    try
    {
      if (Environment.getExternalStorageState().equals("mounted"))
      {
        File localFile = new File(c);
        if (!localFile.exists()) {
          localFile.mkdirs();
        }
        paramString = new File(a(paramString));
        if (paramString.exists()) {
          paramString.delete();
        }
        return paramString.getPath();
      }
      paramString = new File(Xiaoenai.j().getCacheDir(), paramString);
      if (paramString.exists()) {
        paramString.delete();
      }
      paramString = paramString.getPath();
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static void b()
  {
    Object localObject = new File(Xiaoenai.j().getFilesDir().getParent());
    if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
    {
      localObject = ((File)localObject).listFiles();
      int k = localObject.length;
      int i = 0;
      if (i < k)
      {
        File[] arrayOfFile = localObject[i];
        if (arrayOfFile.getName().equals("lib")) {}
        for (;;)
        {
          i += 1;
          break;
          if ((arrayOfFile.getName().equals("shared_prefs")) || (arrayOfFile.getName().equals("app_user-common")))
          {
            arrayOfFile = arrayOfFile.listFiles();
            int m = arrayOfFile.length;
            int j = 0;
            label107:
            File localFile;
            if (j < m)
            {
              localFile = arrayOfFile[j];
              if ((!localFile.getName().equals("xiaoenai.xml")) && (!localFile.getName().equals("app.dat"))) {
                break label152;
              }
            }
            for (;;)
            {
              j += 1;
              break label107;
              break;
              label152:
              if (localFile.delete()) {
                a.c("delete file success {}", new Object[] { localFile.getName() });
              } else {
                a.c("delete file fault {}", new Object[] { localFile.getName() });
              }
            }
          }
          if (a(arrayOfFile)) {
            a.c("delete file success {}", new Object[] { arrayOfFile.getName() });
          } else if (arrayOfFile.delete()) {
            a.c("delete file success {}", new Object[] { arrayOfFile.getName() });
          } else {
            a.c("delete file fault {}", new Object[] { arrayOfFile.getName() });
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\utils\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */