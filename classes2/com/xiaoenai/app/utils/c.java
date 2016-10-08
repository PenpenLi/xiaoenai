package com.xiaoenai.app.utils;

import java.io.File;
import java.util.Comparator;

final class c
  implements Comparator<File>
{
  public int a(File paramFile1, File paramFile2)
  {
    if (paramFile1.lastModified() > paramFile2.lastModified()) {
      return 1;
    }
    if (paramFile1.lastModified() < paramFile2.lastModified()) {
      return -1;
    }
    return 0;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\utils\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */