package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.ActionProvider.SubUiVisibilityListener;
import android.support.v7.a.a.a;
import android.support.v7.a.a.g;
import android.support.v7.a.a.h;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.ActionMenuItemView.b;
import android.support.v7.view.menu.b;
import android.support.v7.view.menu.f;
import android.support.v7.view.menu.l;
import android.support.v7.view.menu.m.a;
import android.support.v7.view.menu.n;
import android.support.v7.view.menu.n.a;
import android.support.v7.view.menu.q;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import java.util.ArrayList;

class ActionMenuPresenter
  extends b
  implements ActionProvider.SubUiVisibilityListener
{
  private b A;
  final f g = new f(null);
  int h;
  private d i;
  private Drawable j;
  private boolean k;
  private boolean l;
  private boolean m;
  private int n;
  private int o;
  private int p;
  private boolean q;
  private boolean r;
  private boolean s;
  private boolean t;
  private int u;
  private final SparseBooleanArray v = new SparseBooleanArray();
  private View w;
  private e x;
  private a y;
  private c z;
  
  public ActionMenuPresenter(Context paramContext)
  {
    super(paramContext, a.h.abc_action_menu_layout, a.h.abc_action_menu_item_layout);
  }
  
  private View a(MenuItem paramMenuItem)
  {
    ViewGroup localViewGroup = (ViewGroup)this.f;
    Object localObject;
    if (localViewGroup == null)
    {
      localObject = null;
      return (View)localObject;
    }
    int i2 = localViewGroup.getChildCount();
    int i1 = 0;
    for (;;)
    {
      if (i1 >= i2) {
        break label74;
      }
      View localView = localViewGroup.getChildAt(i1);
      if ((localView instanceof n.a))
      {
        localObject = localView;
        if (((n.a)localView).getItemData() == paramMenuItem) {
          break;
        }
      }
      i1 += 1;
    }
    label74:
    return null;
  }
  
  public n a(ViewGroup paramViewGroup)
  {
    paramViewGroup = super.a(paramViewGroup);
    ((ActionMenuView)paramViewGroup).setPresenter(this);
    return paramViewGroup;
  }
  
  public View a(android.support.v7.view.menu.h paramh, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramh.getActionView();
    if ((localView == null) || (paramh.m())) {
      localView = super.a(paramh, paramView, paramViewGroup);
    }
    if (paramh.isActionViewExpanded()) {}
    for (int i1 = 8;; i1 = 0)
    {
      localView.setVisibility(i1);
      paramh = (ActionMenuView)paramViewGroup;
      paramView = localView.getLayoutParams();
      if (!paramh.checkLayoutParams(paramView)) {
        localView.setLayoutParams(paramh.generateLayoutParams(paramView));
      }
      return localView;
    }
  }
  
  public void a(Context paramContext, f paramf)
  {
    super.a(paramContext, paramf);
    paramf = paramContext.getResources();
    paramContext = android.support.v7.view.a.a(paramContext);
    if (!this.m) {
      this.l = paramContext.b();
    }
    if (!this.s) {
      this.n = paramContext.c();
    }
    if (!this.q) {
      this.p = paramContext.a();
    }
    int i1 = this.n;
    if (this.l)
    {
      if (this.i == null)
      {
        this.i = new d(this.a);
        if (this.k)
        {
          this.i.setImageDrawable(this.j);
          this.j = null;
          this.k = false;
        }
        int i2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.i.measure(i2, i2);
      }
      i1 -= this.i.getMeasuredWidth();
    }
    for (;;)
    {
      this.o = i1;
      this.u = ((int)(56.0F * paramf.getDisplayMetrics().density));
      this.w = null;
      return;
      this.i = null;
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (!this.q) {
      this.p = this.b.getResources().getInteger(a.g.abc_max_action_buttons);
    }
    if (this.c != null) {
      this.c.b(true);
    }
  }
  
  public void a(Drawable paramDrawable)
  {
    if (this.i != null)
    {
      this.i.setImageDrawable(paramDrawable);
      return;
    }
    this.k = true;
    this.j = paramDrawable;
  }
  
  public void a(f paramf, boolean paramBoolean)
  {
    f();
    super.a(paramf, paramBoolean);
  }
  
  public void a(android.support.v7.view.menu.h paramh, n.a parama)
  {
    parama.a(paramh, 0);
    paramh = (ActionMenuView)this.f;
    parama = (ActionMenuItemView)parama;
    parama.setItemInvoker(paramh);
    if (this.A == null) {
      this.A = new b(null);
    }
    parama.setPopupCallback(this.A);
  }
  
  public void a(ActionMenuView paramActionMenuView)
  {
    this.f = paramActionMenuView;
    paramActionMenuView.initialize(this.c);
  }
  
  public void a(boolean paramBoolean)
  {
    int i2 = 1;
    int i3 = 0;
    Object localObject = (ViewGroup)((View)this.f).getParent();
    if (localObject != null) {
      android.support.v7.d.a.a((ViewGroup)localObject);
    }
    super.a(paramBoolean);
    ((View)this.f).requestLayout();
    int i1;
    if (this.c != null)
    {
      localObject = this.c.k();
      int i4 = ((ArrayList)localObject).size();
      i1 = 0;
      while (i1 < i4)
      {
        ActionProvider localActionProvider = ((android.support.v7.view.menu.h)((ArrayList)localObject).get(i1)).getSupportActionProvider();
        if (localActionProvider != null) {
          localActionProvider.setSubUiVisibilityListener(this);
        }
        i1 += 1;
      }
    }
    if (this.c != null)
    {
      localObject = this.c.l();
      i1 = i3;
      if (this.l)
      {
        i1 = i3;
        if (localObject != null)
        {
          i1 = ((ArrayList)localObject).size();
          if (i1 != 1) {
            break label273;
          }
          if (((android.support.v7.view.menu.h)((ArrayList)localObject).get(0)).isActionViewExpanded()) {
            break label267;
          }
          i1 = 1;
        }
      }
      label168:
      if (i1 == 0) {
        break label291;
      }
      if (this.i == null) {
        this.i = new d(this.a);
      }
      localObject = (ViewGroup)this.i.getParent();
      if (localObject != this.f)
      {
        if (localObject != null) {
          ((ViewGroup)localObject).removeView(this.i);
        }
        localObject = (ActionMenuView)this.f;
        ((ActionMenuView)localObject).addView(this.i, ((ActionMenuView)localObject).generateOverflowButtonLayoutParams());
      }
    }
    for (;;)
    {
      ((ActionMenuView)this.f).setOverflowReserved(this.l);
      return;
      localObject = null;
      break;
      label267:
      i1 = 0;
      break label168;
      label273:
      if (i1 > 0) {}
      for (i1 = i2;; i1 = 0) {
        break;
      }
      label291:
      if ((this.i != null) && (this.i.getParent() == this.f)) {
        ((ViewGroup)this.f).removeView(this.i);
      }
    }
  }
  
  public boolean a(int paramInt, android.support.v7.view.menu.h paramh)
  {
    return paramh.i();
  }
  
  public boolean a(q paramq)
  {
    if (!paramq.hasVisibleItems()) {
      return false;
    }
    for (Object localObject = paramq; ((q)localObject).s() != this.c; localObject = (q)((q)localObject).s()) {}
    View localView = a(((q)localObject).getItem());
    localObject = localView;
    if (localView == null)
    {
      if (this.i == null) {
        return false;
      }
      localObject = this.i;
    }
    this.h = paramq.getItem().getItemId();
    this.y = new a(this.b, paramq);
    this.y.a((View)localObject);
    this.y.c();
    super.a(paramq);
    return true;
  }
  
  public boolean a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramViewGroup.getChildAt(paramInt) == this.i) {
      return false;
    }
    return super.a(paramViewGroup, paramInt);
  }
  
  public void b(boolean paramBoolean)
  {
    this.l = paramBoolean;
    this.m = true;
  }
  
  public boolean b()
  {
    ArrayList localArrayList = this.c.i();
    int i9 = localArrayList.size();
    int i1 = this.p;
    int i8 = this.o;
    int i10 = View.MeasureSpec.makeMeasureSpec(0, 0);
    ViewGroup localViewGroup = (ViewGroup)this.f;
    int i3 = 0;
    int i4 = 0;
    int i5 = 0;
    int i2 = 0;
    Object localObject1;
    if (i2 < i9)
    {
      localObject1 = (android.support.v7.view.menu.h)localArrayList.get(i2);
      if (((android.support.v7.view.menu.h)localObject1).k())
      {
        i3 += 1;
        label83:
        if ((!this.t) || (!((android.support.v7.view.menu.h)localObject1).isActionViewExpanded())) {
          break label888;
        }
        i1 = 0;
      }
    }
    label325:
    label479:
    label539:
    label546:
    label588:
    label683:
    label695:
    label701:
    label861:
    label864:
    label879:
    label888:
    for (;;)
    {
      i2 += 1;
      break;
      if (((android.support.v7.view.menu.h)localObject1).j())
      {
        i4 += 1;
        break label83;
      }
      i5 = 1;
      break label83;
      i2 = i1;
      if (this.l) {
        if (i5 == 0)
        {
          i2 = i1;
          if (i3 + i4 <= i1) {}
        }
        else
        {
          i2 = i1 - 1;
        }
      }
      i2 -= i3;
      localObject1 = this.v;
      ((SparseBooleanArray)localObject1).clear();
      i1 = 0;
      if (this.r)
      {
        i1 = i8 / this.u;
        i3 = this.u;
        i4 = this.u;
      }
      for (int i6 = i8 % i3 / i1 + i4;; i6 = 0)
      {
        int i7 = 0;
        i5 = 0;
        i3 = i1;
        i1 = i2;
        i4 = i8;
        i2 = i5;
        android.support.v7.view.menu.h localh;
        Object localObject2;
        if (i7 < i9)
        {
          localh = (android.support.v7.view.menu.h)localArrayList.get(i7);
          if (localh.k())
          {
            localObject2 = a(localh, this.w, localViewGroup);
            if (this.w == null) {
              this.w = ((View)localObject2);
            }
            if (this.r)
            {
              i5 = i3 - ActionMenuView.measureChildForCells((View)localObject2, i6, i3, i10, 0);
              i3 = ((View)localObject2).getMeasuredWidth();
              if (i2 != 0) {
                break label879;
              }
              i2 = i3;
            }
          }
        }
        for (;;)
        {
          i8 = localh.getGroupId();
          if (i8 != 0) {
            ((SparseBooleanArray)localObject1).put(i8, true);
          }
          localh.d(true);
          i4 -= i3;
          i3 = i1;
          i1 = i4;
          i8 = i7 + 1;
          i7 = i3;
          i3 = i5;
          i4 = i1;
          i1 = i7;
          i7 = i8;
          break;
          ((View)localObject2).measure(i10, i10);
          i5 = i3;
          break label325;
          int i11;
          boolean bool;
          int i12;
          if (localh.j())
          {
            i11 = localh.getGroupId();
            bool = ((SparseBooleanArray)localObject1).get(i11);
            if (((i1 > 0) || (bool)) && (i4 > 0) && ((!this.r) || (i3 > 0)))
            {
              i12 = 1;
              if (i12 == 0) {
                break label864;
              }
              localObject2 = a(localh, this.w, localViewGroup);
              if (this.w == null) {
                this.w = ((View)localObject2);
              }
              if (!this.r) {
                break label683;
              }
              i5 = ActionMenuView.measureChildForCells((View)localObject2, i6, i3, i10, 0);
              if (i5 != 0) {
                break label861;
              }
              i12 = 0;
              i3 -= i5;
              i5 = ((View)localObject2).getMeasuredWidth();
              i8 = i4 - i5;
              i4 = i2;
              if (i2 == 0) {
                i4 = i5;
              }
              if (!this.r) {
                break label701;
              }
              if (i8 < 0) {
                break label695;
              }
              i2 = 1;
              i12 &= i2;
              i2 = i4;
              i5 = i3;
              i4 = i8;
              i3 = i2;
              i2 = i5;
            }
          }
          for (;;)
          {
            if ((i12 != 0) && (i11 != 0)) {
              ((SparseBooleanArray)localObject1).put(i11, true);
            }
            for (;;)
            {
              i5 = i1;
              if (i12 != 0) {
                i5 = i1 - 1;
              }
              localh.d(i12);
              i1 = i4;
              i4 = i5;
              i5 = i2;
              i2 = i3;
              i3 = i4;
              break;
              int i13 = 0;
              break label479;
              ((View)localObject2).measure(i10, i10);
              break label546;
              i2 = 0;
              break label588;
              if (i8 + i4 > 0) {}
              for (i2 = 1;; i2 = 0)
              {
                i13 &= i2;
                i2 = i3;
                i3 = i4;
                i4 = i8;
                break;
              }
              if (bool)
              {
                ((SparseBooleanArray)localObject1).put(i11, false);
                i8 = 0;
                for (;;)
                {
                  if (i8 < i7)
                  {
                    localObject2 = (android.support.v7.view.menu.h)localArrayList.get(i8);
                    i5 = i1;
                    if (((android.support.v7.view.menu.h)localObject2).getGroupId() == i11)
                    {
                      i5 = i1;
                      if (((android.support.v7.view.menu.h)localObject2).i()) {
                        i5 = i1 + 1;
                      }
                      ((android.support.v7.view.menu.h)localObject2).d(false);
                    }
                    i8 += 1;
                    i1 = i5;
                    continue;
                    localh.d(false);
                    i5 = i4;
                    i4 = i1;
                    i1 = i5;
                    i5 = i3;
                    i3 = i4;
                    break;
                    return true;
                  }
                }
              }
            }
            break label539;
            i5 = i2;
            i2 = i3;
            i3 = i5;
          }
        }
      }
    }
  }
  
  public Drawable c()
  {
    if (this.i != null) {
      return this.i.getDrawable();
    }
    if (this.k) {
      return this.j;
    }
    return null;
  }
  
  public void c(boolean paramBoolean)
  {
    this.t = paramBoolean;
  }
  
  public boolean d()
  {
    if ((this.l) && (!h()) && (this.c != null) && (this.f != null) && (this.z == null) && (!this.c.l().isEmpty()))
    {
      this.z = new c(new e(this.b, this.c, this.i, true));
      ((View)this.f).post(this.z);
      super.a(null);
      return true;
    }
    return false;
  }
  
  public boolean e()
  {
    if ((this.z != null) && (this.f != null))
    {
      ((View)this.f).removeCallbacks(this.z);
      this.z = null;
      return true;
    }
    e locale = this.x;
    if (locale != null)
    {
      locale.f();
      return true;
    }
    return false;
  }
  
  public boolean f()
  {
    return e() | g();
  }
  
  public boolean g()
  {
    if (this.y != null)
    {
      this.y.f();
      return true;
    }
    return false;
  }
  
  public boolean h()
  {
    return (this.x != null) && (this.x.g());
  }
  
  public boolean i()
  {
    return (this.z != null) || (h());
  }
  
  public boolean j()
  {
    return this.l;
  }
  
  public void onSubUiVisibilityChanged(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      super.a(null);
      return;
    }
    this.c.a(false);
  }
  
  private static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new i();
    public int a;
    
    SavedState() {}
    
    SavedState(Parcel paramParcel)
    {
      this.a = paramParcel.readInt();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.a);
    }
  }
  
  private class a
    extends l
  {
    private q d;
    
    public a(Context paramContext, q paramq)
    {
      super(paramq, null, false, a.a.actionOverflowMenuStyle);
      this.d = paramq;
      int j;
      int i;
      if (!((android.support.v7.view.menu.h)paramq.getItem()).i())
      {
        if (ActionMenuPresenter.e(ActionMenuPresenter.this) == null)
        {
          paramContext = (View)ActionMenuPresenter.f(ActionMenuPresenter.this);
          a(paramContext);
        }
      }
      else
      {
        a(ActionMenuPresenter.this.g);
        j = paramq.size();
        i = 0;
      }
      for (;;)
      {
        boolean bool1 = bool2;
        if (i < j)
        {
          this$1 = paramq.getItem(i);
          if ((ActionMenuPresenter.this.isVisible()) && (ActionMenuPresenter.this.getIcon() != null)) {
            bool1 = true;
          }
        }
        else
        {
          b(bool1);
          return;
          paramContext = ActionMenuPresenter.e(ActionMenuPresenter.this);
          break;
        }
        i += 1;
      }
    }
    
    public void onDismiss()
    {
      super.onDismiss();
      ActionMenuPresenter.a(ActionMenuPresenter.this, null);
      ActionMenuPresenter.this.h = 0;
    }
  }
  
  private class b
    extends ActionMenuItemView.b
  {
    private b() {}
    
    public ListPopupWindow a()
    {
      if (ActionMenuPresenter.i(ActionMenuPresenter.this) != null) {
        return ActionMenuPresenter.i(ActionMenuPresenter.this).d();
      }
      return null;
    }
  }
  
  private class c
    implements Runnable
  {
    private ActionMenuPresenter.e b;
    
    public c(ActionMenuPresenter.e parame)
    {
      this.b = parame;
    }
    
    public void run()
    {
      ActionMenuPresenter.g(ActionMenuPresenter.this).f();
      View localView = (View)ActionMenuPresenter.h(ActionMenuPresenter.this);
      if ((localView != null) && (localView.getWindowToken() != null) && (this.b.e())) {
        ActionMenuPresenter.a(ActionMenuPresenter.this, this.b);
      }
      ActionMenuPresenter.a(ActionMenuPresenter.this, null);
    }
  }
  
  private class d
    extends AppCompatImageView
    implements ActionMenuView.ActionMenuChildView
  {
    private final float[] b = new float[2];
    
    public d(Context paramContext)
    {
      super(null, a.a.actionOverflowButtonStyle);
      setClickable(true);
      setFocusable(true);
      setVisibility(0);
      setEnabled(true);
      setOnTouchListener(new h(this, this, ActionMenuPresenter.this));
    }
    
    public boolean needsDividerAfter()
    {
      return false;
    }
    
    public boolean needsDividerBefore()
    {
      return false;
    }
    
    public boolean performClick()
    {
      if (super.performClick()) {
        return true;
      }
      playSoundEffect(0);
      ActionMenuPresenter.this.d();
      return true;
    }
    
    protected boolean setFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      boolean bool = super.setFrame(paramInt1, paramInt2, paramInt3, paramInt4);
      Drawable localDrawable1 = getDrawable();
      Drawable localDrawable2 = getBackground();
      if ((localDrawable1 != null) && (localDrawable2 != null))
      {
        int i = getWidth();
        paramInt2 = getHeight();
        paramInt1 = Math.max(i, paramInt2) / 2;
        int j = getPaddingLeft();
        int k = getPaddingRight();
        paramInt3 = getPaddingTop();
        paramInt4 = getPaddingBottom();
        i = (i + (j - k)) / 2;
        paramInt2 = (paramInt2 + (paramInt3 - paramInt4)) / 2;
        DrawableCompat.setHotspotBounds(localDrawable2, i - paramInt1, paramInt2 - paramInt1, i + paramInt1, paramInt2 + paramInt1);
      }
      return bool;
    }
  }
  
  private class e
    extends l
  {
    public e(Context paramContext, f paramf, View paramView, boolean paramBoolean)
    {
      super(paramf, paramView, paramBoolean, a.a.actionOverflowMenuStyle);
      a(8388613);
      a(ActionMenuPresenter.this.g);
    }
    
    public void onDismiss()
    {
      super.onDismiss();
      if (ActionMenuPresenter.c(ActionMenuPresenter.this) != null) {
        ActionMenuPresenter.d(ActionMenuPresenter.this).close();
      }
      ActionMenuPresenter.a(ActionMenuPresenter.this, null);
    }
  }
  
  private class f
    implements m.a
  {
    private f() {}
    
    public void onCloseMenu(f paramf, boolean paramBoolean)
    {
      if ((paramf instanceof q)) {
        ((q)paramf).p().a(false);
      }
      m.a locala = ActionMenuPresenter.this.a();
      if (locala != null) {
        locala.onCloseMenu(paramf, paramBoolean);
      }
    }
    
    public boolean onOpenSubMenu(f paramf)
    {
      if (paramf == null) {
        return false;
      }
      ActionMenuPresenter.this.h = ((q)paramf).getItem().getItemId();
      m.a locala = ActionMenuPresenter.this.a();
      if (locala != null) {}
      for (boolean bool = locala.onOpenSubMenu(paramf);; bool = false) {
        return bool;
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\ActionMenuPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */