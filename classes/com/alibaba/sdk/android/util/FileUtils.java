package com.alibaba.sdk.android.util;

import java.io.File;

public class FileUtils
{
  public static void delete(File paramFile)
  {
    if (!paramFile.exists()) {
      return;
    }
    if (paramFile.isFile())
    {
      paramFile.delete();
      return;
    }
    deleteDirectory(paramFile);
  }
  
  private static void deleteDirectory(File paramFile)
  {
    paramFile = paramFile.listFiles();
    int j = paramFile.length;
    int i = 0;
    if (i < j)
    {
      File localFile = paramFile[i];
      if (localFile.isDirectory()) {
        deleteDirectory(localFile);
      }
      for (;;)
      {
        i += 1;
        break;
        if (localFile.isFile()) {
          localFile.delete();
        }
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\util\FileUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */