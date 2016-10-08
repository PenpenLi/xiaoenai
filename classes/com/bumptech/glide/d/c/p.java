package com.bumptech.glide.d.c;

import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.d.a.c;
import java.io.File;

public class p<T>
  implements l<String, T>
{
  private final l<Uri, T> a;
  
  public p(l<Uri, T> paraml)
  {
    this.a = paraml;
  }
  
  private static Uri a(String paramString)
  {
    return Uri.fromFile(new File(paramString));
  }
  
  public c<T> a(String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject;
    if (paramString.startsWith("/")) {
      localObject = a(paramString);
    }
    for (;;)
    {
      return this.a.a(localObject, paramInt1, paramInt2);
      Uri localUri = Uri.parse(paramString);
      localObject = localUri;
      if (localUri.getScheme() == null) {
        localObject = a(paramString);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\c\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */