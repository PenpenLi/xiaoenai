package com.nostra13.universalimageloader.b;

import java.util.Comparator;

final class e
  implements Comparator<String>
{
  public int a(String paramString1, String paramString2)
  {
    return paramString1.substring(0, paramString1.lastIndexOf("_")).compareTo(paramString2.substring(0, paramString2.lastIndexOf("_")));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\nostra13\universalimageloader\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */