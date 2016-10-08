package com.xiaoenai.app.classes.chat.history;

import android.content.Intent;
import android.hardware.SensorEvent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.chat.BaseChatActivity;
import com.xiaoenai.app.classes.chat.av.a;
import com.xiaoenai.app.classes.chat.messagelist.message.model.o;
import com.xiaoenai.app.utils.ak;
import com.xiaoenai.app.widget.TitleBarView;
import java.util.Calendar;
import java.util.Vector;

public class ChatHisEditActivity
  extends BaseChatActivity
  implements av.a
{
  private TextView b;
  private TextView c;
  private TextView i;
  private TextView j;
  private TextView k;
  private ListView l;
  private u m;
  private int n;
  private int o;
  private int s;
  private Vector<com.xiaoenai.app.classes.chat.messagelist.message.a.a> t;
  private w u;
  private int v = 0;
  
  public int a()
  {
    return 2130903097;
  }
  
  public String a(Integer... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i1 = 0;
    if (i1 < paramVarArgs.length)
    {
      if (i1 == paramVarArgs.length - 1) {
        localStringBuilder.append(paramVarArgs[i1]);
      }
      for (;;)
      {
        i1 += 1;
        break;
        localStringBuilder.append(paramVarArgs[i1]);
        localStringBuilder.append("/");
      }
    }
    return localStringBuilder.toString();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.n = paramInt1;
    this.o = (paramInt2 + 1);
    this.s = paramInt3;
  }
  
  public void a(View paramView, com.xiaoenai.app.classes.chat.messagelist.message.a.a parama)
  {
    if (parama.b().equals("voice"))
    {
      com.xiaoenai.app.utils.f.a.c("content = {}", new Object[] { parama.c() });
      a((o)parama);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      this.m.a(this.t.toArray(), paramBoolean);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  protected void b()
  {
    super.b();
    this.o += 1;
    this.g.setTitle(a(new Integer[] { Integer.valueOf(this.n), Integer.valueOf(this.o), Integer.valueOf(this.s) }));
    q();
  }
  
  public void b(View paramView, com.xiaoenai.app.classes.chat.messagelist.message.a.a parama) {}
  
  public void b(boolean paramBoolean)
  {
    c(paramBoolean);
    if (paramBoolean)
    {
      this.g.setLeftButtonVisible(8);
      this.g.setRightButtonVisible(8);
      return;
    }
    this.g.setLeftButtonVisible(0);
    this.g.setRightButtonVisible(0);
  }
  
  public void c(boolean paramBoolean)
  {
    int i2 = 8;
    int i1;
    if (paramBoolean)
    {
      i1 = 0;
      if (!paramBoolean) {
        break label69;
      }
    }
    for (;;)
    {
      this.j.setVisibility(i1);
      this.k.setVisibility(i1);
      this.b.setVisibility(i2);
      this.c.setVisibility(i2);
      this.i.setVisibility(i2);
      this.g.setTitle(2131100540);
      return;
      i1 = 8;
      break;
      label69:
      i2 = 0;
    }
  }
  
  public void f(o paramo)
  {
    if (paramo == null) {
      return;
    }
    runOnUiThread(new n(this, paramo));
  }
  
  protected void i()
  {
    if ((this.m != null) && (!isFinishing())) {
      this.m.a();
    }
  }
  
  public void o()
  {
    this.b = ((TextView)findViewById(2131558775));
    this.c = ((TextView)findViewById(2131558776));
    this.i = ((TextView)findViewById(2131558777));
    this.j = ((TextView)findViewById(2131558778));
    this.k = ((TextView)findViewById(2131558779));
    this.l = ((ListView)findViewById(2131558780));
    this.m = new u(this, this.t.toArray(), new a(this));
    this.m.a(this);
    this.l.setAdapter(this.m);
    this.j.setOnClickListener(new b(this));
    this.c.setOnClickListener(new c(this));
    this.k.setOnClickListener(new f(this));
    this.b.setOnClickListener(new h(this));
    this.i.setOnClickListener(new j(this));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Object localObject;
    String str;
    if ((getIntent() != null) && (getIntent().getAction().equals("com.xiaoenai.history.edit.dataAction")))
    {
      localObject = getIntent();
      str = ((Intent)localObject).getStringExtra("historyData");
      this.n = ((Intent)localObject).getIntExtra("year", 0);
      this.o = ((Intent)localObject).getIntExtra("month", 0);
      this.s = ((Intent)localObject).getIntExtra("day", 0);
      if ((str != null) && (!str.equals(""))) {
        break label133;
      }
      this.u = new w();
      this.u.a((int)ak.b());
    }
    for (this.t = new Vector();; this.t = this.u.b())
    {
      super.onCreate(paramBundle);
      o();
      this.l.setSelectionAfterHeaderView();
      return;
      label133:
      this.u = com.xiaoenai.app.utils.l.a(str);
      localObject = x.a(this.u.a());
      this.n = ((Calendar)localObject).get(1);
      this.o = ((Calendar)localObject).get(2);
      this.s = ((Calendar)localObject).get(5);
    }
  }
  
  protected void onDestroy()
  {
    this.t = null;
    this.m.c();
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (!Xiaoenai.j().o()) {
      super.onSensorChanged(paramSensorEvent);
    }
  }
  
  public w p()
  {
    return this.u;
  }
  
  public void q()
  {
    this.g.setLeftButtonClickListener(new l(this));
    this.g.setRightButtonClickListener(new m(this));
  }
  
  public void r()
  {
    super.r();
    if (this.m != null) {
      this.m.i();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\chat\history\ChatHisEditActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */