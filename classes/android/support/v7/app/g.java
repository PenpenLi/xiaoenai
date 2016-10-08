package android.support.v7.app;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

class g
  extends ArrayAdapter<CharSequence>
{
  g(a.a parama, Context paramContext, int paramInt1, int paramInt2, CharSequence[] paramArrayOfCharSequence, ListView paramListView)
  {
    super(paramContext, paramInt1, paramInt2, paramArrayOfCharSequence);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = super.getView(paramInt, paramView, paramViewGroup);
    if ((this.b.C != null) && (this.b.C[paramInt] != 0)) {
      this.a.setItemChecked(paramInt, true);
    }
    return paramView;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\app\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */