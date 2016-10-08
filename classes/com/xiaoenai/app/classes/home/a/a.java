package com.xiaoenai.app.classes.home.a;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import com.alibaba.sdk.android.AlibabaHelper;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.home.a.b;
import com.xiaoenai.app.classes.home.model.HomeDiscoverBaseItem;
import com.xiaoenai.app.classes.home.model.HomeDiscoverItem;
import com.xiaoenai.app.classes.home.view.HomeDiscoverHeadLayoutView;
import com.xiaoenai.app.classes.home.view.viewHolder.LifeServiceItemViewHolder.a;
import com.xiaoenai.app.model.ConfigCenter;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.net.g;
import com.xiaoenai.app.net.q;
import com.xiaoenai.app.utils.ai;
import com.xiaoenai.app.utils.ak;
import com.xiaoenai.app.utils.as;
import com.xiaoenai.app.widget.TitleBarView;
import com.xiaoenai.app.widget.remindButton.RemindButton;
import java.net.URLEncoder;
import java.util.List;
import org.json.JSONObject;

public class a
  extends m
  implements AdapterView.OnItemClickListener
{
  private static int g = 0;
  public boolean a = false;
  private LayoutInflater c;
  private LinearLayout d;
  private TitleBarView f;
  private boolean h = false;
  private int i = 0;
  private ListView j;
  private j k;
  private HomeDiscoverHeadLayoutView l;
  private ImageView m;
  private RemindButton n;
  private LifeServiceItemViewHolder.a o = new i(this);
  
  private void a(View paramView)
  {
    this.f = ((TitleBarView)paramView.findViewById(2131559515));
    this.m = ((ImageView)paramView.findViewById(2131559008));
    this.n = ((RemindButton)paramView.findViewById(2131559009));
    this.l = ((HomeDiscoverHeadLayoutView)paramView.findViewById(2131559516));
    this.j = ((ListView)paramView.findViewById(2131559517));
    this.k = new j(paramView.getContext(), this.o);
    this.j.setAdapter(this.k);
    this.j.setOnItemClickListener(this);
  }
  
  private void a(List<HomeDiscoverBaseItem> paramList)
  {
    if (this.a)
    {
      g = 0;
      k.a().a(g, "xiaoenai.discovery.forum", getActivity());
      UserConfig.setLong("key_discover_forum_last_update_time", (int)ak.b());
      this.a = false;
    }
    for (;;)
    {
      this.k.a(paramList);
      return;
      g();
    }
  }
  
  private void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public static void b()
  {
    g = 0;
  }
  
  private void c()
  {
    View localView = this.c.inflate(2130903159, null);
    this.m = ((ImageView)localView.findViewById(2131559008));
    this.n = ((RemindButton)localView.findViewById(2131559009));
    this.f.setRightButtonView(localView);
  }
  
  private void d()
  {
    if (this.f != null) {
      this.f.setRightButtonClickListener(new b(this));
    }
  }
  
  private void e()
  {
    if (!ai.l()) {
      return;
    }
    com.xiaoenai.app.classes.home.a.a().a(getActivity(), "discover", new c(this, getActivity()));
  }
  
  private void f()
  {
    new com.xiaoenai.app.net.l(new d(this, getActivity())).s();
  }
  
  private void g()
  {
    if (!k.a().b("xiaoenai.discovery.forum")) {}
    while (!ai.j()) {
      return;
    }
    long l2 = UserConfig.getLong("key_discover_forum_last_update_time", -1L);
    long l1 = l2;
    if (l2 <= 0L)
    {
      l1 = (int)ak.b();
      UserConfig.setLong("key_discover_forum_last_update_time", l1);
    }
    new g(new e(this, getActivity())).a(l1);
  }
  
  private void h()
  {
    List localList = k.a().b();
    com.xiaoenai.app.utils.f.a.c("shouldRequestDiscoverList {}", new Object[] { Boolean.valueOf(ai.k()) });
    if ((localList != null) && (localList.size() > 0)) {
      a(localList);
    }
    for (;;)
    {
      if (ai.k()) {
        new q(new f(this, getActivity())).a();
      }
      return;
      i();
    }
  }
  
  private void i()
  {
    JSONObject localJSONObject = k.a().e();
    com.xiaoenai.app.utils.f.a.c("checkLocalDiscoverData {}", new Object[] { localJSONObject });
    l locall = new l(new h(this));
    if (Build.VERSION.SDK_INT >= 11)
    {
      locall.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new JSONObject[] { localJSONObject });
      return;
    }
    locall.execute(new JSONObject[] { localJSONObject });
  }
  
  public void a()
  {
    a.b localb = com.xiaoenai.app.classes.home.a.a().a("discover");
    if (this.l != null) {
      this.l.a(localb);
    }
  }
  
  public void a(int paramInt)
  {
    this.h = true;
    this.i = paramInt;
  }
  
  public void a(HomeDiscoverItem paramHomeDiscoverItem)
  {
    String str;
    if ((getActivity() != null) && (!getActivity().isFinishing()) && (isAdded()) && (paramHomeDiscoverItem != null) && (paramHomeDiscoverItem.getModule() != null) && (paramHomeDiscoverItem.getModule().length() > 0))
    {
      str = paramHomeDiscoverItem.getModule();
      if (paramHomeDiscoverItem.getRedHintsInfo() != null) {
        com.xiaoenai.app.widget.remindButton.a.a().b(paramHomeDiscoverItem.getRedHintsInfo());
      }
      if (!"xiaoenai.discovery.forum".equalsIgnoreCase(str)) {
        break label148;
      }
      UserConfig.setLong("key_discover_forum_last_update_time", (int)ak.b());
      a(true);
    }
    for (;;)
    {
      paramHomeDiscoverItem = new com.xiaoenai.app.classes.common.c.f().a(paramHomeDiscoverItem, "discovery");
      if ((str == null) || (str.equalsIgnoreCase("xiaoenai.event.browser"))) {
        break;
      }
      com.xiaoenai.app.utils.f.a.c("notify inner", new Object[0]);
      new com.xiaoenai.app.classes.common.c.e().a(getActivity(), paramHomeDiscoverItem);
      return;
      label148:
      if (("xiaoenai.discovery.lovepet".equalsIgnoreCase(str)) || ("xiaoenai.discovery.wishtree".equalsIgnoreCase(str)))
      {
        if (User.isSingle())
        {
          as.a();
          return;
        }
        int i1 = as.e("com.xiaoenai.app:lovepet");
        com.xiaoenai.app.utils.f.a.c("pid = {}", new Object[] { Integer.valueOf(i1) });
        if (i1 > 0) {
          Process.killProcess(i1);
        }
      }
    }
    com.xiaoenai.app.utils.f.a.c("notify outter", new Object[0]);
    new com.xiaoenai.app.classes.common.c.i().a(getActivity(), paramHomeDiscoverItem);
  }
  
  public void a(Class<?> paramClass)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(getActivity(), paramClass);
    getActivity().startActivity(localIntent);
    getActivity().overridePendingTransition(2130968604, 2130968605);
  }
  
  public void b(int paramInt)
  {
    if (this.l != null) {
      this.l.a(paramInt);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.c = getLayoutInflater(paramBundle);
    this.d = ((LinearLayout)this.c.inflate(2130903253, null));
    paramLayoutInflater = new RelativeLayout.LayoutParams(-1, -1);
    paramLayoutInflater.addRule(2, 2131559171);
    this.d.setLayoutParams(paramLayoutInflater);
    a(this.d);
    c();
    d();
    this.a = false;
    if (!AlibabaHelper.isInited) {
      AlibabaHelper.initSDK(Xiaoenai.j(), URLEncoder.encode(Xiaoenai.j().D));
    }
    return this.d;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (HomeDiscoverBaseItem)this.k.getItem(paramInt);
    if ((paramAdapterView != null) && (paramAdapterView.getType() == 0)) {
      a((HomeDiscoverItem)paramAdapterView);
    }
  }
  
  public void onResume()
  {
    h();
    if (this.h)
    {
      b(this.i);
      this.h = false;
    }
    if (!User.isSingle())
    {
      this.m.setVisibility(0);
      this.n.b();
      f();
    }
    for (;;)
    {
      this.f.a();
      super.onResume();
      if (this.b != null) {
        this.b.b(1);
      }
      if (ConfigCenter.isShowDiscoverBanner())
      {
        e();
        a();
      }
      Intent localIntent = new Intent("com.xiaoenai.app.COCOS_ON_PUSH_RECIEVED");
      localIntent.putExtra("Command", "exit");
      getActivity().sendBroadcast(localIntent, getString(2131101650));
      return;
      if (this.m != null) {
        this.m.setVisibility(8);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\home\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */