package com.xiaoenai.app.classes.common.image.imagePreview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.ui.component.view.ProgressView;
import com.xiaoenai.app.ui.photoview.PhotoView;
import com.xiaoenai.app.utils.e.b;
import com.xiaoenai.app.utils.f.a;
import com.xiaoenai.app.widget.TitleBarView;
import java.util.ArrayList;
import java.util.HashMap;

public class z
  extends m
{
  private Context a = null;
  private TitleBarView b;
  private ArrayList<String> c = new ArrayList();
  private ViewPager d;
  private ArrayList<Integer> e = new ArrayList();
  private boolean f = false;
  private boolean g = false;
  
  public z(Activity paramActivity, TitleBarView paramTitleBarView, String[] paramArrayOfString, ViewPager paramViewPager)
  {
    super(paramActivity, paramViewPager);
    this.a = paramActivity;
    this.b = paramTitleBarView;
    this.d = paramViewPager;
    b(paramArrayOfString);
    c();
    e();
  }
  
  public z(Activity paramActivity, TitleBarView paramTitleBarView, String[] paramArrayOfString, ViewPager paramViewPager, boolean paramBoolean)
  {
    super(paramActivity, paramViewPager);
    this.a = paramActivity;
    this.b = paramTitleBarView;
    this.d = paramViewPager;
    this.f = paramBoolean;
    b(paramArrayOfString);
    c();
    e();
  }
  
  private void b(String[] paramArrayOfString)
  {
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      this.c.add(paramArrayOfString[i]);
      i += 1;
    }
  }
  
  private void c()
  {
    this.b.setRightButtonClickListener(new ae(this));
    this.b.setLeftButtonClickListener(new ah(this));
  }
  
  private void d()
  {
    this.c.remove(this.d.getCurrentItem());
    this.e.add(Integer.valueOf(this.d.getCurrentItem()));
    if (this.c.size() <= 0) {
      Xiaoenai.j().k().post(new ai(this));
    }
    notifyDataSetChanged();
    this.b.setTitle(this.d.getCurrentItem() + 1 + "/" + this.c.size());
  }
  
  private void e()
  {
    this.b.a(a().getResources().getDrawable(2130839000), null);
  }
  
  private int[] f()
  {
    int[] arrayOfInt = new int[this.e.size()];
    int i = 0;
    while (i < this.e.size())
    {
      arrayOfInt[i] = ((Integer)this.e.get(i)).intValue();
      i += 1;
    }
    return arrayOfInt;
  }
  
  protected void a(String[] paramArrayOfString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("image_url_array", paramArrayOfString);
    localIntent.putExtra("image_position_array", f());
    a().setResult(-1, localIntent);
    a().finish();
  }
  
  public boolean a(String paramString)
  {
    a.c("================== ForumImageController", new Object[0]);
    Xiaoenai.j().k().post(new aj(this));
    return true;
  }
  
  public int getCount()
  {
    if (this.c.size() > 0) {
      return this.c.size();
    }
    return 0;
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    View localView = a().getLayoutInflater().inflate(2130903149, null);
    ((ViewPager)paramView).addView(localView);
    paramView = (PhotoView)localView.findViewById(2131558985);
    ImageButton localImageButton = (ImageButton)localView.findViewById(2131558986);
    Button localButton = (Button)localView.findViewById(2131558982);
    ProgressView localProgressView = (ProgressView)localView.findViewById(2131558987);
    localButton.setVisibility(8);
    localImageButton.setVisibility(8);
    paramView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    b.a(paramView, (String)this.c.get(paramInt), new aa(this, localProgressView));
    if (this.f)
    {
      paramView.setOnLongClickListener(new ab(this, paramInt));
      paramView.setOnClickListener(new ac(this));
    }
    for (;;)
    {
      b().put(Integer.valueOf(paramInt), paramView);
      return localView;
      paramView.setOnClickListener(new ad(this));
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\image\imagePreview\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */