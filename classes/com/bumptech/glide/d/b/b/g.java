package com.bumptech.glide.d.b.b;

import android.content.Context;
import java.io.File;

class g
  implements d.a
{
  g(Context paramContext, String paramString) {}
  
  public File a()
  {
    File localFile = this.a.getCacheDir();
    if (localFile == null) {
      return null;
    }
    if (this.b != null) {
      return new File(localFile, this.b);
    }
    return localFile;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\b\b\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */