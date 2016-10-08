package com.taobao.applink.exception;

public class TBAppLinkException
  extends Exception
{
  public TBAppLinkException(TBAppLinkExceptionCode paramTBAppLinkExceptionCode)
  {
    super(getErrorMsg(paramTBAppLinkExceptionCode));
  }
  
  public TBAppLinkException(String paramString)
  {
    super(paramString);
  }
  
  private static String getErrorMsg(TBAppLinkExceptionCode paramTBAppLinkExceptionCode)
  {
    if (paramTBAppLinkExceptionCode == null) {
      return "AppLinkSDK error!";
    }
    return "AppLinkSDK error! code: " + paramTBAppLinkExceptionCode.mCode;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\applink\exception\TBAppLinkException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */