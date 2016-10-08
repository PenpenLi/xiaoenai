package com.alibaba.sdk.android.rpc;

import com.alibaba.sdk.android.rpc.codec.DynamicByteBuffer;
import com.alibaba.sdk.android.rpc.impl.RpcContext;
import com.alibaba.sdk.android.rpc.model.RpcRequest;
import com.alibaba.sdk.android.rpc.utils.ProtocolUtils;
import com.alibaba.sdk.android.security.SecurityGuardService;
import com.alibaba.sdk.android.util.JSONUtils;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class ServiceRequest
{
  private static final String DEFAULT_DOMAIN = "taobao";
  private static final String UTF_8 = "UTF-8";
  public long clientTimestamp;
  public byte[] customParams;
  public Map<String, Object> headers = new HashMap();
  public JSONObject jsonParams;
  public String platformId;
  public String region;
  public RpcRequest rpcRequest;
  public String sid;
  public int timeout = 15000;
  
  private void assembleBody(byte paramByte, DynamicByteBuffer paramDynamicByteBuffer)
  {
    if (this.customParams != null) {
      paramDynamicByteBuffer.put(this.customParams);
    }
    do
    {
      return;
      if (paramByte == 1)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        Iterator localIterator;
        if ((this.rpcRequest.params != null) && (!this.rpcRequest.params.isEmpty())) {
          localIterator = this.rpcRequest.params.entrySet().iterator();
        }
        while (localIterator.hasNext())
        {
          Object localObject1 = (Map.Entry)localIterator.next();
          Object localObject2 = ((Map.Entry)localObject1).getValue();
          if (localObject2 != null)
          {
            localStringBuilder.append(encode((String)((Map.Entry)localObject1).getKey())).append("=").append(encode(localObject2.toString())).append("&");
            continue;
            if (this.jsonParams != null)
            {
              localIterator = this.jsonParams.keys();
              while (localIterator.hasNext())
              {
                localObject1 = (String)localIterator.next();
                localObject2 = this.jsonParams.get((String)localObject1);
                if (localObject2 != null) {
                  localStringBuilder.append(encode((String)localObject1)).append("=").append(encode(localObject2.toString())).append("&");
                }
              }
            }
          }
        }
        paramDynamicByteBuffer.put(localStringBuilder.toString().getBytes("UTF-8"));
        return;
      }
      if ((this.rpcRequest.params != null) && (!this.rpcRequest.params.isEmpty()))
      {
        paramDynamicByteBuffer.put(JSONUtils.toJsonObject(this.rpcRequest.params).toString().getBytes("UTF-8"));
        return;
      }
    } while (this.jsonParams == null);
    paramDynamicByteBuffer.put(this.jsonParams.toString().getBytes("UTF-8"));
  }
  
  private String encode(String paramString)
  {
    return URLEncoder.encode(paramString, "UTF-8");
  }
  
  private boolean isHttpOrHttps(String paramString)
  {
    return (paramString.startsWith("http://")) || (paramString.startsWith("https://"));
  }
  
  public byte[] toBytes(boolean paramBoolean)
  {
    byte b2 = 2;
    if ((this.jsonParams == null) && (this.rpcRequest.params == null) && (this.customParams == null)) {
      throw new ServiceInvokeException(ServiceInvokeException.ServiceInvokeExceptionType.SYSTEM_ERROR, "at least one type of payload should be set for the current request");
    }
    DynamicByteBuffer localDynamicByteBuffer = DynamicByteBuffer.allocate(1024);
    byte b1;
    Object localObject1;
    if (isHttpOrHttps(this.rpcRequest.target))
    {
      b1 = 1;
      localDynamicByteBuffer.put(b1);
      if (this.rpcRequest.version != null) {
        break label222;
      }
      localObject1 = RpcContext.defaultAPIVersion;
      label85:
      if (!isHttpOrHttps(this.rpcRequest.target)) {
        break label234;
      }
      localObject1 = this.rpcRequest.target;
      ProtocolUtils.encodeString(localDynamicByteBuffer, (String)localObject1);
      if (this.customParams == null) {
        break label294;
      }
      label122:
      localDynamicByteBuffer.put(b2);
      localObject1 = this.headers;
      if (this.clientTimestamp != 0L) {
        break label299;
      }
    }
    label222:
    label234:
    label294:
    label299:
    for (long l = System.currentTimeMillis();; l = this.clientTimestamp)
    {
      ((Map)localObject1).put("clientTimestamp", String.valueOf(l));
      ProtocolUtils.encodeHeaders(localDynamicByteBuffer, this.headers);
      assembleBody(b1, localDynamicByteBuffer);
      Object localObject2 = localDynamicByteBuffer.array();
      localObject1 = localObject2;
      if (paramBoolean) {
        localObject1 = RpcContext.securityGuardService.symEncrypt((byte[])localObject2, this.rpcRequest.seedKey);
      }
      return (byte[])localObject1;
      b1 = 2;
      break;
      localObject1 = this.rpcRequest.version;
      break label85;
      if (this.rpcRequest.domain == null) {}
      for (localObject2 = "taobao";; localObject2 = this.rpcRequest.domain)
      {
        localObject1 = String.format("%s;%s;%s", new Object[] { localObject2, this.rpcRequest.target, localObject1 });
        break;
      }
      b2 = 0;
      break label122;
    }
  }
  
  public String toString()
  {
    return "ServiceRequest [rpcRequest=" + this.rpcRequest + ", region=" + this.region + ", sid=" + this.sid + ", headers=" + this.headers + ", jsonParams=" + this.jsonParams + ", customParams=" + Arrays.toString(this.customParams) + ", clientTimestamp=" + this.clientTimestamp + ", platformId=" + this.platformId + ", timeout=" + this.timeout + "]";
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\rpc\ServiceRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */