package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.text.TextUtilsCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.widget.ListViewAutoScrollHelper;
import android.support.v4.widget.PopupWindowCompat;
import android.support.v7.a.a.a;
import android.support.v7.a.a.k;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import java.lang.reflect.Method;

public class ListPopupWindow
{
  private static final boolean DEBUG = false;
  private static final int EXPAND_LIST_TIMEOUT = 250;
  public static final int INPUT_METHOD_FROM_FOCUSABLE = 0;
  public static final int INPUT_METHOD_NEEDED = 1;
  public static final int INPUT_METHOD_NOT_NEEDED = 2;
  public static final int MATCH_PARENT = -1;
  public static final int POSITION_PROMPT_ABOVE = 0;
  public static final int POSITION_PROMPT_BELOW = 1;
  private static final String TAG = "ListPopupWindow";
  public static final int WRAP_CONTENT = -2;
  private static Method sClipToWindowEnabledMethod;
  private static Method sGetMaxAvailableHeightMethod;
  private ListAdapter mAdapter;
  private Context mContext;
  private boolean mDropDownAlwaysVisible = false;
  private View mDropDownAnchorView;
  private int mDropDownGravity = 0;
  private int mDropDownHeight = -2;
  private int mDropDownHorizontalOffset;
  private a mDropDownList;
  private Drawable mDropDownListHighlight;
  private int mDropDownVerticalOffset;
  private boolean mDropDownVerticalOffsetSet;
  private int mDropDownWidth = -2;
  private int mDropDownWindowLayoutType = 1002;
  private boolean mForceIgnoreOutsideTouch = false;
  private final Handler mHandler;
  private final b mHideSelector = new b(null);
  private AdapterView.OnItemClickListener mItemClickListener;
  private AdapterView.OnItemSelectedListener mItemSelectedListener;
  private int mLayoutDirection;
  int mListItemExpandMaximum = Integer.MAX_VALUE;
  private boolean mModal;
  private DataSetObserver mObserver;
  private PopupWindow mPopup;
  private int mPromptPosition = 0;
  private View mPromptView;
  private final f mResizePopupRunnable = new f(null);
  private final d mScrollListener = new d(null);
  private Runnable mShowDropDownRunnable;
  private Rect mTempRect = new Rect();
  private final e mTouchInterceptor = new e(null);
  
  static
  {
    try
    {
      sClipToWindowEnabledMethod = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[] { Boolean.TYPE });
    }
    catch (NoSuchMethodException localNoSuchMethodException1)
    {
      for (;;)
      {
        try
        {
          sGetMaxAvailableHeightMethod = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", new Class[] { View.class, Integer.TYPE, Boolean.TYPE });
          return;
        }
        catch (NoSuchMethodException localNoSuchMethodException2)
        {
          Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
        }
        localNoSuchMethodException1 = localNoSuchMethodException1;
        Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
      }
    }
  }
  
  public ListPopupWindow(Context paramContext)
  {
    this(paramContext, null, a.a.listPopupWindowStyle);
  }
  
  public ListPopupWindow(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.a.listPopupWindowStyle);
  }
  
  public ListPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  public ListPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    this.mContext = paramContext;
    this.mHandler = new Handler(paramContext.getMainLooper());
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.ListPopupWindow, paramInt1, paramInt2);
    this.mDropDownHorizontalOffset = localTypedArray.getDimensionPixelOffset(a.k.ListPopupWindow_android_dropDownHorizontalOffset, 0);
    this.mDropDownVerticalOffset = localTypedArray.getDimensionPixelOffset(a.k.ListPopupWindow_android_dropDownVerticalOffset, 0);
    if (this.mDropDownVerticalOffset != 0) {
      this.mDropDownVerticalOffsetSet = true;
    }
    localTypedArray.recycle();
    this.mPopup = new AppCompatPopupWindow(paramContext, paramAttributeSet, paramInt1);
    this.mPopup.setInputMethodMode(1);
    this.mLayoutDirection = TextUtilsCompat.getLayoutDirectionFromLocale(this.mContext.getResources().getConfiguration().locale);
  }
  
  private int buildDropDown()
  {
    boolean bool2 = true;
    Object localObject2;
    boolean bool1;
    Object localObject1;
    View localView;
    LinearLayout.LayoutParams localLayoutParams;
    label245:
    int j;
    int i;
    if (this.mDropDownList == null)
    {
      localObject2 = this.mContext;
      this.mShowDropDownRunnable = new am(this);
      if (!this.mModal)
      {
        bool1 = true;
        this.mDropDownList = new a((Context)localObject2, bool1);
        if (this.mDropDownListHighlight != null) {
          this.mDropDownList.setSelector(this.mDropDownListHighlight);
        }
        this.mDropDownList.setAdapter(this.mAdapter);
        this.mDropDownList.setOnItemClickListener(this.mItemClickListener);
        this.mDropDownList.setFocusable(true);
        this.mDropDownList.setFocusableInTouchMode(true);
        this.mDropDownList.setOnItemSelectedListener(new an(this));
        this.mDropDownList.setOnScrollListener(this.mScrollListener);
        if (this.mItemSelectedListener != null) {
          this.mDropDownList.setOnItemSelectedListener(this.mItemSelectedListener);
        }
        localObject1 = this.mDropDownList;
        localView = this.mPromptView;
        if (localView == null) {
          break label714;
        }
        localObject2 = new LinearLayout((Context)localObject2);
        ((LinearLayout)localObject2).setOrientation(1);
        localLayoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0F);
        switch (this.mPromptPosition)
        {
        default: 
          Log.e("ListPopupWindow", "Invalid hint position " + this.mPromptPosition);
          if (this.mDropDownWidth >= 0)
          {
            j = this.mDropDownWidth;
            i = Integer.MIN_VALUE;
            label263:
            localView.measure(View.MeasureSpec.makeMeasureSpec(j, i), 0);
            localObject1 = (LinearLayout.LayoutParams)localView.getLayoutParams();
            i = localView.getMeasuredHeight();
            j = ((LinearLayout.LayoutParams)localObject1).topMargin;
            i = ((LinearLayout.LayoutParams)localObject1).bottomMargin + (i + j);
            localObject1 = localObject2;
          }
          break;
        }
      }
    }
    for (;;)
    {
      this.mPopup.setContentView((View)localObject1);
      for (;;)
      {
        label317:
        localObject1 = this.mPopup.getBackground();
        if (localObject1 != null)
        {
          ((Drawable)localObject1).getPadding(this.mTempRect);
          j = this.mTempRect.top + this.mTempRect.bottom;
          if (this.mDropDownVerticalOffsetSet) {
            break label705;
          }
          this.mDropDownVerticalOffset = (-this.mTempRect.top);
        }
        label374:
        label545:
        label705:
        for (;;)
        {
          if (this.mPopup.getInputMethodMode() == 2) {}
          int m;
          for (bool1 = bool2;; bool1 = false)
          {
            m = getMaxAvailableHeight(getAnchorView(), this.mDropDownVerticalOffset, bool1);
            if ((!this.mDropDownAlwaysVisible) && (this.mDropDownHeight != -1)) {
              break label545;
            }
            return m + j;
            bool1 = false;
            break;
            ((LinearLayout)localObject2).addView((View)localObject1, localLayoutParams);
            ((LinearLayout)localObject2).addView(localView);
            break label245;
            ((LinearLayout)localObject2).addView(localView);
            ((LinearLayout)localObject2).addView((View)localObject1, localLayoutParams);
            break label245;
            i = 0;
            j = 0;
            break label263;
            localObject1 = (ViewGroup)this.mPopup.getContentView();
            localObject1 = this.mPromptView;
            if (localObject1 == null) {
              break label708;
            }
            localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
            i = ((View)localObject1).getMeasuredHeight();
            j = ((LinearLayout.LayoutParams)localObject2).topMargin;
            i = ((LinearLayout.LayoutParams)localObject2).bottomMargin + (i + j);
            break label317;
            this.mTempRect.setEmpty();
            j = 0;
            break label374;
          }
          int k;
          switch (this.mDropDownWidth)
          {
          default: 
            k = View.MeasureSpec.makeMeasureSpec(this.mDropDownWidth, 1073741824);
          }
          for (;;)
          {
            m = this.mDropDownList.measureHeightOfChildrenCompat(k, 0, -1, m - i, -1);
            k = i;
            if (m > 0) {
              k = i + j;
            }
            return m + k;
            k = View.MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right), Integer.MIN_VALUE);
            continue;
            k = View.MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right), 1073741824);
          }
        }
        label708:
        i = 0;
      }
      label714:
      i = 0;
    }
  }
  
  private int getMaxAvailableHeight(View paramView, int paramInt, boolean paramBoolean)
  {
    if (sGetMaxAvailableHeightMethod != null) {
      try
      {
        int i = ((Integer)sGetMaxAvailableHeightMethod.invoke(this.mPopup, new Object[] { paramView, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) })).intValue();
        return i;
      }
      catch (Exception localException)
      {
        Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
      }
    }
    return this.mPopup.getMaxAvailableHeight(paramView, paramInt);
  }
  
  private static boolean isConfirmKey(int paramInt)
  {
    return (paramInt == 66) || (paramInt == 23);
  }
  
  private void removePromptView()
  {
    if (this.mPromptView != null)
    {
      ViewParent localViewParent = this.mPromptView.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(this.mPromptView);
      }
    }
  }
  
  private void setPopupClipToScreenEnabled(boolean paramBoolean)
  {
    if (sClipToWindowEnabledMethod != null) {}
    try
    {
      sClipToWindowEnabledMethod.invoke(this.mPopup, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (Exception localException)
    {
      Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
    }
  }
  
  public void clearListSelection()
  {
    a locala = this.mDropDownList;
    if (locala != null)
    {
      a.a(locala, true);
      locala.requestLayout();
    }
  }
  
  public View.OnTouchListener createDragToOpenListener(View paramView)
  {
    return new al(this, paramView);
  }
  
  public void dismiss()
  {
    this.mPopup.dismiss();
    removePromptView();
    this.mPopup.setContentView(null);
    this.mDropDownList = null;
    this.mHandler.removeCallbacks(this.mResizePopupRunnable);
  }
  
  public View getAnchorView()
  {
    return this.mDropDownAnchorView;
  }
  
  public int getAnimationStyle()
  {
    return this.mPopup.getAnimationStyle();
  }
  
  public Drawable getBackground()
  {
    return this.mPopup.getBackground();
  }
  
  public int getHeight()
  {
    return this.mDropDownHeight;
  }
  
  public int getHorizontalOffset()
  {
    return this.mDropDownHorizontalOffset;
  }
  
  public int getInputMethodMode()
  {
    return this.mPopup.getInputMethodMode();
  }
  
  public ListView getListView()
  {
    return this.mDropDownList;
  }
  
  public int getPromptPosition()
  {
    return this.mPromptPosition;
  }
  
  public Object getSelectedItem()
  {
    if (!isShowing()) {
      return null;
    }
    return this.mDropDownList.getSelectedItem();
  }
  
  public long getSelectedItemId()
  {
    if (!isShowing()) {
      return Long.MIN_VALUE;
    }
    return this.mDropDownList.getSelectedItemId();
  }
  
  public int getSelectedItemPosition()
  {
    if (!isShowing()) {
      return -1;
    }
    return this.mDropDownList.getSelectedItemPosition();
  }
  
  public View getSelectedView()
  {
    if (!isShowing()) {
      return null;
    }
    return this.mDropDownList.getSelectedView();
  }
  
  public int getSoftInputMode()
  {
    return this.mPopup.getSoftInputMode();
  }
  
  public int getVerticalOffset()
  {
    if (!this.mDropDownVerticalOffsetSet) {
      return 0;
    }
    return this.mDropDownVerticalOffset;
  }
  
  public int getWidth()
  {
    return this.mDropDownWidth;
  }
  
  public boolean isDropDownAlwaysVisible()
  {
    return this.mDropDownAlwaysVisible;
  }
  
  public boolean isInputMethodNotNeeded()
  {
    return this.mPopup.getInputMethodMode() == 2;
  }
  
  public boolean isModal()
  {
    return this.mModal;
  }
  
  public boolean isShowing()
  {
    return this.mPopup.isShowing();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    int m;
    int k;
    int i;
    int j;
    if ((isShowing()) && (paramInt != 62) && ((this.mDropDownList.getSelectedItemPosition() >= 0) || (!isConfirmKey(paramInt))))
    {
      m = this.mDropDownList.getSelectedItemPosition();
      ListAdapter localListAdapter;
      if (!this.mPopup.isAboveAnchor())
      {
        k = 1;
        localListAdapter = this.mAdapter;
        i = Integer.MAX_VALUE;
        j = Integer.MIN_VALUE;
        if (localListAdapter != null)
        {
          boolean bool = localListAdapter.areAllItemsEnabled();
          if (!bool) {
            break label161;
          }
          i = 0;
          label86:
          if (!bool) {
            break label175;
          }
        }
      }
      label161:
      label175:
      for (j = localListAdapter.getCount() - 1;; j = this.mDropDownList.lookForSelectablePosition(localListAdapter.getCount() - 1, false))
      {
        if (((k == 0) || (paramInt != 19) || (m > i)) && ((k != 0) || (paramInt != 20) || (m < j))) {
          break label196;
        }
        clearListSelection();
        this.mPopup.setInputMethodMode(1);
        show();
        return true;
        k = 0;
        break;
        i = this.mDropDownList.lookForSelectablePosition(0, true);
        break label86;
      }
      label196:
      a.a(this.mDropDownList, false);
      if (!this.mDropDownList.onKeyDown(paramInt, paramKeyEvent)) {
        break label282;
      }
      this.mPopup.setInputMethodMode(2);
      this.mDropDownList.requestFocusFromTouch();
      show();
      switch (paramInt)
      {
      }
    }
    label282:
    do
    {
      do
      {
        return false;
        if ((k == 0) || (paramInt != 20)) {
          break;
        }
      } while (m != j);
      return true;
    } while ((k != 0) || (paramInt != 19) || (m != i));
    return true;
  }
  
  public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (isShowing()))
    {
      Object localObject = this.mDropDownAnchorView;
      if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
      {
        localObject = ((View)localObject).getKeyDispatcherState();
        if (localObject != null) {
          ((KeyEvent.DispatcherState)localObject).startTracking(paramKeyEvent, this);
        }
        return true;
      }
      if (paramKeyEvent.getAction() == 1)
      {
        localObject = ((View)localObject).getKeyDispatcherState();
        if (localObject != null) {
          ((KeyEvent.DispatcherState)localObject).handleUpEvent(paramKeyEvent);
        }
        if ((paramKeyEvent.isTracking()) && (!paramKeyEvent.isCanceled()))
        {
          dismiss();
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((isShowing()) && (this.mDropDownList.getSelectedItemPosition() >= 0))
    {
      boolean bool = this.mDropDownList.onKeyUp(paramInt, paramKeyEvent);
      if ((bool) && (isConfirmKey(paramInt))) {
        dismiss();
      }
      return bool;
    }
    return false;
  }
  
  public boolean performItemClick(int paramInt)
  {
    if (isShowing())
    {
      if (this.mItemClickListener != null)
      {
        a locala = this.mDropDownList;
        View localView = locala.getChildAt(paramInt - locala.getFirstVisiblePosition());
        ListAdapter localListAdapter = locala.getAdapter();
        this.mItemClickListener.onItemClick(locala, localView, paramInt, localListAdapter.getItemId(paramInt));
      }
      return true;
    }
    return false;
  }
  
  public void postShow()
  {
    this.mHandler.post(this.mShowDropDownRunnable);
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if (this.mObserver == null) {
      this.mObserver = new c(null);
    }
    for (;;)
    {
      this.mAdapter = paramListAdapter;
      if (this.mAdapter != null) {
        paramListAdapter.registerDataSetObserver(this.mObserver);
      }
      if (this.mDropDownList != null) {
        this.mDropDownList.setAdapter(this.mAdapter);
      }
      return;
      if (this.mAdapter != null) {
        this.mAdapter.unregisterDataSetObserver(this.mObserver);
      }
    }
  }
  
  public void setAnchorView(View paramView)
  {
    this.mDropDownAnchorView = paramView;
  }
  
  public void setAnimationStyle(int paramInt)
  {
    this.mPopup.setAnimationStyle(paramInt);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    this.mPopup.setBackgroundDrawable(paramDrawable);
  }
  
  public void setContentWidth(int paramInt)
  {
    Drawable localDrawable = this.mPopup.getBackground();
    if (localDrawable != null)
    {
      localDrawable.getPadding(this.mTempRect);
      this.mDropDownWidth = (this.mTempRect.left + this.mTempRect.right + paramInt);
      return;
    }
    setWidth(paramInt);
  }
  
  public void setDropDownAlwaysVisible(boolean paramBoolean)
  {
    this.mDropDownAlwaysVisible = paramBoolean;
  }
  
  public void setDropDownGravity(int paramInt)
  {
    this.mDropDownGravity = paramInt;
  }
  
  public void setForceIgnoreOutsideTouch(boolean paramBoolean)
  {
    this.mForceIgnoreOutsideTouch = paramBoolean;
  }
  
  public void setHeight(int paramInt)
  {
    this.mDropDownHeight = paramInt;
  }
  
  public void setHorizontalOffset(int paramInt)
  {
    this.mDropDownHorizontalOffset = paramInt;
  }
  
  public void setInputMethodMode(int paramInt)
  {
    this.mPopup.setInputMethodMode(paramInt);
  }
  
  void setListItemExpandMax(int paramInt)
  {
    this.mListItemExpandMaximum = paramInt;
  }
  
  public void setListSelector(Drawable paramDrawable)
  {
    this.mDropDownListHighlight = paramDrawable;
  }
  
  public void setModal(boolean paramBoolean)
  {
    this.mModal = paramBoolean;
    this.mPopup.setFocusable(paramBoolean);
  }
  
  public void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.mPopup.setOnDismissListener(paramOnDismissListener);
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.mItemClickListener = paramOnItemClickListener;
  }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.mItemSelectedListener = paramOnItemSelectedListener;
  }
  
  public void setPromptPosition(int paramInt)
  {
    this.mPromptPosition = paramInt;
  }
  
  public void setPromptView(View paramView)
  {
    boolean bool = isShowing();
    if (bool) {
      removePromptView();
    }
    this.mPromptView = paramView;
    if (bool) {
      show();
    }
  }
  
  public void setSelection(int paramInt)
  {
    a locala = this.mDropDownList;
    if ((isShowing()) && (locala != null))
    {
      a.a(locala, false);
      locala.setSelection(paramInt);
      if ((Build.VERSION.SDK_INT >= 11) && (locala.getChoiceMode() != 0)) {
        locala.setItemChecked(paramInt, true);
      }
    }
  }
  
  public void setSoftInputMode(int paramInt)
  {
    this.mPopup.setSoftInputMode(paramInt);
  }
  
  public void setVerticalOffset(int paramInt)
  {
    this.mDropDownVerticalOffset = paramInt;
    this.mDropDownVerticalOffsetSet = true;
  }
  
  public void setWidth(int paramInt)
  {
    this.mDropDownWidth = paramInt;
  }
  
  public void setWindowLayoutType(int paramInt)
  {
    this.mDropDownWindowLayoutType = paramInt;
  }
  
  public void show()
  {
    boolean bool1 = true;
    boolean bool2 = false;
    int m = -1;
    int i = buildDropDown();
    boolean bool3 = isInputMethodNotNeeded();
    PopupWindowCompat.setWindowLayoutType(this.mPopup, this.mDropDownWindowLayoutType);
    int j;
    label65:
    PopupWindow localPopupWindow;
    if (this.mPopup.isShowing())
    {
      int k;
      label86:
      label100:
      View localView;
      int n;
      int i1;
      if (this.mDropDownWidth == -1)
      {
        j = -1;
        if (this.mDropDownHeight != -1) {
          break label270;
        }
        if (!bool3) {
          break label220;
        }
        if (!bool3) {
          break label231;
        }
        localPopupWindow = this.mPopup;
        if (this.mDropDownWidth != -1) {
          break label225;
        }
        k = -1;
        localPopupWindow.setWidth(k);
        this.mPopup.setHeight(0);
        localPopupWindow = this.mPopup;
        bool1 = bool2;
        if (!this.mForceIgnoreOutsideTouch)
        {
          bool1 = bool2;
          if (!this.mDropDownAlwaysVisible) {
            bool1 = true;
          }
        }
        localPopupWindow.setOutsideTouchable(bool1);
        localPopupWindow = this.mPopup;
        localView = getAnchorView();
        n = this.mDropDownHorizontalOffset;
        i1 = this.mDropDownVerticalOffset;
        k = j;
        if (j < 0) {
          k = -1;
        }
        if (i >= 0) {
          break label290;
        }
        i = m;
      }
      label220:
      label225:
      label231:
      label270:
      label290:
      for (;;)
      {
        localPopupWindow.update(localView, n, i1, k, i);
        return;
        if (this.mDropDownWidth == -2)
        {
          j = getAnchorView().getWidth();
          break;
        }
        j = this.mDropDownWidth;
        break;
        i = -1;
        break label65;
        k = 0;
        break label86;
        localPopupWindow = this.mPopup;
        if (this.mDropDownWidth == -1) {}
        for (k = -1;; k = 0)
        {
          localPopupWindow.setWidth(k);
          this.mPopup.setHeight(-1);
          break;
        }
        if (this.mDropDownHeight == -2) {
          break label100;
        }
        i = this.mDropDownHeight;
        break label100;
      }
    }
    if (this.mDropDownWidth == -1)
    {
      j = -1;
      label304:
      if (this.mDropDownHeight != -1) {
        break label474;
      }
      i = -1;
      label314:
      this.mPopup.setWidth(j);
      this.mPopup.setHeight(i);
      setPopupClipToScreenEnabled(true);
      localPopupWindow = this.mPopup;
      if ((this.mForceIgnoreOutsideTouch) || (this.mDropDownAlwaysVisible)) {
        break label491;
      }
    }
    for (;;)
    {
      localPopupWindow.setOutsideTouchable(bool1);
      this.mPopup.setTouchInterceptor(this.mTouchInterceptor);
      PopupWindowCompat.showAsDropDown(this.mPopup, getAnchorView(), this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset, this.mDropDownGravity);
      this.mDropDownList.setSelection(-1);
      if ((!this.mModal) || (this.mDropDownList.isInTouchMode())) {
        clearListSelection();
      }
      if (this.mModal) {
        break;
      }
      this.mHandler.post(this.mHideSelector);
      return;
      if (this.mDropDownWidth == -2)
      {
        j = getAnchorView().getWidth();
        break label304;
      }
      j = this.mDropDownWidth;
      break label304;
      label474:
      if (this.mDropDownHeight == -2) {
        break label314;
      }
      i = this.mDropDownHeight;
      break label314;
      label491:
      bool1 = false;
    }
  }
  
  public static abstract class ForwardingListener
    implements View.OnTouchListener
  {
    private int mActivePointerId;
    private Runnable mDisallowIntercept;
    private boolean mForwarding;
    private final int mLongPressTimeout;
    private final float mScaledTouchSlop;
    private final View mSrc;
    private final int mTapTimeout;
    private final int[] mTmpLocation = new int[2];
    private Runnable mTriggerLongPress;
    private boolean mWasLongPress;
    
    public ForwardingListener(View paramView)
    {
      this.mSrc = paramView;
      this.mScaledTouchSlop = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
      this.mTapTimeout = ViewConfiguration.getTapTimeout();
      this.mLongPressTimeout = ((this.mTapTimeout + ViewConfiguration.getLongPressTimeout()) / 2);
    }
    
    private void clearCallbacks()
    {
      if (this.mTriggerLongPress != null) {
        this.mSrc.removeCallbacks(this.mTriggerLongPress);
      }
      if (this.mDisallowIntercept != null) {
        this.mSrc.removeCallbacks(this.mDisallowIntercept);
      }
    }
    
    private void onLongPress()
    {
      clearCallbacks();
      View localView = this.mSrc;
      if ((!localView.isEnabled()) || (localView.isLongClickable())) {}
      while (!onForwardingStarted()) {
        return;
      }
      localView.getParent().requestDisallowInterceptTouchEvent(true);
      long l = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
      localView.onTouchEvent(localMotionEvent);
      localMotionEvent.recycle();
      this.mForwarding = true;
      this.mWasLongPress = true;
    }
    
    private boolean onTouchForwarded(MotionEvent paramMotionEvent)
    {
      boolean bool1 = true;
      View localView = this.mSrc;
      Object localObject = getPopup();
      if ((localObject == null) || (!((ListPopupWindow)localObject).isShowing())) {}
      do
      {
        return false;
        localObject = ((ListPopupWindow)localObject).mDropDownList;
      } while ((localObject == null) || (!((ListPopupWindow.a)localObject).isShown()));
      MotionEvent localMotionEvent = MotionEvent.obtainNoHistory(paramMotionEvent);
      toGlobalMotionEvent(localView, localMotionEvent);
      toLocalMotionEvent((View)localObject, localMotionEvent);
      boolean bool2 = ((ListPopupWindow.a)localObject).a(localMotionEvent, this.mActivePointerId);
      localMotionEvent.recycle();
      int i = MotionEventCompat.getActionMasked(paramMotionEvent);
      if ((i != 1) && (i != 3))
      {
        i = 1;
        if ((!bool2) || (i == 0)) {
          break label121;
        }
      }
      for (;;)
      {
        return bool1;
        i = 0;
        break;
        label121:
        bool1 = false;
      }
    }
    
    private boolean onTouchObserved(MotionEvent paramMotionEvent)
    {
      View localView = this.mSrc;
      if (!localView.isEnabled()) {}
      int i;
      do
      {
        return false;
        switch (MotionEventCompat.getActionMasked(paramMotionEvent))
        {
        default: 
          return false;
        case 0: 
          this.mActivePointerId = paramMotionEvent.getPointerId(0);
          this.mWasLongPress = false;
          if (this.mDisallowIntercept == null) {
            this.mDisallowIntercept = new a(null);
          }
          localView.postDelayed(this.mDisallowIntercept, this.mTapTimeout);
          if (this.mTriggerLongPress == null) {
            this.mTriggerLongPress = new b(null);
          }
          localView.postDelayed(this.mTriggerLongPress, this.mLongPressTimeout);
          return false;
        case 2: 
          i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
        }
      } while ((i < 0) || (pointInView(localView, paramMotionEvent.getX(i), paramMotionEvent.getY(i), this.mScaledTouchSlop)));
      clearCallbacks();
      localView.getParent().requestDisallowInterceptTouchEvent(true);
      return true;
      clearCallbacks();
      return false;
    }
    
    private static boolean pointInView(View paramView, float paramFloat1, float paramFloat2, float paramFloat3)
    {
      return (paramFloat1 >= -paramFloat3) && (paramFloat2 >= -paramFloat3) && (paramFloat1 < paramView.getRight() - paramView.getLeft() + paramFloat3) && (paramFloat2 < paramView.getBottom() - paramView.getTop() + paramFloat3);
    }
    
    private boolean toGlobalMotionEvent(View paramView, MotionEvent paramMotionEvent)
    {
      int[] arrayOfInt = this.mTmpLocation;
      paramView.getLocationOnScreen(arrayOfInt);
      paramMotionEvent.offsetLocation(arrayOfInt[0], arrayOfInt[1]);
      return true;
    }
    
    private boolean toLocalMotionEvent(View paramView, MotionEvent paramMotionEvent)
    {
      int[] arrayOfInt = this.mTmpLocation;
      paramView.getLocationOnScreen(arrayOfInt);
      paramMotionEvent.offsetLocation(-arrayOfInt[0], -arrayOfInt[1]);
      return true;
    }
    
    public abstract ListPopupWindow getPopup();
    
    protected boolean onForwardingStarted()
    {
      ListPopupWindow localListPopupWindow = getPopup();
      if ((localListPopupWindow != null) && (!localListPopupWindow.isShowing())) {
        localListPopupWindow.show();
      }
      return true;
    }
    
    protected boolean onForwardingStopped()
    {
      ListPopupWindow localListPopupWindow = getPopup();
      if ((localListPopupWindow != null) && (localListPopupWindow.isShowing())) {
        localListPopupWindow.dismiss();
      }
      return true;
    }
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      boolean bool2 = false;
      boolean bool3 = this.mForwarding;
      if (bool3)
      {
        if (this.mWasLongPress) {
          bool1 = onTouchForwarded(paramMotionEvent);
        }
        for (;;)
        {
          this.mForwarding = bool1;
          if (!bool1)
          {
            bool1 = bool2;
            if (!bool3) {}
          }
          else
          {
            bool1 = true;
          }
          return bool1;
          if ((onTouchForwarded(paramMotionEvent)) || (!onForwardingStopped())) {
            bool1 = true;
          } else {
            bool1 = false;
          }
        }
      }
      if ((onTouchObserved(paramMotionEvent)) && (onForwardingStarted())) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        if (bool1)
        {
          long l = SystemClock.uptimeMillis();
          paramView = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
          this.mSrc.onTouchEvent(paramView);
          paramView.recycle();
        }
        break;
      }
    }
    
    private class a
      implements Runnable
    {
      private a() {}
      
      public void run()
      {
        ListPopupWindow.ForwardingListener.this.mSrc.getParent().requestDisallowInterceptTouchEvent(true);
      }
    }
    
    private class b
      implements Runnable
    {
      private b() {}
      
      public void run()
      {
        ListPopupWindow.ForwardingListener.this.onLongPress();
      }
    }
  }
  
  private static class a
    extends ListViewCompat
  {
    private boolean a;
    private boolean b;
    private boolean c;
    private ViewPropertyAnimatorCompat d;
    private ListViewAutoScrollHelper e;
    
    public a(Context paramContext, boolean paramBoolean)
    {
      super(null, a.a.dropDownListViewStyle);
      this.b = paramBoolean;
      setCacheColorHint(0);
    }
    
    private void a()
    {
      this.c = false;
      setPressed(false);
      drawableStateChanged();
      View localView = getChildAt(this.mMotionPosition - getFirstVisiblePosition());
      if (localView != null) {
        localView.setPressed(false);
      }
      if (this.d != null)
      {
        this.d.cancel();
        this.d = null;
      }
    }
    
    private void a(View paramView, int paramInt)
    {
      performItemClick(paramView, paramInt, getItemIdAtPosition(paramInt));
    }
    
    private void a(View paramView, int paramInt, float paramFloat1, float paramFloat2)
    {
      this.c = true;
      if (Build.VERSION.SDK_INT >= 21) {
        drawableHotspotChanged(paramFloat1, paramFloat2);
      }
      if (!isPressed()) {
        setPressed(true);
      }
      layoutChildren();
      if (this.mMotionPosition != -1)
      {
        View localView = getChildAt(this.mMotionPosition - getFirstVisiblePosition());
        if ((localView != null) && (localView != paramView) && (localView.isPressed())) {
          localView.setPressed(false);
        }
      }
      this.mMotionPosition = paramInt;
      float f1 = paramView.getLeft();
      float f2 = paramView.getTop();
      if (Build.VERSION.SDK_INT >= 21) {
        paramView.drawableHotspotChanged(paramFloat1 - f1, paramFloat2 - f2);
      }
      if (!paramView.isPressed()) {
        paramView.setPressed(true);
      }
      positionSelectorLikeTouchCompat(paramInt, paramView, paramFloat1, paramFloat2);
      setSelectorEnabled(false);
      refreshDrawableState();
    }
    
    public boolean a(MotionEvent paramMotionEvent, int paramInt)
    {
      int i = MotionEventCompat.getActionMasked(paramMotionEvent);
      switch (i)
      {
      default: 
        paramInt = 0;
      case 3: 
        for (bool = true;; bool = false)
        {
          label41:
          if ((!bool) || (paramInt != 0)) {
            a();
          }
          if (!bool) {
            break;
          }
          if (this.e == null) {
            this.e = new ListViewAutoScrollHelper(this);
          }
          this.e.setEnabled(true);
          this.e.onTouch(this, paramMotionEvent);
          label97:
          return bool;
          paramInt = 0;
        }
      }
      for (boolean bool = false;; bool = true)
      {
        int j = paramMotionEvent.findPointerIndex(paramInt);
        if (j < 0)
        {
          paramInt = 0;
          bool = false;
          break label41;
        }
        paramInt = (int)paramMotionEvent.getX(j);
        j = (int)paramMotionEvent.getY(j);
        int k = pointToPosition(paramInt, j);
        if (k == -1)
        {
          paramInt = 1;
          break label41;
        }
        View localView = getChildAt(k - getFirstVisiblePosition());
        a(localView, k, paramInt, j);
        if (i != 1) {
          break;
        }
        a(localView, k);
        break;
        if (this.e == null) {
          break label97;
        }
        this.e.setEnabled(false);
        return bool;
      }
    }
    
    public boolean hasFocus()
    {
      return (this.b) || (super.hasFocus());
    }
    
    public boolean hasWindowFocus()
    {
      return (this.b) || (super.hasWindowFocus());
    }
    
    public boolean isFocused()
    {
      return (this.b) || (super.isFocused());
    }
    
    public boolean isInTouchMode()
    {
      return ((this.b) && (this.a)) || (super.isInTouchMode());
    }
    
    protected boolean touchModeDrawsInPressedStateCompat()
    {
      return (this.c) || (super.touchModeDrawsInPressedStateCompat());
    }
  }
  
  private class b
    implements Runnable
  {
    private b() {}
    
    public void run()
    {
      ListPopupWindow.this.clearListSelection();
    }
  }
  
  private class c
    extends DataSetObserver
  {
    private c() {}
    
    public void onChanged()
    {
      if (ListPopupWindow.this.isShowing()) {
        ListPopupWindow.this.show();
      }
    }
    
    public void onInvalidated()
    {
      ListPopupWindow.this.dismiss();
    }
  }
  
  private class d
    implements AbsListView.OnScrollListener
  {
    private d() {}
    
    public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      if ((paramInt == 1) && (!ListPopupWindow.this.isInputMethodNotNeeded()) && (ListPopupWindow.this.mPopup.getContentView() != null))
      {
        ListPopupWindow.this.mHandler.removeCallbacks(ListPopupWindow.this.mResizePopupRunnable);
        ListPopupWindow.this.mResizePopupRunnable.run();
      }
    }
  }
  
  private class e
    implements View.OnTouchListener
  {
    private e() {}
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      int i = paramMotionEvent.getAction();
      int j = (int)paramMotionEvent.getX();
      int k = (int)paramMotionEvent.getY();
      if ((i == 0) && (ListPopupWindow.this.mPopup != null) && (ListPopupWindow.this.mPopup.isShowing()) && (j >= 0) && (j < ListPopupWindow.this.mPopup.getWidth()) && (k >= 0) && (k < ListPopupWindow.this.mPopup.getHeight())) {
        ListPopupWindow.this.mHandler.postDelayed(ListPopupWindow.this.mResizePopupRunnable, 250L);
      }
      for (;;)
      {
        return false;
        if (i == 1) {
          ListPopupWindow.this.mHandler.removeCallbacks(ListPopupWindow.this.mResizePopupRunnable);
        }
      }
    }
  }
  
  private class f
    implements Runnable
  {
    private f() {}
    
    public void run()
    {
      if ((ListPopupWindow.this.mDropDownList != null) && (ViewCompat.isAttachedToWindow(ListPopupWindow.this.mDropDownList)) && (ListPopupWindow.this.mDropDownList.getCount() > ListPopupWindow.this.mDropDownList.getChildCount()) && (ListPopupWindow.this.mDropDownList.getChildCount() <= ListPopupWindow.this.mListItemExpandMaximum))
      {
        ListPopupWindow.this.mPopup.setInputMethodMode(2);
        ListPopupWindow.this.show();
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\ListPopupWindow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */