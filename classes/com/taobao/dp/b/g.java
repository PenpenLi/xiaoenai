package com.taobao.dp.b;

import android.os.Environment;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public final class g
{
  public static String a(String paramString)
  {
    try
    {
      paramString = b(paramString);
      StringBuilder localStringBuilder = new StringBuilder();
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(paramString))));
      String str = localBufferedReader.readLine();
      paramString = str;
      if (str == null) {
        paramString = "";
      }
      localStringBuilder.append(paramString);
      localBufferedReader.close();
      paramString = localStringBuilder.toString();
      return paramString;
    }
    catch (IOException paramString) {}
    return "";
  }
  
  public static void a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = b(paramString1);
      if ((paramString1 != null) && (paramString1.length() > 0))
      {
        paramString1 = new FileOutputStream(new File(paramString1), false);
        paramString1.write(paramString2.getBytes());
        paramString1.flush();
        paramString1.close();
      }
      return;
    }
    catch (IOException paramString1) {}
  }
  
  private static String b(String paramString)
  {
    if (Environment.getExternalStorageState().equals("mounted"))
    {
      localObject = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/.com.taobao.dp");
      if ((!((File)localObject).exists()) && (!((File)localObject).mkdir())) {}
    }
    for (Object localObject = ((File)localObject).getAbsolutePath(); localObject != null; localObject = null)
    {
      paramString = new File((String)localObject, paramString);
      if ((!paramString.exists()) && (!paramString.createNewFile())) {
        break;
      }
      return paramString.getAbsolutePath();
    }
    return "";
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\dp\b\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */