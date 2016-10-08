package com.xiaoenai.app.feature.photoalbum.view.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaoenai.app.feature.photoalbum.a.c;
import com.xiaoenai.app.feature.photoalbum.a.d;
import com.xiaoenai.app.feature.photoalbum.a.e;

public class ToggleButton
  extends LinearLayout
{
  private RelativeLayout a;
  private RelativeLayout b;
  private TextView c;
  private TextView d;
  private ImageView e;
  private ImageView f;
  private String g = "left";
  private a h;
  private View.OnClickListener i = new g(this);
  private View.OnClickListener j = new h(this);
  
  public ToggleButton(Context paramContext)
  {
    super(paramContext);
    LinearLayout.inflate(paramContext, a.e.view_toggle_button, this);
    a();
  }
  
  public ToggleButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LinearLayout.inflate(paramContext, a.e.view_toggle_button, this);
    a();
  }
  
  @TargetApi(11)
  public ToggleButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LinearLayout.inflate(paramContext, a.e.view_toggle_button, this);
    a();
  }
  
  @TargetApi(21)
  public ToggleButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    LinearLayout.inflate(paramContext, a.e.view_toggle_button, this);
    a();
  }
  
  private void a()
  {
    this.a = ((RelativeLayout)findViewById(a.d.view_left));
    this.b = ((RelativeLayout)findViewById(a.d.view_right));
    this.c = ((TextView)findViewById(a.d.tv_left));
    this.d = ((TextView)findViewById(a.d.tv_right));
    this.e = ((ImageView)findViewById(a.d.iv_left));
    this.f = ((ImageView)findViewById(a.d.iv_right));
    this.a.setOnClickListener(this.i);
    this.b.setOnClickListener(this.j);
    this.c.setSelected(true);
    this.e.setSelected(true);
    this.d.setSelected(false);
    this.f.setSelected(false);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.e.setImageResource(paramInt1);
    this.f.setImageResource(paramInt2);
  }
  
  public void setOnToggleListener(a parama)
  {
    this.h = parama;
  }
  
  public void setStatus(String paramString)
  {
    if ("left".equals(paramString))
    {
      paramString = getContext().getResources().getDrawable(a.c.toggle_left_pressed);
      localDrawable = getContext().getResources().getDrawable(a.c.toggle_right_normal);
      this.a.setBackgroundDrawable(paramString);
      this.b.setBackgroundDrawable(localDrawable);
      this.c.setSelected(true);
      this.e.setSelected(true);
      this.d.setSelected(false);
      this.f.setSelected(false);
      this.g = "left";
    }
    while (!"right".equals(paramString)) {
      return;
    }
    paramString = getContext().getResources().getDrawable(a.c.toggle_left_normal);
    Drawable localDrawable = getContext().getResources().getDrawable(a.c.toggle_right_pressed);
    this.a.setBackgroundDrawable(paramString);
    this.b.setBackgroundDrawable(localDrawable);
    this.c.setSelected(false);
    this.e.setSelected(false);
    this.d.setSelected(true);
    this.f.setSelected(true);
    this.g = "right";
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void b();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\feature\photoalbum\view\widget\ToggleButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */