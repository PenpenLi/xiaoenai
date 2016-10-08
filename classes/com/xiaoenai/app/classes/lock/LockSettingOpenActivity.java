package com.xiaoenai.app.classes.lock;

import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.model.UserConfig;

public class LockSettingOpenActivity
  extends TitleBarActivity
{
  private ImageView a = null;
  private ImageView b = null;
  private ImageView c = null;
  private ImageView i = null;
  private LinearLayout j = null;
  private int k = 0;
  private TextView l = null;
  private TextView m = null;
  private StringBuffer n = new StringBuffer();
  private StringBuffer o = new StringBuffer();
  private boolean s = true;
  private boolean t = false;
  private View.OnClickListener u = new j(this);
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.t) {}
    for (;;)
    {
      return;
      if (this.a.getDrawable() == null)
      {
        this.m.setTextColor(-7829368);
        this.m.setText(2131100640);
        this.a.setImageResource(paramInt1);
        if (!this.s) {
          break label240;
        }
        if (this.n.length() < 4) {
          this.n.append(paramInt2);
        }
      }
      for (;;)
      {
        if ((this.n.length() == 4) && (this.o.length() == 4))
        {
          if (this.n.toString().equals(this.o.toString()))
          {
            UserConfig.setStringWithEncypt("lock_password_v2", this.n.toString());
            this.n.delete(0, this.n.length());
            this.o.delete(0, this.o.length());
            Xiaoenai.j().a(false);
            finish();
            overridePendingTransition(2130968606, 2130968607);
            return;
            if (this.b.getDrawable() == null)
            {
              this.b.setImageResource(paramInt1);
              break;
            }
            if (this.c.getDrawable() == null)
            {
              this.c.setImageResource(paramInt1);
              break;
            }
            if (this.i.getDrawable() != null) {
              break;
            }
            this.i.setImageResource(paramInt1);
            break;
            label240:
            if (this.o.length() >= 4) {
              continue;
            }
            this.o.append(paramInt2);
            continue;
          }
          this.m.setTextColor(-65536);
          this.m.setText(2131100639);
          this.n.delete(0, this.n.length());
          this.o.delete(0, this.o.length());
          this.s = true;
          this.l.setText(2131100637);
        }
      }
      for (paramInt1 = 1; (this.a.getDrawable() != null) && (this.b.getDrawable() != null) && (this.c.getDrawable() != null) && (this.i.getDrawable() != null); paramInt1 = 0)
      {
        this.t = true;
        if (paramInt1 == 0)
        {
          this.l.setText(2131100638);
          if (this.n.length() == 4) {
            this.s = false;
          }
        }
        new Handler().postDelayed(new k(this), 500L);
        return;
      }
    }
  }
  
  private void c()
  {
    this.l = ((TextView)findViewById(2131559604));
    this.l.setText(2131100637);
    this.m = ((TextView)findViewById(2131559605));
    this.a = ((ImageView)findViewById(2131559599));
    this.b = ((ImageView)findViewById(2131559600));
    this.c = ((ImageView)findViewById(2131559601));
    this.i = ((ImageView)findViewById(2131559602));
    this.j = ((LinearLayout)findViewById(2131559606));
    Object localObject = getLayoutInflater().inflate(2130903271, null);
    ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    this.k = ((View)localObject).getMeasuredHeight();
    localObject = (RelativeLayout.LayoutParams)this.j.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = (-this.k);
    this.j.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void d()
  {
    this.j.findViewById(2131559586).setOnClickListener(this.u);
    this.j.findViewById(2131559587).setOnClickListener(this.u);
    this.j.findViewById(2131559588).setOnClickListener(this.u);
    this.j.findViewById(2131559589).setOnClickListener(this.u);
    this.j.findViewById(2131559590).setOnClickListener(this.u);
    this.j.findViewById(2131559591).setOnClickListener(this.u);
    this.j.findViewById(2131559592).setOnClickListener(this.u);
    this.j.findViewById(2131559593).setOnClickListener(this.u);
    this.j.findViewById(2131559594).setOnClickListener(this.u);
    this.j.findViewById(2131559596).setOnClickListener(this.u);
    this.j.findViewById(2131559597).setOnClickListener(this.u);
  }
  
  private void f()
  {
    if (this.i.getDrawable() != null)
    {
      this.i.setImageResource(0);
      if (!this.s) {
        break label116;
      }
      if (this.n.length() > 0) {
        this.n.deleteCharAt(this.n.length() - 1);
      }
    }
    label116:
    while (this.o.length() <= 0)
    {
      return;
      if (this.c.getDrawable() != null)
      {
        this.c.setImageResource(0);
        break;
      }
      if (this.b.getDrawable() != null)
      {
        this.b.setImageResource(0);
        break;
      }
      if (this.a.getDrawable() == null) {
        break;
      }
      this.a.setImageResource(0);
      break;
    }
    this.o.deleteCharAt(this.o.length() - 1);
  }
  
  private void g()
  {
    AnimationSet localAnimationSet = new AnimationSet(true);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.j.getMeasuredHeight());
    localTranslateAnimation.setDuration(250L);
    localTranslateAnimation.setAnimationListener(new l(this));
    localAnimationSet.addAnimation(localTranslateAnimation);
    this.j.startAnimation(localAnimationSet);
  }
  
  public int a()
  {
    return 2130903270;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    c();
    d();
    g();
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
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\lock\LockSettingOpenActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */