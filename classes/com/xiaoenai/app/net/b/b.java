package com.xiaoenai.app.net.b;

import android.content.Context;
import android.content.res.Resources;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.utils.ae;
import java.io.InputStream;
import java.util.HashMap;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class b
{
  private static HashMap<String, a> a;
  private static b b;
  
  public static b a()
  {
    if (b == null) {}
    try
    {
      if (b == null)
      {
        b = new b();
        b.c();
      }
      return b;
    }
    finally {}
  }
  
  private String a(String paramString)
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
  
  public static void b()
  {
    a = null;
    b = null;
  }
  
  private void c()
  {
    try
    {
      InputStream localInputStream = Xiaoenai.j().getResources().openRawResource(2131034112);
      SAXParser localSAXParser = SAXParserFactory.newInstance().newSAXParser();
      c localc = new c();
      localSAXParser.parse(localInputStream, localc);
      localInputStream.close();
      a = localc.a();
      return;
    }
    catch (Exception localException)
    {
      a = null;
      com.xiaoenai.app.utils.f.a.c(true, "HttpAddressManager parserXml: {}", new Object[] { localException.getMessage() });
      localException.printStackTrace();
    }
  }
  
  public String a(Context paramContext, String paramString1, String paramString2)
  {
    String str = "";
    a locala;
    if (a != null)
    {
      locala = (a)a.get(paramString1);
      if (locala != null)
      {
        str = locala.b();
        if (paramString2.equals(paramContext.getResources().getStringArray(2131427329)[0]))
        {
          boolean bool = com.xiaoenai.app.h.a.a.a().a(paramContext, "mzd_https_enable", false);
          com.xiaoenai.app.utils.f.a.c("enable_https = {}", new Object[] { Boolean.valueOf(bool) });
          if (bool)
          {
            paramContext = locala.g();
            com.xiaoenai.app.utils.f.a.c("AddressName = {}", new Object[] { paramString1 });
            com.xiaoenai.app.utils.f.a.c("Address = {}", new Object[] { paramContext });
          }
        }
      }
    }
    for (;;)
    {
      paramString2 = paramContext;
      if (ae.a(paramContext)) {
        paramString2 = a(paramString1);
      }
      return paramString2;
      paramContext = locala.b();
      break;
      if (paramString2.equals(paramContext.getResources().getStringArray(2131427329)[1]))
      {
        paramContext = locala.g();
        break;
      }
      if (paramString2.equals(paramContext.getResources().getStringArray(2131427329)[2]))
      {
        paramContext = locala.d();
        break;
      }
      if (paramString2.equals(paramContext.getResources().getStringArray(2131427329)[3]))
      {
        if (com.xiaoenai.app.h.a.a.a().a(paramContext, "mzd_https_enable", false))
        {
          paramContext = locala.f();
          break;
        }
        paramContext = locala.c();
        break;
      }
      if (paramString2.equals(paramContext.getResources().getStringArray(2131427329)[4]))
      {
        paramContext = locala.f();
        break;
      }
      if (paramString2.equals(paramContext.getResources().getStringArray(2131427329)[5]))
      {
        paramContext = locala.e();
        break;
      }
      paramContext = str;
      break;
      paramContext = "";
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\net\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */