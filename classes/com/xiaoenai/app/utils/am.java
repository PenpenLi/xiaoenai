package com.xiaoenai.app.utils;

import com.xiaoenai.app.Xiaoenai;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class am
{
  public static a a(String paramString)
  {
    if (paramString.length() == 0) {
      return new a(Boolean.valueOf(false), a(2131100649));
    }
    if (paramString.length() < 6) {
      return new a(Boolean.valueOf(false), a(2131101042));
    }
    return new a(Boolean.valueOf(true), null);
  }
  
  public static a a(String paramString1, String paramString2)
  {
    if (paramString1.length() == 0) {
      return new a(Boolean.valueOf(false), a(2131100649));
    }
    if (paramString1.length() < 6) {
      return new a(Boolean.valueOf(false), a(2131101042));
    }
    if (paramString2.length() == 0) {
      return new a(Boolean.valueOf(false), a(2131101032));
    }
    if (!paramString1.intern().equals(paramString2.intern())) {
      return new a(Boolean.valueOf(false), a(2131101043));
    }
    return new a(Boolean.valueOf(true), null);
  }
  
  private static String a(int paramInt)
  {
    return Xiaoenai.j().getString(paramInt);
  }
  
  public static a b(String paramString)
  {
    paramString = paramString.replaceAll(" ", "");
    if (paramString.equals("")) {
      return new a(Boolean.valueOf(false), a(2131101031));
    }
    if (Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*").matcher(paramString).find()) {
      return new a(Boolean.valueOf(true), null);
    }
    return new a(Boolean.valueOf(false), a(2131101030));
  }
  
  public static a c(String paramString)
  {
    paramString = paramString.replaceAll(" ", "");
    if (paramString.equals("")) {
      return new a(Boolean.valueOf(false), a(2131100651));
    }
    if ((Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*").matcher(paramString).find()) || (e(paramString)) || (f(paramString))) {
      return new a(Boolean.valueOf(true), null);
    }
    return new a(Boolean.valueOf(false), a(2131100647));
  }
  
  public static boolean d(String paramString)
  {
    return (e(paramString)) && (paramString.length() == 11);
  }
  
  public static boolean e(String paramString)
  {
    int i = paramString.length();
    int j;
    do
    {
      j = i - 1;
      if (j < 0) {
        break;
      }
      i = j;
    } while (Character.isDigit(paramString.charAt(j)));
    return false;
    return true;
  }
  
  private static boolean f(String paramString)
  {
    boolean bool2 = true;
    int i = paramString.charAt(0);
    if (((i >= 97) && (i <= 122)) || ((i >= 65) && (i <= 90)))
    {
      i = 1;
      for (;;)
      {
        bool1 = bool2;
        if (i >= paramString.length()) {
          break label109;
        }
        int j = paramString.charAt(i);
        if (((j < 97) || (j > 122)) && ((j < 65) || (j > 90)) && ((j < 48) || (j > 57)) && (j != 95) && (j != 45)) {
          break;
        }
        i += 1;
      }
      boolean bool1 = false;
      label109:
      return bool1;
    }
    return false;
  }
  
  public static class a
  {
    public Boolean a;
    public String b;
    
    public a(Boolean paramBoolean, String paramString)
    {
      this.a = paramBoolean;
      this.b = paramString;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\utils\am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */