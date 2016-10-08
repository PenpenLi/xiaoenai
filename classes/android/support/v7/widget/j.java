package android.support.v7.widget;

import android.database.DataSetObserver;

class j
  extends DataSetObserver
{
  j(ActivityChooserView paramActivityChooserView) {}
  
  public void onChanged()
  {
    super.onChanged();
    ActivityChooserView.access$000(this.a).notifyDataSetChanged();
  }
  
  public void onInvalidated()
  {
    super.onInvalidated();
    ActivityChooserView.access$000(this.a).notifyDataSetInvalidated();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */