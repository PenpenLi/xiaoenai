package com.bumptech.glide.e;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class b
{
  private final Context a;
  
  public b(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private static a a(String paramString)
  {
    try
    {
      paramString = Class.forName(paramString);
      Object localObject;
      return (a)localIllegalAccessException;
    }
    catch (ClassNotFoundException paramString)
    {
      try
      {
        localObject = paramString.newInstance();
        if ((localObject instanceof a)) {
          break label114;
        }
        throw new RuntimeException("Expected instanceof GlideModule, but found: " + localObject);
      }
      catch (InstantiationException localInstantiationException)
      {
        throw new RuntimeException("Unable to instantiate GlideModule implementation for " + paramString, localInstantiationException);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new RuntimeException("Unable to instantiate GlideModule implementation for " + paramString, localIllegalAccessException);
      }
      paramString = paramString;
      throw new IllegalArgumentException("Unable to find GlideModule implementation", paramString);
    }
  }
  
  public List<a> a()
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      ApplicationInfo localApplicationInfo = this.a.getPackageManager().getApplicationInfo(this.a.getPackageName(), 128);
      if (localApplicationInfo.metaData != null)
      {
        Iterator localIterator = localApplicationInfo.metaData.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if ("GlideModule".equals(localApplicationInfo.metaData.get(str))) {
            localArrayList.add(a(str));
          }
        }
      }
      return localNameNotFoundException;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      throw new RuntimeException("Unable to find metadata to parse GlideModules", localNameNotFoundException);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\e\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */