package com.xiaoenai.app.classes.forum.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xiaoenai.app.classes.forum.ForumReplyActivity;
import com.xiaoenai.app.classes.forum.dm;
import com.xiaoenai.app.classes.forum.widget.ForumReplyLayout;
import com.xiaoenai.app.classes.forum.widget.ForumReplyLayout.a;
import com.xiaoenai.app.model.Forum.f;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.net.g;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.ak;
import com.xiaoenai.app.utils.as;
import com.xiaoenai.app.utils.f.a;
import com.xiaoenai.app.widget.swipeLayout.SwipeLayout;
import com.xiaoenai.app.widget.swipeLayout.SwipeLayout.i;

public class o
  implements b
{
  private com.xiaoenai.app.model.Forum.d a;
  private Context b;
  private int c;
  private int d;
  private a e;
  private ForumReplyLayout.a f;
  
  public o(Context paramContext, int paramInt1, a parama, int paramInt2, ForumReplyLayout paramForumReplyLayout, SwipeLayout.i parami)
  {
    this.b = paramContext;
    this.c = paramInt1;
    this.e = parama;
    this.d = paramInt2;
    this.f = paramForumReplyLayout.getViewHolder();
    this.f.a.a(parami);
  }
  
  private void a(ForumReplyLayout.a parama)
  {
    if (this.a.a == 2)
    {
      if (!UserConfig.getBoolean("forum_night_theme", Boolean.valueOf(false)).booleanValue()) {
        parama.r.setBackgroundColor(-1);
      }
      if (!f.d().d) {
        a(parama, 8);
      }
      b(parama, 8);
      if ((!f.d().d) && (this.a.g.a == f.d().a)) {
        parama.a.setSwipeEnabled(false);
      }
    }
  }
  
  private void a(ForumReplyLayout.a parama, int paramInt)
  {
    parama.k.setVisibility(paramInt);
    parama.q.setVisibility(paramInt);
  }
  
  private void b(ForumReplyLayout.a parama, int paramInt)
  {
    parama.i.setVisibility(paramInt);
    parama.o.setVisibility(paramInt);
  }
  
  private void c(ForumReplyLayout.a parama, int paramInt)
  {
    parama.j.setVisibility(paramInt);
    parama.p.setVisibility(paramInt);
  }
  
  private void f()
  {
    new g(new w(this, this.b)).h(this.a.b);
  }
  
  public void a()
  {
    com.xiaoenai.app.utils.e.b.a(this.f.b, this.a.g.c + "?imageView/2/w/" + ab.a(34.0F), Boolean.valueOf(true));
    this.f.c.setText(String.valueOf(this.a.e) + this.f.c.getContext().getString(2131100386));
    this.f.d.setText(this.a.g.b);
    int i;
    String str;
    if (this.a.g.e == 0)
    {
      i = 2130838341;
      this.f.e.setImageResource(i);
      if ((this.a.i == null) || (this.a.i.e <= 0)) {
        break label412;
      }
      str = this.a.i.g.b;
      str = String.format(as.a(2131100482), new Object[] { str });
      if (!this.a.c.startsWith(str)) {
        break label375;
      }
      this.f.g.setText(this.a.c);
      label233:
      this.f.h.setText(ak.a(this.a.f));
      com.xiaoenai.app.classes.chat.input.faces.d.a().c(this.f.g);
      com.xiaoenai.app.classes.chat.input.faces.d.a().c(this.f.f);
      a.c("author {} user {}", new Object[] { Integer.valueOf(this.a.g.a), Integer.valueOf(f.d().a) });
      if (!f.d().d)
      {
        if (this.a.g.a == f.d().a) {
          break label432;
        }
        a(this.f, 8);
      }
    }
    for (;;)
    {
      a(this.f);
      b();
      return;
      i = 2130838340;
      break;
      label375:
      this.f.g.setText(str + this.a.c);
      break label233;
      label412:
      this.f.g.setText(this.a.c);
      break label233;
      label432:
      a(this.f, 0);
      c(this.f, 8);
    }
  }
  
  public void a(com.xiaoenai.app.model.Forum.d paramd)
  {
    this.a = paramd;
  }
  
  public void b()
  {
    if (this.f != null)
    {
      this.f.i.setOnClickListener(new p(this));
      this.f.j.setOnClickListener(new q(this));
      this.f.k.setOnClickListener(new r(this));
      this.f.l.setOnClickListener(new s(this));
      this.f.m.setOnClickListener(new t(this));
      this.f.n.setOnClickListener(new u(this));
    }
  }
  
  public void c()
  {
    if (dm.a((Activity)this.b, 1))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("forum_topic_id", this.c);
      localIntent.putExtra("forum_reply_id", this.a.b);
      localIntent.putExtra("forum_reply_name", this.a.g.b);
      localIntent.putExtra("forum_reply_floor", this.a.e);
      localIntent.setClass(this.b, ForumReplyActivity.class);
      ((Activity)this.b).startActivityForResult(localIntent, 257);
      ((Activity)this.b).overridePendingTransition(2130968608, 2130968609);
    }
  }
  
  public void d()
  {
    if (this.a.a == 2)
    {
      x.a(this.b, this.a, this.c, 4);
      return;
    }
    x.a(this.b, this.a, this.c, 3);
  }
  
  public void e()
  {
    new g(new v(this, this.b)).e(this.a.b);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\forum\presenter\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */