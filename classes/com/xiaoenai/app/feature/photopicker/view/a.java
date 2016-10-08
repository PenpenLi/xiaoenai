package com.xiaoenai.app.feature.photopicker.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaoenai.app.feature.photopicker.a.b;
import com.xiaoenai.app.feature.photopicker.a.c;
import com.xiaoenai.app.feature.photopicker.a.d;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;

public class a
  extends BaseAdapter
{
  private ArrayList<com.xiaoenai.app.feature.photopicker.a.b> a;
  private Context b;
  private a c;
  
  public a(ArrayList<com.xiaoenai.app.feature.photopicker.a.b> paramArrayList, Context paramContext)
  {
    this.a = paramArrayList;
    this.b = paramContext;
  }
  
  private void a(ImageView paramImageView, TextView paramTextView, com.xiaoenai.app.feature.photopicker.a.b paramb)
  {
    com.xiaoenai.app.utils.e.b.a(paramImageView, "file://" + paramb.b(), false, true, this.b.getResources().getDrawable(a.b.space_divider));
    paramImageView = new File(paramb.a());
    paramTextView.setText(String.format(Locale.getDefault(), "%s(%d)", new Object[] { paramImageView.getName(), Integer.valueOf(paramb.c()) }));
  }
  
  public com.xiaoenai.app.feature.photopicker.a.b a(int paramInt)
  {
    if ((this.a != null) && (this.a.size() > 0)) {
      return (com.xiaoenai.app.feature.photopicker.a.b)this.a.get(paramInt);
    }
    return null;
  }
  
  public void a(ArrayList<com.xiaoenai.app.feature.photopicker.a.b> paramArrayList, a parama)
  {
    this.a = paramArrayList;
    this.c = parama;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if ((this.a != null) && (this.a.size() > 0)) {
      return this.a.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.b).inflate(a.d.item_image_dir, null);
      paramView.setTag(paramView);
    }
    for (;;)
    {
      a((ImageView)paramView.findViewById(a.c.image_dir_photo), (TextView)paramView.findViewById(a.c.image_dir_name), (com.xiaoenai.app.feature.photopicker.a.b)this.a.get(paramInt));
      paramView.setOnClickListener(new b(this, paramInt));
      return paramView;
      paramView = (View)paramView.getTag();
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\feature\photopicker\view\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */