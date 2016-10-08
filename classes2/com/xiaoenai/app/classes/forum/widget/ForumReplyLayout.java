package com.xiaoenai.app.classes.forum.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.utils.k;
import com.xiaoenai.app.widget.swipeLayout.SwipeLayout;
import com.xiaoenai.app.widget.swipeLayout.SwipeLayout.b;
import com.xiaoenai.app.widget.swipeLayout.SwipeLayout.e;

public class ForumReplyLayout
  extends LinearLayout
{
  private a a;
  
  public ForumReplyLayout(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ForumReplyLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.a = new a();
    this.a.a = ((SwipeLayout)LayoutInflater.from(paramContext).inflate(2130903213, null));
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    addView(this.a.a, paramContext);
    this.a.a.a(new f(this));
    this.a.a.setShowMode(SwipeLayout.e.b);
    this.a.a.setDragEdge(SwipeLayout.b.b);
    setOnClickListener(new g(this));
    this.a.b = ((ImageView)this.a.a.findViewById(2131559291));
    this.a.c = ((TextView)this.a.a.findViewById(2131559292));
    this.a.d = ((TextView)this.a.a.findViewById(2131559293));
    this.a.e = ((ImageView)this.a.a.findViewById(2131559294));
    this.a.f = ((TextView)this.a.a.findViewById(2131559295));
    this.a.g = ((TextView)this.a.a.findViewById(2131559296));
    this.a.h = ((TextView)this.a.a.findViewById(2131559297));
    this.a.i = ((LinearLayout)this.a.a.findViewById(2131559283));
    this.a.o = this.a.a.findViewById(2131559282);
    this.a.j = ((LinearLayout)this.a.a.findViewById(2131559286));
    this.a.p = this.a.a.findViewById(2131559285);
    this.a.k = ((LinearLayout)this.a.a.findViewById(2131559289));
    this.a.q = this.a.a.findViewById(2131559288);
    this.a.l = ((ImageView)this.a.a.findViewById(2131559284));
    this.a.m = ((ImageView)this.a.a.findViewById(2131559287));
    this.a.n = ((ImageView)this.a.a.findViewById(2131559290));
    this.a.r = this.a.a.findViewById(2131559281);
    setNightThemeBtnStyle(UserConfig.getBoolean("forum_night_theme", Boolean.valueOf(false)).booleanValue());
  }
  
  public a getViewHolder()
  {
    return this.a;
  }
  
  public void setNightThemeBtnStyle(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Drawable localDrawable1 = k.a(getResources().getDrawable(2130838865), getResources().getColor(2131492947));
      Drawable localDrawable2 = k.a(getResources().getDrawable(2130838866), getResources().getColor(2131492947));
      Drawable localDrawable3 = k.a(getResources().getDrawable(2130838853), getResources().getColor(2131492947));
      this.a.l.setImageDrawable(localDrawable1);
      this.a.m.setImageDrawable(localDrawable2);
      this.a.n.setImageDrawable(localDrawable3);
    }
  }
  
  public class a
  {
    public SwipeLayout a = null;
    public ImageView b;
    public TextView c;
    public TextView d;
    public ImageView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public LinearLayout i;
    public LinearLayout j;
    public LinearLayout k;
    public ImageView l;
    public ImageView m;
    public ImageView n;
    public View o;
    public View p;
    public View q;
    public View r;
    
    public a() {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\forum\widget\ForumReplyLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */