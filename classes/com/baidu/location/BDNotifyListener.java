package com.baidu.location;

public abstract class BDNotifyListener
{
  public int Notified = 0;
  public float differDistance = 0.0F;
  public boolean isAdded = false;
  public String mCoorType = null;
  public double mLatitude = Double.MIN_VALUE;
  public double mLatitudeC = Double.MIN_VALUE;
  public double mLongitude = Double.MIN_VALUE;
  public double mLongitudeC = Double.MIN_VALUE;
  public z mNotifyCache = null;
  public float mRadius = 0.0F;
  
  public void SetNotifyLocation(double paramDouble1, double paramDouble2, float paramFloat, String paramString)
  {
    this.mLatitude = paramDouble1;
    this.mLongitude = paramDouble2;
    if (paramFloat < 0.0F)
    {
      this.mRadius = 200.0F;
      if ((!paramString.equals("gcj02")) && (!paramString.equals("bd09")) && (!paramString.equals("bd09ll")) && (!paramString.equals("gps"))) {
        break label127;
      }
    }
    label127:
    for (this.mCoorType = paramString;; this.mCoorType = "gcj02")
    {
      if (this.mCoorType.equals("gcj02"))
      {
        this.mLatitudeC = this.mLatitude;
        this.mLongitudeC = this.mLongitude;
      }
      if (this.isAdded)
      {
        this.Notified = 0;
        this.mNotifyCache.jdMethod_if(this);
      }
      return;
      this.mRadius = paramFloat;
      break;
    }
  }
  
  public void onNotify(BDLocation paramBDLocation, float paramFloat)
  {
    c.jdMethod_do("baidu_location_service", "new location, not far from the destination..." + paramFloat);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\baidu\location\BDNotifyListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */