package android.support.v7.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

class an
  implements AdapterView.OnItemSelectedListener
{
  an(ListPopupWindow paramListPopupWindow) {}
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt != -1)
    {
      paramAdapterView = ListPopupWindow.access$600(this.a);
      if (paramAdapterView != null) {
        ListPopupWindow.a.a(paramAdapterView, false);
      }
    }
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */