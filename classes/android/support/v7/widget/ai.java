package android.support.v7.widget;

import android.view.View;

class ai
{
  boolean a = true;
  int b;
  int c;
  int d;
  int e;
  int f = 0;
  int g = 0;
  boolean h;
  boolean i;
  
  View a(RecyclerView.Recycler paramRecycler)
  {
    paramRecycler = paramRecycler.getViewForPosition(this.c);
    this.c += this.d;
    return paramRecycler;
  }
  
  boolean a(RecyclerView.State paramState)
  {
    return (this.c >= 0) && (this.c < paramState.getItemCount());
  }
  
  public String toString()
  {
    return "LayoutState{mAvailable=" + this.b + ", mCurrentPosition=" + this.c + ", mItemDirection=" + this.d + ", mLayoutDirection=" + this.e + ", mStartLine=" + this.f + ", mEndLine=" + this.g + '}';
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */