package com.alibaba.sdk.android;

import com.alibaba.sdk.android.message.Message;
import com.alibaba.sdk.android.message.MessageUtils;

public class ResultCode
{
  @Deprecated
  public static final ResultCode ALIPAY_AUTH_FAIL_CODE;
  @Deprecated
  public static final ResultCode ALREADY_LOGOUT;
  @Deprecated
  public static final ResultCode BRIDGE_EXCEPTION;
  @Deprecated
  public static final ResultCode GET_ORDER_URL_EXCEPTION;
  @Deprecated
  public static final ResultCode HTTP_REQUEST_EXCEPTION;
  @Deprecated
  public static final ResultCode ILLEGAL_PARAM;
  @Deprecated
  public static final ResultCode INIT_EXCEPTION;
  @Deprecated
  public static final ResultCode NEED_AUTHORIZE;
  @Deprecated
  public static final ResultCode NETWORK_NOT_AVAILABLE;
  @Deprecated
  public static final ResultCode NO_SUCH_METHOD;
  @Deprecated
  public static final ResultCode PLUGIN_START_FAIL = new ResultCode(10022, "PLUGIN_START_FAIL");
  @Deprecated
  public static final ResultCode QUERY_ORDER_RESULT_EXCEPTION;
  @Deprecated
  public static final ResultCode REFRESH_SID_EXCEPTION;
  @Deprecated
  public static final ResultCode REQUEST_INIT_SERVER_EXCEPTION;
  @Deprecated
  public static final ResultCode RSA_DECRYPT_EXCEPTION;
  @Deprecated
  public static final ResultCode SDK_NOT_INITED_EXCEPTION;
  @Deprecated
  public static final ResultCode SECURITY_GUARD_INIT_EXCEPTION;
  public static final ResultCode SUCCESS = new ResultCode(100, "SUCCESS");
  @Deprecated
  public static final ResultCode SYSTEM_EXCEPTION;
  @Deprecated
  public static final ResultCode TAOKE_TRACE_FAIL;
  @Deprecated
  public static final ResultCode TB_BIND_FAIL;
  @Deprecated
  public static final ResultCode UMID_INIT_FAIL;
  @Deprecated
  public static final ResultCode UNSUPPORTED_ITEM_TYPE;
  @Deprecated
  public static final ResultCode USER_CANCEL;
  @Deprecated
  public static final ResultCode USER_LOGOUT;
  public int code;
  public String message;
  
  static
  {
    REFRESH_SID_EXCEPTION = new ResultCode(101);
    NO_SUCH_METHOD = new ResultCode(10000, "NO_SUCH_METHOD");
    BRIDGE_EXCEPTION = new ResultCode(10001, "BRIDGE_EXCEPTION");
    INIT_EXCEPTION = new ResultCode(10002, "INIT_EXCEPTION");
    USER_CANCEL = new ResultCode(10003, "USER_CANCEL");
    REQUEST_INIT_SERVER_EXCEPTION = new ResultCode(10004, "INIT_SID_EXCEPTION");
    RSA_DECRYPT_EXCEPTION = new ResultCode(10005);
    HTTP_REQUEST_EXCEPTION = new ResultCode(10006);
    UNSUPPORTED_ITEM_TYPE = new ResultCode(10007, "UNSUPPORTED_ITEM_TYPE");
    GET_ORDER_URL_EXCEPTION = new ResultCode(10008, "GET_ORDER_URL_EXCEPTION");
    QUERY_ORDER_RESULT_EXCEPTION = new ResultCode(10009, "QUERY_ORDER_RESULT_EXCEPTION");
    SYSTEM_EXCEPTION = new ResultCode(10010, "SYSTEM_EXCEPTION");
    ALREADY_LOGOUT = new ResultCode(10011, "AREADY_LOGOUT");
    SDK_NOT_INITED_EXCEPTION = new ResultCode(10012, "SDK_NOT_INITED_EXCEPTION");
    ILLEGAL_PARAM = new ResultCode(10013, "ILLEGAL_PARAM");
    NETWORK_NOT_AVAILABLE = new ResultCode(10014, "NETWORK_NOT_AVAILABLE");
    USER_LOGOUT = new ResultCode(10015, "USER_LOGOUT");
    SECURITY_GUARD_INIT_EXCEPTION = new ResultCode(10016, "SECURITY_GUARD_INIT_EXCEPTION");
    NEED_AUTHORIZE = new ResultCode(10017, "NEED_AUTHORIZE");
    TAOKE_TRACE_FAIL = new ResultCode(10018, "TAOKE_TRACE_FAIL");
    UMID_INIT_FAIL = new ResultCode(10019, "UMID_INIT_FAIL");
    ALIPAY_AUTH_FAIL_CODE = new ResultCode(10020, "ALIPAY_AUTH_CODE");
    TB_BIND_FAIL = new ResultCode(10021, "TB_BIND_FAIL");
  }
  
  public ResultCode(int paramInt)
  {
    this(paramInt, null);
  }
  
  public ResultCode(int paramInt, String paramString)
  {
    this.code = paramInt;
    this.message = paramString;
  }
  
  public static ResultCode create(int paramInt, Object... paramVarArgs)
  {
    return new ResultCode(paramInt, MessageUtils.getMessageContent(paramInt, paramVarArgs));
  }
  
  public static ResultCode create(Message paramMessage)
  {
    return new ResultCode(paramMessage.code, paramMessage.message);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (ResultCode)paramObject;
    } while (this.code == ((ResultCode)paramObject).code);
    return false;
  }
  
  public int hashCode()
  {
    return this.code + 31;
  }
  
  public boolean isSuccess()
  {
    return this.code == 100;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\ResultCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */