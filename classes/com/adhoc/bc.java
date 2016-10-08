package com.adhoc;

import java.net.IDN;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class bc
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
  
  private bc(a parama)
  {
    this.b = parama.a;
    this.c = e(parama.b);
    this.d = e(parama.c);
    this.e = parama.d;
    this.f = parama.a();
    this.g = a(parama.f);
    if (parama.g != null) {}
    for (Object localObject1 = a(parama.g);; localObject1 = null)
    {
      this.h = ((List)localObject1);
      localObject1 = localObject2;
      if (parama.h != null) {
        localObject1 = e(parama.h);
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
  
  static String a(String paramString, int paramInt1, int paramInt2)
  {
    int k = paramInt1;
    while (k < paramInt2)
    {
      if (paramString.charAt(k) == '%')
      {
        eo localeo = new eo();
        localeo.a(paramString, paramInt1, k);
        a(localeo, paramString, k, paramInt2);
        return localeo.o();
      }
      k += 1;
    }
    return paramString.substring(paramInt1, paramInt2);
  }
  
  static String a(String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    int k = paramInt1;
    while (k < paramInt2)
    {
      int m = paramString1.codePointAt(k);
      if ((m < 32) || (m >= 127) || (paramString2.indexOf(m) != -1) || ((m == 37) && (!paramBoolean1)) || ((paramBoolean2) && (m == 43)))
      {
        eo localeo = new eo();
        localeo.a(paramString1, paramInt1, k);
        a(localeo, paramString1, k, paramInt2, paramString2, paramBoolean1, paramBoolean2);
        return localeo.o();
      }
      k += Character.charCount(m);
    }
    return paramString1.substring(paramInt1, paramInt2);
  }
  
  static String a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramString1, 0, paramString1.length(), paramString2, paramBoolean1, paramBoolean2);
  }
  
  private List<String> a(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      paramList = (String)localIterator.next();
      if (paramList != null) {}
      for (paramList = e(paramList);; paramList = null)
      {
        localArrayList.add(paramList);
        break;
      }
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  static void a(eo parameo, String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2)
    {
      int k = paramString.codePointAt(paramInt1);
      if ((k == 37) && (paramInt1 + 2 < paramInt2))
      {
        int m = a(paramString.charAt(paramInt1 + 1));
        int n = a(paramString.charAt(paramInt1 + 2));
        if ((m != -1) && (n != -1))
        {
          parameo.b((m << 4) + n);
          paramInt1 += 2;
        }
      }
      for (;;)
      {
        paramInt1 += Character.charCount(k);
        break;
        parameo.a(k);
      }
    }
  }
  
  static void a(eo parameo, String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
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
        if ((paramBoolean2) && (k == 43))
        {
          if (paramBoolean1) {}
          for (localObject2 = "%20";; localObject2 = "%2B")
          {
            parameo.a((String)localObject2);
            localObject3 = localObject1;
            break;
          }
        }
        if ((k < 32) || (k >= 127) || (paramString2.indexOf(k) != -1) || ((k == 37) && (!paramBoolean1)))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new eo();
          }
          ((eo)localObject2).a(k);
          for (;;)
          {
            localObject3 = localObject2;
            if (((eo)localObject2).f()) {
              break;
            }
            int m = ((eo)localObject2).h() & 0xFF;
            parameo.b(37);
            parameo.b(a[(m >> 4 & 0xF)]);
            parameo.b(a[(m & 0xF)]);
          }
        }
        parameo.a(k);
        localObject3 = localObject1;
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
  
  private static int b(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    for (;;)
    {
      int k = paramInt2;
      if (paramInt1 < paramInt2)
      {
        if (paramString2.indexOf(paramString1.charAt(paramInt1)) != -1) {
          k = paramInt1;
        }
      }
      else {
        return k;
      }
      paramInt1 += 1;
    }
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
  
  public static bc d(String paramString)
  {
    return new a().a(null, paramString);
  }
  
  static String e(String paramString)
  {
    return a(paramString, 0, paramString.length());
  }
  
  public URL a()
  {
    try
    {
      URL localURL = new URL(this.j);
      return localURL;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      throw new RuntimeException(localMalformedURLException);
    }
  }
  
  public URI b()
  {
    try
    {
      URI localURI = new URI(this.j);
      return localURI;
    }
    catch (URISyntaxException localURISyntaxException)
    {
      throw new IllegalStateException("not valid as a java.net.URI: " + this.j);
    }
  }
  
  public bc c(String paramString)
  {
    return new a().a(this, paramString);
  }
  
  public String c()
  {
    return this.b;
  }
  
  public boolean d()
  {
    return this.b.equals("https");
  }
  
  public String e()
  {
    if (this.c.length() == 0) {
      return "";
    }
    int k = this.b.length() + 3;
    int m = b(this.j, k, this.j.length(), ":@");
    return this.j.substring(k, m);
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof bc)) && (((bc)paramObject).j.equals(this.j));
  }
  
  public String f()
  {
    if (this.d.isEmpty()) {
      return "";
    }
    int k = this.j.indexOf(':', this.b.length() + 3);
    int m = this.j.indexOf('@');
    return this.j.substring(k + 1, m);
  }
  
  public String g()
  {
    return this.e;
  }
  
  public int h()
  {
    return this.f;
  }
  
  public int hashCode()
  {
    return this.j.hashCode();
  }
  
  public String i()
  {
    int k = this.j.indexOf('/', this.b.length() + 3);
    int m = b(this.j, k, this.j.length(), "?#");
    return this.j.substring(k, m);
  }
  
  public List<String> j()
  {
    int k = this.j.indexOf('/', this.b.length() + 3);
    int m = b(this.j, k, this.j.length(), "?#");
    ArrayList localArrayList = new ArrayList();
    while (k < m)
    {
      int n = k + 1;
      k = b(this.j, n, m, "/");
      localArrayList.add(this.j.substring(n, k));
    }
    return localArrayList;
  }
  
  public String k()
  {
    if (this.h == null) {
      return null;
    }
    int k = this.j.indexOf('?') + 1;
    int m = b(this.j, k + 1, this.j.length(), "#");
    return this.j.substring(k, m);
  }
  
  public String l()
  {
    if (this.h == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    b(localStringBuilder, this.h);
    return localStringBuilder.toString();
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
      eo localeo = new eo();
      i = i1;
      while (i < paramArrayOfByte.length) {
        if (i == k)
        {
          localeo.b(58);
          m = i + j;
          i = m;
          if (m == 16)
          {
            localeo.b(58);
            i = m;
          }
        }
        else
        {
          if (i > 0) {
            localeo.b(58);
          }
          localeo.h((paramArrayOfByte[i] & 0xFF) << 8 | paramArrayOfByte[(i + 1)] & 0xFF);
          i += 2;
        }
      }
      return localeo.o();
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
        i = bc.a(paramString, paramInt1, paramInt2, "/\\");
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
      paramString = bc.a(paramString, paramInt1, paramInt2, " \"<>^`{}|/\\?#", paramBoolean2, false);
      if (d(paramString)) {}
      for (;;)
      {
        return;
        if (e(paramString))
        {
          c();
          return;
        }
        if (((String)this.f.get(this.f.size() - 1)).length() == 0) {
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
    
    private int b(String paramString, int paramInt1, int paramInt2)
    {
      for (;;)
      {
        int i = paramInt2;
        if (paramInt1 < paramInt2) {}
        switch (paramString.charAt(paramInt1))
        {
        default: 
          i = paramInt1;
          return i;
        }
        paramInt1 += 1;
      }
    }
    
    private int c(String paramString, int paramInt1, int paramInt2)
    {
      paramInt2 -= 1;
      for (;;)
      {
        int i = paramInt1;
        if (paramInt2 >= paramInt1) {}
        switch (paramString.charAt(paramInt2))
        {
        default: 
          i = paramInt2 + 1;
          return i;
        }
        paramInt2 -= 1;
      }
    }
    
    private void c()
    {
      if ((((String)this.f.remove(this.f.size() - 1)).length() == 0) && (this.f.size() != 0))
      {
        this.f.set(this.f.size() - 1, "");
        return;
      }
      this.f.add("");
    }
    
    private static int d(String paramString, int paramInt1, int paramInt2)
    {
      if (paramInt2 - paramInt1 < 2) {}
      int i;
      label103:
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
              if (((i < 97) || (i > 122)) && ((i < 65) || (i > 90)) && (i != 43) && (i != 45) && (i != 46)) {
                break label103;
              }
              paramInt1 += 1;
            }
          }
        }
      } while (i != 58);
      return paramInt1;
    }
    
    private boolean d(String paramString)
    {
      return (paramString.equals(".")) || (paramString.equalsIgnoreCase("%2e"));
    }
    
    private static int e(String paramString, int paramInt1, int paramInt2)
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
    
    private boolean e(String paramString)
    {
      return (paramString.equals("..")) || (paramString.equalsIgnoreCase("%2e.")) || (paramString.equalsIgnoreCase(".%2e")) || (paramString.equalsIgnoreCase("%2e%2e"));
    }
    
    private static int f(String paramString, int paramInt1, int paramInt2)
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
    
    private static String f(String paramString)
    {
      try
      {
        paramString = IDN.toASCII(paramString).toLowerCase(Locale.US);
        int i = paramString.length();
        if (i == 0) {
          return null;
        }
        return paramString;
      }
      catch (IllegalArgumentException paramString) {}
      return null;
    }
    
    private static String g(String paramString, int paramInt1, int paramInt2)
    {
      paramString = bc.a(paramString, paramInt1, paramInt2);
      if ((paramString.startsWith("[")) && (paramString.endsWith("]")))
      {
        paramString = h(paramString, 1, paramString.length() - 1);
        if (paramString != null) {}
      }
      do
      {
        do
        {
          return null;
          paramString = paramString.getAddress();
          if (paramString.length == 16) {
            return a(paramString);
          }
          throw new AssertionError();
          paramString = f(paramString);
        } while (paramString == null);
        paramInt1 = paramString.length();
      } while (bc.a(paramString, 0, paramInt1, "\000\t\n\r #%/:?@[\\]") != paramInt1);
      return paramString;
    }
    
    private static InetAddress h(String paramString, int paramInt1, int paramInt2)
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
            k = bc.a(paramString.charAt(i));
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
    
    private static int i(String paramString, int paramInt1, int paramInt2)
    {
      try
      {
        paramInt1 = Integer.parseInt(bc.a(paramString, paramInt1, paramInt2, "", false, false));
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
      return bc.a(this.a);
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
    
    bc a(bc parambc, String paramString)
    {
      int i = b(paramString, 0, paramString.length());
      int i1 = c(paramString, i, paramString.length());
      label68:
      int k;
      label123:
      int n;
      if (d(paramString, i, i1) != -1) {
        if (paramString.regionMatches(true, i, "https:", 0, 6))
        {
          this.a = "https";
          i += "https:".length();
          m = e(paramString, i, i1);
          if ((m < 2) && (parambc != null) && (bc.a(parambc).equals(this.a))) {
            break label676;
          }
          k = 0;
          j = 0;
          m = i + m;
          i = k;
          k = m;
          n = bc.a(paramString, k, i1, "@/\\?#");
          if (n == i1) {
            break label293;
          }
        }
      }
      label293:
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
          break label123;
          if (paramString.regionMatches(true, i, "http:", 0, 5))
          {
            this.a = "http";
            i += "http:".length();
            break label68;
          }
          return null;
          if (parambc != null)
          {
            this.a = bc.a(parambc);
            break label68;
          }
          return null;
        }
      }
      if (i == 0)
      {
        m = bc.a(paramString, k, n, ":");
        String str = bc.a(paramString, k, m, " \"':;<=>@[]^`{}|/\\?#", true, false);
        parambc = str;
        if (j != 0) {
          parambc = this.b + "%40" + str;
        }
        this.b = parambc;
        if (m != n)
        {
          i = 1;
          this.c = bc.a(paramString, m + 1, n, " \"':;<=>@[]^`{}|/\\?#", true, false);
        }
        j = 1;
      }
      for (;;)
      {
        m = n + 1;
        k = i;
        i = m;
        break;
        this.c = (this.c + "%40" + bc.a(paramString, k, n, " \"':;<=>@[]^`{}|/\\?#", true, false));
      }
      i = f(paramString, k, n);
      if (i + 1 < n)
      {
        this.d = g(paramString, k, i);
        this.e = i(paramString, i + 1, n);
        if (this.e == -1) {
          return null;
        }
      }
      else
      {
        this.d = g(paramString, k, i);
        this.e = bc.a(this.a);
      }
      if (this.d == null) {
        return null;
      }
      int j = n;
      i = bc.a(paramString, j, i1, "?#");
      a(paramString, j, i);
      if ((i < i1) && (paramString.charAt(i) == '?'))
      {
        j = bc.a(paramString, i, i1, "#");
        this.g = bc.b(bc.a(paramString, i + 1, j, " \"'<>#", true, true));
        i = j;
      }
      for (;;)
      {
        if ((i < i1) && (paramString.charAt(i) == '#')) {
          this.h = bc.a(paramString, i + 1, i1, "", true, false);
        }
        return b();
        label676:
        this.b = parambc.e();
        this.c = parambc.f();
        this.d = bc.b(parambc);
        this.e = bc.c(parambc);
        this.f.clear();
        this.f.addAll(parambc.j());
        if (i != i1)
        {
          j = i;
          if (paramString.charAt(i) != '#') {
            break;
          }
        }
        c(parambc.k());
        j = i;
        break;
      }
    }
    
    public a b(String paramString)
    {
      if (paramString == null) {
        throw new IllegalArgumentException("host == null");
      }
      String str = g(paramString, 0, paramString.length());
      if (str == null) {
        throw new IllegalArgumentException("unexpected host: " + paramString);
      }
      this.d = str;
      return this;
    }
    
    public bc b()
    {
      if (this.a == null) {
        throw new IllegalStateException("scheme == null");
      }
      if (this.d == null) {
        throw new IllegalStateException("host == null");
      }
      return new bc(this, null);
    }
    
    public a c(String paramString)
    {
      if (paramString != null) {}
      for (paramString = bc.b(bc.a(paramString, " \"'<>#", true, true));; paramString = null)
      {
        this.g = paramString;
        return this;
      }
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a);
      localStringBuilder.append("://");
      if ((this.b.length() != 0) || (!this.c.isEmpty()))
      {
        localStringBuilder.append(this.b);
        if (this.c.length() != 0)
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
        if (i != bc.a(this.a))
        {
          localStringBuilder.append(':');
          localStringBuilder.append(i);
        }
        bc.a(localStringBuilder, this.f);
        if (this.g != null)
        {
          localStringBuilder.append('?');
          bc.b(localStringBuilder, this.g);
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
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */