package com.mob.tools.a;

import android.content.Context;
import android.os.Build.VERSION;
import com.mob.tools.log.d;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.FileNameMap;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.X509TrustManager;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;

public class l
{
  public static int connectionTimeout;
  public static int readTimout;
  
  private HttpURLConnection getConnection(String paramString, a parama)
  {
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
    try
    {
      paramString = com.mob.tools.b.h.a(localHttpURLConnection, "methodTokens");
      if (paramString == null)
      {
        try
        {
          localObject1 = com.mob.tools.b.h.b("HttpURLConnection", "PERMITTED_USER_METHODS");
          paramString = "PERMITTED_USER_METHODS";
          i = 1;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            Object localObject1;
            SecureRandom localSecureRandom;
            localObject2 = "PERMITTED_USER_METHODS";
            i = 1;
            str = paramString;
            paramString = (String)localObject2;
            continue;
            com.mob.tools.b.h.a(localHttpURLConnection, paramString, localObject2);
            continue;
            i = parama.b;
            continue;
            i = parama.a;
          }
        }
        if (localObject1 != null)
        {
          localObject1 = (String[])localObject1;
          localObject2 = new String[localObject1.length + 1];
          System.arraycopy(localObject1, 0, localObject2, 0, localObject1.length);
          localObject2[localObject1.length] = "PATCH";
          if (i != 0) {
            com.mob.tools.b.h.a("HttpURLConnection", paramString, localObject2);
          }
        }
        else
        {
          if (Build.VERSION.SDK_INT < 8) {
            System.setProperty("http.keepAlive", "false");
          }
          if ((localHttpURLConnection instanceof HttpsURLConnection))
          {
            paramString = (HttpsURLConnection)localHttpURLConnection;
            localObject1 = SSLContext.getInstance("TLS");
            localObject2 = new n(this);
            localSecureRandom = new SecureRandom();
            ((SSLContext)localObject1).init(null, new X509TrustManager[] { localObject2 }, localSecureRandom);
            HttpsURLConnection.setDefaultSSLSocketFactory(((SSLContext)localObject1).getSocketFactory());
            paramString.setHostnameVerifier(new o(this));
          }
          if (parama != null) {
            break label261;
          }
          i = connectionTimeout;
          if (i > 0) {
            localHttpURLConnection.setConnectTimeout(i);
          }
          if (parama != null) {
            break label270;
          }
          i = readTimout;
          if (i > 0) {
            localHttpURLConnection.setReadTimeout(i);
          }
          return localHttpURLConnection;
        }
      }
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        paramString = null;
        continue;
        label261:
        label270:
        Object localObject2 = "methodTokens";
        int i = 0;
        String str = paramString;
        paramString = (String)localObject2;
      }
    }
  }
  
  private c getFilePostHTTPPart(HttpURLConnection paramHttpURLConnection, String paramString, ArrayList<i<String>> paramArrayList1, ArrayList<i<String>> paramArrayList2)
  {
    String str = UUID.randomUUID().toString();
    paramHttpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + str);
    j localj = new j();
    paramHttpURLConnection = new t();
    if (paramArrayList1 != null)
    {
      paramString = paramArrayList1.iterator();
      while (paramString.hasNext())
      {
        paramArrayList1 = (i)paramString.next();
        paramHttpURLConnection.a("--").a(str).a("\r\n");
        paramHttpURLConnection.a("Content-Disposition: form-data; name=\"").a(paramArrayList1.a).a("\"\r\n\r\n");
        paramHttpURLConnection.a((String)paramArrayList1.b).a("\r\n");
      }
    }
    localj.a(paramHttpURLConnection);
    paramArrayList1 = paramArrayList2.iterator();
    if (paramArrayList1.hasNext())
    {
      paramArrayList2 = (i)paramArrayList1.next();
      t localt = new t();
      paramHttpURLConnection = new File((String)paramArrayList2.b);
      localt.a("--").a(str).a("\r\n");
      localt.a("Content-Disposition: form-data; name=\"").a(paramArrayList2.a).a("\"; filename=\"").a(paramHttpURLConnection.getName()).a("\"\r\n");
      paramString = URLConnection.getFileNameMap().getContentTypeFor((String)paramArrayList2.b);
      if (paramString != null)
      {
        paramHttpURLConnection = paramString;
        if (paramString.length() > 0) {}
      }
      else
      {
        if ((!((String)paramArrayList2.b).toLowerCase().endsWith("jpg")) && (!((String)paramArrayList2.b).toLowerCase().endsWith("jpeg"))) {
          break label392;
        }
        paramHttpURLConnection = "image/jpeg";
      }
      for (;;)
      {
        localt.a("Content-Type: ").a(paramHttpURLConnection).a("\r\n\r\n");
        localj.a(localt);
        paramHttpURLConnection = new b();
        paramHttpURLConnection.a((String)paramArrayList2.b);
        localj.a(paramHttpURLConnection);
        paramHttpURLConnection = new t();
        paramHttpURLConnection.a("\r\n");
        localj.a(paramHttpURLConnection);
        break;
        label392:
        if (((String)paramArrayList2.b).toLowerCase().endsWith("png"))
        {
          paramHttpURLConnection = "image/png";
        }
        else if (((String)paramArrayList2.b).toLowerCase().endsWith("gif"))
        {
          paramHttpURLConnection = "image/gif";
        }
        else
        {
          paramHttpURLConnection = new FileInputStream((String)paramArrayList2.b);
          paramString = URLConnection.guessContentTypeFromStream(paramHttpURLConnection);
          paramHttpURLConnection.close();
          if (paramString != null)
          {
            paramHttpURLConnection = paramString;
            if (paramString.length() > 0) {}
          }
          else
          {
            paramHttpURLConnection = "application/octet-stream";
          }
        }
      }
    }
    paramHttpURLConnection = new t();
    paramHttpURLConnection.a("--").a(str).a("--\r\n");
    localj.a(paramHttpURLConnection);
    return localj;
  }
  
  private c getTextPostHTTPPart(HttpURLConnection paramHttpURLConnection, String paramString, ArrayList<i<String>> paramArrayList)
  {
    paramHttpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
    paramHttpURLConnection = new t();
    if (paramArrayList != null) {
      paramHttpURLConnection.a(kvPairsToUrl(paramArrayList));
    }
    return paramHttpURLConnection;
  }
  
  private void httpPatchImpl(String paramString, ArrayList<i<String>> paramArrayList1, i<String> parami, long paramLong, ArrayList<i<String>> paramArrayList2, p paramp, h paramh, a parama)
  {
    long l = System.currentTimeMillis();
    com.mob.tools.e.a().i("httpPatch: " + paramString, new Object[0]);
    String str = paramString;
    if (paramArrayList1 != null)
    {
      paramArrayList1 = kvPairsToUrl(paramArrayList1);
      str = paramString;
      if (paramArrayList1.length() > 0) {
        str = paramString + "?" + paramArrayList1;
      }
    }
    paramArrayList1 = new g(str);
    if (paramArrayList2 != null)
    {
      paramString = paramArrayList2.iterator();
      while (paramString.hasNext())
      {
        paramArrayList2 = (i)paramString.next();
        paramArrayList1.setHeader(paramArrayList2.a, (String)paramArrayList2.b);
      }
    }
    paramString = new b();
    paramString.a(paramp);
    paramString.a((String)parami.b);
    paramString.a(paramLong);
    paramString = new InputStreamEntity(paramString.c(), paramString.b() - paramLong);
    paramString.setContentEncoding("application/offset+octet-stream");
    paramArrayList1.setEntity(paramString);
    paramString = new BasicHttpParams();
    int i;
    if (parama == null)
    {
      i = connectionTimeout;
      if (i > 0) {
        HttpConnectionParams.setConnectionTimeout(paramString, i);
      }
      if (parama != null) {
        break label477;
      }
      i = readTimout;
      label247:
      if (i > 0) {
        HttpConnectionParams.setSoTimeout(paramString, i);
      }
      paramArrayList1.setParams(paramString);
      if (!str.startsWith("https://")) {
        break label487;
      }
      paramString = KeyStore.getInstance(KeyStore.getDefaultType());
      paramString.load(null, null);
      paramString = new r(paramString);
      paramString.a();
      parami = new BasicHttpParams();
      HttpProtocolParams.setVersion(parami, HttpVersion.HTTP_1_1);
      HttpProtocolParams.setContentCharset(parami, "UTF-8");
      paramArrayList2 = new SchemeRegistry();
      paramArrayList2.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
      paramArrayList2.register(new Scheme("https", paramString, 443));
      paramString = new DefaultHttpClient(new ThreadSafeClientConnManager(parami, paramArrayList2), parami);
      label391:
      paramArrayList1 = paramString.execute(paramArrayList1);
      if (paramh == null) {
        break label515;
      }
    }
    for (;;)
    {
      try
      {
        paramh.a(new e(paramArrayList1));
        paramString.getConnectionManager().shutdown();
        com.mob.tools.e.a().i("use time: " + (System.currentTimeMillis() - l), new Object[0]);
        return;
      }
      catch (Throwable paramArrayList1)
      {
        label477:
        label487:
        throw paramArrayList1;
      }
      finally
      {
        paramString.getConnectionManager().shutdown();
      }
      i = parama.b;
      break;
      i = parama.a;
      break label247;
      paramString = new DefaultHttpClient();
      break label391;
      label515:
      paramString.getConnectionManager().shutdown();
    }
  }
  
  private String kvPairsToUrl(ArrayList<i<String>> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramArrayList.iterator();
    if (localIterator.hasNext())
    {
      paramArrayList = (i)localIterator.next();
      String str = com.mob.tools.b.b.c(paramArrayList.a, "utf-8");
      if (paramArrayList.b != null) {}
      for (paramArrayList = com.mob.tools.b.b.c((String)paramArrayList.b, "utf-8");; paramArrayList = "")
      {
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append('&');
        }
        localStringBuilder.append(str).append('=').append(paramArrayList);
        break;
      }
    }
    return localStringBuilder.toString();
  }
  
  public String downloadCache(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, a parama)
  {
    long l = System.currentTimeMillis();
    com.mob.tools.e.a().i("downloading: " + paramString1, new Object[0]);
    Object localObject;
    if (paramBoolean)
    {
      localObject = new File(com.mob.tools.b.g.e(paramContext, paramString2), com.mob.tools.b.b.b(paramString1));
      if ((paramBoolean) && (((File)localObject).exists()))
      {
        com.mob.tools.e.a().i("use time: " + (System.currentTimeMillis() - l), new Object[0]);
        return ((File)localObject).getAbsolutePath();
      }
    }
    HttpURLConnection localHttpURLConnection = getConnection(paramString1, parama);
    localHttpURLConnection.connect();
    int i = localHttpURLConnection.getResponseCode();
    if (i == 200)
    {
      Map localMap = localHttpURLConnection.getHeaderFields();
      if (localMap != null)
      {
        parama = (List)localMap.get("Content-Disposition");
        if ((parama != null) && (parama.size() > 0))
        {
          String[] arrayOfString = ((String)parama.get(0)).split(";");
          int j = arrayOfString.length;
          parama = null;
          i = 0;
          for (;;)
          {
            localObject = parama;
            if (i >= j) {
              break;
            }
            localObject = arrayOfString[i];
            if (((String)localObject).trim().startsWith("filename"))
            {
              localObject = localObject.split("=")[1];
              parama = (a)localObject;
              if (((String)localObject).startsWith("\""))
              {
                parama = (a)localObject;
                if (((String)localObject).endsWith("\"")) {
                  parama = ((String)localObject).substring(1, ((String)localObject).length() - 1);
                }
              }
            }
            i += 1;
          }
        }
      }
      localObject = null;
      parama = (a)localObject;
      if (localObject == null)
      {
        localObject = com.mob.tools.b.b.b(paramString1);
        if (localMap == null) {
          break label928;
        }
        parama = (List)localMap.get("Content-Type");
        if ((parama == null) || (parama.size() <= 0)) {
          break label928;
        }
        parama = (String)parama.get(0);
        if (parama != null) {
          break label532;
        }
        parama = "";
        if (!parama.startsWith("image/")) {
          break label542;
        }
        parama = parama.substring("image/".length());
        localObject = new StringBuilder().append((String)localObject).append(".");
        paramString1 = parama;
        if ("jpeg".equals(parama)) {
          paramString1 = "jpg";
        }
        parama = paramString1;
      }
    }
    for (;;)
    {
      paramContext = new File(com.mob.tools.b.g.e(paramContext, paramString2), parama);
      if ((paramBoolean) && (paramContext.exists()))
      {
        localHttpURLConnection.disconnect();
        com.mob.tools.e.a().i("use time: " + (System.currentTimeMillis() - l), new Object[0]);
        return paramContext.getAbsolutePath();
        label532:
        parama = parama.trim();
        break;
        label542:
        i = paramString1.lastIndexOf('/');
        parama = null;
        if (i > 0) {
          parama = paramString1.substring(i + 1);
        }
        if ((parama == null) || (parama.length() <= 0)) {
          break label928;
        }
        i = parama.lastIndexOf('.');
        if ((i <= 0) || (parama.length() - i >= 10)) {
          break label928;
        }
        parama = (String)localObject + parama.substring(i);
        continue;
      }
      if (!paramContext.getParentFile().exists()) {
        paramContext.getParentFile().mkdirs();
      }
      if (paramContext.exists()) {
        paramContext.delete();
      }
      try
      {
        paramString1 = localHttpURLConnection.getInputStream();
        paramString2 = new FileOutputStream(paramContext);
        parama = new byte['Ѐ'];
        for (i = paramString1.read(parama); i > 0; i = paramString1.read(parama)) {
          paramString2.write(parama, 0, i);
        }
        paramString2.flush();
        paramString1.close();
        paramString2.close();
        localHttpURLConnection.disconnect();
        com.mob.tools.e.a().i("use time: " + (System.currentTimeMillis() - l), new Object[0]);
        return paramContext.getAbsolutePath();
      }
      catch (Throwable paramString1)
      {
        if (paramContext.exists()) {
          paramContext.delete();
        }
        throw paramString1;
      }
      paramString1 = new StringBuilder();
      paramString2 = new BufferedReader(new InputStreamReader(localHttpURLConnection.getErrorStream(), Charset.forName("utf-8")));
      for (paramContext = paramString2.readLine(); paramContext != null; paramContext = paramString2.readLine())
      {
        if (paramString1.length() > 0) {
          paramString1.append('\n');
        }
        paramString1.append(paramContext);
      }
      paramString2.close();
      localHttpURLConnection.disconnect();
      paramContext = new HashMap();
      paramContext.put("error", paramString1.toString());
      paramContext.put("status", Integer.valueOf(i));
      throw new Throwable(new com.mob.tools.b.e().a(paramContext));
      label928:
      parama = (a)localObject;
    }
  }
  
  public void getHttpPostResponse(String paramString, ArrayList<i<String>> paramArrayList1, i<String> parami, ArrayList<i<String>> paramArrayList2, h paramh, a parama)
  {
    long l = System.currentTimeMillis();
    com.mob.tools.e.a().i("httpPost: " + paramString, new Object[0]);
    parama = getConnection(paramString, parama);
    parama.setDoOutput(true);
    parama.setChunkedStreamingMode(0);
    ArrayList localArrayList;
    if ((parami != null) && (parami.b != null) && (new File((String)parami.b).exists()))
    {
      localArrayList = new ArrayList();
      localArrayList.add(parami);
    }
    for (paramString = getFilePostHTTPPart(parama, paramString, paramArrayList1, localArrayList); paramArrayList2 != null; paramString = getTextPostHTTPPart(parama, paramString, paramArrayList1))
    {
      paramArrayList1 = paramArrayList2.iterator();
      while (paramArrayList1.hasNext())
      {
        parami = (i)paramArrayList1.next();
        parama.setRequestProperty(parami.a, (String)parami.b);
      }
    }
    parama.connect();
    paramArrayList1 = parama.getOutputStream();
    paramString = paramString.c();
    parami = new byte[65536];
    for (int i = paramString.read(parami); i > 0; i = paramString.read(parami)) {
      paramArrayList1.write(parami, 0, i);
    }
    paramArrayList1.flush();
    paramString.close();
    paramArrayList1.close();
    if (paramh != null) {}
    for (;;)
    {
      try
      {
        paramh.a(new f(parama));
        parama.disconnect();
        com.mob.tools.e.a().i("use time: " + (System.currentTimeMillis() - l), new Object[0]);
        return;
      }
      catch (Throwable paramString)
      {
        throw paramString;
      }
      finally
      {
        parama.disconnect();
      }
      parama.disconnect();
    }
  }
  
  public String httpGet(String paramString, ArrayList<i<String>> paramArrayList1, ArrayList<i<String>> paramArrayList2, a parama)
  {
    long l = System.currentTimeMillis();
    com.mob.tools.e.a().i("httpGet: " + paramString, new Object[0]);
    String str = paramString;
    if (paramArrayList1 != null)
    {
      paramArrayList1 = kvPairsToUrl(paramArrayList1);
      str = paramString;
      if (paramArrayList1.length() > 0) {
        str = paramString + "?" + paramArrayList1;
      }
    }
    paramArrayList1 = getConnection(str, parama);
    if (paramArrayList2 != null)
    {
      paramString = paramArrayList2.iterator();
      while (paramString.hasNext())
      {
        paramArrayList2 = (i)paramString.next();
        paramArrayList1.setRequestProperty(paramArrayList2.a, (String)paramArrayList2.b);
      }
    }
    paramArrayList1.connect();
    int i = paramArrayList1.getResponseCode();
    if (i == 200)
    {
      paramArrayList2 = new StringBuilder();
      parama = new BufferedReader(new InputStreamReader(paramArrayList1.getInputStream(), Charset.forName("utf-8")));
      for (paramString = parama.readLine(); paramString != null; paramString = parama.readLine())
      {
        if (paramArrayList2.length() > 0) {
          paramArrayList2.append('\n');
        }
        paramArrayList2.append(paramString);
      }
      parama.close();
      paramArrayList1.disconnect();
      paramString = paramArrayList2.toString();
      com.mob.tools.e.a().i("use time: " + (System.currentTimeMillis() - l), new Object[0]);
      return paramString;
    }
    paramArrayList2 = new StringBuilder();
    parama = new BufferedReader(new InputStreamReader(paramArrayList1.getErrorStream(), Charset.forName("utf-8")));
    for (paramString = parama.readLine(); paramString != null; paramString = parama.readLine())
    {
      if (paramArrayList2.length() > 0) {
        paramArrayList2.append('\n');
      }
      paramArrayList2.append(paramString);
    }
    parama.close();
    paramArrayList1.disconnect();
    paramString = new HashMap();
    paramString.put("error", paramArrayList2.toString());
    paramString.put("status", Integer.valueOf(i));
    throw new Throwable(new com.mob.tools.b.e().a(paramString));
  }
  
  public ArrayList<i<String[]>> httpHead(String paramString, ArrayList<i<String>> paramArrayList1, i<String> parami, ArrayList<i<String>> paramArrayList2, a parama)
  {
    long l = System.currentTimeMillis();
    com.mob.tools.e.a().i("httpHead: " + paramString, new Object[0]);
    parami = paramString;
    if (paramArrayList1 != null)
    {
      paramArrayList1 = kvPairsToUrl(paramArrayList1);
      parami = paramString;
      if (paramArrayList1.length() > 0) {
        parami = paramString + "?" + paramArrayList1;
      }
    }
    paramString = getConnection(parami, parama);
    paramString.setRequestMethod("HEAD");
    if (paramArrayList2 != null)
    {
      paramArrayList1 = paramArrayList2.iterator();
      while (paramArrayList1.hasNext())
      {
        parami = (i)paramArrayList1.next();
        paramString.setRequestProperty(parami.a, (String)parami.b);
      }
    }
    paramString.connect();
    parami = paramString.getHeaderFields();
    paramArrayList1 = new ArrayList();
    if (parami != null)
    {
      parami = parami.entrySet().iterator();
      while (parami.hasNext())
      {
        paramArrayList2 = (Map.Entry)parami.next();
        parama = (List)paramArrayList2.getValue();
        if (parama == null)
        {
          paramArrayList1.add(new i((String)paramArrayList2.getKey(), new String[0]));
        }
        else
        {
          String[] arrayOfString = new String[parama.size()];
          int i = 0;
          while (i < arrayOfString.length)
          {
            arrayOfString[i] = ((String)parama.get(i));
            i += 1;
          }
          paramArrayList1.add(new i((String)paramArrayList2.getKey(), arrayOfString));
        }
      }
    }
    paramString.disconnect();
    com.mob.tools.e.a().i("use time: " + (System.currentTimeMillis() - l), new Object[0]);
    return paramArrayList1;
  }
  
  public void httpPatch(String paramString, ArrayList<i<String>> paramArrayList1, i<String> parami, long paramLong, ArrayList<i<String>> paramArrayList2, p paramp, h paramh, a parama)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      httpPatchImpl23(paramString, paramArrayList1, parami, paramLong, paramArrayList2, paramp, paramh, parama);
      return;
    }
    httpPatchImpl(paramString, paramArrayList1, parami, paramLong, paramArrayList2, paramp, paramh, parama);
  }
  
  public void httpPatchImpl23(String paramString, ArrayList<i<String>> paramArrayList1, i<String> parami, long paramLong, ArrayList<i<String>> paramArrayList2, p paramp, h paramh, a parama)
  {
    long l = System.currentTimeMillis();
    com.mob.tools.e.a().i("httpPatch: " + paramString, new Object[0]);
    String str = paramString;
    if (paramArrayList1 != null)
    {
      paramArrayList1 = kvPairsToUrl(paramArrayList1);
      str = paramString;
      if (paramArrayList1.length() > 0) {
        str = paramString + "?" + paramArrayList1;
      }
    }
    paramString = getConnection(str, parama);
    paramString.setDoOutput(true);
    paramString.setChunkedStreamingMode(0);
    paramString.setRequestMethod("PATCH");
    paramString.setRequestProperty("Content-Type", "application/offset+octet-stream");
    if (paramArrayList2 != null)
    {
      paramArrayList1 = paramArrayList2.iterator();
      while (paramArrayList1.hasNext())
      {
        paramArrayList2 = (i)paramArrayList1.next();
        paramString.setRequestProperty(paramArrayList2.a, (String)paramArrayList2.b);
      }
    }
    paramString.connect();
    paramArrayList1 = paramString.getOutputStream();
    paramArrayList2 = new b();
    paramArrayList2.a(paramp);
    paramArrayList2.a((String)parami.b);
    paramArrayList2.a(paramLong);
    parami = paramArrayList2.c();
    paramArrayList2 = new byte[65536];
    for (int i = parami.read(paramArrayList2); i > 0; i = parami.read(paramArrayList2)) {
      paramArrayList1.write(paramArrayList2, 0, i);
    }
    paramArrayList1.flush();
    parami.close();
    paramArrayList1.close();
    if (paramh != null) {}
    for (;;)
    {
      try
      {
        paramh.a(new f(paramString));
        paramString.disconnect();
        com.mob.tools.e.a().i("use time: " + (System.currentTimeMillis() - l), new Object[0]);
        return;
      }
      catch (Throwable paramArrayList1)
      {
        throw paramArrayList1;
      }
      finally
      {
        paramString.disconnect();
      }
      paramString.disconnect();
    }
  }
  
  public String httpPost(String paramString, ArrayList<i<String>> paramArrayList1, i<String> parami, ArrayList<i<String>> paramArrayList2, a parama)
  {
    ArrayList localArrayList = new ArrayList();
    if ((parami != null) && (parami.b != null) && (new File((String)parami.b).exists())) {
      localArrayList.add(parami);
    }
    return httpPostFiles(paramString, paramArrayList1, localArrayList, paramArrayList2, parama);
  }
  
  public void httpPost(String paramString, ArrayList<i<String>> paramArrayList1, ArrayList<i<String>> paramArrayList2, ArrayList<i<String>> paramArrayList3, h paramh, a parama)
  {
    long l = System.currentTimeMillis();
    com.mob.tools.e.a().i("httpPost: " + paramString, new Object[0]);
    parama = getConnection(paramString, parama);
    parama.setDoOutput(true);
    if ((paramArrayList2 != null) && (paramArrayList2.size() > 0))
    {
      paramString = getFilePostHTTPPart(parama, paramString, paramArrayList1, paramArrayList2);
      parama.setChunkedStreamingMode(0);
    }
    while (paramArrayList3 != null)
    {
      paramArrayList1 = paramArrayList3.iterator();
      while (paramArrayList1.hasNext())
      {
        paramArrayList2 = (i)paramArrayList1.next();
        parama.setRequestProperty(paramArrayList2.a, (String)paramArrayList2.b);
      }
      paramString = getTextPostHTTPPart(parama, paramString, paramArrayList1);
      parama.setFixedLengthStreamingMode((int)paramString.b());
    }
    parama.connect();
    paramArrayList1 = parama.getOutputStream();
    paramString = paramString.c();
    paramArrayList2 = new byte[65536];
    for (int i = paramString.read(paramArrayList2); i > 0; i = paramString.read(paramArrayList2)) {
      paramArrayList1.write(paramArrayList2, 0, i);
    }
    paramArrayList1.flush();
    paramString.close();
    paramArrayList1.close();
    if (paramh != null) {}
    for (;;)
    {
      try
      {
        paramh.a(new f(parama));
        parama.disconnect();
        com.mob.tools.e.a().i("use time: " + (System.currentTimeMillis() - l), new Object[0]);
        return;
      }
      catch (Throwable paramString)
      {
        throw paramString;
      }
      finally
      {
        parama.disconnect();
      }
      parama.disconnect();
    }
  }
  
  public String httpPostFiles(String paramString, ArrayList<i<String>> paramArrayList1, ArrayList<i<String>> paramArrayList2, ArrayList<i<String>> paramArrayList3, a parama)
  {
    HashMap localHashMap = new HashMap();
    httpPost(paramString, paramArrayList1, paramArrayList2, paramArrayList3, new m(this, localHashMap), parama);
    return (String)localHashMap.get("resp");
  }
  
  public String httpPut(String paramString, ArrayList<i<String>> paramArrayList1, i<String> parami, ArrayList<i<String>> paramArrayList2, a parama)
  {
    long l = System.currentTimeMillis();
    com.mob.tools.e.a().i("httpPut: " + paramString, new Object[0]);
    String str = paramString;
    if (paramArrayList1 != null)
    {
      paramArrayList1 = kvPairsToUrl(paramArrayList1);
      str = paramString;
      if (paramArrayList1.length() > 0) {
        str = paramString + "?" + paramArrayList1;
      }
    }
    paramArrayList1 = getConnection(str, parama);
    paramArrayList1.setDoOutput(true);
    paramArrayList1.setChunkedStreamingMode(0);
    paramArrayList1.setRequestMethod("PUT");
    paramArrayList1.setRequestProperty("Content-Type", "application/octet-stream");
    if (paramArrayList2 != null)
    {
      paramString = paramArrayList2.iterator();
      while (paramString.hasNext())
      {
        paramArrayList2 = (i)paramString.next();
        paramArrayList1.setRequestProperty(paramArrayList2.a, (String)paramArrayList2.b);
      }
    }
    paramArrayList1.connect();
    paramString = paramArrayList1.getOutputStream();
    paramArrayList2 = new b();
    paramArrayList2.a((String)parami.b);
    parami = paramArrayList2.c();
    paramArrayList2 = new byte[65536];
    for (int i = parami.read(paramArrayList2); i > 0; i = parami.read(paramArrayList2)) {
      paramString.write(paramArrayList2, 0, i);
    }
    paramString.flush();
    parami.close();
    paramString.close();
    i = paramArrayList1.getResponseCode();
    if ((i == 200) || (i == 201))
    {
      parami = new StringBuilder();
      paramArrayList2 = new BufferedReader(new InputStreamReader(paramArrayList1.getInputStream(), Charset.forName("utf-8")));
      for (paramString = paramArrayList2.readLine(); paramString != null; paramString = paramArrayList2.readLine())
      {
        if (parami.length() > 0) {
          parami.append('\n');
        }
        parami.append(paramString);
      }
      paramArrayList2.close();
      paramArrayList1.disconnect();
      paramString = parami.toString();
      com.mob.tools.e.a().i("use time: " + (System.currentTimeMillis() - l), new Object[0]);
      return paramString;
    }
    parami = new StringBuilder();
    paramArrayList1 = new BufferedReader(new InputStreamReader(paramArrayList1.getErrorStream(), Charset.forName("utf-8")));
    for (paramString = paramArrayList1.readLine(); paramString != null; paramString = paramArrayList1.readLine())
    {
      if (parami.length() > 0) {
        parami.append('\n');
      }
      parami.append(paramString);
    }
    paramArrayList1.close();
    paramString = new HashMap();
    paramString.put("error", parami.toString());
    paramString.put("status", Integer.valueOf(i));
    throw new Throwable(new com.mob.tools.b.e().a(paramString));
  }
  
  public String jsonPost(String paramString, ArrayList<i<String>> paramArrayList1, ArrayList<i<String>> paramArrayList2, a parama)
  {
    long l = System.currentTimeMillis();
    com.mob.tools.e.a().i("jsonPost: " + paramString, new Object[0]);
    parama = getConnection(paramString, parama);
    parama.setDoOutput(true);
    parama.setChunkedStreamingMode(0);
    parama.setRequestProperty("content-type", "application/json");
    if (paramArrayList2 != null)
    {
      paramString = paramArrayList2.iterator();
      while (paramString.hasNext())
      {
        paramArrayList2 = (i)paramString.next();
        parama.setRequestProperty(paramArrayList2.a, (String)paramArrayList2.b);
      }
    }
    paramString = new t();
    if (paramArrayList1 != null)
    {
      paramArrayList2 = new HashMap();
      paramArrayList1 = paramArrayList1.iterator();
      while (paramArrayList1.hasNext())
      {
        i locali = (i)paramArrayList1.next();
        paramArrayList2.put(locali.a, locali.b);
      }
      paramString.a(new com.mob.tools.b.e().a(paramArrayList2));
    }
    parama.connect();
    paramArrayList1 = parama.getOutputStream();
    paramString = paramString.c();
    paramArrayList2 = new byte[65536];
    for (int i = paramString.read(paramArrayList2); i > 0; i = paramString.read(paramArrayList2)) {
      paramArrayList1.write(paramArrayList2, 0, i);
    }
    paramArrayList1.flush();
    paramString.close();
    paramArrayList1.close();
    i = parama.getResponseCode();
    if ((i == 200) || (i == 201))
    {
      paramArrayList1 = new StringBuilder();
      paramArrayList2 = new BufferedReader(new InputStreamReader(parama.getInputStream(), Charset.forName("utf-8")));
      for (paramString = paramArrayList2.readLine(); paramString != null; paramString = paramArrayList2.readLine())
      {
        if (paramArrayList1.length() > 0) {
          paramArrayList1.append('\n');
        }
        paramArrayList1.append(paramString);
      }
      paramArrayList2.close();
      parama.disconnect();
      paramString = paramArrayList1.toString();
      com.mob.tools.e.a().i("use time: " + (System.currentTimeMillis() - l), new Object[0]);
      return paramString;
    }
    paramArrayList1 = new StringBuilder();
    paramArrayList2 = new BufferedReader(new InputStreamReader(parama.getErrorStream(), Charset.forName("utf-8")));
    for (paramString = paramArrayList2.readLine(); paramString != null; paramString = paramArrayList2.readLine())
    {
      if (paramArrayList1.length() > 0) {
        paramArrayList1.append('\n');
      }
      paramArrayList1.append(paramString);
    }
    paramArrayList2.close();
    parama.disconnect();
    paramString = new HashMap();
    paramString.put("error", paramArrayList1.toString());
    paramString.put("status", Integer.valueOf(i));
    throw new Throwable(new com.mob.tools.b.e().a(paramString));
  }
  
  public void rawGet(String paramString, q paramq, a parama)
  {
    long l = System.currentTimeMillis();
    com.mob.tools.e.a().i("rawGet: " + paramString, new Object[0]);
    parama = getConnection(paramString, parama);
    parama.connect();
    int i = parama.getResponseCode();
    if (i == 200)
    {
      if (paramq != null) {
        paramq.a(parama.getInputStream());
      }
      parama.disconnect();
      com.mob.tools.e.a().i("use time: " + (System.currentTimeMillis() - l), new Object[0]);
      return;
    }
    paramq = new StringBuilder();
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(parama.getErrorStream(), Charset.forName("utf-8")));
    for (paramString = localBufferedReader.readLine(); paramString != null; paramString = localBufferedReader.readLine())
    {
      if (paramq.length() > 0) {
        paramq.append('\n');
      }
      paramq.append(paramString);
    }
    localBufferedReader.close();
    parama.disconnect();
    paramString = new HashMap();
    paramString.put("error", paramq.toString());
    paramString.put("status", Integer.valueOf(i));
    throw new Throwable(new com.mob.tools.b.e().a(paramString));
  }
  
  public void rawPost(String paramString, ArrayList<i<String>> paramArrayList, c paramc, h paramh, a parama)
  {
    long l = System.currentTimeMillis();
    com.mob.tools.e.a().i("rawpost: " + paramString, new Object[0]);
    paramString = getConnection(paramString, parama);
    paramString.setDoOutput(true);
    paramString.setChunkedStreamingMode(0);
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        parama = (i)paramArrayList.next();
        paramString.setRequestProperty(parama.a, (String)parama.b);
      }
    }
    paramString.connect();
    paramArrayList = paramString.getOutputStream();
    paramc = paramc.c();
    parama = new byte[65536];
    for (int i = paramc.read(parama); i > 0; i = paramc.read(parama)) {
      paramArrayList.write(parama, 0, i);
    }
    paramArrayList.flush();
    paramc.close();
    paramArrayList.close();
    if (paramh != null) {}
    for (;;)
    {
      try
      {
        paramh.a(new f(paramString));
        paramString.disconnect();
        com.mob.tools.e.a().i("use time: " + (System.currentTimeMillis() - l), new Object[0]);
        return;
      }
      catch (Throwable paramArrayList)
      {
        throw paramArrayList;
      }
      finally
      {
        paramString.disconnect();
      }
      paramString.disconnect();
    }
  }
  
  /* Error */
  public void rawPost(String paramString, ArrayList<i<String>> paramArrayList, c paramc, q paramq, a parama)
  {
    // Byte code:
    //   0: invokestatic 289	java/lang/System:currentTimeMillis	()J
    //   3: lstore 7
    //   5: invokestatic 294	com/mob/tools/e:a	()Lcom/mob/tools/log/d;
    //   8: new 146	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   15: ldc_w 763
    //   18: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_1
    //   22: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: iconst_0
    //   29: anewarray 4	java/lang/Object
    //   32: invokevirtual 302	com/mob/tools/log/d:i	(Ljava/lang/Object;[Ljava/lang/Object;)I
    //   35: pop
    //   36: aload_0
    //   37: aload_1
    //   38: aload 5
    //   40: invokespecial 492	com/mob/tools/a/l:getConnection	(Ljava/lang/String;Lcom/mob/tools/a/l$a;)Ljava/net/HttpURLConnection;
    //   43: astore 5
    //   45: aload 5
    //   47: iconst_1
    //   48: invokevirtual 643	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   51: aload 5
    //   53: iconst_0
    //   54: invokevirtual 646	java/net/HttpURLConnection:setChunkedStreamingMode	(I)V
    //   57: aload_2
    //   58: ifnull +46 -> 104
    //   61: aload_2
    //   62: invokevirtual 170	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   65: astore_1
    //   66: aload_1
    //   67: invokeinterface 176 1 0
    //   72: ifeq +32 -> 104
    //   75: aload_1
    //   76: invokeinterface 180 1 0
    //   81: checkcast 182	com/mob/tools/a/i
    //   84: astore_2
    //   85: aload 5
    //   87: aload_2
    //   88: getfield 194	com/mob/tools/a/i:a	Ljava/lang/String;
    //   91: aload_2
    //   92: getfield 199	com/mob/tools/a/i:b	Ljava/lang/Object;
    //   95: checkcast 49	java/lang/String
    //   98: invokevirtual 158	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: goto -35 -> 66
    //   104: aload 5
    //   106: invokevirtual 495	java/net/HttpURLConnection:connect	()V
    //   109: aload 5
    //   111: invokevirtual 658	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   114: astore_1
    //   115: aload_3
    //   116: invokevirtual 661	com/mob/tools/a/c:c	()Ljava/io/InputStream;
    //   119: astore_2
    //   120: ldc_w 662
    //   123: newarray <illegal type>
    //   125: astore_3
    //   126: aload_2
    //   127: aload_3
    //   128: invokevirtual 579	java/io/InputStream:read	([B)I
    //   131: istore 6
    //   133: iload 6
    //   135: ifle +21 -> 156
    //   138: aload_1
    //   139: aload_3
    //   140: iconst_0
    //   141: iload 6
    //   143: invokevirtual 665	java/io/OutputStream:write	([BII)V
    //   146: aload_2
    //   147: aload_3
    //   148: invokevirtual 579	java/io/InputStream:read	([B)I
    //   151: istore 6
    //   153: goto -20 -> 133
    //   156: aload_1
    //   157: invokevirtual 666	java/io/OutputStream:flush	()V
    //   160: aload_2
    //   161: invokevirtual 587	java/io/InputStream:close	()V
    //   164: aload_1
    //   165: invokevirtual 667	java/io/OutputStream:close	()V
    //   168: aload 5
    //   170: invokevirtual 498	java/net/HttpURLConnection:getResponseCode	()I
    //   173: istore 6
    //   175: iload 6
    //   177: sipush 200
    //   180: if_icmpne +99 -> 279
    //   183: aload 4
    //   185: ifnull +86 -> 271
    //   188: aload 5
    //   190: invokevirtual 568	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   193: astore_1
    //   194: aload 4
    //   196: aload_1
    //   197: invokeinterface 759 2 0
    //   202: aload_1
    //   203: ifnull +7 -> 210
    //   206: aload_1
    //   207: invokevirtual 587	java/io/InputStream:close	()V
    //   210: aload 5
    //   212: invokevirtual 551	java/net/HttpURLConnection:disconnect	()V
    //   215: invokestatic 294	com/mob/tools/e:a	()Lcom/mob/tools/log/d;
    //   218: new 146	java/lang/StringBuilder
    //   221: dup
    //   222: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   225: ldc_w 452
    //   228: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: invokestatic 289	java/lang/System:currentTimeMillis	()J
    //   234: lload 7
    //   236: lsub
    //   237: invokevirtual 455	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   240: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: iconst_0
    //   244: anewarray 4	java/lang/Object
    //   247: invokevirtual 302	com/mob/tools/log/d:i	(Ljava/lang/Object;[Ljava/lang/Object;)I
    //   250: pop
    //   251: return
    //   252: astore_2
    //   253: aload_2
    //   254: athrow
    //   255: astore_2
    //   256: aload_1
    //   257: ifnull +7 -> 264
    //   260: aload_1
    //   261: invokevirtual 587	java/io/InputStream:close	()V
    //   264: aload 5
    //   266: invokevirtual 551	java/net/HttpURLConnection:disconnect	()V
    //   269: aload_2
    //   270: athrow
    //   271: aload 5
    //   273: invokevirtual 551	java/net/HttpURLConnection:disconnect	()V
    //   276: goto -61 -> 215
    //   279: new 146	java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   286: astore_2
    //   287: new 590	java/io/BufferedReader
    //   290: dup
    //   291: new 592	java/io/InputStreamReader
    //   294: dup
    //   295: aload 5
    //   297: invokevirtual 595	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   300: ldc_w 459
    //   303: invokestatic 601	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   306: invokespecial 604	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   309: invokespecial 607	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   312: astore_3
    //   313: aload_3
    //   314: invokevirtual 610	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   317: astore_1
    //   318: aload_1
    //   319: ifnull +31 -> 350
    //   322: aload_2
    //   323: invokevirtual 464	java/lang/StringBuilder:length	()I
    //   326: ifle +10 -> 336
    //   329: aload_2
    //   330: bipush 10
    //   332: invokevirtual 467	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   335: pop
    //   336: aload_2
    //   337: aload_1
    //   338: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: pop
    //   342: aload_3
    //   343: invokevirtual 610	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   346: astore_1
    //   347: goto -29 -> 318
    //   350: aload_3
    //   351: invokevirtual 611	java/io/BufferedReader:close	()V
    //   354: aload 5
    //   356: invokevirtual 551	java/net/HttpURLConnection:disconnect	()V
    //   359: new 613	java/util/HashMap
    //   362: dup
    //   363: invokespecial 614	java/util/HashMap:<init>	()V
    //   366: astore_1
    //   367: aload_1
    //   368: ldc_w 616
    //   371: aload_2
    //   372: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   375: invokevirtual 620	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   378: pop
    //   379: aload_1
    //   380: ldc_w 622
    //   383: iload 6
    //   385: invokestatic 628	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   388: invokevirtual 620	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   391: pop
    //   392: new 19	java/lang/Throwable
    //   395: dup
    //   396: new 630	com/mob/tools/b/e
    //   399: dup
    //   400: invokespecial 631	com/mob/tools/b/e:<init>	()V
    //   403: aload_1
    //   404: invokevirtual 634	com/mob/tools/b/e:a	(Ljava/util/HashMap;)Ljava/lang/String;
    //   407: invokespecial 635	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   410: athrow
    //   411: astore_1
    //   412: goto -202 -> 210
    //   415: astore_1
    //   416: goto -152 -> 264
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	419	0	this	l
    //   0	419	1	paramString	String
    //   0	419	2	paramArrayList	ArrayList<i<String>>
    //   0	419	3	paramc	c
    //   0	419	4	paramq	q
    //   0	419	5	parama	a
    //   131	253	6	i	int
    //   3	232	7	l	long
    // Exception table:
    //   from	to	target	type
    //   194	202	252	java/lang/Throwable
    //   194	202	255	finally
    //   253	255	255	finally
    //   206	210	411	java/lang/Throwable
    //   260	264	415	java/lang/Throwable
  }
  
  public static class a
  {
    public int a;
    public int b;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\mob\tools\a\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */