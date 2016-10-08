package com.alipay.sdk.util;

import android.util.Log;
import com.alipay.sdk.net.b;
import com.alipay.sdk.net.c;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

final class e
  implements Runnable
{
  e(String paramString) {}
  
  public final void run()
  {
    ArrayList localArrayList;
    synchronized ()
    {
      localArrayList = new ArrayList(1);
      localArrayList.add(new BasicNameValuePair("errorTag", this.a));
    }
    try
    {
      d.b().setEntity(new UrlEncodedFormEntity(localArrayList));
      try
      {
        b.a();
        b.a();
        Log.d("Http Post Response:", c.a(b.b.a(d.b())));
        return;
        localObject2 = finally;
        throw ((Throwable)localObject2);
      }
      catch (Throwable localThrowable)
      {
        for (;;) {}
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;) {}
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\sdk\util\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */