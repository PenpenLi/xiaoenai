package com.adhoc;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.adhoc.adhocsdk.AdhocTracker;
import java.util.Iterator;
import java.util.List;

class l
  implements Runnable
{
  l(k paramk, Context paramContext, MotionEvent paramMotionEvent) {}
  
  public void run()
  {
    if (!(this.a instanceof Activity)) {
      return;
    }
    List localList = k.a(this.c, (Activity)this.a, this.b.getRawX(), this.b.getRawY());
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      if ((localView instanceof TextView))
      {
        String str2 = ((TextView)localView).getText().toString();
        String str1 = str2;
        if (str2.length() > 13) {
          str1 = str2.substring(0, 13) + "...";
        }
        str1 = localView.getId() + "_" + str1 + "_autoclick";
        AdhocTracker.incrementStat(this.a, str1, 1);
        fl.a("自动统计:key_" + str1);
      }
    }
    fl.a("点击view 列表:" + k.a(this.c, localList));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */