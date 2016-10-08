package com.xiaoenai.app.utils.e.c;

public final class e
{
  public static a a(f paramf)
  {
    if (paramf != null)
    {
      if (a("com.nostra13.universalimageloader.core.ImageLoader")) {
        return new h(paramf);
      }
      if (a("com.squareup.picasso.Picasso")) {
        return new g(paramf);
      }
      if (a("com.bumptech.glide.Glide")) {
        return new c(paramf);
      }
      return new h(paramf);
    }
    return new b(null);
  }
  
  private static boolean a(String paramString)
  {
    try
    {
      Class.forName(paramString);
      return true;
    }
    catch (ClassNotFoundException paramString) {}
    return false;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\utils\e\c\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */