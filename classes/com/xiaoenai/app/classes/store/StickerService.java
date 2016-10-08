package com.xiaoenai.app.classes.store;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.xiaoenai.app.classes.store.sticker.BaseSticker;
import com.xiaoenai.app.utils.b;
import com.xiaoenai.app.utils.b.a;
import com.xiaoenai.app.utils.f.a;
import java.io.File;
import java.util.Iterator;
import java.util.Vector;
import org.json.JSONObject;

public class StickerService
  extends Service
{
  private Handler a;
  private DownloadReceiver b;
  private Vector<BaseSticker> c;
  private Vector<BaseSticker> d;
  private Bundle e;
  private a f = new a();
  private boolean g = false;
  
  private BaseSticker a(Vector<BaseSticker> paramVector, String paramString)
  {
    int i = 0;
    while (i < paramVector.size())
    {
      if (((BaseSticker)paramVector.get(i)).getZipUrl().equals(paramString)) {
        return (BaseSticker)paramVector.get(i);
      }
      i += 1;
    }
    return null;
  }
  
  private void a()
  {
    if ((this.d != null) && (this.d.size() == 0))
    {
      a("downloadAllComplete", null, "");
      stopSelf();
    }
  }
  
  private void a(int paramInt, BaseSticker paramBaseSticker)
  {
    new com.xiaoenai.app.net.l(new af(this, this, paramBaseSticker)).b(paramInt);
  }
  
  private void a(Intent paramIntent)
  {
    Intent localIntent = new Intent("com.xiaoenai.app.download.ACTION_IDownloadService");
    localIntent.putExtra("type", 6);
    localIntent.putExtra("filePath", b.c());
    localIntent.putExtra("url", paramIntent.getStringExtra("faceZipUrl"));
    startService(localIntent);
  }
  
  private void a(BaseSticker paramBaseSticker, Vector<BaseSticker> paramVector, JSONObject paramJSONObject)
  {
    paramBaseSticker.setZipUrl(com.xiaoenai.app.utils.l.e(paramJSONObject.toString()));
    b(paramBaseSticker, paramVector);
  }
  
  private void a(String paramString)
  {
    Intent localIntent = new Intent("com.xiaoenai.app.download.ACTION_IDownloadService");
    localIntent.putExtra("type", 6);
    localIntent.putExtra("filePath", b.c());
    localIntent.putExtra("url", paramString);
    startService(localIntent);
  }
  
  private void a(String paramString1, String paramString2, Bundle paramBundle)
  {
    Intent localIntent = new Intent();
    localIntent.setAction(paramString1);
    localIntent.putExtra(paramString2, paramBundle);
    sendBroadcast(localIntent);
  }
  
  private void a(String paramString1, String paramString2, b.a parama)
  {
    b.a(paramString1, paramString2, parama);
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    Intent localIntent = new Intent();
    localIntent.setAction(paramString1);
    if ((paramString2 != null) && (paramString3 != null)) {
      localIntent.putExtra(paramString2, paramString3);
    }
    sendBroadcast(localIntent);
  }
  
  private void a(String paramString, Vector<BaseSticker> paramVector)
  {
    paramVector.remove(a(paramVector, paramString));
  }
  
  private void a(String paramString, Vector<BaseSticker> paramVector1, Vector<BaseSticker> paramVector2)
  {
    if (paramVector1 != null) {
      a(paramString, paramVector1);
    }
    if (paramVector2 != null) {
      a(paramString, paramVector2);
    }
  }
  
  private void a(Vector<BaseSticker> paramVector)
  {
    if ((paramVector != null) && (paramVector.size() > 0)) {
      a(((BaseSticker)paramVector.get(0)).getZipUrl());
    }
  }
  
  private void a(Vector<BaseSticker> paramVector, String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean)
  {
    paramString1 = a(paramVector, paramString1);
    if (paramString1 != null)
    {
      a(paramString2, String.valueOf(paramString1.getId()), new ae(this, paramString1, paramBundle, paramString2, paramBoolean));
      paramVector.remove(paramString1);
      if (paramBoolean) {
        a();
      }
    }
  }
  
  private boolean a(BaseSticker paramBaseSticker, Vector<BaseSticker> paramVector)
  {
    paramVector = paramVector.iterator();
    while (paramVector.hasNext()) {
      if (((BaseSticker)paramVector.next()).getId() == paramBaseSticker.getId()) {
        return true;
      }
    }
    return false;
  }
  
  private void b(BaseSticker paramBaseSticker, Vector<BaseSticker> paramVector)
  {
    if ((paramVector != null) && (!paramBaseSticker.getZipUrl().equals(""))) {
      paramVector.add(paramBaseSticker);
    }
    if ((!paramBaseSticker.getZipUrl().equals("")) && (!this.g))
    {
      a(paramBaseSticker.getZipUrl());
      this.g = true;
    }
  }
  
  private void b(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.exists()) {
      paramString.delete();
    }
  }
  
  public void a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 0: 
    case 1: 
    case 10: 
      String str2;
      do
      {
        do
        {
          return;
          this.e = paramMessage.getData();
          a("downloadProgress", "stickerBundle", this.e);
          return;
          str1 = "";
          str2 = (String)paramMessage.obj;
          this.e = paramMessage.getData();
          paramMessage = str1;
          if (this.e != null)
          {
            paramMessage = str1;
            if (this.e.getString("url") != null) {
              paramMessage = this.e.getString("url");
            }
          }
        } while (paramMessage == null);
        a(this.c, paramMessage, str2, this.e, false);
        a(this.d, paramMessage, str2, this.e, true);
        a(this.d);
        return;
        str2 = (String)paramMessage.obj;
        String str1 = "";
        this.e = paramMessage.getData();
        paramMessage = str1;
        if (this.e != null)
        {
          paramMessage = str1;
          if (this.e.getString("url") != null) {
            paramMessage = this.e.getString("url");
          }
        }
        a.c("============filePath:{}", new Object[] { str2 });
      } while (paramMessage == null);
      a(this.c, paramMessage, str2, this.e, false);
      a(this.d, paramMessage, str2, this.e, true);
      a(this.d);
      return;
    }
    this.e = paramMessage.getData();
    paramMessage = (String)paramMessage.obj;
    a.c("============filePath:{}", new Object[] { paramMessage });
    a("downloadError", "stickerBundle", this.e);
    a(this.d);
    b(paramMessage);
    a(this.e.getString("url"), this.c);
    a(this.e.getString("url"), this.d);
    stopSelf();
  }
  
  public boolean a(BaseSticker paramBaseSticker)
  {
    if ((this.c != null) && (a(paramBaseSticker, this.c))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (this.d != null)
      {
        bool2 = bool1;
        if (a(paramBaseSticker, this.d)) {
          bool2 = true;
        }
      }
      a.c("======================= {}", new Object[] { Boolean.valueOf(bool2) });
      return bool2;
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.f;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.a = new ac(this);
    this.a.postDelayed(new ad(this), 90000L);
    this.b = new DownloadReceiver(this.a);
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("com.xiaoenai.app.download.TASK_CHANGE");
    registerReceiver(this.b, (IntentFilter)localObject);
    this.c = new Vector();
    this.d = new Vector();
    localObject = new Intent("com.xiaoenai.app.download.ACTION_IDownloadService");
    ((Intent)localObject).putExtra("type", 2);
    startService((Intent)localObject);
  }
  
  public void onDestroy()
  {
    this.a = null;
    if (this.b != null) {
      unregisterReceiver(this.b);
    }
    if (this.c != null)
    {
      this.c.clear();
      this.c = null;
    }
    if (this.d != null)
    {
      this.d.clear();
      this.d = null;
    }
    super.onDestroy();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (paramIntent != null)
    {
      localObject = paramIntent.getAction();
      if (localObject != null)
      {
        if (!((String)localObject).equals("stickerDownloadAction")) {
          break label68;
        }
        localObject = (BaseSticker)paramIntent.getParcelableExtra("stickerData");
        if (localObject != null) {
          this.c.add(localObject);
        }
        a(paramIntent);
      }
    }
    for (;;)
    {
      return super.onStartCommand(paramIntent, paramInt1 | 0x2, paramInt2);
      label68:
      if (((String)localObject).equals("downloadAll"))
      {
        localObject = (BaseSticker)paramIntent.getParcelableExtra("stickerData");
        if ((((BaseSticker)localObject).getZipUrl() == null) || (((BaseSticker)localObject).getZipUrl().equals(""))) {
          a(((BaseSticker)localObject).getId(), (BaseSticker)localObject);
        }
        b((BaseSticker)localObject, this.d);
      }
      else if (((String)localObject).equals("checkDownloadingState"))
      {
        localObject = (BaseSticker)paramIntent.getParcelableExtra("stickerData");
        if (this.d != null)
        {
          Intent localIntent = new Intent();
          localIntent.setAction("downloadingStateAction");
          localIntent.putExtra("downloadingKey", a((BaseSticker)localObject));
          sendBroadcast(localIntent);
        }
      }
      else if (((String)localObject).equals("deleteDownload"))
      {
        localObject = paramIntent.getStringExtra("downloadUrl");
        if (localObject != null) {
          a((String)localObject, this.c, this.d);
        }
      }
    }
  }
  
  public class a
    extends Binder
  {
    public a() {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\store\StickerService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */