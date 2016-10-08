package com.xiaoenai.app.utils;

import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.model.AppModel;
import com.xiaoenai.app.utils.d.f;
import com.xiaoenai.app.utils.f.a;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.apache.http.util.EncodingUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b
{
  private static Comparator<File> a = new c();
  
  public static File a(String paramString)
  {
    File localFile = f.a(Xiaoenai.j(), AppModel.getInstance().getUserId(), "faces");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return new File(f.a(Xiaoenai.j(), AppModel.getInstance().getUserId(), "faces"), paramString);
  }
  
  public static ArrayList<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = f.a(Xiaoenai.j(), AppModel.getInstance().getUserId(), "faces");
    if ((localObject1 != null) && (((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
    {
      localObject1 = ((File)localObject1).listFiles();
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        Arrays.sort((Object[])localObject1, a);
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          File localFile = new File(a(((File)localObject2).getName()), "config.json");
          if ((((File)localObject2).isDirectory()) && (((File)localObject2).list().length > 0) && (localFile.exists())) {
            localArrayList.add(((File)localObject2).getName());
          }
          i += 1;
        }
      }
    }
    return localArrayList;
  }
  
  public static JSONObject a(File paramFile)
  {
    if (!paramFile.exists()) {
      return null;
    }
    try
    {
      paramFile = new FileInputStream(paramFile);
      byte[] arrayOfByte = new byte[paramFile.available()];
      paramFile.read(arrayOfByte);
      paramFile.close();
      paramFile = new JSONObject(EncodingUtils.getString(arrayOfByte, "UTF-8"));
      return paramFile;
    }
    catch (FileNotFoundException paramFile)
    {
      paramFile.printStackTrace();
      return null;
    }
    catch (IOException paramFile)
    {
      paramFile.printStackTrace();
      return null;
    }
    catch (JSONException paramFile)
    {
      paramFile.printStackTrace();
    }
    return null;
  }
  
  public static void a(String paramString1, String paramString2, a parama)
  {
    if (paramString2 == null) {
      return;
    }
    paramString2 = a(paramString2);
    try
    {
      b(paramString1, paramString2.getAbsolutePath());
      return;
    }
    catch (Exception paramString1)
    {
      e.a(paramString2);
      paramString1.printStackTrace();
    }
  }
  
  private static void a(ZipInputStream paramZipInputStream, String paramString)
  {
    paramString = new BufferedOutputStream(new FileOutputStream(paramString));
    byte[] arrayOfByte = new byte['က'];
    for (;;)
    {
      int i = paramZipInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      paramString.write(arrayOfByte, 0, i);
    }
    paramString.close();
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    paramString2 = a(paramString2);
    try
    {
      b(paramString1, paramString2.getAbsolutePath());
      return true;
    }
    catch (Exception paramString1)
    {
      e.a(paramString2);
      paramString1.printStackTrace();
    }
    return false;
  }
  
  public static void b()
  {
    a.c("checkInstallFaces检查是否安装的了表情库", new Object[0]);
    new d().start();
  }
  
  public static void b(String paramString1, String paramString2)
  {
    Object localObject = new File(paramString2);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = new ZipInputStream(new FileInputStream(paramString1));
    paramString1 = ((ZipInputStream)localObject).getNextEntry();
    if (paramString1 != null)
    {
      String str = paramString2 + File.separator + paramString1.getName();
      if (!paramString1.isDirectory()) {
        a((ZipInputStream)localObject, str);
      }
      for (;;)
      {
        ((ZipInputStream)localObject).closeEntry();
        paramString1 = ((ZipInputStream)localObject).getNextEntry();
        break;
        new File(str).mkdir();
      }
    }
    ((ZipInputStream)localObject).close();
  }
  
  public static boolean b(String paramString)
  {
    paramString = a(paramString);
    return (paramString != null) && (paramString.exists()) && (paramString.isDirectory()) && (paramString.list().length > 0);
  }
  
  public static String c()
  {
    File localFile = f.a(Xiaoenai.j(), AppModel.getInstance().getUserId(), "faces");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile.getAbsolutePath();
  }
  
  public static JSONObject c(String paramString)
  {
    File localFile = a(paramString);
    paramString = localFile;
    if (localFile.listFiles().length == 1) {
      paramString = localFile.listFiles()[0];
    }
    return a(new File(paramString, "config.json"));
  }
  
  public static String d(String paramString)
  {
    File localFile = a(paramString);
    paramString = localFile;
    if (localFile != null)
    {
      paramString = localFile;
      if (localFile.listFiles().length == 1) {
        paramString = localFile.listFiles()[0];
      }
    }
    return paramString.getAbsolutePath();
  }
  
  public static ArrayList<String> e(String paramString)
  {
    Object localObject = c(paramString);
    paramString = new ArrayList();
    if (localObject != null) {
      try
      {
        localObject = ((JSONObject)localObject).getJSONArray("emotions");
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          paramString.add(((JSONArray)localObject).getJSONObject(i).getString("url"));
          i += 1;
        }
        return paramString;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public static abstract interface a {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\utils\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */