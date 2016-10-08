package android.support.v7.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;

class u
  implements AdapterView.OnItemClickListener
{
  u(AppCompatSpinner.b paramb, AppCompatSpinner paramAppCompatSpinner) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.b.a.setSelection(paramInt);
    if (this.b.a.getOnItemClickListener() != null) {
      this.b.a.performItemClick(paramView, paramInt, AppCompatSpinner.b.a(this.b).getItemId(paramInt));
    }
    this.b.dismiss();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */