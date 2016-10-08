package a.a.a.c;

import a.a.a.g;

public class d
{
  private static final char[] a = "0123456789ABCDEF".toCharArray();
  
  public static String a(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    paramString1 = new StringBuilder(paramString1);
    paramString1.append('"').append(paramString2).append('"').append(" (");
    a(paramString1, paramArrayOfString);
    paramString1.append(") VALUES (");
    a(paramString1, paramArrayOfString.length);
    paramString1.append(')');
    return paramString1.toString();
  }
  
  public static String a(String paramString1, String paramString2, String[] paramArrayOfString, boolean paramBoolean)
  {
    if ((paramString2 == null) || (paramString2.length() < 0)) {
      throw new a.a.a.d("Table alias required");
    }
    if (paramBoolean) {}
    for (Object localObject = "SELECT DISTINCT ";; localObject = "SELECT ")
    {
      localObject = new StringBuilder((String)localObject);
      a((StringBuilder)localObject, paramString2, paramArrayOfString).append(" FROM ");
      ((StringBuilder)localObject).append('"').append(paramString1).append('"').append(' ').append(paramString2).append(' ');
      return ((StringBuilder)localObject).toString();
    }
  }
  
  public static String a(String paramString, String[] paramArrayOfString)
  {
    paramString = '"' + paramString + '"';
    StringBuilder localStringBuilder = new StringBuilder("DELETE FROM ");
    localStringBuilder.append(paramString);
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      localStringBuilder.append(" WHERE ");
      b(localStringBuilder, paramString, paramArrayOfString);
    }
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    paramString = '"' + paramString + '"';
    StringBuilder localStringBuilder = new StringBuilder("UPDATE ");
    localStringBuilder.append(paramString).append(" SET ");
    b(localStringBuilder, paramArrayOfString1);
    localStringBuilder.append(" WHERE ");
    b(localStringBuilder, paramString, paramArrayOfString2);
    return localStringBuilder.toString();
  }
  
  public static StringBuilder a(StringBuilder paramStringBuilder, int paramInt)
  {
    int i = 0;
    if (i < paramInt)
    {
      if (i < paramInt - 1) {
        paramStringBuilder.append("?,");
      }
      for (;;)
      {
        i += 1;
        break;
        paramStringBuilder.append('?');
      }
    }
    return paramStringBuilder;
  }
  
  public static StringBuilder a(StringBuilder paramStringBuilder, String paramString)
  {
    paramStringBuilder.append('"').append(paramString).append('"');
    return paramStringBuilder;
  }
  
  public static StringBuilder a(StringBuilder paramStringBuilder, String paramString, g paramg)
  {
    if (paramString != null) {
      paramStringBuilder.append(paramString).append('.');
    }
    paramStringBuilder.append('"').append(paramg.e).append('"');
    return paramStringBuilder;
  }
  
  public static StringBuilder a(StringBuilder paramStringBuilder, String paramString1, String paramString2)
  {
    paramStringBuilder.append(paramString1).append(".\"").append(paramString2).append('"');
    return paramStringBuilder;
  }
  
  public static StringBuilder a(StringBuilder paramStringBuilder, String paramString, String[] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      a(paramStringBuilder, paramString, paramArrayOfString[i]);
      if (i < j - 1) {
        paramStringBuilder.append(',');
      }
      i += 1;
    }
    return paramStringBuilder;
  }
  
  public static StringBuilder a(StringBuilder paramStringBuilder, String[] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      paramStringBuilder.append('"').append(paramArrayOfString[i]).append('"');
      if (i < j - 1) {
        paramStringBuilder.append(',');
      }
      i += 1;
    }
    return paramStringBuilder;
  }
  
  public static StringBuilder b(StringBuilder paramStringBuilder, String paramString, String[] paramArrayOfString)
  {
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      a(paramStringBuilder, paramString, paramArrayOfString[i]).append("=?");
      if (i < paramArrayOfString.length - 1) {
        paramStringBuilder.append(',');
      }
      i += 1;
    }
    return paramStringBuilder;
  }
  
  public static StringBuilder b(StringBuilder paramStringBuilder, String[] paramArrayOfString)
  {
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      a(paramStringBuilder, paramArrayOfString[i]).append("=?");
      if (i < paramArrayOfString.length - 1) {
        paramStringBuilder.append(',');
      }
      i += 1;
    }
    return paramStringBuilder;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\a\a\a\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */