package com.mob.tools.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.mob.tools.a.i;
import com.mob.tools.e;
import com.mob.tools.log.d;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

public class g
{
  private static float a;
  private static Object b;
  
  private static int a(int paramInt1, int paramInt2)
  {
    int i;
    if ((paramInt2 < 2) || (paramInt2 > 36))
    {
      i = -1;
      return i;
    }
    if ((48 <= paramInt1) && (paramInt1 <= 57)) {
      paramInt1 -= 48;
    }
    for (;;)
    {
      i = paramInt1;
      if (paramInt1 < paramInt2) {
        break;
      }
      return -1;
      if ((97 <= paramInt1) && (paramInt1 <= 122)) {
        paramInt1 = paramInt1 - 97 + 10;
      } else if ((65 <= paramInt1) && (paramInt1 <= 90)) {
        paramInt1 = paramInt1 - 65 + 10;
      } else {
        paramInt1 = -1;
      }
    }
  }
  
  public static int a(Context paramContext, int paramInt)
  {
    if (a <= 0.0F) {
      a = paramContext.getResources().getDisplayMetrics().density;
    }
    return (int)(paramInt * a + 0.5F);
  }
  
  public static int a(Context paramContext, String paramString)
  {
    return a(paramContext, "drawable", paramString);
  }
  
  public static int a(Context paramContext, String paramString1, String paramString2)
  {
    int k;
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      k = 0;
      return k;
    }
    if (b != null) {}
    for (;;)
    {
      try
      {
        Object localObject = b.getClass().getMethod("getResId", new Class[] { Context.class, String.class, String.class });
        ((Method)localObject).setAccessible(true);
        j = ((Integer)((Method)localObject).invoke(b, new Object[] { paramContext, paramString1, paramString2 })).intValue();
        k = j;
        if (j > 0) {
          break;
        }
        localObject = paramContext.getPackageName();
        k = j;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        int i = j;
        if (j <= 0)
        {
          j = paramContext.getResources().getIdentifier(paramString2, paramString1, (String)localObject);
          i = j;
          if (j <= 0) {
            i = paramContext.getResources().getIdentifier(paramString2.toLowerCase(), paramString1, (String)localObject);
          }
        }
        k = i;
        if (i > 0) {
          break;
        }
        System.err.println("failed to parse " + paramString1 + " resource \"" + paramString2 + "\"");
        return i;
      }
      catch (Throwable localThrowable)
      {
        e.a().d(localThrowable);
      }
      int j = 0;
    }
  }
  
  public static int a(String paramString, int paramInt)
  {
    int i = 1;
    if ((paramInt < 2) || (paramInt > 36)) {
      throw new Throwable("Invalid radix: " + paramInt);
    }
    if (paramString == null) {
      throw f(paramString);
    }
    int j = paramString.length();
    if (j == 0) {
      throw f(paramString);
    }
    if (paramString.charAt(0) == '-') {}
    for (boolean bool = true; bool; bool = false)
    {
      if (1 != j) {
        break label99;
      }
      throw f(paramString);
    }
    i = 0;
    label99:
    return a(paramString, i, paramInt, bool);
  }
  
  private static int a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int k = Integer.MIN_VALUE / paramInt2;
    int j = 0;
    int m = paramString.length();
    int i = paramInt1;
    paramInt1 = j;
    while (i < m)
    {
      j = a(paramString.charAt(i), paramInt2);
      if (j == -1) {
        throw f(paramString);
      }
      if (k > paramInt1) {
        throw f(paramString);
      }
      j = paramInt1 * paramInt2 - j;
      if (j > paramInt1) {
        throw f(paramString);
      }
      paramInt1 = j;
      i += 1;
    }
    paramInt2 = paramInt1;
    if (!paramBoolean)
    {
      paramInt1 = -paramInt1;
      paramInt2 = paramInt1;
      if (paramInt1 < 0) {
        throw f(paramString);
      }
    }
    return paramInt2;
  }
  
  public static long a(String paramString)
  {
    try
    {
      paramString = new Date(paramString);
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTime(paramString);
      long l = localCalendar.getTimeInMillis();
      return l;
    }
    catch (Throwable paramString)
    {
      e.a().w(paramString);
    }
    return 0L;
  }
  
  public static String a(ArrayList<i<String>> paramArrayList)
  {
    if (paramArrayList == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramArrayList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      paramArrayList = (i)localIterator.next();
      if (i > 0) {
        localStringBuilder.append('&');
      }
      String str2 = paramArrayList.a;
      String str1 = (String)paramArrayList.b;
      if (str2 != null)
      {
        paramArrayList = str1;
        if (str1 == null) {
          paramArrayList = "";
        }
        localStringBuilder.append(b.d(str2) + "=" + b.d(paramArrayList));
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
  
  public static void a(File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists())) {
      return;
    }
    if (paramFile.isFile())
    {
      paramFile.delete();
      return;
    }
    String[] arrayOfString = paramFile.list();
    if ((arrayOfString == null) || (arrayOfString.length <= 0))
    {
      paramFile.delete();
      return;
    }
    int j = arrayOfString.length;
    int i = 0;
    if (i < j)
    {
      File localFile = new File(paramFile, arrayOfString[i]);
      if (localFile.isDirectory()) {
        a(localFile);
      }
      for (;;)
      {
        i += 1;
        break;
        localFile.delete();
      }
    }
    paramFile.delete();
  }
  
  public static void a(FileInputStream paramFileInputStream, FileOutputStream paramFileOutputStream)
  {
    byte[] arrayOfByte = new byte[65536];
    for (int i = paramFileInputStream.read(arrayOfByte); i > 0; i = paramFileInputStream.read(arrayOfByte)) {
      paramFileOutputStream.write(arrayOfByte, 0, i);
    }
    paramFileInputStream.close();
    paramFileOutputStream.close();
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    while (!new File(paramString1).exists()) {
      return false;
    }
    try
    {
      a(new FileInputStream(paramString1), new FileOutputStream(paramString2));
      return true;
    }
    catch (Throwable paramString1) {}
    return false;
  }
  
  public static int[] a(Context paramContext)
  {
    try
    {
      paramContext = (WindowManager)paramContext.getSystemService("window");
      if (paramContext == null) {
        return new int[] { 0, 0 };
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        e.a().w(paramContext);
        paramContext = null;
      }
      paramContext = paramContext.getDefaultDisplay();
      Object localObject;
      if (Build.VERSION.SDK_INT < 13)
      {
        localObject = new DisplayMetrics();
        paramContext.getMetrics((DisplayMetrics)localObject);
        return new int[] { ((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels };
      }
      try
      {
        localObject = new Point();
        Method localMethod = paramContext.getClass().getMethod("getRealSize", new Class[] { Point.class });
        localMethod.setAccessible(true);
        localMethod.invoke(paramContext, new Object[] { localObject });
        int i = ((Point)localObject).x;
        int j = ((Point)localObject).y;
        return new int[] { i, j };
      }
      catch (Throwable paramContext)
      {
        e.a().w(paramContext);
      }
    }
    return tmp175_171;
  }
  
  public static int b(Context paramContext, String paramString)
  {
    return a(paramContext, "string", paramString);
  }
  
  public static long b(String paramString, int paramInt)
  {
    int i = 1;
    if ((paramInt < 2) || (paramInt > 36)) {
      throw new Throwable("Invalid radix: " + paramInt);
    }
    if (paramString == null) {
      throw new Throwable("Invalid long: \"" + paramString + "\"");
    }
    int j = paramString.length();
    if (j == 0) {
      throw new Throwable("Invalid long: \"" + paramString + "\"");
    }
    if (paramString.charAt(0) == '-') {}
    for (boolean bool = true; bool; bool = false)
    {
      if (1 != j) {
        break label183;
      }
      throw new Throwable("Invalid long: \"" + paramString + "\"");
    }
    i = 0;
    label183:
    return b(paramString, i, paramInt, bool);
  }
  
  private static long b(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    long l3 = Long.MIN_VALUE / paramInt2;
    long l1 = 0L;
    long l4 = paramString.length();
    while (paramInt1 < l4)
    {
      int i = a(paramString.charAt(paramInt1), paramInt2);
      if (i == -1) {
        throw new Throwable("Invalid long: \"" + paramString + "\"");
      }
      if (l3 > l1) {
        throw new Throwable("Invalid long: \"" + paramString + "\"");
      }
      l2 = paramInt2 * l1 - i;
      if (l2 > l1) {
        throw new Throwable("Invalid long: \"" + paramString + "\"");
      }
      l1 = l2;
      paramInt1 += 1;
    }
    long l2 = l1;
    if (!paramBoolean)
    {
      l1 = -l1;
      l2 = l1;
      if (l1 < 0L) {
        throw new Throwable("Invalid long: \"" + paramString + "\"");
      }
    }
    return l2;
  }
  
  public static Bundle b(String paramString)
  {
    int i = paramString.indexOf("://");
    if (i >= 0) {}
    for (paramString = "http://" + paramString.substring(i + 1);; paramString = "http://" + paramString) {
      try
      {
        paramString = new URL(paramString);
        Bundle localBundle = c(paramString.getQuery());
        localBundle.putAll(c(paramString.getRef()));
        return localBundle;
      }
      catch (Throwable paramString)
      {
        e.a().w(paramString);
      }
    }
    return new Bundle();
  }
  
  public static String b(Context paramContext)
  {
    Object localObject = paramContext.getFilesDir().getAbsolutePath() + "/Mob/";
    c localc = c.a(paramContext);
    paramContext = (Context)localObject;
    if (localc.C()) {
      paramContext = localc.D() + "/Mob/";
    }
    localObject = new File(paramContext);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    return paramContext;
  }
  
  public static int c(Context paramContext, String paramString)
  {
    return a(paramContext, "layout", paramString);
  }
  
  public static Bundle c(String paramString)
  {
    Bundle localBundle = new Bundle();
    if (paramString != null)
    {
      paramString = paramString.split("&");
      int j = paramString.length;
      int i = 0;
      if (i < j)
      {
        String[] arrayOfString = paramString[i].split("=");
        if ((arrayOfString.length < 2) || (arrayOfString[1] == null)) {
          localBundle.putString(URLDecoder.decode(arrayOfString[0]), "");
        }
        for (;;)
        {
          i += 1;
          break;
          localBundle.putString(URLDecoder.decode(arrayOfString[0]), URLDecoder.decode(arrayOfString[1]));
        }
      }
    }
    return localBundle;
  }
  
  public static String c(Context paramContext)
  {
    return e(paramContext, "images");
  }
  
  public static int d(Context paramContext, String paramString)
  {
    return a(paramContext, "id", paramString);
  }
  
  public static int d(String paramString)
  {
    return a(paramString, 10);
  }
  
  public static void d(Context paramContext)
  {
    a(new File(e(paramContext, null)));
  }
  
  public static long e(String paramString)
  {
    return b(paramString, 10);
  }
  
  public static String e(Context paramContext, String paramString)
  {
    localObject = paramContext.getFilesDir().getAbsolutePath() + "/Mob/cache/";
    c localc = c.a(paramContext);
    paramContext = (Context)localObject;
    try
    {
      if (localc.C())
      {
        paramContext = (Context)localObject;
        if (localc.a("android.permission.READ_EXTERNAL_STORAGE")) {
          paramContext = localc.D() + "/Mob/" + localc.x() + "/cache/";
        }
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        e.a().d(paramContext);
        paramContext = (Context)localObject;
      }
    }
    localObject = paramContext;
    if (!TextUtils.isEmpty(paramString)) {
      localObject = paramContext + paramString + "/";
    }
    paramContext = new File((String)localObject);
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    return (String)localObject;
  }
  
  private static Throwable f(String paramString)
  {
    throw new Throwable("Invalid int: \"" + paramString + "\"");
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\mob\tools\b\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */