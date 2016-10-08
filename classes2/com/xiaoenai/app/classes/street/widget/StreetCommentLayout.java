package com.xiaoenai.app.classes.street.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.xiaoenai.app.widget.swipeLayout.SwipeLayout;
import com.xiaoenai.app.widget.swipeLayout.SwipeLayout.b;
import com.xiaoenai.app.widget.swipeLayout.SwipeLayout.e;

public class StreetCommentLayout
  extends LinearLayout
{
  private a a;
  
  public StreetCommentLayout(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public StreetCommentLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.a = new a();
    this.a.a = ((SwipeLayout)LayoutInflater.from(paramContext).inflate(2130903275, null));
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    addView(this.a.a, paramContext);
    this.a.a.a(new g(this));
    this.a.a.setShowMode(SwipeLayout.e.b);
    this.a.a.setDragEdge(SwipeLayout.b.b);
    setOnClickListener(new h(this));
    this.a.b = ((ImageView)this.a.a.findViewById(2131559618));
    this.a.c = ((TextView)this.a.a.findViewById(2131559620));
    this.a.d = ((TextView)this.a.a.findViewById(2131559621));
    this.a.e = ((TextView)this.a.a.findViewById(2131559619));
    this.a.f = ((LinearLayout)this.a.a.findViewById(2131559616));
    this.a.g = this.a.a.findViewById(2131559282);
    this.a.h = this.a.a.findViewById(2131559615);
  }
  
  public a getViewHolder()
  {
    return this.a;
  }
  
  public class a
  {
    public SwipeLayout a = null;
    public ImageView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public LinearLayout f;
    public View g;
    public View h;
    
    public a() {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\StreetCommentLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */