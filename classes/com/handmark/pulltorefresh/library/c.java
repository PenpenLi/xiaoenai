package com.handmark.pulltorefresh.library;

import android.graphics.drawable.Drawable;
import com.handmark.pulltorefresh.library.internal.f;
import java.util.HashSet;
import java.util.Iterator;

public class c
  implements b
{
  private final HashSet<f> a = new HashSet();
  
  public void a(f paramf)
  {
    if (paramf != null) {
      this.a.add(paramf);
    }
  }
  
  public void setLastUpdatedLabel(CharSequence paramCharSequence)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((f)localIterator.next()).setLastUpdatedLabel(paramCharSequence);
    }
  }
  
  public void setLoadingDrawable(Drawable paramDrawable)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((f)localIterator.next()).setLoadingDrawable(paramDrawable);
    }
  }
  
  public void setPullLabel(CharSequence paramCharSequence)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((f)localIterator.next()).setPullLabel(paramCharSequence);
    }
  }
  
  public void setRefreshingLabel(CharSequence paramCharSequence)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((f)localIterator.next()).setRefreshingLabel(paramCharSequence);
    }
  }
  
  public void setReleaseLabel(CharSequence paramCharSequence)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((f)localIterator.next()).setReleaseLabel(paramCharSequence);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\handmark\pulltorefresh\library\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */