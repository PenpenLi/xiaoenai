package com.xiaoenai.app.utils.d;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import android.widget.Toast;

public class a
{
  public static void a(Context paramContext, int paramInt)
  {
    Toast.makeText(paramContext, paramInt, 0).show();
  }
  
  public static boolean a()
  {
    boolean bool = false;
    String str = Environment.getExternalStorageState();
    if ("mounted".equals(str)) {
      bool = true;
    }
    while (!"mounted_ro".equals(str)) {
      return bool;
    }
    return false;
  }
  
  @SuppressLint({"ServiceCast"})
  public static boolean a(Context paramContext, String paramString)
  {
    if (Build.VERSION.SDK_INT > 10) {
      c(paramContext, paramString);
    }
    if (Build.VERSION.SDK_INT <= 10) {
      b(paramContext, paramString);
    }
    return true;
  }
  
  @TargetApi(10)
  private static void b(Context paramContext, String paramString)
  {
    ((android.text.ClipboardManager)paramContext.getSystemService("clipboard")).setText(paramString);
  }
  
  @TargetApi(11)
  private static void c(Context paramContext, String paramString)
  {
    ((android.content.ClipboardManager)paramContext.getSystemService("clipboard")).setText(paramString);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\utils\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */