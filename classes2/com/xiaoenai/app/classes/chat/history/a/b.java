package com.xiaoenai.app.classes.chat.history.a;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.utils.as;
import com.xiaoenai.app.widget.wheel.WheelView;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class b
  extends Dialog
{
  private static final String a = "%d" + as.a(2131101665);
  private static final String b = "%02d" + as.a(2131100884);
  private static final String c = "%02d" + as.a(2131100103);
  private static int d = 18;
  private static int e = 2011;
  private static int f = d();
  private Context g;
  private a h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private boolean o = false;
  private boolean p = false;
  private boolean q = false;
  private boolean r = false;
  private boolean s = false;
  private boolean t = false;
  private int u;
  private Handler v = new Handler();
  private int w;
  private int x;
  private int y;
  
  public b(Context paramContext, a parama)
  {
    super(paramContext);
    this.g = paramContext;
    this.h = parama;
    getWindow().setBackgroundDrawableResource(2131493206);
    c();
  }
  
  private int a(int paramInt)
  {
    return Integer.valueOf(new DecimalFormat("00").format(paramInt)).intValue();
  }
  
  private void a(int paramInt1, int paramInt2, List<String> paramList1, List<String> paramList2, WheelView paramWheelView)
  {
    if (paramList1.contains(String.valueOf(paramInt1 + 1))) {
      paramWheelView.setViewAdapter(new com.xiaoenai.app.widget.wheel.a.d(this.g, 1, 31, c));
    }
    for (;;)
    {
      paramWheelView.setTextSize(d);
      paramWheelView.setTextColor(-16777216);
      return;
      if (paramList2.contains(String.valueOf(paramInt1 + 1))) {
        paramWheelView.setViewAdapter(new com.xiaoenai.app.widget.wheel.a.d(this.g, 1, 30, c));
      } else if (com.xiaoenai.app.utils.c.c.d(paramInt2)) {
        paramWheelView.setViewAdapter(new com.xiaoenai.app.widget.wheel.a.d(this.g, 1, 29, c));
      } else {
        paramWheelView.setViewAdapter(new com.xiaoenai.app.widget.wheel.a.d(this.g, 1, 28, c));
      }
    }
  }
  
  private void c()
  {
    this.u = UserConfig.getInt("his_recovery_start_ts", Integer.valueOf(-1)).intValue();
    if (this.u != -1)
    {
      localCalendar = Calendar.getInstance();
      localCalendar.clear();
      localCalendar.setTimeInMillis(this.u * 1000L);
      this.i = localCalendar.get(1);
      this.j = (localCalendar.get(2) + 1);
      this.k = localCalendar.get(5);
    }
    Calendar localCalendar = Calendar.getInstance();
    this.l = localCalendar.get(1);
    this.m = (localCalendar.get(2) + 1);
    this.n = localCalendar.get(5);
    requestWindowFeature(1);
  }
  
  private static int d()
  {
    return Calendar.getInstance().get(1);
  }
  
  public void a()
  {
    Object localObject1 = Calendar.getInstance();
    this.w = ((Calendar)localObject1).get(1);
    this.x = ((Calendar)localObject1).get(2);
    this.y = ((Calendar)localObject1).get(5);
    localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).clear();
    if (this.g != null) {
      ((Calendar)localObject1).setTimeInMillis(UserConfig.getInt("im_history_ts", Integer.valueOf(0)).intValue() * 1000L);
    }
    Object localObject3 = Arrays.asList(new String[] { "1", "3", "5", "7", "8", "10", "12" });
    Object localObject4 = Arrays.asList(new String[] { "4", "6", "9", "11" });
    localObject1 = ((LayoutInflater)this.g.getSystemService("layout_inflater")).inflate(2130903156, null);
    ((TextView)((View)localObject1).findViewById(2131558578)).setText(getContext().getString(2131100533));
    WheelView localWheelView1 = (WheelView)((View)localObject1).findViewById(2131559001);
    localWheelView1.setViewAdapter(new com.xiaoenai.app.widget.wheel.a.d(this.g, e, f, a));
    localWheelView1.setCyclic(false);
    localWheelView1.setCurrentItem(f - e);
    WheelView localWheelView2 = (WheelView)((View)localObject1).findViewById(2131559002);
    localWheelView2.setViewAdapter(new com.xiaoenai.app.widget.wheel.a.d(this.g, 1, 12, b));
    localWheelView2.setCyclic(true);
    localWheelView2.setCurrentItem(this.x);
    WheelView localWheelView3 = (WheelView)((View)localObject1).findViewById(2131559003);
    localWheelView3.setCyclic(true);
    a(this.x, this.w, (List)localObject3, (List)localObject4, localWheelView3);
    localWheelView3.setCurrentItem(this.y - 1);
    Object localObject2 = new c(this, (List)localObject3, (List)localObject4, localWheelView3, localWheelView1);
    localObject3 = new f(this, (List)localObject3, (List)localObject4, localWheelView3, localWheelView1, localWheelView2);
    localObject4 = new i(this, localWheelView3);
    localWheelView1.a((com.xiaoenai.app.widget.wheel.d)localObject2);
    localWheelView2.a((com.xiaoenai.app.widget.wheel.d)localObject3);
    localWheelView3.a((com.xiaoenai.app.widget.wheel.d)localObject4);
    localWheelView1.setTextSize(d);
    localWheelView1.setTextColor(-16777216);
    localWheelView2.setTextSize(d);
    localWheelView2.setTextColor(-16777216);
    localWheelView3.setTextSize(d);
    localWheelView3.setTextColor(-16777216);
    localObject2 = (Button)((View)localObject1).findViewById(2131559004);
    localObject3 = (Button)((View)localObject1).findViewById(2131559005);
    ((Button)localObject2).setOnClickListener(new l(this, localWheelView1, localWheelView2, localWheelView3));
    ((Button)localObject3).setOnClickListener(new m(this));
    setContentView((View)localObject1);
    show();
    com.xiaoenai.app.utils.f.a.d("== showDatePicker show==", new Object[0]);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\history\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */