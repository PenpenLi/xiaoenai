package com.google.gson.a.a.a;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class a
{
  private static final TimeZone a = TimeZone.getTimeZone("UTC");
  
  private static int a(String paramString, int paramInt)
  {
    while (paramInt < paramString.length())
    {
      int i = paramString.charAt(paramInt);
      if ((i < 48) || (i > 57)) {
        return paramInt;
      }
      paramInt += 1;
    }
    return paramString.length();
  }
  
  private static int a(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt2 > paramString.length()) || (paramInt1 > paramInt2)) {
      throw new NumberFormatException(paramString);
    }
    int i = 0;
    int j;
    if (paramInt1 < paramInt2)
    {
      j = paramInt1 + 1;
      i = Character.digit(paramString.charAt(paramInt1), 10);
      if (i < 0) {
        throw new NumberFormatException("Invalid number: " + paramString.substring(paramInt1, paramInt2));
      }
      i = -i;
    }
    for (;;)
    {
      if (j < paramInt2)
      {
        int k = Character.digit(paramString.charAt(j), 10);
        if (k < 0) {
          throw new NumberFormatException("Invalid number: " + paramString.substring(paramInt1, paramInt2));
        }
        i = i * 10 - k;
        j += 1;
      }
      else
      {
        return -i;
        j = paramInt1;
      }
    }
  }
  
  public static Date a(String paramString, ParsePosition paramParsePosition)
  {
    try
    {
      j = paramParsePosition.getIndex();
      i = j + 4;
      i2 = a(paramString, j, i);
      if (!a(paramString, i, '-')) {
        break label943;
      }
      i += 1;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      int i2;
      int i3;
      int i4;
      boolean bool;
      GregorianCalendar localGregorianCalendar;
      int i5;
      if (paramString != null) {
        break label827;
      }
      paramString = null;
      String str1 = localIndexOutOfBoundsException.getMessage();
      if (str1 == null) {
        break label425;
      }
      Object localObject2 = str1;
      if (!str1.isEmpty()) {
        break label457;
      }
      localObject2 = "(" + localIndexOutOfBoundsException.getClass().getName() + ")";
      paramString = new ParseException("Failed to parse date [" + paramString + "]: " + (String)localObject2, paramParsePosition.getIndex());
      paramString.initCause(localIndexOutOfBoundsException);
      throw paramString;
      j *= 10;
      break label946;
      j *= 100;
      break label946;
      c = paramString.charAt(i);
      if (c != 'Z') {
        break label973;
      }
      Object localObject1 = a;
      i += 1;
      String str2;
      do
      {
        do
        {
          for (;;)
          {
            localObject1 = new GregorianCalendar((TimeZone)localObject1);
            ((Calendar)localObject1).setLenient(false);
            ((Calendar)localObject1).set(1, i2);
            ((Calendar)localObject1).set(2, i3 - 1);
            ((Calendar)localObject1).set(5, i4);
            ((Calendar)localObject1).set(11, n);
            ((Calendar)localObject1).set(12, m);
            ((Calendar)localObject1).set(13, k);
            ((Calendar)localObject1).set(14, j);
            paramParsePosition.setIndex(i);
            return ((Calendar)localObject1).getTime();
            localObject1 = paramString.substring(i);
            i1 = i + ((String)localObject1).length();
            if ((!"+0000".equals(localObject1)) && (!"+00:00".equals(localObject1))) {
              break;
            }
            localObject1 = a;
            i = i1;
          }
          str1 = "GMT" + (String)localObject1;
          localObject2 = TimeZone.getTimeZone(str1);
          str2 = ((TimeZone)localObject2).getID();
          localObject1 = localObject2;
          i = i1;
        } while (str2.equals(str1));
        localObject1 = localObject2;
        i = i1;
      } while (str2.replace(":", "").equals(str1));
      throw new IndexOutOfBoundsException("Mismatching time zone indicator: " + str1 + " given, resolves to " + ((TimeZone)localObject2).getID());
      throw new IndexOutOfBoundsException("Invalid time zone indicator '" + c + "'");
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        char c;
        continue;
        paramString = '"' + paramString + "'";
        continue;
        int n = m;
        int m = i;
        int i = j;
        int i1 = k;
        int j = 0;
        int k = m;
        m = i1;
        continue;
        n = k;
        i1 = m;
        j = 0;
        k = 0;
        m = n;
        n = i1;
        continue;
        continue;
        i1 = 0;
        k = 0;
        m = 0;
        n = 0;
        i = j;
        j = i1;
        continue;
        i = j;
        continue;
        continue;
        n = m;
        m = i;
        i = i1;
        i1 = k;
        k = m;
        m = i1;
        continue;
        if (c != '+') {
          if (c != '-') {}
        }
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label425:
      label457:
      label827:
      label943:
      label946:
      label973:
      for (;;) {}
    }
    j = i + 2;
    i3 = a(paramString, i, j);
    if (a(paramString, j, '-'))
    {
      i = j + 1;
      j = i + 2;
      i4 = a(paramString, i, j);
      bool = a(paramString, j, 'T');
      if ((!bool) && (paramString.length() <= j))
      {
        localGregorianCalendar = new GregorianCalendar(i2, i3 - 1, i4);
        paramParsePosition.setIndex(j);
        return localGregorianCalendar.getTime();
      }
      if (bool)
      {
        j += 1;
        i = j + 2;
        m = a(paramString, j, i);
        if (a(paramString, i, ':'))
        {
          i += 1;
          j = i + 2;
          k = a(paramString, i, j);
          i = j;
          if (a(paramString, j, ':')) {
            i = j + 1;
          }
          if (paramString.length() > i)
          {
            j = paramString.charAt(i);
            if ((j != 90) && (j != 43) && (j != 45))
            {
              j = i + 2;
              n = a(paramString, i, j);
              i = n;
              if (n > 59)
              {
                i = n;
                if (n < 63) {
                  i = 59;
                }
              }
              if (a(paramString, j, '.'))
              {
                n = j + 1;
                i1 = a(paramString, n + 1);
                i5 = Math.min(i1, n + 3);
                j = a(paramString, n, i5);
                switch (i5 - n)
                {
                case 2: 
                  if (paramString.length() <= i) {
                    throw new IllegalArgumentException("No time zone indicator");
                  }
                  break;
                }
              }
            }
          }
        }
      }
    }
  }
  
  private static boolean a(String paramString, int paramInt, char paramChar)
  {
    return (paramInt < paramString.length()) && (paramString.charAt(paramInt) == paramChar);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\google\gson\a\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */