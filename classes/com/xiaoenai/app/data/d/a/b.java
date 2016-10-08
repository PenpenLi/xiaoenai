package com.xiaoenai.app.data.d.a;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.xiaoenai.app.data.a.a;
import java.io.InputStream;
import java.util.HashMap;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

@Singleton
public class b
{
  private HashMap<String, a> a;
  private final Context b;
  private e c;
  private int d = 0;
  
  @Inject
  public b(Context paramContext, e parame)
  {
    this.b = paramContext;
    this.c = parame;
    this.d = parame.a();
    c();
  }
  
  private String b(String paramString)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return "";
        if (paramString.equals("baseURL"))
        {
          i = 0;
          continue;
          if (paramString.equals("appsURL"))
          {
            i = 1;
            continue;
            if (paramString.equals("notificationURL"))
            {
              i = 2;
              continue;
              if (paramString.equals("socketURL"))
              {
                i = 3;
                continue;
                if (paramString.equals("forumUrl"))
                {
                  i = 4;
                  continue;
                  if (paramString.equals("uploadBaseURL"))
                  {
                    i = 5;
                    continue;
                    if (paramString.equals("imageBaseURL"))
                    {
                      i = 6;
                      continue;
                      if (paramString.equals("voiceBaseURL"))
                      {
                        i = 7;
                        continue;
                        if (paramString.equals("socketURL2"))
                        {
                          i = 8;
                          continue;
                          if (paramString.equals("authSdkUrl"))
                          {
                            i = 9;
                            continue;
                            if (paramString.equals("messageUrl"))
                            {
                              i = 10;
                              continue;
                              if (paramString.equals("verifyUrl"))
                              {
                                i = 11;
                                continue;
                                if (paramString.equals("forumImageURL"))
                                {
                                  i = 12;
                                  continue;
                                  if (paramString.equals("mallImageUploadURL"))
                                  {
                                    i = 13;
                                    continue;
                                    if (paramString.equals("orderURL"))
                                    {
                                      i = 14;
                                      continue;
                                      if (paramString.equals("adsURL"))
                                      {
                                        i = 15;
                                        continue;
                                        if (paramString.equals("configURL"))
                                        {
                                          i = 16;
                                          continue;
                                          if (paramString.equals("forumShareURL"))
                                          {
                                            i = 17;
                                            continue;
                                            if (paramString.equals("streetURL"))
                                            {
                                              i = 18;
                                              continue;
                                              if (paramString.equals("streetImageUploadURL"))
                                              {
                                                i = 19;
                                                continue;
                                                if (paramString.equals("statURL"))
                                                {
                                                  i = 20;
                                                  continue;
                                                  if (paramString.equals("gameURL"))
                                                  {
                                                    i = 21;
                                                    continue;
                                                    if (paramString.equals("emchatAppkey"))
                                                    {
                                                      i = 22;
                                                      continue;
                                                      if (paramString.equals("streetGuideURL")) {
                                                        i = 23;
                                                      }
                                                    }
                                                  }
                                                }
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    return "http://api.xiaoenai.com/";
    return "http://apps.api.xiaoenai.com/";
    return "http://noti.api.xiaoenai.com/";
    return "http://socket.api.xiaoenai.com/";
    return "http://forum2.api.xiaoenai.com/";
    return "http://upxea.qiniu.com/";
    return "http://a0.cdn.xiaoenai.com/";
    return "http://a3.cdn.xiaoenai.com/";
    return "http://42.62.56.53/";
    return "http://openapi.xiaoenai.com/";
    return "http://msg.api.xiaoenai.com/";
    return "http://sms.api.xiaoenai.com/";
    return "http://a5.cdn.xiaoenai.com/";
    return "http://a6.cdn.xiaoenai.com/";
    return "http://order.mall.xiaoenai.com/";
    return "http://ads.api.xiaoenai.com/";
    return "http://conf.api.xiaoenai.com/";
    return "http://shuo.xiaoenai.com/";
    return "http://gw01.api.xiaoenai.com/";
    return "http://a6.cdn.xiaoenai.com/";
    return "http://gw01.api.xiaoenai.com/";
    return "http://gw01.api.xiaoenai.com/";
    return "mzd2015#xiaoenai2015";
    return "http://gw01.api.xiaoenai.com/";
  }
  
  private void c()
  {
    try
    {
      InputStream localInputStream = this.b.getResources().openRawResource(a.a.address);
      SAXParser localSAXParser = SAXParserFactory.newInstance().newSAXParser();
      d locald = new d();
      localSAXParser.parse(localInputStream, locald);
      localInputStream.close();
      this.a = locald.a();
      return;
    }
    catch (Exception localException)
    {
      this.a = null;
      com.xiaoenai.app.utils.f.a.c(true, "HttpAddressManager parserXml: {}", new Object[] { localException.getMessage() });
      localException.printStackTrace();
    }
  }
  
  public String a(String paramString)
  {
    String str = "";
    Object localObject;
    if (this.a != null)
    {
      localObject = (a)this.a.get(paramString);
      if (localObject != null)
      {
        str = ((a)localObject).b();
        if (this.c.a() == 0)
        {
          str = ((a)localObject).b();
          com.xiaoenai.app.utils.f.a.c("AddressName = {}", new Object[] { paramString });
          com.xiaoenai.app.utils.f.a.c("Address = {}", new Object[] { str });
        }
      }
    }
    for (;;)
    {
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = b(paramString);
      }
      return (String)localObject;
      if (this.c.a() == 1)
      {
        str = ((a)localObject).g();
        break;
      }
      if (this.c.a() == 4)
      {
        str = ((a)localObject).d();
        break;
      }
      if (this.c.a() == 2)
      {
        str = ((a)localObject).c();
        break;
      }
      if (this.c.a() == 3)
      {
        str = ((a)localObject).f();
        break;
      }
      if (this.c.a() == 5)
      {
        str = ((a)localObject).e();
        break;
      }
      break;
      str = "";
    }
  }
  
  public boolean a()
  {
    return this.d != this.c.a();
  }
  
  public void b()
  {
    this.d = this.c.a();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\data\d\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */