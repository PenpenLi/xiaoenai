package com.xiaoenai.app.net.c.a;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import com.xiaoenai.app.a.c;
import com.xiaoenai.app.utils.ak;
import com.xiaoenai.app.utils.v;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class k
{
  private HttpRequestBase a;
  private Context b;
  
  public k(Context paramContext)
  {
    this.b = paramContext;
  }
  
  public static List<NameValuePair> a(JSONObject paramJSONObject)
  {
    int j = 0;
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = new String[paramJSONObject.length()];
    Iterator localIterator = paramJSONObject.keys();
    int i = 0;
    while (localIterator.hasNext())
    {
      arrayOfString[i] = ((String)localIterator.next());
      i += 1;
    }
    Arrays.sort(arrayOfString);
    i = j;
    if (paramJSONObject.has("sig"))
    {
      localArrayList.add(new BasicNameValuePair("sig", paramJSONObject.getString("sig")));
      i = j;
    }
    while (i < arrayOfString.length)
    {
      if (!arrayOfString[i].equals("sig")) {
        localArrayList.add(new BasicNameValuePair(arrayOfString[i], paramJSONObject.getString(arrayOfString[i])));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private JSONObject a(HttpResponse paramHttpResponse, String paramString)
  {
    com.xiaoenai.app.a.b localb = c.a(ak.a());
    int i = paramHttpResponse.getStatusLine().getStatusCode();
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("httpStatusCode", i);
    paramHttpResponse = EntityUtils.toString(paramHttpResponse.getEntity());
    com.xiaoenai.app.utils.f.a.c("requestUrl:{}", new Object[] { paramString });
    com.xiaoenai.app.utils.f.a.c("result statusCode={}", new Object[] { Integer.valueOf(i) });
    com.xiaoenai.app.utils.f.a.a(paramHttpResponse);
    if ((!paramString.equals("http://api.xiaoenai.com/v2/feedback/submit")) && (i != 200)) {
      com.xiaoenai.app.utils.f.a.a(true, "http requestUrl:{} statusCode={} responseStr:{}", new Object[] { paramString, Integer.valueOf(i), paramHttpResponse });
    }
    localJSONObject.put("httpRetJson", new JSONObject(paramHttpResponse));
    try
    {
      a(localb, paramString, i, paramHttpResponse);
      return localJSONObject;
    }
    catch (Exception paramHttpResponse)
    {
      paramHttpResponse.printStackTrace();
    }
    return localJSONObject;
  }
  
  private void a(com.xiaoenai.app.a.b paramb, String paramString1, int paramInt, String paramString2)
  {
    long l1;
    long l2;
    if (c.a())
    {
      paramString1 = com.xiaoenai.app.utils.b.a.b(paramString1);
      paramb.a(paramString1);
      paramb.b(ak.a());
      l1 = 0L;
      if (!a()) {
        break label169;
      }
      paramString1 = ((HttpPost)this.a).getEntity();
      if (paramString1 == null) {
        break label209;
      }
      l2 = paramString1.getContentLength();
      if (!(paramString1 instanceof MultipartEntity)) {
        break label128;
      }
      paramString1 = "stream";
      l1 = l2;
    }
    for (;;)
    {
      int i = 1;
      paramString1 = com.xiaoenai.app.utils.b.a.b(paramString1);
      paramb.c(paramString2.length());
      paramString2 = com.xiaoenai.app.utils.b.a.b(paramString2);
      paramb.a(i);
      paramb.b(paramString1);
      paramb.d(l1);
      paramb.b(paramInt);
      paramb.c(paramString2);
      c.a(paramb);
      return;
      label128:
      String str = EntityUtils.toString(paramString1);
      paramString1 = str;
      l1 = l2;
      if (str.length() > 256)
      {
        paramString1 = str.substring(0, 256);
        l1 = l2;
        continue;
        label169:
        i = paramString1.indexOf("?");
        if (-1 != i) {}
        for (paramString1 = paramString1.substring(i);; paramString1 = "")
        {
          l1 = paramString1.length();
          i = 0;
          break;
        }
        label209:
        paramString1 = "";
      }
    }
  }
  
  public static String c(String paramString, JSONObject paramJSONObject)
  {
    String str = paramString;
    if (!paramString.endsWith("?")) {
      str = paramString + "?";
    }
    paramString = URLEncodedUtils.format(a(paramJSONObject), "UTF-8");
    return str + paramString;
  }
  
  private JSONObject c()
  {
    Object localObject1 = null;
    String str1 = this.a.getURI().toString();
    String str2 = new URL(str1).getHost();
    Iterator localIterator = com.xiaoenai.app.net.a.b.a(str2).iterator();
    Object localObject2;
    for (;;)
    {
      localObject2 = localObject1;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject1 = str1.replace(str2, (String)localIterator.next());
      com.xiaoenai.app.utils.f.a.c(true, "requestUrl:{} \n realUrl:{}", new Object[] { str1, localObject1 });
      this.a.setHeader("Host", str2);
      this.a.setURI(new URI((String)localObject1));
      localObject1 = f.a().execute(this.a);
      int i = ((HttpResponse)localObject1).getStatusLine().getStatusCode();
      localObject1 = a((HttpResponse)localObject1, str1);
      localObject2 = localObject1;
      if (!v.a(i)) {
        break;
      }
      com.xiaoenai.app.utils.f.a.c("statusCode:{}", new Object[] { Integer.valueOf(i) });
    }
    return (JSONObject)localObject2;
  }
  
  private boolean d()
  {
    try
    {
      Object localObject = (ConnectivityManager)this.b.getSystemService("connectivity");
      if (localObject != null)
      {
        localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
        if ((localObject != null) && (((NetworkInfo)localObject).isConnectedOrConnecting()))
        {
          localObject = ((NetworkInfo)localObject).getState();
          NetworkInfo.State localState = NetworkInfo.State.CONNECTED;
          if (localObject == localState) {
            return true;
          }
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  public void a(String paramString, JSONObject paramJSONObject)
  {
    paramString = new HttpPost(paramString);
    paramString.setEntity(new UrlEncodedFormEntity(a(paramJSONObject), "UTF-8"));
    this.a = paramString;
  }
  
  public void a(String paramString1, JSONObject paramJSONObject, String paramString2)
  {
    paramString1 = new HttpPost(paramString1);
    MultipartEntity localMultipartEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
    localMultipartEntity.addPart("file", new FileBody(new File(paramString2)));
    localMultipartEntity.addPart("token", new StringBody(paramJSONObject.getString("token")));
    paramString1.setEntity(localMultipartEntity);
    this.a = paramString1;
  }
  
  public boolean a()
  {
    return this.a instanceof HttpPost;
  }
  
  public JSONObject b()
  {
    if (!d()) {
      throw new NetworkErrorException("网络好像有问题哦");
    }
    if (com.xiaoenai.app.h.a.a.a().a(this.b, "mzd_http_dns_enable", false)) {}
    for (Object localObject = c();; localObject = a(f.a().execute(this.a), (String)localObject))
    {
      if (localObject != null)
      {
        int i = ((JSONObject)localObject).optInt("httpStatusCode");
        v.a(this.b, i);
        v.b(this.b, i);
      }
      return (JSONObject)localObject;
      localObject = this.a.getURI().toString();
    }
  }
  
  public void b(String paramString, JSONObject paramJSONObject)
  {
    paramString = c(paramString, paramJSONObject);
    com.xiaoenai.app.utils.f.a.c("Http GET: url={}", new Object[] { paramString });
    this.a = new HttpGet(paramString);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\net\c\a\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */