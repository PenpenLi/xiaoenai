package com.xiaoenai.app.classes.street.model;

import com.xiaoenai.app.annotation.json.JsonParser;
import com.xiaoenai.app.annotation.json.a;

@JsonParser(a={@com.xiaoenai.app.annotation.json.JsonElement(a="orderId", b="order_id"), @com.xiaoenai.app.annotation.json.JsonElement(a="title", b="title"), @com.xiaoenai.app.annotation.json.JsonElement(a="vote", b="vote")})
public class Reviews
  extends a
{
  private String orderId;
  private String title;
  private int vote;
  
  public String getOrderId()
  {
    return this.orderId;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public int getVote()
  {
    return this.vote;
  }
  
  public void setOrderId(String paramString)
  {
    this.orderId = paramString;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public void setVote(int paramInt)
  {
    this.vote = paramInt;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\model\Reviews.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */