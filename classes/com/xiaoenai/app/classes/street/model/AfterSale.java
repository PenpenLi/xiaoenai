package com.xiaoenai.app.classes.street.model;

import com.xiaoenai.app.annotation.json.JsonParser;
import com.xiaoenai.app.annotation.json.a;

@JsonParser(a={@com.xiaoenai.app.annotation.json.JsonElement(a="type", b="type"), @com.xiaoenai.app.annotation.json.JsonElement(a="typeDesc", b="type_desc"), @com.xiaoenai.app.annotation.json.JsonElement(a="refundPrice", b="refund_price"), @com.xiaoenai.app.annotation.json.JsonElement(a="progressTitle", b="progress_title"), @com.xiaoenai.app.annotation.json.JsonElement(a="progressContent", b="progress_content"), @com.xiaoenai.app.annotation.json.JsonElement(a="needDelivery", b="need_delivery"), @com.xiaoenai.app.annotation.json.JsonElement(a="canCancel", b="can_cancel")})
public class AfterSale
  extends a
{
  private int canCancel;
  private int needDelivery;
  private String progressContent;
  private String progressTitle;
  private int refundPrice;
  private int type;
  private String typeDesc;
  
  public int getCanCancel()
  {
    return this.canCancel;
  }
  
  public int getNeedDelivery()
  {
    return this.needDelivery;
  }
  
  public String getProgressContent()
  {
    return this.progressContent;
  }
  
  public String getProgressTitle()
  {
    return this.progressTitle;
  }
  
  public int getRefundPrice()
  {
    return this.refundPrice;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public String getTypeDesc()
  {
    return this.typeDesc;
  }
  
  public void setCanCancel(int paramInt)
  {
    this.canCancel = paramInt;
  }
  
  public void setNeedDelivery(int paramInt)
  {
    this.needDelivery = paramInt;
  }
  
  public void setProgressContent(String paramString)
  {
    this.progressContent = paramString;
  }
  
  public void setProgressTitle(String paramString)
  {
    this.progressTitle = paramString;
  }
  
  public void setRefundPrice(int paramInt)
  {
    this.refundPrice = paramInt;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public void setTypeDesc(String paramString)
  {
    this.typeDesc = paramString;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\model\AfterSale.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */