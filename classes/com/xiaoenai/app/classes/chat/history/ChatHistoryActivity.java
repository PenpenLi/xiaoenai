package com.xiaoenai.app.classes.chat.history;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.stat.c;
import com.xiaoenai.app.ui.a.h;
import java.util.Calendar;

public class ChatHistoryActivity
  extends TitleBarActivity
{
  private Button a;
  private Button b;
  private int c;
  private int i;
  private int j;
  
  private void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if (!isFinishing())
    {
      Intent localIntent = new Intent();
      localIntent.setAction("com.xiaoenai.history.edit.dataAction");
      localIntent.putExtra("year", paramInt1);
      localIntent.putExtra("month", paramInt2);
      localIntent.putExtra("day", paramInt3);
      if (paramString != null) {
        localIntent.putExtra("historyData", paramString);
      }
      localIntent.setClass(this, ChatHisEditActivity.class);
      startActivity(localIntent);
      overridePendingTransition(2130968604, 2130968605);
    }
  }
  
  private void d()
  {
    h localh = h.a(this);
    localh.a(2131100622);
    localh.show();
    new r(this, x.a(this.c, this.i, this.j), "prev", localh, new p(this), false).execute(new Object[0]);
  }
  
  public int a()
  {
    return 2130903096;
  }
  
  public void c()
  {
    this.a = ((Button)findViewById(2131558772));
    this.b = ((Button)findViewById(2131558773));
    this.a.setOnClickListener(new o(this));
    Calendar localCalendar = Calendar.getInstance();
    this.c = localCalendar.get(1);
    this.i = localCalendar.get(2);
    this.j = localCalendar.get(5);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("from");
    if ((paramBundle != null) && (paramBundle.equals("chat"))) {}
    for (this.f = 2;; this.f = 1)
    {
      c();
      c.a().a(103);
      return;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\chat\history\ChatHistoryActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */