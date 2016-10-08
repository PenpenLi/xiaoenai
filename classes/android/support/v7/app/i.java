package android.support.v7.app;

import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class i
  implements AdapterView.OnItemClickListener
{
  i(a.a parama, a parama1) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.b.u.onClick(a.g(this.a), paramInt);
    if (!this.b.E) {
      a.g(this.a).dismiss();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\app\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */