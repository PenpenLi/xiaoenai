package com.bumptech.glide.d.c;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.d.a.c;

public class n<T>
  implements l<Integer, T>
{
  private final l<Uri, T> a;
  private final Resources b;
  
  public n(Context paramContext, l<Uri, T> paraml)
  {
    this(paramContext.getResources(), paraml);
  }
  
  public n(Resources paramResources, l<Uri, T> paraml)
  {
    this.b = paramResources;
    this.a = paraml;
  }
  
  public c<T> a(Integer paramInteger, int paramInt1, int paramInt2)
  {
    c localc = null;
    try
    {
      Uri localUri = Uri.parse("android.resource://" + this.b.getResourcePackageName(paramInteger.intValue()) + '/' + this.b.getResourceTypeName(paramInteger.intValue()) + '/' + this.b.getResourceEntryName(paramInteger.intValue()));
      paramInteger = localUri;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      for (;;)
      {
        if (Log.isLoggable("ResourceLoader", 5)) {
          Log.w("ResourceLoader", "Received invalid resource id: " + paramInteger, localNotFoundException);
        }
        paramInteger = null;
      }
    }
    if (paramInteger != null) {
      localc = this.a.a(paramInteger, paramInt1, paramInt2);
    }
    return localc;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\c\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */