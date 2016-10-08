package com.f.a;

import android.content.Context;
import android.text.TextUtils;

public class l
{
  private static String[] a = new String[2];
  
  public static String[] a(Context paramContext)
  {
    if ((!TextUtils.isEmpty(a[0])) && (!TextUtils.isEmpty(a[1]))) {
      return a;
    }
    if (paramContext != null)
    {
      paramContext = o.a(paramContext).a();
      if (paramContext != null)
      {
        a[0] = paramContext[0];
        a[1] = paramContext[1];
        return a;
      }
    }
    return null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\f\a\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */