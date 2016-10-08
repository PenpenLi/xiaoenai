package com.alibaba.sdk.android.rpc.model;

import android.text.TextUtils;
import com.alibaba.sdk.android.util.JSONUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class RpcRequest
{
  public String domain;
  public Map<String, String> filter;
  public Map<String, Object> params;
  public String rpcReferer;
  public String seedKey = "seed_key";
  public String target;
  public String version;
  
  public static RpcRequest create(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString);
      RpcRequest localRpcRequest = new RpcRequest();
      localRpcRequest.target = JSONUtils.optString(paramString, "target");
      localRpcRequest.version = JSONUtils.optString(paramString, "version");
      localRpcRequest.params = JSONUtils.toMap(paramString.optJSONObject("params"));
      return localRpcRequest;
    }
    catch (JSONException paramString)
    {
      throw new RuntimeException(paramString);
    }
  }
  
  public String toString()
  {
    return "RpcRequest [target=" + this.target + ", version=" + this.version + ", params=" + this.params + ", domain=" + this.domain + ", seedKey=" + this.seedKey + ", rpcReferer=" + this.rpcReferer + ", filter=" + this.filter + "]";
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\rpc\model\RpcRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */