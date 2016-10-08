package com.alipay.apmobilesecuritysdk.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.alipay.apmobilesecuritysdk.a.h;
import com.alipay.security.mobile.module.http.IUpload;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  private File a = null;
  private IUpload b = null;
  
  public b(String paramString, IUpload paramIUpload)
  {
    this.a = new File(paramString);
    this.b = paramIUpload;
  }
  
  private static String a(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", "id");
      localJSONObject.put("error", paramString);
      return localJSONObject.toString();
    }
    catch (JSONException paramString) {}
    return "";
  }
  
  private void a()
  {
    int j = 0;
    for (;;)
    {
      try
      {
        Object localObject1 = this.a;
        if (localObject1 == null) {
          return;
        }
        if ((this.a.exists()) && (this.a.isDirectory()) && (this.a.list().length != 0))
        {
          ArrayList localArrayList = new ArrayList();
          localObject1 = this.a.list();
          int k = localObject1.length;
          int i = 0;
          if (i < k)
          {
            localArrayList.add(localObject1[i]);
            i += 1;
          }
          else
          {
            Collections.sort(localArrayList);
            localObject1 = (String)localArrayList.get(localArrayList.size() - 1);
            i = localArrayList.size();
            Object localObject3 = Calendar.getInstance().getTime();
            localObject3 = new SimpleDateFormat("yyyyMMdd").format((Date)localObject3);
            if (((String)localObject1).equals((String)localObject3 + ".log")) {
              if (localArrayList.size() >= 2)
              {
                localObject1 = (String)localArrayList.get(localArrayList.size() - 2);
                i -= 1;
                localObject1 = a(com.alipay.security.mobile.module.a.b.a(this.a.getAbsolutePath(), (String)localObject1));
                if (!this.b.logCollect((String)localObject1))
                {
                  i -= 1;
                  if (j < i)
                  {
                    localObject1 = (String)localArrayList.get(j);
                    new File(this.a, (String)localObject1).delete();
                    j += 1;
                    continue;
                  }
                }
                else
                {
                  continue;
                }
              }
            }
          }
        }
      }
      finally {}
    }
  }
  
  public final void a(Context paramContext)
  {
    Object localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (localObject == null)
    {
      localObject = null;
      if ((localObject == null) || (!((NetworkInfo)localObject).isConnected()) || (((NetworkInfo)localObject).getType() != 1)) {
        break label79;
      }
    }
    label79:
    for (int i = 1;; i = 0)
    {
      boolean bool = h.a(paramContext);
      if ((i != 0) && (bool)) {
        new Thread(new c(this)).start();
      }
      return;
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      break;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\apmobilesecuritysdk\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */