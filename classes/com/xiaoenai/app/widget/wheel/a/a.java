package com.xiaoenai.app.widget.wheel.a;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import java.util.LinkedList;
import java.util.List;

public abstract class a
  implements e
{
  private List<DataSetObserver> a;
  
  public View a(View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public void a(DataSetObserver paramDataSetObserver)
  {
    if (this.a == null) {
      this.a = new LinkedList();
    }
    this.a.add(paramDataSetObserver);
  }
  
  public void b(DataSetObserver paramDataSetObserver)
  {
    if (this.a != null) {
      this.a.remove(paramDataSetObserver);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\widget\wheel\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */