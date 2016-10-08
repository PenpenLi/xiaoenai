package com.xiaoenai.app.classes.auth;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.classes.guide.NewVersionIntroActivity;
import com.xiaoenai.app.classes.home.HomeActivity;
import com.xiaoenai.app.model.AppModel;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.net.c.a.j;
import com.xiaoenai.app.ui.a.g;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.widget.TitleBarView;
import org.json.JSONException;
import org.json.JSONObject;

public class XeaAuthActivity
  extends TitleBarActivity
  implements SimpleLoginView.a
{
  protected h a;
  private String b;
  private RelativeLayout c;
  private WebView i;
  private String j;
  private b k;
  private SimpleLoginView l;
  
  private void a(int paramInt, JSONObject paramJSONObject)
  {
    if (this.i != null) {}
    for (;;)
    {
      try
      {
        l_();
        this.i.requestFocus();
        this.i.freeMemory();
        this.i.destroy();
        com.xiaoenai.app.utils.f.a.c("send msg back", new Object[0]);
        localIntent = new Intent("xiaoenai_authorize_action");
        localIntent.putExtra("appkey", this.j);
        if ((paramInt != 0) || (paramJSONObject == null)) {}
      }
      catch (Exception localException)
      {
        try
        {
          Intent localIntent;
          localIntent.putExtra("token", paramJSONObject.getString("access_token"));
          localIntent.putExtra("expireTime", paramJSONObject.getLong("expires_in"));
          if (paramJSONObject.has("open_id")) {
            localIntent.putExtra("openId", paramJSONObject.getLong("open_id"));
          }
          localIntent.putExtra("code", paramInt);
          setResult(-1, localIntent);
          sendBroadcast(localIntent);
          k();
          return;
          localException = localException;
          localException.printStackTrace();
        }
        catch (JSONException paramJSONObject)
        {
          paramJSONObject.printStackTrace();
          continue;
        }
        if (paramInt <= 0) {
          continue;
        }
        if (paramJSONObject == null) {}
      }
      try
      {
        localException.putExtra("server_msg", paramJSONObject.getString("server_msg"));
        localException.putExtra("err_msg", j.a(paramInt));
      }
      catch (JSONException paramJSONObject)
      {
        for (;;)
        {
          paramJSONObject.printStackTrace();
        }
      }
    }
  }
  
  private void b(String paramString)
  {
    this.g.setRightButtonEnable(false);
    this.i.setVisibility(0);
    this.k.a(paramString);
  }
  
  private void f()
  {
    this.c = ((RelativeLayout)findViewById(2131558670));
    this.g.setLeftButtonClickListener(new al(this));
    this.g.setRightButtonClickListener(new am(this));
    this.i = ((WebView)findViewById(2131558741));
    this.g.setRightButtonEnable(false);
  }
  
  private void g()
  {
    if (this.l == null)
    {
      this.l = new SimpleLoginView(this);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.c.addView(this.l, localLayoutParams);
      this.l.setAuthActivity(this);
      this.l.setLoginActionListener(this);
    }
  }
  
  private void h()
  {
    if (this.l != null)
    {
      this.c.removeView(this.l);
      this.l = null;
    }
  }
  
  private void i()
  {
    sendBroadcast(new Intent("kill_action"), getString(2131101650));
    Intent localIntent = new Intent(this, HomeActivity.class);
    localIntent.addFlags(67108864);
    localIntent.putExtra("from", "login_qq");
    startActivity(localIntent);
    finish();
    overridePendingTransition(2130968604, 2130968605);
    com.xiaoenai.app.classes.common.a.a().a(this);
  }
  
  private void j()
  {
    Intent localIntent = new Intent(this, NewVersionIntroActivity.class);
    localIntent.putExtra("from", "login_qq");
    startActivity(localIntent);
    finish();
    com.xiaoenai.app.classes.common.a.a().a(this);
  }
  
  private void k()
  {
    finish();
    overridePendingTransition(2130968606, 2130968607);
  }
  
  private void o()
  {
    g localg = new g(this);
    localg.a(2131099964);
    localg.a(2131100898, new an(this));
    localg.setCancelable(false);
    localg.show();
  }
  
  public int a()
  {
    return 2130903087;
  }
  
  public void a(String paramString)
  {
    a(paramString, true);
  }
  
  /* Error */
  public void a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 39	com/xiaoenai/app/classes/auth/XeaAuthActivity:l_	()V
    //   6: aload_0
    //   7: invokevirtual 291	com/xiaoenai/app/classes/auth/XeaAuthActivity:isFinishing	()Z
    //   10: istore_3
    //   11: iload_3
    //   12: ifeq +6 -> 18
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: aload_0
    //   19: getfield 29	com/xiaoenai/app/classes/auth/XeaAuthActivity:g	Lcom/xiaoenai/app/widget/TitleBarView;
    //   22: iconst_0
    //   23: invokevirtual 144	com/xiaoenai/app/widget/TitleBarView:setRightButtonEnable	(Z)V
    //   26: aload_0
    //   27: aload_0
    //   28: invokestatic 296	com/xiaoenai/app/ui/a/h:a	(Landroid/content/Context;)Lcom/xiaoenai/app/ui/a/h;
    //   31: putfield 298	com/xiaoenai/app/classes/auth/XeaAuthActivity:a	Lcom/xiaoenai/app/ui/a/h;
    //   34: aload_0
    //   35: getfield 298	com/xiaoenai/app/classes/auth/XeaAuthActivity:a	Lcom/xiaoenai/app/ui/a/h;
    //   38: iload_2
    //   39: invokevirtual 299	com/xiaoenai/app/ui/a/h:setCancelable	(Z)V
    //   42: aload_1
    //   43: ifnull +11 -> 54
    //   46: aload_0
    //   47: getfield 298	com/xiaoenai/app/classes/auth/XeaAuthActivity:a	Lcom/xiaoenai/app/ui/a/h;
    //   50: aload_1
    //   51: invokevirtual 300	com/xiaoenai/app/ui/a/h:a	(Ljava/lang/String;)V
    //   54: aload_0
    //   55: getfield 298	com/xiaoenai/app/classes/auth/XeaAuthActivity:a	Lcom/xiaoenai/app/ui/a/h;
    //   58: invokevirtual 303	com/xiaoenai/app/ui/a/h:isShowing	()Z
    //   61: ifne -46 -> 15
    //   64: aload_0
    //   65: invokevirtual 291	com/xiaoenai/app/classes/auth/XeaAuthActivity:isFinishing	()Z
    //   68: ifne -53 -> 15
    //   71: aload_0
    //   72: getfield 298	com/xiaoenai/app/classes/auth/XeaAuthActivity:a	Lcom/xiaoenai/app/ui/a/h;
    //   75: invokevirtual 304	com/xiaoenai/app/ui/a/h:show	()V
    //   78: goto -63 -> 15
    //   81: astore_1
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_1
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	XeaAuthActivity
    //   0	86	1	paramString	String
    //   0	86	2	paramBoolean	boolean
    //   10	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	11	81	finally
    //   18	42	81	finally
    //   46	54	81	finally
    //   54	78	81	finally
  }
  
  public void c()
  {
    com.xiaoenai.app.classes.common.a.a().a(this);
    h();
    b(this.b);
  }
  
  public void d()
  {
    a(2, null);
  }
  
  public void f_()
  {
    if (UserConfig.getString("cur_version", "").equals("v5.6.0"))
    {
      i();
      return;
    }
    j();
  }
  
  public void l_()
  {
    if (this.g != null) {
      this.g.setRightButtonEnable(true);
    }
    if ((this.a != null) && (this.a.isShowing())) {
      this.a.dismiss();
    }
    this.a = null;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      a(-1, null);
      return;
    }
    this.j = paramBundle.getStringExtra("appkey");
    paramBundle = paramBundle.getStringExtra("appsig");
    if ((paramBundle == null) || (TextUtils.isEmpty(paramBundle)) || (this.j == null) || (TextUtils.isEmpty(this.j)))
    {
      com.xiaoenai.app.utils.f.a.c("{} {}", new Object[] { this.j, paramBundle });
      a(-3, null);
      return;
    }
    overridePendingTransition(2130968604, 2130968605);
    this.d = false;
    setContentView(2130903087);
    this.b = (Xiaoenai.h + "v1/sdk/oauth1/authorize?appkey=" + this.j + "&appsig=" + paramBundle + "&ts=" + (int)com.xiaoenai.app.utils.ak.b());
    f();
    if (this.i != null) {
      this.k = new b(this.i, this, new aj(this), new ak(this, this), this.j);
    }
    this.k.a();
    if ((AppModel.getInstance().isLogined()) && (AppModel.getInstance().getToken() != null) && (AppModel.getInstance().getToken().length() > 0))
    {
      b(this.b);
      return;
    }
    g();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      a(-1, null);
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\auth\XeaAuthActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */