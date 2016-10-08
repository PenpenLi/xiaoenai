package com.xiaoenai.app.classes.home.a;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.common.c.d;
import com.xiaoenai.app.classes.common.c.e;
import com.xiaoenai.app.classes.common.c.f;
import com.xiaoenai.app.classes.common.c.i;
import com.xiaoenai.app.classes.home.a.b;
import com.xiaoenai.app.classes.home.a.c;
import com.xiaoenai.app.classes.home.notification.DynamicNotification;
import com.xiaoenai.app.classes.home.view.LoverSearchView;
import com.xiaoenai.app.model.ConfigCenter;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.ui.component.view.ProgressView;
import com.xiaoenai.app.utils.ai;
import com.xiaoenai.app.utils.e.b;
import com.xiaoenai.app.widget.BannerView;
import com.xiaoenai.app.widget.TitleBarView;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class o
  extends m
  implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener
{
  private LayoutInflater a;
  private RelativeLayout c;
  private TitleBarView d;
  private ListView f;
  private LoverSearchView g;
  private ProgressView h = null;
  private boolean i = false;
  private int j = 0;
  private n k;
  private HashMap<String, DynamicNotification> l = new HashMap();
  private List<DynamicNotification> m = new com.xiaoenai.app.utils.x(new p(this));
  private com.xiaoenai.app.d.v n = new com.xiaoenai.app.d.v();
  private a o;
  private boolean p = false;
  private Handler q = new Handler();
  private BannerView r;
  private RelativeLayout s;
  private ImageButton t;
  private LinearLayout u;
  private ImageView v;
  private View.OnClickListener w = new q(this);
  private View.OnClickListener x = new r(this);
  private Comparator<DynamicNotification> y = new w(this);
  
  private void a(View paramView)
  {
    this.f = ((ListView)paramView.findViewById(2131559520));
    this.k = new n(null, getActivity());
    this.s = ((RelativeLayout)paramView.findViewById(2131559455));
    this.r = ((BannerView)this.s.findViewById(2131559511));
    this.t = ((ImageButton)this.s.findViewById(2131559512));
    User.getInstance();
    if (User.isSingle()) {
      this.g.setVisibility(0);
    }
    this.f.setAdapter(this.k);
    this.f.setOnItemClickListener(this);
    this.f.setOnItemLongClickListener(this);
    this.d = ((TitleBarView)paramView.findViewById(2131559518));
    this.h = ((ProgressView)paramView.findViewById(2131558669));
    this.u = ((LinearLayout)paramView.findViewById(2131559521));
    this.v = ((ImageView)paramView.findViewById(2131559522));
  }
  
  private void a(View paramView, int paramInt)
  {
    if (paramInt < this.m.size())
    {
      paramView = (DynamicNotification)this.m.get(paramInt);
      this.n.a(paramView.getUpdated_at());
      this.m.remove(paramView);
      this.l.remove(paramView.getGroup());
      this.k.a(this.m.toArray());
      c(this.m.size());
      if (this.o != null) {
        this.o.a();
      }
      return;
    }
    h.c(getActivity(), "index: " + paramInt, 2000L);
  }
  
  private void a(DynamicNotification paramDynamicNotification)
  {
    DynamicNotification localDynamicNotification = (DynamicNotification)this.l.get(paramDynamicNotification.getGroup());
    localDynamicNotification.setCount(localDynamicNotification.getCount() + paramDynamicNotification.getCount());
    localDynamicNotification.setContent(paramDynamicNotification.getContent());
    localDynamicNotification.setUpdated_at(paramDynamicNotification.getUpdated_at());
    localDynamicNotification.setTitle(paramDynamicNotification.getTitle());
    localDynamicNotification.setModule(paramDynamicNotification.getModule());
    localDynamicNotification.setReadStatus(0);
  }
  
  private void b(DynamicNotification paramDynamicNotification)
  {
    paramDynamicNotification.setReadStatus(1);
    paramDynamicNotification.setCount(0);
    this.n.c(paramDynamicNotification);
  }
  
  private void c()
  {
    a(this.n.b());
    if (this.o != null) {
      this.o.a();
    }
  }
  
  private void c(int paramInt)
  {
    if (this.u != null)
    {
      if (paramInt > 0) {
        this.u.setVisibility(8);
      }
    }
    else {
      return;
    }
    this.u.setVisibility(0);
    User.getInstance();
    if (User.isSingle())
    {
      this.v.setVisibility(8);
      return;
    }
    this.v.setVisibility(0);
  }
  
  private void d()
  {
    if (!ai.n()) {
      return;
    }
    com.xiaoenai.app.classes.home.a.a().a(getActivity(), "noti", new u(this, getActivity()));
  }
  
  private void d(int paramInt)
  {
    DynamicNotification localDynamicNotification = this.k.a(paramInt);
    if (localDynamicNotification.getReadStatus() == 0)
    {
      localDynamicNotification.setReadStatus(1);
      b(localDynamicNotification);
      this.k.notifyDataSetChanged();
    }
    com.xiaoenai.app.classes.common.c.g localg = new f().a(localDynamicNotification, "notification");
    if (localg != null)
    {
      if ((localDynamicNotification.getModule() != null) && (!localDynamicNotification.getModule().equalsIgnoreCase("xiaoenai.event.browser")))
      {
        com.xiaoenai.app.utils.f.a.c("notify inner", new Object[0]);
        new e().a(getActivity(), localg);
      }
    }
    else {
      return;
    }
    com.xiaoenai.app.utils.f.a.c("notify outter", new Object[0]);
    new i().a(getActivity(), localg);
  }
  
  private void e()
  {
    a.b localb = com.xiaoenai.app.classes.home.a.a().a("noti");
    if (localb != null)
    {
      if (localb.a())
      {
        this.s.setVisibility(0);
        ViewGroup.LayoutParams localLayoutParams = this.r.getLayoutParams();
        localLayoutParams.height = localb.a(localb.f[0].b, localb.f[0].a);
        this.r.setLayoutParams(localLayoutParams);
        b.a(this.r, localb.f[0].c);
        this.s.setOnClickListener(this.w);
        this.t.setOnTouchListener(com.xiaoenai.app.utils.d.w.c);
        this.t.setOnClickListener(this.x);
      }
    }
    else {
      return;
    }
    this.s.setVisibility(8);
  }
  
  private void f()
  {
    this.q.post(new v(this));
  }
  
  private void g()
  {
    Collections.sort(this.m, this.y);
    this.k.a(this.m.toArray());
  }
  
  public void a()
  {
    if (!ai.m())
    {
      c();
      return;
    }
    b();
  }
  
  public void a(int paramInt)
  {
    this.i = true;
    this.j = paramInt;
  }
  
  public void a(a parama)
  {
    this.o = parama;
  }
  
  public void a(List<DynamicNotification> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.m.clear();
      this.l.clear();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        DynamicNotification localDynamicNotification = (DynamicNotification)paramList.next();
        if (!this.l.containsKey(localDynamicNotification.getGroup()))
        {
          this.l.put(localDynamicNotification.getGroup(), localDynamicNotification);
          this.m.add(localDynamicNotification);
        }
        else
        {
          a(localDynamicNotification);
        }
      }
      this.k.a(this.m.toArray());
    }
    c(this.m.size());
  }
  
  public void b()
  {
    if (this.p) {
      return;
    }
    new com.xiaoenai.app.net.e.a(new s(this, Xiaoenai.j())).a(UserConfig.getInt("global_notification_id_max", Integer.valueOf(0)).intValue(), UserConfig.getInt("user_notification_id_max", Integer.valueOf(0)).intValue());
  }
  
  public void b(int paramInt)
  {
    if (paramInt == 0) {
      if (this.g != null) {
        this.g.setVisibility(8);
      }
    }
    while ((1 != paramInt) || (this.g == null)) {
      return;
    }
    this.g.setVisibility(0);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.a = getLayoutInflater(paramBundle);
    this.c = ((RelativeLayout)this.a.inflate(2130903254, null));
    paramLayoutInflater = new RelativeLayout.LayoutParams(-1, -1);
    paramLayoutInflater.addRule(2, 2131559171);
    this.c.setLayoutParams(paramLayoutInflater);
    this.g = ((LoverSearchView)this.c.findViewById(2131559519));
    a(this.c);
    c();
    getActivity().getWindow().setSoftInputMode(3);
    return this.c;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    d(paramInt - this.f.getHeaderViewsCount());
    if (this.o != null) {
      this.o.a();
    }
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = new com.xiaoenai.app.ui.a.g(getActivity());
    paramAdapterView.a(2131100142);
    paramAdapterView.a(2131100104, new x(this, paramView, paramInt));
    paramAdapterView.b(2131099973, new y(this));
    paramAdapterView.show();
    return true;
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.i)
    {
      b(this.j);
      this.i = false;
    }
    this.d.a();
    a();
    if (this.b != null) {
      this.b.b(3);
    }
    if (ConfigCenter.isShowNotificationBanner())
    {
      d();
      e();
    }
    this.g.b();
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\home\a\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */