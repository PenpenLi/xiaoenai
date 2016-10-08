package android.support.v7.app;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.ListView;

class h
  extends CursorAdapter
{
  private final int d;
  private final int e;
  
  h(a.a parama, Context paramContext, Cursor paramCursor, boolean paramBoolean, ListView paramListView, a parama1)
  {
    super(paramContext, paramCursor, paramBoolean);
    parama = getCursor();
    this.d = parama.getColumnIndexOrThrow(this.c.I);
    this.e = parama.getColumnIndexOrThrow(this.c.J);
  }
  
  public void bindView(View paramView, Context paramContext, Cursor paramCursor)
  {
    ((CheckedTextView)paramView.findViewById(16908308)).setText(paramCursor.getString(this.d));
    paramView = this.a;
    int i = paramCursor.getPosition();
    if (paramCursor.getInt(this.e) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.setItemChecked(i, bool);
      return;
    }
  }
  
  public View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return this.c.b.inflate(a.l(this.b), paramViewGroup, false);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\app\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */