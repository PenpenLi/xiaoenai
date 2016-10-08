package com.xiaoenai.app.net.socket;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.model.AppModel;
import com.xiaoenai.app.model.AppSettings;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.utils.ai;
import com.xiaoenai.app.utils.d.f;
import com.xiaoenai.app.utils.d.o;
import com.xiaoenai.app.utils.v;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
import org.mzd.socket.MessageCallback;
import org.mzd.socket.SocketJNI;

public class SocketManager
  extends BroadcastReceiver
  implements b
{
  public static String a = "com.xiaoenai.app.net.socket.ON_CONNECT_CHANGED_SOCKET";
  public static String b = "com.xiaoenai.app.net.socket.ON_PUSH_MESSAGE_RECIEVED_SOCKET";
  public static String c = "com.xiaoenai.app.net.socket.ON_PUSH_AUTH_FAILED_SOCKET";
  public static String d = "com.xiaoenai.app.net.SOCKET_ON_GETNEWMESSAGE";
  private static SocketManager e = null;
  private static byte[] h = new byte[0];
  private Context f;
  private boolean g = false;
  private int i = 1;
  private boolean j = true;
  
  private SocketManager(Context paramContext)
  {
    this.f = paramContext;
    this.j = true;
  }
  
  public static SocketManager a()
  {
    if (e == null) {}
    synchronized (h)
    {
      if (e == null)
      {
        e = new SocketManager(Xiaoenai.j());
        if (Build.VERSION.SDK_INT == 8)
        {
          System.setProperty("java.net.preferIPv4Stack", "true");
          System.setProperty("java.net.preferIPv6Addresses", "false");
        }
      }
      return e;
    }
  }
  
  public static void b()
  {
    try
    {
      if (e != null)
      {
        e.e();
        e = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void b(int paramInt)
  {
    int k = paramInt;
    if (1 == paramInt)
    {
      k = paramInt;
      if (1 == this.i)
      {
        if (!o.g(this.f)) {
          break label61;
        }
        k = 0;
      }
    }
    for (;;)
    {
      this.i = k;
      this.f.sendBroadcast(new Intent(a), this.f.getString(2131101650));
      return;
      label61:
      k = paramInt;
      if (!o.d(this.f))
      {
        k = paramInt;
        if (!o.e(this.f)) {
          k = 0;
        }
      }
    }
  }
  
  private void i() {}
  
  public void a(int paramInt)
  {
    b(paramInt);
  }
  
  public void a(long paramLong)
  {
    SocketJNI.setAdjustTime(paramLong);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    com.xiaoenai.app.utils.f.a.c(true, "maxMessageId = {}  maxReadTs = {}", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    SocketJNI.getNewMessage(paramLong1, paramLong2);
  }
  
  public void a(String paramString)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString);
      if (localJSONObject1 == null) {
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      do
      {
        JSONObject localJSONObject2;
        do
        {
          for (;;)
          {
            localJSONException.printStackTrace();
            localJSONObject2 = null;
          }
          if ((localJSONObject2.has("auth")) && (!localJSONObject2.optBoolean("auth", false)))
          {
            Intent localIntent = new Intent(c);
            this.f.sendBroadcast(localIntent, this.f.getString(2131101650));
            com.xiaoenai.app.utils.f.a.c(true, "auth = {}", new Object[] { paramString });
          }
          if (localJSONObject2.has("flag")) {
            break;
          }
          paramString = new Intent(b);
          paramString.putExtra("Command", localJSONObject2.optString("pushNotification"));
          if (localJSONObject2.has("pushMsg")) {
            paramString.putExtra("pushMsg", localJSONObject2.optString("pushMsg"));
          }
          if (localJSONObject2.has("pushBadge")) {
            paramString.putExtra("pushBadge", localJSONObject2.optInt("pushBadge"));
          }
          if (localJSONObject2.has("notifyId")) {
            paramString.putExtra("notifyId", localJSONObject2.optInt("notifyId"));
          }
          if (localJSONObject2.has("pushSound")) {
            paramString.putExtra("pushSound", localJSONObject2.optString("pushSound"));
          }
          if (localJSONObject2.has("moduleId")) {
            paramString.putExtra("moduleId", localJSONObject2.optString("moduleId"));
          }
          if (localJSONObject2.has("data"))
          {
            localJSONObject2 = localJSONObject2.optJSONObject("data");
            paramString.putExtra("action", localJSONObject2.optString("action"));
            if (localJSONObject2.has("data")) {
              paramString.putExtra("data", localJSONObject2.optJSONObject("data").toString());
            }
          }
          this.f.sendBroadcast(paramString, this.f.getString(2131101650));
        } while (2 == this.i);
        b(2);
        return;
        if ((localJSONObject2.has("new")) || (localJSONObject2.has("read")) || (localJSONObject2.has("update")))
        {
          paramString = new Intent(d);
          paramString.putExtra("data", localJSONObject2.toString());
          this.f.sendBroadcast(paramString, this.f.getString(2131101650));
          com.xiaoenai.app.utils.f.a.c("get data = {}", new Object[] { localJSONObject2.toString() });
        }
      } while (2 == this.i);
      b(2);
    }
  }
  
  public void a(MessageCallback paramMessageCallback, String paramString)
  {
    SocketJNI.sendMessage(paramMessageCallback, paramString);
  }
  
  public void b(MessageCallback paramMessageCallback, String paramString)
  {
    SocketJNI.readMessage(paramMessageCallback, paramString);
  }
  
  public void c()
  {
    Object localObject;
    if (!this.g)
    {
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("android.net.conn.CONNECTIVITY_CHANGE");
      this.f.registerReceiver(this, (IntentFilter)localObject);
      this.g = true;
    }
    if (this.j)
    {
      localObject = AppModel.getInstance().getToken();
      String str = AppModel.getInstance().getSigKey();
      long l1 = User.getInstance().getUserId();
      long l2 = User.getInstance().getLoverId();
      long l3 = AppSettings.getInt("client_server_adjust", Integer.valueOf(0)).intValue();
      SocketJNI.setSocketCallBack(this);
      SocketJNI.setUserDataPath(f.b(Xiaoenai.j(), AppModel.getInstance().getUserId()) + File.separator);
      SocketJNI.setAdjustTime(l3);
      SocketJNI.setUserData((String)localObject, str, l1, l2);
      i();
      new a().a();
      this.j = false;
      com.xiaoenai.app.utils.f.a.c("SocketManager start ", new Object[0]);
    }
  }
  
  public void c(MessageCallback paramMessageCallback, String paramString)
  {
    SocketJNI.updateMessage(paramMessageCallback, paramString);
  }
  
  public Context d()
  {
    return this.f;
  }
  
  public void e()
  {
    if (this.g)
    {
      this.f.unregisterReceiver(this);
      this.g = false;
    }
    if (!this.j)
    {
      SocketJNI.destroy();
      this.j = true;
    }
  }
  
  public int f()
  {
    return this.i;
  }
  
  public void g() {}
  
  public void h() {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    SocketJNI.networkChange(1);
    boolean bool = v.a(this.f);
    com.xiaoenai.app.utils.f.a.d("isWifiNet = {}", new Object[] { Boolean.valueOf(bool) });
    ai.a(bool);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\net\socket\SocketManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */