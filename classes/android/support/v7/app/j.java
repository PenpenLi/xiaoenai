package android.support.v7.app;

import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

class j
  implements AdapterView.OnItemClickListener
{
  j(a.a parama, ListView paramListView, a parama1) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.c.C != null) {
      this.c.C[paramInt] = this.a.isItemChecked(paramInt);
    }
    this.c.G.onClick(a.g(this.b), paramInt, this.a.isItemChecked(paramInt));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\app\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */