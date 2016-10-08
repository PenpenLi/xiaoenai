package com.xiaoenai.app.classes.chat.messagelist.message.b;

import android.content.Context;
import android.content.res.Resources;
import android.widget.RelativeLayout;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.a.c;
import com.xiaoenai.app.classes.chat.messagelist.view.n;
import com.xiaoenai.app.model.ConfigCenter;
import com.xiaoenai.app.ui.a.k;
import com.xiaoenai.app.utils.ae;
import org.json.JSONException;
import org.json.JSONObject;

public class d
  extends o
{
  private static String a(double paramDouble)
  {
    if (paramDouble < 100.0D) {
      return Xiaoenai.j().getString(2131100118);
    }
    if (paramDouble < 200.0D) {
      return Xiaoenai.j().getString(2131100119);
    }
    if (paramDouble < 1000.0D) {
      return String.format(Xiaoenai.j().getString(2131100117), new Object[] { Integer.valueOf((int)paramDouble) });
    }
    return String.format(Xiaoenai.j().getString(2131100126), new Object[] { Double.valueOf(paramDouble / 1000.0D) });
  }
  
  public static void a(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = new com.xiaoenai.app.ui.a.g(paramContext);
      paramContext.a(2131100124);
      paramContext.show();
      paramContext.a(2131100898, new h());
    }
  }
  
  public static void a(com.xiaoenai.app.classes.chat.messagelist.message.model.d paramd, n paramn)
  {
    paramn.setStatus(paramd.f().intValue());
    String str = a(paramd.w());
    paramn.setStatusIcon(Xiaoenai.j().getResources().getIdentifier(str, "drawable", "com.xiaoenai.app"));
    paramn.getMessageBody().setBackgroundResource(2130837643);
    if (paramd.u() == -99999.0D) {
      if (paramd.f().intValue() == -2) {
        paramn.setContentText(Xiaoenai.j().getString(2131100128));
      }
    }
    for (;;)
    {
      paramn.requestLayout();
      return;
      if (paramd.f().intValue() == -1)
      {
        paramn.setContentText(Xiaoenai.j().getString(2131100130));
      }
      else
      {
        paramn.setContentText(Xiaoenai.j().getString(2131100129));
        continue;
        paramn.setContentText(a(paramd.u()));
      }
    }
  }
  
  public static boolean a(com.xiaoenai.app.classes.chat.messagelist.message.a.a parama)
  {
    boolean bool = false;
    if (parama.q()) {
      bool = true;
    }
    return bool;
  }
  
  public static void b(Context paramContext)
  {
    String str;
    if (paramContext != null)
    {
      str = ConfigCenter.getHelpPage();
      if (!ae.a(str)) {}
    }
    else
    {
      return;
    }
    paramContext = new k(paramContext);
    paramContext.d(k.i);
    paramContext.a(2131100127, 2131100054, new i(), 2131099685, new j(str));
  }
  
  public static void b(com.xiaoenai.app.classes.chat.messagelist.message.model.d paramd, n paramn)
  {
    com.xiaoenai.app.utils.f.a.c("renderLover {}", new Object[] { Long.valueOf(paramd.h()) });
    if (paramd.u() == -99999.0D)
    {
      if (paramd.v())
      {
        paramd = a(paramd.w());
        paramn.setStatusIcon(Xiaoenai.j().getResources().getIdentifier(paramd, "drawable", "com.xiaoenai.app"));
        paramn.setContentText(Xiaoenai.j().getString(2131100121));
        paramn.setContentTextColor(2131493178);
        paramn.getMessageBody().setBackgroundResource(2130837639);
      }
      for (;;)
      {
        paramn.requestLayout();
        return;
        paramn.setStatus(paramd.f().intValue());
        paramn.setLocationContentText(Xiaoenai.j().getString(2131100122));
        paramn.setContentTextColor(2131493206);
        paramn.getMessageBody().setBackgroundResource(2130837640);
        paramn.setStatusIcon(2130838905);
        paramn.getMessageBody().setOnClickListener(new e(paramn, paramd));
      }
    }
    paramn.getMessageBody().setOnClickListener(null);
    paramn.setStatus(paramd.f().intValue());
    String str = a(paramd.w());
    paramn.setStatusIcon(Xiaoenai.j().getResources().getIdentifier(str, "drawable", "com.xiaoenai.app"));
    paramn.setContentText(a(paramd.u()));
    paramn.setContentTextColor(2131493178);
    paramn.getMessageBody().setBackgroundResource(2130837639);
    paramn.requestLayout();
  }
  
  private static void e(com.xiaoenai.app.classes.chat.messagelist.message.model.d paramd, n paramn)
  {
    c localc = new c();
    localc.a(new f(paramd, localc, paramn));
  }
  
  private static void f(com.xiaoenai.app.classes.chat.messagelist.message.model.d paramd, n paramn)
  {
    paramn = new com.xiaoenai.app.net.socket.g(new g(paramd, paramn));
    paramn.b("updateMessage");
    paramn.a("message");
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("types", paramd.b());
      localJSONObject.put("content", paramd.c());
      localJSONObject.put("id", paramd.h());
      localJSONObject.put("msg_ts", paramd.d());
      paramn.a(localJSONObject);
      paramn.b();
      return;
    }
    catch (JSONException paramd)
    {
      paramd.printStackTrace();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\messagelist\message\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */