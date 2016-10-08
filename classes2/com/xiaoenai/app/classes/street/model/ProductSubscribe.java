package com.xiaoenai.app.classes.street.model;

public class ProductSubscribe
{
  private long closeTime = 0L;
  private int id = -1;
  private boolean isReminded = false;
  private String orderNotiDesc = "";
  private long orderNotiTs = 0L;
  private int productId = 0;
  private int rushId = 0;
  private long sellingTime = 0L;
  private boolean subscribeStatus = false;
  
  public long getCloseTime()
  {
    return this.closeTime;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public String getOrderNotiDesc()
  {
    return this.orderNotiDesc;
  }
  
  public long getOrderNotiTs()
  {
    return this.orderNotiTs;
  }
  
  public int getProductId()
  {
    return this.productId;
  }
  
  public int getRushId()
  {
    return this.rushId;
  }
  
  public long getSellingTime()
  {
    return this.sellingTime;
  }
  
  public boolean isRemind()
  {
    return this.isReminded;
  }
  
  public boolean isSubscribeStatus()
  {
    return this.subscribeStatus;
  }
  
  public void setCloseTime(long paramLong)
  {
    this.closeTime = paramLong;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setIsRemind(boolean paramBoolean)
  {
    this.isReminded = paramBoolean;
  }
  
  public void setOrderNotiDesc(String paramString)
  {
    this.orderNotiDesc = paramString;
  }
  
  public void setOrderNotiTs(long paramLong)
  {
    this.orderNotiTs = paramLong;
  }
  
  public void setProductId(int paramInt)
  {
    this.productId = paramInt;
  }
  
  public void setRushId(int paramInt)
  {
    this.rushId = paramInt;
  }
  
  public void setSellingTime(long paramLong)
  {
    this.sellingTime = paramLong;
  }
  
  public void setSubscribeStatus(boolean paramBoolean)
  {
    this.subscribeStatus = paramBoolean;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\model\ProductSubscribe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */