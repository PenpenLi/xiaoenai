package com.xiaoenai.app.classes.home.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaoenai.app.classes.common.dialog.e;
import com.xiaoenai.app.classes.extentions.todo.q;
import com.xiaoenai.app.classes.home.a.b;
import com.xiaoenai.app.classes.home.a.c;
import com.xiaoenai.app.classes.home.mode.ModeSleepActivity;
import com.xiaoenai.app.classes.home.model.HomeBaseModel;
import com.xiaoenai.app.classes.home.view.wiget.b.b;
import com.xiaoenai.app.feature.photoalbum.view.activity.PhotoAlbumActivity;
import com.xiaoenai.app.model.ConfigCenter;
import com.xiaoenai.app.model.HomeModeSettings;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.ui.component.view.AvatarView;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.ae;
import com.xiaoenai.app.utils.ak;
import com.xiaoenai.app.utils.as;
import com.xiaoenai.app.widget.BannerView;
import com.xiaoenai.app.widget.InsideListViewPager;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import org.json.JSONObject;

public class ContentView
  extends LinearLayout
  implements b.b
{
  private static long g = 0L;
  private RelativeLayout a;
  private UserInfoView b;
  private JSONObject c = null;
  private RelativeLayout d;
  private Handler e = new Handler();
  private Timer f = new Timer();
  private int h = 60;
  private Timer i = null;
  private Button j;
  private BannerView k;
  private RelativeLayout l;
  private ImageButton m;
  private Runnable n = new a(this);
  private boolean o = false;
  private boolean p;
  private HomeBaseModel q;
  private com.xiaoenai.app.classes.home.view.wiget.b r;
  private boolean s;
  private InsideListViewPager t;
  private LinearLayout u;
  
  public ContentView(Context paramContext)
  {
    super(paramContext);
    n();
  }
  
  public ContentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    n();
  }
  
  private void a(Button paramButton)
  {
    new com.xiaoenai.app.net.l(new b(this, getContext(), paramButton)).h();
  }
  
  private void a(Button paramButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject = new ColorMatrix();
      ((ColorMatrix)localObject).setSaturation(0.0F);
      localObject = new ColorMatrixColorFilter((ColorMatrix)localObject);
      paramButton.getBackground().setColorFilter((ColorFilter)localObject);
      if (Build.VERSION.SDK_INT < 16)
      {
        paramButton.setBackgroundDrawable(paramButton.getBackground());
        return;
      }
      paramButton.setBackground(paramButton.getBackground());
      return;
    }
    Object localObject = new ColorMatrix();
    ((ColorMatrix)localObject).setSaturation(1.0F);
    localObject = new ColorMatrixColorFilter((ColorMatrix)localObject);
    paramButton.getBackground().setColorFilter((ColorFilter)localObject);
    if (Build.VERSION.SDK_INT < 16)
    {
      paramButton.setBackgroundDrawable(paramButton.getBackground());
      return;
    }
    paramButton.setBackground(paramButton.getBackground());
  }
  
  private void a(com.xiaoenai.app.classes.chat.messagelist.message.model.k paramk)
  {
    if (!l())
    {
      User.getInstance();
      if (!User.isSingle())
      {
        Object localObject = com.c.a.l.a((ImageView)this.d.findViewById(2131559435), "rotation", new float[] { 0.0F, 360.0F }).b(2000L);
        ((com.c.a.l)localObject).a(-1);
        ((com.c.a.l)localObject).a();
        ((AvatarView)this.d.findViewById(2131559434)).setRoundedImage(User.getInstance().getLoverAvatar());
        this.j = ((Button)this.d.findViewById(2131559437));
        this.j.setOnClickListener(new r(this, paramk));
        localObject = (TextView)this.d.findViewById(2131559436);
        if (this.i == null) {
          this.i = new Timer();
        }
        this.i.schedule(new s(this, paramk, (TextView)localObject), 0L, 1000L);
      }
    }
  }
  
  private void a(com.xiaoenai.app.classes.chat.messagelist.message.model.k paramk, Button paramButton)
  {
    long l2 = ak.a() - paramk.d() * 1000L;
    long l1 = l2 / 3600000L;
    l2 /= 60000L;
    if (l1 < 7L) {}
    for (paramk = getContext().getString(2131100575);; paramk = String.format(getContext().getString(2131100574), new Object[] { Long.valueOf(l1), Long.valueOf(l2 - 60L * l1) }))
    {
      new com.xiaoenai.app.ui.a.k(getContext()).a(2131101649, paramk, 2131099973, new u(this), 2131100898, new v(this, paramButton));
      return;
    }
  }
  
  private void a(Class paramClass)
  {
    paramClass = new Intent(getContext(), paramClass);
    getContext().startActivity(paramClass);
    ((Activity)getContext()).overridePendingTransition(2130968604, 2130968605);
  }
  
  private void b(int paramInt)
  {
    this.u.removeAllViews();
    if (paramInt < 2)
    {
      this.u.setVisibility(4);
      return;
    }
    this.u.setVisibility(0);
    int i1 = 0;
    while (i1 < paramInt)
    {
      ImageView localImageView = new ImageView(getContext());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(ab.a(8.0F), ab.a(8.0F));
      localLayoutParams.leftMargin = ab.a(4.0F);
      localLayoutParams.rightMargin = ab.a(4.0F);
      localImageView.setLayoutParams(localLayoutParams);
      localImageView.setImageResource(2130837782);
      localImageView.setSelected(false);
      this.u.addView(localImageView);
      i1 += 1;
    }
    this.u.getChildAt(0).setSelected(true);
  }
  
  private void n()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2130903238, this);
    this.a = ((RelativeLayout)localView.findViewById(2131559431));
    this.d = ((RelativeLayout)localView.findViewById(2131559432));
    User localUser = User.getInstance();
    if ((localUser != null) && (localUser.getLoverId() > 0))
    {
      this.b = new UserInfoView(getContext());
      this.a.addView(this.b);
    }
    this.k = ((BannerView)localView.findViewById(2131559439));
    this.l = ((RelativeLayout)localView.findViewById(2131559438));
    this.m = ((ImageButton)localView.findViewById(2131559440));
    this.t = ((InsideListViewPager)localView.findViewById(2131559442));
    this.u = ((LinearLayout)localView.findViewById(2131559441));
    this.u.setVisibility(4);
    o();
    this.i = new Timer();
    v();
  }
  
  private void o()
  {
    this.r = new com.xiaoenai.app.classes.home.view.wiget.b();
    this.t.setAdapter(this.r);
    this.r.a(this);
  }
  
  private void p()
  {
    if (HomeModeSettings.getMessage("home_mode.msg") != null)
    {
      s();
      return;
    }
    e locale = new e(getContext());
    locale.a(2131100580, 1, new l(this, locale));
    locale.show();
  }
  
  private boolean q()
  {
    boolean bool = false;
    if (User.isSingle())
    {
      as.a();
      bool = true;
    }
    return bool;
  }
  
  private void r()
  {
    new com.xiaoenai.app.net.l(new n(this, getContext())).g();
  }
  
  private void s()
  {
    Intent localIntent = new Intent(getContext(), ModeSleepActivity.class);
    getContext().startActivity(localIntent);
    ((Activity)getContext()).overridePendingTransition(2130968608, 2130968609);
  }
  
  private void setAwakeAlarmBtnStatus(boolean paramBoolean)
  {
    if (this.j == null) {
      this.j = ((Button)this.d.findViewById(2131559437));
    }
    if (paramBoolean)
    {
      this.j.setClickable(false);
      a(this.j, true);
      return;
    }
    this.j.setClickable(true);
    a(this.j, false);
    this.j.setText(2131100561);
  }
  
  private void t()
  {
    e locale = new e(getContext());
    locale.a(2131100131, 1, new o(this, locale));
    locale.show();
  }
  
  private void u()
  {
    if (this.f != null)
    {
      this.f.cancel();
      if (this.j != null)
      {
        setSendedAlarm(false);
        setAwakeAlarmBtnStatus(false);
        this.h = 60;
        if (this.n != null) {
          this.e.removeCallbacks(this.n);
        }
      }
      this.f = null;
    }
  }
  
  private void v()
  {
    long l1 = g - System.currentTimeMillis();
    if ((l1 < 0L) || (l1 >= 60000L)) {
      return;
    }
    this.h = ((int)l1 / 1000);
    if (this.f == null) {
      this.f = new Timer();
    }
    this.f.schedule(new f(this), 0L, 1000L);
    setAwakeAlarmBtnStatus(true);
  }
  
  public void a()
  {
    if (this.s) {
      return;
    }
    this.s = true;
    ArrayList localArrayList = new ArrayList();
    this.q = new HomeBaseModel(2130838547, 2131100580);
    HomeBaseModel localHomeBaseModel1 = new HomeBaseModel(2130838507, 2131100131);
    HomeBaseModel localHomeBaseModel2 = new HomeBaseModel(2130838518, 2131100855);
    HomeBaseModel localHomeBaseModel3 = new HomeBaseModel(2130838502, 2131099739);
    HomeBaseModel localHomeBaseModel4 = new HomeBaseModel(2130838503, 2131099918);
    HomeBaseModel localHomeBaseModel5 = new HomeBaseModel(2130838565, 2131101536);
    localArrayList.add(this.q);
    localArrayList.add(localHomeBaseModel1);
    localArrayList.add(localHomeBaseModel3);
    localArrayList.add(localHomeBaseModel4);
    localArrayList.add(localHomeBaseModel5);
    localArrayList.add(2, localHomeBaseModel2);
    if (localArrayList.size() % 6 == 0) {}
    for (int i1 = localArrayList.size() / 6;; i1 = localArrayList.size() / 6 + 1)
    {
      this.t.setOnPageChangeListener(new k(this, i1));
      this.r.a(localArrayList);
      b(i1);
      return;
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.b = new UserInfoView(getContext());
      this.a.addView(this.b);
    }
    for (;;)
    {
      this.a.invalidate();
      this.a.requestLayout();
      f();
      return;
      if (paramInt == 1)
      {
        UserConfig.remove("home_search_lover_avatar");
        UserConfig.remove("home_search_lover_email");
      }
      if (this.b != null) {
        this.a.removeView(this.b);
      }
    }
  }
  
  public void a(View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    a.b localb = com.xiaoenai.app.classes.home.a.a().a("index");
    if (localb != null)
    {
      if (localb.a())
      {
        this.l.setVisibility(0);
        ViewGroup.LayoutParams localLayoutParams = this.k.getLayoutParams();
        localLayoutParams.height = localb.a(localb.f[0].b, localb.f[0].a);
        this.k.setLayoutParams(localLayoutParams);
        com.xiaoenai.app.utils.e.b.a(this.k, localb.f[0].c);
        this.l.setOnClickListener(paramOnClickListener1);
        this.m.setOnClickListener(paramOnClickListener2);
      }
    }
    else {
      return;
    }
    this.l.setVisibility(8);
  }
  
  public void a(View paramView, HomeBaseModel paramHomeBaseModel)
  {
    if ((q()) || (!this.p)) {}
    do
    {
      return;
      switch (paramHomeBaseModel.getResId())
      {
      default: 
        return;
      case 2130838502: 
        a(PhotoAlbumActivity.class);
        return;
      case 2130838547: 
      case 2130838549: 
        p();
        return;
      case 2130838507: 
        if (as.g(getContext(), "android.permission.ACCESS_FINE_LOCATION"))
        {
          t();
          return;
        }
        paramView = ConfigCenter.getHelpPage();
      }
    } while (ae.a(paramView));
    paramHomeBaseModel = new com.xiaoenai.app.ui.a.k(getContext());
    paramHomeBaseModel.d(com.xiaoenai.app.ui.a.k.i);
    paramHomeBaseModel.a(2131100127, 2131100054, new i(this), 2131099685, new j(this, paramView));
    return;
    com.xiaoenai.app.classes.extentions.menses.a.a((FragmentActivity)getContext());
    return;
    com.xiaoenai.app.classes.extentions.anniversary.a.a((FragmentActivity)getContext());
    return;
    q.a((FragmentActivity)getContext());
  }
  
  public void b()
  {
    this.p = true;
  }
  
  public void c()
  {
    this.p = false;
  }
  
  public void d()
  {
    if (HomeModeSettings.getMessage("home_mode.msg") != null)
    {
      User.getInstance();
      if (!User.isSingle())
      {
        this.q.setResId(2130838549);
        this.q.setStringId(2131100586);
      }
    }
    for (;;)
    {
      this.r.notifyDataSetChanged();
      return;
      this.q.setResId(2130838547);
      this.q.setStringId(2131100580);
    }
  }
  
  public void e()
  {
    this.l.setVisibility(8);
  }
  
  public void f() {}
  
  public void g()
  {
    if (this.b != null) {
      this.b.a();
    }
  }
  
  public void h()
  {
    if (this.b != null) {
      this.b.b();
    }
  }
  
  public boolean i()
  {
    if (this.d != null)
    {
      User.getInstance();
      if (!User.isSingle())
      {
        com.xiaoenai.app.classes.chat.messagelist.message.a.a locala = HomeModeSettings.getMessage("home_lover_mode.msg");
        if (locala == null) {
          break label46;
        }
        this.d.setVisibility(0);
        a((com.xiaoenai.app.classes.chat.messagelist.message.model.k)locala);
      }
    }
    return false;
    label46:
    this.d.setVisibility(8);
    if (this.i != null)
    {
      this.i.cancel();
      this.i = null;
    }
    u();
    return false;
  }
  
  public void j()
  {
    if (this.b != null)
    {
      this.b.c();
      this.a.removeView(this.b);
    }
    if (this.i != null)
    {
      this.i.cancel();
      this.i = null;
    }
    if ((this.f != null) && (this.h < 60)) {}
    for (g = System.currentTimeMillis() + this.h * 1000;; g = 0L)
    {
      u();
      return;
    }
  }
  
  public void k()
  {
    d();
  }
  
  public boolean l()
  {
    try
    {
      boolean bool = this.o;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void m()
  {
    if (User.isSingle())
    {
      HomeModeSettings.removeMessage("home_mode.msg");
      if (this.d != null) {
        this.d = ((RelativeLayout)findViewById(2131559432));
      }
      if (this.f != null)
      {
        this.f.cancel();
        this.f = null;
      }
      if (this.i != null)
      {
        this.i.cancel();
        this.i = null;
      }
      if (this.d != null) {
        this.d.setVisibility(8);
      }
      d();
    }
  }
  
  public void setSendedAlarm(boolean paramBoolean)
  {
    try
    {
      this.o = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void setTopBarViewClickEnalbe(Boolean paramBoolean) {}
  
  public void setUserModeChangeListener(UserInfoView.a parama)
  {
    if (this.b != null) {
      this.b.setUserModeChangeListener(parama);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\home\view\ContentView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */