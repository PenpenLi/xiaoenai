package com.xiaoenai.app.classes.home;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.ecloud.pulltozoomview.PullToZoomScrollViewEx;
import com.xiaoenai.app.classes.common.share.ShareInfo;
import com.xiaoenai.app.classes.common.share.p;
import com.xiaoenai.app.classes.extentions.anniversary.AnniversaryAddActivity;
import com.xiaoenai.app.classes.home.a.m;
import com.xiaoenai.app.classes.home.a.m.a;
import com.xiaoenai.app.classes.home.view.ContentView;
import com.xiaoenai.app.classes.home.view.LoverSearchView;
import com.xiaoenai.app.classes.home.view.UserInfoView.a;
import com.xiaoenai.app.model.ConfigCenter;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.net.l;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.utils.ak;
import com.xiaoenai.app.utils.e.b;
import com.xiaoenai.app.utils.g;
import com.xiaoenai.app.widget.TitleBarView;
import org.json.JSONObject;

public class v
  extends m
  implements UserInfoView.a
{
  private ContentView a;
  private View c;
  private ImageView d;
  private View f;
  private TextView g;
  private ImageView h;
  private TitleBarView i;
  private LoverSearchView j;
  private PullToZoomScrollViewEx k;
  private boolean l = false;
  private int m = 0;
  private View.OnClickListener n = new w(this);
  private View.OnClickListener o = new z(this);
  private boolean p = true;
  private JSONObject q;
  private JSONObject r;
  
  private void c(int paramInt)
  {
    if (!User.isSingle())
    {
      UserConfig.remove("home_search_lover_avatar");
      UserConfig.remove("home_search_lover_email");
      this.c = LayoutInflater.from(getActivity()).inflate(2130903241, null);
      this.i.setVisibility(8);
      this.j.setVisibility(8);
      this.d = ((ImageView)View.inflate(getActivity(), 2130903152, null));
      f();
      this.c.setOnClickListener(new ac(this));
      this.f = this.c.findViewById(2131559451);
      this.g = ((TextView)this.c.findViewById(2131559452));
      this.g.setOnClickListener(new ad(this));
      m();
      this.h = ((ImageView)this.c.findViewById(2131559453));
      this.h.setOnClickListener(new ae(this));
      this.a.setUserModeChangeListener(this);
      this.k.setZoomView(this.d);
      this.k.setHeaderView(this.c);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, com.xiaoenai.app.utils.ab.a() - (int)getResources().getDimension(2131230872) - com.xiaoenai.app.utils.ab.a(70.0F));
      this.k.setHeaderLayoutParams(localLayoutParams);
      this.k.setZoomEnabled(true);
      this.k.setHideHeader(false);
    }
    for (;;)
    {
      this.k.setScrollContentView(this.a);
      this.k.setParallax(false);
      return;
      if (this.c != null)
      {
        this.d.setImageDrawable(null);
        this.c = null;
      }
      this.j.setVisibility(0);
      this.k.setHideHeader(true);
      this.k.setZoomEnabled(false);
      this.i.setVisibility(0);
      this.a.a(paramInt);
    }
  }
  
  private void l()
  {
    if (!com.xiaoenai.app.utils.ai.o()) {
      return;
    }
    a.a().a(getActivity(), "index", new ai(this, getActivity()));
  }
  
  private void m()
  {
    if (User.getInstance().getLovedTime() > 0L)
    {
      long l1 = ak.f(User.getInstance().getLovedTime() * 1000L);
      String str = String.format(getString(2131100552), new Object[] { Long.valueOf(l1) });
      if (this.g != null) {
        this.g.setText(str);
      }
    }
  }
  
  private void n()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(getActivity(), AnniversaryAddActivity.class);
    localIntent.putExtra("index", 0);
    getActivity().startActivity(localIntent);
  }
  
  private void o()
  {
    h localh = h.a(getActivity());
    new l(new x(this, getActivity(), localh)).l();
  }
  
  private void p()
  {
    ShareInfo localShareInfo = new ShareInfo(this.q);
    localShareInfo.b(4);
    localShareInfo.e(com.xiaoenai.app.utils.e.a("weChatIcon.png", com.xiaoenai.app.utils.e.a, "weChatIcon1.png"));
    localShareInfo.f("http://xiaoenai.com");
    new p().a(localShareInfo, getActivity().getString(2131100598), getActivity(), new com.xiaoenai.app.classes.common.share.e());
  }
  
  private void q()
  {
    if (this.r == null)
    {
      u();
      return;
    }
    v();
  }
  
  private void u()
  {
    h localh = h.a(getActivity());
    new l(new y(this, getActivity(), localh)).u();
  }
  
  private void v()
  {
    ShareInfo localShareInfo = new ShareInfo(this.r);
    localShareInfo.a(new String[] { "wxs", "qq" });
    localShareInfo.d(localShareInfo.b());
    localShareInfo.f("http://xiaoenai.com");
    localShareInfo.c(com.xiaoenai.app.utils.e.a("weChatIcon.png", com.xiaoenai.app.utils.e.a, "weChatIcon1.png"));
    localShareInfo.e(com.xiaoenai.app.utils.e.a("weChatIcon.png", com.xiaoenai.app.utils.e.a, "weChatIcon1.png"));
    localShareInfo.b(4);
    new p().a(localShareInfo, getActivity().getString(2131100559), getActivity(), new com.xiaoenai.app.classes.common.share.e());
  }
  
  public void a()
  {
    this.a.a(this.n, this.o);
  }
  
  public void a(int paramInt)
  {
    this.l = true;
    this.m = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.a != null)
    {
      this.a.setTopBarViewClickEnalbe(Boolean.valueOf(paramBoolean));
      this.p = paramBoolean;
    }
  }
  
  public void b()
  {
    this.a.e();
  }
  
  public void b(int paramInt)
  {
    this.a.a(paramInt);
    c(paramInt);
    this.a.f();
    if (User.isSingle()) {}
    while (!(getActivity() instanceof HomeActivity)) {
      return;
    }
    ((HomeActivity)getActivity()).a(this);
  }
  
  public boolean c()
  {
    return this.a.i();
  }
  
  public void d()
  {
    if (this.j != null) {
      this.j.a();
    }
    this.a.h();
    m();
    f();
  }
  
  public void e()
  {
    this.a.f();
  }
  
  public void f()
  {
    String str = User.getInstance().getCouplePhotoUrl();
    if (str != null)
    {
      str = str + "?imageView/1/w/" + com.xiaoenai.app.utils.ab.b() + "/h/" + com.xiaoenai.app.utils.ab.b();
      b.a(this.d, str, new aj(this, str));
    }
  }
  
  public void g()
  {
    if (this.a != null) {
      this.a.b();
    }
  }
  
  public void h()
  {
    if (this.a != null) {
      this.a.c();
    }
  }
  
  public void i()
  {
    if (this.a != null) {
      this.a.k();
    }
  }
  
  public void j()
  {
    this.a.m();
  }
  
  public void k()
  {
    if (this.q == null)
    {
      o();
      return;
    }
    p();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      com.xiaoenai.app.utils.f.a.c("data:{}", new Object[] { paramIntent });
      if (paramInt1 != 21) {
        break label69;
      }
      paramIntent = paramIntent.getStringArrayExtra("image_url_array");
      if (paramIntent != null) {
        g.a().a(g.a().a(paramIntent[0]), true, this, 1280, 1280, null);
      }
    }
    label69:
    while (paramInt1 != 5) {
      return;
    }
    paramIntent = paramIntent.getData().getPath();
    g.a().a(paramIntent, getActivity());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = paramLayoutInflater.inflate(2130903244, paramViewGroup, false);
    this.i = ((TitleBarView)paramLayoutInflater.findViewById(2131559463));
    this.i.setLeftButtonClickListener(new aa(this));
    this.i.setRightButtonClickListener(new ab(this));
    this.j = ((LoverSearchView)paramLayoutInflater.findViewById(2131559464));
    this.k = ((PullToZoomScrollViewEx)paramLayoutInflater.findViewById(2131559465));
    if (Build.VERSION.SDK_INT >= 11) {
      this.k.setOverScrollMode(2);
    }
    this.a = new ContentView(getActivity());
    c(2);
    paramViewGroup = new RelativeLayout.LayoutParams(-1, -1);
    paramViewGroup.addRule(2, 2131559171);
    paramLayoutInflater.setLayoutParams(paramViewGroup);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    this.a.j();
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    h();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.l)
    {
      j();
      b(this.m);
      this.l = false;
    }
    d();
    c();
    e();
    if (this.b != null) {
      this.b.b(0);
    }
    com.xiaoenai.app.utils.f.a.c("***********ConfigCenter.isShowHomeBanner():{}", new Object[] { Boolean.valueOf(ConfigCenter.isShowHomeBanner()) });
    if (ConfigCenter.isShowHomeBanner())
    {
      l();
      a();
    }
    g();
    this.j.b();
    this.a.k();
  }
  
  public void onStart()
  {
    super.onStart();
    this.a.a();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\home\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */