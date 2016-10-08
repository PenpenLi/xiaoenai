package com.xiaoenai.app.classes.forum.widget;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xiaoenai.app.classes.forum.presenter.f;

public class ForumMomentContentLayout
  extends LinearLayout
{
  private f a;
  private a b;
  
  public ForumMomentContentLayout(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
    a();
    setVisibility(8);
  }
  
  public ForumMomentContentLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
    a();
  }
  
  private void a(Context paramContext)
  {
    this.b = new a();
    this.b.a = LayoutInflater.from(paramContext).inflate(2130903202, this);
    this.b.b = ((ImageView)findViewById(2131559240));
    this.b.c = ((TextView)findViewById(2131559243));
    this.b.d = ((TextView)findViewById(2131559244));
    this.b.e = ((TextView)findViewById(2131559241));
    this.b.f = ((TextView)findViewById(2131559242));
    this.b.g = ((Button)findViewById(2131559245));
    this.b.h = ((LinearLayout)findViewById(2131559246));
  }
  
  public void a()
  {
    if (this.b != null)
    {
      this.b.g.setOnClickListener(new c(this));
      this.b.h.setOnClickListener(new d(this));
    }
  }
  
  public void a(Fragment paramFragment)
  {
    this.a.a(this.b, getContext(), paramFragment);
  }
  
  public void setCommentController(f paramf)
  {
    this.a = paramf;
  }
  
  public class a
  {
    public View a;
    public ImageView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public Button g;
    public LinearLayout h;
    
    public a() {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\forum\widget\ForumMomentContentLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */