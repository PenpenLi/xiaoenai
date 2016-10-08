package com.xiaoenai.app.classes.common.image.imagePreview;

import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.ui.photoview.PhotoView;
import com.xiaoenai.app.utils.e.b;
import com.xiaoenai.app.utils.f.a;
import com.xiaoenai.app.utils.g;
import com.xiaoenai.app.widget.TitleBarView;
import com.xiaoenai.app.widget.imagepicker.s;
import java.io.File;
import java.util.HashMap;

public class ak
  extends m
{
  private String[] a;
  private int[] b;
  private int[] c;
  private int d = 0;
  private Button e;
  private ViewPager f;
  private LinearLayout g;
  private int h;
  private boolean i = false;
  private TextView j;
  private TitleBarView k;
  private int l;
  private int m;
  private boolean n = false;
  
  public ak(Activity paramActivity, String[] paramArrayOfString, int[] paramArrayOfInt1, boolean paramBoolean, int[] paramArrayOfInt2, Button paramButton, ViewPager paramViewPager, LinearLayout paramLinearLayout, TextView paramTextView, int paramInt1, TitleBarView paramTitleBarView, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramActivity, paramViewPager);
    this.a = paramArrayOfString;
    this.b = paramArrayOfInt1;
    this.c = paramArrayOfInt2;
    this.e = paramButton;
    this.f = paramViewPager;
    this.g = paramLinearLayout;
    this.j = paramTextView;
    this.h = paramInt1;
    this.i = paramBoolean;
    this.k = paramTitleBarView;
    this.l = paramInt3;
    this.m = paramInt4;
    this.d = a(paramArrayOfInt1);
    d();
    a(paramInt2);
    f(this.d);
    if (this.i)
    {
      paramLinearLayout.setSelected(true);
      a(paramInt2, b(paramArrayOfString[paramInt2]));
    }
    if (f()) {
      c();
    }
  }
  
  private int a(int[] paramArrayOfInt)
  {
    int i1 = 0;
    int i3;
    for (int i2 = 0; i1 < paramArrayOfInt.length; i2 = i3)
    {
      i3 = i2;
      if (paramArrayOfInt[i1] != -1) {
        i3 = i2 + 1;
      }
      i1 += 1;
    }
    return i2;
  }
  
  private void a(int paramInt, long paramLong)
  {
    a.c("============= {} == {} == {}", new Object[] { Boolean.valueOf(this.i), Boolean.valueOf(b(paramInt)), Integer.valueOf(paramInt) });
    if ((this.i) && (b(paramInt)))
    {
      this.j.setText(a().getString(2131100092) + "(" + a(paramLong) + ")");
      return;
    }
    this.j.setText(a().getString(2131100092));
  }
  
  private long b(String paramString)
  {
    return new File(g.a().a(paramString)).length();
  }
  
  private boolean b(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i1;
    if (this.b != null) {
      i1 = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i1 < this.b.length)
      {
        if (this.b[i1] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  private void c()
  {
    this.g.setVisibility(8);
    this.k.setRightButtonVisible(8);
  }
  
  private void c(int paramInt)
  {
    int i1 = 0;
    for (;;)
    {
      if (i1 < this.b.length)
      {
        if (this.b[i1] == -1) {
          this.b[i1] = paramInt;
        }
      }
      else {
        return;
      }
      i1 += 1;
    }
  }
  
  private void d()
  {
    this.k.setRightButtonClickListener(new al(this));
    this.e.setOnClickListener(new am(this));
    this.g.setOnClickListener(new an(this));
    this.f.setOnPageChangeListener(new ao(this));
  }
  
  private void d(int paramInt)
  {
    int i1 = 0;
    for (;;)
    {
      if (i1 < this.b.length)
      {
        if (this.b[i1] == paramInt) {
          this.b[i1] = -1;
        }
      }
      else {
        return;
      }
      i1 += 1;
    }
  }
  
  private void e()
  {
    this.g.setOnClickListener(new aq(this));
  }
  
  private boolean e(int paramInt)
  {
    if (paramInt >= s.a())
    {
      h.c(a(), String.format(a().getString(2131100606), new Object[] { Integer.valueOf(s.a()) }), 1500L);
      return true;
    }
    return false;
  }
  
  private void f(int paramInt)
  {
    StringBuilder localStringBuilder;
    if (paramInt > 0)
    {
      localStringBuilder = new StringBuilder();
      if (this.h == 2)
      {
        localStringBuilder.append(a().getString(2131100610));
        localStringBuilder.append("(");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("/");
        localStringBuilder.append(s.a());
        localStringBuilder.append(")");
        this.e.setText(localStringBuilder.toString());
      }
    }
    do
    {
      return;
      if (this.h == 1)
      {
        localStringBuilder.append(a().getText(2131101071));
        break;
      }
      if (this.h != 3) {
        break;
      }
      localStringBuilder.append(a().getString(2131100136));
      break;
      if (this.h == 2)
      {
        this.e.setText(a().getString(2131100610));
        return;
      }
      if (this.h == 1)
      {
        this.e.setText(a().getText(2131101071));
        return;
      }
    } while (this.h != 3);
    this.e.setText(a().getText(2131100136));
  }
  
  private boolean f()
  {
    if ((this.m != -1) && (this.m == 0)) {}
    while (this.l != 1) {
      return false;
    }
    return true;
  }
  
  public void a(int paramInt)
  {
    if (b(this.c[paramInt]))
    {
      this.k.b(2130837585, 0);
      return;
    }
    this.k.b(2130837586, 0);
  }
  
  public boolean a(String paramString)
  {
    super.a(paramString);
    a("merge_action", 3, this.b, this.i, this.a[this.f.getCurrentItem()]);
    return false;
  }
  
  public int getCount()
  {
    if ((this.a != null) && (this.a.length > 0)) {
      return this.a.length;
    }
    return 0;
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    View localView = a().getLayoutInflater().inflate(2130903149, null);
    ((ViewPager)paramView).addView(localView);
    paramView = (PhotoView)localView.findViewById(2131558985);
    ImageButton localImageButton = (ImageButton)localView.findViewById(2131558986);
    ((Button)localView.findViewById(2131558982)).setVisibility(8);
    localImageButton.setVisibility(8);
    paramView.setOnClickListener(new ap(this));
    a.c("================== {}", new Object[] { this.a[paramInt] });
    b.a(paramView, this.a[paramInt]);
    b().put(Integer.valueOf(paramInt), paramView);
    return localView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\image\imagePreview\ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */