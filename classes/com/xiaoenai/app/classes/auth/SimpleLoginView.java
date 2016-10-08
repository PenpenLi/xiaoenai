package com.xiaoenai.app.classes.auth;

import android.content.Context;
import android.content.Intent;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qzone.QZone;
import cn.sharesdk.wechat.friends.Wechat;
import com.f.a.b;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.common.dialog.e;
import com.xiaoenai.app.classes.settings.account.ResetByEmailActivity;
import com.xiaoenai.app.classes.settings.account.ResetPasswordByPhoneNumActivity;
import com.xiaoenai.app.model.AppModel;
import com.xiaoenai.app.model.HomeModeSettings;
import com.xiaoenai.app.model.ShareSDKSettings;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.model.status.StatusList;
import com.xiaoenai.app.net.l;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.utils.am;
import com.xiaoenai.app.utils.am.a;
import com.xiaoenai.app.utils.as;
import com.xiaoenai.app.widget.TitleBarView;
import org.json.JSONException;
import org.json.JSONObject;

public class SimpleLoginView
  extends LinearLayout
{
  private EditText a;
  private EditText b;
  private Button c;
  private TitleBarView d;
  private XeaAuthActivity e;
  private int f = 0;
  private View g;
  private View h;
  private View i;
  private a j;
  
  public SimpleLoginView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public SimpleLoginView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a()
  {
    if (!as.a(this.e, "com.tencent.mm"))
    {
      as.b(2131101149);
      return;
    }
    h localh = i();
    localh.setCancelable(true);
    Platform localPlatform = ShareSDK.getPlatform(this.e, Wechat.NAME);
    localPlatform.setPlatformActionListener(new af(this, localh));
    localPlatform.authorize();
  }
  
  private void a(Context paramContext)
  {
    paramContext = LayoutInflater.from(getContext()).inflate(2130903088, this);
    this.c = ((Button)paramContext.findViewById(2131558746));
    Object localObject = new f(this);
    this.a = ((EditText)paramContext.findViewById(2131558742));
    this.a.setOnEditorActionListener((TextView.OnEditorActionListener)localObject);
    this.b = ((EditText)paramContext.findViewById(2131558744));
    this.b.setOnEditorActionListener((TextView.OnEditorActionListener)localObject);
    this.d = ((TitleBarView)paramContext.findViewById(2131558471));
    this.d.setLeftButtonClickListener(new w(this));
    this.d.setRightButtonVisible(8);
    this.c.setOnClickListener(new z(this));
    this.d.setRightButtonEnable(false);
    this.c.setEnabled(false);
    localObject = new aa(this);
    this.a.addTextChangedListener((TextWatcher)localObject);
    this.b.addTextChangedListener((TextWatcher)localObject);
    localObject = (TextView)findViewById(2131558747);
    ((TextView)localObject).setOnClickListener(new ab(this));
    ((TextView)localObject).getPaint().setFlags(1);
    this.g = paramContext.findViewById(2131558749);
    this.h = paramContext.findViewById(2131558748);
    this.i = paramContext.findViewById(2131558750);
    this.g.setOnTouchListener(com.xiaoenai.app.utils.d.w.a);
    this.g.setOnClickListener(new ac(this));
    this.h.setOnClickListener(new ad(this));
    this.h.setOnTouchListener(com.xiaoenai.app.utils.d.w.a);
    this.i.setOnClickListener(new ae(this));
    this.i.setOnTouchListener(com.xiaoenai.app.utils.d.w.a);
  }
  
  private void a(JSONObject paramJSONObject, boolean paramBoolean)
  {
    this.e.l_();
    this.h.setEnabled(true);
    Object localObject = null;
    try
    {
      JSONObject localJSONObject = paramJSONObject.getJSONObject("user_info");
      localObject = localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      try
      {
        ShareSDKSettings.loadShareSDK(this.e);
        HomeModeSettings.handleFunStatus(paramJSONObject.getJSONObject("fun_status"));
        b.b(this.e, "LoginSuccess");
        Xiaoenai.j().e();
        new l(this.e).a(true);
        as.a(as.k());
        if (this.j == null) {
          break label187;
        }
        if (!paramBoolean) {
          break label206;
        }
        this.j.f_();
        return;
        localJSONException = localJSONException;
        localJSONException.printStackTrace();
      }
      catch (Exception paramJSONObject)
      {
        for (;;)
        {
          paramJSONObject.printStackTrace();
        }
        this.j.c();
      }
    }
    if (paramJSONObject.has("im_history_ts")) {
      UserConfig.setInt("im_history_ts", paramJSONObject.optInt("im_history_ts"));
    }
    AppModel.getInstance().loadFromJson(paramJSONObject);
    AppModel.getInstance().save();
    com.xiaoenai.app.utils.f.a.c("userInfo: {}", new Object[] { localObject });
    new User((JSONObject)localObject).save();
    User.release();
    com.xiaoenai.app.classes.chat.messagelist.a.m();
    com.xiaoenai.app.classes.chat.messagelist.a.a();
    if (paramJSONObject.has("onekey_status")) {
      StatusList.getInstance().getStatusFromJson(paramJSONObject);
    }
    label187:
    label206:
    return;
  }
  
  private void b()
  {
    h localh = i();
    Platform localPlatform = ShareSDK.getPlatform(this.e, QZone.NAME);
    localPlatform.setPlatformActionListener(new g(this, localh));
    localPlatform.authorize();
  }
  
  private void b(String paramString1, String paramString2)
  {
    new l(new o(this, this.e)).c(paramString1, paramString2);
  }
  
  private void c()
  {
    h localh = i();
    Platform localPlatform = ShareSDK.getPlatform(this.e, SinaWeibo.NAME);
    localPlatform.setPlatformActionListener(new k(this, localh));
    localPlatform.authorize();
  }
  
  private void c(String paramString1, String paramString2)
  {
    new l(new p(this, this.e)).a(paramString1, paramString2);
  }
  
  private void d()
  {
    e locale = new e(this.e);
    locale.setTitle(2131100657);
    locale.a(2131100658, 1, new r(this, locale));
    locale.a(2131100653, 1, new s(this, locale));
    locale.show();
  }
  
  private void d(String paramString1, String paramString2)
  {
    new l(new q(this, this.e)).b(paramString1, paramString2);
  }
  
  private void e()
  {
    Intent localIntent = new Intent(this.e, ResetPasswordByPhoneNumActivity.class);
    this.e.startActivity(localIntent);
  }
  
  private void f()
  {
    Intent localIntent = new Intent(this.e, ResetByEmailActivity.class);
    localIntent.putExtra("from", "resetpassword");
    String str = this.a.getText().toString().trim();
    if ((str != null) && (str.contains("@")))
    {
      localIntent.setAction("resetPwdAction");
      localIntent.putExtra("email", str);
    }
    for (;;)
    {
      this.e.startActivity(localIntent);
      this.e.overridePendingTransition(2130968604, 2130968605);
      return;
      str = User.getInstance().getEmail();
      if ((str != null) && (!"".equals(str)))
      {
        localIntent.setAction("resetPwdAction");
        localIntent.putExtra("email", str);
      }
    }
  }
  
  private void g()
  {
    Object localObject = this.a.getText().toString().trim();
    String str = this.b.getText().toString().trim();
    am.a locala = am.c((String)localObject);
    if (!locala.a.booleanValue())
    {
      localObject = new com.xiaoenai.app.ui.a.g(getContext());
      ((com.xiaoenai.app.ui.a.g)localObject).a(locala.b);
      ((com.xiaoenai.app.ui.a.g)localObject).a(2131100898, new t(this));
      ((com.xiaoenai.app.ui.a.g)localObject).show();
      return;
    }
    locala = am.a(str);
    if (!locala.a.booleanValue())
    {
      localObject = new com.xiaoenai.app.ui.a.g(getContext());
      ((com.xiaoenai.app.ui.a.g)localObject).a(locala.b);
      ((com.xiaoenai.app.ui.a.g)localObject).a(2131100898, new u(this));
      ((com.xiaoenai.app.ui.a.g)localObject).show();
      return;
    }
    a((String)localObject, str);
  }
  
  private void h()
  {
    com.xiaoenai.app.ui.a.g localg = new com.xiaoenai.app.ui.a.g(this.e);
    localg.a(2131099961);
    localg.a(2131100898, new x(this));
    localg.setCancelable(false);
    localg.show();
  }
  
  private h i()
  {
    h localh = h.a(this.e);
    localh.show();
    localh.setCancelable(false);
    return localh;
  }
  
  private void j()
  {
    if (this.h != null) {
      this.h.post(new y(this));
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
    localInputMethodManager.hideSoftInputFromWindow(this.a.getWindowToken(), 0);
    localInputMethodManager.hideSoftInputFromWindow(this.b.getWindowToken(), 0);
    new com.xiaoenai.app.net.p(new v(this, getContext(), paramString1)).m(paramString1, paramString2);
  }
  
  public void setAuthActivity(XeaAuthActivity paramXeaAuthActivity)
  {
    this.e = paramXeaAuthActivity;
  }
  
  public void setLoginActionListener(a parama)
  {
    this.j = parama;
  }
  
  public static abstract interface a
  {
    public abstract void c();
    
    public abstract void d();
    
    public abstract void f_();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\auth\SimpleLoginView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */