package com.xiaoenai.app.feature.photoalbum.view.b;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tonicartos.superslim.LayoutManager;
import com.xiaoenai.app.feature.photoalbum.a.a;
import com.xiaoenai.app.feature.photoalbum.a.d;
import com.xiaoenai.app.feature.photoalbum.a.e;
import com.xiaoenai.app.feature.photoalbum.e.c;
import com.xiaoenai.app.feature.photoalbum.e.c.a;
import com.xiaoenai.app.feature.photoalbum.view.activity.PhotoAlbumActivity;
import com.xiaoenai.app.ui.component.view.SwipeRefreshLayout;
import com.xiaoenai.app.ui.component.view.SwipeRefreshLayout.b;
import com.xiaoenai.app.ui.component.view.SwipeRefreshLayout.c;
import com.xiaoenai.app.ui.component.view.SwipeRefreshLayout.d;
import com.xiaoenai.app.utils.e.d;
import com.xiaoenai.app.utils.e.d.f;
import java.lang.ref.WeakReference;

public class a
  extends com.xiaoenai.app.common.view.a.a
  implements c.a, SwipeRefreshLayout.c, SwipeRefreshLayout.d
{
  private RecyclerView a;
  private SwipeRefreshLayout b;
  private com.xiaoenai.app.feature.photoalbum.view.a.b c;
  private int d;
  private boolean f;
  private View g;
  
  private void c()
  {
    this.a.setLayoutManager(new LayoutManager(getActivity()));
    this.c = new com.xiaoenai.app.feature.photoalbum.view.a.b((PhotoAlbumActivity)getActivity());
    WeakReference localWeakReference = new WeakReference(d.b());
    this.a.addOnScrollListener(new f(localWeakReference, true, true, new b(this)));
    this.a.setAdapter(this.c);
  }
  
  public void a()
  {
    com.xiaoenai.app.utils.f.a.e("onLoad()", new Object[0]);
    View localView = ((LayoutManager)this.a.getLayoutManager()).b().findViewById(a.d.item_album_progressView);
    if (localView != null) {
      this.b.setTag(localView);
    }
    ((PhotoAlbumActivity)getActivity()).b().a(this.a);
  }
  
  public void a(int paramInt)
  {
    if (-1 == paramInt) {
      this.c.notifyDataSetChanged();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.b.setVisibility(8);
      this.g.setVisibility(0);
      return;
    }
    this.g.setVisibility(8);
    this.b.setVisibility(0);
  }
  
  public void b()
  {
    this.b.setRefreshing(false);
  }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(a.e.fragment_album_table, null);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.a != null) {
      this.a.clearOnScrollListeners();
    }
    if (this.c != null) {
      this.c.a();
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putInt("key_header_mode", this.d);
    paramBundle.putBoolean("key_margins_fixed", this.f);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    if (paramBundle != null) {
      this.d = paramBundle.getInt("key_header_mode", 17);
    }
    for (this.f = paramBundle.getBoolean("key_margins_fixed", getResources().getBoolean(a.a.default_margins_fixed));; this.f = getResources().getBoolean(a.a.default_margins_fixed))
    {
      this.d = 0;
      this.a = ((RecyclerView)paramView.findViewById(a.d.album_list_recyclerview));
      this.g = paramView.findViewById(a.d.emptyLayout);
      this.b = ((SwipeRefreshLayout)paramView.findViewById(a.d.album_list_SwipeRefreshLayout));
      this.b.a(17170445, 17170445, 17170445, 17170445);
      this.b.b(17170445, 17170445, 17170445, 17170445);
      this.b.setOnRefreshListener(this);
      this.b.setOnLoadListener(this);
      this.b.setMode(SwipeRefreshLayout.b.a);
      c();
      ((PhotoAlbumActivity)getActivity()).b().a(this);
      return;
      this.d = 17;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\feature\photoalbum\view\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */