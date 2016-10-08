package b.a.b;

import b.ab;
import b.al;
import java.net.Proxy.Type;

public final class r
{
  public static String a(ab paramab)
  {
    String str1 = paramab.h();
    String str2 = paramab.j();
    paramab = str1;
    if (str2 != null) {
      paramab = str1 + '?' + str2;
    }
    return paramab;
  }
  
  static String a(al paramal, Proxy.Type paramType)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramal.b());
    localStringBuilder.append(' ');
    if (b(paramal, paramType)) {
      localStringBuilder.append(paramal.a());
    }
    for (;;)
    {
      localStringBuilder.append(" HTTP/1.1");
      return localStringBuilder.toString();
      localStringBuilder.append(a(paramal.a()));
    }
  }
  
  private static boolean b(al paramal, Proxy.Type paramType)
  {
    return (!paramal.g()) && (paramType == Proxy.Type.HTTP);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\b\a\b\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */