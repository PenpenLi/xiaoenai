package com.xiaoenai.app.classes.chat.messagelist.message.b;

import android.content.res.Resources;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.chat.messagelist.message.model.k;
import com.xiaoenai.app.classes.chat.messagelist.view.n;
import java.text.DecimalFormat;

public class o
{
  public static String a(int paramInt)
  {
    String str2 = "status_icon030";
    String str3 = new DecimalFormat("000").format(paramInt);
    String[] arrayOfString = Xiaoenai.j().getResources().getStringArray(2131427336);
    int i = arrayOfString.length;
    paramInt = 0;
    for (;;)
    {
      String str1 = str2;
      if (paramInt < i)
      {
        if (str3.equals(arrayOfString[paramInt])) {
          str1 = "status_icon" + str3;
        }
      }
      else {
        return str1;
      }
      paramInt += 1;
    }
  }
  
  public static String a(String paramString)
  {
    String str = "status_icon030";
    if (Integer.parseInt(paramString) != 0) {
      str = a(Integer.parseInt(paramString));
    }
    return str;
  }
  
  public static String b(int paramInt)
  {
    String str = "";
    Resources localResources = Xiaoenai.j().getResources();
    String[] arrayOfString1 = localResources.getStringArray(2131427336);
    String[] arrayOfString2 = localResources.getStringArray(2131427335);
    DecimalFormat localDecimalFormat = new DecimalFormat("000");
    int j = arrayOfString1.length;
    int i = 0;
    for (;;)
    {
      Object localObject = str;
      if (i < j)
      {
        if (!localDecimalFormat.format(paramInt).equals(arrayOfString1[i])) {
          break label117;
        }
        str = arrayOfString2[i];
        localObject = str;
        if (str.equals("menses_tip"))
        {
          localObject = localResources.getStringArray(2131427333);
          if (localObject.length == 0) {
            break label114;
          }
          localObject = localObject[((int)(Math.random() * localObject.length))];
        }
      }
      return (String)localObject;
      label114:
      return "";
      label117:
      i += 1;
    }
  }
  
  public static void c(k paramk, n paramn)
  {
    paramn.setStatus(paramk.f().intValue());
    String str = a(paramk.w());
    int j = Xiaoenai.j().getResources().getIdentifier(str, "drawable", "com.xiaoenai.app");
    int i = j;
    if (j == 0) {
      i = 2130838903;
    }
    paramn.setStatusIcon(i);
    paramn.setContentText(paramk.r());
    paramn.setContentTextColor(2131493178);
    if (paramk.g() == 1) {}
    for (i = 2130837643;; i = 2130837639)
    {
      paramn.setContentBackground(i);
      paramn.requestLayout();
      return;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\messagelist\message\b\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */