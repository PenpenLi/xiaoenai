package com.alibaba.sdk.android.login.utils;

import android.content.Context;
import android.util.Log;
import com.alibaba.sdk.android.util.IOUtils;
import java.io.Closeable;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtils
{
  private static final String TAG = FileUtils.class.getSimpleName();
  
  public static boolean write2File(String paramString, Context paramContext, byte[] paramArrayOfByte)
  {
    Object localObject = null;
    String str = null;
    try
    {
      paramString = paramContext.openFileOutput(paramString, 0);
      str = paramString;
      localObject = paramString;
      paramString.write(paramArrayOfByte);
      IOUtils.closeQuietly(paramString);
      return true;
    }
    catch (IOException paramString)
    {
      localObject = str;
      Log.e(TAG, null, paramString);
      IOUtils.closeQuietly(str);
      return false;
    }
    finally
    {
      IOUtils.closeQuietly((Closeable)localObject);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\login\utils\FileUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */