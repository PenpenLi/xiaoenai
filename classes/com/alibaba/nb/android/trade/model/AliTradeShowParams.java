package com.alibaba.nb.android.trade.model;

public class AliTradeShowParams
{
  private boolean a;
  private AliOpenType b;
  private String c;
  private String d;
  
  public AliTradeShowParams()
  {
    this.b = AliOpenType.Auto;
  }
  
  public AliTradeShowParams(AliOpenType paramAliOpenType, boolean paramBoolean)
  {
    this.b = paramAliOpenType;
    this.a = paramBoolean;
  }
  
  public String getBackUrl()
  {
    return this.c;
  }
  
  public AliOpenType getOpenType()
  {
    return this.b;
  }
  
  public String getTitle()
  {
    return this.d;
  }
  
  public boolean isNeedPush()
  {
    return this.a;
  }
  
  public void setBackUrl(String paramString)
  {
    this.c = paramString;
  }
  
  public void setNeedPush(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void setOpenType(AliOpenType paramAliOpenType)
  {
    this.b = paramAliOpenType;
  }
  
  public void setTitle(String paramString)
  {
    this.d = paramString;
  }
  
  public String toString()
  {
    return "AliTradeShowParams{isNeedPush=" + this.a + ", openType=" + this.b + ", backUrl='" + this.c + '\'' + '}';
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\model\AliTradeShowParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */