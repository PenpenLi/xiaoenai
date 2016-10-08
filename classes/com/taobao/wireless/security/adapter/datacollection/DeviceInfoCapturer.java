package com.taobao.wireless.security.adapter.datacollection;

import android.content.Context;
import com.taobao.dp.DeviceSecuritySDK;

public class DeviceInfoCapturer
{
  private static Context a = null;
  private static a b = null;
  
  public static String doCommandForString(int paramInt)
  {
    Object localObject1;
    switch (paramInt)
    {
    case 125: 
    default: 
      localObject1 = null;
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 100: 
    case 101: 
    case 102: 
    case 103: 
    case 104: 
    case 105: 
    case 106: 
    case 107: 
    case 108: 
    case 109: 
    case 110: 
    case 111: 
    case 114: 
    case 115: 
    case 116: 
    case 117: 
    case 118: 
    case 119: 
    case 120: 
      Object localObject2;
      do
      {
        String str;
        do
        {
          return (String)localObject1;
          try
          {
            if (!d.a("android.hardware.wifi")) {
              break;
            }
            return "1";
          }
          catch (Exception localException) {}
          if (!d.a("android.hardware.bluetooth")) {
            break label566;
          }
          return "1";
          if (!d.a("android.hardware.bluetooth_le")) {
            break label569;
          }
          return "1";
          if (!d.a("android.hardware.telephony")) {
            break label572;
          }
          return "1";
          if (!d.a("android.hardware.usb.accessory")) {
            break label575;
          }
          return "1";
          if (!d.a("android.hardware.location.gps")) {
            break label578;
          }
          return "1";
          if (!d.a("android.hardware.nfc")) {
            break label581;
          }
          return "1";
          if (!e.a(1)) {
            break label584;
          }
          return "1";
          if (!e.a(9)) {
            break label587;
          }
          return "1";
          if (!e.a(4)) {
            break label590;
          }
          return "1";
          if (!g.f()) {
            break label593;
          }
          return "1";
          return e.b(1);
          return e.c(1);
          return e.b(9);
          return e.c(9);
          return f.a();
          return f.b();
          return f.e();
          return f.f();
          return g.e();
          return g.a();
          return g.b();
          return g.c();
          return b.a();
          return b.b();
          return b.c();
          return b.d();
          return b.e();
          return b.f();
          localObject2 = a;
          str = "";
          localObject1 = str;
        } while (localObject2 == null);
        localObject2 = DeviceSecuritySDK.getInstance((Context)localObject2);
        localObject1 = str;
      } while (localObject2 == null);
      return ((DeviceSecuritySDK)localObject2).getSecurityToken();
    case 121: 
      if (b != null) {
        return a.a();
      }
    case 122: 
      return d.a();
    case 123: 
      return d.b();
    case 124: 
      localObject1 = g.d();
      return (String)localObject1;
      return null;
      return "0";
      return "0";
      return "0";
      return "0";
      return "0";
      return "0";
      return "0";
      return "0";
      return "0";
      return "0";
      return "0";
    case 112: 
      label566:
      label569:
      label572:
      label575:
      label578:
      label581:
      label584:
      label587:
      label590:
      label593:
      return null;
    }
    return null;
  }
  
  public static void initialize(Context paramContext, a parama)
  {
    a = paramContext;
    b = parama;
    d.a(paramContext);
    e.a(paramContext);
    f.a(paramContext);
    g.a(paramContext);
    c.a(paramContext);
    b.a(paramContext);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\wireless\security\adapter\datacollection\DeviceInfoCapturer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */