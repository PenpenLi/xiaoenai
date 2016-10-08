package com.sina.weibo.sdk.call;

public class Position
{
  private float mLatitude;
  private float mLongitude;
  private boolean mOffset;
  
  public Position(float paramFloat1, float paramFloat2)
  {
    this.mLongitude = paramFloat1;
    this.mLatitude = paramFloat2;
    this.mOffset = true;
  }
  
  public Position(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    this.mLongitude = paramFloat1;
    this.mLatitude = paramFloat2;
    this.mOffset = paramBoolean;
  }
  
  boolean checkValid()
  {
    if ((Float.isNaN(this.mLongitude)) || (this.mLongitude < -180.0F) || (this.mLongitude > 180.0F)) {}
    while ((Float.isNaN(this.mLatitude)) || (this.mLatitude < -180.0F) || (this.mLatitude > 180.0F)) {
      return false;
    }
    return true;
  }
  
  public float getLatitude()
  {
    return this.mLatitude;
  }
  
  public float getLongitude()
  {
    return this.mLongitude;
  }
  
  public String getStrLatitude()
  {
    return String.valueOf(this.mLatitude);
  }
  
  public String getStrLongitude()
  {
    return String.valueOf(this.mLongitude);
  }
  
  public String getStrOffset()
  {
    if (this.mOffset) {
      return "1";
    }
    return "0";
  }
  
  public boolean isOffset()
  {
    return this.mOffset;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\call\Position.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */