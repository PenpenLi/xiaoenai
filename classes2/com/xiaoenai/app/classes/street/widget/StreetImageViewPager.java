package com.xiaoenai.app.classes.street.widget;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Scroller;
import com.xiaoenai.app.classes.street.model.Banner;
import com.xiaoenai.app.classes.street.model.ImageInfo;
import com.xiaoenai.app.ui.component.view.ProgressView;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.e.b;
import com.xiaoenai.app.utils.f.a;
import com.xiaoenai.app.widget.LoopViewPager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class StreetImageViewPager
  extends RelativeLayout
{
  private RelativeLayout a = null;
  private RelativeLayout b = null;
  private Context c = null;
  private LoopViewPager d = null;
  private c e = null;
  private LinearLayout f = null;
  private long g = 0L;
  private Handler h = null;
  private int i = 0;
  private boolean j = true;
  private Banner[] k = null;
  private d l = null;
  private List<Banner> m = new ArrayList();
  private a n = null;
  
  public StreetImageViewPager(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public StreetImageViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public StreetImageViewPager(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(int paramInt)
  {
    a.c("index = {}", new Object[] { Integer.valueOf(paramInt) });
    this.d.a(paramInt, true);
  }
  
  private void a(long paramLong)
  {
    if ((this.k != null) && (this.k.length > 1)) {
      e();
    }
  }
  
  private void a(Context paramContext)
  {
    this.c = paramContext;
    this.a = ((RelativeLayout)RelativeLayout.inflate(paramContext, 2130903344, this));
    this.b = ((RelativeLayout)this.a.findViewById(2131558633));
    this.i = (new Random(System.currentTimeMillis()).nextInt() % 100 + 100);
    a.c("mViewPagerId = {}", new Object[] { Integer.valueOf(this.i) });
    this.d = ((LoopViewPager)findViewById(2131559880));
    this.h = new e(this, this.i);
    this.d.setLoopEnable(true);
    this.f = ((LinearLayout)findViewById(2131559881));
    a(paramContext, this.m);
    setDescendantFocusability(393216);
    b();
    setCenter(true);
  }
  
  private void a(Context paramContext, List<Banner> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.f.removeAllViews();
      if (paramList.size() > 1)
      {
        int i1 = 0;
        if (i1 < paramList.size())
        {
          ImageView localImageView = new ImageView(paramContext);
          localImageView.setFocusable(false);
          localImageView.setFocusableInTouchMode(false);
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(ab.a(6.0F), ab.a(6.0F));
          localLayoutParams.leftMargin = ab.a(3.0F);
          localLayoutParams.rightMargin = ab.a(3.0F);
          localImageView.setLayoutParams(localLayoutParams);
          localImageView.setImageResource(2130838710);
          if (i1 == 0) {
            localImageView.setSelected(true);
          }
          for (;;)
          {
            this.f.addView(localImageView);
            i1 += 1;
            break;
            localImageView.setSelected(false);
          }
        }
      }
      if (this.e != null) {
        break label204;
      }
      this.e = new c(this.c, paramList);
      this.d.setAdapter(this.e);
      this.e.a(this.l);
    }
    for (;;)
    {
      this.d.setCurrentItem(0);
      return;
      label204:
      this.e.a(paramList);
    }
  }
  
  private void b()
  {
    this.d.setOnPageChangeListener(new j(this));
  }
  
  private void c()
  {
    this.h.removeMessages(this.i);
  }
  
  private void d()
  {
    post(new k(this));
  }
  
  private void e()
  {
    this.h.removeMessages(this.i);
    this.h.sendEmptyMessageDelayed(this.i, this.g * 1000L);
  }
  
  public void a()
  {
    if (this.b != null) {
      ((RelativeLayout.LayoutParams)this.b.getLayoutParams()).setMargins(0, 0, 0, 0);
    }
  }
  
  public void a(Banner[] paramArrayOfBanner, long paramLong)
  {
    if ((this.k != null) && (Arrays.equals(this.k, paramArrayOfBanner))) {}
    do
    {
      return;
      this.k = paramArrayOfBanner;
    } while ((paramArrayOfBanner == null) || (paramArrayOfBanner.length <= 0));
    int i1 = ab.b();
    setLayoutParams(new AbsListView.LayoutParams(i1, paramArrayOfBanner[0].getImageInfo().getHeight() * i1 / paramArrayOfBanner[0].getImageInfo().getWidth()));
    this.m.clear();
    i1 = 0;
    while (i1 < paramArrayOfBanner.length)
    {
      if (paramArrayOfBanner[i1] != null)
      {
        this.m.add(paramArrayOfBanner[i1]);
        a.c("banner[{}] = {}", new Object[] { Integer.valueOf(i1), paramArrayOfBanner[i1].getModule() });
        a.c("banner[{}] = {}", new Object[] { Integer.valueOf(i1), paramArrayOfBanner[i1].getTitle() });
        a.c("banner[{}] = {}", new Object[] { Integer.valueOf(i1), paramArrayOfBanner[i1].getClickUrl() });
        a.c("banner[{}] = {}", new Object[] { Integer.valueOf(i1), paramArrayOfBanner[i1].getImageInfo() });
      }
      i1 += 1;
    }
    this.g = paramLong;
    a(this.c, this.m);
    a(paramLong);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    getParent().requestDisallowInterceptTouchEvent(true);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      a(this.g);
      continue;
      c();
    }
  }
  
  public void setCenter(boolean paramBoolean)
  {
    this.j = paramBoolean;
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.b != null)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
      if (this.j) {
        localLayoutParams.setMargins(0, 0, 0, ab.a(getResources().getInteger(2131361797)));
      }
    }
    else
    {
      return;
    }
    int i1 = ab.a(getResources().getInteger(2131361797));
    localLayoutParams.setMargins(0, i1, 0, i1);
  }
  
  public void setOnClickListener(d paramd)
  {
    this.l = paramd;
    if (this.e != null) {
      this.e.a(this.l);
    }
  }
  
  private class a
    extends Scroller
  {
    private int a;
    
    public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.a);
    }
    
    public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      super.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.a);
    }
  }
  
  private class b
    extends RelativeLayout
  {
    private Banner b = null;
    private Context c = null;
    private ImageView d = null;
    private ProgressView e = null;
    private StreetImageViewPager.d f = null;
    
    public b(Context paramContext)
    {
      super();
      a(paramContext);
    }
    
    private void a()
    {
      if ((this.d != null) && (this.b != null) && (this.b.getImageInfo() != null))
      {
        int i = ab.b();
        int j = this.b.getImageInfo().getHeight() * i / this.b.getImageInfo().getWidth();
        String str = this.b.getImageInfo().getUrl() + "?imageView/1/w/" + i + "/h/" + j;
        a.c("url = {}", new Object[] { str });
        b.a(this.d, str, new m(this));
        return;
      }
      a.c(" url = null ", new Object[0]);
    }
    
    private void a(Context paramContext)
    {
      this.c = paramContext;
      setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
      setBackgroundResource(2131493206);
      this.d = new ImageView(paramContext);
      this.d.setFocusable(false);
      this.d.setFocusableInTouchMode(false);
      this.d.setScaleType(ImageView.ScaleType.CENTER_CROP);
      this.e = new ProgressView(paramContext);
      this.e.setFocusable(false);
      this.e.setFocusableInTouchMode(false);
      this.e.b();
      addView(this.d, new RelativeLayout.LayoutParams(-1, -1));
      paramContext = new RelativeLayout.LayoutParams(ab.a(24.0F), ab.a(24.0F));
      paramContext.addRule(13);
      addView(this.e, paramContext);
      this.d.setOnClickListener(new l(this));
    }
    
    public void a(Banner paramBanner)
    {
      if (paramBanner != null)
      {
        this.b = paramBanner;
        a();
      }
    }
    
    public void a(StreetImageViewPager.d paramd)
    {
      this.f = paramd;
    }
  }
  
  private class c
    extends PagerAdapter
  {
    private List<Banner> b = new ArrayList();
    private StreetImageViewPager.d c = null;
    private Context d = null;
    
    public c(List<Banner> paramList)
    {
      this.d = paramList;
      List localList;
      a(localList);
    }
    
    public void a(StreetImageViewPager.d paramd)
    {
      this.c = paramd;
    }
    
    public void a(List<Banner> paramList)
    {
      this.b = paramList;
      notifyDataSetChanged();
    }
    
    public void destroyItem(View paramView, int paramInt, Object paramObject)
    {
      ((LoopViewPager)paramView).removeView((View)paramObject);
    }
    
    public int getCount()
    {
      if (this.b != null) {
        return this.b.size();
      }
      return 0;
    }
    
    public Object instantiateItem(View paramView, int paramInt)
    {
      a.c("position = {}", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt >= 0) {
        paramInt %= this.b.size();
      }
      for (;;)
      {
        StreetImageViewPager.b localb = new StreetImageViewPager.b(StreetImageViewPager.this, this.d);
        localb.a(this.c);
        localb.a((Banner)this.b.get(paramInt));
        ((LoopViewPager)paramView).addView(localb);
        return localb;
        paramInt = this.b.size() - Math.abs(paramInt) % this.b.size() - 1;
      }
    }
    
    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == paramObject;
    }
  }
  
  public static abstract interface d
  {
    public abstract void a(Banner paramBanner);
  }
  
  private class e
    extends Handler
  {
    private int b = 0;
    private final WeakReference<StreetImageViewPager> c;
    
    public e(StreetImageViewPager paramStreetImageViewPager, int paramInt)
    {
      this.c = new WeakReference(paramStreetImageViewPager);
      this.b = paramInt;
    }
    
    public void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      StreetImageViewPager localStreetImageViewPager = (StreetImageViewPager)this.c.get();
      if ((this.b == paramMessage.what) && (localStreetImageViewPager != null)) {
        StreetImageViewPager.f(localStreetImageViewPager);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\StreetImageViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */