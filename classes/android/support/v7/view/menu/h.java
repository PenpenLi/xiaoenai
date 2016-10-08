package android.support.v7.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.MenuItemCompat.OnActionExpandListener;
import android.support.v7.widget.AppCompatDrawableManager;
import android.util.Log;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug.CapturedViewProperty;
import android.widget.LinearLayout;

public final class h
  implements SupportMenuItem
{
  private static String w;
  private static String x;
  private static String y;
  private static String z;
  private final int a;
  private final int b;
  private final int c;
  private final int d;
  private CharSequence e;
  private CharSequence f;
  private Intent g;
  private char h;
  private char i;
  private Drawable j;
  private int k = 0;
  private f l;
  private q m;
  private Runnable n;
  private MenuItem.OnMenuItemClickListener o;
  private int p = 16;
  private int q = 0;
  private View r;
  private android.support.v4.view.ActionProvider s;
  private MenuItemCompat.OnActionExpandListener t;
  private boolean u = false;
  private ContextMenu.ContextMenuInfo v;
  
  h(f paramf, int paramInt1, int paramInt2, int paramInt3, int paramInt4, CharSequence paramCharSequence, int paramInt5)
  {
    this.l = paramf;
    this.a = paramInt2;
    this.b = paramInt1;
    this.c = paramInt3;
    this.d = paramInt4;
    this.e = paramCharSequence;
    this.q = paramInt5;
  }
  
  public SupportMenuItem a(int paramInt)
  {
    Context localContext = this.l.e();
    a(LayoutInflater.from(localContext).inflate(paramInt, new LinearLayout(localContext), false));
    return this;
  }
  
  public SupportMenuItem a(View paramView)
  {
    this.r = paramView;
    this.s = null;
    if ((paramView != null) && (paramView.getId() == -1) && (this.a > 0)) {
      paramView.setId(this.a);
    }
    this.l.b(this);
    return this;
  }
  
  CharSequence a(n.a parama)
  {
    if ((parama != null) && (parama.a())) {
      return getTitleCondensed();
    }
    return getTitle();
  }
  
  public void a(q paramq)
  {
    this.m = paramq;
    paramq.setHeaderTitle(getTitle());
  }
  
  void a(ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    this.v = paramContextMenuInfo;
  }
  
  public void a(boolean paramBoolean)
  {
    int i2 = this.p;
    if (paramBoolean) {}
    for (int i1 = 4;; i1 = 0)
    {
      this.p = (i1 | i2 & 0xFFFFFFFB);
      return;
    }
  }
  
  public boolean a()
  {
    if ((this.o != null) && (this.o.onMenuItemClick(this))) {}
    do
    {
      do
      {
        return true;
      } while (this.l.a(this.l.p(), this));
      if (this.n != null)
      {
        this.n.run();
        return true;
      }
      if (this.g != null) {
        try
        {
          this.l.e().startActivity(this.g);
          return true;
        }
        catch (ActivityNotFoundException localActivityNotFoundException)
        {
          Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", localActivityNotFoundException);
        }
      }
    } while ((this.s != null) && (this.s.onPerformDefaultAction()));
    return false;
  }
  
  public int b()
  {
    return this.d;
  }
  
  public SupportMenuItem b(int paramInt)
  {
    setShowAsAction(paramInt);
    return this;
  }
  
  void b(boolean paramBoolean)
  {
    int i2 = this.p;
    int i3 = this.p;
    if (paramBoolean) {}
    for (int i1 = 2;; i1 = 0)
    {
      this.p = (i1 | i3 & 0xFFFFFFFD);
      if (i2 != this.p) {
        this.l.b(false);
      }
      return;
    }
  }
  
  char c()
  {
    if (this.l.b()) {
      return this.i;
    }
    return this.h;
  }
  
  boolean c(boolean paramBoolean)
  {
    boolean bool = false;
    int i2 = this.p;
    int i3 = this.p;
    if (paramBoolean) {}
    for (int i1 = 0;; i1 = 8)
    {
      this.p = (i1 | i3 & 0xFFFFFFF7);
      paramBoolean = bool;
      if (i2 != this.p) {
        paramBoolean = true;
      }
      return paramBoolean;
    }
  }
  
  public boolean collapseActionView()
  {
    if ((this.q & 0x8) == 0) {}
    do
    {
      return false;
      if (this.r == null) {
        return true;
      }
    } while ((this.t != null) && (!this.t.onMenuItemActionCollapse(this)));
    return this.l.d(this);
  }
  
  String d()
  {
    char c1 = c();
    if (c1 == 0) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(w);
    switch (c1)
    {
    default: 
      localStringBuilder.append(c1);
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append(x);
      continue;
      localStringBuilder.append(y);
      continue;
      localStringBuilder.append(z);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.p |= 0x20;
      return;
    }
    this.p &= 0xFFFFFFDF;
  }
  
  public void e(boolean paramBoolean)
  {
    this.u = paramBoolean;
    this.l.b(false);
  }
  
  boolean e()
  {
    return (this.l.c()) && (c() != 0);
  }
  
  public boolean expandActionView()
  {
    if (!m()) {}
    while ((this.t != null) && (!this.t.onMenuItemActionExpand(this))) {
      return false;
    }
    return this.l.c(this);
  }
  
  public boolean f()
  {
    return (this.p & 0x4) != 0;
  }
  
  public void g()
  {
    this.l.b(this);
  }
  
  public android.view.ActionProvider getActionProvider()
  {
    throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
  }
  
  public View getActionView()
  {
    if (this.r != null) {
      return this.r;
    }
    if (this.s != null)
    {
      this.r = this.s.onCreateActionView(this);
      return this.r;
    }
    return null;
  }
  
  public char getAlphabeticShortcut()
  {
    return this.i;
  }
  
  public int getGroupId()
  {
    return this.b;
  }
  
  public Drawable getIcon()
  {
    if (this.j != null) {
      return this.j;
    }
    if (this.k != 0)
    {
      Drawable localDrawable = AppCompatDrawableManager.get().getDrawable(this.l.e(), this.k);
      this.k = 0;
      this.j = localDrawable;
      return localDrawable;
    }
    return null;
  }
  
  public Intent getIntent()
  {
    return this.g;
  }
  
  @ViewDebug.CapturedViewProperty
  public int getItemId()
  {
    return this.a;
  }
  
  public ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return this.v;
  }
  
  public char getNumericShortcut()
  {
    return this.h;
  }
  
  public int getOrder()
  {
    return this.c;
  }
  
  public SubMenu getSubMenu()
  {
    return this.m;
  }
  
  public android.support.v4.view.ActionProvider getSupportActionProvider()
  {
    return this.s;
  }
  
  @ViewDebug.CapturedViewProperty
  public CharSequence getTitle()
  {
    return this.e;
  }
  
  public CharSequence getTitleCondensed()
  {
    if (this.f != null) {}
    for (CharSequence localCharSequence = this.f;; localCharSequence = this.e)
    {
      Object localObject = localCharSequence;
      if (Build.VERSION.SDK_INT < 18)
      {
        localObject = localCharSequence;
        if (localCharSequence != null)
        {
          localObject = localCharSequence;
          if (!(localCharSequence instanceof String)) {
            localObject = localCharSequence.toString();
          }
        }
      }
      return (CharSequence)localObject;
    }
  }
  
  public boolean h()
  {
    return this.l.q();
  }
  
  public boolean hasSubMenu()
  {
    return this.m != null;
  }
  
  public boolean i()
  {
    return (this.p & 0x20) == 32;
  }
  
  public boolean isActionViewExpanded()
  {
    return this.u;
  }
  
  public boolean isCheckable()
  {
    return (this.p & 0x1) == 1;
  }
  
  public boolean isChecked()
  {
    return (this.p & 0x2) == 2;
  }
  
  public boolean isEnabled()
  {
    return (this.p & 0x10) != 0;
  }
  
  public boolean isVisible()
  {
    if ((this.s != null) && (this.s.overridesItemVisibility())) {
      if (((this.p & 0x8) != 0) || (!this.s.isVisible())) {}
    }
    while ((this.p & 0x8) == 0)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public boolean j()
  {
    return (this.q & 0x1) == 1;
  }
  
  public boolean k()
  {
    return (this.q & 0x2) == 2;
  }
  
  public boolean l()
  {
    return (this.q & 0x4) == 4;
  }
  
  public boolean m()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((this.q & 0x8) != 0)
    {
      if ((this.r == null) && (this.s != null)) {
        this.r = this.s.onCreateActionView(this);
      }
      bool1 = bool2;
      if (this.r != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public MenuItem setActionProvider(android.view.ActionProvider paramActionProvider)
  {
    throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar)
  {
    if (this.i == paramChar) {
      return this;
    }
    this.i = Character.toLowerCase(paramChar);
    this.l.b(false);
    return this;
  }
  
  public MenuItem setCheckable(boolean paramBoolean)
  {
    int i2 = this.p;
    int i3 = this.p;
    if (paramBoolean) {}
    for (int i1 = 1;; i1 = 0)
    {
      this.p = (i1 | i3 & 0xFFFFFFFE);
      if (i2 != this.p) {
        this.l.b(false);
      }
      return this;
    }
  }
  
  public MenuItem setChecked(boolean paramBoolean)
  {
    if ((this.p & 0x4) != 0)
    {
      this.l.a(this);
      return this;
    }
    b(paramBoolean);
    return this;
  }
  
  public MenuItem setEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (this.p |= 0x10;; this.p &= 0xFFFFFFEF)
    {
      this.l.b(false);
      return this;
    }
  }
  
  public MenuItem setIcon(int paramInt)
  {
    this.j = null;
    this.k = paramInt;
    this.l.b(false);
    return this;
  }
  
  public MenuItem setIcon(Drawable paramDrawable)
  {
    this.k = 0;
    this.j = paramDrawable;
    this.l.b(false);
    return this;
  }
  
  public MenuItem setIntent(Intent paramIntent)
  {
    this.g = paramIntent;
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar)
  {
    if (this.h == paramChar) {
      return this;
    }
    this.h = paramChar;
    this.l.b(false);
    return this;
  }
  
  public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setOnActionExpandListener()");
  }
  
  public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.o = paramOnMenuItemClickListener;
    return this;
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    this.h = paramChar1;
    this.i = Character.toLowerCase(paramChar2);
    this.l.b(false);
    return this;
  }
  
  public void setShowAsAction(int paramInt)
  {
    switch (paramInt & 0x3)
    {
    default: 
      throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
    }
    this.q = paramInt;
    this.l.b(this);
  }
  
  public SupportMenuItem setSupportActionProvider(android.support.v4.view.ActionProvider paramActionProvider)
  {
    if (this.s != null) {
      this.s.reset();
    }
    this.r = null;
    this.s = paramActionProvider;
    this.l.b(true);
    if (this.s != null) {
      this.s.setVisibilityListener(new i(this));
    }
    return this;
  }
  
  public SupportMenuItem setSupportOnActionExpandListener(MenuItemCompat.OnActionExpandListener paramOnActionExpandListener)
  {
    this.t = paramOnActionExpandListener;
    return this;
  }
  
  public MenuItem setTitle(int paramInt)
  {
    return setTitle(this.l.e().getString(paramInt));
  }
  
  public MenuItem setTitle(CharSequence paramCharSequence)
  {
    this.e = paramCharSequence;
    this.l.b(false);
    if (this.m != null) {
      this.m.setHeaderTitle(paramCharSequence);
    }
    return this;
  }
  
  public MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    this.f = paramCharSequence;
    if (paramCharSequence == null) {
      paramCharSequence = this.e;
    }
    this.l.b(false);
    return this;
  }
  
  public MenuItem setVisible(boolean paramBoolean)
  {
    if (c(paramBoolean)) {
      this.l.a(this);
    }
    return this;
  }
  
  public String toString()
  {
    if (this.e != null) {
      return this.e.toString();
    }
    return null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\view\menu\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */