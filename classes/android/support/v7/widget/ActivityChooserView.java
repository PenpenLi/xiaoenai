package android.support.v7.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.ViewCompat;
import android.support.v7.a.a.d;
import android.support.v7.a.a.f;
import android.support.v7.a.a.h;
import android.support.v7.a.a.i;
import android.support.v7.a.a.k;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;

public class ActivityChooserView
  extends ViewGroup
  implements ActivityChooserModel.ActivityChooserModelClient
{
  private static final String LOG_TAG = "ActivityChooserView";
  private final LinearLayoutCompat mActivityChooserContent;
  private final Drawable mActivityChooserContentBackground;
  private final a mAdapter;
  private final b mCallbacks;
  private int mDefaultActionButtonContentDescription;
  private final FrameLayout mDefaultActivityButton;
  private final ImageView mDefaultActivityButtonImage;
  private final FrameLayout mExpandActivityOverflowButton;
  private final ImageView mExpandActivityOverflowButtonImage;
  private int mInitialActivityCount = 4;
  private boolean mIsAttachedToWindow;
  private boolean mIsSelectingDefaultActivity;
  private final int mListPopupMaxWidth;
  private ListPopupWindow mListPopupWindow;
  private final DataSetObserver mModelDataSetOberver = new j(this);
  private PopupWindow.OnDismissListener mOnDismissListener;
  private final ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener = new k(this);
  ActionProvider mProvider;
  
  public ActivityChooserView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActivityChooserView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ActivityChooserView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Object localObject = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.ActivityChooserView, paramInt, 0);
    this.mInitialActivityCount = ((TypedArray)localObject).getInt(a.k.ActivityChooserView_initialActivityCount, 4);
    paramAttributeSet = ((TypedArray)localObject).getDrawable(a.k.ActivityChooserView_expandActivityOverflowButtonDrawable);
    ((TypedArray)localObject).recycle();
    LayoutInflater.from(getContext()).inflate(a.h.abc_activity_chooser_view, this, true);
    this.mCallbacks = new b(null);
    this.mActivityChooserContent = ((LinearLayoutCompat)findViewById(a.f.activity_chooser_view_content));
    this.mActivityChooserContentBackground = this.mActivityChooserContent.getBackground();
    this.mDefaultActivityButton = ((FrameLayout)findViewById(a.f.default_activity_button));
    this.mDefaultActivityButton.setOnClickListener(this.mCallbacks);
    this.mDefaultActivityButton.setOnLongClickListener(this.mCallbacks);
    this.mDefaultActivityButtonImage = ((ImageView)this.mDefaultActivityButton.findViewById(a.f.image));
    localObject = (FrameLayout)findViewById(a.f.expand_activities_button);
    ((FrameLayout)localObject).setOnClickListener(this.mCallbacks);
    ((FrameLayout)localObject).setOnTouchListener(new l(this, (View)localObject));
    this.mExpandActivityOverflowButton = ((FrameLayout)localObject);
    this.mExpandActivityOverflowButtonImage = ((ImageView)((FrameLayout)localObject).findViewById(a.f.image));
    this.mExpandActivityOverflowButtonImage.setImageDrawable(paramAttributeSet);
    this.mAdapter = new a(null);
    this.mAdapter.registerDataSetObserver(new m(this));
    paramContext = paramContext.getResources();
    this.mListPopupMaxWidth = Math.max(paramContext.getDisplayMetrics().widthPixels / 2, paramContext.getDimensionPixelSize(a.d.abc_config_prefDialogWidth));
  }
  
  private ListPopupWindow getListPopupWindow()
  {
    if (this.mListPopupWindow == null)
    {
      this.mListPopupWindow = new ListPopupWindow(getContext());
      this.mListPopupWindow.setAdapter(this.mAdapter);
      this.mListPopupWindow.setAnchorView(this);
      this.mListPopupWindow.setModal(true);
      this.mListPopupWindow.setOnItemClickListener(this.mCallbacks);
      this.mListPopupWindow.setOnDismissListener(this.mCallbacks);
    }
    return this.mListPopupWindow;
  }
  
  private void showPopupUnchecked(int paramInt)
  {
    if (this.mAdapter.e() == null) {
      throw new IllegalStateException("No data model. Did you call #setDataModel?");
    }
    getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
    boolean bool;
    int i;
    label61:
    label94:
    ListPopupWindow localListPopupWindow;
    if (this.mDefaultActivityButton.getVisibility() == 0)
    {
      bool = true;
      int j = this.mAdapter.c();
      if (!bool) {
        break label189;
      }
      i = 1;
      if ((paramInt == Integer.MAX_VALUE) || (j <= i + paramInt)) {
        break label194;
      }
      this.mAdapter.a(true);
      this.mAdapter.a(paramInt - 1);
      localListPopupWindow = getListPopupWindow();
      if (!localListPopupWindow.isShowing())
      {
        if ((!this.mIsSelectingDefaultActivity) && (bool)) {
          break label213;
        }
        this.mAdapter.a(true, bool);
      }
    }
    for (;;)
    {
      localListPopupWindow.setContentWidth(Math.min(this.mAdapter.a(), this.mListPopupMaxWidth));
      localListPopupWindow.show();
      if (this.mProvider != null) {
        this.mProvider.subUiVisibilityChanged(true);
      }
      localListPopupWindow.getListView().setContentDescription(getContext().getString(a.i.abc_activitychooserview_choose_application));
      return;
      bool = false;
      break;
      label189:
      i = 0;
      break label61;
      label194:
      this.mAdapter.a(false);
      this.mAdapter.a(paramInt);
      break label94;
      label213:
      this.mAdapter.a(false, false);
    }
  }
  
  private void updateAppearance()
  {
    if (this.mAdapter.getCount() > 0)
    {
      this.mExpandActivityOverflowButton.setEnabled(true);
      int i = this.mAdapter.c();
      int j = this.mAdapter.d();
      if ((i != 1) && ((i <= 1) || (j <= 0))) {
        break label160;
      }
      this.mDefaultActivityButton.setVisibility(0);
      Object localObject = this.mAdapter.b();
      PackageManager localPackageManager = getContext().getPackageManager();
      this.mDefaultActivityButtonImage.setImageDrawable(((ResolveInfo)localObject).loadIcon(localPackageManager));
      if (this.mDefaultActionButtonContentDescription != 0)
      {
        localObject = ((ResolveInfo)localObject).loadLabel(localPackageManager);
        localObject = getContext().getString(this.mDefaultActionButtonContentDescription, new Object[] { localObject });
        this.mDefaultActivityButton.setContentDescription((CharSequence)localObject);
      }
    }
    for (;;)
    {
      if (this.mDefaultActivityButton.getVisibility() != 0) {
        break label172;
      }
      this.mActivityChooserContent.setBackgroundDrawable(this.mActivityChooserContentBackground);
      return;
      this.mExpandActivityOverflowButton.setEnabled(false);
      break;
      label160:
      this.mDefaultActivityButton.setVisibility(8);
    }
    label172:
    this.mActivityChooserContent.setBackgroundDrawable(null);
  }
  
  public boolean dismissPopup()
  {
    if (isShowingPopup())
    {
      getListPopupWindow().dismiss();
      ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
      if (localViewTreeObserver.isAlive()) {
        localViewTreeObserver.removeGlobalOnLayoutListener(this.mOnGlobalLayoutListener);
      }
    }
    return true;
  }
  
  public ActivityChooserModel getDataModel()
  {
    return this.mAdapter.e();
  }
  
  public boolean isShowingPopup()
  {
    return getListPopupWindow().isShowing();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ActivityChooserModel localActivityChooserModel = this.mAdapter.e();
    if (localActivityChooserModel != null) {
      localActivityChooserModel.registerObserver(this.mModelDataSetOberver);
    }
    this.mIsAttachedToWindow = true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Object localObject = this.mAdapter.e();
    if (localObject != null) {
      ((ActivityChooserModel)localObject).unregisterObserver(this.mModelDataSetOberver);
    }
    localObject = getViewTreeObserver();
    if (((ViewTreeObserver)localObject).isAlive()) {
      ((ViewTreeObserver)localObject).removeGlobalOnLayoutListener(this.mOnGlobalLayoutListener);
    }
    if (isShowingPopup()) {
      dismissPopup();
    }
    this.mIsAttachedToWindow = false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mActivityChooserContent.layout(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
    if (!isShowingPopup()) {
      dismissPopup();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    LinearLayoutCompat localLinearLayoutCompat = this.mActivityChooserContent;
    int i = paramInt2;
    if (this.mDefaultActivityButton.getVisibility() != 0) {
      i = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt2), 1073741824);
    }
    measureChild(localLinearLayoutCompat, paramInt1, i);
    setMeasuredDimension(localLinearLayoutCompat.getMeasuredWidth(), localLinearLayoutCompat.getMeasuredHeight());
  }
  
  public void setActivityChooserModel(ActivityChooserModel paramActivityChooserModel)
  {
    this.mAdapter.a(paramActivityChooserModel);
    if (isShowingPopup())
    {
      dismissPopup();
      showPopup();
    }
  }
  
  public void setDefaultActionButtonContentDescription(int paramInt)
  {
    this.mDefaultActionButtonContentDescription = paramInt;
  }
  
  public void setExpandActivityOverflowButtonContentDescription(int paramInt)
  {
    String str = getContext().getString(paramInt);
    this.mExpandActivityOverflowButtonImage.setContentDescription(str);
  }
  
  public void setExpandActivityOverflowButtonDrawable(Drawable paramDrawable)
  {
    this.mExpandActivityOverflowButtonImage.setImageDrawable(paramDrawable);
  }
  
  public void setInitialActivityCount(int paramInt)
  {
    this.mInitialActivityCount = paramInt;
  }
  
  public void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.mOnDismissListener = paramOnDismissListener;
  }
  
  public void setProvider(ActionProvider paramActionProvider)
  {
    this.mProvider = paramActionProvider;
  }
  
  public boolean showPopup()
  {
    if ((isShowingPopup()) || (!this.mIsAttachedToWindow)) {
      return false;
    }
    this.mIsSelectingDefaultActivity = false;
    showPopupUnchecked(this.mInitialActivityCount);
    return true;
  }
  
  public static class InnerLayout
    extends LinearLayoutCompat
  {
    private static final int[] TINT_ATTRS = { 16842964 };
    
    public InnerLayout(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = TintTypedArray.obtainStyledAttributes(paramContext, paramAttributeSet, TINT_ATTRS);
      setBackgroundDrawable(paramContext.getDrawable(0));
      paramContext.recycle();
    }
  }
  
  private class a
    extends BaseAdapter
  {
    private ActivityChooserModel b;
    private int c = 4;
    private boolean d;
    private boolean e;
    private boolean f;
    
    private a() {}
    
    public int a()
    {
      int i = 0;
      int k = this.c;
      this.c = Integer.MAX_VALUE;
      int m = View.MeasureSpec.makeMeasureSpec(0, 0);
      int n = View.MeasureSpec.makeMeasureSpec(0, 0);
      int i1 = getCount();
      View localView = null;
      int j = 0;
      while (i < i1)
      {
        localView = getView(i, localView, null);
        localView.measure(m, n);
        j = Math.max(j, localView.getMeasuredWidth());
        i += 1;
      }
      this.c = k;
      return j;
    }
    
    public void a(int paramInt)
    {
      if (this.c != paramInt)
      {
        this.c = paramInt;
        notifyDataSetChanged();
      }
    }
    
    public void a(ActivityChooserModel paramActivityChooserModel)
    {
      ActivityChooserModel localActivityChooserModel = ActivityChooserView.this.mAdapter.e();
      if ((localActivityChooserModel != null) && (ActivityChooserView.this.isShown())) {
        localActivityChooserModel.unregisterObserver(ActivityChooserView.this.mModelDataSetOberver);
      }
      this.b = paramActivityChooserModel;
      if ((paramActivityChooserModel != null) && (ActivityChooserView.this.isShown())) {
        paramActivityChooserModel.registerObserver(ActivityChooserView.this.mModelDataSetOberver);
      }
      notifyDataSetChanged();
    }
    
    public void a(boolean paramBoolean)
    {
      if (this.f != paramBoolean)
      {
        this.f = paramBoolean;
        notifyDataSetChanged();
      }
    }
    
    public void a(boolean paramBoolean1, boolean paramBoolean2)
    {
      if ((this.d != paramBoolean1) || (this.e != paramBoolean2))
      {
        this.d = paramBoolean1;
        this.e = paramBoolean2;
        notifyDataSetChanged();
      }
    }
    
    public ResolveInfo b()
    {
      return this.b.b();
    }
    
    public int c()
    {
      return this.b.a();
    }
    
    public int d()
    {
      return this.b.c();
    }
    
    public ActivityChooserModel e()
    {
      return this.b;
    }
    
    public boolean f()
    {
      return this.d;
    }
    
    public int getCount()
    {
      int j = this.b.a();
      int i = j;
      if (!this.d)
      {
        i = j;
        if (this.b.b() != null) {
          i = j - 1;
        }
      }
      j = Math.min(i, this.c);
      i = j;
      if (this.f) {
        i = j + 1;
      }
      return i;
    }
    
    public Object getItem(int paramInt)
    {
      switch (getItemViewType(paramInt))
      {
      default: 
        throw new IllegalArgumentException();
      case 1: 
        return null;
      }
      int i = paramInt;
      if (!this.d)
      {
        i = paramInt;
        if (this.b.b() != null) {
          i = paramInt + 1;
        }
      }
      return this.b.a(i);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public int getItemViewType(int paramInt)
    {
      if ((this.f) && (paramInt == getCount() - 1)) {
        return 1;
      }
      return 0;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView;
      switch (getItemViewType(paramInt))
      {
      default: 
        throw new IllegalArgumentException();
      case 1: 
        if (paramView != null)
        {
          localView = paramView;
          if (paramView.getId() == 1) {}
        }
        else
        {
          localView = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(a.h.abc_activity_chooser_view_list_item, paramViewGroup, false);
          localView.setId(1);
          ((TextView)localView.findViewById(a.f.title)).setText(ActivityChooserView.this.getContext().getString(a.i.abc_activity_chooser_view_see_all));
        }
        return localView;
      }
      if (paramView != null)
      {
        localView = paramView;
        if (paramView.getId() == a.f.list_item) {}
      }
      else
      {
        localView = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(a.h.abc_activity_chooser_view_list_item, paramViewGroup, false);
      }
      paramView = ActivityChooserView.this.getContext().getPackageManager();
      paramViewGroup = (ImageView)localView.findViewById(a.f.icon);
      ResolveInfo localResolveInfo = (ResolveInfo)getItem(paramInt);
      paramViewGroup.setImageDrawable(localResolveInfo.loadIcon(paramView));
      ((TextView)localView.findViewById(a.f.title)).setText(localResolveInfo.loadLabel(paramView));
      if ((this.d) && (paramInt == 0) && (this.e))
      {
        ViewCompat.setActivated(localView, true);
        return localView;
      }
      ViewCompat.setActivated(localView, false);
      return localView;
    }
    
    public int getViewTypeCount()
    {
      return 3;
    }
  }
  
  private class b
    implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener
  {
    private b() {}
    
    private void a()
    {
      if (ActivityChooserView.this.mOnDismissListener != null) {
        ActivityChooserView.this.mOnDismissListener.onDismiss();
      }
    }
    
    public void onClick(View paramView)
    {
      if (paramView == ActivityChooserView.this.mDefaultActivityButton)
      {
        ActivityChooserView.this.dismissPopup();
        paramView = ActivityChooserView.this.mAdapter.b();
        int i = ActivityChooserView.this.mAdapter.e().a(paramView);
        paramView = ActivityChooserView.this.mAdapter.e().b(i);
        if (paramView != null)
        {
          paramView.addFlags(524288);
          ActivityChooserView.this.getContext().startActivity(paramView);
        }
        return;
      }
      if (paramView == ActivityChooserView.this.mExpandActivityOverflowButton)
      {
        ActivityChooserView.access$602(ActivityChooserView.this, false);
        ActivityChooserView.this.showPopupUnchecked(ActivityChooserView.this.mInitialActivityCount);
        return;
      }
      throw new IllegalArgumentException();
    }
    
    public void onDismiss()
    {
      a();
      if (ActivityChooserView.this.mProvider != null) {
        ActivityChooserView.this.mProvider.subUiVisibilityChanged(false);
      }
    }
    
    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      switch (((ActivityChooserView.a)paramAdapterView.getAdapter()).getItemViewType(paramInt))
      {
      default: 
        throw new IllegalArgumentException();
      case 1: 
        ActivityChooserView.this.showPopupUnchecked(Integer.MAX_VALUE);
      }
      do
      {
        return;
        ActivityChooserView.this.dismissPopup();
        if (!ActivityChooserView.this.mIsSelectingDefaultActivity) {
          break;
        }
      } while (paramInt <= 0);
      ActivityChooserView.this.mAdapter.e().c(paramInt);
      return;
      if (ActivityChooserView.this.mAdapter.f()) {}
      for (;;)
      {
        paramAdapterView = ActivityChooserView.this.mAdapter.e().b(paramInt);
        if (paramAdapterView == null) {
          break;
        }
        paramAdapterView.addFlags(524288);
        ActivityChooserView.this.getContext().startActivity(paramAdapterView);
        return;
        paramInt += 1;
      }
    }
    
    public boolean onLongClick(View paramView)
    {
      if (paramView == ActivityChooserView.this.mDefaultActivityButton)
      {
        if (ActivityChooserView.this.mAdapter.getCount() > 0)
        {
          ActivityChooserView.access$602(ActivityChooserView.this, true);
          ActivityChooserView.this.showPopupUnchecked(ActivityChooserView.this.mInitialActivityCount);
        }
        return true;
      }
      throw new IllegalArgumentException();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\ActivityChooserView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */