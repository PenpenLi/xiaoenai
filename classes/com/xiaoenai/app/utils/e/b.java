package com.xiaoenai.app.utils.e;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.xiaoenai.app.utils.e.a.b.a;
import com.xiaoenai.app.utils.e.c.d.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class b
{
  public static String a(String paramString)
  {
    paramString = d.b().a(paramString);
    if ((paramString != null) && (paramString.exists())) {
      return paramString.getPath();
    }
    return null;
  }
  
  public static void a()
  {
    try
    {
      d.b().a();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  @Deprecated
  public static void a(ImageView paramImageView, String paramString)
  {
    a(paramImageView, paramString, null, null, null);
  }
  
  @Deprecated
  public static void a(ImageView paramImageView, String paramString, int paramInt)
  {
    a(paramImageView, paramString, new d.a().b(paramInt).c(paramInt).a(), null, null);
  }
  
  @Deprecated
  public static void a(ImageView paramImageView, String paramString, Drawable paramDrawable)
  {
    a(paramImageView, paramString, new d.a().a(paramDrawable).a(), null, null);
  }
  
  static void a(ImageView paramImageView, String paramString, com.xiaoenai.app.utils.e.c.d paramd, com.xiaoenai.app.utils.e.d.b paramb, com.xiaoenai.app.utils.e.d.d paramd1)
  {
    paramString = g(paramString);
    if ((paramImageView == null) || (TextUtils.isEmpty(paramString)))
    {
      com.xiaoenai.app.utils.f.a.a(true, "Either of image view or image uri is null imageView = {} url = {}", new Object[] { paramImageView, paramString });
      if (paramb != null) {
        paramb.a(paramString, paramImageView, new com.xiaoenai.app.utils.e.a.b(b.a.e, new Throwable()));
      }
      return;
    }
    d.b().a(paramImageView, paramString, paramd, null, paramb, paramd1);
  }
  
  @Deprecated
  public static void a(ImageView paramImageView, String paramString, com.xiaoenai.app.utils.e.d.b paramb)
  {
    a(paramImageView, paramString, null, paramb, null);
  }
  
  @Deprecated
  public static void a(ImageView paramImageView, String paramString, com.xiaoenai.app.utils.e.d.b paramb, com.xiaoenai.app.utils.e.d.d paramd)
  {
    a(paramImageView, paramString, null, paramb, paramd);
  }
  
  @Deprecated
  public static void a(ImageView paramImageView, String paramString, Boolean paramBoolean)
  {
    a(paramImageView, paramString, new d.a().a(paramBoolean.booleanValue()).a(), null, null);
  }
  
  @Deprecated
  public static void a(ImageView paramImageView, String paramString, Boolean paramBoolean, com.xiaoenai.app.utils.e.d.b paramb)
  {
    a(paramImageView, paramString, new d.a().a(paramBoolean.booleanValue()).a(), paramb, null);
  }
  
  @Deprecated
  public static void a(ImageView paramImageView, String paramString, Boolean paramBoolean, com.xiaoenai.app.utils.e.d.b paramb, com.xiaoenai.app.utils.e.a.c paramc)
  {
    a(paramImageView, paramString, new d.a().a(paramBoolean.booleanValue()).a(paramc).a(), paramb, null);
  }
  
  @Deprecated
  public static void a(ImageView paramImageView, String paramString, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    a(paramImageView, paramString, new d.a().c(true).b(paramBoolean).a(Bitmap.Config.RGB_565).a(paramInt1).c(paramInt2).b(paramInt2).a(), null, null);
  }
  
  @Deprecated
  public static void a(ImageView paramImageView, String paramString, boolean paramBoolean1, boolean paramBoolean2, Drawable paramDrawable)
  {
    a(paramImageView, paramString, new d.a().c(paramBoolean1).b(paramBoolean2).a(paramDrawable).a(), null, null);
  }
  
  public static void a(String paramString, Bitmap paramBitmap)
  {
    d.b().a(paramString, paramBitmap);
  }
  
  public static void a(String paramString, com.xiaoenai.app.utils.e.d.c paramc)
  {
    a(paramString, paramc, true, true);
  }
  
  public static void a(String paramString, com.xiaoenai.app.utils.e.d.c paramc, boolean paramBoolean1, boolean paramBoolean2)
  {
    com.xiaoenai.app.utils.e.c.d locald = new d.a().c(paramBoolean1).b(paramBoolean2).a(Bitmap.Config.RGB_565).a();
    d.b().a(paramString, locald, null, paramc, null);
  }
  
  static boolean a(String paramString1, String paramString2)
  {
    Object localObject = null;
    try
    {
      paramString2 = new FileInputStream(paramString2);
      boolean bool = false;
      if (paramString2 != null) {
        bool = d.b().a(paramString1, paramString2, new c());
      }
      return bool;
    }
    catch (FileNotFoundException paramString2)
    {
      for (;;)
      {
        paramString2.printStackTrace();
        paramString2 = (String)localObject;
      }
    }
  }
  
  public static File b(String paramString)
  {
    return d.b().a(paramString);
  }
  
  public static void b()
  {
    try
    {
      d.b().b();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  @Deprecated
  public static void b(ImageView paramImageView, String paramString, int paramInt)
  {
    a(paramImageView, paramString, new d.a().a(paramInt).a(), null, null);
  }
  
  public static void b(ImageView paramImageView, String paramString, com.xiaoenai.app.utils.e.c.d paramd, com.xiaoenai.app.utils.e.d.b paramb, com.xiaoenai.app.utils.e.d.d paramd1)
  {
    a(paramImageView, paramString, paramd, paramb, paramd1);
  }
  
  public static void b(String paramString1, String paramString2)
  {
    a(paramString1, paramString2);
  }
  
  public static void c(String paramString)
  {
    a(paramString, null, true, true);
  }
  
  public static void d(String paramString)
  {
    try
    {
      d.b().c(paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static void e(String paramString)
  {
    try
    {
      d.b().d(paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static Bitmap f(String paramString)
  {
    return d.b().b(paramString);
  }
  
  private static String g(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = str;
    if (!str.startsWith("http"))
    {
      paramString = str;
      if (!str.startsWith("file")) {
        paramString = "file://" + str;
      }
    }
    return paramString;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\utils\e\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */