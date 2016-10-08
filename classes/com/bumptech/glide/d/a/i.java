package com.bumptech.glide.d.a;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import java.io.InputStream;

public class i
  extends g<InputStream>
{
  public i(Context paramContext, Uri paramUri)
  {
    super(paramContext, paramUri);
  }
  
  protected InputStream a(Uri paramUri, ContentResolver paramContentResolver)
  {
    return paramContentResolver.openInputStream(paramUri);
  }
  
  protected void a(InputStream paramInputStream)
  {
    paramInputStream.close();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\a\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */