package com.alipay.security.mobile.module.a;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class c
{
  private static String a = "";
  private static String b = "";
  private static String c = "";
  
  public static void a(String paramString)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramString);
      a(localArrayList);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      a = paramString1;
      b = paramString2;
      c = paramString3;
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public static void a(Throwable paramThrowable)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(b(paramThrowable));
      a(localArrayList);
      return;
    }
    finally
    {
      paramThrowable = finally;
      throw paramThrowable;
    }
  }
  
  private static void a(List<String> paramList)
  {
    StringBuffer localStringBuffer;
    try
    {
      if (!a.a(b))
      {
        boolean bool = a.a(c);
        if (!bool) {}
      }
      else
      {
        return;
      }
      localStringBuffer = new StringBuffer();
      localStringBuffer.append(c);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        localStringBuffer.append(", " + str);
      }
      localStringBuffer.append("\n");
    }
    finally {}
    for (;;)
    {
      try
      {
        paramList = new File(a);
        if (!paramList.exists()) {
          paramList.mkdirs();
        }
        paramList = new File(a, b);
        if (!paramList.exists()) {
          paramList.createNewFile();
        }
        if (paramList.length() + localStringBuffer.length() > 51200L) {
          break label210;
        }
        paramList = new FileWriter(paramList, true);
        paramList.write(localStringBuffer.toString());
        paramList.flush();
        paramList.close();
      }
      catch (Exception paramList)
      {
        paramList.toString();
      }
      break;
      label210:
      paramList = new FileWriter(paramList);
    }
  }
  
  public static String b(Throwable paramThrowable)
  {
    if (paramThrowable != null)
    {
      StringWriter localStringWriter = new StringWriter();
      paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
      return localStringWriter.toString();
    }
    return "";
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\security\mobile\module\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */