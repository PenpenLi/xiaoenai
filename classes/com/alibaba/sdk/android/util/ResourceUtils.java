package com.alibaba.sdk.android.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import com.alibaba.sdk.android.impl.KernelContext;
import java.lang.reflect.Field;

public class ResourceUtils
{
  public static final String TAG = "ResourceUtils";
  
  public static int getIdentifier(Context paramContext, String paramString1, String paramString2)
  {
    return paramContext.getResources().getIdentifier(paramString2, paramString1, paramContext.getPackageName());
  }
  
  public static int getIdentifier(String paramString1, String paramString2)
  {
    return getIdentifier(KernelContext.context, paramString1, paramString2);
  }
  
  public static int getRDrawable(Context paramContext, String paramString)
  {
    return getIdentifier(paramContext, "drawable", paramString);
  }
  
  public static int getRDrawable(String paramString)
  {
    return getIdentifier(KernelContext.context, "drawable", paramString);
  }
  
  public static int getRId(Context paramContext, String paramString)
  {
    return getIdentifier(paramContext, "id", paramString);
  }
  
  public static int getRId(String paramString)
  {
    return getIdentifier(KernelContext.context, "id", paramString);
  }
  
  public static int getRLayout(Context paramContext, String paramString)
  {
    return getIdentifier(paramContext, "layout", paramString);
  }
  
  public static int getRLayout(String paramString)
  {
    return getIdentifier(KernelContext.context, "layout", paramString);
  }
  
  public static int getRStyleable(Context paramContext, String paramString)
  {
    paramContext = getRStyleableField(paramContext, paramString);
    if (paramContext == null) {
      return 0;
    }
    return ((Integer)paramContext).intValue();
  }
  
  private static Object getRStyleableField(Context paramContext, String paramString)
  {
    try
    {
      paramContext = Class.forName(paramContext.getPackageName() + ".R$styleable").getField(paramString).get(null);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      Log.e("ResourceUtils", "", paramContext);
    }
    return null;
  }
  
  public static final int[] getRStyleableIntArray(Context paramContext, String paramString)
  {
    return (int[])getRStyleableField(paramContext, paramString);
  }
  
  public static String getString(Context paramContext, String paramString)
  {
    return paramContext.getResources().getString(getIdentifier(paramContext, "string", paramString));
  }
  
  public static String getString(String paramString)
  {
    return getString(KernelContext.context, paramString);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\util\ResourceUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */