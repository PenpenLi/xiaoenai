package com.bumptech.glide.d.a;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.e;
import java.io.IOException;

public abstract class g<T>
  implements c<T>
{
  private final Uri a;
  private final Context b;
  private T c;
  
  public g(Context paramContext, Uri paramUri)
  {
    this.b = paramContext.getApplicationContext();
    this.a = paramUri;
  }
  
  public final T a(e parame)
  {
    parame = this.b.getContentResolver();
    this.c = b(this.a, parame);
    return (T)this.c;
  }
  
  public void a()
  {
    if (this.c != null) {}
    try
    {
      a(this.c);
      return;
    }
    catch (IOException localIOException)
    {
      while (!Log.isLoggable("LocalUriFetcher", 2)) {}
      Log.v("LocalUriFetcher", "failed to close data", localIOException);
    }
  }
  
  protected abstract void a(T paramT);
  
  protected abstract T b(Uri paramUri, ContentResolver paramContentResolver);
  
  public String b()
  {
    return this.a.toString();
  }
  
  public void c() {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */