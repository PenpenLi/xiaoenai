package b;

import b.a.j;
import c.e;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class ab
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  private final String b;
  private final String c;
  private final String d;
  private final String e;
  private final int f;
  private final List<String> g;
  private final List<String> h;
  private final String i;
  private final String j;
  
  private ab(a parama)
  {
    this.b = parama.a;
    this.c = a(parama.b, false);
    this.d = a(parama.c, false);
    this.e = parama.d;
    this.f = parama.a();
    this.g = a(parama.f, false);
    if (parama.g != null) {}
    for (Object localObject1 = a(parama.g, true);; localObject1 = null)
    {
      this.h = ((List)localObject1);
      localObject1 = localObject2;
      if (parama.h != null) {
        localObject1 = a(parama.h, false);
      }
      this.i = ((String)localObject1);
      this.j = parama.toString();
      return;
    }
  }
  
  static int a(char paramChar)
  {
    if ((paramChar >= '0') && (paramChar <= '9')) {
      return paramChar - '0';
    }
    if ((paramChar >= 'a') && (paramChar <= 'f')) {
      return paramChar - 'a' + 10;
    }
    if ((paramChar >= 'A') && (paramChar <= 'F')) {
      return paramChar - 'A' + 10;
    }
    return -1;
  }
  
  public static int a(String paramString)
  {
    if (paramString.equals("http")) {
      return 80;
    }
    if (paramString.equals("https")) {
      return 443;
    }
    return -1;
  }
  
  static String a(String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    int k = paramInt1;
    while (k < paramInt2)
    {
      int m = paramString1.codePointAt(k);
      if ((m < 32) || (m == 127) || ((m >= 128) && (paramBoolean4)) || (paramString2.indexOf(m) != -1) || ((m == 37) && ((!paramBoolean1) || ((paramBoolean2) && (!a(paramString1, k, paramInt2))))) || ((m == 43) && (paramBoolean3)))
      {
        e locale = new e();
        locale.a(paramString1, paramInt1, k);
        a(locale, paramString1, k, paramInt2, paramString2, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
        return locale.p();
      }
      k += Character.charCount(m);
    }
    return paramString1.substring(paramInt1, paramInt2);
  }
  
  static String a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int k = paramInt1;
    while (k < paramInt2)
    {
      int m = paramString.charAt(k);
      if ((m == 37) || ((m == 43) && (paramBoolean)))
      {
        e locale = new e();
        locale.a(paramString, paramInt1, k);
        a(locale, paramString, k, paramInt2, paramBoolean);
        return locale.p();
      }
      k += 1;
    }
    return paramString.substring(paramInt1, paramInt2);
  }
  
  static String a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    return a(paramString1, 0, paramString1.length(), paramString2, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
  }
  
  static String a(String paramString, boolean paramBoolean)
  {
    return a(paramString, 0, paramString.length(), paramBoolean);
  }
  
  private List<String> a(List<String> paramList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      paramList = (String)localIterator.next();
      if (paramList != null) {}
      for (paramList = a(paramList, paramBoolean);; paramList = null)
      {
        localArrayList.add(paramList);
        break;
      }
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  static void a(e parame, String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    Object localObject1 = null;
    if (paramInt1 < paramInt2)
    {
      int k = paramString1.codePointAt(paramInt1);
      Object localObject3;
      if (paramBoolean1)
      {
        localObject3 = localObject1;
        if (k != 9)
        {
          localObject3 = localObject1;
          if (k != 10)
          {
            localObject3 = localObject1;
            if (k != 12)
            {
              if (k != 13) {
                break label79;
              }
              localObject3 = localObject1;
            }
          }
        }
      }
      for (;;)
      {
        paramInt1 += Character.charCount(k);
        localObject1 = localObject3;
        break;
        label79:
        Object localObject2;
        if ((k == 43) && (paramBoolean3))
        {
          if (paramBoolean1) {}
          for (localObject2 = "+";; localObject2 = "%2B")
          {
            parame.a((String)localObject2);
            localObject3 = localObject1;
            break;
          }
        }
        if ((k < 32) || (k == 127) || ((k >= 128) && (paramBoolean4)) || (paramString2.indexOf(k) != -1) || ((k == 37) && ((!paramBoolean1) || ((paramBoolean2) && (!a(paramString1, paramInt1, paramInt2))))))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new e();
          }
          ((e)localObject2).a(k);
          for (;;)
          {
            localObject3 = localObject2;
            if (((e)localObject2).f()) {
              break;
            }
            int m = ((e)localObject2).i() & 0xFF;
            parame.b(37);
            parame.b(a[(m >> 4 & 0xF)]);
            parame.b(a[(m & 0xF)]);
          }
        }
        parame.a(k);
        localObject3 = localObject1;
      }
    }
  }
  
  static void a(e parame, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt1 < paramInt2)
    {
      int k = paramString.codePointAt(paramInt1);
      if ((k == 37) && (paramInt1 + 2 < paramInt2))
      {
        int m = a(paramString.charAt(paramInt1 + 1));
        int n = a(paramString.charAt(paramInt1 + 2));
        if ((m == -1) || (n == -1)) {
          break label111;
        }
        parame.b((m << 4) + n);
        paramInt1 += 2;
      }
      for (;;)
      {
        paramInt1 += Character.charCount(k);
        break;
        if ((k == 43) && (paramBoolean)) {
          parame.b(32);
        } else {
          label111:
          parame.a(k);
        }
      }
    }
  }
  
  static void a(StringBuilder paramStringBuilder, List<String> paramList)
  {
    int m = paramList.size();
    int k = 0;
    while (k < m)
    {
      paramStringBuilder.append('/');
      paramStringBuilder.append((String)paramList.get(k));
      k += 1;
    }
  }
  
  static boolean a(String paramString, int paramInt1, int paramInt2)
  {
    return (paramInt1 + 2 < paramInt2) && (paramString.charAt(paramInt1) == '%') && (a(paramString.charAt(paramInt1 + 1)) != -1) && (a(paramString.charAt(paramInt1 + 2)) != -1);
  }
  
  static List<String> b(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int k = 0;
    if (k <= paramString.length())
    {
      int n = paramString.indexOf('&', k);
      int m = n;
      if (n == -1) {
        m = paramString.length();
      }
      n = paramString.indexOf('=', k);
      if ((n == -1) || (n > m))
      {
        localArrayList.add(paramString.substring(k, m));
        localArrayList.add(null);
      }
      for (;;)
      {
        k = m + 1;
        break;
        localArrayList.add(paramString.substring(k, n));
        localArrayList.add(paramString.substring(n + 1, m));
      }
    }
    return localArrayList;
  }
  
  static void b(StringBuilder paramStringBuilder, List<String> paramList)
  {
    int m = paramList.size();
    int k = 0;
    while (k < m)
    {
      String str1 = (String)paramList.get(k);
      String str2 = (String)paramList.get(k + 1);
      if (k > 0) {
        paramStringBuilder.append('&');
      }
      paramStringBuilder.append(str1);
      if (str2 != null)
      {
        paramStringBuilder.append('=');
        paramStringBuilder.append(str2);
      }
      k += 2;
    }
  }
  
  public static ab e(String paramString)
  {
    ab localab = null;
    a locala = new a();
    if (locala.a(null, paramString) == ab.a.a.a) {
      localab = locala.c();
    }
    return localab;
  }
  
  public URI a()
  {
    Object localObject = m().b().toString();
    try
    {
      URI localURI = new URI((String)localObject);
      return localURI;
    }
    catch (URISyntaxException localURISyntaxException)
    {
      try
      {
        localObject = URI.create(((String)localObject).replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
        return (URI)localObject;
      }
      catch (Exception localException)
      {
        throw new RuntimeException(localURISyntaxException);
      }
    }
  }
  
  public String b()
  {
    return this.b;
  }
  
  public ab c(String paramString)
  {
    paramString = d(paramString);
    if (paramString != null) {
      return paramString.c();
    }
    return null;
  }
  
  public boolean c()
  {
    return this.b.equals("https");
  }
  
  public a d(String paramString)
  {
    a locala = new a();
    if (locala.a(this, paramString) == ab.a.a.a) {
      return locala;
    }
    return null;
  }
  
  public String d()
  {
    if (this.c.isEmpty()) {
      return "";
    }
    int k = this.b.length() + 3;
    int m = j.a(this.j, k, this.j.length(), ":@");
    return this.j.substring(k, m);
  }
  
  public String e()
  {
    if (this.d.isEmpty()) {
      return "";
    }
    int k = this.j.indexOf(':', this.b.length() + 3);
    int m = this.j.indexOf('@');
    return this.j.substring(k + 1, m);
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof ab)) && (((ab)paramObject).j.equals(this.j));
  }
  
  public String f()
  {
    return this.e;
  }
  
  public int g()
  {
    return this.f;
  }
  
  public String h()
  {
    int k = this.j.indexOf('/', this.b.length() + 3);
    int m = j.a(this.j, k, this.j.length(), "?#");
    return this.j.substring(k, m);
  }
  
  public int hashCode()
  {
    return this.j.hashCode();
  }
  
  public List<String> i()
  {
    int k = this.j.indexOf('/', this.b.length() + 3);
    int m = j.a(this.j, k, this.j.length(), "?#");
    ArrayList localArrayList = new ArrayList();
    while (k < m)
    {
      int n = k + 1;
      k = j.a(this.j, n, m, '/');
      localArrayList.add(this.j.substring(n, k));
    }
    return localArrayList;
  }
  
  public String j()
  {
    if (this.h == null) {
      return null;
    }
    int k = this.j.indexOf('?') + 1;
    int m = j.a(this.j, k + 1, this.j.length(), '#');
    return this.j.substring(k, m);
  }
  
  public String k()
  {
    if (this.h == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    b(localStringBuilder, this.h);
    return localStringBuilder.toString();
  }
  
  public String l()
  {
    if (this.i == null) {
      return null;
    }
    int k = this.j.indexOf('#');
    return this.j.substring(k + 1);
  }
  
  public a m()
  {
    a locala = new a();
    locala.a = this.b;
    locala.b = d();
    locala.c = e();
    locala.d = this.e;
    if (this.f != a(this.b)) {}
    for (int k = this.f;; k = -1)
    {
      locala.e = k;
      locala.f.clear();
      locala.f.addAll(i());
      locala.c(j());
      locala.h = l();
      return locala;
    }
  }
  
  public String toString()
  {
    return this.j;
  }
  
  public static final class a
  {
    String a;
    String b = "";
    String c = "";
    String d;
    int e = -1;
    final List<String> f = new ArrayList();
    List<String> g;
    String h;
    
    public a()
    {
      this.f.add("");
    }
    
    private static String a(byte[] paramArrayOfByte)
    {
      int i1 = 0;
      int j = 0;
      int k = -1;
      int i = 0;
      int m;
      while (i < paramArrayOfByte.length)
      {
        m = i;
        while ((m < 16) && (paramArrayOfByte[m] == 0) && (paramArrayOfByte[(m + 1)] == 0)) {
          m += 2;
        }
        int i2 = m - i;
        int n = j;
        if (i2 > j)
        {
          n = i2;
          k = i;
        }
        i = m + 2;
        j = n;
      }
      e locale = new e();
      i = i1;
      while (i < paramArrayOfByte.length) {
        if (i == k)
        {
          locale.b(58);
          m = i + j;
          i = m;
          if (m == 16)
          {
            locale.b(58);
            i = m;
          }
        }
        else
        {
          if (i > 0) {
            locale.b(58);
          }
          locale.i((paramArrayOfByte[i] & 0xFF) << 8 | paramArrayOfByte[(i + 1)] & 0xFF);
          i += 2;
        }
      }
      return locale.p();
    }
    
    private void a(String paramString, int paramInt1, int paramInt2)
    {
      if (paramInt1 == paramInt2) {
        return;
      }
      int i = paramString.charAt(paramInt1);
      if ((i == 47) || (i == 92))
      {
        this.f.clear();
        this.f.add("");
        paramInt1 += 1;
        label52:
        if (paramInt1 >= paramInt2) {
          break label127;
        }
        i = j.a(paramString, paramInt1, paramInt2, "/\\");
        if (i >= paramInt2) {
          break label129;
        }
      }
      label127:
      label129:
      for (boolean bool = true;; bool = false)
      {
        a(paramString, paramInt1, i, bool, true);
        paramInt1 = i;
        if (bool) {
          paramInt1 = i + 1;
        }
        break label52;
        this.f.set(this.f.size() - 1, "");
        break label52;
        break;
      }
    }
    
    private void a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
    {
      paramString = ab.a(paramString, paramInt1, paramInt2, " \"<>^`{}|/\\?#", paramBoolean2, false, false, true);
      if (d(paramString)) {}
      for (;;)
      {
        return;
        if (e(paramString))
        {
          d();
          return;
        }
        if (((String)this.f.get(this.f.size() - 1)).isEmpty()) {
          this.f.set(this.f.size() - 1, paramString);
        }
        while (paramBoolean1)
        {
          this.f.add("");
          return;
          this.f.add(paramString);
        }
      }
    }
    
    private static boolean a(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte, int paramInt3)
    {
      int j = paramInt3;
      int i = paramInt1;
      while (i < paramInt2)
      {
        if (j == paramArrayOfByte.length) {
          return false;
        }
        paramInt1 = i;
        if (j != paramInt3)
        {
          if (paramString.charAt(i) != '.') {
            return false;
          }
          paramInt1 = i + 1;
        }
        int k = 0;
        i = paramInt1;
        for (;;)
        {
          int m;
          if (i < paramInt2)
          {
            m = paramString.charAt(i);
            if ((m >= 48) && (m <= 57)) {}
          }
          else
          {
            if (i - paramInt1 != 0) {
              break;
            }
            return false;
          }
          if ((k == 0) && (paramInt1 != i)) {
            return false;
          }
          k = k * 10 + m - 48;
          if (k > 255) {
            return false;
          }
          i += 1;
        }
        paramArrayOfByte[j] = ((byte)k);
        j += 1;
      }
      return j == paramInt3 + 4;
    }
    
    private static int b(String paramString, int paramInt1, int paramInt2)
    {
      if (paramInt2 - paramInt1 < 2) {}
      int i;
      label115:
      do
      {
        for (;;)
        {
          return -1;
          i = paramString.charAt(paramInt1);
          if (((i >= 97) && (i <= 122)) || ((i >= 65) && (i <= 90)))
          {
            paramInt1 += 1;
            while (paramInt1 < paramInt2)
            {
              i = paramString.charAt(paramInt1);
              if (((i < 97) || (i > 122)) && ((i < 65) || (i > 90)) && ((i < 48) || (i > 57)) && (i != 43) && (i != 45) && (i != 46)) {
                break label115;
              }
              paramInt1 += 1;
            }
          }
        }
      } while (i != 58);
      return paramInt1;
    }
    
    private static int c(String paramString, int paramInt1, int paramInt2)
    {
      int i = 0;
      while (paramInt1 < paramInt2)
      {
        int j = paramString.charAt(paramInt1);
        if ((j != 92) && (j != 47)) {
          break;
        }
        i += 1;
        paramInt1 += 1;
      }
      return i;
    }
    
    private static int d(String paramString, int paramInt1, int paramInt2)
    {
      int i;
      int j;
      if (paramInt1 < paramInt2)
      {
        i = paramInt1;
        j = paramInt1;
      }
      switch (paramString.charAt(paramInt1))
      {
      default: 
        i = paramInt1;
      case '[': 
        for (;;)
        {
          paramInt1 = i + 1;
          break;
          do
          {
            paramInt1 = i + 1;
            i = paramInt1;
            if (paramInt1 >= paramInt2) {
              break;
            }
            i = paramInt1;
          } while (paramString.charAt(paramInt1) != ']');
          i = paramInt1;
        }
        j = paramInt2;
      }
      return j;
    }
    
    private void d()
    {
      if ((((String)this.f.remove(this.f.size() - 1)).isEmpty()) && (!this.f.isEmpty()))
      {
        this.f.set(this.f.size() - 1, "");
        return;
      }
      this.f.add("");
    }
    
    private boolean d(String paramString)
    {
      return (paramString.equals(".")) || (paramString.equalsIgnoreCase("%2e"));
    }
    
    private static String e(String paramString, int paramInt1, int paramInt2)
    {
      paramString = ab.a(paramString, paramInt1, paramInt2, false);
      if (paramString.contains(":"))
      {
        if ((paramString.startsWith("[")) && (paramString.endsWith("]"))) {}
        for (paramString = f(paramString, 1, paramString.length() - 1); paramString == null; paramString = f(paramString, 0, paramString.length())) {
          return null;
        }
        paramString = paramString.getAddress();
        if (paramString.length == 16) {
          return a(paramString);
        }
        throw new AssertionError();
      }
      return j.a(paramString);
    }
    
    private boolean e(String paramString)
    {
      return (paramString.equals("..")) || (paramString.equalsIgnoreCase("%2e.")) || (paramString.equalsIgnoreCase(".%2e")) || (paramString.equalsIgnoreCase("%2e%2e"));
    }
    
    private static InetAddress f(String paramString, int paramInt1, int paramInt2)
    {
      byte[] arrayOfByte = new byte[16];
      int i1 = -1;
      int j = -1;
      int i = 0;
      int k = paramInt1;
      int m = j;
      paramInt1 = i;
      if (k < paramInt2)
      {
        if (i == arrayOfByte.length) {
          return null;
        }
        if ((k + 2 <= paramInt2) && (paramString.regionMatches(k, "::", 0, 2)))
        {
          if (j != -1) {
            return null;
          }
          paramInt1 = k + 2;
          i += 2;
          if (paramInt1 != paramInt2) {
            break label360;
          }
          paramInt1 = i;
          m = i;
        }
      }
      else
      {
        if (paramInt1 == arrayOfByte.length) {
          break label344;
        }
        if (m != -1) {
          break label312;
        }
        return null;
      }
      paramInt1 = k;
      m = j;
      int n = i;
      if (i != 0)
      {
        if (!paramString.regionMatches(k, ":", 0, 1)) {
          break label195;
        }
        paramInt1 = k + 1;
        n = i;
      }
      for (m = j;; m = i)
      {
        j = 0;
        i = paramInt1;
        for (;;)
        {
          if (i < paramInt2)
          {
            k = ab.a(paramString.charAt(i));
            if (k != -1) {}
          }
          else
          {
            k = i - paramInt1;
            if ((k != 0) && (k <= 4)) {
              break label257;
            }
            return null;
            label195:
            if (paramString.regionMatches(k, ".", 0, 1))
            {
              if (!a(paramString, i1, paramInt2, arrayOfByte, i - 2)) {
                return null;
              }
              paramInt1 = i + 2;
              m = j;
              break;
            }
            return null;
          }
          j = (j << 4) + k;
          i += 1;
        }
        label257:
        k = n + 1;
        arrayOfByte[n] = ((byte)(j >>> 8 & 0xFF));
        n = k + 1;
        arrayOfByte[k] = ((byte)(j & 0xFF));
        k = i;
        j = m;
        i = n;
        i1 = paramInt1;
        break;
        label312:
        System.arraycopy(arrayOfByte, m, arrayOfByte, arrayOfByte.length - (paramInt1 - m), paramInt1 - m);
        Arrays.fill(arrayOfByte, m, arrayOfByte.length - paramInt1 + m, (byte)0);
        try
        {
          label344:
          paramString = InetAddress.getByAddress(arrayOfByte);
          return paramString;
        }
        catch (UnknownHostException paramString)
        {
          throw new AssertionError();
        }
        label360:
        n = i;
      }
    }
    
    private static int g(String paramString, int paramInt1, int paramInt2)
    {
      try
      {
        paramInt1 = Integer.parseInt(ab.a(paramString, paramInt1, paramInt2, "", false, false, false, true));
        if ((paramInt1 > 0) && (paramInt1 <= 65535)) {
          return paramInt1;
        }
        return -1;
      }
      catch (NumberFormatException paramString) {}
      return -1;
    }
    
    int a()
    {
      if (this.e != -1) {
        return this.e;
      }
      return ab.a(this.a);
    }
    
    a a(ab paramab, String paramString)
    {
      int i = j.a(paramString, 0, paramString.length());
      int i1 = j.b(paramString, i, paramString.length());
      label66:
      int k;
      label121:
      int n;
      if (b(paramString, i, i1) != -1) {
        if (paramString.regionMatches(true, i, "https:", 0, 6))
        {
          this.a = "https";
          i += "https:".length();
          m = c(paramString, i, i1);
          if ((m < 2) && (paramab != null) && (ab.a(paramab).equals(this.a))) {
            break label683;
          }
          k = 0;
          j = 0;
          m = i + m;
          i = k;
          k = m;
          n = j.a(paramString, k, i1, "@/\\?#");
          if (n == i1) {
            break label291;
          }
        }
      }
      label291:
      for (int m = paramString.charAt(n);; m = -1) {
        switch (m)
        {
        default: 
          m = i;
          i = k;
          k = m;
          m = k;
          k = i;
          i = m;
          break label121;
          if (paramString.regionMatches(true, i, "http:", 0, 5))
          {
            this.a = "http";
            i += "http:".length();
            break label66;
          }
          return a.c;
          if (paramab != null)
          {
            this.a = ab.a(paramab);
            break label66;
          }
          return a.b;
        }
      }
      if (i == 0)
      {
        m = j.a(paramString, k, n, ':');
        String str = ab.a(paramString, k, m, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
        paramab = str;
        if (j != 0) {
          paramab = this.b + "%40" + str;
        }
        this.b = paramab;
        if (m != n)
        {
          i = 1;
          this.c = ab.a(paramString, m + 1, n, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
        }
        j = 1;
      }
      for (;;)
      {
        m = n + 1;
        k = i;
        i = m;
        break;
        this.c = (this.c + "%40" + ab.a(paramString, k, n, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true));
      }
      i = d(paramString, k, n);
      if (i + 1 < n)
      {
        this.d = e(paramString, k, i);
        this.e = g(paramString, i + 1, n);
        if (this.e == -1) {
          return a.d;
        }
      }
      else
      {
        this.d = e(paramString, k, i);
        this.e = ab.a(this.a);
      }
      if (this.d == null) {
        return a.e;
      }
      int j = n;
      i = j.a(paramString, j, i1, "?#");
      a(paramString, j, i);
      if ((i < i1) && (paramString.charAt(i) == '?'))
      {
        j = j.a(paramString, i, i1, '#');
        this.g = ab.b(ab.a(paramString, i + 1, j, " \"'<>#", true, false, true, true));
        i = j;
      }
      for (;;)
      {
        if ((i < i1) && (paramString.charAt(i) == '#')) {
          this.h = ab.a(paramString, i + 1, i1, "", true, false, false, false);
        }
        return a.a;
        label683:
        this.b = paramab.d();
        this.c = paramab.e();
        this.d = ab.b(paramab);
        this.e = ab.c(paramab);
        this.f.clear();
        this.f.addAll(paramab.i());
        if (i != i1)
        {
          j = i;
          if (paramString.charAt(i) != '#') {
            break;
          }
        }
        c(paramab.j());
        j = i;
        break;
      }
    }
    
    public a a(int paramInt)
    {
      if ((paramInt <= 0) || (paramInt > 65535)) {
        throw new IllegalArgumentException("unexpected port: " + paramInt);
      }
      this.e = paramInt;
      return this;
    }
    
    public a a(String paramString)
    {
      if (paramString == null) {
        throw new IllegalArgumentException("scheme == null");
      }
      if (paramString.equalsIgnoreCase("http"))
      {
        this.a = "http";
        return this;
      }
      if (paramString.equalsIgnoreCase("https"))
      {
        this.a = "https";
        return this;
      }
      throw new IllegalArgumentException("unexpected scheme: " + paramString);
    }
    
    public a a(String paramString1, String paramString2)
    {
      if (paramString1 == null) {
        throw new IllegalArgumentException("name == null");
      }
      if (this.g == null) {
        this.g = new ArrayList();
      }
      this.g.add(ab.a(paramString1, " \"'<>#&=", false, false, true, true));
      List localList = this.g;
      if (paramString2 != null) {}
      for (paramString1 = ab.a(paramString2, " \"'<>#&=", false, false, true, true);; paramString1 = null)
      {
        localList.add(paramString1);
        return this;
      }
    }
    
    a b()
    {
      int j = this.f.size();
      int i = 0;
      String str;
      while (i < j)
      {
        str = (String)this.f.get(i);
        this.f.set(i, ab.a(str, "[]", true, true, false, true));
        i += 1;
      }
      if (this.g != null)
      {
        j = this.g.size();
        i = 0;
        while (i < j)
        {
          str = (String)this.g.get(i);
          if (str != null) {
            this.g.set(i, ab.a(str, "\\^`{|}", true, true, true, true));
          }
          i += 1;
        }
      }
      if (this.h != null) {
        this.h = ab.a(this.h, " \"#<>\\^`{|}", true, true, false, false);
      }
      return this;
    }
    
    public a b(String paramString)
    {
      if (paramString == null) {
        throw new IllegalArgumentException("host == null");
      }
      String str = e(paramString, 0, paramString.length());
      if (str == null) {
        throw new IllegalArgumentException("unexpected host: " + paramString);
      }
      this.d = str;
      return this;
    }
    
    public a c(String paramString)
    {
      if (paramString != null) {}
      for (paramString = ab.b(ab.a(paramString, " \"'<>#", true, false, true, true));; paramString = null)
      {
        this.g = paramString;
        return this;
      }
    }
    
    public ab c()
    {
      if (this.a == null) {
        throw new IllegalStateException("scheme == null");
      }
      if (this.d == null) {
        throw new IllegalStateException("host == null");
      }
      return new ab(this, null);
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a);
      localStringBuilder.append("://");
      if ((!this.b.isEmpty()) || (!this.c.isEmpty()))
      {
        localStringBuilder.append(this.b);
        if (!this.c.isEmpty())
        {
          localStringBuilder.append(':');
          localStringBuilder.append(this.c);
        }
        localStringBuilder.append('@');
      }
      if (this.d.indexOf(':') != -1)
      {
        localStringBuilder.append('[');
        localStringBuilder.append(this.d);
        localStringBuilder.append(']');
      }
      for (;;)
      {
        int i = a();
        if (i != ab.a(this.a))
        {
          localStringBuilder.append(':');
          localStringBuilder.append(i);
        }
        ab.a(localStringBuilder, this.f);
        if (this.g != null)
        {
          localStringBuilder.append('?');
          ab.b(localStringBuilder, this.g);
        }
        if (this.h != null)
        {
          localStringBuilder.append('#');
          localStringBuilder.append(this.h);
        }
        return localStringBuilder.toString();
        localStringBuilder.append(this.d);
      }
    }
    
    static enum a
    {
      private a() {}
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\b\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */