package com.bumptech.glide.d.c;

import android.net.Uri;
import com.bumptech.glide.d.a.c;
import java.io.File;

public class b<T>
  implements l<File, T>
{
  private final l<Uri, T> a;
  
  public b(l<Uri, T> paraml)
  {
    this.a = paraml;
  }
  
  public c<T> a(File paramFile, int paramInt1, int paramInt2)
  {
    return this.a.a(Uri.fromFile(paramFile), paramInt1, paramInt2);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */