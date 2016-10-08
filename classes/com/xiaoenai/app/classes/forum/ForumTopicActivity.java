package com.xiaoenai.app.classes.forum;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.classes.forum.a.b;
import com.xiaoenai.app.classes.forum.presenter.ForumTopicViewPresenter;
import com.xiaoenai.app.classes.forum.widget.ForumPostLayoutView;
import com.xiaoenai.app.model.Forum.Post;
import com.xiaoenai.app.model.Forum.d;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.net.g;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.utils.ae;
import com.xiaoenai.app.widget.PullToRefreshListViewWithFirstItem;
import com.xiaoenai.app.widget.TitleBarView;
import org.json.JSONException;
import org.json.JSONObject;

public class ForumTopicActivity
  extends TitleBarActivity
{
  protected PullToRefreshListViewWithFirstItem a;
  protected ForumPostLayoutView b;
  protected ForumTopicViewPresenter c;
  protected b i;
  protected LinearLayout j;
  protected LinearLayout k;
  protected LinearLayout l;
  protected Post m;
  protected boolean n = true;
  protected boolean o = true;
  private ImageView s;
  private int t = 1;
  private int u = 0;
  private boolean v = false;
  
  private void c()
  {
    Object localObject = getIntent();
    if (localObject != null)
    {
      String str = ((Intent)localObject).getStringExtra("param");
      if (!ae.a(str)) {
        try
        {
          localObject = new JSONObject(str);
          str = ((JSONObject)localObject).optString("topic_id");
          if (!ae.a(str)) {}
          for (this.u = Integer.parseInt(str);; this.u = ((JSONObject)localObject).optInt("topic_id"))
          {
            localObject = ((JSONObject)localObject).optString("module_id");
            if ((ae.a((String)localObject)) || (!((String)localObject).equalsIgnoreCase("xiaoenai.forum.topic"))) {
              break;
            }
            this.t = 3;
            return;
          }
          this.m = ((Post)localJSONException.getParcelableExtra("forum_topic_key"));
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
          return;
        }
      }
      this.t = localJSONException.getIntExtra("forum_topic_type_key", 1);
      this.u = localJSONException.getIntExtra("forum_topic_id", 0);
    }
  }
  
  private void c(int paramInt)
  {
    if (paramInt == 2)
    {
      this.g.setTitle(2131100493);
      this.g.a(2130839000, 0);
      this.g.setRightButtonVisible(8);
    }
  }
  
  private void i()
  {
    this.c = new ForumTopicViewPresenter(1, this, this.b.getViewHolder());
    this.c.a(this.m);
    if (this.m != null)
    {
      this.c.b();
      return;
    }
    this.b.setVisibility(8);
  }
  
  private void j()
  {
    if (this.v) {}
    int i1;
    com.xiaoenai.app.classes.common.ads.a locala;
    do
    {
      do
      {
        return;
      } while (!this.i.c());
      int i2 = this.i.a() - 1;
      i1 = i2;
      if (i2 < 0) {
        i1 = 0;
      }
      locala = this.i.b(i1);
    } while (locala == null);
    if (locala.a() == 4) {
      locala = this.i.b(i1 - 1);
    }
    for (;;)
    {
      i1 = ((d)locala).b;
      a(q(), i1, 20, null);
      return;
    }
  }
  
  private m k()
  {
    return new cx(this, this);
  }
  
  private void o()
  {
    new g(new cy(this, this)).b(q());
  }
  
  private void p()
  {
    Post localPost;
    if (this.m != null)
    {
      localPost = this.m;
      if (this.m.q) {
        break label49;
      }
    }
    label49:
    for (boolean bool = true;; bool = false)
    {
      localPost.q = bool;
      h();
      new g(this).c(q());
      return;
    }
  }
  
  private int q()
  {
    int i2 = 13881;
    int i1;
    if (this.t == 1) {
      if (this.m != null) {
        i1 = this.m.b;
      }
    }
    do
    {
      do
      {
        return i1;
        return this.u;
        i1 = i2;
      } while (this.t == 2);
      i1 = i2;
    } while (this.t != 3);
    return this.u;
  }
  
  private void s()
  {
    com.xiaoenai.app.classes.extentions.forum.a.a(this.m, this);
  }
  
  public int a()
  {
    return 2130903219;
  }
  
  protected void a(int paramInt)
  {
    if (paramInt < 20) {
      this.i.a(false);
    }
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, a parama)
  {
    new g(new dd(this, this, parama)).b(paramInt1, paramInt2, paramInt3, this.i.a());
  }
  
  protected void b()
  {
    super.b();
    this.g.setLeftButtonClickListener(new dl(this));
    this.g.setRightButtonClickListener(new cw(this));
  }
  
  protected void d()
  {
    this.a = ((PullToRefreshListViewWithFirstItem)findViewById(2131559313));
    this.b = new ForumPostLayoutView(this);
    this.i = new b(this, q());
    ListView localListView = (ListView)this.a.getRefreshableView();
    localListView.addHeaderView(this.b);
    localListView.setHeaderDividersEnabled(true);
    this.b.setCardType(1);
    this.b.setController(this.c);
    if (this.m != null)
    {
      dm.a(this, this.a);
      this.b.a();
    }
    for (;;)
    {
      this.a.setAdapter(this.i);
      this.j = ((LinearLayout)findViewById(2131559318));
      this.k = ((LinearLayout)findViewById(2131559321));
      this.l = ((LinearLayout)findViewById(2131559315));
      this.s = ((ImageView)findViewById(2131559322));
      h();
      return;
      this.b.setVisibility(8);
    }
  }
  
  protected void f()
  {
    this.j.setOnClickListener(new cv(this));
    this.k.setOnClickListener(new de(this));
    this.l.setOnClickListener(new df(this));
    this.g.setOnClickListener(new dg(this));
  }
  
  protected void g()
  {
    this.a.setOnRefreshListener(new dh(this));
    this.a.setOnLastItemVisibleListener(new di(this));
  }
  
  protected void h()
  {
    if ((this.m != null) && (this.m.q))
    {
      this.s.setImageResource(2130838481);
      return;
    }
    this.s.setImageResource(2130838483);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      if (paramInt1 != 257) {
        break label76;
      }
      paramIntent = paramIntent.getStringExtra("forum_reply_name");
      com.xiaoenai.app.utils.f.a.c(paramIntent, new Object[0]);
    }
    label76:
    while (paramInt1 != 259) {
      try
      {
        paramIntent = new d(new JSONObject(paramIntent));
        this.i.a(paramIntent);
        Xiaoenai.j().a(new dj(this), 300L);
        return;
      }
      catch (JSONException paramIntent)
      {
        paramIntent.printStackTrace();
        return;
      }
    }
    Xiaoenai.j().a(new dk(this), 300L);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.d(UserConfig.getBoolean("forum_night_theme", Boolean.valueOf(false)).booleanValue());
    super.onCreate(paramBundle);
    c();
    d();
    if (this.o) {
      i();
    }
    f();
    g();
    if (this.n) {
      o();
    }
    c(this.t);
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\ForumTopicActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */