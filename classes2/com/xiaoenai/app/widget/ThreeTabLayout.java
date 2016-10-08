package com.xiaoenai.app.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.utils.f.a;
import com.xiaoenai.app.utils.k;

public class ThreeTabLayout
  extends LinearLayout
{
  Drawable a;
  Drawable b;
  Drawable c;
  private Button d;
  private Button e;
  private Button f;
  private int g = 0;
  private int h = 2131296397;
  private int i = 0;
  private a j;
  
  public ThreeTabLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private Drawable a(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(View.PRESSED_SELECTED_STATE_SET, paramDrawable1);
    localStateListDrawable.addState(View.SELECTED_STATE_SET, paramDrawable1);
    localStateListDrawable.addState(View.EMPTY_STATE_SET, paramDrawable2);
    return localStateListDrawable;
  }
  
  private void a()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2130903133, this, false);
    addView(localView);
    setPadding(0, 0, 0, 0);
    this.d = ((Button)localView.findViewById(2131558912));
    this.d.setSelected(true);
    this.d.setOnClickListener(new r(this));
    this.e = ((Button)localView.findViewById(2131558913));
    this.e.setOnClickListener(new s(this));
    this.f = ((Button)localView.findViewById(2131558914));
    this.f.setOnClickListener(new t(this));
    b(this.d, this.e, this.f);
    a(this.d, this.e, this.f);
  }
  
  private void a(Button paramButton1, Button paramButton2, Button paramButton3)
  {
    if (this.h == 2131296398)
    {
      paramButton1.setTextColor(getResources().getColor(2131492974));
      paramButton2.setTextColor(getResources().getColor(2131492956));
      paramButton3.setTextColor(getResources().getColor(2131492956));
      return;
    }
    paramButton1.setTextColor(UserConfig.getInt("chat_title_color", Integer.valueOf(-1864528)).intValue());
    paramButton2.setTextColor(-1);
    paramButton3.setTextColor(-1);
  }
  
  private void b()
  {
    k.a(getResources().getDrawable(2130837812), getResources().getColor(2131492956));
    k.a(getResources().getDrawable(2130837809), getResources().getColor(2131492956));
    this.a = a(getResources().getDrawable(2130837813), getResources().getDrawable(2130837810));
    k.a(getResources().getDrawable(2130837806), getResources().getColor(2131492956));
    k.a(getResources().getDrawable(2130837803), getResources().getColor(2131492956));
    this.c = a(getResources().getDrawable(2130837807), getResources().getDrawable(2130837804));
    k.a(getResources().getDrawable(2130837818), getResources().getColor(2131492956));
    k.a(getResources().getDrawable(2130837815), getResources().getColor(2131492956));
    this.b = a(getResources().getDrawable(2130837819), getResources().getDrawable(2130837816));
  }
  
  private void b(Button paramButton1, Button paramButton2, Button paramButton3)
  {
    if (UserConfig.getBoolean("forum_night_theme", Boolean.valueOf(false)).booleanValue())
    {
      a.c("theme  AppTheme_Night", new Object[0]);
      b();
      paramButton1.setBackgroundDrawable(this.a);
      paramButton2.setBackgroundDrawable(this.c);
      paramButton3.setBackgroundDrawable(this.b);
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt == this.i) {}
    for (;;)
    {
      return;
      this.i = paramInt;
      if (paramInt == 0)
      {
        this.d.setSelected(true);
        this.d.requestFocus();
        this.f.setSelected(false);
        this.f.clearFocus();
        this.e.setSelected(false);
        this.e.clearFocus();
        a(this.d, this.e, this.f);
      }
      while (this.j != null)
      {
        this.j.a(this.i);
        return;
        if (paramInt == 1)
        {
          this.d.setSelected(false);
          this.d.clearFocus();
          this.f.setSelected(false);
          this.f.clearFocus();
          this.e.setSelected(true);
          this.e.requestFocus();
          a(this.e, this.d, this.f);
        }
        else
        {
          this.d.setSelected(false);
          this.d.clearFocus();
          this.f.setSelected(true);
          this.f.requestFocus();
          this.e.setSelected(false);
          this.e.clearFocus();
          a(this.f, this.e, this.d);
        }
      }
    }
  }
  
  public int getCurTab()
  {
    return this.i;
  }
  
  public int getCurrentTabId()
  {
    return this.g;
  }
  
  public a getOnTabChangeListener()
  {
    return this.j;
  }
  
  public void setBackground(int paramInt)
  {
    findViewById(2131558788).setBackgroundColor(paramInt);
  }
  
  public void setLeftTabString(String paramString)
  {
    this.d.setText(paramString);
  }
  
  public void setMidTabString(String paramString)
  {
    this.e.setText(paramString);
  }
  
  public void setOnTabChangeListener(a parama)
  {
    this.j = parama;
  }
  
  public void setRightTabString(String paramString)
  {
    this.f.setText(paramString);
  }
  
  public void setTheme(int paramInt)
  {
    this.h = paramInt;
    a(this.d, this.e, this.f);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\widget\ThreeTabLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */