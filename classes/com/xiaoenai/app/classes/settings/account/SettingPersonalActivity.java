package com.xiaoenai.app.classes.settings.account;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.classes.common.dialog.e;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.net.l;
import com.xiaoenai.app.net.n;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.ui.a.k;
import com.xiaoenai.app.utils.d.f;
import com.xiaoenai.app.utils.e.b;
import com.xiaoenai.app.utils.f.a;
import java.io.File;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class SettingPersonalActivity
  extends TitleBarActivity
{
  private View A;
  private TextView B;
  private TextView C;
  private boolean D = false;
  private boolean E = false;
  private boolean F = false;
  private boolean G = true;
  private String H = null;
  private String I = null;
  private String J = null;
  private ImageView K;
  private ImageView a = null;
  private TextView b = null;
  private TextView c = null;
  private Button i;
  private Button j;
  private Button k;
  private Button l;
  private Button m;
  private ImageView n;
  private ImageView o;
  private ImageView s;
  private ImageView t;
  private ImageView u;
  private TextView v;
  private TextView w;
  private TextView x;
  private TextView y;
  private TextView z;
  
  private void C()
  {
    com.xiaoenai.app.ui.a.g localg = new com.xiaoenai.app.ui.a.g(this);
    localg.a(2131101175);
    localg.a(2131100898, new cb(this));
    localg.show();
  }
  
  private boolean D()
  {
    if ((this.G) && (User.getInstance().getEmail() != null) && (this.D)) {}
    for (int i1 = 1;; i1 = 0)
    {
      int i2 = i1;
      if (this.E) {
        i2 = i1 + 1;
      }
      return i2 + c(this.H) + c(this.I) + c(this.J) >= 2;
    }
  }
  
  private void E()
  {
    h.c(this, 2131101253, 1500L);
  }
  
  private void a(int paramInt, CharSequence paramCharSequence)
  {
    Intent localIntent = new Intent(this, SettingNameOrMailActivity.class);
    localIntent.putExtra("Type", paramInt);
    localIntent.putExtra("preText", paramCharSequence);
    if (paramInt == 1) {
      localIntent.putExtra("isEmailVerify", this.D);
    }
    startActivity(localIntent);
    overridePendingTransition(2130968604, 2130968605);
  }
  
  private void a(CharSequence paramCharSequence, int paramInt)
  {
    com.xiaoenai.app.ui.a.g localg = new com.xiaoenai.app.ui.a.g(this);
    localg.a(paramCharSequence);
    localg.a(2131100898, new bh(this, paramInt));
    localg.show();
  }
  
  private void a(String paramString1, String paramString2)
  {
    new l(new bn(this, this)).h(paramString1, paramString2);
  }
  
  private void a(String paramString1, String paramString2, Platform paramPlatform)
  {
    new l(new bq(this, this, paramPlatform)).j(paramString1, paramString2);
  }
  
  private void a(JSONObject paramJSONObject)
  {
    this.D = paramJSONObject.getBoolean("email");
    this.E = paramJSONObject.getBoolean("phone");
    this.F = paramJSONObject.getBoolean("username_modified");
    this.G = paramJSONObject.getBoolean("password_exist");
    if ((paramJSONObject.has("qq_nickname")) && (!paramJSONObject.isNull("qq_nickname"))) {
      this.H = paramJSONObject.getString("qq_nickname");
    }
    if ((paramJSONObject.has("sina_nickname")) && (!paramJSONObject.isNull("sina_nickname"))) {
      this.I = paramJSONObject.getString("sina_nickname");
    }
    if ((paramJSONObject.has("wx_nickname")) && (!paramJSONObject.isNull("wx_nickname"))) {
      this.J = paramJSONObject.getString("wx_nickname");
    }
  }
  
  private void a(boolean paramBoolean)
  {
    new l(new bf(this, this, paramBoolean)).d();
  }
  
  private void b(String paramString)
  {
    if (paramString == null) {
      return;
    }
    n localn = new n(new be(this, this, paramString));
    a.c("upload avatar 3", new Object[0]);
    localn.d(paramString);
  }
  
  private void b(String paramString1, String paramString2)
  {
    new l(new bo(this, this)).i(paramString1, paramString2);
  }
  
  private int c(String paramString)
  {
    int i1 = 0;
    if (paramString != null) {
      i1 = 1;
    }
    return i1;
  }
  
  private void h()
  {
    this.a = ((ImageView)findViewById(2131559741));
    this.c = ((TextView)findViewById(2131559747));
    this.b = ((TextView)findViewById(2131559744));
    this.i = ((Button)findViewById(2131559754));
    this.j = ((Button)findViewById(2131559758));
    this.k = ((Button)findViewById(2131559767));
    this.l = ((Button)findViewById(2131559764));
    this.m = ((Button)findViewById(2131559751));
    this.v = ((TextView)findViewById(2131559755));
    this.w = ((TextView)findViewById(2131559759));
    this.x = ((TextView)findViewById(2131559768));
    this.y = ((TextView)findViewById(2131559762));
    this.z = ((TextView)findViewById(2131559750));
    this.n = ((ImageView)findViewById(2131559753));
    this.o = ((ImageView)findViewById(2131559757));
    this.s = ((ImageView)findViewById(2131559766));
    this.t = ((ImageView)findViewById(2131559761));
    this.u = ((ImageView)findViewById(2131559749));
    this.K = ((ImageView)findViewById(2131559763));
  }
  
  private void i()
  {
    e locale = new e(this);
    locale.setTitle(2131101161);
    locale.a(2131101166, 1, new av(this, locale));
    if (this.E) {
      locale.a(2131101223, 1, new bg(this, locale));
    }
    locale.a(2131101222, 1, new bt(this, locale));
    locale.show();
  }
  
  private void j()
  {
    h.c(this, 2131101187, 1500L);
  }
  
  private void k()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("isPhoneVerify", this.E);
    localIntent.setClass(this, SettingPhoneInputActivity.class);
    startActivityForResult(localIntent, 3);
    overridePendingTransition(2130968604, 2130968605);
  }
  
  private void o()
  {
    User localUser = User.getInstance();
    Object localObject = f.a(Xiaoenai.j(), UserConfig.getUserBindedInfo());
    if ((localObject != null) && (((File)localObject).exists()))
    {
      localObject = f.b((File)localObject);
      a.c("user bind info = {}", new Object[] { localObject });
    }
    try
    {
      a((JSONObject)localObject);
      if ((localUser.getNickName() != null) && (localUser.getNickName().length() > 0))
      {
        this.b.setText(localUser.getNickName());
        this.b.setTextColor(getResources().getColor(2131493103));
        p();
        b.a(this.a, localUser.getAvatar());
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
        continue;
        this.b.setTextColor(getResources().getColor(2131493073));
        this.b.setText(2131101168);
      }
    }
  }
  
  private void p()
  {
    if (this.D)
    {
      this.n.setImageResource(2130838813);
      this.i.setBackgroundResource(2130839085);
      this.i.setText(2131101185);
      this.i.setTextColor(getResources().getColor(2131493103));
      this.v.setText(User.getInstance().getEmail());
      this.v.setTextSize(2, 18.0F);
      if (!this.F) {
        break label611;
      }
      this.c.setText(User.getInstance().getUserName());
      this.c.setTextColor(-9205075);
      label108:
      if (this.H == null) {
        break label703;
      }
      this.o.setImageResource(2130838821);
      this.j.setBackgroundResource(2130839085);
      this.j.setText(2131101185);
      this.j.setTextColor(getResources().getColor(2131493103));
      this.w.setText(this.H);
      this.w.setTextSize(2, 18.0F);
      label184:
      if (this.I == null) {
        break label774;
      }
      this.s.setImageResource(2130838825);
      this.k.setBackgroundResource(2130839085);
      this.k.setText(2131101185);
      this.k.setTextColor(getResources().getColor(2131493103));
      this.x.setText(this.I);
      this.x.setTextSize(2, 18.0F);
      label260:
      if (this.J == null) {
        break label845;
      }
      this.t.setImageResource(2130838823);
      this.l.setBackgroundResource(2130839085);
      this.l.setText(2131101185);
      this.l.setTextColor(getResources().getColor(2131493103));
      this.y.setText(this.J);
      this.y.setTextSize(2, 18.0F);
      label336:
      if (!this.E) {
        break label920;
      }
      this.u.setImageResource(2130838819);
      this.m.setBackgroundResource(2130839085);
      this.m.setText(2131101185);
      this.m.setTextColor(getResources().getColor(2131493103));
      this.z.setText(User.getInstance().getPhoneNum());
      this.z.setTextSize(2, 18.0F);
    }
    for (;;)
    {
      if (!this.G) {
        break label991;
      }
      this.B.setText(2131101161);
      this.C.setText(2131101162);
      return;
      if ((User.getInstance().getEmail() == null) || (User.getInstance().getEmail().equals("")))
      {
        this.n.setImageResource(2130838814);
        this.i.setBackgroundResource(2130839084);
        this.i.setText(2131101186);
        this.i.setTextColor(getResources().getColor(2131493073));
        this.v.setText(2131101158);
        this.v.setTextSize(2, 18.0F);
        break;
      }
      this.n.setImageResource(2130838813);
      this.i.setBackgroundResource(2130839084);
      this.i.setText(2131101189);
      this.i.setTextColor(getResources().getColor(2131493073));
      this.v.setText(User.getInstance().getEmail());
      this.v.setTextSize(2, 18.0F);
      break;
      label611:
      Spanned localSpanned = Html.fromHtml(User.getInstance().getUserName() + "<font color=\"" + getResources().getColor(2131493073) + "\"> (" + getString(2131101188) + ") </font>");
      this.c.setText(localSpanned);
      this.c.setTextColor(getResources().getColor(2131493103));
      break label108;
      label703:
      this.o.setImageResource(2130838822);
      this.j.setBackgroundResource(2130839084);
      this.j.setText(2131101186);
      this.j.setTextColor(getResources().getColor(2131493073));
      this.w.setText(2131101170);
      this.w.setTextSize(2, 18.0F);
      break label184;
      label774:
      this.s.setImageResource(2130838826);
      this.k.setBackgroundResource(2130839084);
      this.k.setText(2131101186);
      this.k.setTextColor(getResources().getColor(2131493073));
      this.x.setText(2131101263);
      this.x.setTextSize(2, 18.0F);
      break label260;
      label845:
      this.t.setImageResource(2130838824);
      this.l.setBackgroundResource(2130839084);
      this.l.setText(2131101186);
      this.l.setTextColor(getResources().getColor(2131493073));
      this.y.setText(getString(2131101190));
      this.y.setTextSize(2, 18.0F);
      break label336;
      label920:
      this.u.setImageResource(2130838820);
      this.m.setBackgroundResource(2130839084);
      this.m.setText(2131101186);
      this.m.setTextColor(getResources().getColor(2131493073));
      this.z.setText(2131101169);
      this.z.setTextSize(2, 18.0F);
    }
    label991:
    this.B.setText(2131101160);
    this.C.setText(2131101163);
  }
  
  private void q()
  {
    Platform localPlatform = ShareSDK.getPlatform(this, SinaWeibo.NAME);
    localPlatform.setPlatformActionListener(new bp(this, localPlatform));
    localPlatform.authorize();
  }
  
  private void s()
  {
    new k(this).a(2131101649, getResources().getString(2131101192), 2131099973, new br(this), 2131100898, new bs(this));
  }
  
  private void t()
  {
    new k(this).a(2131101649, 2131099973, new bu(this), 2131100898, new bv(this));
  }
  
  private void u()
  {
    new k(this).a(2131101649, getResources().getString(2131101176), 2131099973, new bw(this), 2131100898, new bx(this));
  }
  
  private void v()
  {
    new l(new by(this, this)).a(false, false, false, true, false);
  }
  
  private void w()
  {
    new l(new bz(this, this)).a(false, false, false, false, true);
  }
  
  private void x()
  {
    new l(new ca(this, this)).a(false, false, true, false, false);
  }
  
  public int a()
  {
    return 2130903320;
  }
  
  public void a(Class<?> paramClass)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this, paramClass);
    startActivity(localIntent);
    overridePendingTransition(2130968604, 2130968605);
  }
  
  public void c()
  {
    ((RelativeLayout)findViewById(2131558636)).setOnClickListener(new cc(this));
    findViewById(2131559742).setOnClickListener(new cf(this));
    findViewById(2131559745).setOnClickListener(new cg(this));
    findViewById(2131559752).setOnClickListener(new ci(this));
    findViewById(2131559760).setOnClickListener(new cj(this));
    View localView1 = findViewById(2131559756);
    localView1.setOnClickListener(new ck(this));
    View localView2 = findViewById(2131559765);
    localView2.setOnClickListener(new aw(this));
    View localView3 = findViewById(2131559748);
    localView3.setOnClickListener(new ax(this));
    this.A = findViewById(2131559769);
    this.B = ((TextView)findViewById(2131559770));
    this.C = ((TextView)findViewById(2131559771));
    this.A.setOnClickListener(new ay(this));
    this.i.setOnClickListener(new az(this));
    this.j.setOnClickListener(new ba(this));
    this.k.setOnClickListener(new bb(this));
    this.l.setOnClickListener(new bc(this));
    this.m.setOnClickListener(new bd(this));
    if (!Xiaoenai.j().getResources().getConfiguration().locale.equals(Locale.SIMPLIFIED_CHINESE))
    {
      localView1.setVisibility(8);
      localView3.setVisibility(8);
      localView2.setVisibility(8);
    }
  }
  
  public void d()
  {
    e locale = new e(this);
    int i1 = 2131101171;
    if (this.J != null) {
      i1 = 2131101173;
    }
    locale.a(i1, 1, new bi(this, locale));
    locale.show();
  }
  
  public void f()
  {
    e locale = new e(this);
    int i1 = 2131101171;
    if (this.H != null) {
      i1 = 2131101173;
    }
    locale.a(i1, 1, new bk(this, locale));
    locale.show();
  }
  
  public void g()
  {
    e locale = new e(this);
    int i1 = 2131101171;
    if (this.I != null) {
      i1 = 2131101173;
    }
    locale.a(i1, 1, new bm(this, locale));
    locale.show();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      a.c(true, "requestCode = {} data={}", new Object[] { Integer.valueOf(paramInt1), paramIntent });
      if (paramInt1 == 21)
      {
        paramIntent = paramIntent.getStringArrayExtra("image_url_array");
        if ((paramIntent != null) && (paramIntent.length > 0)) {
          com.xiaoenai.app.utils.g.a().a(com.xiaoenai.app.utils.g.a().a(paramIntent[0]), true, null, 1280, 1280, this);
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (paramInt1 != 5) {
            break;
          }
        } while ((paramIntent == null) || (paramIntent.getData() == null));
        b(paramIntent.getData().getPath());
        return;
      } while ((paramInt1 != 0) || (paramIntent == null) || (paramIntent.getData() == null));
      b(paramIntent.getData().getPath());
      return;
      if (paramInt2 == 9)
      {
        h.a(this, 2131101172, 1500L);
        return;
      }
    } while (paramInt2 != 16);
    h.a(this, 2131101177, 1500L);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    h();
    c();
    a(true);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      finish();
      overridePendingTransition(2130968606, 2130968607);
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onRestart()
  {
    super.onRestart();
    a(false);
  }
  
  protected void onResume()
  {
    super.onResume();
    o();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\account\SettingPersonalActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */