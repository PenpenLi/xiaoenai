package com.alibaba.wireless.security.open.umid;

import android.content.Context;
import com.alibaba.wireless.security.open.SecException;
import com.taobao.dp.DeviceSecuritySDK;
import com.taobao.dp.OnlineHost;
import com.taobao.dp.client.IInitResultListener;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Iterator;

public final class a
  implements IUMIDComponent, IInitResultListener
{
  private static final Object e = new Object();
  private Context a;
  private short b;
  private volatile boolean c = false;
  private ArrayList d;
  
  public a(Context paramContext)
  {
    this.a = paramContext;
    this.b = -1;
    this.d = new ArrayList();
  }
  
  public final void a()
  {
    this.c = true;
    DeviceSecuritySDK.getInstance(this.a).initAsync(null, null, 0, null, this);
  }
  
  public final String getSecurityToken()
  {
    if (!this.c) {
      throw new SecException(901);
    }
    return DeviceSecuritySDK.getInstance(this.a).getSecurityToken();
  }
  
  public final void initUMID(String paramString1, int paramInt, String paramString2, IUMIDInitListenerEx paramIUMIDInitListenerEx)
  {
    DeviceSecuritySDK.getInstance(this.a).initAsync(paramString1, paramString2, paramInt, null, new b(paramIUMIDInitListenerEx));
  }
  
  public final void onInitFinished(String paramString, int paramInt)
  {
    short s = 1;
    Object localObject = e;
    if (paramString != null) {}
    for (;;)
    {
      boolean bool;
      try
      {
        if ((paramString.length() <= 0) || ("000000000000000000000000".equals(paramString))) {
          break label92;
        }
        bool = true;
      }
      finally {}
      this.b = s;
      paramString = this.d.iterator();
      if (paramString.hasNext())
      {
        IUMIDInitListener localIUMIDInitListener = (IUMIDInitListener)paramString.next();
        if (localIUMIDInitListener != null)
        {
          localIUMIDInitListener.onUMIDInitFinished(bool);
          continue;
          label92:
          bool = false;
        }
      }
      else
      {
        while (!bool)
        {
          s = 0;
          break;
          return;
        }
      }
    }
  }
  
  public final void registerInitListener(IUMIDInitListener paramIUMIDInitListener)
  {
    boolean bool = true;
    if (!this.c) {
      throw new SecException(901);
    }
    for (;;)
    {
      synchronized (e)
      {
        if (this.b == -1)
        {
          if (paramIUMIDInitListener != null) {
            this.d.add(paramIUMIDInitListener);
          }
          return;
        }
        if (paramIUMIDInitListener == null) {
          continue;
        }
        if (this.b == 1)
        {
          paramIUMIDInitListener.onUMIDInitFinished(bool);
          return;
        }
      }
      bool = false;
    }
  }
  
  public final void setOnlineHost(String paramString)
  {
    try
    {
      paramString = OnlineHost.valueof(paramString);
      DeviceSecuritySDK.getInstance(this.a).setOnlineHost(paramString);
      return;
    }
    catch (InvalidParameterException paramString)
    {
      throw new SecException(902);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\wireless\security\open\umid\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */