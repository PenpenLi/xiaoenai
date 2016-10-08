package com.bumptech.glide.d.a;

import android.content.res.AssetManager;
import android.util.Log;
import com.bumptech.glide.e;
import java.io.IOException;

public abstract class a<T>
  implements c<T>
{
  private final String a;
  private final AssetManager b;
  private T c;
  
  public a(AssetManager paramAssetManager, String paramString)
  {
    this.b = paramAssetManager;
    this.a = paramString;
  }
  
  protected abstract T a(AssetManager paramAssetManager, String paramString);
  
  public T a(e parame)
  {
    this.c = a(this.b, this.a);
    return (T)this.c;
  }
  
  public void a()
  {
    if (this.c == null) {}
    do
    {
      return;
      try
      {
        a(this.c);
        return;
      }
      catch (IOException localIOException) {}
    } while (!Log.isLoggable("AssetUriFetcher", 2));
    Log.v("AssetUriFetcher", "Failed to close data", localIOException);
  }
  
  protected abstract void a(T paramT);
  
  public String b()
  {
    return this.a;
  }
  
  public void c() {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */