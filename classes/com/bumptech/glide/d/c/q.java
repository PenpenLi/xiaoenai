package com.bumptech.glide.d.c;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.d.a.c;

public abstract class q<T>
  implements l<Uri, T>
{
  private final Context a;
  private final l<e, T> b;
  
  public q(Context paramContext, l<e, T> paraml)
  {
    this.a = paramContext;
    this.b = paraml;
  }
  
  private static boolean a(String paramString)
  {
    return ("file".equals(paramString)) || ("content".equals(paramString)) || ("android.resource".equals(paramString));
  }
  
  protected abstract c<T> a(Context paramContext, Uri paramUri);
  
  protected abstract c<T> a(Context paramContext, String paramString);
  
  public final c<T> a(Uri paramUri, int paramInt1, int paramInt2)
  {
    String str = paramUri.getScheme();
    Object localObject2 = null;
    Object localObject1;
    if (a(str)) {
      if (a.a(paramUri))
      {
        paramUri = a.b(paramUri);
        localObject1 = a(this.a, paramUri);
      }
    }
    do
    {
      do
      {
        return (c<T>)localObject1;
        return a(this.a, paramUri);
        localObject1 = localObject2;
      } while (this.b == null);
      if ("http".equals(str)) {
        break;
      }
      localObject1 = localObject2;
    } while (!"https".equals(str));
    return this.b.a(new e(paramUri.toString()), paramInt1, paramInt2);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\c\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */