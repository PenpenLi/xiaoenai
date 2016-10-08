package com.baidu.location;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

class aw
{
  private static aw a = null;
  private a jdField_do = null;
  private boolean jdField_for = false;
  private String jdField_if = null;
  
  public static aw jdMethod_do()
  {
    if (a == null) {
      a = new aw();
    }
    return a;
  }
  
  public String a()
  {
    return this.jdField_if;
  }
  
  public void jdMethod_for()
  {
    f.getServiceContext().registerReceiver(this.jdField_do, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
  }
  
  public void jdMethod_if()
  {
    if (this.jdField_do != null) {
      f.getServiceContext().unregisterReceiver(this.jdField_do);
    }
    this.jdField_do = null;
  }
  
  public boolean jdMethod_int()
  {
    return this.jdField_for;
  }
  
  public class a
    extends BroadcastReceiver
  {
    public a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      paramContext = paramIntent.getAction();
      for (;;)
      {
        int j;
        try
        {
          if (!paramContext.equals("android.intent.action.BATTERY_CHANGED")) {
            break;
          }
          aw.a(aw.this, false);
          int i = paramIntent.getIntExtra("status", 0);
          j = paramIntent.getIntExtra("plugged", 0);
          switch (i)
          {
          case 2: 
            aw.a(aw.this, null);
          }
        }
        catch (Exception paramContext)
        {
          aw.a(aw.this, null);
          return;
        }
        if (aw.a(aw.this))
        {
          ai.bA().bz();
          return;
          aw.a(aw.this, "4");
          break label188;
          aw.a(aw.this, "3");
          break label188;
          aw.a(aw.this, "6");
          aw.a(aw.this, true);
          continue;
          aw.a(aw.this, "5");
          aw.a(aw.this, true);
        }
        else
        {
          ai.bA().bB();
          return;
          continue;
        }
        label188:
        switch (j)
        {
        }
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\baidu\location\aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */