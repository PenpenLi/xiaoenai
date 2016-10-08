package b.a.b;

public final class m
{
  public static boolean a(String paramString)
  {
    return (paramString.equals("POST")) || (paramString.equals("PATCH")) || (paramString.equals("PUT")) || (paramString.equals("DELETE")) || (paramString.equals("MOVE"));
  }
  
  public static boolean b(String paramString)
  {
    return (paramString.equals("POST")) || (paramString.equals("PUT")) || (paramString.equals("PATCH")) || (paramString.equals("PROPPATCH")) || (paramString.equals("REPORT"));
  }
  
  public static boolean c(String paramString)
  {
    return (b(paramString)) || (paramString.equals("OPTIONS")) || (paramString.equals("DELETE")) || (paramString.equals("PROPFIND")) || (paramString.equals("MKCOL")) || (paramString.equals("LOCK"));
  }
  
  public static boolean d(String paramString)
  {
    return !paramString.equals("PROPFIND");
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\b\a\b\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */