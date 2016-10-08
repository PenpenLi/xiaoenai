package com.xiaoenai.app.classes.street.model;

import com.xiaoenai.app.utils.ak;

public class ProductItemInfo
{
  private String click_url;
  private int from;
  private String guarantees;
  private int id;
  private ImageInfo image;
  private boolean isNew = false;
  private int origin_price;
  private int price;
  private String selling_count;
  private long selling_ts;
  private String title;
  
  public String getClick_url()
  {
    return this.click_url;
  }
  
  public int getFrom()
  {
    return this.from;
  }
  
  public String getGuarantees()
  {
    return this.guarantees;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public ImageInfo getImage()
  {
    return this.image;
  }
  
  public int getOrigin_price()
  {
    return this.origin_price;
  }
  
  public int getPrice()
  {
    return this.price;
  }
  
  public String getSelling_text()
  {
    return this.selling_count;
  }
  
  public long getSelling_ts()
  {
    return this.selling_ts;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public boolean isNew()
  {
    return this.isNew;
  }
  
  public boolean isToday()
  {
    return ak.p(getSelling_ts());
  }
  
  public void setClick_url(String paramString)
  {
    this.click_url = paramString;
  }
  
  public void setFrom(int paramInt)
  {
    this.from = paramInt;
  }
  
  public void setGuarantees(String paramString)
  {
    this.guarantees = paramString;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setImage(ImageInfo paramImageInfo)
  {
    this.image = paramImageInfo;
  }
  
  public void setNew(boolean paramBoolean)
  {
    this.isNew = paramBoolean;
  }
  
  public void setOrigin_price(int paramInt)
  {
    this.origin_price = paramInt;
  }
  
  public void setPrice(int paramInt)
  {
    this.price = paramInt;
  }
  
  public void setSelling_text(String paramString)
  {
    this.selling_count = paramString;
  }
  
  public void setSelling_ts(long paramLong)
  {
    this.selling_ts = paramLong;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\model\ProductItemInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */