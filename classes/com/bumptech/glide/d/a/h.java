package com.bumptech.glide.d.a;

import android.content.res.AssetManager;
import java.io.InputStream;

public class h
  extends a<InputStream>
{
  public h(AssetManager paramAssetManager, String paramString)
  {
    super(paramAssetManager, paramString);
  }
  
  protected void a(InputStream paramInputStream)
  {
    paramInputStream.close();
  }
  
  protected InputStream b(AssetManager paramAssetManager, String paramString)
  {
    return paramAssetManager.open(paramString);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */