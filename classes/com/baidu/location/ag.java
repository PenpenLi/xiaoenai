package com.baidu.location;

import android.location.Location;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

abstract class ag
  implements ax, n
{
  public static String ee = null;
  private boolean ed = false;
  private boolean ef = true;
  final Handler eg = new b();
  public t.a eh = null;
  private boolean ei = false;
  private boolean ej = false;
  public ar.b ek = null;
  
  abstract void at();
  
  abstract void jdMethod_byte(Message paramMessage);
  
  public String e(String paramString)
  {
    if ((this.eh == null) || (!this.eh.jdMethod_do())) {
      this.eh = t.an().ak();
    }
    label92:
    Location localLocation;
    String str;
    Object localObject1;
    label129:
    Object localObject3;
    if (this.eh != null)
    {
      c.jdMethod_if("baidu_location_service", this.eh.jdMethod_if());
      if ((this.ek == null) || (!this.ek.jdMethod_for())) {
        this.ek = ar.bW().b1();
      }
      if (this.ek == null) {
        break label216;
      }
      c.jdMethod_if("baidu_location_service", this.ek.jdMethod_else());
      localLocation = null;
      if (x.a4().aR()) {
        localLocation = x.a4().aS();
      }
      str = k.p().o();
      if (!ar.bU()) {
        break label226;
      }
      localObject1 = "&cn=32";
      if (!this.ef) {
        break label254;
      }
      this.ef = false;
      localObject3 = localObject1;
    }
    for (;;)
    {
      Object localObject2 = (String)localObject3 + str;
      localObject1 = localObject2;
      if (paramString != null) {
        localObject1 = paramString + (String)localObject2;
      }
      return c.jdMethod_if(this.eh, this.ek, localLocation, (String)localObject1, 0);
      c.jdMethod_if("baidu_location_service", "cellInfo null...");
      break;
      label216:
      c.jdMethod_if("baidu_location_service", "wifi list null");
      break label92;
      label226:
      localObject1 = String.format(Locale.CHINA, "&cn=%d", new Object[] { Integer.valueOf(t.an().ap()) });
      break label129;
      label254:
      localObject3 = localObject1;
      if (!this.ed)
      {
        localObject3 = q.y();
        localObject2 = localObject1;
        if (localObject3 != null) {
          localObject2 = (String)localObject1 + (String)localObject3;
        }
        localObject1 = ar.bW().b0();
        localObject3 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = ((String)localObject1).replace(":", "");
          localObject3 = String.format(Locale.CHINA, "%s&mac=%s", new Object[] { localObject2, localObject1 });
          this.ed = true;
        }
      }
    }
  }
  
  class a
    extends s
  {
    String dx = null;
    String dy = null;
    
    public a()
    {
      this.cT = new ArrayList();
    }
    
    void T()
    {
      this.cR = c.jdMethod_for();
      Object localObject = Jni.i(this.dx);
      if (ab.gE) {
        Log.i("baidu_location_service", (String)localObject);
      }
      ak.a().a((String)localObject);
      this.dx = null;
      if (this.dy == null) {
        this.dy = q.B();
      }
      this.cT.add(new BasicNameValuePair("bloc", (String)localObject));
      if (this.dy != null) {
        this.cT.add(new BasicNameValuePair("up", this.dy));
      }
      localObject = new StringBuffer(512);
      ((StringBuffer)localObject).append(String.format(Locale.CHINA, "&ki=%s&sn=%s", new Object[] { v.a(f.getServiceContext()), v.jdMethod_if(f.getServiceContext()) }));
      String str = j.cZ().cY();
      if (str != null) {
        ((StringBuffer)localObject).append(str);
      }
      if (((StringBuffer)localObject).length() > 0) {
        this.cT.add(new BasicNameValuePair("ext", Jni.i(((StringBuffer)localObject).toString())));
      }
      localObject = String.format(Locale.CHINA, "%d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      this.cT.add(new BasicNameValuePair("trtm", (String)localObject));
      g.e().h();
    }
    
    public void d(String paramString)
    {
      this.dx = paramString;
      N();
    }
    
    void jdMethod_do(boolean paramBoolean)
    {
      if ((paramBoolean) && (this.cS != null))
      {
        for (;;)
        {
          try
          {
            localObject1 = EntityUtils.toString(this.cS, "utf-8");
            ag.ee = (String)localObject1;
            ak.a().jdMethod_if((String)localObject1);
          }
          catch (Exception localException2)
          {
            Object localObject1;
            Object localObject2;
            localMessage = ag.this.eg.obtainMessage(63);
            localMessage.obj = "HttpStatus error";
            localMessage.sendToTarget();
            continue;
          }
          try
          {
            localObject2 = new BDLocation((String)localObject1);
            localObject1 = localObject2;
            if (((BDLocation)localObject2).getLocType() == 161)
            {
              g.e().jdMethod_try(((BDLocation)localObject2).getTime());
              ((BDLocation)localObject2).jdMethod_byte(t.an().aq());
              localObject1 = localObject2;
              if (af.bw().by())
              {
                ((BDLocation)localObject2).setDirection(af.bw().bu());
                localObject1 = localObject2;
              }
            }
          }
          catch (Exception localException1)
          {
            localBDLocation = new BDLocation();
            localBDLocation.setLocType(63);
          }
        }
        localObject2 = ag.this.eg.obtainMessage(21);
        ((Message)localObject2).obj = localObject1;
        ((Message)localObject2).sendToTarget();
        this.dy = null;
      }
      for (;;)
      {
        if (this.cT != null) {
          this.cT.clear();
        }
        return;
        BDLocation localBDLocation;
        ak.a().jdMethod_if("network exception");
        Message localMessage = ag.this.eg.obtainMessage(63);
        localMessage.obj = "HttpStatus error";
        localMessage.sendToTarget();
      }
    }
  }
  
  public class b
    extends Handler
  {
    public b() {}
    
    public void handleMessage(Message paramMessage)
    {
      if (!ab.gv) {
        return;
      }
      switch (paramMessage.what)
      {
      default: 
        return;
      case 21: 
        ag.this.jdMethod_byte(paramMessage);
        return;
      }
      ag.this.at();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\baidu\location\ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */