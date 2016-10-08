package com.xiaoenai.app.classes.forum.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.marshalchen.ultimaterecyclerview.CustomUltimateRecyclerview;
import com.marshalchen.ultimaterecyclerview.RefreshCustomUltimateRecyclerview;
import com.marshalchen.ultimaterecyclerview.e;
import com.xiaoenai.app.classes.common.webview.WebViewActivity;
import com.xiaoenai.app.classes.forum.ForumMomentActivity;
import com.xiaoenai.app.classes.forum.a.a.a;
import com.xiaoenai.app.classes.forum.model.MomentInfo;
import com.xiaoenai.app.classes.street.ea;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.ui.component.view.ProgressView;
import com.xiaoenai.app.utils.ab;
import java.util.List;

public class ForumMomentListFragment
  extends com.xiaoenai.app.classes.common.mvp.view.a.a<MomentInfo>
  implements com.xiaoenai.app.classes.common.mvp.view.c<MomentInfo>, a.a
{
  private com.xiaoenai.app.classes.forum.presenter.c a;
  private com.xiaoenai.app.classes.forum.a.a b;
  private int c;
  @BindView(2131559332)
  ImageButton mFloatingButton;
  @BindView(2131558669)
  ProgressView mProgressView;
  @BindView(2131558668)
  RefreshCustomUltimateRecyclerview mRecyclerview;
  
  public void a()
  {
    super.a();
    this.mRecyclerview.a(new com.marshalchen.ultimaterecyclerview.c(ab.a(10.0F), ab.a(12.0F), ab.a(10.0F), 0));
    int i = ab.a();
    this.mRecyclerview.setOnScrollChangeListener(new t(this, i));
    this.mFloatingButton.setOnClickListener(new u(this));
  }
  
  public void a(View paramView, MomentInfo paramMomentInfo)
  {
    Object localObject;
    if (paramMomentInfo != null)
    {
      com.xiaoenai.app.utils.f.a.c(paramMomentInfo.toString(), new Object[0]);
      paramView = new Intent();
      localObject = paramMomentInfo.getUrl();
      if ((localObject != null) && (((String)localObject).length() != 0)) {
        break label104;
      }
      paramView.setClass(getActivity(), ForumMomentActivity.class);
      localObject = new Bundle();
      ((Bundle)localObject).putInt("moment_id", paramMomentInfo.getId());
      ((Bundle)localObject).putInt("moment_flag", paramMomentInfo.getStatus());
      paramView.putExtras((Bundle)localObject);
    }
    for (;;)
    {
      getActivity().startActivity(paramView);
      getActivity().overridePendingTransition(2130968604, 2130968605);
      return;
      label104:
      paramView.setClass(getActivity(), WebViewActivity.class);
      paramView.putExtra("url", ea.a((String)localObject));
    }
  }
  
  public void b()
  {
    Resources localResources = getResources();
    if (UserConfig.getBoolean("forum_night_theme", Boolean.valueOf(false)).booleanValue()) {}
    for (int i = 2131492944;; i = 2131492952)
    {
      i = localResources.getColor(i);
      this.b.d().setBackgroundColor(i);
      this.mRecyclerview.setAdapter(this.b);
      return;
    }
  }
  
  public e<MomentInfo> d()
  {
    return this.b;
  }
  
  public ProgressView e()
  {
    return this.mProgressView;
  }
  
  public com.xiaoenai.app.classes.common.mvp.a.a<MomentInfo> f()
  {
    return this.a;
  }
  
  public com.xiaoenai.app.classes.common.mvp.view.c<MomentInfo> g()
  {
    return this;
  }
  
  public void i()
  {
    if ((this.b.b() == null) || (this.b.b().size() == 0)) {
      this.a.d();
    }
  }
  
  public CustomUltimateRecyclerview i_()
  {
    return this.mRecyclerview;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a = new com.xiaoenai.app.classes.forum.presenter.c(this);
    this.b = new com.xiaoenai.app.classes.forum.a.a(getActivity());
    this.b.a(this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130903222, null);
    ButterKnife.bind(this, paramLayoutInflater);
    this.mRecyclerview.setHasFixedSize(true);
    this.mRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
    return paramLayoutInflater;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\fragment\ForumMomentListFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */