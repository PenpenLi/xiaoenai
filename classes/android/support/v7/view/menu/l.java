package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.a.a.a;
import android.support.v7.a.a.d;
import android.support.v7.a.a.h;
import android.support.v7.widget.ListPopupWindow;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import java.util.ArrayList;

public class l
  implements m, View.OnKeyListener, ViewTreeObserver.OnGlobalLayoutListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener
{
  static final int a = a.h.abc_popup_menu_item_layout;
  boolean b;
  private final Context c;
  private final LayoutInflater d;
  private final f e;
  private final a f;
  private final boolean g;
  private final int h;
  private final int i;
  private final int j;
  private View k;
  private ListPopupWindow l;
  private ViewTreeObserver m;
  private m.a n;
  private ViewGroup o;
  private boolean p;
  private int q;
  private int r = 0;
  
  public l(Context paramContext, f paramf, View paramView)
  {
    this(paramContext, paramf, paramView, false, a.a.popupMenuStyle);
  }
  
  public l(Context paramContext, f paramf, View paramView, boolean paramBoolean, int paramInt)
  {
    this(paramContext, paramf, paramView, paramBoolean, paramInt, 0);
  }
  
  public l(Context paramContext, f paramf, View paramView, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.c = paramContext;
    this.d = LayoutInflater.from(paramContext);
    this.e = paramf;
    this.f = new a(this.e);
    this.g = paramBoolean;
    this.i = paramInt1;
    this.j = paramInt2;
    Resources localResources = paramContext.getResources();
    this.h = Math.max(localResources.getDisplayMetrics().widthPixels / 2, localResources.getDimensionPixelSize(a.d.abc_config_prefDialogWidth));
    this.k = paramView;
    paramf.a(this, paramContext);
  }
  
  private int h()
  {
    a locala = this.f;
    int i5 = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i6 = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i7 = locala.getCount();
    int i2 = 0;
    int i3 = 0;
    View localView = null;
    int i1 = 0;
    int i4 = i1;
    if (i2 < i7)
    {
      i4 = locala.getItemViewType(i2);
      if (i4 == i3) {
        break label156;
      }
      i3 = i4;
      localView = null;
      label70:
      if (this.o == null) {
        this.o = new FrameLayout(this.c);
      }
      localView = locala.getView(i2, localView, this.o);
      localView.measure(i5, i6);
      i4 = localView.getMeasuredWidth();
      if (i4 >= this.h) {
        i4 = this.h;
      }
    }
    else
    {
      return i4;
    }
    if (i4 > i1) {
      i1 = i4;
    }
    for (;;)
    {
      i2 += 1;
      break;
      label156:
      break label70;
    }
  }
  
  public int a()
  {
    return this.r;
  }
  
  public void a(int paramInt)
  {
    this.r = paramInt;
  }
  
  public void a(Context paramContext, f paramf) {}
  
  public void a(f paramf, boolean paramBoolean)
  {
    if (paramf != this.e) {}
    do
    {
      return;
      f();
    } while (this.n == null);
    this.n.onCloseMenu(paramf, paramBoolean);
  }
  
  public void a(m.a parama)
  {
    this.n = parama;
  }
  
  public void a(View paramView)
  {
    this.k = paramView;
  }
  
  public void a(boolean paramBoolean)
  {
    this.p = false;
    if (this.f != null) {
      this.f.notifyDataSetChanged();
    }
  }
  
  public boolean a(f paramf, h paramh)
  {
    return false;
  }
  
  public boolean a(q paramq)
  {
    l locall;
    int i1;
    if (paramq.hasVisibleItems())
    {
      locall = new l(this.c, paramq, this.k);
      locall.a(this.n);
      int i2 = paramq.size();
      i1 = 0;
      if (i1 >= i2) {
        break label120;
      }
      MenuItem localMenuItem = paramq.getItem(i1);
      if ((!localMenuItem.isVisible()) || (localMenuItem.getIcon() == null)) {}
    }
    label120:
    for (boolean bool = true;; bool = false)
    {
      locall.b(bool);
      if (locall.e())
      {
        if (this.n != null) {
          this.n.onOpenSubMenu(paramq);
        }
        return true;
        i1 += 1;
        break;
      }
      return false;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean b(f paramf, h paramh)
  {
    return false;
  }
  
  public void c()
  {
    if (!e()) {
      throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
    }
  }
  
  public ListPopupWindow d()
  {
    return this.l;
  }
  
  public boolean e()
  {
    int i1 = 0;
    this.l = new ListPopupWindow(this.c, null, this.i, this.j);
    this.l.setOnDismissListener(this);
    this.l.setOnItemClickListener(this);
    this.l.setAdapter(this.f);
    this.l.setModal(true);
    View localView = this.k;
    if (localView != null)
    {
      if (this.m == null) {
        i1 = 1;
      }
      this.m = localView.getViewTreeObserver();
      if (i1 != 0) {
        this.m.addOnGlobalLayoutListener(this);
      }
      this.l.setAnchorView(localView);
      this.l.setDropDownGravity(this.r);
      if (!this.p)
      {
        this.q = h();
        this.p = true;
      }
      this.l.setContentWidth(this.q);
      this.l.setInputMethodMode(2);
      this.l.show();
      this.l.getListView().setOnKeyListener(this);
      return true;
    }
    return false;
  }
  
  public void f()
  {
    if (g()) {
      this.l.dismiss();
    }
  }
  
  public boolean g()
  {
    return (this.l != null) && (this.l.isShowing());
  }
  
  public void onDismiss()
  {
    this.l = null;
    this.e.close();
    if (this.m != null)
    {
      if (!this.m.isAlive()) {
        this.m = this.k.getViewTreeObserver();
      }
      this.m.removeGlobalOnLayoutListener(this);
      this.m = null;
    }
  }
  
  public void onGlobalLayout()
  {
    if (g())
    {
      View localView = this.k;
      if ((localView != null) && (localView.isShown())) {
        break label28;
      }
      f();
    }
    label28:
    while (!g()) {
      return;
    }
    this.l.show();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.f;
    a.a(paramAdapterView).a(paramAdapterView.a(paramInt), 0);
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 1) && (paramInt == 82))
    {
      f();
      return true;
    }
    return false;
  }
  
  private class a
    extends BaseAdapter
  {
    private f b;
    private int c = -1;
    
    public a(f paramf)
    {
      this.b = paramf;
      a();
    }
    
    public h a(int paramInt)
    {
      if (l.a(l.this)) {}
      for (ArrayList localArrayList = this.b.l();; localArrayList = this.b.i())
      {
        int i = paramInt;
        if (this.c >= 0)
        {
          i = paramInt;
          if (paramInt >= this.c) {
            i = paramInt + 1;
          }
        }
        return (h)localArrayList.get(i);
      }
    }
    
    void a()
    {
      h localh = l.c(l.this).r();
      if (localh != null)
      {
        ArrayList localArrayList = l.c(l.this).l();
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          if ((h)localArrayList.get(i) == localh)
          {
            this.c = i;
            return;
          }
          i += 1;
        }
      }
      this.c = -1;
    }
    
    public int getCount()
    {
      if (l.a(l.this)) {}
      for (ArrayList localArrayList = this.b.l(); this.c < 0; localArrayList = this.b.i()) {
        return localArrayList.size();
      }
      return localArrayList.size() - 1;
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null) {
        paramView = l.b(l.this).inflate(l.a, paramViewGroup, false);
      }
      for (;;)
      {
        paramViewGroup = (n.a)paramView;
        if (l.this.b) {
          ((ListMenuItemView)paramView).setForceShowIcon(true);
        }
        paramViewGroup.a(a(paramInt), 0);
        return paramView;
      }
    }
    
    public void notifyDataSetChanged()
    {
      a();
      super.notifyDataSetChanged();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\view\menu\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */