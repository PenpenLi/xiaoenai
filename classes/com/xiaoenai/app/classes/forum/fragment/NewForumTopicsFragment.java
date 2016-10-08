package com.xiaoenai.app.classes.forum.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.marshalchen.ultimaterecyclerview.CustomUltimateRecyclerview;
import com.marshalchen.ultimaterecyclerview.RefreshCustomUltimateRecyclerview;
import com.marshalchen.ultimaterecyclerview.e;
import com.xiaoenai.app.classes.common.webview.WebViewActivity;
import com.xiaoenai.app.classes.forum.ForumTopicActivity;
import com.xiaoenai.app.classes.forum.a.h;
import com.xiaoenai.app.classes.forum.a.l;
import com.xiaoenai.app.classes.forum.a.l.a;
import com.xiaoenai.app.classes.forum.c.b;
import com.xiaoenai.app.classes.forum.presenter.ap;
import com.xiaoenai.app.classes.forum.widget.ForumAdView.a;
import com.xiaoenai.app.model.Forum.ForumAdInfo;
import com.xiaoenai.app.model.Forum.Post;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.ui.component.view.ProgressView;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.e.d.f;
import java.lang.ref.WeakReference;
import java.util.List;

public class NewForumTopicsFragment
  extends com.xiaoenai.app.classes.common.mvp.view.a.a<com.xiaoenai.app.classes.common.ads.a>
  implements AdapterView.OnItemClickListener, com.xiaoenai.app.classes.common.mvp.view.c<com.xiaoenai.app.classes.common.ads.a>, l.a, b, ForumAdView.a
{
  public boolean a = false;
  public final int b = 9999;
  private View c;
  private TextView d;
  private ListView f;
  private l g;
  private h h;
  private ap i;
  private int j = -1;
  private List<com.xiaoenai.app.classes.common.ads.a> k;
  private boolean l = true;
  private int m;
  @BindView(2131559332)
  ImageButton mFloatingButton;
  @BindView(2131558669)
  ProgressView mProgessView;
  @BindView(2131558668)
  RefreshCustomUltimateRecyclerview mRecyclerview;
  
  private void a(Post paramPost)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(getActivity(), ForumTopicActivity.class);
    localIntent.putExtra("forum_topic_key", paramPost);
    getActivity().startActivityForResult(localIntent, 2);
    getActivity().overridePendingTransition(2130968604, 2130968605);
  }
  
  private void a(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.VIEW");
    try
    {
      localIntent.setData(Uri.parse(paramString));
      startActivity(localIntent);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(getActivity(), WebViewActivity.class);
    localIntent.putExtra("url", paramString1);
    localIntent.putExtra("title", paramString2);
    getActivity().startActivity(localIntent);
    getActivity().overridePendingTransition(2130968604, 2130968605);
  }
  
  private void n()
  {
    this.d.setOnClickListener(new y(this));
    this.f.setOnItemClickListener(this);
  }
  
  public void a()
  {
    super.a();
    int n = ab.a();
    this.mRecyclerview.a(new com.marshalchen.ultimaterecyclerview.c(0, 0, 0, ab.a(15.0F)));
    this.mRecyclerview.setOnScrollChangeListener(new w(this, n));
    this.mFloatingButton.setOnClickListener(new x(this));
    this.c = View.inflate(getActivity(), 2130903196, null);
    this.d = ((TextView)this.c.findViewById(2131559223));
    this.f = ((ListView)this.c.findViewById(2131559224));
  }
  
  public void a(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void a(View paramView, Post paramPost)
  {
    a(paramPost);
  }
  
  public void a(ForumAdInfo paramForumAdInfo)
  {
    com.xiaoenai.app.utils.f.a.c("onAdClick", new Object[0]);
    paramForumAdInfo = paramForumAdInfo.i();
    if ((paramForumAdInfo != null) && (!TextUtils.isEmpty(paramForumAdInfo.h())))
    {
      paramForumAdInfo.e();
      com.xiaoenai.app.utils.f.a.c("cta = {} click url = {}", new Object[] { paramForumAdInfo.g(), paramForumAdInfo.h() });
      if ((!TextUtils.isEmpty(paramForumAdInfo.g())) && (paramForumAdInfo.g().equals("open")))
      {
        a(paramForumAdInfo.h(), paramForumAdInfo.a());
        return;
      }
      a(paramForumAdInfo.h());
      return;
    }
    com.xiaoenai.app.utils.f.a.b("AdInfo is null", new Object[0]);
  }
  
  public void a(List<com.xiaoenai.app.classes.common.ads.a> paramList)
  {
    this.h.a(paramList);
    this.k = paramList;
    ListView localListView = this.f;
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (int n = 8;; n = 0)
    {
      localListView.setVisibility(n);
      return;
    }
  }
  
  public void b()
  {
    this.g = new l(getActivity());
    this.g.a(this);
    this.h = new h();
    this.f.setAdapter(this.h);
    Resources localResources = getResources();
    if (UserConfig.getBoolean("forum_night_theme", Boolean.valueOf(false)).booleanValue()) {}
    for (int n = 2131492944;; n = 2131492952)
    {
      n = localResources.getColor(n);
      this.g.d().setBackgroundColor(n);
      this.mRecyclerview.setAdapter(this.g);
      this.mRecyclerview.setNormalHeader(this.c);
      if ((this.g.b() == null) || (this.g.b().size() == 0)) {
        this.i.d();
      }
      n();
      return;
    }
  }
  
  public void b(int paramInt)
  {
    if (paramInt > 0)
    {
      this.d.setVisibility(0);
      if (paramInt <= 9999) {
        break label98;
      }
      paramInt = 9999;
    }
    label98:
    for (int n = 1;; n = 0)
    {
      String str = String.format(getString(2131100432), new Object[] { Integer.valueOf(paramInt) });
      if (n != 0) {
        str = getString(2131100901) + str;
      }
      for (;;)
      {
        this.d.setText(str);
        return;
      }
      this.d.setVisibility(8);
      return;
    }
  }
  
  public void b(ForumAdInfo paramForumAdInfo)
  {
    com.xiaoenai.app.utils.f.a.c("onAdClose", new Object[0]);
    List localList = this.g.b();
    this.l = false;
    if (localList != null)
    {
      com.xiaoenai.app.utils.f.a.c("onAdClose {}", new Object[] { Integer.valueOf(localList.size()) });
      this.i.a(paramForumAdInfo);
      if (localList.remove(paramForumAdInfo))
      {
        com.xiaoenai.app.utils.f.a.c("onAdClose remove", new Object[0]);
        paramForumAdInfo.i().f();
        this.g.notifyDataSetChanged();
      }
      com.xiaoenai.app.utils.f.a.c("onAdClose {}", new Object[] { Integer.valueOf(localList.size()) });
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public e<com.xiaoenai.app.classes.common.ads.a> d()
  {
    return this.g;
  }
  
  public ProgressView e()
  {
    return this.mProgessView;
  }
  
  public com.xiaoenai.app.classes.common.mvp.a.a<com.xiaoenai.app.classes.common.ads.a> f()
  {
    return this.i;
  }
  
  public com.xiaoenai.app.classes.common.mvp.view.c<com.xiaoenai.app.classes.common.ads.a> g()
  {
    return this;
  }
  
  public void h()
  {
    super.h();
    if (this.i != null) {
      this.i.h();
    }
  }
  
  public void i()
  {
    if ((this.g.b() == null) || (this.g.b().size() == 0)) {
      this.i.d();
    }
  }
  
  public CustomUltimateRecyclerview i_()
  {
    return this.mRecyclerview;
  }
  
  public void j()
  {
    if ((this.mRecyclerview != null) && (this.mRecyclerview.e != null)) {
      this.mRecyclerview.e.scrollToPosition(0);
    }
  }
  
  public int k()
  {
    return this.j;
  }
  
  public long l()
  {
    if ((this.g == null) || (this.g.b() == null) || (this.g.b().size() == 0)) {
      return -1L;
    }
    Post localPost = (Post)this.g.b().get(this.g.b().size() - 1);
    if (localPost != null) {
      return localPost.f;
    }
    return -1L;
  }
  
  public Fragment m()
  {
    return this;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.i = new ap(this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130903223, null);
    ButterKnife.bind(this, paramLayoutInflater);
    this.mRecyclerview.setHasFixedSize(true);
    this.mRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
    paramViewGroup = new WeakReference(com.xiaoenai.app.utils.e.d.b());
    this.mRecyclerview.a(new f(paramViewGroup, true, true, null));
    return paramLayoutInflater;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((this.k != null) && (this.k.get(paramInt) != null)) {
      a((Post)this.k.get(paramInt));
    }
  }
  
  public void onResume()
  {
    if (this.a) {
      this.d.setVisibility(8);
    }
    super.onResume();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.g.a(this);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\fragment\NewForumTopicsFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */