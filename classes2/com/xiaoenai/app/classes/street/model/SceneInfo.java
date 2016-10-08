package com.xiaoenai.app.classes.street.model;

import java.util.List;

public class SceneInfo
{
  private Banner[] banner_list;
  private String no_more;
  private List<ProductItemInfo> product_list;
  private String special_text;
  private String special_today_text;
  
  public Banner[] getBanner_list()
  {
    return this.banner_list;
  }
  
  public String getNo_more()
  {
    return this.no_more;
  }
  
  public List<ProductItemInfo> getProduct_list()
  {
    return this.product_list;
  }
  
  public String getSpecial_text()
  {
    return this.special_text;
  }
  
  public String getSpecial_today_text()
  {
    return this.special_today_text;
  }
  
  public void setBanner_list(Banner[] paramArrayOfBanner)
  {
    this.banner_list = paramArrayOfBanner;
  }
  
  public void setNo_more(String paramString)
  {
    this.no_more = paramString;
  }
  
  public void setProduct_list(List<ProductItemInfo> paramList)
  {
    this.product_list = paramList;
  }
  
  public void setSpecial_text(String paramString)
  {
    this.special_text = paramString;
  }
  
  public void setSpecial_today_text(String paramString)
  {
    this.special_today_text = paramString;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\model\SceneInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */