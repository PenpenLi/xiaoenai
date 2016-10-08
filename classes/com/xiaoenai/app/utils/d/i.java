package com.xiaoenai.app.utils.d;

import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public final class i
{
  public static final String a = Environment.getExternalStorageDirectory() + File.separator + ".com.xiaoenai";
  public static final String b = a + File.separator + ".image";
  
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
  
  public static long a(String paramString)
  {
    String str = paramString;
    if (paramString.contains("file://")) {
      str = paramString.substring("file://".length());
    }
    return new File(str).length();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\utils\d\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */