package com.taobao.applink.jsbridge;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TBBridgeMessage
{
  private static final String CALLBACK_ID_STR = "callbackId";
  private static final String DATA_STR = "data";
  private static final String HANDLER_NAME_STR = "handlerName";
  private static final String RESPONSE_DATA_STR = "responseData";
  private static final String RESPONSE_ID_STR = "responseId";
  private String callbackId;
  private String data;
  private String handlerName;
  private String responseData;
  private String responseId;
  
  public static List<TBBridgeMessage> toArrayList(String paramString)
  {
    localArrayList = new ArrayList();
    try
    {
      JSONArray localJSONArray = new JSONArray(paramString);
      int i = 0;
      if (i < localJSONArray.length())
      {
        TBBridgeMessage localTBBridgeMessage = new TBBridgeMessage();
        JSONObject localJSONObject = localJSONArray.getJSONObject(i);
        if (localJSONObject.has("handlerName"))
        {
          paramString = localJSONObject.getString("handlerName");
          label63:
          localTBBridgeMessage.setHandlerName(paramString);
          if (!localJSONObject.has("callbackId")) {
            break label182;
          }
          paramString = localJSONObject.getString("callbackId");
          label86:
          localTBBridgeMessage.setCallbackId(paramString);
          if (!localJSONObject.has("responseData")) {
            break label187;
          }
          paramString = localJSONObject.getString("responseData");
          label109:
          localTBBridgeMessage.setResponseData(paramString);
          if (!localJSONObject.has("responseId")) {
            break label192;
          }
          paramString = localJSONObject.getString("responseId");
          label132:
          localTBBridgeMessage.setResponseId(paramString);
          if (!localJSONObject.has("data")) {
            break label197;
          }
        }
        label182:
        label187:
        label192:
        label197:
        for (paramString = localJSONObject.getString("data");; paramString = null)
        {
          localTBBridgeMessage.setData(paramString);
          localArrayList.add(localTBBridgeMessage);
          i += 1;
          break;
          paramString = null;
          break label63;
          paramString = null;
          break label86;
          paramString = null;
          break label109;
          paramString = null;
          break label132;
        }
      }
      return localArrayList;
    }
    catch (JSONException paramString)
    {
      Log.d("AppLink", paramString.toString());
    }
  }
  
  public static TBBridgeMessage toObject(String paramString)
  {
    Object localObject = null;
    localTBBridgeMessage = new TBBridgeMessage();
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      if (localJSONObject.has("handlerName"))
      {
        paramString = localJSONObject.getString("handlerName");
        localTBBridgeMessage.setHandlerName(paramString);
        if (!localJSONObject.has("callbackId")) {
          break label133;
        }
        paramString = localJSONObject.getString("callbackId");
        label56:
        localTBBridgeMessage.setCallbackId(paramString);
        if (!localJSONObject.has("responseData")) {
          break label138;
        }
        paramString = localJSONObject.getString("responseData");
        label77:
        localTBBridgeMessage.setResponseData(paramString);
        if (!localJSONObject.has("responseId")) {
          break label143;
        }
      }
      label133:
      label138:
      label143:
      for (paramString = localJSONObject.getString("responseId");; paramString = null)
      {
        localTBBridgeMessage.setResponseId(paramString);
        paramString = (String)localObject;
        if (localJSONObject.has("data")) {
          paramString = localJSONObject.getString("data");
        }
        localTBBridgeMessage.setData(paramString);
        return localTBBridgeMessage;
        paramString = null;
        break;
        paramString = null;
        break label56;
        paramString = null;
        break label77;
      }
      return localTBBridgeMessage;
    }
    catch (JSONException paramString)
    {
      Log.d("AppLink", paramString.toString());
    }
  }
  
  public String getCallbackId()
  {
    return this.callbackId;
  }
  
  public String getData()
  {
    return this.data;
  }
  
  public String getHandlerName()
  {
    return this.handlerName;
  }
  
  public String getResponseData()
  {
    return this.responseData;
  }
  
  public String getResponseId()
  {
    return this.responseId;
  }
  
  public void setCallbackId(String paramString)
  {
    this.callbackId = paramString;
  }
  
  public void setData(String paramString)
  {
    this.data = paramString;
  }
  
  public void setHandlerName(String paramString)
  {
    this.handlerName = paramString;
  }
  
  public void setResponseData(String paramString)
  {
    this.responseData = paramString;
  }
  
  public void setResponseId(String paramString)
  {
    this.responseId = paramString;
  }
  
  public String toJson()
  {
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("callbackId", getCallbackId());
      ((JSONObject)localObject).put("data", getData());
      ((JSONObject)localObject).put("handlerName", getHandlerName());
      ((JSONObject)localObject).put("responseData", getResponseData());
      ((JSONObject)localObject).put("responseId", getResponseId());
      localObject = ((JSONObject)localObject).toString();
      return (String)localObject;
    }
    catch (JSONException localJSONException)
    {
      Log.d("AppLink", localJSONException.toString());
    }
    return null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\applink\jsbridge\TBBridgeMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */