package com.xiaoenai.app.widget.imagepicker;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaoenai.app.utils.e.b;
import java.io.File;
import java.util.Locale;

public class o
  extends BaseAdapter
{
  private Object[] a;
  private Context b;
  private a c;
  
  public o(Object[] paramArrayOfObject, Context paramContext)
  {
    this.a = paramArrayOfObject;
    this.b = paramContext;
  }
  
  private void a(ImageView paramImageView, TextView paramTextView, ImageDirEntry paramImageDirEntry)
  {
    b.a(paramImageView, "file://" + paramImageDirEntry.b(), false, true, this.b.getResources().getDrawable(2130839103));
    paramImageView = new File(paramImageDirEntry.a());
    paramTextView.setText(String.format(Locale.getDefault(), "%s(%d)", new Object[] { paramImageView.getName(), Integer.valueOf(paramImageDirEntry.c()) }));
  }
  
  public void a(Object[] paramArrayOfObject, a parama)
  {
    this.a = paramArrayOfObject;
    this.c = parama;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if ((this.a != null) && (this.a.length > 0)) {
      return this.a.length;
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.a != null) && (this.a.length > 0)) {
      return this.a[paramInt];
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.b).inflate(2130903146, null);
      paramView.setTag(paramView);
    }
    for (;;)
    {
      a((ImageView)paramView.findViewById(2131558971), (TextView)paramView.findViewById(2131558972), (ImageDirEntry)this.a[paramInt]);
      paramView.setOnClickListener(new p(this, paramInt));
      return paramView;
      paramView = (View)paramView.getTag();
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\widget\imagepicker\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */