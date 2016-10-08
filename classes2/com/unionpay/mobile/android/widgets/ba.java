package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.unionpay.mobile.android.global.a;
import com.unionpay.mobile.android.resource.c;
import com.unionpay.mobile.android.utils.d;
import com.unionpay.mobile.android.utils.e;
import com.unionpay.mobile.android.utils.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ba
{
  private static int a = a.r;
  private static int b = 40;
  private static List<Integer> i = new ArrayList(10);
  private Context c = null;
  private View.OnClickListener d = null;
  private PopupWindow e = null;
  private View f = null;
  private ScrollView g = null;
  private int h = -1;
  private PopupWindow.OnDismissListener j = new bb(this);
  
  static
  {
    int k = 0;
    while (k < 10)
    {
      i.add(Integer.valueOf(k));
      k += 1;
    }
  }
  
  public ba(Context paramContext, View.OnClickListener paramOnClickListener, View paramView)
  {
    this.c = paramContext;
    this.d = paramOnClickListener;
    a = d.a(this.c, 55.0F);
    b = d.a(this.c, 40.0F);
    for (paramOnClickListener = (ViewParent)paramView;; paramOnClickListener = paramOnClickListener.getParent()) {
      if (paramOnClickListener != null)
      {
        if ((paramOnClickListener instanceof ScrollView))
        {
          this.g = ((ScrollView)paramOnClickListener);
          h.a("UPWidgetKeyBoard", "mSV : " + this.g.toString());
          h.a("UPWidgetKeyBoard", "mSV H:" + this.g.getHeight());
          this.f = ((ScrollView)paramOnClickListener).getChildAt(0);
        }
      }
      else
      {
        paramOnClickListener = new RelativeLayout(paramContext);
        new RelativeLayout.LayoutParams(-1, -2).setMargins(0, 0, 0, 0);
        paramOnClickListener.setBackgroundColor(-1342177280);
        paramContext = new RelativeLayout(paramContext);
        paramContext.setBackgroundColor(-13290188);
        paramView = new RelativeLayout.LayoutParams(-1, -2);
        paramView.setMargins(0, 0, 0, 0);
        paramOnClickListener.addView(paramContext, paramView);
        paramContext.addView(new b(this.c), paramView);
        this.e = new PopupWindow(paramOnClickListener, -1, -2, true);
        new RelativeLayout.LayoutParams(-1, -2);
        this.e.setBackgroundDrawable(new BitmapDrawable());
        this.e.setOutsideTouchable(false);
        this.e.setFocusable(false);
        this.e.setOnDismissListener(this.j);
        return;
      }
    }
  }
  
  private static int d()
  {
    int k = a * 4 + b;
    h.c("UPWidgetKeyBoard", "kbH=" + k);
    return k;
  }
  
  public final void a()
  {
    if (this.e != null) {
      this.e.dismiss();
    }
  }
  
  public final void a(View paramView)
  {
    if (this.e != null)
    {
      this.e.showAtLocation(paramView, 80, 0, 0);
      this.e.update();
      if (this.f != null)
      {
        paramView.setVisibility(0);
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.g.getLayoutParams();
        this.h = localMarginLayoutParams.height;
        Rect localRect = new Rect();
        paramView.getWindowVisibleDisplayFrame(localRect);
        localMarginLayoutParams.height = (a.t - localRect.top - a.k - d());
        h.a("UPWidgetKeyBoard", "height = " + localMarginLayoutParams.height);
        localMarginLayoutParams.bottomMargin = d();
        this.g.setLayoutParams(localMarginLayoutParams);
      }
    }
  }
  
  public final boolean b()
  {
    return this.e.isShowing();
  }
  
  private final class a
    extends BaseAdapter
  {
    private a() {}
    
    public final int getCount()
    {
      return ba.c().size() + 2;
    }
    
    public final Object getItem(int paramInt)
    {
      return null;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      int i = 10;
      paramView = new LinearLayout(ba.c(ba.this));
      paramViewGroup = c.a(ba.c(ba.this)).a(1022);
      Object localObject = c.a(ba.c(ba.this)).a(1023);
      paramView.setBackgroundDrawable(e.a(paramViewGroup, (Drawable)localObject, (Drawable)localObject, paramViewGroup));
      paramView.setMinimumHeight(d.a(ba.c(ba.this), 55.0F));
      paramView.setClickable(true);
      paramView.setOnClickListener(ba.d(ba.this));
      paramViewGroup = new LinearLayout.LayoutParams(-1, -1);
      paramViewGroup.gravity = 17;
      if ((paramInt == 9) || (paramInt == 11))
      {
        localObject = new ImageView(ba.c(ba.this));
        if (paramInt == 9) {
          if (paramInt != 9) {
            break label213;
          }
        }
        label213:
        for (paramInt = 1024;; paramInt = 1025)
        {
          ((ImageView)localObject).setImageDrawable(c.a(ba.c(ba.this)).a(paramInt, -1, d.a(ba.c(ba.this), 20.0F)));
          paramView.setId(i);
          paramView.addView((View)localObject, paramViewGroup);
          return paramView;
          i = 20;
          break;
        }
      }
      localObject = new TextView(ba.c(ba.this));
      ((TextView)localObject).setTextColor(-1);
      ((TextView)localObject).getPaint().setFakeBoldText(true);
      ((TextView)localObject).setTextSize(30.0F);
      ((TextView)localObject).setGravity(17);
      i = paramInt;
      if (paramInt == 10) {
        i = 9;
      }
      paramInt = ((Integer)ba.c().get(i)).intValue();
      paramView.setId(paramInt);
      ((TextView)localObject).setText(paramInt);
      paramView.addView((View)localObject, paramViewGroup);
      return paramView;
    }
  }
  
  private final class b
    extends LinearLayout
  {
    public b(Context paramContext)
    {
      super();
      setOrientation(1);
      setBackgroundColor(-11316397);
      this$1 = new LinearLayout.LayoutParams(-1, -2);
      ba.this.gravity = 17;
      LinearLayout localLinearLayout = new LinearLayout(paramContext);
      int i = d.a(paramContext, 5.0F);
      localLinearLayout.setPadding(0, i, 0, i);
      localLinearLayout.setGravity(17);
      localLinearLayout.setBackgroundColor(-13816531);
      localLinearLayout.setOrientation(0);
      i = d.a(paramContext, 24.0F);
      Drawable localDrawable = c.a(paramContext).a(1020, -1, i);
      ImageView localImageView = new ImageView(paramContext);
      localImageView.setImageDrawable(localDrawable);
      localLinearLayout.addView(localImageView);
      addView(localLinearLayout, ba.this);
      Collections.shuffle(ba.c());
      this$1 = new LinearLayout.LayoutParams(-1, -2);
      ba.this.gravity = 17;
      paramContext = new GridView(paramContext);
      paramContext.setNumColumns(3);
      paramContext.setAdapter(new ba.a(ba.this, (byte)0));
      paramContext.setGravity(17);
      paramContext.setStretchMode(2);
      paramContext.setHorizontalScrollBarEnabled(false);
      paramContext.setVerticalScrollBarEnabled(false);
      paramContext.setEnabled(true);
      i = d.a(ba.c(ba.this), 1.0F);
      paramContext.setHorizontalSpacing(i);
      paramContext.setVerticalSpacing(i);
      int j = -i;
      paramContext.setPadding(j, i, j, j);
      addView(paramContext, ba.this);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\widgets\ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */