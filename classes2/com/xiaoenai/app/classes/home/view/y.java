package com.xiaoenai.app.classes.home.view;

import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import com.xiaoenai.app.classes.home.view.a.a;

class y
  extends GridLayoutManager.SpanSizeLookup
{
  y(LifeServiceLayout paramLifeServiceLayout) {}
  
  public int getSpanSize(int paramInt)
  {
    if ((LifeServiceLayout.a(this.a).a() % 4 > 0) && (paramInt == LifeServiceLayout.a(this.a).getItemCount() - 1)) {
      return 4 - LifeServiceLayout.a(this.a).a() % 4;
    }
    return 1;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\home\view\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */