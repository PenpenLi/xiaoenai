package com.taobao.wireless.security.adapter.dynamicupdatelib;

import android.content.Context;
import com.taobao.wireless.security.adapter.common.SPUtility2;
import com.taobao.wireless.security.adapter.common.a;
import com.taobao.wireless.security.adapter.common.b;
import com.taobao.wireless.security.adapter.common.c;
import java.io.File;
import java.util.HashMap;

public class DynamicUpdateLibAdapter
{
  private static final String a = "SGDocuments" + File.separator + "update";
  private static Context b = null;
  
  public static String downloadNewFileAdapter(String paramString1, String paramString2)
  {
    return c.a(paramString1, paramString2);
  }
  
  public static String getDownloadFolderDirAdapter()
  {
    Object localObject1 = b;
    if (localObject1 == null) {}
    do
    {
      return null;
      try
      {
        localObject1 = new File(((Context)localObject1).getFilesDir().getAbsolutePath() + File.separator + a);
        if (!((File)localObject1).exists()) {
          ((File)localObject1).mkdirs();
        }
        boolean bool = ((File)localObject1).exists();
        if (!bool) {
          localObject1 = null;
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Object localObject2 = null;
        }
      }
    } while (localObject1 == null);
    return ((File)localObject1).getAbsolutePath();
  }
  
  public static String getMiniVersion()
  {
    return SPUtility2.readFromSPUnified("DynamicUpdateDataPreferences", "86ad108d66bb9408fda79f4ed3e746b0", null);
  }
  
  public static byte[] queryUpdateInfoAdapter(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    HashMap localHashMap = null;
    if (a.b(new String[] { paramString2 }))
    {
      localHashMap = new HashMap();
      localHashMap.put("keyindex", paramString2);
    }
    return c.a(paramString1, localHashMap, paramArrayOfByte).a();
  }
  
  public static void setApplicationContext(Context paramContext)
  {
    if (paramContext != null) {
      b = paramContext;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\wireless\security\adapter\dynamicupdatelib\DynamicUpdateLibAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */