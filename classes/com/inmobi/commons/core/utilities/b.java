package com.inmobi.commons.core.utilities;

import java.io.File;

public class b
{
  public static void a(File paramFile)
  {
    if (paramFile.exists())
    {
      File[] arrayOfFile = paramFile.listFiles();
      if (arrayOfFile != null)
      {
        int j = arrayOfFile.length;
        int i = 0;
        if (i < j)
        {
          File localFile = arrayOfFile[i];
          if (localFile.isDirectory()) {
            a(localFile);
          }
          for (;;)
          {
            i += 1;
            break;
            localFile.delete();
          }
        }
      }
      paramFile.delete();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\commons\core\utilities\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */