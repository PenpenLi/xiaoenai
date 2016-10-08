package com.alibaba.nb.android.trade.utils;

public class AliTradeResultCode
{
  @Deprecated
  public static final AliTradeResultCode ALIPAY_AUTH_FAIL_CODE;
  @Deprecated
  public static final AliTradeResultCode ALREADY_LOGOUT;
  @Deprecated
  public static final AliTradeResultCode BRIDGE_EXCEPTION;
  @Deprecated
  public static final AliTradeResultCode GET_ORDER_URL_EXCEPTION;
  @Deprecated
  public static final AliTradeResultCode HTTP_REQUEST_EXCEPTION;
  @Deprecated
  public static final AliTradeResultCode ILLEGAL_PARAM;
  @Deprecated
  public static final AliTradeResultCode INIT_EXCEPTION;
  @Deprecated
  public static final AliTradeResultCode NEED_AUTHORIZE;
  @Deprecated
  public static final AliTradeResultCode NETWORK_NOT_AVAILABLE;
  @Deprecated
  public static final AliTradeResultCode NO_SUCH_METHOD;
  @Deprecated
  public static final AliTradeResultCode PLUGIN_START_FAIL = new AliTradeResultCode(10022, "PLUGIN_START_FAIL");
  @Deprecated
  public static final AliTradeResultCode QUERY_ORDER_RESULT_EXCEPTION;
  @Deprecated
  public static final AliTradeResultCode REFRESH_SID_EXCEPTION;
  @Deprecated
  public static final AliTradeResultCode REQUEST_INIT_SERVER_EXCEPTION;
  @Deprecated
  public static final AliTradeResultCode RSA_DECRYPT_EXCEPTION;
  @Deprecated
  public static final AliTradeResultCode SDK_NOT_INITED_EXCEPTION;
  @Deprecated
  public static final AliTradeResultCode SECURITY_GUARD_INIT_EXCEPTION;
  public static final AliTradeResultCode SUCCESS = new AliTradeResultCode(100, "SUCCESS");
  @Deprecated
  public static final AliTradeResultCode SYSTEM_EXCEPTION;
  @Deprecated
  public static final AliTradeResultCode TAOKE_TRACE_FAIL;
  @Deprecated
  public static final AliTradeResultCode TB_BIND_FAIL;
  @Deprecated
  public static final AliTradeResultCode UMID_INIT_FAIL;
  @Deprecated
  public static final AliTradeResultCode UNSUPPORTED_ITEM_TYPE;
  @Deprecated
  public static final AliTradeResultCode USER_CANCEL;
  @Deprecated
  public static final AliTradeResultCode USER_LOGOUT;
  public int code;
  public String message;
  
  static
  {
    REFRESH_SID_EXCEPTION = new AliTradeResultCode(101);
    NO_SUCH_METHOD = new AliTradeResultCode(10000, "NO_SUCH_METHOD");
    BRIDGE_EXCEPTION = new AliTradeResultCode(10001, "BRIDGE_EXCEPTION");
    INIT_EXCEPTION = new AliTradeResultCode(10002, "INIT_EXCEPTION");
    USER_CANCEL = new AliTradeResultCode(10003, "USER_CANCEL");
    REQUEST_INIT_SERVER_EXCEPTION = new AliTradeResultCode(10004, "INIT_SID_EXCEPTION");
    RSA_DECRYPT_EXCEPTION = new AliTradeResultCode(10005);
    HTTP_REQUEST_EXCEPTION = new AliTradeResultCode(10006);
    UNSUPPORTED_ITEM_TYPE = new AliTradeResultCode(10007, "UNSUPPORTED_ITEM_TYPE");
    GET_ORDER_URL_EXCEPTION = new AliTradeResultCode(10008, "GET_ORDER_URL_EXCEPTION");
    QUERY_ORDER_RESULT_EXCEPTION = new AliTradeResultCode(10009, "QUERY_ORDER_RESULT_EXCEPTION");
    SYSTEM_EXCEPTION = new AliTradeResultCode(10010, "SYSTEM_EXCEPTION");
    ALREADY_LOGOUT = new AliTradeResultCode(10011, "AREADY_LOGOUT");
    SDK_NOT_INITED_EXCEPTION = new AliTradeResultCode(10012, "SDK_NOT_INITED_EXCEPTION");
    ILLEGAL_PARAM = new AliTradeResultCode(10013, "ILLEGAL_PARAM");
    NETWORK_NOT_AVAILABLE = new AliTradeResultCode(10014, "NETWORK_NOT_AVAILABLE");
    USER_LOGOUT = new AliTradeResultCode(10015, "USER_LOGOUT");
    SECURITY_GUARD_INIT_EXCEPTION = new AliTradeResultCode(10016, "SECURITY_GUARD_INIT_EXCEPTION");
    NEED_AUTHORIZE = new AliTradeResultCode(10017, "NEED_AUTHORIZE");
    TAOKE_TRACE_FAIL = new AliTradeResultCode(10018, "TAOKE_TRACE_FAIL");
    UMID_INIT_FAIL = new AliTradeResultCode(10019, "UMID_INIT_FAIL");
    ALIPAY_AUTH_FAIL_CODE = new AliTradeResultCode(10020, "ALIPAY_AUTH_CODE");
    TB_BIND_FAIL = new AliTradeResultCode(10021, "TB_BIND_FAIL");
  }
  
  public AliTradeResultCode(int paramInt)
  {
    this(paramInt, null);
  }
  
  public AliTradeResultCode(int paramInt, String paramString)
  {
    this.code = paramInt;
    this.message = paramString;
  }
  
  public boolean isSuccess()
  {
    return this.code == 100;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\utils\AliTradeResultCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */