package com.alibaba.nb.android.trade.utils;

import android.content.Intent;

public final class h
{
  public static boolean a(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        return false;
        if ((paramObject instanceof Boolean)) {
          return ((Boolean)paramObject).booleanValue();
        }
      } while (!(paramObject instanceof String));
      paramObject = (String)paramObject;
    } while ((!"true".equals(((String)paramObject).toLowerCase())) && (!"1".equals(paramObject)) && (!"YES".equals(paramObject)));
    return true;
  }
  
  public static int b(Object paramObject)
  {
    try
    {
      int i = Integer.parseInt(paramObject.toString());
      return i;
    }
    catch (Exception paramObject)
    {
      ((Exception)paramObject).printStackTrace();
    }
    return Integer.MIN_VALUE;
  }
  
  public static Intent c(Object paramObject)
  {
    try
    {
      paramObject = (Intent)paramObject;
      return (Intent)paramObject;
    }
    catch (Exception paramObject)
    {
      ((Exception)paramObject).printStackTrace();
    }
    return null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\utils\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */