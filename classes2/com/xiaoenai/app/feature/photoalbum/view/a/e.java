package com.xiaoenai.app.feature.photoalbum.view.a;

import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tonicartos.superslim.GridSLM;
import com.tonicartos.superslim.GridSLM.LayoutParams;
import com.xiaoenai.app.domain.PhotoAlbum;
import com.xiaoenai.app.feature.photoalbum.a.e;
import com.xiaoenai.app.feature.photoalbum.b.b;
import com.xiaoenai.app.feature.photoalbum.e.c;
import com.xiaoenai.app.feature.photoalbum.view.activity.PhotoAlbumActivity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class e
  extends RecyclerView.Adapter<com.xiaoenai.app.feature.photoalbum.view.widget.d>
  implements View.OnClickListener
{
  private ArrayList<a> a = new ArrayList();
  private int b;
  private boolean c;
  private Map<Long, Integer> d = new HashMap();
  private final PhotoAlbumActivity e;
  private c f;
  private long g;
  private View h;
  
  public e(PhotoAlbumActivity paramPhotoAlbumActivity, View paramView, int paramInt, long paramLong)
  {
    this.e = paramPhotoAlbumActivity;
    this.g = (1000L * paramLong);
    this.f = this.e.b();
    this.h = paramView;
    this.f.a(new f(this));
    paramPhotoAlbumActivity = this.f.e();
    if (paramPhotoAlbumActivity.size() > 0) {
      a(paramPhotoAlbumActivity);
    }
    this.b = paramInt;
  }
  
  private void a()
  {
    int i = 0;
    while (i < this.a.size())
    {
      if (((a)this.a.get(i)).c) {
        notifyItemChanged(i);
      }
      i += 1;
    }
  }
  
  private void a(List<PhotoAlbum> paramList)
  {
    List localList = new b().a(paramList, this.g);
    if (localList.size() > 0) {
      this.h.setVisibility(0);
    }
    this.a.clear();
    paramList = "";
    int i = 0;
    int k = 0;
    int j = 0;
    com.xiaoenai.app.feature.photoalbum.b.d locald;
    if (i < localList.size())
    {
      Object localObject = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
      locald = (com.xiaoenai.app.feature.photoalbum.b.d)localList.get(i);
      localObject = ((SimpleDateFormat)localObject).format(locald.c());
      if (TextUtils.equals(paramList, (CharSequence)localObject)) {
        break label212;
      }
      k = i + j;
      this.a.add(new a(locald, true, 0, k));
      j += 1;
      paramList = (List<PhotoAlbum>)localObject;
    }
    label212:
    for (;;)
    {
      this.d.put(((com.xiaoenai.app.feature.photoalbum.b.d)localList.get(i)).a(), Integer.valueOf(this.a.size()));
      this.a.add(new a(locald, false, 0, k));
      i += 1;
      break;
      notifyDataSetChanged();
      return;
    }
  }
  
  public com.xiaoenai.app.feature.photoalbum.view.widget.d a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 1)
    {
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(a.e.header_item, paramViewGroup, false);
      return new com.xiaoenai.app.feature.photoalbum.view.widget.d(this.e, paramViewGroup, true, this, this.f);
    }
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(a.e.item_album_time_alxe, paramViewGroup, false);
    return new com.xiaoenai.app.feature.photoalbum.view.widget.d(this.e, paramViewGroup, false, this, this.f);
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
    a();
  }
  
  public void a(com.xiaoenai.app.feature.photoalbum.view.widget.d paramd, int paramInt)
  {
    boolean bool2 = false;
    a locala = (a)this.a.get(paramInt);
    View localView = paramd.itemView;
    paramd.a(locala, this, paramInt);
    GridSLM.LayoutParams localLayoutParams = GridSLM.LayoutParams.a(localView.getLayoutParams());
    boolean bool1;
    if (locala.c)
    {
      localLayoutParams.b = this.b;
      if ((localLayoutParams.f()) || ((this.c) && (!localLayoutParams.g())))
      {
        localLayoutParams.width = -1;
        if (this.c) {
          break label177;
        }
        bool1 = true;
        label93:
        localLayoutParams.f = bool1;
        bool1 = bool2;
        if (!this.c) {
          bool1 = true;
        }
        localLayoutParams.e = bool1;
      }
    }
    else
    {
      if (locala.a != 0) {
        break label183;
      }
    }
    label177:
    label183:
    for (paramInt = com.tonicartos.superslim.e.a;; paramInt = GridSLM.a)
    {
      localLayoutParams.c(paramInt);
      localLayoutParams.a(120);
      localLayoutParams.b(locala.b);
      localView.setLayoutParams(localLayoutParams);
      paramd.setIsRecyclable(true);
      return;
      localLayoutParams.width = -2;
      break;
      bool1 = false;
      break label93;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
    a();
  }
  
  public int getItemCount()
  {
    return this.a.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    if (((a)this.a.get(paramInt)).c) {
      return 1;
    }
    return 0;
  }
  
  public void onClick(View paramView) {}
  
  public static class a
  {
    public int a;
    public int b;
    public boolean c;
    public com.xiaoenai.app.feature.photoalbum.b.d d;
    
    public a(com.xiaoenai.app.feature.photoalbum.b.d paramd, boolean paramBoolean, int paramInt1, int paramInt2)
    {
      this.c = paramBoolean;
      this.d = paramd;
      this.a = paramInt1;
      this.b = paramInt2;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\feature\photoalbum\view\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */