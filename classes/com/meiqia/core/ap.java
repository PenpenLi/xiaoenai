package com.meiqia.core;

import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import com.meiqia.core.a.a.a.a;
import com.meiqia.core.a.a.e.h;
import com.meiqia.core.b.c;
import com.meiqia.core.b.g;
import com.meiqia.core.b.l;
import java.net.URI;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

class ap
  extends a
{
  ap(MeiQiaService paramMeiQiaService, URI paramURI)
  {
    super(paramURI);
  }
  
  public void a(h paramh)
  {
    g.b("socket open");
    MeiQiaService.c = true;
    MeiQiaService.a(this.c).set(false);
    if (MeiQiaService.c(this.c)) {
      MeiQiaService.d(this.c);
    }
    MeiQiaService.e(this.c).removeMessages(1);
  }
  
  public void a(Exception paramException)
  {
    MeiQiaService.c = false;
    MeiQiaService.h(this.c);
    g.b("socket error: message = " + paramException.getMessage() + " class = " + paramException.getClass().getSimpleName());
  }
  
  public void b(int paramInt, String paramString, boolean paramBoolean)
  {
    g.b("socket close: i = " + paramInt + " s = " + paramString);
    MeiQiaService.c = false;
    MeiQiaService.h(this.c);
  }
  
  public void b(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!MeiQiaService.b)) {}
    try
    {
      paramString = new JSONObject(paramString);
      Object localObject = paramString.optString("action");
      String str = paramString.optString("id");
      MeiQiaService.f(this.c).a(str);
      if ("message".equals(localObject))
      {
        paramString = c.a(paramString);
        MeiQiaService.a(this.c, paramString);
      }
      do
      {
        do
        {
          return;
          if ("ticket_reply".equals(localObject))
          {
            MeiQiaService.a(this.c, paramString);
            return;
          }
          if (("agent_redirect".equals(localObject)) || ("timeout_redirect".equals(localObject)))
          {
            paramString = c.b(paramString.optJSONObject("body").optJSONObject("to"));
            MeiQiaService.a(this.c, paramString);
            return;
          }
          if ("agent_inputting".equals(localObject))
          {
            paramString = new Intent("agent_inputting_action");
            l.a(this.c, paramString);
            return;
          }
          if ("invite_evaluation".equals(localObject))
          {
            MeiQiaService.b(this.c, paramString);
            return;
          }
          if (!"end_conv_agent".equals(localObject)) {
            break;
          }
          localObject = paramString.optJSONObject("body");
        } while ((localObject == null) || (!((JSONObject)localObject).optBoolean("evaluation")));
        MeiQiaService.b(this.c, paramString);
        return;
        if ("agent_update".equals(localObject))
        {
          MeiQiaService.c(this.c, paramString);
          return;
        }
        if (TextUtils.equals("visit_black_add", (CharSequence)localObject))
        {
          MeiQiaService.d(this.c, paramString);
          return;
        }
        if (TextUtils.equals("visit_black_del", (CharSequence)localObject))
        {
          MeiQiaService.e(this.c, paramString);
          return;
        }
        if ("queueing_remove".equals(localObject))
        {
          MeiQiaService.g(this.c);
          return;
        }
      } while (!"init_conv".equals(localObject));
      MeiQiaService.f(this.c, paramString);
      return;
    }
    catch (JSONException paramString) {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\meiqia\core\ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */