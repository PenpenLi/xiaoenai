package b;

import b.a.b.h;
import b.a.j;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class q
{
  private static final Pattern a = Pattern.compile("(\\d{2,4})[^\\d]*");
  private static final Pattern b = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
  private static final Pattern c = Pattern.compile("(\\d{1,2})[^\\d]*");
  private static final Pattern d = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
  private final String e;
  private final String f;
  private final long g;
  private final String h;
  private final String i;
  private final boolean j;
  private final boolean k;
  private final boolean l;
  private final boolean m;
  
  private q(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.e = paramString1;
    this.f = paramString2;
    this.g = paramLong;
    this.h = paramString3;
    this.i = paramString4;
    this.j = paramBoolean1;
    this.k = paramBoolean2;
    this.m = paramBoolean3;
    this.l = paramBoolean4;
  }
  
  private static int a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    for (;;)
    {
      int n = paramInt2;
      if (paramInt1 < paramInt2)
      {
        n = paramString.charAt(paramInt1);
        if (((n >= 32) || (n == 9)) && (n < 127) && ((n < 48) || (n > 57)) && ((n < 97) || (n > 122)) && ((n < 65) || (n > 90)) && (n != 58)) {
          break label108;
        }
        n = 1;
        if (paramBoolean) {
          break label114;
        }
      }
      label108:
      label114:
      for (int i1 = 1;; i1 = 0)
      {
        if (n != i1) {
          break label120;
        }
        n = paramInt1;
        return n;
        n = 0;
        break;
      }
      label120:
      paramInt1 += 1;
    }
  }
  
  private static long a(String paramString)
  {
    try
    {
      l1 = Long.parseLong(paramString);
      if (l1 > 0L) {
        break label15;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      long l1;
      label15:
      while (paramString.matches("-?\\d+")) {
        if (!paramString.startsWith("-")) {
          return Long.MAX_VALUE;
        }
      }
      throw localNumberFormatException;
    }
    return Long.MIN_VALUE;
    return l1;
  }
  
  private static long a(String paramString, int paramInt1, int paramInt2)
  {
    int i5 = a(paramString, paramInt1, paramInt2, false);
    int n = -1;
    int i2 = -1;
    int i4 = -1;
    int i1 = -1;
    int i3 = -1;
    paramInt1 = -1;
    Matcher localMatcher = d.matcher(paramString);
    if (i5 < paramInt2)
    {
      int i11 = a(paramString, i5 + 1, paramInt2, true);
      localMatcher.region(i5, i11);
      int i6;
      int i8;
      int i10;
      int i9;
      int i7;
      if ((n == -1) && (localMatcher.usePattern(d).matches()))
      {
        i6 = Integer.parseInt(localMatcher.group(1));
        i8 = Integer.parseInt(localMatcher.group(2));
        i10 = Integer.parseInt(localMatcher.group(3));
        i9 = i1;
        i7 = i3;
        i5 = paramInt1;
      }
      for (;;)
      {
        i11 = a(paramString, i11 + 1, paramInt2, false);
        paramInt1 = i5;
        i3 = i7;
        i1 = i9;
        i4 = i10;
        i2 = i8;
        n = i6;
        i5 = i11;
        break;
        if ((i1 == -1) && (localMatcher.usePattern(c).matches()))
        {
          i9 = Integer.parseInt(localMatcher.group(1));
          i5 = paramInt1;
          i7 = i3;
          i10 = i4;
          i8 = i2;
          i6 = n;
        }
        else if ((i3 == -1) && (localMatcher.usePattern(b).matches()))
        {
          String str = localMatcher.group(1).toLowerCase(Locale.US);
          i7 = b.pattern().indexOf(str) / 4;
          i5 = paramInt1;
          i9 = i1;
          i10 = i4;
          i8 = i2;
          i6 = n;
        }
        else
        {
          i5 = paramInt1;
          i7 = i3;
          i9 = i1;
          i10 = i4;
          i8 = i2;
          i6 = n;
          if (paramInt1 == -1)
          {
            i5 = paramInt1;
            i7 = i3;
            i9 = i1;
            i10 = i4;
            i8 = i2;
            i6 = n;
            if (localMatcher.usePattern(a).matches())
            {
              i5 = Integer.parseInt(localMatcher.group(1));
              i7 = i3;
              i9 = i1;
              i10 = i4;
              i8 = i2;
              i6 = n;
            }
          }
        }
      }
    }
    paramInt2 = paramInt1;
    if (paramInt1 >= 70)
    {
      paramInt2 = paramInt1;
      if (paramInt1 <= 99) {
        paramInt2 = paramInt1 + 1900;
      }
    }
    paramInt1 = paramInt2;
    if (paramInt2 >= 0)
    {
      paramInt1 = paramInt2;
      if (paramInt2 <= 69) {
        paramInt1 = paramInt2 + 2000;
      }
    }
    if (paramInt1 < 1601) {
      throw new IllegalArgumentException();
    }
    if (i3 == -1) {
      throw new IllegalArgumentException();
    }
    if ((i1 < 1) || (i1 > 31)) {
      throw new IllegalArgumentException();
    }
    if ((n < 0) || (n > 23)) {
      throw new IllegalArgumentException();
    }
    if ((i2 < 0) || (i2 > 59)) {
      throw new IllegalArgumentException();
    }
    if ((i4 < 0) || (i4 > 59)) {
      throw new IllegalArgumentException();
    }
    paramString = new GregorianCalendar(j.d);
    paramString.setLenient(false);
    paramString.set(1, paramInt1);
    paramString.set(2, i3 - 1);
    paramString.set(5, i1);
    paramString.set(11, n);
    paramString.set(12, i2);
    paramString.set(13, i4);
    paramString.set(14, 0);
    return paramString.getTimeInMillis();
  }
  
  static q a(long paramLong, ab paramab, String paramString)
  {
    int i1 = paramString.length();
    int n = j.a(paramString, 0, i1, ';');
    int i2 = j.a(paramString, 0, n, '=');
    if (i2 == n) {
      return null;
    }
    String str3 = j.c(paramString, 0, i2);
    if (str3.isEmpty()) {
      return null;
    }
    String str4 = j.c(paramString, i2 + 1, n);
    long l1 = 253402300799999L;
    long l2 = -1L;
    Object localObject1 = null;
    Object localObject2 = null;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = true;
    boolean bool1 = false;
    n += 1;
    String str5;
    String str1;
    if (n < i1)
    {
      i2 = j.a(paramString, n, i1, ';');
      int i3 = j.a(paramString, n, i2, '=');
      str5 = j.c(paramString, n, i3);
      if (i3 < i2)
      {
        str1 = j.c(paramString, i3 + 1, i2);
        label162:
        if (!str5.equalsIgnoreCase("expires")) {
          break label213;
        }
      }
    }
    for (;;)
    {
      long l3;
      try
      {
        l3 = a(str1, 0, str1.length());
        bool1 = true;
        l1 = l3;
      }
      catch (IllegalArgumentException localIllegalArgumentException1)
      {
        continue;
      }
      n = i2 + 1;
      break;
      str1 = "";
      break label162;
      label213:
      if (str5.equalsIgnoreCase("max-age"))
      {
        try
        {
          l3 = a(localIllegalArgumentException1);
          l2 = l3;
          bool1 = true;
        }
        catch (NumberFormatException localNumberFormatException) {}
      }
      else if (str5.equalsIgnoreCase("domain"))
      {
        try
        {
          String str2 = b(localNumberFormatException);
          localObject1 = str2;
          bool2 = false;
        }
        catch (IllegalArgumentException localIllegalArgumentException2) {}
      }
      else if (str5.equalsIgnoreCase("path"))
      {
        localObject2 = localIllegalArgumentException2;
      }
      else if (str5.equalsIgnoreCase("secure"))
      {
        bool4 = true;
      }
      else if (str5.equalsIgnoreCase("httponly"))
      {
        bool3 = true;
        continue;
        if (l2 == Long.MIN_VALUE) {
          paramLong = Long.MIN_VALUE;
        }
        for (;;)
        {
          if (localObject1 == null)
          {
            paramString = paramab.f();
            label349:
            if ((localObject2 != null) && (((String)localObject2).startsWith("/"))) {
              break label499;
            }
            paramab = paramab.h();
            n = paramab.lastIndexOf('/');
            if (n == 0) {
              break label493;
            }
            paramab = paramab.substring(0, n);
          }
          for (;;)
          {
            return new q(str3, str4, paramLong, paramString, paramab, bool4, bool3, bool2, bool1);
            if (l2 == -1L) {
              break label505;
            }
            if (l2 <= 9223372036854775L) {}
            for (l1 = l2 * 1000L;; l1 = Long.MAX_VALUE)
            {
              l1 += paramLong;
              if (l1 >= paramLong)
              {
                paramLong = l1;
                if (l1 <= 253402300799999L) {
                  break;
                }
              }
              paramLong = 253402300799999L;
              break;
            }
            paramString = (String)localObject1;
            if (b(paramab, (String)localObject1)) {
              break label349;
            }
            return null;
            label493:
            paramab = "/";
            continue;
            label499:
            paramab = (ab)localObject2;
          }
          label505:
          paramLong = l1;
        }
      }
    }
  }
  
  public static q a(ab paramab, String paramString)
  {
    return a(System.currentTimeMillis(), paramab, paramString);
  }
  
  public static List<q> a(ab paramab, z paramz)
  {
    List localList = paramz.c("Set-Cookie");
    paramz = null;
    int i1 = localList.size();
    int n = 0;
    q localq;
    while (n < i1)
    {
      localq = a(paramab, (String)localList.get(n));
      if (localq == null)
      {
        n += 1;
      }
      else
      {
        if (paramz != null) {
          break label92;
        }
        paramz = new ArrayList();
      }
    }
    label92:
    for (;;)
    {
      paramz.add(localq);
      break;
      if (paramz != null) {
        return Collections.unmodifiableList(paramz);
      }
      return Collections.emptyList();
    }
  }
  
  private static String b(String paramString)
  {
    if (paramString.endsWith(".")) {
      throw new IllegalArgumentException();
    }
    String str = paramString;
    if (paramString.startsWith(".")) {
      str = paramString.substring(1);
    }
    paramString = j.a(str);
    if (paramString == null) {
      throw new IllegalArgumentException();
    }
    return paramString;
  }
  
  private static boolean b(ab paramab, String paramString)
  {
    paramab = paramab.f();
    if (paramab.equals(paramString)) {}
    while ((paramab.endsWith(paramString)) && (paramab.charAt(paramab.length() - paramString.length() - 1) == '.') && (!j.b(paramab))) {
      return true;
    }
    return false;
  }
  
  public String a()
  {
    return this.e;
  }
  
  public String b()
  {
    return this.f;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof q)) {}
    do
    {
      return false;
      paramObject = (q)paramObject;
    } while ((!((q)paramObject).e.equals(this.e)) || (!((q)paramObject).f.equals(this.f)) || (!((q)paramObject).h.equals(this.h)) || (!((q)paramObject).i.equals(this.i)) || (((q)paramObject).g != this.g) || (((q)paramObject).j != this.j) || (((q)paramObject).k != this.k) || (((q)paramObject).l != this.l) || (((q)paramObject).m != this.m));
    return true;
  }
  
  public int hashCode()
  {
    int i3 = 0;
    int i4 = this.e.hashCode();
    int i5 = this.f.hashCode();
    int i6 = this.h.hashCode();
    int i7 = this.i.hashCode();
    int i8 = (int)(this.g ^ this.g >>> 32);
    int n;
    int i1;
    label72:
    int i2;
    if (this.j)
    {
      n = 0;
      if (!this.k) {
        break label145;
      }
      i1 = 0;
      if (!this.l) {
        break label150;
      }
      i2 = 0;
      label81:
      if (!this.m) {
        break label155;
      }
    }
    for (;;)
    {
      return (i2 + (i1 + (n + (((((i4 + 527) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8) * 31) * 31) * 31) * 31 + i3;
      n = 1;
      break;
      label145:
      i1 = 1;
      break label72;
      label150:
      i2 = 1;
      break label81;
      label155:
      i3 = 1;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.e);
    localStringBuilder.append('=');
    localStringBuilder.append(this.f);
    if (this.l)
    {
      if (this.g != Long.MIN_VALUE) {
        break label131;
      }
      localStringBuilder.append("; max-age=0");
    }
    for (;;)
    {
      if (!this.m) {
        localStringBuilder.append("; domain=").append(this.h);
      }
      localStringBuilder.append("; path=").append(this.i);
      if (this.j) {
        localStringBuilder.append("; secure");
      }
      if (this.k) {
        localStringBuilder.append("; httponly");
      }
      return localStringBuilder.toString();
      label131:
      localStringBuilder.append("; expires=").append(h.a(new Date(this.g)));
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\b\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */