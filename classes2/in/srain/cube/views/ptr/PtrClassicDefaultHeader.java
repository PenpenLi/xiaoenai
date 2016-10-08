package in.srain.cube.views.ptr;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import in.srain.cube.views.ptr.a.a;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PtrClassicDefaultHeader
  extends FrameLayout
  implements d
{
  private static SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  private int b = 150;
  private RotateAnimation c;
  private RotateAnimation d;
  private TextView e;
  private View f;
  private View g;
  private long h = -1L;
  private TextView i;
  private String j;
  private boolean k;
  private a l = new a(null);
  
  public PtrClassicDefaultHeader(Context paramContext)
  {
    super(paramContext);
    a(null);
  }
  
  public PtrClassicDefaultHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
  }
  
  public PtrClassicDefaultHeader(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
  }
  
  private void a()
  {
    this.c = new RotateAnimation(0.0F, -180.0F, 1, 0.5F, 1, 0.5F);
    this.c.setInterpolator(new LinearInterpolator());
    this.c.setDuration(this.b);
    this.c.setFillAfter(true);
    this.d = new RotateAnimation(-180.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    this.d.setInterpolator(new LinearInterpolator());
    this.d.setDuration(this.b);
    this.d.setFillAfter(true);
  }
  
  private void b()
  {
    c();
    this.g.setVisibility(4);
  }
  
  private void c()
  {
    this.f.clearAnimation();
    this.f.setVisibility(4);
  }
  
  private void d()
  {
    if ((TextUtils.isEmpty(this.j)) || (!this.k))
    {
      this.i.setVisibility(8);
      return;
    }
    String str = getLastUpdateTime();
    if (TextUtils.isEmpty(str))
    {
      this.i.setVisibility(8);
      return;
    }
    this.i.setVisibility(0);
    this.i.setText(str);
  }
  
  private void e(PtrFrameLayout paramPtrFrameLayout)
  {
    if (!paramPtrFrameLayout.h())
    {
      this.e.setVisibility(0);
      this.e.setText(g.c.cube_ptr_release_to_refresh);
    }
  }
  
  private void f(PtrFrameLayout paramPtrFrameLayout)
  {
    this.e.setVisibility(0);
    if (paramPtrFrameLayout.h())
    {
      this.e.setText(getResources().getString(g.c.cube_ptr_pull_down_to_refresh));
      return;
    }
    this.e.setText(getResources().getString(g.c.cube_ptr_pull_down));
  }
  
  private String getLastUpdateTime()
  {
    if ((this.h == -1L) && (!TextUtils.isEmpty(this.j))) {
      this.h = getContext().getSharedPreferences("cube_ptr_classic_last_update", 0).getLong(this.j, -1L);
    }
    if (this.h == -1L) {}
    long l1;
    int m;
    do
    {
      return null;
      l1 = new Date().getTime() - this.h;
      m = (int)(l1 / 1000L);
    } while ((l1 < 0L) || (m <= 0));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getContext().getString(g.c.cube_ptr_last_update));
    if (m < 60) {
      localStringBuilder.append(m + getContext().getString(g.c.cube_ptr_seconds_ago));
    }
    for (;;)
    {
      return localStringBuilder.toString();
      m /= 60;
      if (m > 60)
      {
        m /= 60;
        if (m > 24)
        {
          Date localDate = new Date(this.h);
          localStringBuilder.append(a.format(localDate));
        }
        else
        {
          localStringBuilder.append(m + getContext().getString(g.c.cube_ptr_hours_ago));
        }
      }
      else
      {
        localStringBuilder.append(m + getContext().getString(g.c.cube_ptr_minutes_ago));
      }
    }
  }
  
  protected void a(AttributeSet paramAttributeSet)
  {
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, g.d.PtrClassicHeader, 0, 0);
    if (paramAttributeSet != null) {
      this.b = paramAttributeSet.getInt(0, this.b);
    }
    a();
    paramAttributeSet = LayoutInflater.from(getContext()).inflate(g.b.cube_ptr_classic_default_header, this);
    this.f = paramAttributeSet.findViewById(g.a.ptr_classic_header_rotate_view);
    this.e = ((TextView)paramAttributeSet.findViewById(g.a.ptr_classic_header_rotate_view_header_title));
    this.i = ((TextView)paramAttributeSet.findViewById(g.a.ptr_classic_header_rotate_view_header_last_update));
    this.g = paramAttributeSet.findViewById(g.a.ptr_classic_header_rotate_view_progressbar);
    b();
  }
  
  public void a(PtrFrameLayout paramPtrFrameLayout)
  {
    b();
    this.k = true;
    d();
  }
  
  public void a(PtrFrameLayout paramPtrFrameLayout, boolean paramBoolean, byte paramByte, a parama)
  {
    int m = paramPtrFrameLayout.getOffsetToRefresh();
    int n = parama.k();
    int i1 = parama.j();
    if ((n < m) && (i1 >= m)) {
      if ((paramBoolean) && (paramByte == 2))
      {
        f(paramPtrFrameLayout);
        if (this.f != null)
        {
          this.f.clearAnimation();
          this.f.startAnimation(this.d);
        }
      }
    }
    do
    {
      do
      {
        return;
      } while ((n <= m) || (i1 > m) || (!paramBoolean) || (paramByte != 2));
      e(paramPtrFrameLayout);
    } while (this.f == null);
    this.f.clearAnimation();
    this.f.startAnimation(this.c);
  }
  
  public void b(PtrFrameLayout paramPtrFrameLayout)
  {
    this.k = true;
    d();
    a.a(this.l);
    this.g.setVisibility(4);
    this.f.setVisibility(0);
    this.e.setVisibility(0);
    if (paramPtrFrameLayout.h())
    {
      this.e.setText(getResources().getString(g.c.cube_ptr_pull_down_to_refresh));
      return;
    }
    this.e.setText(getResources().getString(g.c.cube_ptr_pull_down));
  }
  
  public void c(PtrFrameLayout paramPtrFrameLayout)
  {
    this.k = false;
    c();
    this.g.setVisibility(0);
    this.e.setVisibility(0);
    this.e.setText(g.c.cube_ptr_refreshing);
    d();
    a.b(this.l);
  }
  
  public void d(PtrFrameLayout paramPtrFrameLayout)
  {
    c();
    this.g.setVisibility(4);
    this.e.setVisibility(0);
    this.e.setText(getResources().getString(g.c.cube_ptr_refresh_complete));
    paramPtrFrameLayout = getContext().getSharedPreferences("cube_ptr_classic_last_update", 0);
    if (!TextUtils.isEmpty(this.j))
    {
      this.h = new Date().getTime();
      paramPtrFrameLayout.edit().putLong(this.j, this.h).commit();
    }
  }
  
  public void setLastUpdateTimeKey(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.j = paramString;
  }
  
  public void setLastUpdateTimeRelateObject(Object paramObject)
  {
    setLastUpdateTimeKey(paramObject.getClass().getName());
  }
  
  public void setRotateAniTime(int paramInt)
  {
    if ((paramInt == this.b) || (paramInt == 0)) {
      return;
    }
    this.b = paramInt;
    a();
  }
  
  private class a
    implements Runnable
  {
    private boolean b = false;
    
    private a() {}
    
    private void a()
    {
      if (TextUtils.isEmpty(PtrClassicDefaultHeader.a(PtrClassicDefaultHeader.this))) {
        return;
      }
      this.b = true;
      run();
    }
    
    private void b()
    {
      this.b = false;
      PtrClassicDefaultHeader.this.removeCallbacks(this);
    }
    
    public void run()
    {
      PtrClassicDefaultHeader.b(PtrClassicDefaultHeader.this);
      if (this.b) {
        PtrClassicDefaultHeader.this.postDelayed(this, 1000L);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\in\srain\cube\views\ptr\PtrClassicDefaultHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */