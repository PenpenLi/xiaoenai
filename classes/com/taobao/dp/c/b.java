package com.taobao.dp.c;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

final class b
  implements FileFilter
{
  public final boolean accept(File paramFile)
  {
    return Pattern.matches("cpu[0-9]+", paramFile.getName());
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\dp\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */