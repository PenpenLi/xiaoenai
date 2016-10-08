package com.xiaoenai.app.classes.forum.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaoenai.app.R.styleable;
import com.xiaoenai.app.classes.forum.presenter.ForumTopicViewPresenter;

public class ForumPostLayoutView
  extends LinearLayout
{
  private int a = 0;
  private Context b;
  private a c = null;
  private ForumTopicViewPresenter d;
  
  public ForumPostLayoutView(Context paramContext)
  {
    super(paramContext);
    this.b = paramContext;
    b();
  }
  
  public ForumPostLayoutView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.b = paramContext;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ForumCardLayout);
    try
    {
      b();
      this.a = paramContext.getInt(0, 0);
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  private void b()
  {
    LayoutInflater.from(this.b).inflate(2130903193, this);
    this.c = new a();
    this.c.a = findViewById(2131559196);
    this.c.b = findViewById(2131559222);
    this.c.c = findViewById(2131559205);
    this.c.d = ((ImageView)findViewById(2131559210));
    this.c.e = ((TextView)findViewById(2131559211));
    this.c.f = ((ImageView)findViewById(2131559212));
    this.c.g = ((TextView)findViewById(2131559213));
    this.c.h = ((TextView)findViewById(2131559214));
    this.c.i = ((TextView)findViewById(2131559216));
    this.c.j = ((LinearLayout)findViewById(2131559217));
    this.c.k = ((TextView)findViewById(2131559218));
    this.c.l = ((LinearLayout)findViewById(2131559220));
    this.c.m = ((TextView)findViewById(2131559221));
    this.c.n = ((RelativeLayout)findViewById(2131559219));
    setTag(this.c);
  }
  
  public void a()
  {
    if (this.d != null) {
      this.d.b();
    }
  }
  
  public ForumTopicViewPresenter getController()
  {
    return this.d;
  }
  
  public a getViewHolder()
  {
    return this.c;
  }
  
  public void setCardType(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setController(ForumTopicViewPresenter paramForumTopicViewPresenter)
  {
    this.d = paramForumTopicViewPresenter;
  }
  
  public class a
  {
    public View a;
    public View b;
    public View c;
    public ImageView d;
    public TextView e;
    public ImageView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public LinearLayout j;
    public TextView k;
    public LinearLayout l;
    public TextView m;
    public RelativeLayout n;
    
    public a() {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\widget\ForumPostLayoutView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */