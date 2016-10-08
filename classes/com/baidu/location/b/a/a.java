package com.baidu.location.b.a;

import android.content.Context;
import android.text.TextUtils;

public class a
{
  private static final boolean a = false;
  private static final String jdField_if = a.class.getSimpleName();
  
  private static String a(Context paramContext)
  {
    return b.a(paramContext);
  }
  
  public static String jdMethod_if(Context paramContext)
  {
    String str2 = a(paramContext);
    String str1 = b.jdMethod_do(paramContext);
    paramContext = str1;
    if (TextUtils.isEmpty(str1)) {
      paramContext = "0";
    }
    paramContext = new StringBuffer(paramContext).reverse().toString();
    return str2 + "|" + paramContext;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\baidu\location\b\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */