package com.xiaoenai.app.classes.street;

import android.content.Context;
import android.content.res.Resources;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import com.xiaoenai.app.model.UserConfig;

public class ea
{
  public static Spannable a(Context paramContext, String paramString)
  {
    paramString = " " + paramContext.getString(2131100698) + "  " + paramString;
    Spannable localSpannable = Spannable.Factory.getInstance().newSpannable(paramString);
    localSpannable.setSpan(new BackgroundColorSpan(-830316), 0, 4, 17);
    localSpannable.setSpan(new ForegroundColorSpan(paramContext.getResources().getColor(2131493009)), 5, paramString.length(), 17);
    return localSpannable;
  }
  
  public static String a(int paramInt)
  {
    int i = paramInt / 100;
    if (paramInt % 100 > 0) {
      return String.valueOf(new Double(paramInt / 100.0D));
    }
    return String.valueOf(i);
  }
  
  public static String a(String paramString)
  {
    int i = 0;
    if (UserConfig.getBoolean("forum_night_theme", Boolean.valueOf(false)).booleanValue()) {
      i = 1;
    }
    if (paramString.contains("?")) {
      return paramString + "&is_night=" + i;
    }
    return paramString + "?is_night=" + i;
  }
  
  public static Spannable b(Context paramContext, String paramString)
  {
    paramString = " " + paramContext.getString(2131100698) + "  " + paramString;
    paramString = Spannable.Factory.getInstance().newSpannable(paramString);
    paramString.setSpan(new BackgroundColorSpan(-830316), 0, 4, 17);
    paramString.setSpan(new ForegroundColorSpan(paramContext.getResources().getColor(2131493206)), 0, 4, 17);
    return paramString;
  }
  
  public static Spannable c(Context paramContext, String paramString)
  {
    Spannable localSpannable = Spannable.Factory.getInstance().newSpannable(paramString);
    localSpannable.setSpan(new ForegroundColorSpan(paramContext.getResources().getColor(2131493009)), 0, paramString.length(), 17);
    return localSpannable;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\ea.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */