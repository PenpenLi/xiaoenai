package com.alibaba.mtl.log.e;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.mtl.log.model.LogField;
import com.alibaba.mtl.log.sign.IRequestAuth;
import com.alibaba.mtl.log.sign.SecurityRequestAuth;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Set;

public class t
{
  private static final String TAG = t.class.getSimpleName();
  
  private static String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Object localObject1 = com.alibaba.mtl.log.a.getContext();
    String str2 = b.getAppkey();
    String str1 = b.l();
    if (str1 == null) {
      str1 = "";
    }
    for (;;)
    {
      String str3 = (String)d.a((Context)localObject1).get(LogField.APPVERSION.toString());
      String str4 = (String)d.a((Context)localObject1).get(LogField.OS.toString());
      String str5 = (String)d.a((Context)localObject1).get(LogField.UTDID.toString());
      String str6 = String.valueOf(System.currentTimeMillis());
      IRequestAuth localIRequestAuth = com.alibaba.mtl.log.a.a();
      localObject1 = "0";
      if ((localIRequestAuth instanceof SecurityRequestAuth)) {
        localObject1 = "1";
      }
      StringBuilder localStringBuilder = new StringBuilder().append(str2).append(str1).append(str3).append(str4).append("2.4.8_for_bc").append(str5).append(str6).append("3.0").append((String)localObject1);
      Object localObject2 = paramString3;
      if (paramString3 == null) {
        localObject2 = "";
      }
      localObject2 = localStringBuilder.append((String)localObject2);
      paramString3 = paramString4;
      if (paramString4 == null) {
        paramString3 = "";
      }
      paramString4 = localIRequestAuth.getSign(j.b(paramString3.getBytes()));
      paramString3 = "";
      if (!TextUtils.isEmpty(paramString2)) {
        paramString3 = paramString2 + "&";
      }
      return String.format("%s?%sak=%s&av=%s&c=%s&v=%s&s=%s&d=%s&sv=%s&p=%s&t=%s&u=%s&is=%s", new Object[] { paramString1, paramString3, c(str2), c(str3), c(str1), c("3.0"), c(paramString4), c(str5), "2.4.8_for_bc", str4, str6, "", localObject1 });
    }
  }
  
  public static String a(String paramString, Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    Object localObject1 = "";
    paramMap1 = (Map<String, Object>)localObject1;
    if (paramMap2 != null)
    {
      paramMap1 = (Map<String, Object>)localObject1;
      if (paramMap2.size() > 0)
      {
        paramMap1 = paramMap2.keySet();
        localObject1 = new String[paramMap1.size()];
        paramMap1.toArray((Object[])localObject1);
        localObject1 = g.a().a((String[])localObject1, true);
        int j = localObject1.length;
        int i = 0;
        paramMap1 = "";
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          byte[] arrayOfByte = (byte[])paramMap2.get(localObject2);
          paramMap1 = paramMap1 + (String)localObject2 + j.b(arrayOfByte);
          i += 1;
        }
      }
    }
    try
    {
      paramString = a(paramString, null, null, paramMap1);
      paramMap2 = com.alibaba.mtl.log.a.a.S;
      paramMap1 = paramString;
      if (!TextUtils.isEmpty(paramMap2)) {
        paramMap1 = paramString + "&dk=" + URLEncoder.encode(paramMap2, "UTF-8");
      }
      return paramMap1;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        paramString = a(com.alibaba.mtl.log.a.a.R, null, null, paramMap1);
      }
    }
  }
  
  private static String c(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    try
    {
      String str = URLEncoder.encode(paramString, "UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
    return paramString;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\log\e\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */