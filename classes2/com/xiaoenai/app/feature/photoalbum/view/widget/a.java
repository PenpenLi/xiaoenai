package com.xiaoenai.app.feature.photoalbum.view.widget;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.xiaoenai.app.domain.PhotoAlbum;
import com.xiaoenai.app.feature.photoalbum.a.c;
import com.xiaoenai.app.feature.photoalbum.a.d;
import com.xiaoenai.app.feature.photoalbum.a.e;
import com.xiaoenai.app.feature.photoalbum.a.f;
import com.xiaoenai.app.feature.photoalbum.preview.PhotoPreviewActivity;
import com.xiaoenai.app.feature.photoalbum.view.a.b.a;
import com.xiaoenai.app.feature.photoalbum.view.activity.PhotoAlbumActivity;
import com.xiaoenai.app.utils.d.t;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class a
  extends RecyclerView.ViewHolder
{
  public TextView a;
  public GridView b;
  public TextView c;
  private final boolean d;
  private b e;
  private int f;
  private PhotoAlbumActivity g;
  private View.OnClickListener h;
  private com.xiaoenai.app.feature.photoalbum.e.c i;
  
  public a(PhotoAlbumActivity paramPhotoAlbumActivity, View paramView, boolean paramBoolean, com.xiaoenai.app.feature.photoalbum.e.c paramc)
  {
    super(paramView);
    this.itemView.setTag(Long.valueOf(0L));
    this.g = paramPhotoAlbumActivity;
    this.d = paramBoolean;
    this.i = paramc;
    if (paramBoolean)
    {
      this.a = ((TextView)paramView.findViewById(a.d.item_album_list_time));
      this.c = ((TextView)paramView.findViewById(a.d.item_album_list_chooser));
      return;
    }
    this.b = ((GridView)paramView.findViewById(a.d.item_album_list_gridview));
  }
  
  private void a(com.xiaoenai.app.feature.photoalbum.b.c paramc, boolean paramBoolean, com.xiaoenai.app.feature.photoalbum.view.a.b paramb)
  {
    paramc = paramc.d();
    int j = 0;
    while (j < paramc.size())
    {
      ((PhotoAlbum)paramc.get(j)).setIsSelected(Boolean.valueOf(paramBoolean));
      j += 1;
    }
    paramb.notifyDataSetChanged();
  }
  
  private void a(List<PhotoAlbum> paramList, int paramInt)
  {
    Intent localIntent = new Intent(this.g, PhotoPreviewActivity.class);
    int k = paramList.size();
    String[] arrayOfString = new String[k];
    int j = 0;
    while (j < k)
    {
      arrayOfString[j] = ((PhotoAlbum)paramList.get(j)).getUrl();
      j += 1;
    }
    localIntent.putExtra("imageUrls", arrayOfString);
    localIntent.putExtra("position", paramInt);
    localIntent.putExtra(PhotoPreviewActivity.h, PhotoPreviewActivity.f);
    localIntent.putExtra("show_origin", false);
    localIntent.putExtra("image_transfer_type", "image_transfer_type_rxbus");
    com.xiaoenai.app.utils.g.a.a().b(new com.xiaoenai.app.feature.photoalbum.c.a(this.i.e()));
    this.g.startActivityForResult(localIntent, 2);
  }
  
  public void a(b.a parama, int paramInt, com.xiaoenai.app.feature.photoalbum.view.a.b paramb, Set<Integer> paramSet)
  {
    int j = 0;
    this.h = paramb;
    this.f = paramInt;
    if (this.d)
    {
      this.a.setText(parama.e.e() + "年" + parama.e.f() + "月");
      if (this.i.d() == 0)
      {
        paramb.a(paramInt).d = false;
        parama.e.a(0);
      }
      TextView localTextView;
      if (parama.d)
      {
        this.c.setText(a.f.album_choose_unable);
        localTextView = this.c;
        if (!this.g.g()) {
          break label175;
        }
      }
      for (;;)
      {
        localTextView.setVisibility(j);
        this.c.setTag(parama);
        this.c.setOnClickListener(new b(this, paramSet, paramInt, paramb));
        return;
        this.c.setText(a.f.album_choose_enable);
        break;
        label175:
        j = 8;
      }
    }
    this.itemView.setPadding(0, t.a(this.g, 20.0F), 0, 0);
    paramSet = (LinearLayout.LayoutParams)this.b.getLayoutParams();
    j = (t.b(this.g) - (t.a(this.g, 8.0F) * 2 - t.a(this.g, 4.0F) * 3)) / 4;
    int k = (int)Math.ceil(parama.e.d().size() / 4.0D);
    paramSet.height = ((j + t.a(this.b.getContext(), 4.0F)) * k - t.a(this.b.getContext(), 4.0F));
    this.b.setLayoutParams(paramSet);
    this.e = new b(this.g, paramInt, parama.e, this.c, parama.e.b(), paramb);
    this.e.a(parama.e.d());
    this.b.setAdapter(this.e);
  }
  
  public class a
  {
    public ImageView a;
    public boolean b = false;
    public int c;
    public int d;
    public int e;
    public int f;
    private ImageView h;
    private List<Integer> i = new ArrayList();
    
    public a(View paramView)
    {
      this.h = ((ImageView)paramView.findViewById(a.d.photo));
      this.a = ((ImageView)paramView.findViewById(a.d.imageSelected));
      this.h.setTag(this);
      this.h.setLayoutParams(a());
    }
    
    private RelativeLayout.LayoutParams a()
    {
      this.e = ((t.b(a.c(a.this)) - (t.a(a.c(a.this), 8.0F) * 2 - t.a(a.c(a.this), 4.0F) * 3)) / 4);
      return new RelativeLayout.LayoutParams(this.e, this.e);
    }
    
    public void a(View.OnClickListener paramOnClickListener)
    {
      this.h.setOnClickListener(paramOnClickListener);
    }
  }
  
  class b
    extends BaseAdapter
  {
    private List<PhotoAlbum> b;
    private int c;
    private TextView d;
    private com.xiaoenai.app.feature.photoalbum.b.c e;
    private com.xiaoenai.app.feature.photoalbum.view.a.b f;
    private int g;
    private PhotoAlbumActivity h;
    
    public b(PhotoAlbumActivity paramPhotoAlbumActivity, int paramInt1, com.xiaoenai.app.feature.photoalbum.b.c paramc, TextView paramTextView, int paramInt2, com.xiaoenai.app.feature.photoalbum.view.a.b paramb)
    {
      this.h = paramPhotoAlbumActivity;
      this.c = paramInt2;
      this.d = paramTextView;
      this.e = paramc;
      this.f = paramb;
      this.g = paramInt1;
    }
    
    public PhotoAlbum a(int paramInt)
    {
      if ((this.b == null) || (this.b.size() == 0)) {
        return null;
      }
      return (PhotoAlbum)this.b.get(paramInt);
    }
    
    public void a(List<PhotoAlbum> paramList)
    {
      this.b = paramList;
      notifyDataSetChanged();
    }
    
    public int getCount()
    {
      if ((this.b == null) || (this.b.size() == 0)) {
        return 0;
      }
      return this.b.size();
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      ImageView localImageView;
      Resources localResources;
      if (paramView == null)
      {
        paramView = LayoutInflater.from(this.h).inflate(a.e.album_image_item, null);
        paramViewGroup = new a.a(a.this, paramView);
        new c(this, paramInt);
        paramViewGroup.a(this.f);
        paramView.setTag(paramViewGroup);
        paramViewGroup.c = paramInt;
        paramViewGroup.d = this.c;
        paramViewGroup.f = this.g;
        paramViewGroup.b = a(paramInt).getIsSelected().booleanValue();
        com.xiaoenai.app.utils.e.b.a(a.a.a(paramViewGroup), a(paramInt).getUrl() + "?imageView/2/w/" + paramViewGroup.e);
        if (!this.h.g()) {
          break label206;
        }
        paramViewGroup.a.setVisibility(0);
        localImageView = paramViewGroup.a;
        localResources = this.h.getResources();
        if (!paramViewGroup.b) {
          break label199;
        }
      }
      label199:
      for (paramInt = a.c.album_items_selected;; paramInt = a.c.album_items_unselected)
      {
        localImageView.setImageDrawable(localResources.getDrawable(paramInt));
        return paramView;
        paramViewGroup = (a.a)paramView.getTag();
        break;
      }
      label206:
      paramViewGroup.a.setVisibility(8);
      return paramView;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\feature\photoalbum\view\widget\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */