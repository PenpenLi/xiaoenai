package com.xiaoenai.app.net.c.a;

import android.content.res.Resources;
import com.xiaoenai.app.Xiaoenai;

public class j
{
  public static String a(int paramInt)
  {
    Resources localResources = Xiaoenai.j().getResources();
    if (paramInt == 0) {
      return localResources.getString(2131100335);
    }
    paramInt = localResources.getIdentifier("error_code_" + paramInt, "string", "com.xiaoenai.app");
    if (paramInt > 0) {
      return localResources.getString(paramInt);
    }
    return localResources.getString(2131100335);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\net\c\a\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */