package com.xiaoenai.app.classes.home.a;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.xiaoenai.app.classes.home.view.ContentView;
import com.xiaoenai.app.classes.home.view.LoverSearchView;
import com.xiaoenai.app.model.RedHintsInfo;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.net.l;
import com.xiaoenai.app.utils.ai;
import com.xiaoenai.app.utils.as;
import com.xiaoenai.app.utils.e.b;
import com.xiaoenai.app.widget.TitleBarView;
import com.xiaoenai.app.widget.remindButton.RemindButton;
import com.xiaoenai.app.widget.remindButton.a;
import java.util.List;

public class z
  extends m
{
  private LayoutInflater a;
  private RelativeLayout c;
  private TitleBarView d;
  private ContentView f;
  private boolean g = false;
  private int h = 0;
  private RelativeLayout i;
  private ImageView j;
  private TextView k;
  private TextView l;
  private TextView m;
  private View n;
  private TextView o;
  private ImageView p;
  private RelativeLayout q;
  private RelativeLayout r;
  private LoverSearchView s;
  private RemindButton t;
  private RemindButton u;
  private RemindButton v;
  
  private void a(View paramView)
  {
    this.f = new ContentView(getActivity());
    this.s = ((LoverSearchView)paramView.findViewById(2131559530));
    User.getInstance();
    if (!User.isSingle()) {
      this.s.setVisibility(8);
    }
    if (this.c != null)
    {
      this.i = ((RelativeLayout)this.c.findViewById(2131559531));
      this.j = ((ImageView)this.c.findViewById(2131559532));
      this.k = ((TextView)this.c.findViewById(2131559534));
      this.l = ((TextView)this.c.findViewById(2131559535));
      this.m = ((TextView)this.c.findViewById(2131559536));
      this.n = this.c.findViewById(2131559537);
      this.o = ((TextView)this.c.findViewById(2131559539));
      this.p = ((ImageView)this.c.findViewById(2131559538));
      this.q = ((RelativeLayout)this.c.findViewById(2131559540));
      this.r = ((RelativeLayout)this.c.findViewById(2131559543));
      this.t = ((RemindButton)this.c.findViewById(2131559533));
      this.u = ((RemindButton)this.c.findViewById(2131559542));
      this.v = ((RemindButton)this.c.findViewById(2131559547));
      if ((!User.isWxEqNull()) || (UserConfig.getBoolean("v_wechat_entered_personal", Boolean.valueOf(false)).booleanValue())) {
        break label304;
      }
      this.t.a();
    }
    for (;;)
    {
      this.d = ((TitleBarView)this.c.findViewById(2131559515));
      return;
      label304:
      this.t.b();
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    String str = getString(2131101079);
    if ((paramBoolean1) && (paramBoolean2))
    {
      this.k.setText(str + getString(2131101080));
      return;
    }
    if ((paramBoolean1) || (paramBoolean2))
    {
      this.k.setText(str + getString(2131101082));
      return;
    }
    this.k.setText(Html.fromHtml(str + as.a(getString(2131101081), "#F45595")));
  }
  
  private void b()
  {
    User localUser = User.getInstance();
    b.a(this.j, localUser.getAvatar());
    if ((localUser.getNickName() != null) && (localUser.getNickName().length() > 0))
    {
      this.l.setText(localUser.getNickName());
      this.l.setTextColor(getResources().getColor(2131493098));
    }
    for (;;)
    {
      this.m.setText(String.format("%s：%s", new Object[] { getString(2131101165), User.getInstance().getUserName() }));
      this.m.setTextColor(getResources().getColor(2131493098));
      d();
      return;
      this.l.setTextColor(getResources().getColor(2131493073));
      this.l.setText(2131101168);
    }
  }
  
  private void c()
  {
    if (this.i != null) {
      this.i.setOnClickListener(new aa(this));
    }
    if (User.getInstance().getLoverId() > 0)
    {
      this.n.setVisibility(0);
      this.n.setOnClickListener(new ab(this));
      b.a(this.p, User.getInstance().getLoverAvatar());
    }
    for (;;)
    {
      if (this.q != null) {
        this.q.setOnClickListener(new ac(this));
      }
      if (this.r != null) {
        this.r.setOnClickListener(new ad(this));
      }
      return;
      this.n.setVisibility(8);
    }
  }
  
  private void d()
  {
    if (ai.p()) {
      new l(new ae(this, getActivity())).d();
    }
  }
  
  private void e()
  {
    this.t.b();
    this.u.b();
    this.v.b();
    List localList = a.a().b("xiaoenai.mine");
    if ((localList != null) && (localList.size() > 0))
    {
      int i1 = 0;
      while (i1 < localList.size())
      {
        a((RedHintsInfo)localList.get(i1));
        i1 += 1;
      }
    }
  }
  
  public void a()
  {
    this.s.a();
  }
  
  public void a(int paramInt)
  {
    this.g = true;
    this.h = paramInt;
  }
  
  public void a(RedHintsInfo paramRedHintsInfo)
  {
    if (paramRedHintsInfo.getModule().equalsIgnoreCase("xiaoenai.mine.face")) {
      a.a().a(this.u, paramRedHintsInfo);
    }
    while (!paramRedHintsInfo.getModule().equalsIgnoreCase("xiaoenai.mine.setting")) {
      return;
    }
    a.a().a(this.v, paramRedHintsInfo);
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
    if (paramInt == 0) {
      if (this.s != null) {
        this.s.setVisibility(8);
      }
    }
    while ((1 != paramInt) || (this.s == null)) {
      return;
    }
    this.s.setVisibility(0);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.a = getLayoutInflater(paramBundle);
    this.c = ((RelativeLayout)this.a.inflate(2130903256, null));
    a(this.c);
    c();
    paramLayoutInflater = new RelativeLayout.LayoutParams(-1, -1);
    paramLayoutInflater.addRule(2, 2131559171);
    this.c.setLayoutParams(paramLayoutInflater);
    return this.c;
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.g)
    {
      b(this.h);
      this.g = false;
    }
    this.d.a();
    b();
    a();
    e();
    if (this.b != null) {
      this.b.b(4);
    }
    this.s.b();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\home\a\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */