package com.bumptech.glide.g.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.WindowManager;
import com.bumptech.glide.g.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class k<T extends View, Z>
  extends a<Z>
{
  private static boolean b = false;
  private static Integer c = null;
  protected final T a;
  private final a d;
  
  public k(T paramT)
  {
    if (paramT == null) {
      throw new NullPointerException("View must not be null!");
    }
    this.a = paramT;
    this.d = new a(paramT);
  }
  
  private Object a()
  {
    if (c == null) {
      return this.a.getTag();
    }
    return this.a.getTag(c.intValue());
  }
  
  private void a(Object paramObject)
  {
    if (c == null)
    {
      b = true;
      this.a.setTag(paramObject);
      return;
    }
    this.a.setTag(c.intValue(), paramObject);
  }
  
  public void a(h paramh)
  {
    this.d.a(paramh);
  }
  
  public void a(c paramc)
  {
    a(paramc);
  }
  
  public c b()
  {
    Object localObject = a();
    if (localObject != null)
    {
      if ((localObject instanceof c)) {
        return (c)localObject;
      }
      throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }
    return null;
  }
  
  public String toString()
  {
    return "Target for: " + this.a;
  }
  
  private static class a
  {
    private final View a;
    private final List<h> b = new ArrayList();
    private a c;
    private Point d;
    
    public a(View paramView)
    {
      this.a = paramView;
    }
    
    private int a(int paramInt, boolean paramBoolean)
    {
      if (paramInt == -2)
      {
        Point localPoint = d();
        if (paramBoolean) {
          return localPoint.y;
        }
        return localPoint.x;
      }
      return paramInt;
    }
    
    private void a()
    {
      if (this.b.isEmpty()) {}
      int i;
      int j;
      do
      {
        return;
        i = c();
        j = b();
      } while ((!a(i)) || (!a(j)));
      a(i, j);
      ViewTreeObserver localViewTreeObserver = this.a.getViewTreeObserver();
      if (localViewTreeObserver.isAlive()) {
        localViewTreeObserver.removeOnPreDrawListener(this.c);
      }
      this.c = null;
    }
    
    private void a(int paramInt1, int paramInt2)
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        ((h)localIterator.next()).a(paramInt1, paramInt2);
      }
      this.b.clear();
    }
    
    private boolean a(int paramInt)
    {
      return (paramInt > 0) || (paramInt == -2);
    }
    
    private int b()
    {
      ViewGroup.LayoutParams localLayoutParams = this.a.getLayoutParams();
      if (a(this.a.getHeight())) {
        return this.a.getHeight();
      }
      if (localLayoutParams != null) {
        return a(localLayoutParams.height, true);
      }
      return 0;
    }
    
    private int c()
    {
      int i = 0;
      ViewGroup.LayoutParams localLayoutParams = this.a.getLayoutParams();
      if (a(this.a.getWidth())) {
        i = this.a.getWidth();
      }
      while (localLayoutParams == null) {
        return i;
      }
      return a(localLayoutParams.width, false);
    }
    
    @TargetApi(13)
    private Point d()
    {
      if (this.d != null) {
        return this.d;
      }
      Display localDisplay = ((WindowManager)this.a.getContext().getSystemService("window")).getDefaultDisplay();
      if (Build.VERSION.SDK_INT >= 13)
      {
        this.d = new Point();
        localDisplay.getSize(this.d);
      }
      for (;;)
      {
        return this.d;
        this.d = new Point(localDisplay.getWidth(), localDisplay.getHeight());
      }
    }
    
    public void a(h paramh)
    {
      int i = c();
      int j = b();
      if ((a(i)) && (a(j))) {
        paramh.a(i, j);
      }
      do
      {
        return;
        if (!this.b.contains(paramh)) {
          this.b.add(paramh);
        }
      } while (this.c != null);
      paramh = this.a.getViewTreeObserver();
      this.c = new a(this);
      paramh.addOnPreDrawListener(this.c);
    }
    
    private static class a
      implements ViewTreeObserver.OnPreDrawListener
    {
      private final WeakReference<k.a> a;
      
      public a(k.a parama)
      {
        this.a = new WeakReference(parama);
      }
      
      public boolean onPreDraw()
      {
        if (Log.isLoggable("ViewTarget", 2)) {
          Log.v("ViewTarget", "OnGlobalLayoutListener called listener=" + this);
        }
        k.a locala = (k.a)this.a.get();
        if (locala != null) {
          k.a.a(locala);
        }
        return true;
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\g\b\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */