package com.xiaoenai.app.classes.forum.presenter;

import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.xiaoenai.app.classes.forum.widget.ForumNotiTopicView;

public class g
{
  private ForumNotiTopicView a;
  private ViewGroup.LayoutParams b;
  
  public g(ForumNotiTopicView paramForumNotiTopicView, ViewGroup.LayoutParams paramLayoutParams)
  {
    this.a = paramForumNotiTopicView;
    this.b = paramLayoutParams;
  }
  
  public void a()
  {
    this.a.setLayoutParams(this.b);
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.a.getGetDetailBtn().setOnClickListener(paramOnClickListener);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\presenter\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */