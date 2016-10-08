package com.xiaoenai.app.classes.lock;

import android.os.Bundle;
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

public class LockSettingCloseActivity
  extends TitleBarActivity
{
  public int a = 0;
  private ImageView b = null;
  private ImageView c = null;
  private ImageView i = null;
  private ImageView j = null;
  private LinearLayout k = null;
  private TextView l = null;
  private StringBuffer m = new StringBuffer();
  private String n = null;
  private View.OnClickListener o = new f(this);
  
  private void a(int paramInt)
  {
    if (paramInt > 2)
    {
      com.xiaoenai.app.ui.a.g localg = new com.xiaoenai.app.ui.a.g(this);
      localg.a(2131100626);
      localg.a(2131100898, new g(this));
      localg.b(2131099973, new h(this));
      localg.show();
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.b.getDrawable() == null)
    {
      this.b.setImageResource(paramInt1);
      this.m.append(paramInt2);
      if (this.m.length() != 4) {
        break label168;
      }
      if (!this.m.toString().equals(this.n)) {
        break label135;
      }
      UserConfig.remove("lock_password_v2");
      Xiaoenai.j().a(false);
      finish();
    }
    label135:
    label168:
    while ((this.b.getDrawable() == null) || (this.c.getDrawable() == null) || (this.i.getDrawable() == null) || (this.j.getDrawable() == null))
    {
      return;
      if (this.c.getDrawable() == null)
      {
        this.c.setImageResource(paramInt1);
        break;
      }
      if (this.i.getDrawable() == null)
      {
        this.i.setImageResource(paramInt1);
        break;
      }
      if (this.j.getDrawable() != null) {
        break;
      }
      this.j.setImageResource(paramInt1);
      break;
      this.m.delete(0, this.m.length());
      paramInt1 = this.a + 1;
      this.a = paramInt1;
      a(paramInt1);
    }
    this.l.setText(2131100634);
    this.j.setImageResource(0);
    this.i.setImageResource(0);
    this.c.setImageResource(0);
    this.b.setImageResource(0);
  }
  
  private void c()
  {
    this.n = UserConfig.getStringWithDecypt("lock_password_v2");
    this.l = ((TextView)findViewById(2131559603));
    this.b = ((ImageView)findViewById(2131559599));
    this.c = ((ImageView)findViewById(2131559600));
    this.i = ((ImageView)findViewById(2131559601));
    this.j = ((ImageView)findViewById(2131559602));
    this.k = ((LinearLayout)findViewById(2131559606));
    Object localObject = getLayoutInflater().inflate(2130903271, null);
    ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    int i1 = ((View)localObject).getMeasuredHeight();
    localObject = (RelativeLayout.LayoutParams)this.k.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = (-i1);
    this.k.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void d()
  {
    this.k.findViewById(2131559586).setOnClickListener(this.o);
    this.k.findViewById(2131559587).setOnClickListener(this.o);
    this.k.findViewById(2131559588).setOnClickListener(this.o);
    this.k.findViewById(2131559589).setOnClickListener(this.o);
    this.k.findViewById(2131559590).setOnClickListener(this.o);
    this.k.findViewById(2131559591).setOnClickListener(this.o);
    this.k.findViewById(2131559592).setOnClickListener(this.o);
    this.k.findViewById(2131559593).setOnClickListener(this.o);
    this.k.findViewById(2131559594).setOnClickListener(this.o);
    this.k.findViewById(2131559596).setOnClickListener(this.o);
    this.k.findViewById(2131559597).setOnClickListener(this.o);
  }
  
  private void f()
  {
    if (this.j.getDrawable() != null) {
      this.j.setImageResource(0);
    }
    for (;;)
    {
      if (this.m.length() != 0) {
        this.m.deleteCharAt(this.m.length() - 1);
      }
      return;
      if (this.i.getDrawable() != null) {
        this.i.setImageResource(0);
      } else if (this.c.getDrawable() != null) {
        this.c.setImageResource(0);
      } else if (this.b.getDrawable() != null) {
        this.b.setImageResource(0);
      }
    }
  }
  
  private void g()
  {
    AnimationSet localAnimationSet = new AnimationSet(true);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.k.getMeasuredHeight());
    localTranslateAnimation.setDuration(250L);
    localTranslateAnimation.setAnimationListener(new i(this));
    localAnimationSet.addAnimation(localTranslateAnimation);
    this.k.startAnimation(localAnimationSet);
  }
  
  public int a()
  {
    return 2130903269;
  }
  
  public void onCreate(Bundle paramBundle)
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


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\lock\LockSettingCloseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */