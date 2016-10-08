package com.alibaba.sdk.android.initialization;

import org.json.JSONObject;

public abstract interface InitializationHandler<T>
{
  public static final int REQUEST_REQUIREMENT_MUST = 1;
  public static final int REQUEST_REQUIREMENT_NEVER = 2;
  public static final int REQUEST_REQUIREMENT_OPTIMISTIK = 3;
  
  public abstract Object createRequestParameters();
  
  public abstract String getRequestParameterKey();
  
  public abstract int getRequestRequirement();
  
  public abstract int getRequestServiceType();
  
  public abstract String getResponseValueKey();
  
  public abstract void handleResponseError(int paramInt, String paramString);
  
  public abstract T handleResponseValue(JSONObject paramJSONObject);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\initialization\InitializationHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */