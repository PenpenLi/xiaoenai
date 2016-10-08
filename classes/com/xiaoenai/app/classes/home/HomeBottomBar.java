package com.xiaoenai.app.classes.home;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaoenai.app.widget.remindButton.RemindButton;

public class HomeBottomBar
  extends RelativeLayout
{
  private TextView a;
  private TextView b;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView[] f;
  private ImageView[] g;
  private int h = 0;
  private ImageView i;
  private TextView j;
  private RemindButton k;
  private RemindButton l;
  private ImageView m;
  private ImageView n;
  private ImageView o;
  private ImageView p;
  private ImageView q;
  private RemindButton r;
  private ImageView s;
  private a t;
  
  public HomeBottomBar(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public HomeBottomBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    View localView1 = LayoutInflater.from(getContext()).inflate(2130903236, this, true);
    this.a = ((TextView)localView1.findViewById(2131559382));
    this.m = ((ImageView)localView1.findViewById(2131559381));
    localView1.findViewById(2131559380).setOnClickListener(new q(this, "home"));
    this.b = ((TextView)localView1.findViewById(2131559386));
    this.n = ((ImageView)localView1.findViewById(2131559385));
    this.l = ((RemindButton)findViewById(2131559387));
    View localView2 = localView1.findViewById(2131559383);
    localView2.setVisibility(0);
    localView2.setOnClickListener(new r(this, "discover"));
    this.c = ((TextView)localView1.findViewById(2131559392));
    localView2 = localView1.findViewById(2131559388);
    this.i = ((ImageView)localView1.findViewById(2131559390));
    this.j = ((TextView)localView1.findViewById(2131559391));
    localView2.setOnClickListener(new s(this));
    this.d = ((TextView)localView1.findViewById(2131559396));
    localView2 = localView1.findViewById(2131559393);
    this.p = ((ImageView)localView1.findViewById(2131559395));
    this.r = ((RemindButton)localView1.findViewById(2131559397));
    localView2.setOnClickListener(new t(this, "notification"));
    this.e = ((TextView)localView1.findViewById(2131559401));
    this.q = ((ImageView)localView1.findViewById(2131559400));
    localView1 = localView1.findViewById(2131559398);
    this.k = ((RemindButton)findViewById(2131559402));
    localView1.setOnClickListener(new u(this, "setting"));
    this.f = new TextView[5];
    this.f[0] = this.a;
    this.f[1] = this.b;
    this.f[2] = this.c;
    this.f[3] = this.d;
    this.f[4] = this.e;
    this.g = new ImageView[5];
    this.g[0] = this.m;
    this.g[1] = this.n;
    this.g[2] = this.o;
    this.g[3] = this.p;
    this.g[4] = this.q;
    this.f[0].setTextColor(-16744196);
    this.m.setSelected(true);
    this.s = this.m;
  }
  
  private void a(int paramInt, boolean paramBoolean, RemindButton paramRemindButton)
  {
    if (paramRemindButton != null)
    {
      if (!paramBoolean) {
        break label23;
      }
      if (paramInt > 0) {
        paramRemindButton.a(paramInt);
      }
    }
    else
    {
      return;
    }
    paramRemindButton.a();
    return;
    label23:
    paramRemindButton.b();
  }
  
  private int getHeartResId()
  {
    return 2130838551;
  }
  
  public void a(int paramInt)
  {
    if ((this.h != 2) && (paramInt == this.h)) {}
    do
    {
      do
      {
        return;
        this.h = paramInt;
        if (paramInt != 2) {
          break;
        }
        setNewRemindNum(0);
      } while (this.t == null);
      this.t.a(paramInt);
      return;
      int i1 = 0;
      if (i1 < this.f.length)
      {
        if (paramInt == i1) {
          this.f[i1].setTextColor(-16744196);
        }
        for (;;)
        {
          i1 += 1;
          break;
          this.f[i1].setTextColor(-7171438);
        }
      }
      if (this.s != null) {
        this.s.setSelected(false);
      }
      if (this.g[paramInt] != null)
      {
        this.g[paramInt].setSelected(true);
        this.s = this.g[paramInt];
      }
    } while (this.t == null);
    this.t.a(paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    a(paramInt, paramBoolean, this.k);
  }
  
  public void b(int paramInt)
  {
    if (this.r != null)
    {
      if (paramInt > 0) {
        this.r.a(paramInt);
      }
    }
    else {
      return;
    }
    this.r.b();
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    a(paramInt, paramBoolean, this.l);
  }
  
  public int getCurrentTab()
  {
    return this.h;
  }
  
  public void setCurrentTab(int paramInt)
  {
    if (paramInt == this.h) {}
    do
    {
      return;
      this.h = paramInt;
      int i1 = 0;
      if (i1 < this.f.length)
      {
        if (paramInt == i1) {
          this.f[i1].setTextColor(-16744196);
        }
        for (;;)
        {
          i1 += 1;
          break;
          this.f[i1].setTextColor(-7171438);
        }
      }
      if (this.s != null) {
        this.s.setSelected(false);
      }
    } while (this.g[paramInt] == null);
    this.g[paramInt].setSelected(true);
    this.s = this.g[paramInt];
  }
  
  public void setNewRemindNum(int paramInt)
  {
    if (paramInt != 0)
    {
      this.i.setImageResource(getHeartResId());
      this.j.setText(String.valueOf(paramInt));
      return;
    }
    this.i.setImageResource(2130838550);
    this.j.setText("");
  }
  
  public void setOnTabSelectedListener(a parama)
  {
    this.t = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\home\HomeBottomBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */