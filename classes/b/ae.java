package b;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ae
{
  private static final Pattern a = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
  private static final Pattern b = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
  private final String c;
  private final String d;
  private final String e;
  private final String f;
  
  private ae(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.c = paramString1;
    this.d = paramString2;
    this.e = paramString3;
    this.f = paramString4;
  }
  
  public static ae a(String paramString)
  {
    Object localObject1 = a.matcher(paramString);
    if (!((Matcher)localObject1).lookingAt()) {}
    String str1;
    String str2;
    Matcher localMatcher;
    int i;
    Object localObject2;
    do
    {
      return null;
      str1 = ((Matcher)localObject1).group(1).toLowerCase(Locale.US);
      str2 = ((Matcher)localObject1).group(2).toLowerCase(Locale.US);
      localMatcher = b.matcher(paramString);
      i = ((Matcher)localObject1).end();
      localObject2 = null;
      if (i >= paramString.length()) {
        break;
      }
      localMatcher.region(i, paramString.length());
    } while (!localMatcher.lookingAt());
    String str3 = localMatcher.group(1);
    localObject1 = localObject2;
    if (str3 != null)
    {
      if (str3.equalsIgnoreCase("charset")) {
        break label127;
      }
      localObject1 = localObject2;
    }
    for (;;)
    {
      i = localMatcher.end();
      localObject2 = localObject1;
      break;
      label127:
      if (localMatcher.group(2) != null) {}
      for (localObject1 = localMatcher.group(2); (localObject2 != null) && (!((String)localObject1).equalsIgnoreCase((String)localObject2)); localObject1 = localMatcher.group(3)) {
        throw new IllegalArgumentException("Multiple different charsets: " + paramString);
      }
    }
    return new ae(paramString, str1, str2, (String)localObject2);
  }
  
  public String a()
  {
    return this.d;
  }
  
  public Charset b()
  {
    if (this.f != null) {
      return Charset.forName(this.f);
    }
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof ae)) && (((ae)paramObject).c.equals(this.c));
  }
  
  public int hashCode()
  {
    return this.c.hashCode();
  }
  
  public String toString()
  {
    return this.c;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\b\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */