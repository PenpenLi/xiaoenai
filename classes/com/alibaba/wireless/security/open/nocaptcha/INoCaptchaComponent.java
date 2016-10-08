package com.alibaba.wireless.security.open.nocaptcha;

import android.os.Handler;
import android.view.MotionEvent;
import com.alibaba.wireless.security.open.IComponent;

public abstract interface INoCaptchaComponent
  extends IComponent
{
  public static final int NC_INIT_STAGE = 1;
  public static final int NC_VERIFY_SATGE = 2;
  public static final int SG_ERROR_NOCAPTCHA = 1200;
  public static final int SG_NC_FAILED = 105;
  public static final int SG_NC_GET_CONFIG_FAILED = 1213;
  public static final int SG_NC_HTTP_NO_TOKEN = 1206;
  public static final int SG_NC_HTTP_REQUEST_FAIL = 1207;
  public static final int SG_NC_INIT_SUCCEED = 101;
  public static final int SG_NC_INVALID_PARA = 1201;
  public static final int SG_NC_NOT_INIT_YET = 1203;
  public static final int SG_NC_NO_MEMORY = 1202;
  public static final int SG_NC_QUEUE_FULL = 1204;
  public static final int SG_NC_RETRY = 103;
  public static final int SG_NC_RETRY_TO_MAX = 1205;
  public static final int SG_NC_SERVER_FAULT = 104;
  public static final int SG_NC_SERVER_RETURN_ERROR = 1208;
  public static final int SG_NC_START = 100;
  public static final int SG_NC_UNKNOWN_ERROR = 1299;
  public static final int SG_NC_VERI_APPKEY_MISMATCH = 1211;
  public static final int SG_NC_VERI_GET_TRACE_FAIL = 1210;
  public static final int SG_NC_VERI_GET_WUA_FAIL = 1209;
  public static final int SG_NC_VERI_SESSION_EXPIRED = 1212;
  public static final int SG_NC_VERI_SUCCEED = 102;
  public static final String errorCode = "errorCode";
  public static final String sessionId = "sessionId";
  public static final String sig = "sig";
  public static final String status = "status";
  public static final String token = "token";
  public static final String x1 = "x1";
  public static final String x2 = "x2";
  public static final String y1 = "y1";
  public static final String y2 = "y2";
  
  public abstract void initNoCaptcha(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, Handler paramHandler, String paramString3);
  
  public abstract void noCaptchaVerification(String paramString);
  
  public abstract boolean putNoCaptchaTraceRecord(MotionEvent paramMotionEvent);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\wireless\security\open\nocaptcha\INoCaptchaComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */