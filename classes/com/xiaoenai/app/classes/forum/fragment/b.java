package com.xiaoenai.app.classes.forum.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.forum.ForumActivity;
import com.xiaoenai.app.classes.forum.ForumMomentActivity;
import com.xiaoenai.app.classes.forum.dm;
import com.xiaoenai.app.classes.forum.widget.ForumMomentContentLayout;
import com.xiaoenai.app.model.Forum.Post;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.net.g;
import com.xiaoenai.app.utils.ae;
import com.xiaoenai.app.utils.ak;
import com.xiaoenai.app.widget.PullToRefreshListViewWithFirstItem;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class b
  extends Fragment
{
  private ForumMomentContentLayout a;
  private PullToRefreshListViewWithFirstItem b;
  private com.xiaoenai.app.classes.forum.a.b c;
  private com.xiaoenai.app.classes.forum.presenter.f d = new com.xiaoenai.app.classes.forum.presenter.f();
  private Post e;
  private boolean f = false;
  private boolean g = false;
  private Bundle h = null;
  private int i = -1;
  
  private void a(int paramInt)
  {
    if (this.g) {
      this.g = false;
    }
    this.b.k();
    this.f = false;
    this.c.a(true);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.i = paramInt1;
    new g(new p(this, getActivity())).a(paramInt1, paramInt2);
  }
  
  private void a(View paramView)
  {
    this.a = new ForumMomentContentLayout(getActivity());
    this.b = ((PullToRefreshListViewWithFirstItem)paramView.findViewById(2131559249));
    ((ListView)this.b.getRefreshableView()).addHeaderView(this.a);
    this.c = new com.xiaoenai.app.classes.forum.a.b(getActivity(), 0);
    this.b.setAdapter(this.c);
    this.c.b(false);
    this.c.a(new c(this));
    com.xiaoenai.app.utils.f.a.c("=================ForumMomentFragment initView", new Object[0]);
  }
  
  private void a(JSONObject paramJSONObject, boolean paramBoolean)
  {
    this.b.k();
    this.f = false;
    this.e = new Post(paramJSONObject.optJSONObject("topic"));
    this.d.a(this.e);
    a();
    this.a.setVisibility(0);
    this.c.a(this.e.b);
    paramJSONObject = com.xiaoenai.app.model.Forum.d.b(paramJSONObject.optJSONArray("replies"));
    b(paramJSONObject.size());
    if (!paramBoolean)
    {
      com.xiaoenai.app.classes.common.ads.a locala = new com.xiaoenai.app.classes.common.ads.a();
      locala.a(4);
      locala.b(3);
      paramJSONObject.add(locala);
    }
    for (;;)
    {
      this.c.a(paramJSONObject);
      UserConfig.setInt("forum_current_moment_id", this.e.b);
      UserConfig.setLong("forum_current_moment_end_time", this.e.l);
      b();
      com.xiaoenai.app.utils.f.a.c("=====event===== Reply ==count: {}", new Object[] { Integer.valueOf(paramJSONObject.size()) });
      return;
      e();
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.f) {
      return;
    }
    new g(new f(this, getActivity(), paramBoolean)).a(this.i);
  }
  
  private void b(int paramInt)
  {
    if (paramInt < 20) {
      this.c.a(false);
    }
  }
  
  private void c()
  {
    Object localObject = this.h.getString("param");
    if (!ae.a((String)localObject)) {
      try
      {
        localObject = new JSONObject((String)localObject);
        String str = ((JSONObject)localObject).optString("moment_id");
        if (!ae.a(str))
        {
          this.i = Integer.parseInt(str);
          return;
        }
        this.i = ((JSONObject)localObject).optInt("moment_id");
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return;
      }
    }
    this.i = this.h.getInt("moment_id");
  }
  
  private void d()
  {
    this.b.setOnRefreshListener(new d(this));
    this.b.setOnLastItemVisibleListener(new e(this));
  }
  
  private void e()
  {
    if (isAdded()) {
      dm.a(getActivity(), this.b);
    }
  }
  
  private void f()
  {
    a(true);
  }
  
  private void g()
  {
    if (this.f) {}
    g localg;
    do
    {
      return;
      localg = new g(new k(this, getActivity()));
    } while (this.e == null);
    int j = this.c.a() - 1;
    com.xiaoenai.app.classes.common.ads.a locala2 = this.c.b(j);
    com.xiaoenai.app.classes.common.ads.a locala1 = locala2;
    if (locala2.a() == 4) {
      locala1 = this.c.b(j - 1);
    }
    localg.a(this.e.b, this.c.a(), 20, ((com.xiaoenai.app.model.Forum.d)locala1).b);
  }
  
  private void h()
  {
    if (this.f) {
      return;
    }
    this.g = true;
    this.c.a(true);
    f();
  }
  
  private void i()
  {
    if (this.f) {}
    while (!this.c.c()) {
      return;
    }
    g();
  }
  
  private void j()
  {
    if ((getActivity() != null) && (!getActivity().isFinishing()) && (isAdded()))
    {
      if (this.e.l - ak.b() < 0L) {
        ((ForumMomentActivity)getActivity()).b(getString(2131100372));
      }
    }
    else {
      return;
    }
    ((ForumMomentActivity)getActivity()).b(getString(2131100430));
  }
  
  public void a()
  {
    this.a.setCommentController(this.d);
    this.a.a(this);
    j();
  }
  
  public void b()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && ((localFragmentActivity instanceof ForumActivity))) {}
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 1) && (paramIntent != null))
    {
      String str = this.h.getString("from");
      if ((str == null) || (str.length() <= 0)) {
        break label84;
      }
      paramIntent = paramIntent.getSerializableExtra("forum_reply_name");
      if ((paramIntent != null) && ((paramIntent instanceof com.xiaoenai.app.model.Forum.d)))
      {
        paramIntent = (com.xiaoenai.app.model.Forum.d)paramIntent;
        this.c.a(paramIntent);
      }
    }
    else
    {
      return;
    }
    h();
    return;
    label84:
    if (paramIntent.getStringExtra("forum_reply_name") != null) {
      try
      {
        paramIntent = paramIntent.getStringExtra("forum_reply_name");
        this.c.a(new com.xiaoenai.app.model.Forum.d(new JSONObject(paramIntent)));
        Xiaoenai.j().a(new o(this), 300L);
        return;
      }
      catch (JSONException paramIntent)
      {
        paramIntent.printStackTrace();
        return;
      }
    }
    h();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.h = getArguments();
    return paramLayoutInflater.inflate(2130903203, null);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onResume()
  {
    com.xiaoenai.app.utils.f.a.c("=================ForumMomentFragment onResume", new Object[0]);
    super.onResume();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    a(paramView);
    if ((this.h != null) && (this.h.size() > 0))
    {
      paramView = this.h.getString("from");
      paramBundle = this.h.getString("post_id");
      String str = this.h.getString("topic_id");
      c();
      if ((getString(2131100475).equals(paramView)) && (paramBundle != null) && (paramBundle.length() > 0)) {
        a(Integer.parseInt(str), Integer.parseInt(paramBundle));
      }
    }
    for (;;)
    {
      d();
      return;
      f();
      continue;
      f();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\fragment\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */