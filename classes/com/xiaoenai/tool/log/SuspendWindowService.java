package com.xiaoenai.tool.log;

import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.os.Binder;
import android.os.IBinder;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import java.util.LinkedList;

public class SuspendWindowService
  extends Service
  implements View.OnTouchListener
{
  private static int e = 100;
  private f a;
  private LinkedList<String> b;
  private ArrayAdapter<String> c;
  private ListView d;
  
  public IBinder onBind(Intent paramIntent)
  {
    return new a(null);
  }
  
  public void onCreate()
  {
    if (this.a == null)
    {
      LinearLayout localLinearLayout = new LinearLayout(getApplicationContext());
      localLinearLayout.setOrientation(1);
      localLinearLayout.setBackgroundColor(Color.parseColor("#80000000"));
      TextView localTextView = new TextView(getApplicationContext());
      localTextView.setText("点此拖动");
      localLinearLayout.addView(localTextView);
      this.d = new ListView(getApplicationContext());
      this.d.setDividerHeight(1);
      this.d.setStackFromBottom(true);
      this.b = new LinkedList();
      this.c = new ArrayAdapter(getApplicationContext(), c.a.suspend_window_text_view, this.b);
      this.d.setAdapter(this.c);
      localLinearLayout.addView(this.d);
      this.a = new f(getApplicationContext(), localLinearLayout, -1, -1);
      localTextView.setOnTouchListener(this);
    }
    super.onCreate();
  }
  
  public void onDestroy()
  {
    this.a.c();
    super.onDestroy();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    this.a.b();
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      this.a.a();
      return true;
      float f1 = paramMotionEvent.getRawX();
      float f2 = paramMotionEvent.getRawY();
      this.a.a(f1);
      this.a.b(f2);
    }
  }
  
  private class a
    extends Binder
    implements a
  {
    private a() {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\tool\log\SuspendWindowService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */