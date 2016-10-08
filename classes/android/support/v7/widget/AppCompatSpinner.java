package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.database.DataSetObserver;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.TintableBackgroundView;
import android.support.v4.view.ViewCompat;
import android.support.v7.a.a.a;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

public class AppCompatSpinner
  extends Spinner
  implements TintableBackgroundView
{
  private static final int[] ATTRS_ANDROID_SPINNERMODE;
  private static final boolean IS_AT_LEAST_JB;
  private static final boolean IS_AT_LEAST_M;
  private static final int MAX_ITEMS_MEASURED = 15;
  private static final int MODE_DIALOG = 0;
  private static final int MODE_DROPDOWN = 1;
  private static final int MODE_THEME = -1;
  private static final String TAG = "AppCompatSpinner";
  private o mBackgroundTintHelper;
  private AppCompatDrawableManager mDrawableManager;
  private int mDropDownWidth;
  private ListPopupWindow.ForwardingListener mForwardingListener;
  private b mPopup;
  private Context mPopupContext;
  private boolean mPopupSet;
  private SpinnerAdapter mTempAdapter;
  private final Rect mTempRect;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      bool = true;
      IS_AT_LEAST_M = bool;
      if (Build.VERSION.SDK_INT < 16) {
        break label45;
      }
    }
    label45:
    for (boolean bool = true;; bool = false)
    {
      IS_AT_LEAST_JB = bool;
      ATTRS_ANDROID_SPINNERMODE = new int[] { 16843505 };
      return;
      bool = false;
      break;
    }
  }
  
  public AppCompatSpinner(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AppCompatSpinner(Context paramContext, int paramInt)
  {
    this(paramContext, null, a.a.spinnerStyle, paramInt);
  }
  
  public AppCompatSpinner(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.a.spinnerStyle);
  }
  
  public AppCompatSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, -1);
  }
  
  public AppCompatSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    this(paramContext, paramAttributeSet, paramInt1, paramInt2, null);
  }
  
  /* Error */
  public AppCompatSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2, Resources.Theme paramTheme)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: iload_3
    //   4: invokespecial 84	android/widget/Spinner:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   7: aload_0
    //   8: new 86	android/graphics/Rect
    //   11: dup
    //   12: invokespecial 88	android/graphics/Rect:<init>	()V
    //   15: putfield 90	android/support/v7/widget/AppCompatSpinner:mTempRect	Landroid/graphics/Rect;
    //   18: aload_1
    //   19: aload_2
    //   20: getstatic 95	android/support/v7/a/a$k:Spinner	[I
    //   23: iload_3
    //   24: iconst_0
    //   25: invokestatic 101	android/support/v7/widget/TintTypedArray:obtainStyledAttributes	(Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroid/support/v7/widget/TintTypedArray;
    //   28: astore 8
    //   30: aload_0
    //   31: invokestatic 107	android/support/v7/widget/AppCompatDrawableManager:get	()Landroid/support/v7/widget/AppCompatDrawableManager;
    //   34: putfield 109	android/support/v7/widget/AppCompatSpinner:mDrawableManager	Landroid/support/v7/widget/AppCompatDrawableManager;
    //   37: aload_0
    //   38: new 111	android/support/v7/widget/o
    //   41: dup
    //   42: aload_0
    //   43: aload_0
    //   44: getfield 109	android/support/v7/widget/AppCompatSpinner:mDrawableManager	Landroid/support/v7/widget/AppCompatDrawableManager;
    //   47: invokespecial 114	android/support/v7/widget/o:<init>	(Landroid/view/View;Landroid/support/v7/widget/AppCompatDrawableManager;)V
    //   50: putfield 116	android/support/v7/widget/AppCompatSpinner:mBackgroundTintHelper	Landroid/support/v7/widget/o;
    //   53: aload 5
    //   55: ifnull +285 -> 340
    //   58: aload_0
    //   59: new 118	android/support/v7/view/d
    //   62: dup
    //   63: aload_1
    //   64: aload 5
    //   66: invokespecial 121	android/support/v7/view/d:<init>	(Landroid/content/Context;Landroid/content/res/Resources$Theme;)V
    //   69: putfield 123	android/support/v7/widget/AppCompatSpinner:mPopupContext	Landroid/content/Context;
    //   72: aload_0
    //   73: getfield 123	android/support/v7/widget/AppCompatSpinner:mPopupContext	Landroid/content/Context;
    //   76: ifnull +184 -> 260
    //   79: iload 4
    //   81: istore 10
    //   83: iload 4
    //   85: iconst_m1
    //   86: if_icmpne +71 -> 157
    //   89: getstatic 53	android/os/Build$VERSION:SDK_INT	I
    //   92: bipush 11
    //   94: if_icmplt +359 -> 453
    //   97: aload_1
    //   98: aload_2
    //   99: getstatic 60	android/support/v7/widget/AppCompatSpinner:ATTRS_ANDROID_SPINNERMODE	[I
    //   102: iload_3
    //   103: iconst_0
    //   104: invokevirtual 128	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   107: astore 6
    //   109: iload 4
    //   111: istore 9
    //   113: aload 6
    //   115: astore 5
    //   117: aload 6
    //   119: iconst_0
    //   120: invokevirtual 134	android/content/res/TypedArray:hasValue	(I)Z
    //   123: ifeq +16 -> 139
    //   126: aload 6
    //   128: astore 5
    //   130: aload 6
    //   132: iconst_0
    //   133: iconst_0
    //   134: invokevirtual 138	android/content/res/TypedArray:getInt	(II)I
    //   137: istore 9
    //   139: iload 9
    //   141: istore 10
    //   143: aload 6
    //   145: ifnull +12 -> 157
    //   148: aload 6
    //   150: invokevirtual 141	android/content/res/TypedArray:recycle	()V
    //   153: iload 9
    //   155: istore 10
    //   157: iload 10
    //   159: iconst_1
    //   160: if_icmpne +100 -> 260
    //   163: new 11	android/support/v7/widget/AppCompatSpinner$b
    //   166: dup
    //   167: aload_0
    //   168: aload_0
    //   169: getfield 123	android/support/v7/widget/AppCompatSpinner:mPopupContext	Landroid/content/Context;
    //   172: aload_2
    //   173: iload_3
    //   174: invokespecial 144	android/support/v7/widget/AppCompatSpinner$b:<init>	(Landroid/support/v7/widget/AppCompatSpinner;Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   177: astore 5
    //   179: aload_0
    //   180: getfield 123	android/support/v7/widget/AppCompatSpinner:mPopupContext	Landroid/content/Context;
    //   183: aload_2
    //   184: getstatic 95	android/support/v7/a/a$k:Spinner	[I
    //   187: iload_3
    //   188: iconst_0
    //   189: invokestatic 101	android/support/v7/widget/TintTypedArray:obtainStyledAttributes	(Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroid/support/v7/widget/TintTypedArray;
    //   192: astore 6
    //   194: aload_0
    //   195: aload 6
    //   197: getstatic 147	android/support/v7/a/a$k:Spinner_android_dropDownWidth	I
    //   200: bipush -2
    //   202: invokevirtual 150	android/support/v7/widget/TintTypedArray:getLayoutDimension	(II)I
    //   205: putfield 152	android/support/v7/widget/AppCompatSpinner:mDropDownWidth	I
    //   208: aload 5
    //   210: aload 6
    //   212: getstatic 155	android/support/v7/a/a$k:Spinner_android_popupBackground	I
    //   215: invokevirtual 159	android/support/v7/widget/TintTypedArray:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   218: invokevirtual 163	android/support/v7/widget/AppCompatSpinner$b:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   221: aload 5
    //   223: aload 8
    //   225: getstatic 166	android/support/v7/a/a$k:Spinner_android_prompt	I
    //   228: invokevirtual 170	android/support/v7/widget/TintTypedArray:getString	(I)Ljava/lang/String;
    //   231: invokevirtual 173	android/support/v7/widget/AppCompatSpinner$b:a	(Ljava/lang/CharSequence;)V
    //   234: aload 6
    //   236: invokevirtual 174	android/support/v7/widget/TintTypedArray:recycle	()V
    //   239: aload_0
    //   240: aload 5
    //   242: putfield 176	android/support/v7/widget/AppCompatSpinner:mPopup	Landroid/support/v7/widget/AppCompatSpinner$b;
    //   245: aload_0
    //   246: new 178	android/support/v7/widget/t
    //   249: dup
    //   250: aload_0
    //   251: aload_0
    //   252: aload 5
    //   254: invokespecial 181	android/support/v7/widget/t:<init>	(Landroid/support/v7/widget/AppCompatSpinner;Landroid/view/View;Landroid/support/v7/widget/AppCompatSpinner$b;)V
    //   257: putfield 183	android/support/v7/widget/AppCompatSpinner:mForwardingListener	Landroid/support/v7/widget/ListPopupWindow$ForwardingListener;
    //   260: aload 8
    //   262: getstatic 186	android/support/v7/a/a$k:Spinner_android_entries	I
    //   265: invokevirtual 190	android/support/v7/widget/TintTypedArray:getTextArray	(I)[Ljava/lang/CharSequence;
    //   268: astore 5
    //   270: aload 5
    //   272: ifnull +28 -> 300
    //   275: new 192	android/widget/ArrayAdapter
    //   278: dup
    //   279: aload_1
    //   280: ldc -63
    //   282: aload 5
    //   284: invokespecial 196	android/widget/ArrayAdapter:<init>	(Landroid/content/Context;I[Ljava/lang/Object;)V
    //   287: astore_1
    //   288: aload_1
    //   289: getstatic 201	android/support/v7/a/a$h:support_simple_spinner_dropdown_item	I
    //   292: invokevirtual 205	android/widget/ArrayAdapter:setDropDownViewResource	(I)V
    //   295: aload_0
    //   296: aload_1
    //   297: invokevirtual 209	android/support/v7/widget/AppCompatSpinner:setAdapter	(Landroid/widget/SpinnerAdapter;)V
    //   300: aload 8
    //   302: invokevirtual 174	android/support/v7/widget/TintTypedArray:recycle	()V
    //   305: aload_0
    //   306: iconst_1
    //   307: putfield 211	android/support/v7/widget/AppCompatSpinner:mPopupSet	Z
    //   310: aload_0
    //   311: getfield 213	android/support/v7/widget/AppCompatSpinner:mTempAdapter	Landroid/widget/SpinnerAdapter;
    //   314: ifnull +16 -> 330
    //   317: aload_0
    //   318: aload_0
    //   319: getfield 213	android/support/v7/widget/AppCompatSpinner:mTempAdapter	Landroid/widget/SpinnerAdapter;
    //   322: invokevirtual 209	android/support/v7/widget/AppCompatSpinner:setAdapter	(Landroid/widget/SpinnerAdapter;)V
    //   325: aload_0
    //   326: aconst_null
    //   327: putfield 213	android/support/v7/widget/AppCompatSpinner:mTempAdapter	Landroid/widget/SpinnerAdapter;
    //   330: aload_0
    //   331: getfield 116	android/support/v7/widget/AppCompatSpinner:mBackgroundTintHelper	Landroid/support/v7/widget/o;
    //   334: aload_2
    //   335: iload_3
    //   336: invokevirtual 216	android/support/v7/widget/o:a	(Landroid/util/AttributeSet;I)V
    //   339: return
    //   340: aload 8
    //   342: getstatic 219	android/support/v7/a/a$k:Spinner_popupTheme	I
    //   345: iconst_0
    //   346: invokevirtual 222	android/support/v7/widget/TintTypedArray:getResourceId	(II)I
    //   349: istore 9
    //   351: iload 9
    //   353: ifeq +20 -> 373
    //   356: aload_0
    //   357: new 118	android/support/v7/view/d
    //   360: dup
    //   361: aload_1
    //   362: iload 9
    //   364: invokespecial 224	android/support/v7/view/d:<init>	(Landroid/content/Context;I)V
    //   367: putfield 123	android/support/v7/widget/AppCompatSpinner:mPopupContext	Landroid/content/Context;
    //   370: goto -298 -> 72
    //   373: getstatic 55	android/support/v7/widget/AppCompatSpinner:IS_AT_LEAST_M	Z
    //   376: ifne +15 -> 391
    //   379: aload_1
    //   380: astore 5
    //   382: aload_0
    //   383: aload 5
    //   385: putfield 123	android/support/v7/widget/AppCompatSpinner:mPopupContext	Landroid/content/Context;
    //   388: goto -316 -> 72
    //   391: aconst_null
    //   392: astore 5
    //   394: goto -12 -> 382
    //   397: astore 7
    //   399: aconst_null
    //   400: astore 6
    //   402: aload 6
    //   404: astore 5
    //   406: ldc 30
    //   408: ldc -30
    //   410: aload 7
    //   412: invokestatic 232	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   415: pop
    //   416: iload 4
    //   418: istore 10
    //   420: aload 6
    //   422: ifnull -265 -> 157
    //   425: aload 6
    //   427: invokevirtual 141	android/content/res/TypedArray:recycle	()V
    //   430: iload 4
    //   432: istore 10
    //   434: goto -277 -> 157
    //   437: astore_1
    //   438: aconst_null
    //   439: astore 5
    //   441: aload 5
    //   443: ifnull +8 -> 451
    //   446: aload 5
    //   448: invokevirtual 141	android/content/res/TypedArray:recycle	()V
    //   451: aload_1
    //   452: athrow
    //   453: iconst_1
    //   454: istore 10
    //   456: goto -299 -> 157
    //   459: astore_1
    //   460: goto -19 -> 441
    //   463: astore 7
    //   465: goto -63 -> 402
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	468	0	this	AppCompatSpinner
    //   0	468	1	paramContext	Context
    //   0	468	2	paramAttributeSet	AttributeSet
    //   0	468	3	paramInt1	int
    //   0	468	4	paramInt2	int
    //   0	468	5	paramTheme	Resources.Theme
    //   107	319	6	localObject	Object
    //   397	14	7	localException1	Exception
    //   463	1	7	localException2	Exception
    //   28	313	8	localTintTypedArray	TintTypedArray
    //   111	252	9	i	int
    //   81	374	10	j	int
    // Exception table:
    //   from	to	target	type
    //   97	109	397	java/lang/Exception
    //   97	109	437	finally
    //   117	126	459	finally
    //   130	139	459	finally
    //   406	416	459	finally
    //   117	126	463	java/lang/Exception
    //   130	139	463	java/lang/Exception
  }
  
  private int compatMeasureContentWidth(SpinnerAdapter paramSpinnerAdapter, Drawable paramDrawable)
  {
    if (paramSpinnerAdapter == null) {
      return 0;
    }
    int n = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
    int i1 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
    int i = Math.max(0, getSelectedItemPosition());
    int i2 = Math.min(paramSpinnerAdapter.getCount(), i + 15);
    int j = Math.max(0, i - (15 - (i2 - i)));
    View localView = null;
    int k = 0;
    i = 0;
    if (j < i2)
    {
      int m = paramSpinnerAdapter.getItemViewType(j);
      if (m == i) {
        break label203;
      }
      localView = null;
      i = m;
    }
    label203:
    for (;;)
    {
      localView = paramSpinnerAdapter.getView(j, localView, this);
      if (localView.getLayoutParams() == null) {
        localView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
      }
      localView.measure(n, i1);
      k = Math.max(k, localView.getMeasuredWidth());
      j += 1;
      break;
      if (paramDrawable != null)
      {
        paramDrawable.getPadding(this.mTempRect);
        return this.mTempRect.left + this.mTempRect.right + k;
      }
      return k;
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.c();
    }
  }
  
  public int getDropDownHorizontalOffset()
  {
    if (this.mPopup != null) {
      return this.mPopup.getHorizontalOffset();
    }
    if (IS_AT_LEAST_JB) {
      return super.getDropDownHorizontalOffset();
    }
    return 0;
  }
  
  public int getDropDownVerticalOffset()
  {
    if (this.mPopup != null) {
      return this.mPopup.getVerticalOffset();
    }
    if (IS_AT_LEAST_JB) {
      return super.getDropDownVerticalOffset();
    }
    return 0;
  }
  
  public int getDropDownWidth()
  {
    if (this.mPopup != null) {
      return this.mDropDownWidth;
    }
    if (IS_AT_LEAST_JB) {
      return super.getDropDownWidth();
    }
    return 0;
  }
  
  public Drawable getPopupBackground()
  {
    if (this.mPopup != null) {
      return this.mPopup.getBackground();
    }
    if (IS_AT_LEAST_JB) {
      return super.getPopupBackground();
    }
    return null;
  }
  
  public Context getPopupContext()
  {
    if (this.mPopup != null) {
      return this.mPopupContext;
    }
    if (IS_AT_LEAST_M) {
      return super.getPopupContext();
    }
    return null;
  }
  
  public CharSequence getPrompt()
  {
    if (this.mPopup != null) {
      return this.mPopup.a();
    }
    return super.getPrompt();
  }
  
  @Nullable
  public ColorStateList getSupportBackgroundTintList()
  {
    if (this.mBackgroundTintHelper != null) {
      return this.mBackgroundTintHelper.a();
    }
    return null;
  }
  
  @Nullable
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    if (this.mBackgroundTintHelper != null) {
      return this.mBackgroundTintHelper.b();
    }
    return null;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((this.mPopup != null) && (this.mPopup.isShowing())) {
      this.mPopup.dismiss();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((this.mPopup != null) && (View.MeasureSpec.getMode(paramInt1) == Integer.MIN_VALUE)) {
      setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), compatMeasureContentWidth(getAdapter(), getBackground())), View.MeasureSpec.getSize(paramInt1)), getMeasuredHeight());
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.mForwardingListener != null) && (this.mForwardingListener.onTouch(this, paramMotionEvent))) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public boolean performClick()
  {
    if (this.mPopup != null)
    {
      if (!this.mPopup.isShowing()) {
        this.mPopup.show();
      }
      return true;
    }
    return super.performClick();
  }
  
  public void setAdapter(SpinnerAdapter paramSpinnerAdapter)
  {
    if (!this.mPopupSet) {
      this.mTempAdapter = paramSpinnerAdapter;
    }
    do
    {
      return;
      super.setAdapter(paramSpinnerAdapter);
    } while (this.mPopup == null);
    if (this.mPopupContext == null) {}
    for (Context localContext = getContext();; localContext = this.mPopupContext)
    {
      this.mPopup.setAdapter(new a(paramSpinnerAdapter, localContext.getTheme()));
      return;
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.a(paramDrawable);
    }
  }
  
  public void setBackgroundResource(@DrawableRes int paramInt)
  {
    super.setBackgroundResource(paramInt);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.a(paramInt);
    }
  }
  
  public void setDropDownHorizontalOffset(int paramInt)
  {
    if (this.mPopup != null) {
      this.mPopup.setHorizontalOffset(paramInt);
    }
    while (!IS_AT_LEAST_JB) {
      return;
    }
    super.setDropDownHorizontalOffset(paramInt);
  }
  
  public void setDropDownVerticalOffset(int paramInt)
  {
    if (this.mPopup != null) {
      this.mPopup.setVerticalOffset(paramInt);
    }
    while (!IS_AT_LEAST_JB) {
      return;
    }
    super.setDropDownVerticalOffset(paramInt);
  }
  
  public void setDropDownWidth(int paramInt)
  {
    if (this.mPopup != null) {
      this.mDropDownWidth = paramInt;
    }
    while (!IS_AT_LEAST_JB) {
      return;
    }
    super.setDropDownWidth(paramInt);
  }
  
  public void setPopupBackgroundDrawable(Drawable paramDrawable)
  {
    if (this.mPopup != null) {
      this.mPopup.setBackgroundDrawable(paramDrawable);
    }
    while (!IS_AT_LEAST_JB) {
      return;
    }
    super.setPopupBackgroundDrawable(paramDrawable);
  }
  
  public void setPopupBackgroundResource(@DrawableRes int paramInt)
  {
    setPopupBackgroundDrawable(ContextCompat.getDrawable(getPopupContext(), paramInt));
  }
  
  public void setPrompt(CharSequence paramCharSequence)
  {
    if (this.mPopup != null)
    {
      this.mPopup.a(paramCharSequence);
      return;
    }
    super.setPrompt(paramCharSequence);
  }
  
  public void setSupportBackgroundTintList(@Nullable ColorStateList paramColorStateList)
  {
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.a(paramColorStateList);
    }
  }
  
  public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.a(paramMode);
    }
  }
  
  private static class a
    implements ListAdapter, SpinnerAdapter
  {
    private SpinnerAdapter a;
    private ListAdapter b;
    
    public a(@Nullable SpinnerAdapter paramSpinnerAdapter, @Nullable Resources.Theme paramTheme)
    {
      this.a = paramSpinnerAdapter;
      if ((paramSpinnerAdapter instanceof ListAdapter)) {
        this.b = ((ListAdapter)paramSpinnerAdapter);
      }
      if (paramTheme != null)
      {
        if ((!AppCompatSpinner.IS_AT_LEAST_M) || (!(paramSpinnerAdapter instanceof android.widget.ThemedSpinnerAdapter))) {
          break label64;
        }
        paramSpinnerAdapter = (android.widget.ThemedSpinnerAdapter)paramSpinnerAdapter;
        if (paramSpinnerAdapter.getDropDownViewTheme() != paramTheme) {
          paramSpinnerAdapter.setDropDownViewTheme(paramTheme);
        }
      }
      label64:
      do
      {
        do
        {
          return;
        } while (!(paramSpinnerAdapter instanceof ThemedSpinnerAdapter));
        paramSpinnerAdapter = (ThemedSpinnerAdapter)paramSpinnerAdapter;
      } while (paramSpinnerAdapter.getDropDownViewTheme() != null);
      paramSpinnerAdapter.setDropDownViewTheme(paramTheme);
    }
    
    public boolean areAllItemsEnabled()
    {
      ListAdapter localListAdapter = this.b;
      if (localListAdapter != null) {
        return localListAdapter.areAllItemsEnabled();
      }
      return true;
    }
    
    public int getCount()
    {
      if (this.a == null) {
        return 0;
      }
      return this.a.getCount();
    }
    
    public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (this.a == null) {
        return null;
      }
      return this.a.getDropDownView(paramInt, paramView, paramViewGroup);
    }
    
    public Object getItem(int paramInt)
    {
      if (this.a == null) {
        return null;
      }
      return this.a.getItem(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      if (this.a == null) {
        return -1L;
      }
      return this.a.getItemId(paramInt);
    }
    
    public int getItemViewType(int paramInt)
    {
      return 0;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      return getDropDownView(paramInt, paramView, paramViewGroup);
    }
    
    public int getViewTypeCount()
    {
      return 1;
    }
    
    public boolean hasStableIds()
    {
      return (this.a != null) && (this.a.hasStableIds());
    }
    
    public boolean isEmpty()
    {
      return getCount() == 0;
    }
    
    public boolean isEnabled(int paramInt)
    {
      ListAdapter localListAdapter = this.b;
      if (localListAdapter != null) {
        return localListAdapter.isEnabled(paramInt);
      }
      return true;
    }
    
    public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
    {
      if (this.a != null) {
        this.a.registerDataSetObserver(paramDataSetObserver);
      }
    }
    
    public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
    {
      if (this.a != null) {
        this.a.unregisterDataSetObserver(paramDataSetObserver);
      }
    }
  }
  
  private class b
    extends ListPopupWindow
  {
    private CharSequence b;
    private ListAdapter c;
    private final Rect d = new Rect();
    
    public b(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt);
      setAnchorView(AppCompatSpinner.this);
      setModal(true);
      setPromptPosition(0);
      setOnItemClickListener(new u(this, AppCompatSpinner.this));
    }
    
    private boolean a(View paramView)
    {
      return (ViewCompat.isAttachedToWindow(paramView)) && (paramView.getGlobalVisibleRect(this.d));
    }
    
    public CharSequence a()
    {
      return this.b;
    }
    
    public void a(CharSequence paramCharSequence)
    {
      this.b = paramCharSequence;
    }
    
    void b()
    {
      Object localObject = getBackground();
      int i;
      int m;
      int n;
      int i1;
      int j;
      if (localObject != null)
      {
        ((Drawable)localObject).getPadding(AppCompatSpinner.this.mTempRect);
        if (ViewUtils.isLayoutRtl(AppCompatSpinner.this))
        {
          i = AppCompatSpinner.this.mTempRect.right;
          m = AppCompatSpinner.this.getPaddingLeft();
          n = AppCompatSpinner.this.getPaddingRight();
          i1 = AppCompatSpinner.this.getWidth();
          if (AppCompatSpinner.this.mDropDownWidth != -2) {
            break label238;
          }
          j = AppCompatSpinner.this.compatMeasureContentWidth((SpinnerAdapter)this.c, getBackground());
          int k = AppCompatSpinner.this.getContext().getResources().getDisplayMetrics().widthPixels - AppCompatSpinner.this.mTempRect.left - AppCompatSpinner.this.mTempRect.right;
          if (j <= k) {
            break label286;
          }
          j = k;
        }
      }
      label165:
      label238:
      label286:
      for (;;)
      {
        setContentWidth(Math.max(j, i1 - m - n));
        if (ViewUtils.isLayoutRtl(AppCompatSpinner.this)) {
          i = i1 - n - getWidth() + i;
        }
        for (;;)
        {
          setHorizontalOffset(i);
          return;
          i = -AppCompatSpinner.this.mTempRect.left;
          break;
          localObject = AppCompatSpinner.this.mTempRect;
          AppCompatSpinner.this.mTempRect.right = 0;
          ((Rect)localObject).left = 0;
          i = 0;
          break;
          if (AppCompatSpinner.this.mDropDownWidth == -1)
          {
            setContentWidth(i1 - m - n);
            break label165;
          }
          setContentWidth(AppCompatSpinner.this.mDropDownWidth);
          break label165;
          i += m;
        }
      }
    }
    
    public void setAdapter(ListAdapter paramListAdapter)
    {
      super.setAdapter(paramListAdapter);
      this.c = paramListAdapter;
    }
    
    public void show()
    {
      boolean bool = isShowing();
      b();
      setInputMethodMode(2);
      super.show();
      getListView().setChoiceMode(1);
      setSelection(AppCompatSpinner.this.getSelectedItemPosition());
      if (bool) {}
      ViewTreeObserver localViewTreeObserver;
      do
      {
        return;
        localViewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
      } while (localViewTreeObserver == null);
      v localv = new v(this);
      localViewTreeObserver.addOnGlobalLayoutListener(localv);
      setOnDismissListener(new w(this, localv));
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\AppCompatSpinner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */