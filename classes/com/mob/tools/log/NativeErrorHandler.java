package com.mob.tools.log;

import android.content.Context;
import com.mob.tools.b.g;
import com.mob.tools.e;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class NativeErrorHandler
{
  private static final boolean a;
  
  static
  {
    boolean bool = false;
    try
    {
      System.loadLibrary("neh");
      bool = true;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
    a = bool;
  }
  
  private static String a(String paramString, a parama)
  {
    paramString = new File(paramString, "." + parama.a);
    if (!paramString.exists()) {
      return "";
    }
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(paramString)));
    parama = new LinkedList();
    for (paramString = localBufferedReader.readLine(); paramString != null; paramString = localBufferedReader.readLine())
    {
      parama.add(paramString);
      if (parama.size() > 100) {
        parama.remove(0);
      }
    }
    localBufferedReader.close();
    paramString = new StringBuffer();
    parama = parama.iterator();
    while (parama.hasNext()) {
      paramString.append((String)parama.next()).append('\n');
    }
    if (paramString.length() > 0) {
      return paramString.substring(0, paramString.length() - 1);
    }
    return "";
  }
  
  private static void a(String paramString)
  {
    try
    {
      Iterator localIterator = b(paramString).iterator();
      while (localIterator.hasNext())
      {
        String str = a(paramString, (a)localIterator.next());
        e.a().nativeCrashLog(str);
      }
      g.a(new File(paramString));
    }
    catch (Throwable paramString)
    {
      e.a().w(paramString);
      return;
    }
  }
  
  public static boolean a(Context paramContext)
  {
    if (a)
    {
      paramContext = b(paramContext);
      a(paramContext);
      nativePrepare(paramContext);
    }
    return a;
  }
  
  private static String b(Context paramContext)
  {
    paramContext = new File(g.b(paramContext), "NativeCrashLogs");
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    return paramContext.getAbsolutePath();
  }
  
  private static ArrayList<a> b(String paramString)
  {
    paramString = new File(paramString, ".ncl");
    if (!paramString.exists()) {
      return new ArrayList();
    }
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(paramString)));
    ArrayList localArrayList = new ArrayList();
    paramString = localBufferedReader.readLine();
    while (paramString != null)
    {
      String[] arrayOfString = paramString.split(",");
      if (arrayOfString.length >= 2)
      {
        paramString = new a(null);
        paramString.a = g.e(arrayOfString[0]);
        paramString.b = g.d(arrayOfString[1]);
        localArrayList.add(paramString);
        paramString = localBufferedReader.readLine();
      }
    }
    localBufferedReader.close();
    return localArrayList;
  }
  
  private static native void nativePrepare(String paramString);
  
  private static class a
  {
    public long a;
    public int b;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\mob\tools\log\NativeErrorHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */