package com.b.a.a;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;

class b
  implements HttpRequestInterceptor
{
  b(a parama) {}
  
  public void process(HttpRequest paramHttpRequest, HttpContext paramHttpContext)
  {
    if (!paramHttpRequest.containsHeader("Accept-Encoding")) {
      paramHttpRequest.addHeader("Accept-Encoding", "gzip");
    }
    paramHttpContext = a.a(this.a).keySet().iterator();
    while (paramHttpContext.hasNext())
    {
      String str = (String)paramHttpContext.next();
      if (paramHttpRequest.containsHeader(str))
      {
        Header localHeader = paramHttpRequest.getFirstHeader(str);
        a.a.b("AsyncHttpClient", String.format("Headers were overwritten! (%s | %s) overwrites (%s | %s)", new Object[] { str, a.a(this.a).get(str), localHeader.getName(), localHeader.getValue() }));
        paramHttpRequest.removeHeader(localHeader);
      }
      paramHttpRequest.addHeader(str, (String)a.a(this.a).get(str));
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\b\a\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */