package com.baidu.location;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

class k
  implements ax, n
{
  private static k bv = null;
  private boolean bt = false;
  private ArrayList bu = null;
  private boolean bw = false;
  
  private a jdMethod_if(Messenger paramMessenger)
  {
    if (this.bu == null) {
      return null;
    }
    Iterator localIterator = this.bu.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.jdField_for.equals(paramMessenger)) {
        return locala;
      }
    }
    return null;
  }
  
  private void jdMethod_if(a parama)
  {
    if (parama == null) {
      return;
    }
    if (jdMethod_if(parama.jdField_for) != null)
    {
      a.a(parama, 14);
      return;
    }
    this.bu.add(parama);
    a.a(parama, 13);
  }
  
  private void j()
  {
    l();
    m();
  }
  
  private void l()
  {
    Iterator localIterator = this.bu.iterator();
    boolean bool1 = false;
    boolean bool2 = false;
    if (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.jdField_do.jdField_for) {
        bool2 = true;
      }
      if (!locala.jdField_do.jdField_goto) {
        break label90;
      }
      bool1 = true;
    }
    label90:
    for (;;)
    {
      break;
      c.a3 = bool1;
      if (this.bw != bool2)
      {
        this.bw = bool2;
        x.a4().jdMethod_int(this.bw);
      }
      return;
    }
  }
  
  public static k p()
  {
    if (bv == null) {
      bv = new k();
    }
    return bv;
  }
  
  public void jdMethod_byte(String paramString)
  {
    BDLocation localBDLocation = new BDLocation(paramString);
    ak.a().jdField_new = paramString;
    paramString = this.bu.iterator();
    while (paramString.hasNext()) {
      ((a)paramString.next()).jdMethod_if(localBDLocation);
    }
  }
  
  public void jdMethod_do(Message paramMessage)
  {
    paramMessage = jdMethod_if(paramMessage.replyTo);
    if (paramMessage != null) {
      this.bu.remove(paramMessage);
    }
    az.cn().cp();
    af.bw().bv();
    h.jdMethod_for().jdMethod_do();
    j();
  }
  
  public void jdMethod_do(BDLocation paramBDLocation)
  {
    Object localObject = new ArrayList();
    Iterator localIterator = this.bu.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      locala.a(paramBDLocation);
      if (locala.jdField_if > 4) {
        ((ArrayList)localObject).add(locala);
      }
    }
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      paramBDLocation = ((ArrayList)localObject).iterator();
      while (paramBDLocation.hasNext())
      {
        localObject = (a)paramBDLocation.next();
        this.bu.remove(localObject);
      }
    }
  }
  
  public int jdMethod_for(Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.replyTo == null)) {}
    do
    {
      return 1;
      paramMessage = jdMethod_if(paramMessage.replyTo);
    } while ((paramMessage == null) || (paramMessage.jdField_do == null));
    return paramMessage.jdField_do.h;
  }
  
  public void i()
  {
    Iterator localIterator = this.bu.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).a();
    }
  }
  
  public String jdMethod_if(Message paramMessage)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramMessage != null)
    {
      if (paramMessage.replyTo != null) {
        break label19;
      }
      localObject1 = localObject2;
    }
    label19:
    a locala;
    do
    {
      do
      {
        return (String)localObject1;
        locala = jdMethod_if(paramMessage.replyTo);
        localObject1 = localObject2;
      } while (locala == null);
      locala.jdField_do.jdField_long = paramMessage.getData().getInt("num", locala.jdField_do.jdField_long);
      locala.jdField_do.c = paramMessage.getData().getFloat("distance", locala.jdField_do.c);
      locala.jdField_do.e = paramMessage.getData().getBoolean("extraInfo", locala.jdField_do.e);
      locala.jdField_do.jdField_new = true;
      paramMessage = String.format(Locale.CHINA, "&poi=%.1f|%d", new Object[] { Float.valueOf(locala.jdField_do.c), Integer.valueOf(locala.jdField_do.jdField_long) });
      localObject1 = paramMessage;
    } while (!locala.jdField_do.e);
    return paramMessage + "|1";
  }
  
  public void jdMethod_if(BDLocation paramBDLocation, int paramInt)
  {
    Object localObject = new ArrayList();
    Iterator localIterator = this.bu.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      locala.a(paramBDLocation, paramInt);
      if (locala.jdField_if > 4) {
        ((ArrayList)localObject).add(locala);
      }
    }
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      paramBDLocation = ((ArrayList)localObject).iterator();
      while (paramBDLocation.hasNext())
      {
        localObject = (a)paramBDLocation.next();
        this.bu.remove(localObject);
      }
    }
  }
  
  public void jdMethod_if(BDLocation paramBDLocation, Message paramMessage)
  {
    if ((paramBDLocation == null) || (paramMessage == null)) {}
    do
    {
      do
      {
        return;
        paramMessage = jdMethod_if(paramMessage.replyTo);
      } while (paramMessage == null);
      paramMessage.a(paramBDLocation);
    } while (paramMessage.jdField_if <= 4);
    this.bu.remove(paramMessage);
  }
  
  public boolean jdMethod_int(Message paramMessage)
  {
    boolean bool2 = false;
    a locala = jdMethod_if(paramMessage.replyTo);
    if (locala == null) {
      return false;
    }
    int i = locala.jdField_do.jdField_int;
    locala.jdField_do.jdField_int = paramMessage.getData().getInt("scanSpan", locala.jdField_do.jdField_int);
    boolean bool1;
    String str;
    LocationClientOption localLocationClientOption;
    if (locala.jdField_do.jdField_int < 1000)
    {
      h.jdMethod_for().a();
      az.cn().cp();
      af.bw().bv();
      x.a4().a0();
      bool1 = bool2;
      if (locala.jdField_do.jdField_int > 999)
      {
        bool1 = bool2;
        if (i < 1000)
        {
          bool1 = true;
          if (locala.jdField_do.g)
          {
            af.bw().jdMethod_try(locala.jdField_do.g);
            af.bw().bx();
          }
          az.cn().cm();
        }
      }
      locala.jdField_do.jdField_for = paramMessage.getData().getBoolean("openGPS", locala.jdField_do.jdField_for);
      str = paramMessage.getData().getString("coorType");
      localLocationClientOption = locala.jdField_do;
      if ((str == null) || (str.equals(""))) {
        break label373;
      }
      label210:
      localLocationClientOption.jdField_do = str;
      str = paramMessage.getData().getString("addrType");
      localLocationClientOption = locala.jdField_do;
      if ((str == null) || (str.equals(""))) {
        break label384;
      }
    }
    for (;;)
    {
      localLocationClientOption.jdField_else = str;
      if (!c.aw.equals(locala.jdField_do.jdField_else)) {
        ah.ay().az();
      }
      c.aw = locala.jdField_do.jdField_else;
      locala.jdField_do.d = paramMessage.getData().getInt("timeOut", locala.jdField_do.d);
      locala.jdField_do.jdField_goto = paramMessage.getData().getBoolean("location_change_notify", locala.jdField_do.jdField_goto);
      locala.jdField_do.h = paramMessage.getData().getInt("priority", locala.jdField_do.h);
      j();
      return bool1;
      h.jdMethod_for().jdMethod_if();
      break;
      label373:
      str = locala.jdField_do.jdField_do;
      break label210;
      label384:
      str = locala.jdField_do.jdField_else;
    }
  }
  
  public boolean k()
  {
    return this.bw;
  }
  
  public void m()
  {
    Iterator localIterator = this.bu.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).jdMethod_if();
    }
  }
  
  public void n()
  {
    this.bu.clear();
    j();
  }
  
  public void jdMethod_new(Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.replyTo == null)) {
      return;
    }
    jdMethod_if(new a(paramMessage));
    j();
  }
  
  public String o()
  {
    Object localObject = new StringBuffer(256);
    if (this.bu.isEmpty()) {
      return "&prod=" + az.iM + ":" + az.iH;
    }
    a locala = (a)this.bu.get(0);
    if (locala.jdField_do.jdField_if != null) {
      ((StringBuffer)localObject).append(locala.jdField_do.jdField_if);
    }
    if (locala.jdField_int != null)
    {
      ((StringBuffer)localObject).append(":");
      ((StringBuffer)localObject).append(locala.jdField_int);
      ((StringBuffer)localObject).append("|");
    }
    localObject = ((StringBuffer)localObject).toString();
    if ((localObject != null) && (!((String)localObject).equals(""))) {
      return "&prod=" + (String)localObject;
    }
    return null;
  }
  
  private class a
  {
    public LocationClientOption jdField_do = new LocationClientOption();
    public Messenger jdField_for = null;
    public int jdField_if = 0;
    public String jdField_int = null;
    
    public a(Message paramMessage)
    {
      this.jdField_for = paramMessage.replyTo;
      this.jdField_int = paramMessage.getData().getString("packName");
      this.jdField_do.jdField_if = paramMessage.getData().getString("prodName");
      az.cn().jdMethod_try(this.jdField_do.jdField_if, this.jdField_int);
      this.jdField_do.jdField_do = paramMessage.getData().getString("coorType");
      this.jdField_do.jdField_else = paramMessage.getData().getString("addrType");
      c.aw = this.jdField_do.jdField_else;
      this.jdField_do.jdField_for = paramMessage.getData().getBoolean("openGPS");
      this.jdField_do.jdField_int = paramMessage.getData().getInt("scanSpan");
      this.jdField_do.d = paramMessage.getData().getInt("timeOut");
      this.jdField_do.h = paramMessage.getData().getInt("priority");
      this.jdField_do.jdField_goto = paramMessage.getData().getBoolean("location_change_notify");
      this.jdField_do.g = paramMessage.getData().getBoolean("needDirect");
      if (this.jdField_do.g)
      {
        af.bw().jdMethod_try(this.jdField_do.g);
        af.bw().bx();
      }
      if (this.jdField_do.jdField_int > 1000)
      {
        az.cn().cm();
        h.jdMethod_for().jdMethod_int();
      }
      if (this.jdField_do.getLocationMode() == LocationClientOption.LocationMode.Hight_Accuracy)
      {
        if (!ar.bW().bZ()) {
          Log.w("baidu_location_service", "use hight accuracy mode does not use open wifi");
        }
        if (!x.a4().a1()) {
          Log.w("baidu_location_service", "use hight accuracy mode does not use open gps");
        }
      }
    }
    
    private void a(int paramInt)
    {
      Message localMessage = Message.obtain(null, paramInt);
      try
      {
        if (this.jdField_for != null) {
          this.jdField_for.send(localMessage);
        }
        this.jdField_if = 0;
        return;
      }
      catch (Exception localException)
      {
        while (!(localException instanceof DeadObjectException)) {}
        this.jdField_if += 1;
      }
    }
    
    private void a(int paramInt, String paramString, BDLocation paramBDLocation)
    {
      Bundle localBundle = new Bundle();
      localBundle.putParcelable(paramString, paramBDLocation);
      paramString = Message.obtain(null, paramInt);
      paramString.setData(localBundle);
      try
      {
        if (this.jdField_for != null) {
          this.jdField_for.send(paramString);
        }
        this.jdField_if = 0;
        return;
      }
      catch (Exception paramString)
      {
        while (!(paramString instanceof DeadObjectException)) {}
        this.jdField_if += 1;
      }
    }
    
    public void a()
    {
      a(23);
    }
    
    public void a(BDLocation paramBDLocation)
    {
      a(paramBDLocation, 21);
    }
    
    public void a(BDLocation paramBDLocation, int paramInt)
    {
      paramBDLocation = new BDLocation(paramBDLocation);
      paramBDLocation.internalSet(0, az.cn().iP);
      if (paramBDLocation == null) {
        return;
      }
      if (paramInt == 21) {
        a(27, "locStr", paramBDLocation);
      }
      if ((this.jdField_do.jdField_do != null) && (!this.jdField_do.jdField_do.equals("gcj02")))
      {
        double d1 = paramBDLocation.getLongitude();
        double d2 = paramBDLocation.getLatitude();
        if ((d1 != Double.MIN_VALUE) && (d2 != Double.MIN_VALUE))
        {
          double[] arrayOfDouble = Jni.jdMethod_if(d1, d2, this.jdField_do.jdField_do);
          paramBDLocation.setLongitude(arrayOfDouble[0]);
          paramBDLocation.setLatitude(arrayOfDouble[1]);
        }
      }
      a(paramInt, "locStr", paramBDLocation);
    }
    
    public void jdMethod_if()
    {
      if (this.jdField_do.jdField_goto == true)
      {
        if (c.am) {
          a(54);
        }
      }
      else {
        return;
      }
      a(55);
    }
    
    public void jdMethod_if(BDLocation paramBDLocation)
    {
      if ((this.jdField_do.jdField_goto != true) || (ae.bp().bq())) {
        return;
      }
      a(paramBDLocation);
      ak.a().a(null);
      ak.a().jdMethod_if(ak.a().jdField_new);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\baidu\location\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */