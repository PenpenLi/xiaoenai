package com.xiaoenai.app.net.http.base.b;

import android.content.Context;
import android.text.TextUtils;
import com.xiaoenai.app.net.http.base.e;
import org.json.JSONObject;

public class c
  extends a<JSONObject>
{
  public c(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(com.xiaoenai.app.net.http.base.a.c paramc, JSONObject paramJSONObject) {}
  
  public void a(e parame) {}
  
  public void a(JSONObject paramJSONObject) {}
  
  public JSONObject b(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new String(paramArrayOfByte);
    com.xiaoenai.app.utils.f.a.a(paramArrayOfByte);
    if (!TextUtils.isEmpty(paramArrayOfByte)) {
      return new JSONObject(paramArrayOfByte);
    }
    return null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\net\http\base\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */