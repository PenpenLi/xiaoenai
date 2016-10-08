package com.taobao.applink;

public class TBAppLinkParam
{
  public String mAppSecret;
  public String mAppkey;
  public String mBackUrl;
  public String mPid;
  public String mSource;
  public String mTag;
  public String mTtid;
  public String mUtdid;
  
  public TBAppLinkParam(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.mAppkey = paramString1;
    this.mAppSecret = paramString2;
    this.mBackUrl = paramString3;
    this.mPid = paramString4;
  }
  
  public TBAppLinkParam(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    this.mAppkey = paramString1;
    this.mBackUrl = paramString2;
    this.mPid = paramString3;
    this.mSource = paramString4;
    this.mTtid = paramString5;
    this.mTag = paramString6;
    this.mUtdid = paramString7;
  }
  
  public TBAppLinkParam setAppSecret(String paramString)
  {
    this.mAppSecret = paramString;
    return this;
  }
  
  public TBAppLinkParam setAppkey(String paramString)
  {
    this.mAppkey = paramString;
    return this;
  }
  
  public TBAppLinkParam setBackUrl(String paramString)
  {
    this.mBackUrl = paramString;
    return this;
  }
  
  public TBAppLinkParam setPid(String paramString)
  {
    this.mPid = paramString;
    return this;
  }
  
  public TBAppLinkParam setSource(String paramString)
  {
    this.mSource = paramString;
    return this;
  }
  
  public TBAppLinkParam setTTID(String paramString)
  {
    this.mTtid = paramString;
    return this;
  }
  
  public TBAppLinkParam setTag(String paramString)
  {
    this.mTag = paramString;
    return this;
  }
  
  public TBAppLinkParam setUtdid(String paramString)
  {
    this.mUtdid = paramString;
    return this;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\applink\TBAppLinkParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */