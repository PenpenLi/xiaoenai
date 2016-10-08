package org.cocos2dx.lib;

import android.app.Activity;
import android.content.res.AssetManager;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.KeyStore;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

public class Cocos2dxHttpURLConnection
{
  private static final String POST_METHOD = "POST";
  private static final String PUT_METHOD = "PUT";
  
  static void addRequestHeader(HttpURLConnection paramHttpURLConnection, String paramString1, String paramString2)
  {
    paramHttpURLConnection.setRequestProperty(paramString1, paramString2);
  }
  
  public static String combinCookies(List<String> paramList, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramList.iterator();
    paramList = "/";
    Object localObject1 = "FALSE";
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    while (localIterator.hasNext())
    {
      String[] arrayOfString1 = ((String)localIterator.next()).split(";");
      int j = arrayOfString1.length;
      int i = 0;
      Object localObject5 = localObject4;
      Object localObject6 = localObject3;
      localObject3 = localObject1;
      localObject4 = paramString;
      localObject1 = paramList;
      paramString = (String)localObject3;
      localObject3 = localObject2;
      localObject2 = localObject6;
      paramList = (List<String>)localObject5;
      if (i < j)
      {
        localObject5 = arrayOfString1[i];
        int k = ((String)localObject5).indexOf("=");
        Object localObject9;
        Object localObject8;
        String str;
        Object localObject7;
        if (-1 == k)
        {
          localObject9 = localObject4;
          localObject8 = localObject1;
          str = paramString;
          localObject7 = localObject3;
          localObject6 = localObject2;
          localObject5 = paramList;
        }
        for (;;)
        {
          i += 1;
          paramList = (List<String>)localObject5;
          localObject2 = localObject6;
          localObject3 = localObject7;
          paramString = str;
          localObject1 = localObject8;
          localObject4 = localObject9;
          break;
          String[] arrayOfString2 = new String[2];
          arrayOfString2[0] = ((String)localObject5).substring(0, k);
          arrayOfString2[1] = ((String)localObject5).substring(k + 1);
          if ("expires".equalsIgnoreCase(arrayOfString2[0].trim()))
          {
            localObject5 = str2Seconds(arrayOfString2[1].trim());
            localObject6 = localObject2;
            localObject7 = localObject3;
            str = paramString;
            localObject8 = localObject1;
            localObject9 = localObject4;
          }
          else if ("path".equalsIgnoreCase(arrayOfString2[0].trim()))
          {
            localObject8 = arrayOfString2[1];
            localObject5 = paramList;
            localObject6 = localObject2;
            localObject7 = localObject3;
            str = paramString;
            localObject9 = localObject4;
          }
          else if ("secure".equalsIgnoreCase(arrayOfString2[0].trim()))
          {
            str = arrayOfString2[1];
            localObject5 = paramList;
            localObject6 = localObject2;
            localObject7 = localObject3;
            localObject8 = localObject1;
            localObject9 = localObject4;
          }
          else if ("domain".equalsIgnoreCase(arrayOfString2[0].trim()))
          {
            localObject9 = arrayOfString2[1];
            localObject5 = paramList;
            localObject6 = localObject2;
            localObject7 = localObject3;
            str = paramString;
            localObject8 = localObject1;
          }
          else
          {
            localObject5 = paramList;
            localObject6 = localObject2;
            localObject7 = localObject3;
            str = paramString;
            localObject8 = localObject1;
            localObject9 = localObject4;
            if (!"version".equalsIgnoreCase(arrayOfString2[0].trim()))
            {
              localObject5 = paramList;
              localObject6 = localObject2;
              localObject7 = localObject3;
              str = paramString;
              localObject8 = localObject1;
              localObject9 = localObject4;
              if (!"max-age".equalsIgnoreCase(arrayOfString2[0].trim()))
              {
                localObject7 = arrayOfString2[0];
                localObject6 = arrayOfString2[1];
                localObject5 = paramList;
                str = paramString;
                localObject8 = localObject1;
                localObject9 = localObject4;
              }
            }
          }
        }
      }
      localObject5 = localObject4;
      if (localObject4 == null) {
        localObject5 = "none";
      }
      localStringBuilder.append((String)localObject5);
      localStringBuilder.append('\t');
      localStringBuilder.append("FALSE");
      localStringBuilder.append('\t');
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append('\t');
      localStringBuilder.append(paramString);
      localStringBuilder.append('\t');
      localStringBuilder.append(paramList);
      localStringBuilder.append("\t");
      localStringBuilder.append((String)localObject3);
      localStringBuilder.append("\t");
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append('\n');
      localObject6 = localObject1;
      localObject1 = localObject3;
      localObject4 = paramList;
      localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = paramString;
      paramList = (List<String>)localObject6;
      paramString = (String)localObject5;
    }
    return localStringBuilder.toString();
  }
  
  static int connect(HttpURLConnection paramHttpURLConnection)
  {
    try
    {
      paramHttpURLConnection.connect();
      return 0;
    }
    catch (IOException paramHttpURLConnection)
    {
      Log.e("cocos2d-x debug info", "come in connect");
      Log.e("cocos2d-x debug info", paramHttpURLConnection.toString());
    }
    return 1;
  }
  
  static HttpURLConnection createHttpURLConnection(String paramString)
  {
    try
    {
      paramString = (HttpURLConnection)new URL(paramString).openConnection();
      paramString.setRequestProperty("Accept-Encoding", "identity");
      paramString.setDoInput(true);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.e("URLConnection exception", paramString.toString());
    }
    return null;
  }
  
  static void disconnect(HttpURLConnection paramHttpURLConnection)
  {
    paramHttpURLConnection.disconnect();
  }
  
  static int getResponseCode(HttpURLConnection paramHttpURLConnection)
  {
    try
    {
      int i = paramHttpURLConnection.getResponseCode();
      return i;
    }
    catch (IOException paramHttpURLConnection)
    {
      Log.e("URLConnection exception", paramHttpURLConnection.toString());
    }
    return 0;
  }
  
  static byte[] getResponseContent(HttpURLConnection paramHttpURLConnection)
  {
    for (;;)
    {
      try
      {
        localObject3 = paramHttpURLConnection.getInputStream();
        str = paramHttpURLConnection.getContentEncoding();
        localObject1 = localObject3;
        if (str != null)
        {
          if (!str.equalsIgnoreCase("gzip")) {
            continue;
          }
          localObject1 = new GZIPInputStream(paramHttpURLConnection.getInputStream());
        }
      }
      catch (IOException localIOException)
      {
        Object localObject3;
        String str;
        Object localObject1;
        int i;
        localObject2 = paramHttpURLConnection.getErrorStream();
        continue;
      }
      catch (Exception paramHttpURLConnection)
      {
        Log.e("URLConnection exception", paramHttpURLConnection.toString());
        return null;
      }
      try
      {
        localObject3 = new byte['Ѐ'];
        paramHttpURLConnection = new ByteArrayOutputStream();
        i = ((InputStream)localObject1).read((byte[])localObject3, 0, 1024);
        if (i == -1) {
          break;
        }
        paramHttpURLConnection.write((byte[])localObject3, 0, i);
        continue;
        localObject1 = localObject3;
      }
      catch (Exception paramHttpURLConnection)
      {
        Log.e("URLConnection exception", paramHttpURLConnection.toString());
        return null;
      }
      if (str.equalsIgnoreCase("deflate")) {
        localObject1 = new InflaterInputStream(paramHttpURLConnection.getInputStream());
      }
    }
    Object localObject2 = paramHttpURLConnection.toByteArray();
    paramHttpURLConnection.close();
    return (byte[])localObject2;
  }
  
  static String getResponseHeaderByIdx(HttpURLConnection paramHttpURLConnection, int paramInt)
  {
    paramHttpURLConnection = paramHttpURLConnection.getHeaderFields();
    if (paramHttpURLConnection == null) {
      return null;
    }
    Object localObject = paramHttpURLConnection.entrySet().iterator();
    int i = 0;
    if (((Iterator)localObject).hasNext())
    {
      paramHttpURLConnection = (Map.Entry)((Iterator)localObject).next();
      if (i == paramInt)
      {
        localObject = (String)paramHttpURLConnection.getKey();
        if (localObject == null) {
          paramHttpURLConnection = listToString((List)paramHttpURLConnection.getValue(), ",") + "\n";
        }
      }
    }
    for (;;)
    {
      return paramHttpURLConnection;
      paramHttpURLConnection = (String)localObject + ":" + listToString((List)paramHttpURLConnection.getValue(), ",") + "\n";
      continue;
      i += 1;
      break;
      paramHttpURLConnection = null;
    }
  }
  
  static String getResponseHeaderByKey(HttpURLConnection paramHttpURLConnection, String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      localObject = paramHttpURLConnection.getHeaderFields();
    } while (localObject == null);
    Object localObject = ((Map)localObject).entrySet().iterator();
    Map.Entry localEntry;
    for (;;)
    {
      if (((Iterator)localObject).hasNext())
      {
        localEntry = (Map.Entry)((Iterator)localObject).next();
        if (paramString.equalsIgnoreCase((String)localEntry.getKey())) {
          if ("set-cookie".equalsIgnoreCase(paramString)) {
            paramHttpURLConnection = combinCookies((List)localEntry.getValue(), paramHttpURLConnection.getURL().getHost());
          }
        }
      }
    }
    for (;;)
    {
      return paramHttpURLConnection;
      paramHttpURLConnection = listToString((List)localEntry.getValue(), ",");
      continue;
      paramHttpURLConnection = null;
    }
  }
  
  static int getResponseHeaderByKeyInt(HttpURLConnection paramHttpURLConnection, String paramString)
  {
    paramHttpURLConnection = paramHttpURLConnection.getHeaderField(paramString);
    if (paramHttpURLConnection == null) {
      return 0;
    }
    return Integer.parseInt(paramHttpURLConnection);
  }
  
  static String getResponseHeaders(HttpURLConnection paramHttpURLConnection)
  {
    paramHttpURLConnection = paramHttpURLConnection.getHeaderFields();
    if (paramHttpURLConnection == null) {
      localObject = null;
    }
    Iterator localIterator;
    do
    {
      return (String)localObject;
      localIterator = paramHttpURLConnection.entrySet().iterator();
      paramHttpURLConnection = "";
      localObject = paramHttpURLConnection;
    } while (!localIterator.hasNext());
    Object localObject = (Map.Entry)localIterator.next();
    String str = (String)((Map.Entry)localObject).getKey();
    if (str == null) {}
    for (paramHttpURLConnection = paramHttpURLConnection + listToString((List)((Map.Entry)localObject).getValue(), ",") + "\n";; paramHttpURLConnection = paramHttpURLConnection + str + ":" + listToString((List)((Map.Entry)localObject).getValue(), ",") + "\n") {
      break;
    }
  }
  
  static String getResponseMessage(HttpURLConnection paramHttpURLConnection)
  {
    try
    {
      paramHttpURLConnection = paramHttpURLConnection.getResponseMessage();
      return paramHttpURLConnection;
    }
    catch (IOException paramHttpURLConnection)
    {
      paramHttpURLConnection = paramHttpURLConnection.toString();
      Log.e("URLConnection exception", paramHttpURLConnection);
    }
    return paramHttpURLConnection;
  }
  
  public static String listToString(List<String> paramList, String paramString)
  {
    if (paramList == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramList.iterator();
    for (int i = 0; localIterator.hasNext(); i = 1)
    {
      String str = (String)localIterator.next();
      if (i != 0) {
        localStringBuilder.append(paramString);
      }
      paramList = str;
      if (str == null) {
        paramList = "";
      }
      localStringBuilder.append(paramList);
    }
    return localStringBuilder.toString();
  }
  
  static void sendRequest(HttpURLConnection paramHttpURLConnection, byte[] paramArrayOfByte)
  {
    try
    {
      paramHttpURLConnection = paramHttpURLConnection.getOutputStream();
      if (paramArrayOfByte != null)
      {
        paramHttpURLConnection.write(paramArrayOfByte);
        paramHttpURLConnection.flush();
      }
      paramHttpURLConnection.close();
      return;
    }
    catch (IOException paramHttpURLConnection)
    {
      Log.e("URLConnection exception", paramHttpURLConnection.toString());
    }
  }
  
  static void setReadAndConnectTimeout(HttpURLConnection paramHttpURLConnection, int paramInt1, int paramInt2)
  {
    paramHttpURLConnection.setReadTimeout(paramInt1);
    paramHttpURLConnection.setConnectTimeout(paramInt2);
  }
  
  static void setRequestMethod(HttpURLConnection paramHttpURLConnection, String paramString)
  {
    try
    {
      paramHttpURLConnection.setRequestMethod(paramString);
      if ((paramString.equalsIgnoreCase("POST")) || (paramString.equalsIgnoreCase("PUT"))) {
        paramHttpURLConnection.setDoOutput(true);
      }
      return;
    }
    catch (ProtocolException paramHttpURLConnection)
    {
      Log.e("URLConnection exception", paramHttpURLConnection.toString());
    }
  }
  
  static void setVerifySSL(HttpURLConnection paramHttpURLConnection, String paramString)
  {
    if (!(paramHttpURLConnection instanceof HttpsURLConnection)) {
      return;
    }
    HttpsURLConnection localHttpsURLConnection = (HttpsURLConnection)paramHttpURLConnection;
    for (;;)
    {
      try
      {
        if (paramString.startsWith("/"))
        {
          paramHttpURLConnection = new BufferedInputStream(new FileInputStream(paramString));
          paramString = CertificateFactory.getInstance("X.509").generateCertificate(paramHttpURLConnection);
          System.out.println("ca=" + ((X509Certificate)paramString).getSubjectDN());
          paramHttpURLConnection.close();
          paramHttpURLConnection = KeyStore.getInstance(KeyStore.getDefaultType());
          paramHttpURLConnection.load(null, null);
          paramHttpURLConnection.setCertificateEntry("ca", paramString);
          paramString = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
          paramString.init(paramHttpURLConnection);
          paramHttpURLConnection = SSLContext.getInstance("TLS");
          paramHttpURLConnection.init(null, paramString.getTrustManagers(), null);
          localHttpsURLConnection.setSSLSocketFactory(paramHttpURLConnection.getSocketFactory());
          return;
        }
      }
      catch (Exception paramHttpURLConnection)
      {
        Log.e("URLConnection exception", paramHttpURLConnection.toString());
        return;
      }
      paramHttpURLConnection = paramString.substring("assets/".length());
      paramHttpURLConnection = new BufferedInputStream(Cocos2dxHelper.getActivity().getAssets().open(paramHttpURLConnection));
    }
  }
  
  private static String str2Seconds(String paramString)
  {
    Calendar localCalendar = Calendar.getInstance();
    long l1 = 0L;
    try
    {
      localCalendar.setTime(new SimpleDateFormat("EEE, dd-MMM-yy hh:mm:ss zzz", Locale.US).parse(paramString));
      long l2 = localCalendar.getTimeInMillis() / 1000L;
      l1 = l2;
    }
    catch (ParseException paramString)
    {
      for (;;)
      {
        Log.e("URLConnection exception", paramString.toString());
      }
    }
    return Long.toString(l1);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\org\cocos2dx\lib\Cocos2dxHttpURLConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */