package com.xiaoenai.app.classes.chat.messagelist.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.xiaoenai.app.classes.chat.messagelist.message.model.o;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.h.g;

public class p
  extends BaseItemView
  implements View.OnClickListener
{
  private View b;
  private TextView c;
  private View d;
  private ProgressBar e;
  private ImageView f;
  private int g = 0;
  private int h = 0;
  private ImageView i;
  private o j = null;
  private View.OnClickListener k = null;
  
  public p(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(o paramo)
  {
    if (paramo == null) {
      return;
    }
    switch (paramo.r())
    {
    default: 
      f();
      return;
    case 0: 
      f();
      return;
    case 1: 
      e();
      return;
    case 2: 
      f();
      return;
    case 3: 
      g();
      return;
    case 4: 
      com.xiaoenai.app.classes.chat.messagelist.message.a.a locala = g.a().b();
      if ((locala != null) && (paramo.h() == locala.h()))
      {
        d();
        return;
      }
      f();
      return;
    case 5: 
      f();
      return;
    case 6: 
      f();
      return;
    }
    g();
  }
  
  private void c()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
    localLayoutParams.width = (this.g + (int)((this.h - this.g) * this.j.w().intValue() * 1.0F / 60.0F));
    this.b.setLayoutParams(localLayoutParams);
    this.c.setText(String.valueOf(this.j.w()) + "''");
  }
  
  private void d()
  {
    c();
    this.mIvVoiceLoadError.setVisibility(8);
    this.f.setVisibility(4);
    this.e.setVisibility(0);
  }
  
  private void e()
  {
    c();
    this.mIvVoiceLoadError.setVisibility(8);
    this.f.setVisibility(4);
    this.e.setVisibility(0);
  }
  
  private void f()
  {
    c();
    this.mIvVoiceLoadError.setVisibility(8);
    this.e.setVisibility(4);
    this.f.setVisibility(0);
  }
  
  private void g()
  {
    this.e.setVisibility(4);
    this.f.setVisibility(0);
    this.mIvVoiceLoadError.setVisibility(0);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
    localLayoutParams.width = ab.a(110.0F);
    this.b.setLayoutParams(localLayoutParams);
    this.c.setText(2131100037);
  }
  
  private void h()
  {
    this.mIvVoiceLoadError.setOnClickListener(this);
    this.mRlVoiceStatus.setOnClickListener(this);
  }
  
  public void b()
  {
    c();
    a(this.j);
  }
  
  public View getMsgContentView()
  {
    this.b = inflate(getContext(), 2130903118, null);
    this.c = ((TextView)this.b.findViewById(2131558861));
    this.e = ((ProgressBar)this.b.findViewById(2131558860));
    this.d = this.b.findViewById(2131558704);
    this.i = ((ImageView)this.b.findViewById(2131558858));
    this.f = ((ImageView)this.b.findViewById(2131558859));
    h();
    return this.b;
  }
  
  public void onClick(View paramView)
  {
    com.xiaoenai.app.utils.f.a.c("length {}", new Object[] { this.j.w() });
    com.xiaoenai.app.utils.f.a.c("path {}", new Object[] { this.j.u() });
    if (this.k != null)
    {
      paramView.setTag(2131558412, this.j);
      this.k.onClick(paramView);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  public void setImageResource(int paramInt)
  {
    this.e.setVisibility(8);
    this.c.setVisibility(8);
    this.d.setVisibility(8);
    this.i.setVisibility(0);
    this.i.setImageResource(paramInt);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    super.setOnClickListener(this);
    this.k = paramOnClickListener;
  }
  
  public void setStatus(int paramInt)
  {
    if (paramInt == 0) {
      if (this.a == 2) {
        if ((this.j != null) && (!this.j.p()))
        {
          this.mVoiceUnread.setVisibility(0);
          com.xiaoenai.app.utils.f.a.c("mVoiceMessage = {}", new Object[] { this.j });
        }
      }
    }
    for (;;)
    {
      super.setStatus(paramInt);
      if (this.a == 2) {
        break label162;
      }
      if ((this.mTvMessageStatus.getVisibility() == 8) && (this.mIvStatusFailed.getVisibility() == 0))
      {
        localLayoutParams = (RelativeLayout.LayoutParams)this.mRlVoiceStatus.getLayoutParams();
        localLayoutParams.addRule(1, -1);
        localLayoutParams.addRule(0, this.mRlStatus.getId());
        this.mRlVoiceStatus.setLayoutParams(localLayoutParams);
      }
      return;
      this.mVoiceUnread.setVisibility(8);
      break;
      this.mVoiceUnread.setVisibility(8);
      continue;
      this.mVoiceUnread.setVisibility(8);
    }
    label162:
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.mRlVoiceStatus.getLayoutParams();
    if (this.mVoiceUnread.getVisibility() == 0)
    {
      localLayoutParams.addRule(1, this.mVoiceUnread.getId());
      localLayoutParams.addRule(0, -1);
      localLayoutParams.setMargins(ab.a(3.0F), 0, 0, 0);
      this.mRlVoiceStatus.setPadding(0, 0, ab.a(3.0F), 0);
    }
    for (;;)
    {
      this.mRlVoiceStatus.setLayoutParams(localLayoutParams);
      return;
      localLayoutParams.addRule(1, this.mMessageBody.getId());
      localLayoutParams.addRule(0, -1);
      this.mRlVoiceStatus.setPadding(ab.a(7.0F), 0, ab.a(3.0F), 0);
    }
  }
  
  public void setUserType(int paramInt)
  {
    super.setUserType(paramInt);
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.d.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
    if (paramInt == 2)
    {
      this.e.setIndeterminateDrawable(getResources().getDrawable(2130837607));
      this.f.setImageResource(2130837704);
      localLayoutParams2.addRule(11, -1);
      localLayoutParams2.addRule(9, 0);
      localLayoutParams1.addRule(9, -1);
      localLayoutParams1.addRule(11, 0);
    }
    for (;;)
    {
      this.d.setLayoutParams(localLayoutParams1);
      this.c.setLayoutParams(localLayoutParams2);
      return;
      this.e.setIndeterminateDrawable(getResources().getDrawable(2130837608));
      this.f.setImageResource(2130837707);
      localLayoutParams2.addRule(9, -1);
      localLayoutParams2.addRule(11, 0);
      localLayoutParams1.addRule(11, -1);
      localLayoutParams1.addRule(9, 0);
    }
  }
  
  public void setVoiceMessage(o paramo)
  {
    this.j = paramo;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\messagelist\view\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */