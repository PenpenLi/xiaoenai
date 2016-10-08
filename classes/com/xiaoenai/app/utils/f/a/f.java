package com.xiaoenai.app.utils.f.a;

public final class f
{
  public static e a(c paramc)
  {
    return a(null, paramc);
  }
  
  public static e a(String paramString, c paramc)
  {
    if (("Timber".equals(paramString)) && (a("timber.log.Timber"))) {
      return new g(paramc);
    }
    if (("Logger".equals(paramString)) && (a("com.orhanobut.logger.Logger"))) {
      return new d(paramc);
    }
    if ("Android".equals(paramString)) {
      return new a(paramc);
    }
    return new b(paramc);
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


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\utils\f\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */