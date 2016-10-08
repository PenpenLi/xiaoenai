package com.xiaoenai.app.classes.extentions.anniversary;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.ak;
import com.xiaoenai.app.utils.as;
import com.xiaoenai.app.utils.f.a;
import com.xiaoenai.app.widget.wheel.WheelView;
import com.xiaoenai.app.widget.wheel.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class DatePickerView
  extends LinearLayout
{
  private int A;
  private int B;
  private int C;
  private int D;
  private int E;
  private int F;
  private String[] G;
  private List<String> H;
  private List<String> I;
  private b J;
  b a = new al(this);
  b b = new am(this);
  b c = new an(this);
  b d = new ao(this);
  b e = new ap(this);
  b f = new aq(this);
  com.xiaoenai.app.widget.wheel.d g = new ar(this);
  final String[] h = { "正月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "冬月", "腊月" };
  final String[] i = { "初一", "初二", "初三", "初四", "初五", "初六", "初七", "初八", "初九", "初十", "十一", "十二", "十三", "十四", "十五", "十六", "十七", "十八", "十九", "二十", "廿一", "廿二", "廿三", "廿四", "廿五", "廿六", "廿七", "廿八", "廿九", "三十" };
  final String[] j = { "初一", "初二", "初三", "初四", "初五", "初六 ", "初七", "初八", "初九", "初十", "十一", "十二", "十三", "十四", "十五", "十六", "十七", "十八", "十九", "二十", "廿一", "廿二", "廿三", "廿四", "廿五", "廿六", "廿七", "廿八", "廿九" };
  private final String k = "%d" + as.a(2131101665);
  private final String l = "%02d" + as.a(2131100884);
  private final String m = "%02d" + as.a(2131100103);
  private long n = 0L;
  private long o;
  private long p = 0L;
  private boolean q = false;
  private int r = 20;
  private int s = 1970;
  private int t = 2038;
  private WheelView u;
  private WheelView v;
  private WheelView w;
  private int x;
  private int y;
  private int z;
  
  public DatePickerView(Context paramContext)
  {
    super(paramContext);
    d();
  }
  
  public DatePickerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    d();
  }
  
  private int a(int paramInt)
  {
    Paint localPaint = new Paint();
    localPaint.setTypeface(Typeface.DEFAULT);
    localPaint.setTextSize(paramInt);
    int i1 = paramInt;
    if (localPaint.measureText("1966(丙午年)") > ab.b() * 4 / 8) {
      i1 = a(paramInt - 1);
    }
    return i1;
  }
  
  private void a(boolean paramBoolean)
  {
    int[] arrayOfInt;
    if (paramBoolean)
    {
      this.A = (this.s + this.u.getCurrentItem());
      this.B = this.v.getCurrentItem();
      this.C = (this.w.getCurrentItem() + 1);
      arrayOfInt = com.xiaoenai.app.utils.c.c.b(this.C, this.B + 1, this.A);
      if (arrayOfInt != null)
      {
        if (arrayOfInt[3] != 1) {
          break label130;
        }
        this.E = (arrayOfInt[1] + 1);
      }
      for (;;)
      {
        this.F = arrayOfInt[0];
        this.D = arrayOfInt[2];
        this.x = (this.D - this.s);
        this.y = (this.E - 1);
        this.z = (this.F - 1);
        return;
        label130:
        i1 = com.xiaoenai.app.utils.c.c.e(arrayOfInt[2]);
        if ((i1 != Integer.MIN_VALUE) && (i1 < arrayOfInt[1])) {
          this.E = (arrayOfInt[1] + 1);
        } else {
          this.E = arrayOfInt[1];
        }
      }
    }
    this.D = (this.s + this.u.getCurrentItem());
    this.E = (this.v.getCurrentItem() + 1);
    this.F = (this.w.getCurrentItem() + 1);
    int i1 = com.xiaoenai.app.utils.c.c.e(this.D);
    if ((i1 != Integer.MIN_VALUE) && (this.E > i1)) {
      if (this.E - 1 == i1) {
        arrayOfInt = com.xiaoenai.app.utils.c.c.a(this.F, i1, this.D, true);
      }
    }
    for (;;)
    {
      if (arrayOfInt != null)
      {
        this.A = arrayOfInt[2];
        this.B = (arrayOfInt[1] - 1);
        this.C = arrayOfInt[0];
      }
      this.x = (this.A - this.s);
      this.y = this.B;
      this.z = (this.C - 1);
      return;
      arrayOfInt = com.xiaoenai.app.utils.c.c.a(this.F, this.E - 1, this.D, false);
      continue;
      arrayOfInt = com.xiaoenai.app.utils.c.c.a(this.F, this.E, this.D, false);
    }
  }
  
  private String b(int paramInt)
  {
    return "闰" + new String[] { "一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "十二" }[(paramInt - 1)] + "月";
  }
  
  private void d()
  {
    View localView = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(2130903167, this);
    this.u = ((WheelView)localView.findViewById(2131559001));
    this.v = ((WheelView)localView.findViewById(2131559002));
    this.w = ((WheelView)localView.findViewById(2131559003));
    this.u.setCyclic(false);
    this.u.setVisibleItems(5);
    this.v.setCyclic(true);
    this.v.setVisibleItems(5);
    this.w.setCyclic(true);
    this.w.setVisibleItems(5);
    this.r = a(this.r);
    a.c("fontSize{}", new Object[] { Integer.valueOf(this.r) });
    e();
    this.x = (this.A - this.s);
    this.y = this.B;
    this.z = (this.C - 1);
    this.H = Arrays.asList(new String[] { "1", "3", "5", "7", "8", "10", "12" });
    this.I = Arrays.asList(new String[] { "4", "6", "9", "11" });
    this.u.a(this.g);
    this.v.a(this.g);
    this.w.a(this.g);
    f();
  }
  
  private void e()
  {
    Object localObject = Calendar.getInstance();
    if (this.p != 0L)
    {
      ((Calendar)localObject).clear();
      ((Calendar)localObject).setTimeInMillis(this.p);
    }
    this.A = ((Calendar)localObject).get(1);
    this.B = ((Calendar)localObject).get(2);
    this.C = ((Calendar)localObject).get(5);
    localObject = com.xiaoenai.app.utils.c.c.b(this.C, this.B + 1, this.A);
    if (localObject != null)
    {
      if (localObject[3] != 1) {
        break label105;
      }
      this.E = (localObject[1] + 1);
    }
    for (;;)
    {
      this.D = localObject[2];
      this.F = localObject[0];
      return;
      label105:
      int i1 = com.xiaoenai.app.utils.c.c.e(localObject[2]);
      if ((i1 != Integer.MIN_VALUE) && (i1 < localObject[1])) {
        this.E = (localObject[1] + 1);
      } else {
        this.E = localObject[1];
      }
    }
  }
  
  private void f()
  {
    this.q = false;
    this.u.b(this.d);
    this.u.a(this.a);
    this.v.b(this.e);
    this.v.a(this.b);
    this.w.b(this.f);
    this.w.a(this.c);
    this.u.setViewAdapter(new c(getContext(), this.s, this.t, this.k));
    this.u.setCurrentItem(this.x);
    this.v.setViewAdapter(new c(getContext(), 1, 12, this.l));
    this.v.setCurrentItem(this.y);
    if (this.H.contains(String.valueOf(this.y + 1))) {
      this.w.setViewAdapter(new c(getContext(), 1, 31, this.m));
    }
    for (;;)
    {
      this.w.setCurrentItem(this.z);
      return;
      if (this.I.contains(String.valueOf(this.y + 1))) {
        this.w.setViewAdapter(new c(getContext(), 1, 30, this.m));
      } else if (com.xiaoenai.app.utils.c.c.d(this.u.getCurrentItem() + this.s)) {
        this.w.setViewAdapter(new c(getContext(), 1, 29, this.m));
      } else {
        this.w.setViewAdapter(new c(getContext(), 1, 28, this.m));
      }
    }
  }
  
  private void g()
  {
    this.x = this.u.getCurrentItem();
    this.y = this.v.getCurrentItem();
    this.z = this.w.getCurrentItem();
    Object localObject1;
    if (this.q) {
      if (this.J != null)
      {
        a locala = (a)this.v.getViewAdapter();
        localObject2 = "";
        localObject1 = localObject2;
        if (locala != null)
        {
          localObject1 = localObject2;
          if (locala.a(this.y) != null) {
            localObject1 = locala.a(this.y).toString();
          }
        }
        localObject2 = (a)this.w.getViewAdapter();
        if ((localObject2 == null) || (((a)localObject2).a(this.z) == null)) {
          break label337;
        }
      }
    }
    label337:
    for (Object localObject2 = ((a)localObject2).a(this.w.getCurrentItem()).toString();; localObject2 = "")
    {
      this.J.a(this.s + this.x + "(" + com.xiaoenai.app.utils.c.d.a(this.s + this.x) + ") " + (String)localObject1 + (String)localObject2);
      this.J.a(this.s + this.x, this.y + 1, this.z + 1);
      do
      {
        return;
        if ((this.o > 0L) && (getDate() > this.o)) {
          h();
        }
        if ((this.n > 0L) && (getDate() < this.n)) {
          i();
        }
      } while (this.J == null);
      this.J.a(this.s + this.x, this.y, this.z + 1);
      this.J.a(com.xiaoenai.app.utils.d.d.d(getDate()));
      return;
    }
  }
  
  private long getDate()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(1, this.s + this.u.getCurrentItem());
    localCalendar.set(2, this.v.getCurrentItem());
    localCalendar.set(5, this.w.getCurrentItem() + 1);
    return localCalendar.getTimeInMillis();
  }
  
  private void h()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.clear();
    localCalendar.setTimeInMillis(this.o);
    this.C = localCalendar.get(5);
    this.B = localCalendar.get(2);
    this.A = localCalendar.get(1);
    this.x = (this.A - this.s);
    this.y = this.B;
    this.z = (this.C - 1);
    this.u.setCurrentItem(this.x);
    this.v.setCurrentItem(this.y);
    this.w.setCurrentItem(this.z);
  }
  
  private void i()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.clear();
    localCalendar.setTimeInMillis(this.n);
    this.C = localCalendar.get(5);
    this.B = localCalendar.get(2);
    this.A = localCalendar.get(1);
    this.x = (this.A - this.s);
    this.y = this.B;
    this.z = (this.C - 1);
    this.u.setCurrentItem(this.x);
    this.v.setCurrentItem(this.y);
    this.w.setCurrentItem(this.z);
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    this.p = paramLong;
    e();
    if (this.q != paramBoolean)
    {
      this.q = paramBoolean;
      if (this.q)
      {
        this.x = (this.D - this.s);
        this.y = (this.E - 1);
        this.z = (this.F - 1);
        c();
      }
      for (;;)
      {
        g();
        return;
        this.x = (this.A - this.s);
        this.y = this.B;
        this.z = (this.C - 1);
        f();
      }
    }
    if (this.q)
    {
      this.x = (this.D - this.s);
      this.y = (this.E - 1);
    }
    for (this.z = (this.F - 1);; this.z = (this.C - 1))
    {
      this.u.setCurrentItem(this.x);
      this.v.setCurrentItem(this.y);
      this.w.setCurrentItem(this.z);
      break;
      this.x = (this.A - this.s);
      this.y = this.B;
    }
  }
  
  public boolean a()
  {
    return this.q;
  }
  
  public void b()
  {
    boolean bool;
    if (!this.q)
    {
      bool = true;
      this.q = bool;
      if (!this.q) {
        break label40;
      }
      a(true);
      c();
    }
    for (;;)
    {
      g();
      return;
      bool = false;
      break;
      label40:
      a(false);
      f();
    }
  }
  
  public void c()
  {
    this.q = true;
    this.u.b(this.a);
    this.u.a(this.d);
    this.v.b(this.b);
    this.v.a(this.e);
    this.w.b(this.c);
    this.w.a(this.f);
    if (this.G == null) {
      this.G = com.xiaoenai.app.utils.c.d.a(this.s, this.t);
    }
    this.u.setViewAdapter(new a(getContext(), this.G));
    this.u.setCurrentItem(this.x);
    int i1 = com.xiaoenai.app.utils.c.c.e(this.x + this.s);
    if (i1 != Integer.MIN_VALUE)
    {
      String str = b(i1);
      ArrayList localArrayList = new ArrayList(13);
      localArrayList.addAll(Arrays.asList(this.h));
      localArrayList.add(i1, str);
      this.v.setViewAdapter(new a(getContext(), localArrayList.toArray(new String[localArrayList.size()])));
      a.c("curMonthIndex: {}", new Object[] { Integer.valueOf(this.y) });
      this.v.setCurrentItem(this.y);
      i1 = com.xiaoenai.app.utils.c.c.e(this.u.getCurrentItem() + this.s);
      if ((i1 == Integer.MIN_VALUE) || (i1 > this.y)) {
        break label404;
      }
      if (this.y != i1) {
        break label381;
      }
      i1 = com.xiaoenai.app.utils.c.c.f(this.u.getCurrentItem() + this.s);
      label297:
      a.c("days:{}", new Object[] { Integer.valueOf(i1) });
      if (i1 >= 30) {
        break label429;
      }
      this.w.setViewAdapter(new a(getContext(), this.j));
    }
    for (;;)
    {
      this.w.setCurrentItem(this.z);
      return;
      this.v.setViewAdapter(new a(getContext(), this.h));
      break;
      label381:
      i1 = com.xiaoenai.app.utils.c.c.b(this.y, this.u.getCurrentItem() + this.s);
      break label297;
      label404:
      i1 = com.xiaoenai.app.utils.c.c.b(this.y + 1, this.u.getCurrentItem() + this.s);
      break label297;
      label429:
      this.w.setViewAdapter(new a(getContext(), this.i));
    }
  }
  
  public long getAdjustDateTs()
  {
    Calendar localCalendar = com.xiaoenai.app.utils.d.d.a();
    localCalendar.set(1, this.s + this.u.getCurrentItem());
    localCalendar.set(2, this.v.getCurrentItem());
    localCalendar.set(5, this.w.getCurrentItem() + 1);
    return ak.g(localCalendar.getTimeInMillis() / 1000L);
  }
  
  public long getDateTs()
  {
    if (this.q)
    {
      this.D = (this.s + this.u.getCurrentItem());
      this.E = (this.v.getCurrentItem() + 1);
      this.F = (this.w.getCurrentItem() + 1);
      int i1 = com.xiaoenai.app.utils.c.c.e(this.D);
      Object localObject;
      if ((i1 != Integer.MIN_VALUE) && (this.E > i1)) {
        if (this.E - 1 == i1) {
          localObject = com.xiaoenai.app.utils.c.c.a(this.F, i1, this.D, true);
        }
      }
      for (;;)
      {
        if (localObject != null)
        {
          this.A = localObject[2];
          this.B = (localObject[1] - 1);
          this.C = localObject[0];
        }
        localObject = Calendar.getInstance();
        ((Calendar)localObject).clear();
        ((Calendar)localObject).set(1, this.A);
        ((Calendar)localObject).set(2, this.B);
        ((Calendar)localObject).set(5, this.C);
        return ((Calendar)localObject).getTimeInMillis();
        localObject = com.xiaoenai.app.utils.c.c.a(this.F, this.E - 1, this.D, false);
        continue;
        localObject = com.xiaoenai.app.utils.c.c.a(this.F, this.E, this.D, false);
      }
    }
    return getDate();
  }
  
  public WheelView getDayWheel()
  {
    return this.w;
  }
  
  public int getEndYear()
  {
    return this.t;
  }
  
  public WheelView getMonthWheel()
  {
    return this.v;
  }
  
  public int getStartYear()
  {
    return this.s;
  }
  
  public WheelView getYearWheel()
  {
    return this.u;
  }
  
  public void setDatePickerListener(b paramb)
  {
    this.J = paramb;
  }
  
  public void setEndYear(int paramInt)
  {
    this.t = paramInt;
  }
  
  public void setMaxDate(long paramLong)
  {
    this.o = paramLong;
  }
  
  public void setMinDate(long paramLong)
  {
    this.n = paramLong;
  }
  
  public void setStartYear(int paramInt)
  {
    this.s = paramInt;
  }
  
  class a<T>
    extends com.xiaoenai.app.widget.wheel.a.c
  {
    public a(T[] paramArrayOfT)
    {
      super(arrayOfObject);
    }
    
    protected void a(TextView paramTextView)
    {
      paramTextView.setTextColor(-16777216);
      paramTextView.setGravity(17);
      paramTextView.setTextSize(DatePickerView.j(DatePickerView.this));
      paramTextView.setLines(1);
      paramTextView.setTypeface(Typeface.SANS_SERIF);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void a(String paramString);
  }
  
  class c
    extends com.xiaoenai.app.widget.wheel.a.d
  {
    public c(Context paramContext, int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt1, paramInt2, paramString);
    }
    
    protected void a(TextView paramTextView)
    {
      paramTextView.setTextColor(-16777216);
      paramTextView.setGravity(17);
      paramTextView.setTextSize(DatePickerView.j(DatePickerView.this));
      paramTextView.setLines(1);
      paramTextView.setTypeface(Typeface.SANS_SERIF);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\anniversary\DatePickerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */