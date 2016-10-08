package android.support.v7.widget;

import android.content.Context;
import android.support.annotation.MenuRes;
import android.support.v7.a.a.a;
import android.support.v7.view.g;
import android.support.v7.view.menu.f;
import android.support.v7.view.menu.f.a;
import android.support.v7.view.menu.l;
import android.support.v7.view.menu.m.a;
import android.support.v7.view.menu.q;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnTouchListener;

public class PopupMenu
  implements f.a, m.a
{
  private View mAnchor;
  private Context mContext;
  private OnDismissListener mDismissListener;
  private View.OnTouchListener mDragListener;
  private f mMenu;
  private OnMenuItemClickListener mMenuItemClickListener;
  private l mPopup;
  
  public PopupMenu(Context paramContext, View paramView)
  {
    this(paramContext, paramView, 0);
  }
  
  public PopupMenu(Context paramContext, View paramView, int paramInt)
  {
    this(paramContext, paramView, paramInt, a.a.popupMenuStyle, 0);
  }
  
  public PopupMenu(Context paramContext, View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mContext = paramContext;
    this.mMenu = new f(paramContext);
    this.mMenu.a(this);
    this.mAnchor = paramView;
    this.mPopup = new l(paramContext, this.mMenu, paramView, false, paramInt2, paramInt3);
    this.mPopup.a(paramInt1);
    this.mPopup.a(this);
  }
  
  public void dismiss()
  {
    this.mPopup.f();
  }
  
  public View.OnTouchListener getDragToOpenListener()
  {
    if (this.mDragListener == null) {
      this.mDragListener = new ar(this, this.mAnchor);
    }
    return this.mDragListener;
  }
  
  public int getGravity()
  {
    return this.mPopup.a();
  }
  
  public Menu getMenu()
  {
    return this.mMenu;
  }
  
  public MenuInflater getMenuInflater()
  {
    return new g(this.mContext);
  }
  
  public void inflate(@MenuRes int paramInt)
  {
    getMenuInflater().inflate(paramInt, this.mMenu);
  }
  
  public void onCloseMenu(f paramf, boolean paramBoolean)
  {
    if (this.mDismissListener != null) {
      this.mDismissListener.onDismiss(this);
    }
  }
  
  public void onCloseSubMenu(q paramq) {}
  
  public boolean onMenuItemSelected(f paramf, MenuItem paramMenuItem)
  {
    if (this.mMenuItemClickListener != null) {
      return this.mMenuItemClickListener.onMenuItemClick(paramMenuItem);
    }
    return false;
  }
  
  public void onMenuModeChange(f paramf) {}
  
  public boolean onOpenSubMenu(f paramf)
  {
    boolean bool = true;
    if (paramf == null) {
      bool = false;
    }
    while (!paramf.hasVisibleItems()) {
      return bool;
    }
    new l(this.mContext, paramf, this.mAnchor).c();
    return true;
  }
  
  public void setGravity(int paramInt)
  {
    this.mPopup.a(paramInt);
  }
  
  public void setOnDismissListener(OnDismissListener paramOnDismissListener)
  {
    this.mDismissListener = paramOnDismissListener;
  }
  
  public void setOnMenuItemClickListener(OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.mMenuItemClickListener = paramOnMenuItemClickListener;
  }
  
  public void show()
  {
    this.mPopup.c();
  }
  
  public static abstract interface OnDismissListener
  {
    public abstract void onDismiss(PopupMenu paramPopupMenu);
  }
  
  public static abstract interface OnMenuItemClickListener
  {
    public abstract boolean onMenuItemClick(MenuItem paramMenuItem);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\PopupMenu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */