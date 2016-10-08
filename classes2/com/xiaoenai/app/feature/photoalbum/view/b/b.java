package com.xiaoenai.app.feature.photoalbum.view.b;

import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.View;
import com.tonicartos.superslim.LayoutManager;
import com.xiaoenai.app.feature.photoalbum.a.d;
import com.xiaoenai.app.feature.photoalbum.e.c;
import com.xiaoenai.app.feature.photoalbum.view.activity.PhotoAlbumActivity;

class b
  extends RecyclerView.OnScrollListener
{
  b(a parama) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if ((paramInt == 0) && (!ViewCompat.canScrollVertically(paramRecyclerView, 1)))
    {
      paramRecyclerView = ((LayoutManager)a.a(this.a).getLayoutManager()).b().findViewById(a.d.item_album_progressView);
      if (paramRecyclerView != null) {
        a.a(this.a).setTag(paramRecyclerView);
      }
      ((PhotoAlbumActivity)this.a.getActivity()).b().a(a.a(this.a));
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\feature\photoalbum\view\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */