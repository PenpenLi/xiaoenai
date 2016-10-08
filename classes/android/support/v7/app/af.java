package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorUpdateListener;
import android.support.v7.a.a.a;
import android.support.v7.a.a.f;
import android.support.v7.a.a.k;
import android.support.v7.view.a;
import android.support.v7.view.b;
import android.support.v7.view.b.a;
import android.support.v7.view.g;
import android.support.v7.view.h;
import android.support.v7.view.menu.f;
import android.support.v7.view.menu.f.a;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback;
import android.support.v7.widget.DecorToolbar;
import android.support.v7.widget.ScrollingTabContainerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class af
  extends ActionBar
  implements ActionBarOverlayLayout.ActionBarVisibilityCallback
{
  private static final Interpolator i;
  private static final Interpolator j;
  private static final boolean k;
  private boolean A;
  private int B = 0;
  private boolean C = true;
  private boolean D;
  private boolean E;
  private boolean F;
  private boolean G = true;
  private h H;
  private boolean I;
  a a;
  b b;
  b.a c;
  boolean d;
  final ViewPropertyAnimatorListener e = new ag(this);
  final ViewPropertyAnimatorListener f = new ah(this);
  final ViewPropertyAnimatorUpdateListener g = new ai(this);
  private Context l;
  private Context m;
  private Activity n;
  private Dialog o;
  private ActionBarOverlayLayout p;
  private ActionBarContainer q;
  private DecorToolbar r;
  private ActionBarContextView s;
  private View t;
  private ScrollingTabContainerView u;
  private ArrayList<Object> v = new ArrayList();
  private int w = -1;
  private boolean x;
  private boolean y;
  private ArrayList<ActionBar.a> z = new ArrayList();
  
  static
  {
    boolean bool2 = true;
    if (!af.class.desiredAssertionStatus())
    {
      bool1 = true;
      h = bool1;
      i = new AccelerateInterpolator();
      j = new DecelerateInterpolator();
      if (Build.VERSION.SDK_INT < 14) {
        break label56;
      }
    }
    label56:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      k = bool1;
      return;
      bool1 = false;
      break;
    }
  }
  
  public af(Activity paramActivity, boolean paramBoolean)
  {
    this.n = paramActivity;
    paramActivity = paramActivity.getWindow().getDecorView();
    a(paramActivity);
    if (!paramBoolean) {
      this.t = paramActivity.findViewById(16908290);
    }
  }
  
  public af(Dialog paramDialog)
  {
    this.o = paramDialog;
    a(paramDialog.getWindow().getDecorView());
  }
  
  private void a(View paramView)
  {
    this.p = ((ActionBarOverlayLayout)paramView.findViewById(a.f.decor_content_parent));
    if (this.p != null) {
      this.p.setActionBarVisibilityCallback(this);
    }
    this.r = b(paramView.findViewById(a.f.action_bar));
    this.s = ((ActionBarContextView)paramView.findViewById(a.f.action_context_bar));
    this.q = ((ActionBarContainer)paramView.findViewById(a.f.action_bar_container));
    if ((this.r == null) || (this.s == null) || (this.q == null)) {
      throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with a compatible window decor layout");
    }
    this.l = this.r.getContext();
    int i1;
    if ((this.r.getDisplayOptions() & 0x4) != 0)
    {
      i1 = 1;
      if (i1 != 0) {
        this.x = true;
      }
      paramView = a.a(this.l);
      if ((!paramView.f()) && (i1 == 0)) {
        break label264;
      }
    }
    label264:
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      j(paramView.d());
      paramView = this.l.obtainStyledAttributes(null, a.k.ActionBar, a.a.actionBarStyle, 0);
      if (paramView.getBoolean(a.k.ActionBar_hideOnContentScroll, false)) {
        b(true);
      }
      i1 = paramView.getDimensionPixelSize(a.k.ActionBar_elevation, 0);
      if (i1 != 0) {
        a(i1);
      }
      paramView.recycle();
      return;
      i1 = 0;
      break;
    }
  }
  
  private DecorToolbar b(View paramView)
  {
    if ((paramView instanceof DecorToolbar)) {
      return (DecorToolbar)paramView;
    }
    if ((paramView instanceof Toolbar)) {
      return ((Toolbar)paramView).getWrapper();
    }
    if ("Can't make a decor toolbar out of " + paramView != null) {}
    for (paramView = paramView.getClass().getSimpleName();; paramView = "null") {
      throw new IllegalStateException(paramView);
    }
  }
  
  private static boolean b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean3) {}
    while ((!paramBoolean1) && (!paramBoolean2)) {
      return true;
    }
    return false;
  }
  
  private void j(boolean paramBoolean)
  {
    boolean bool = true;
    this.A = paramBoolean;
    int i1;
    label46:
    label79:
    Object localObject;
    if (!this.A)
    {
      this.r.setEmbeddedTabView(null);
      this.q.setTabContainer(this.u);
      if (j() != 2) {
        break label153;
      }
      i1 = 1;
      if (this.u != null)
      {
        if (i1 == 0) {
          break label158;
        }
        this.u.setVisibility(0);
        if (this.p != null) {
          ViewCompat.requestApplyInsets(this.p);
        }
      }
      localObject = this.r;
      if ((this.A) || (i1 == 0)) {
        break label170;
      }
      paramBoolean = true;
      label97:
      ((DecorToolbar)localObject).setCollapsible(paramBoolean);
      localObject = this.p;
      if ((this.A) || (i1 == 0)) {
        break label175;
      }
    }
    label153:
    label158:
    label170:
    label175:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      ((ActionBarOverlayLayout)localObject).setHasNonEmbeddedTabs(paramBoolean);
      return;
      this.q.setTabContainer(null);
      this.r.setEmbeddedTabView(this.u);
      break;
      i1 = 0;
      break label46;
      this.u.setVisibility(8);
      break label79;
      paramBoolean = false;
      break label97;
    }
  }
  
  private void k(boolean paramBoolean)
  {
    if (b(this.D, this.E, this.F)) {
      if (!this.G)
      {
        this.G = true;
        g(paramBoolean);
      }
    }
    while (!this.G) {
      return;
    }
    this.G = false;
    h(paramBoolean);
  }
  
  private void l()
  {
    if (!this.F)
    {
      this.F = true;
      if (this.p != null) {
        this.p.setShowingForActionMode(true);
      }
      k(false);
    }
  }
  
  private void m()
  {
    if (this.F)
    {
      this.F = false;
      if (this.p != null) {
        this.p.setShowingForActionMode(false);
      }
      k(false);
    }
  }
  
  public int a()
  {
    return this.r.getDisplayOptions();
  }
  
  public b a(b.a parama)
  {
    if (this.a != null) {
      this.a.c();
    }
    this.p.setHideOnContentScrollEnabled(false);
    this.s.killMode();
    parama = new a(this.s.getContext(), parama);
    if (parama.e())
    {
      parama.d();
      this.s.initForMode(parama);
      i(true);
      this.s.sendAccessibilityEvent(32);
      this.a = parama;
      return parama;
    }
    return null;
  }
  
  public void a(float paramFloat)
  {
    ViewCompat.setElevation(this.q, paramFloat);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i1 = this.r.getDisplayOptions();
    if ((paramInt2 & 0x4) != 0) {
      this.x = true;
    }
    this.r.setDisplayOptions(i1 & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
  }
  
  public void a(Configuration paramConfiguration)
  {
    j(a.a(this.l).d());
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.r.setWindowTitle(paramCharSequence);
  }
  
  public void a(boolean paramBoolean)
  {
    this.r.setHomeButtonEnabled(paramBoolean);
  }
  
  public void b(boolean paramBoolean)
  {
    if ((paramBoolean) && (!this.p.isInOverlayMode())) {
      throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }
    this.d = paramBoolean;
    this.p.setHideOnContentScrollEnabled(paramBoolean);
  }
  
  public boolean b()
  {
    int i1 = k();
    return (this.G) && ((i1 == 0) || (d() < i1));
  }
  
  public Context c()
  {
    int i1;
    if (this.m == null)
    {
      TypedValue localTypedValue = new TypedValue();
      this.l.getTheme().resolveAttribute(a.a.actionBarWidgetTheme, localTypedValue, true);
      i1 = localTypedValue.resourceId;
      if (i1 == 0) {
        break label61;
      }
    }
    label61:
    for (this.m = new ContextThemeWrapper(this.l, i1);; this.m = this.l) {
      return this.m;
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (!this.x) {
      f(paramBoolean);
    }
  }
  
  public int d()
  {
    return this.p.getActionBarHideOffset();
  }
  
  public void d(boolean paramBoolean)
  {
    this.I = paramBoolean;
    if ((!paramBoolean) && (this.H != null)) {
      this.H.b();
    }
  }
  
  public void e(boolean paramBoolean)
  {
    if (paramBoolean == this.y) {}
    for (;;)
    {
      return;
      this.y = paramBoolean;
      int i2 = this.z.size();
      int i1 = 0;
      while (i1 < i2)
      {
        ((ActionBar.a)this.z.get(i1)).a(paramBoolean);
        i1 += 1;
      }
    }
  }
  
  public void enableContentAnimations(boolean paramBoolean)
  {
    this.C = paramBoolean;
  }
  
  public void f(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i1 = 4;; i1 = 0)
    {
      a(i1, 4);
      return;
    }
  }
  
  public boolean f()
  {
    if ((this.r != null) && (this.r.hasExpandedActionView()))
    {
      this.r.collapseActionView();
      return true;
    }
    return false;
  }
  
  public void g(boolean paramBoolean)
  {
    if (this.H != null) {
      this.H.b();
    }
    this.q.setVisibility(0);
    if ((this.B == 0) && (k) && ((this.I) || (paramBoolean)))
    {
      ViewCompat.setTranslationY(this.q, 0.0F);
      float f2 = -this.q.getHeight();
      float f1 = f2;
      if (paramBoolean)
      {
        localObject = new int[2];
        Object tmp77_75 = localObject;
        tmp77_75[0] = 0;
        Object tmp81_77 = tmp77_75;
        tmp81_77[1] = 0;
        tmp81_77;
        this.q.getLocationInWindow((int[])localObject);
        f1 = f2 - localObject[1];
      }
      ViewCompat.setTranslationY(this.q, f1);
      Object localObject = new h();
      ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat = ViewCompat.animate(this.q).translationY(0.0F);
      localViewPropertyAnimatorCompat.setUpdateListener(this.g);
      ((h)localObject).a(localViewPropertyAnimatorCompat);
      if ((this.C) && (this.t != null))
      {
        ViewCompat.setTranslationY(this.t, f1);
        ((h)localObject).a(ViewCompat.animate(this.t).translationY(0.0F));
      }
      ((h)localObject).a(j);
      ((h)localObject).a(250L);
      ((h)localObject).a(this.f);
      this.H = ((h)localObject);
      ((h)localObject).a();
    }
    for (;;)
    {
      if (this.p != null) {
        ViewCompat.requestApplyInsets(this.p);
      }
      return;
      ViewCompat.setAlpha(this.q, 1.0F);
      ViewCompat.setTranslationY(this.q, 0.0F);
      if ((this.C) && (this.t != null)) {
        ViewCompat.setTranslationY(this.t, 0.0F);
      }
      this.f.onAnimationEnd(null);
    }
  }
  
  public boolean g()
  {
    ViewGroup localViewGroup = this.r.getViewGroup();
    if ((localViewGroup != null) && (!localViewGroup.hasFocus()))
    {
      localViewGroup.requestFocus();
      return true;
    }
    return false;
  }
  
  public void h(boolean paramBoolean)
  {
    if (this.H != null) {
      this.H.b();
    }
    if ((this.B == 0) && (k) && ((this.I) || (paramBoolean)))
    {
      ViewCompat.setAlpha(this.q, 1.0F);
      this.q.setTransitioning(true);
      h localh = new h();
      float f2 = -this.q.getHeight();
      float f1 = f2;
      if (paramBoolean)
      {
        localObject = new int[2];
        Object tmp86_84 = localObject;
        tmp86_84[0] = 0;
        Object tmp90_86 = tmp86_84;
        tmp90_86[1] = 0;
        tmp90_86;
        this.q.getLocationInWindow((int[])localObject);
        f1 = f2 - localObject[1];
      }
      Object localObject = ViewCompat.animate(this.q).translationY(f1);
      ((ViewPropertyAnimatorCompat)localObject).setUpdateListener(this.g);
      localh.a((ViewPropertyAnimatorCompat)localObject);
      if ((this.C) && (this.t != null)) {
        localh.a(ViewCompat.animate(this.t).translationY(f1));
      }
      localh.a(i);
      localh.a(250L);
      localh.a(this.e);
      this.H = localh;
      localh.a();
      return;
    }
    this.e.onAnimationEnd(null);
  }
  
  public void hideForSystem()
  {
    if (!this.E)
    {
      this.E = true;
      k(true);
    }
  }
  
  void i()
  {
    if (this.c != null)
    {
      this.c.a(this.b);
      this.b = null;
      this.c = null;
    }
  }
  
  public void i(boolean paramBoolean)
  {
    ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat1;
    ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat2;
    if (paramBoolean)
    {
      l();
      if (!paramBoolean) {
        break label68;
      }
      localViewPropertyAnimatorCompat1 = this.r.setupAnimatorToVisibility(4, 100L);
      localViewPropertyAnimatorCompat2 = this.s.setupAnimatorToVisibility(0, 200L);
    }
    for (;;)
    {
      h localh = new h();
      localh.a(localViewPropertyAnimatorCompat1, localViewPropertyAnimatorCompat2);
      localh.a();
      return;
      m();
      break;
      label68:
      localViewPropertyAnimatorCompat2 = this.r.setupAnimatorToVisibility(0, 200L);
      localViewPropertyAnimatorCompat1 = this.s.setupAnimatorToVisibility(8, 100L);
    }
  }
  
  public int j()
  {
    return this.r.getNavigationMode();
  }
  
  public int k()
  {
    return this.q.getHeight();
  }
  
  public void onContentScrollStarted()
  {
    if (this.H != null)
    {
      this.H.b();
      this.H = null;
    }
  }
  
  public void onContentScrollStopped() {}
  
  public void onWindowVisibilityChanged(int paramInt)
  {
    this.B = paramInt;
  }
  
  public void showForSystem()
  {
    if (this.E)
    {
      this.E = false;
      k(true);
    }
  }
  
  public class a
    extends b
    implements f.a
  {
    private final Context b;
    private final f c;
    private b.a d;
    private WeakReference<View> e;
    
    public a(Context paramContext, b.a parama)
    {
      this.b = paramContext;
      this.d = parama;
      this.c = new f(paramContext).a(1);
      this.c.a(this);
    }
    
    public MenuInflater a()
    {
      return new g(this.b);
    }
    
    public void a(int paramInt)
    {
      b(af.i(af.this).getResources().getString(paramInt));
    }
    
    public void a(View paramView)
    {
      af.g(af.this).setCustomView(paramView);
      this.e = new WeakReference(paramView);
    }
    
    public void a(CharSequence paramCharSequence)
    {
      af.g(af.this).setSubtitle(paramCharSequence);
    }
    
    public void a(boolean paramBoolean)
    {
      super.a(paramBoolean);
      af.g(af.this).setTitleOptional(paramBoolean);
    }
    
    public Menu b()
    {
      return this.c;
    }
    
    public void b(int paramInt)
    {
      a(af.i(af.this).getResources().getString(paramInt));
    }
    
    public void b(CharSequence paramCharSequence)
    {
      af.g(af.this).setTitle(paramCharSequence);
    }
    
    public void c()
    {
      if (af.this.a != this) {
        return;
      }
      if (!af.a(af.e(af.this), af.f(af.this), false))
      {
        af.this.b = this;
        af.this.c = this.d;
      }
      for (;;)
      {
        this.d = null;
        af.this.i(false);
        af.g(af.this).closeMode();
        af.h(af.this).getViewGroup().sendAccessibilityEvent(32);
        af.d(af.this).setHideOnContentScrollEnabled(af.this.d);
        af.this.a = null;
        return;
        this.d.a(this);
      }
    }
    
    public void d()
    {
      if (af.this.a != this) {
        return;
      }
      this.c.g();
      try
      {
        this.d.b(this, this.c);
        return;
      }
      finally
      {
        this.c.h();
      }
    }
    
    public boolean e()
    {
      this.c.g();
      try
      {
        boolean bool = this.d.a(this, this.c);
        return bool;
      }
      finally
      {
        this.c.h();
      }
    }
    
    public CharSequence f()
    {
      return af.g(af.this).getTitle();
    }
    
    public CharSequence g()
    {
      return af.g(af.this).getSubtitle();
    }
    
    public boolean h()
    {
      return af.g(af.this).isTitleOptional();
    }
    
    public View i()
    {
      if (this.e != null) {
        return (View)this.e.get();
      }
      return null;
    }
    
    public boolean onMenuItemSelected(f paramf, MenuItem paramMenuItem)
    {
      if (this.d != null) {
        return this.d.a(this, paramMenuItem);
      }
      return false;
    }
    
    public void onMenuModeChange(f paramf)
    {
      if (this.d == null) {
        return;
      }
      d();
      af.g(af.this).showOverflowMenu();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\app\af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */