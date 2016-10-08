package com.xiaoenai.app.feature.photoalbum.view.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
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
import com.xiaoenai.app.feature.photoalbum.e.c;
import com.xiaoenai.app.feature.photoalbum.preview.PhotoPreviewActivity;
import com.xiaoenai.app.feature.photoalbum.view.a.e.a;
import com.xiaoenai.app.feature.photoalbum.view.activity.PhotoAlbumActivity;
import com.xiaoenai.app.utils.d.t;
import com.xiaoenai.app.utils.e.b;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class d
  extends RecyclerView.ViewHolder
{
  private TextView a;
  private TextView b;
  private TextView c;
  private TextView d;
  private FrameLayout e;
  private ImageView f;
  private GridView g;
  private TextView h;
  private TextView i;
  private TextView j;
  private View.OnClickListener k;
  private boolean l;
  private PhotoAlbumActivity m;
  private b n;
  private c o;
  
  public d(PhotoAlbumActivity paramPhotoAlbumActivity, View paramView, boolean paramBoolean, View.OnClickListener paramOnClickListener, c paramc)
  {
    super(paramView);
    paramView.setOnClickListener(paramOnClickListener);
    this.o = paramc;
    if (paramBoolean)
    {
      this.a = ((TextView)paramView.findViewById(a.d.tv_date));
      this.b = ((TextView)paramView.findViewById(a.d.tv_month));
      this.c = ((TextView)paramView.findViewById(a.d.tv_year));
      this.d = ((TextView)paramView.findViewById(a.d.tv_anniversary));
      this.e = ((FrameLayout)paramView.findViewById(a.d.fl_anniversary));
      this.f = ((ImageView)paramView.findViewById(a.d.im_circle));
    }
    for (;;)
    {
      this.l = paramBoolean;
      this.m = paramPhotoAlbumActivity;
      return;
      this.g = ((GridView)paramView.findViewById(a.d.item_album_time_alxe_gridview));
      this.h = ((TextView)paramView.findViewById(a.d.item_album_text));
      this.i = ((TextView)paramView.findViewById(a.d.item_album_time));
      this.j = ((TextView)paramView.findViewById(a.d.item_album_choose));
    }
  }
  
  private void a(com.xiaoenai.app.feature.photoalbum.b.d paramd, boolean paramBoolean, com.xiaoenai.app.feature.photoalbum.view.a.e parame)
  {
    paramd = paramd.d();
    int i1 = 0;
    while (i1 < paramd.size())
    {
      ((PhotoAlbum)paramd.get(i1)).setIsSelected(Boolean.valueOf(paramBoolean));
      i1 += 1;
    }
    parame.notifyDataSetChanged();
  }
  
  private void a(List<PhotoAlbum> paramList, int paramInt)
  {
    Intent localIntent = new Intent(this.m, PhotoPreviewActivity.class);
    int i2 = paramList.size();
    Object localObject = new String[i2];
    int i1 = 0;
    while (i1 < i2)
    {
      localObject[i1] = ((PhotoAlbum)paramList.get(i1)).getUrl();
      i1 += 1;
    }
    localIntent.putExtra("imageUrls", (String[])localObject);
    localObject = PhotoPreviewActivity.e;
    if (paramList.size() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra((String)localObject, bool);
      localIntent.putExtra(PhotoPreviewActivity.h, PhotoPreviewActivity.f);
      localIntent.putExtra("position", paramInt);
      localIntent.putExtra("show_origin", false);
      localIntent.putExtra("image_transfer_type", "image_transfer_type_rxbus");
      com.xiaoenai.app.utils.g.a.a().b(new com.xiaoenai.app.feature.photoalbum.c.a(this.o.e()));
      this.m.startActivityForResult(localIntent, 2);
      return;
    }
  }
  
  public void a(e.a parama, com.xiaoenai.app.feature.photoalbum.view.a.e parame, int paramInt)
  {
    long l1 = parama.d.c().longValue();
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(l1);
    if (this.l)
    {
      if (paramInt == 0)
      {
        this.a.setTextColor(Color.rgb(244, 85, 147));
        this.b.setTextColor(Color.rgb(244, 85, 147));
        this.c.setTextColor(Color.rgb(244, 85, 147));
        this.f.setImageResource(a.c.icon_circle_pink);
        if (parama.d.f().length() <= 0) {
          break label272;
        }
        this.d.setText(parama.d.f());
        this.e.setVisibility(0);
      }
      for (;;)
      {
        this.a.setText(com.xiaoenai.app.utils.d.d.i((Calendar)localObject));
        this.b.setText(com.xiaoenai.app.utils.d.d.h((Calendar)localObject) + this.m.getString(a.f.album_month));
        this.c.setText(com.xiaoenai.app.utils.d.d.j((Calendar)localObject));
        this.itemView.setTag(parama);
        return;
        this.a.setTextColor(Color.rgb(51, 51, 51));
        this.b.setTextColor(Color.rgb(175, 175, 175));
        this.c.setTextColor(Color.rgb(175, 175, 175));
        this.f.setImageResource(a.c.icon_circle_white);
        break;
        label272:
        this.e.setVisibility(8);
      }
    }
    if (1 == paramInt) {
      this.itemView.setPadding(0, t.a(this.m, 20.0F), 0, 0);
    }
    if (TextUtils.isEmpty(parama.d.b()))
    {
      this.h.setVisibility(8);
      label331:
      this.i.setText(com.xiaoenai.app.utils.d.d.f((Calendar)localObject));
      localObject = (LinearLayout.LayoutParams)this.g.getLayoutParams();
      paramInt = (t.b(this.m) - (t.a(this.m, 8.0F) * 2 - t.a(this.m, 4.0F) * 2) - t.a(this.m, 85.0F)) / 3;
      int i1 = (int)Math.ceil(parama.d.d().size() / 3.0D);
      ((LinearLayout.LayoutParams)localObject).height = ((paramInt + t.a(this.itemView.getContext(), 4.0F)) * i1 - t.a(this.itemView.getContext(), 4.0F));
      this.g.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (Integer)this.o.c().get(parama.d.a());
      if ((localObject != null) && (-1 == ((Integer)localObject).intValue())) {
        break label637;
      }
      this.j.setText(a.f.album_choose_enable);
      label519:
      this.j.setOnClickListener(new e(this, parama, parame));
      parame = this.j;
      if (!this.m.g()) {
        break label650;
      }
    }
    label637:
    label650:
    for (paramInt = 0;; paramInt = 8)
    {
      parame.setVisibility(paramInt);
      this.n = new b(this.g.getContext(), parama.d.e());
      this.n.a(parama.d.d());
      this.g.setAdapter(this.n);
      break;
      this.h.setVisibility(0);
      this.h.setText(parama.d.b());
      break label331;
      this.j.setText(a.f.album_choose_unable);
      break label519;
    }
  }
  
  class a
  {
    private ImageView b;
    private ImageView c;
    private boolean d;
    private int e;
    
    public a(View paramView)
    {
      this.b = ((ImageView)paramView.findViewById(a.d.photo));
      this.c = ((ImageView)paramView.findViewById(a.d.imageSelected));
      this.b.setTag(this);
      this.b.setLayoutParams(a());
    }
    
    private RelativeLayout.LayoutParams a()
    {
      this.e = ((t.b(d.c(d.this)) - (t.a(d.c(d.this), 8.0F) * 2 - t.a(d.c(d.this), 4.0F) * 2) - t.a(d.c(d.this), 85.0F)) / 3);
      return new RelativeLayout.LayoutParams(this.e, this.e);
    }
    
    public void a(View.OnClickListener paramOnClickListener)
    {
      this.b.setOnClickListener(paramOnClickListener);
    }
  }
  
  class b
    extends BaseAdapter
  {
    private List<PhotoAlbum> b = null;
    private Context c;
    private int d;
    
    public b(Context paramContext, int paramInt)
    {
      this.c = paramContext;
      this.d = paramInt;
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
      if (this.b != null) {
        notifyDataSetChanged();
      }
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
      if (paramView == null)
      {
        paramView = LayoutInflater.from(this.c).inflate(a.e.album_image_item, null);
        paramViewGroup = new d.a(d.this, paramView);
        paramViewGroup.a(new f(this, paramInt));
        paramView.setTag(paramViewGroup);
        b.a(d.a.c(paramViewGroup), a(paramInt).getUrl() + "?imageView/2/w/" + d.a.d(paramViewGroup));
        if (!d.c(d.this).g()) {
          break label188;
        }
        d.a.b(paramViewGroup).setVisibility(0);
        if (a(paramInt).getIsSelected().booleanValue()) {
          d.a.b(paramViewGroup).setImageDrawable(d.c(d.this).getResources().getDrawable(a.c.album_item_selected));
        }
      }
      for (;;)
      {
        d.a.a(paramViewGroup, a(paramInt).getIsSelected().booleanValue());
        paramView.setOnClickListener(d.d(d.this));
        return paramView;
        paramViewGroup = (d.a)paramView.getTag();
        break;
        label188:
        d.a.b(paramViewGroup).setVisibility(8);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\feature\photoalbum\view\widget\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */