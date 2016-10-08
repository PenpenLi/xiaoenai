package com.taobao.dp.http;

import android.content.Context;
import com.taobao.dp.b.i;
import com.taobao.dp.bean.ReqData;
import com.taobao.dp.bean.ServiceData;
import com.taobao.dp.c.e;
import com.taobao.dp.c.f;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a
{
  private i a;
  private IUrlRequestService b;
  private IResponseReceiver c;
  private Context d;
  private String e;
  private String f;
  private com.taobao.dp.client.a g;
  
  public a(Context paramContext, String paramString1, String paramString2, com.taobao.dp.client.a parama, IUrlRequestService paramIUrlRequestService, i parami)
  {
    this.d = paramContext;
    this.e = paramString1;
    this.f = paramString2;
    this.b = paramIUrlRequestService;
    this.a = parami;
    this.g = parama;
    this.c = new b(this);
  }
  
  private com.taobao.dp.bean.c a(int paramInt, byte[] paramArrayOfByte)
  {
    com.taobao.dp.bean.c localc = new com.taobao.dp.bean.c();
    if (paramArrayOfByte == null)
    {
      localc.a(paramInt);
      return localc;
    }
    if (paramInt == 200) {
      try
      {
        Object localObject = new JSONObject(new String(paramArrayOfByte, "UTF-8"));
        paramArrayOfByte = ((JSONObject)localObject).getString("payload");
        String str = com.taobao.dp.a.c.c(((JSONObject)localObject).getString("service") + ((JSONObject)localObject).getString("version") + ((JSONObject)localObject).getString("app") + paramArrayOfByte + ((JSONObject)localObject).getLong("timestamp"), this.e, this.f, this.d);
        localObject = ((JSONObject)localObject).getString("signature");
        if (localObject != null)
        {
          boolean bool = ((String)localObject).equals(str);
          if (bool) {}
        }
        else
        {
          paramInt = 1001;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        int i;
        label174:
        localc.a(1002);
        return localc;
      }
    }
    try
    {
      i = new JSONObject(paramArrayOfByte).getInt("code");
      paramInt = i;
    }
    catch (Exception paramArrayOfByte)
    {
      break label174;
    }
    localc.a(paramInt);
    return localc;
    paramArrayOfByte = com.taobao.dp.a.c.b(paramArrayOfByte, this.e, this.f, this.d);
    if (paramArrayOfByte != null)
    {
      paramArrayOfByte = new JSONObject(paramArrayOfByte);
      localc.a(paramArrayOfByte.getInt("code"));
      localc.a(paramArrayOfByte.getString("data"));
      paramArrayOfByte.getString("message");
      return localc;
    }
    localc.a(10006);
    return localc;
    localc.a(paramInt);
    return localc;
  }
  
  private void a(ReqData paramReqData)
  {
    com.taobao.dp.bean.c localc = new com.taobao.dp.bean.c();
    paramReqData = b(paramReqData);
    if (paramReqData == null)
    {
      localc.a(1003);
      this.a.a(localc);
      return;
    }
    if (this.b != null)
    {
      this.b.sendRequest(this.g.a(), paramReqData, this.c);
      return;
    }
    localc.a(1004);
    this.a.a(localc);
  }
  
  private String b(ReqData paramReqData)
  {
    label203:
    do
    {
      try
      {
        str = e.a(f.a(paramReqData));
        paramReqData = new ServiceData();
        paramReqData.setApp(this.e);
        paramReqData.setVersion("1.4.2");
        paramReqData.setService("com.taobao.tdp");
        paramReqData.setOs("android");
        paramReqData.setTimestamp(System.currentTimeMillis());
        str = com.taobao.dp.a.c.a(str, this.e, this.f, this.d);
        paramReqData.setPayload(str);
        str = com.taobao.dp.a.c.c(paramReqData.getService() + paramReqData.getVersion() + paramReqData.getApp() + paramReqData.getOs() + str + paramReqData.getTimestamp(), this.e, this.f, this.d);
        if ((str == null) || (str.length() == 0)) {
          break label203;
        }
        paramReqData.setSignature(str);
        paramReqData = e.a(f.a(paramReqData));
      }
      catch (Exception paramReqData)
      {
        String str;
        HashMap localHashMap;
        return null;
      }
      str = this.g.b();
      localHashMap = new HashMap();
      localHashMap.put("c", paramReqData);
      paramReqData = com.taobao.wireless.security.adapter.common.c.a(str, localHashMap);
      return paramReqData;
      paramReqData = null;
    } while (paramReqData != null);
    return null;
  }
  
  public final void a(String paramString1, String paramString2)
  {
    try
    {
      ReqData localReqData = new ReqData();
      localReqData.setAction(paramString1);
      localReqData.setData(paramString2);
      a(localReqData);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1 = new com.taobao.dp.bean.c();
      paramString1.a(1002);
      this.a.a(paramString1);
    }
  }
  
  public final void a(String paramString, JSONObject paramJSONObject)
  {
    try
    {
      ReqData localReqData = new ReqData();
      localReqData.setAction(paramString);
      localReqData.setData(paramJSONObject.toString());
      a(localReqData);
      return;
    }
    catch (Exception paramString)
    {
      paramString = new com.taobao.dp.bean.c();
      paramString.a(1002);
      this.a.a(paramString);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\dp\http\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */