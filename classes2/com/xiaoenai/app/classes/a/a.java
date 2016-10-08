package com.xiaoenai.app.classes.a;

import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.LocationClientOption.LocationMode;
import com.xiaoenai.app.Xiaoenai;

public class a
  extends b
{
  private LocationClient a;
  private BDLocationListener b = null;
  
  public void a()
  {
    this.a = new LocationClient(Xiaoenai.j());
    LocationClientOption localLocationClientOption = new LocationClientOption();
    localLocationClientOption.setCoorType("gcj02");
    localLocationClientOption.setProdName("xiaoenai");
    localLocationClientOption.setScanSpan(5000);
    localLocationClientOption.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
    localLocationClientOption.setIsNeedAddress(true);
    localLocationClientOption.setTimeOut(20000);
    this.a.setLocOption(localLocationClientOption);
    this.a.start();
  }
  
  public void a(BDLocationListener paramBDLocationListener)
  {
    this.b = paramBDLocationListener;
    if (this.a != null)
    {
      this.a.requestLocation();
      this.a.registerLocationListener(paramBDLocationListener);
    }
  }
  
  public void b()
  {
    if (this.a != null)
    {
      this.a.stop();
      if (this.b != null) {
        this.a.unRegisterLocationListener(this.b);
      }
    }
    this.a = null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */