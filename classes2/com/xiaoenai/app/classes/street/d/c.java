package com.xiaoenai.app.classes.street.d;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xiaoenai.app.classes.street.model.Comment;
import com.xiaoenai.app.classes.street.widget.StreetCommentLayout;
import com.xiaoenai.app.classes.street.widget.StreetCommentLayout.a;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.ak;
import com.xiaoenai.app.utils.e.b;
import com.xiaoenai.app.widget.swipeLayout.SwipeLayout;
import com.xiaoenai.app.widget.swipeLayout.SwipeLayout.i;

public class c
  extends a
{
  private Comment a;
  private Context b;
  private int c;
  private a d;
  private StreetCommentLayout.a e;
  
  public c(Context paramContext, a parama, int paramInt, StreetCommentLayout paramStreetCommentLayout, SwipeLayout.i parami)
  {
    this.b = paramContext;
    this.d = parama;
    this.c = paramInt;
    this.e = paramStreetCommentLayout.getViewHolder();
    this.e.a.a(parami);
  }
  
  private void a(StreetCommentLayout.a parama, int paramInt)
  {
    parama.f.setVisibility(paramInt);
    parama.g.setVisibility(paramInt);
  }
  
  public void a()
  {
    b.a(this.e.b, this.a.getCouplePhoto() + "?imageView/2/w/" + ab.a(34.0F), Boolean.valueOf(true));
    this.e.c.setText(this.a.getName());
    this.e.d.setText(this.a.getContent());
    this.e.e.setText(ak.a(this.a.getCreatedTime()));
    com.xiaoenai.app.classes.chat.input.faces.d.a().c(this.e.d);
    if (this.a.getUid() == User.getInstance().getUserId())
    {
      a(this.e, 8);
      this.e.a.setSwipeEnabled(false);
    }
    for (;;)
    {
      b();
      return;
      a(this.e, 0);
      this.e.a.setSwipeEnabled(true);
    }
  }
  
  public void a(Comment paramComment)
  {
    this.a = paramComment;
  }
  
  public void b()
  {
    if (this.e != null) {
      this.e.f.setOnClickListener(new d(this));
    }
  }
  
  public void c()
  {
    bg.a(this.b, this.a);
  }
  
  public static abstract interface a {}
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\d\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */