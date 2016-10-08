package com.xiaoenai.app.feature.photoalbum.view.a;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tonicartos.superslim.GridSLM;
import com.tonicartos.superslim.GridSLM.LayoutParams;
import com.tonicartos.superslim.e;
import com.xiaoenai.app.domain.PhotoAlbum;
import com.xiaoenai.app.feature.photoalbum.a.c;
import com.xiaoenai.app.feature.photoalbum.a.e;
import com.xiaoenai.app.feature.photoalbum.preview.PhotoPreviewActivity;
import com.xiaoenai.app.feature.photoalbum.view.activity.PhotoAlbumActivity;
import com.xiaoenai.app.feature.photoalbum.view.widget.a.a;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class b
  extends RecyclerView.Adapter<com.xiaoenai.app.feature.photoalbum.view.widget.a>
  implements View.OnClickListener
{
  private b a;
  private ArrayList<a> b = new ArrayList();
  private Map<String, Integer> c = new HashMap();
  private int d;
  private Set<Integer> e = new HashSet();
  private final PhotoAlbumActivity f;
  private com.xiaoenai.app.feature.photoalbum.e.c g;
  private int h = 0;
  
  public b(PhotoAlbumActivity paramPhotoAlbumActivity)
  {
    this.f = paramPhotoAlbumActivity;
    this.g = this.f.b();
    this.g.a(new c(this));
    paramPhotoAlbumActivity = this.g.e();
    if (paramPhotoAlbumActivity.size() > 0) {
      a(paramPhotoAlbumActivity);
    }
  }
  
  private void a(List<PhotoAlbum> paramList)
  {
    if (paramList.isEmpty()) {
      return;
    }
    List localList = new com.xiaoenai.app.feature.photoalbum.b.b().b(paramList);
    this.b.clear();
    Object localObject = "";
    int j = 0;
    int k = 0;
    int i = 0;
    SimpleDateFormat localSimpleDateFormat;
    com.xiaoenai.app.feature.photoalbum.b.c localc;
    String str;
    if (j < localList.size())
    {
      localSimpleDateFormat = new SimpleDateFormat("yyyy-MM", Locale.getDefault());
      localc = (com.xiaoenai.app.feature.photoalbum.b.c)localList.get(j);
      str = localSimpleDateFormat.format(localc.c());
      if (TextUtils.equals((CharSequence)localObject, str)) {
        break label331;
      }
      k = j + i;
      this.b.add(new a(localc, true, 0, k, this.e.contains(Integer.valueOf(k))));
      i += 1;
      localObject = str;
    }
    label331:
    for (;;)
    {
      if ((paramList.size() > this.h) && (TextUtils.equals((CharSequence)localObject, localSimpleDateFormat.format(((PhotoAlbum)paramList.get(this.h)).getCreatedTs())))) {
        ((a)this.b.get(k)).d = false;
      }
      this.c.put(str, Integer.valueOf(this.b.size()));
      this.b.add(new a(localc, false, 0, k, this.e.contains(Integer.valueOf(k))));
      j += 1;
      break;
      com.xiaoenai.app.utils.f.a.c("initData {}  {} ", new Object[] { Integer.valueOf(paramList.size()), Integer.valueOf(this.h) });
      this.h = paramList.size();
      notifyDataSetChanged();
      this.a = new d(this);
      return;
    }
  }
  
  private void a(List<PhotoAlbum> paramList, int paramInt)
  {
    Intent localIntent = new Intent(this.f, PhotoPreviewActivity.class);
    int j = paramList.size();
    String[] arrayOfString = new String[j];
    int i = 0;
    while (i < j)
    {
      arrayOfString[i] = ((PhotoAlbum)paramList.get(i)).getUrl();
      i += 1;
    }
    localIntent.putExtra("imageUrls", arrayOfString);
    localIntent.putExtra("position", paramInt);
    localIntent.putExtra(PhotoPreviewActivity.h, PhotoPreviewActivity.f);
    localIntent.putExtra("show_origin", false);
    localIntent.putExtra("image_transfer_type", "image_transfer_type_rxbus");
    com.xiaoenai.app.utils.g.a.a().b(new com.xiaoenai.app.feature.photoalbum.c.a(this.g.e()));
    this.f.startActivityForResult(localIntent, 2);
  }
  
  private void b()
  {
    int i = 0;
    while (i < this.b.size())
    {
      if (((a)this.b.get(i)).c) {
        notifyItemChanged(i);
      }
      i += 1;
    }
  }
  
  public a a(int paramInt)
  {
    return (a)this.b.get(paramInt);
  }
  
  public com.xiaoenai.app.feature.photoalbum.view.widget.a a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 1)
    {
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(a.e.header_item_table, paramViewGroup, false);
      return new com.xiaoenai.app.feature.photoalbum.view.widget.a(this.f, paramViewGroup, true, this.g);
    }
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(a.e.item_album_table, paramViewGroup, false);
    return new com.xiaoenai.app.feature.photoalbum.view.widget.a(this.f, paramViewGroup, false, this.g);
  }
  
  public void a()
  {
    com.xiaoenai.app.utils.g.a.a().b(com.xiaoenai.app.feature.photoalbum.c.a.class);
  }
  
  public void a(com.xiaoenai.app.feature.photoalbum.view.widget.a parama, int paramInt)
  {
    a locala = (a)this.b.get(paramInt);
    View localView = parama.itemView;
    parama.a(locala, paramInt, this, this.e);
    GridSLM.LayoutParams localLayoutParams = GridSLM.LayoutParams.a(localView.getLayoutParams());
    if (locala.c)
    {
      localLayoutParams.b = (this.d | 0x10);
      localLayoutParams.width = -1;
      localLayoutParams.f = true;
      localLayoutParams.e = true;
    }
    if (locala.a == 0) {}
    for (paramInt = e.a;; paramInt = GridSLM.a)
    {
      localLayoutParams.c(paramInt);
      localLayoutParams.a(120);
      localLayoutParams.b(locala.b);
      localView.setLayoutParams(localLayoutParams);
      parama.setIsRecyclable(true);
      return;
    }
  }
  
  public int getItemCount()
  {
    return this.b.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    if (((a)this.b.get(paramInt)).c) {
      return 1;
    }
    return 0;
  }
  
  public void onClick(View paramView)
  {
    paramView = (a.a)paramView.getTag();
    Object localObject1 = ((a)this.b.get(paramView.f)).e;
    if (this.f.g())
    {
      PhotoAlbum localPhotoAlbum = (PhotoAlbum)((com.xiaoenai.app.feature.photoalbum.b.c)localObject1).d().get(paramView.c);
      Map localMap = this.g.c();
      long l = localPhotoAlbum.getGroupId().longValue();
      Object localObject2 = (Integer)localMap.get(Long.valueOf(l));
      boolean bool;
      label106:
      int j;
      if (localObject2 == null)
      {
        i = 1;
        if (paramView.b) {
          break label304;
        }
        bool = true;
        paramView.b = bool;
        localPhotoAlbum.setIsSelected(Boolean.valueOf(paramView.b));
        localObject2 = paramView.a;
        Resources localResources = paramView.a.getContext().getResources();
        if (!paramView.b) {
          break label310;
        }
        j = a.c.album_item_selected;
        label153:
        ((ImageView)localObject2).setImageDrawable(localResources.getDrawable(j));
        if (!paramView.b) {
          break label318;
        }
        j = ((com.xiaoenai.app.feature.photoalbum.b.c)localObject1).a() + 1;
        label180:
        ((com.xiaoenai.app.feature.photoalbum.b.c)localObject1).a(j);
        if (!paramView.b) {
          break label329;
        }
        this.g.a(Integer.valueOf(paramView.c + paramView.d), Integer.valueOf(localPhotoAlbum.getId().intValue()));
        label222:
        if (((com.xiaoenai.app.feature.photoalbum.b.c)localObject1).d().size() != ((com.xiaoenai.app.feature.photoalbum.b.c)localObject1).a()) {
          break label351;
        }
        localMap.put(Long.valueOf(l), Integer.valueOf(-1));
        if (!((a)this.b.get(paramView.f - 1)).d) {
          this.a.a(paramView.f, true);
        }
      }
      label304:
      label310:
      label318:
      label329:
      label351:
      do
      {
        return;
        i = ((Integer)localObject2).intValue() + 1;
        break;
        bool = false;
        break label106;
        j = a.c.album_item_unselected;
        break label153;
        j = ((com.xiaoenai.app.feature.photoalbum.b.c)localObject1).a() - 1;
        break label180;
        this.g.a(Integer.valueOf(paramView.c + paramView.d));
        break label222;
        localMap.put(Long.valueOf(l), Integer.valueOf(i));
      } while (!((a)this.b.get(paramView.f - 1)).d);
      this.a.a(paramView.f, false);
      return;
    }
    localObject1 = ((com.xiaoenai.app.feature.photoalbum.b.c)localObject1).d();
    int i = paramView.c;
    a((List)localObject1, paramView.d + i);
  }
  
  public static class a
  {
    public int a;
    public int b;
    public boolean c;
    public boolean d = false;
    public com.xiaoenai.app.feature.photoalbum.b.c e;
    
    public a(com.xiaoenai.app.feature.photoalbum.b.c paramc, boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2)
    {
      this.c = paramBoolean1;
      this.e = paramc;
      this.a = paramInt1;
      this.b = paramInt2;
      this.d = paramBoolean2;
    }
  }
  
  static abstract interface b
  {
    public abstract void a(int paramInt, boolean paramBoolean);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\feature\photoalbum\view\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */