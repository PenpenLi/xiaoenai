package com.inmobi.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils.TruncateAt;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Picasso.Builder;
import com.squareup.picasso.RequestCreator;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;

class aj
{
  private static final String a = aj.class.getSimpleName();
  @NonNull
  private static final Map<Class, c> c = new HashMap();
  @Nullable
  private static volatile WeakReference<aj> e;
  private static volatile Picasso f;
  private int b;
  @NonNull
  private Map<c, b> d = new HashMap();
  
  static
  {
    c.put(ag.class, c.a);
    c.put(ao.class, c.b);
    c.put(NativeStrandContainerLayout.class, c.c);
    c.put(ImageView.class, c.f);
    c.put(a.class, c.d);
    c.put(Button.class, c.e);
  }
  
  private aj()
  {
    Object localObject = new aj.1(this);
    this.d.put(c.a, localObject);
    localObject = new aj.2(this);
    this.d.put(c.c, localObject);
    localObject = new aj.3(this);
    this.d.put(c.b, localObject);
    localObject = new aj.4(this);
    this.d.put(c.f, localObject);
    localObject = new aj.5(this);
    this.d.put(c.d, localObject);
    localObject = new aj.6(this);
    this.d.put(c.e, localObject);
  }
  
  public static ViewGroup.LayoutParams a(@NonNull NativeStrandAsset paramNativeStrandAsset, @NonNull ViewGroup paramViewGroup)
  {
    Object localObject = paramNativeStrandAsset.b().a();
    paramNativeStrandAsset = paramNativeStrandAsset.b().b();
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(((Point)localObject).x, ((Point)localObject).y);
    if ((paramViewGroup instanceof NativeStrandContainerLayout))
    {
      paramViewGroup = new NativeStrandContainerLayout.a(((Point)localObject).x, ((Point)localObject).y);
      ((NativeStrandContainerLayout.a)paramViewGroup).a(paramNativeStrandAsset.x, paramNativeStrandAsset.y);
      return paramViewGroup;
    }
    if ((paramViewGroup instanceof LinearLayout))
    {
      paramViewGroup = new LinearLayout.LayoutParams(((Point)localObject).x, ((Point)localObject).y);
      ((LinearLayout.LayoutParams)paramViewGroup).setMargins(paramNativeStrandAsset.x, paramNativeStrandAsset.y, 0, 0);
      return paramViewGroup;
    }
    if ((paramViewGroup instanceof AbsListView)) {
      return new AbsListView.LayoutParams(((Point)localObject).x, ((Point)localObject).y);
    }
    if ((paramViewGroup instanceof FrameLayout))
    {
      paramViewGroup = new FrameLayout.LayoutParams(((Point)localObject).x, ((Point)localObject).y);
      ((FrameLayout.LayoutParams)paramViewGroup).setMargins(paramNativeStrandAsset.x, paramNativeStrandAsset.y, 0, 0);
      return paramViewGroup;
    }
    localObject = Logger.InternalLogLevel.INTERNAL;
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder().append("Could not set layout params for Parent:");
    if (paramViewGroup == null) {}
    for (paramNativeStrandAsset = "null";; paramNativeStrandAsset = paramViewGroup.getClass().getSimpleName())
    {
      Logger.a((Logger.InternalLogLevel)localObject, str, paramNativeStrandAsset);
      return localLayoutParams;
    }
  }
  
  @Nullable
  private c a(NativeStrandAsset paramNativeStrandAsset)
  {
    if ((paramNativeStrandAsset instanceof v))
    {
      paramNativeStrandAsset = (v)paramNativeStrandAsset;
      if (paramNativeStrandAsset.o()) {
        return c.a;
      }
      if (paramNativeStrandAsset.p()) {
        return c.b;
      }
      return c.c;
    }
    switch (aj.7.a[paramNativeStrandAsset.a().ordinal()])
    {
    default: 
      return null;
    case 1: 
      return c.d;
    case 2: 
    case 3: 
      return c.f;
    }
    return c.e;
  }
  
  /* Error */
  public static aj a(@NonNull Context paramContext)
  {
    // Byte code:
    //   0: getstatic 211	com/inmobi/ads/aj:e	Ljava/lang/ref/WeakReference;
    //   3: ifnonnull +59 -> 62
    //   6: aconst_null
    //   7: astore_1
    //   8: aload_1
    //   9: astore_2
    //   10: aload_1
    //   11: ifnonnull +49 -> 60
    //   14: ldc 2
    //   16: monitorenter
    //   17: getstatic 211	com/inmobi/ads/aj:e	Ljava/lang/ref/WeakReference;
    //   20: ifnonnull +55 -> 75
    //   23: aconst_null
    //   24: astore_1
    //   25: aload_1
    //   26: astore_2
    //   27: aload_1
    //   28: ifnonnull +29 -> 57
    //   31: new 2	com/inmobi/ads/aj
    //   34: dup
    //   35: invokespecial 212	com/inmobi/ads/aj:<init>	()V
    //   38: astore_2
    //   39: new 214	java/lang/ref/WeakReference
    //   42: dup
    //   43: aload_2
    //   44: invokespecial 217	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   47: putstatic 211	com/inmobi/ads/aj:e	Ljava/lang/ref/WeakReference;
    //   50: aload_0
    //   51: invokevirtual 223	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   54: invokestatic 226	com/inmobi/ads/aj:b	(Landroid/content/Context;)V
    //   57: ldc 2
    //   59: monitorexit
    //   60: aload_2
    //   61: areturn
    //   62: getstatic 211	com/inmobi/ads/aj:e	Ljava/lang/ref/WeakReference;
    //   65: invokevirtual 230	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   68: checkcast 2	com/inmobi/ads/aj
    //   71: astore_1
    //   72: goto -64 -> 8
    //   75: getstatic 211	com/inmobi/ads/aj:e	Ljava/lang/ref/WeakReference;
    //   78: invokevirtual 230	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   81: checkcast 2	com/inmobi/ads/aj
    //   84: astore_1
    //   85: goto -60 -> 25
    //   88: astore_0
    //   89: ldc 2
    //   91: monitorexit
    //   92: aload_0
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	paramContext	Context
    //   7	78	1	localaj1	aj
    //   9	52	2	localaj2	aj
    // Exception table:
    //   from	to	target	type
    //   17	23	88	finally
    //   31	57	88	finally
    //   57	60	88	finally
    //   75	85	88	finally
    //   89	92	88	finally
  }
  
  private void a()
  {
    b localb = b();
    if (localb != null) {
      localb.b();
    }
  }
  
  private void a(@NonNull View paramView, @NonNull NativeStrandAsset paramNativeStrandAsset)
  {
    int n = 1;
    NativeStrandAsset localNativeStrandAsset = paramNativeStrandAsset.k();
    int j = 0;
    int k = 0;
    int i;
    int m;
    if ((localNativeStrandAsset != null) && (t.b.b == localNativeStrandAsset.b().c())) {
      if (localNativeStrandAsset.b().b().x == paramNativeStrandAsset.b().b().x)
      {
        i = 1;
        if (localNativeStrandAsset.b().a().x == paramNativeStrandAsset.b().a().x + paramNativeStrandAsset.b().b().x)
        {
          m = 1;
          label94:
          if (localNativeStrandAsset.b().b().y == paramNativeStrandAsset.b().b().y)
          {
            j = 1;
            label120:
            if (localNativeStrandAsset.b().a().y == paramNativeStrandAsset.b().a().y + paramNativeStrandAsset.b().b().y) {
              k = 1;
            }
            if (localNativeStrandAsset.b().a().x == paramNativeStrandAsset.b().a().x)
            {
              i = 1;
              m = n;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT < 17)
      {
        paramView.setPadding(i, j, m, k);
        return;
      }
      paramView.setPaddingRelative(i, j, m, k);
      return;
      continue;
      j = 0;
      break label120;
      m = 0;
      break label94;
      i = 0;
      break;
      m = 0;
      n = 0;
      i = 0;
      k = j;
      j = n;
    }
  }
  
  @TargetApi(21)
  static void a(View paramView, @NonNull t paramt)
  {
    int i = Color.parseColor("#00000000");
    try
    {
      j = Color.parseColor(paramt.g());
      i = j;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        int j;
        GradientDrawable localGradientDrawable;
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Error parsing background color for container! Will fallback to default background color");
      }
    }
    paramView.setBackgroundColor(i);
    if (t.b.b == paramt.c())
    {
      localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setColor(i);
      if (t.a.a == paramt.d()) {
        localGradientDrawable.setCornerRadius(paramt.e());
      }
      i = Color.parseColor("#ff000000");
    }
    try
    {
      j = Color.parseColor(paramt.f());
      i = j;
    }
    catch (IllegalArgumentException paramt)
    {
      for (;;)
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Error parsing border color for container! Will fallback to default border color");
      }
      paramView.setBackground(localIllegalArgumentException);
    }
    localGradientDrawable.setStroke(1, i);
    if (Build.VERSION.SDK_INT < 16)
    {
      paramView.setBackgroundDrawable(localGradientDrawable);
      return;
    }
  }
  
  private void a(@NonNull ImageView paramImageView, @NonNull NativeStrandAsset paramNativeStrandAsset)
  {
    String str = (String)paramNativeStrandAsset.d();
    if (str != null)
    {
      int i = paramNativeStrandAsset.b().a().x;
      int j = paramNativeStrandAsset.b().a().y;
      if ((i > 0) && (j > 0) && (str.length() != 0)) {
        f.load(str).resize(i, j).into(paramImageView);
      }
      a(paramImageView, paramNativeStrandAsset);
      a(paramImageView, paramNativeStrandAsset.b());
    }
  }
  
  @TargetApi(17)
  private void a(@NonNull TextView paramTextView, NativeStrandAsset paramNativeStrandAsset)
  {
    ah.a locala = (ah.a)paramNativeStrandAsset.b();
    paramTextView.setLayoutParams(new ViewGroup.LayoutParams(locala.a().x, locala.a().y));
    paramTextView.setText((CharSequence)paramNativeStrandAsset.d());
    paramTextView.setTypeface(Typeface.DEFAULT);
    paramTextView.setTextSize(1, locala.h());
    int i = Color.parseColor("#ff000000");
    try
    {
      j = Color.parseColor(locala.i());
      i = j;
    }
    catch (IllegalArgumentException paramNativeStrandAsset)
    {
      for (;;)
      {
        int j;
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Error parsing color for text asset! Will fallback to default text color");
      }
    }
    paramTextView.setTextColor(i);
    i = Color.parseColor("#00000000");
    try
    {
      j = Color.parseColor(locala.g());
      i = j;
    }
    catch (IllegalArgumentException paramNativeStrandAsset)
    {
      for (;;)
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Error parsing background color for text asset! Will fallback to default background color");
      }
    }
    paramTextView.setBackgroundColor(i);
    if (Build.VERSION.SDK_INT >= 17) {
      paramTextView.setTextAlignment(1);
    }
    paramTextView.setGravity(16);
    a(paramTextView, locala.k());
    if (locala.j() != Integer.MAX_VALUE) {
      paramTextView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
    }
    a(paramTextView, locala);
  }
  
  private static void a(@NonNull TextView paramTextView, ah.a.a[] paramArrayOfa)
  {
    int i = paramTextView.getPaintFlags();
    int m = paramArrayOfa.length;
    int k = 0;
    int j = 0;
    if (k < m)
    {
      ah.a.a locala = paramArrayOfa[k];
      switch (aj.7.b[locala.ordinal()])
      {
      }
      for (;;)
      {
        k += 1;
        break;
        j |= 0x1;
        continue;
        j |= 0x2;
        continue;
        i |= 0x10;
        continue;
        i |= 0x8;
      }
    }
    paramTextView.setTypeface(Typeface.DEFAULT, j);
    paramTextView.setPaintFlags(i);
  }
  
  @TargetApi(17)
  private static Button b(@NonNull Button paramButton, @NonNull NativeStrandAsset paramNativeStrandAsset)
  {
    w.a locala = (w.a)paramNativeStrandAsset.b();
    paramButton.setLayoutParams(new ViewGroup.LayoutParams(locala.a().x, locala.a().y));
    paramButton.setText((CharSequence)paramNativeStrandAsset.d());
    paramButton.setTextSize(1, locala.h());
    int i = Color.parseColor("#ff000000");
    try
    {
      j = Color.parseColor(locala.i());
      i = j;
    }
    catch (IllegalArgumentException paramNativeStrandAsset)
    {
      for (;;)
      {
        int j;
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Error parsing color for CTA asset! Will fallback to default text color");
      }
    }
    paramButton.setTextColor(i);
    i = Color.parseColor("#00000000");
    try
    {
      j = Color.parseColor(locala.g());
      i = j;
    }
    catch (IllegalArgumentException paramNativeStrandAsset)
    {
      for (;;)
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Error parsing background color for CTA asset! Will fallback to default background color");
      }
    }
    paramButton.setBackgroundColor(i);
    if (Build.VERSION.SDK_INT >= 17) {
      paramButton.setTextAlignment(4);
    }
    paramButton.setGravity(17);
    a(paramButton, locala.k());
    a(paramButton, locala);
    return paramButton;
  }
  
  @Nullable
  private b b()
  {
    int i = 0;
    b localb = null;
    Iterator localIterator = this.d.entrySet().iterator();
    if (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((b)localEntry.getValue()).a() <= i) {
        break label77;
      }
      localb = (b)localEntry.getValue();
      i = localb.a();
    }
    label77:
    for (;;)
    {
      break;
      return localb;
    }
  }
  
  private static void b(Context paramContext)
  {
    if (f == null) {
      try
      {
        if (f == null) {
          f = new Picasso.Builder(paramContext.getApplicationContext()).build();
        }
        return;
      }
      finally {}
    }
  }
  
  private static void b(@NonNull TextView paramTextView)
  {
    paramTextView.setTypeface(Typeface.DEFAULT, 0);
    paramTextView.setPaintFlags(paramTextView.getPaintFlags() & 0xFFFFFFEF);
    paramTextView.setPaintFlags(paramTextView.getPaintFlags() & 0xFFFFFFF7);
  }
  
  private void c(@NonNull View paramView)
  {
    c localc = (c)c.get(paramView.getClass());
    if (localc == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "View type unknown, ignoring recycle:" + paramView);
      return;
    }
    b localb = (b)this.d.get(localc);
    if (localb == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Unsupported AssetType:" + localc + " failed to recycle view");
      return;
    }
    if (this.b >= 300) {
      a();
    }
    localb.a(paramView);
  }
  
  private static void d(@NonNull View paramView)
  {
    if (Build.VERSION.SDK_INT < 16)
    {
      paramView.setBackgroundDrawable(null);
      return;
    }
    paramView.setBackground(null);
  }
  
  @Nullable
  public View a(@NonNull Context paramContext, @NonNull NativeStrandAsset paramNativeStrandAsset)
  {
    c localc = a(paramNativeStrandAsset);
    if (localc == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Unsupported AssetType:" + paramNativeStrandAsset.a().toString() + " failed to instantiate view ");
      return null;
    }
    return ((b)this.d.get(localc)).a(paramContext, paramNativeStrandAsset);
  }
  
  public void a(@NonNull View paramView)
  {
    if (((paramView instanceof ag)) || ((paramView instanceof NativeStrandContainerLayout)))
    {
      NativeStrandContainerLayout localNativeStrandContainerLayout = (NativeStrandContainerLayout)paramView;
      if (localNativeStrandContainerLayout.getChildCount() == 0) {
        c(paramView);
      }
      for (;;)
      {
        return;
        paramView = new Stack();
        paramView.push(localNativeStrandContainerLayout);
        while (!paramView.isEmpty())
        {
          localNativeStrandContainerLayout = (NativeStrandContainerLayout)paramView.pop();
          int i = localNativeStrandContainerLayout.getChildCount() - 1;
          if (i >= 0)
          {
            View localView = localNativeStrandContainerLayout.getChildAt(i);
            localNativeStrandContainerLayout.removeViewAt(i);
            if ((localView instanceof NativeStrandContainerLayout)) {
              paramView.push((NativeStrandContainerLayout)localView);
            }
            for (;;)
            {
              i -= 1;
              break;
              c(localView);
            }
          }
          c(localNativeStrandContainerLayout);
        }
      }
    }
    c(paramView);
  }
  
  public void a(@NonNull ViewGroup paramViewGroup)
  {
    int i = paramViewGroup.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = paramViewGroup.getChildAt(i);
      paramViewGroup.removeViewAt(i);
      a(localView);
      i -= 1;
    }
  }
  
  private static final class a
    extends TextView
  {
    public a(Context paramContext)
    {
      super();
    }
    
    public boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      return false;
    }
  }
  
  private abstract class b
  {
    @NonNull
    private LinkedList<View> a = new LinkedList();
    private int c = 0;
    private int d = 0;
    
    public b() {}
    
    public int a()
    {
      return this.a.size();
    }
    
    protected abstract View a(@NonNull Context paramContext);
    
    public View a(@NonNull Context paramContext, NativeStrandAsset paramNativeStrandAsset)
    {
      if (this.a.isEmpty())
      {
        this.c += 1;
        paramContext = a(paramContext);
      }
      for (;;)
      {
        a(paramContext, paramNativeStrandAsset);
        return paramContext;
        this.d += 1;
        paramContext = (View)this.a.removeFirst();
        aj.b(aj.this);
      }
    }
    
    protected abstract void a(@NonNull View paramView, @NonNull NativeStrandAsset paramNativeStrandAsset);
    
    public boolean a(@NonNull View paramView)
    {
      aj.b(paramView);
      paramView.setOnClickListener(null);
      this.a.addLast(paramView);
      aj.a(aj.this);
      return true;
    }
    
    public void b()
    {
      if (this.a.size() > 0) {
        this.a.removeFirst();
      }
    }
    
    public String toString()
    {
      return "Size:" + this.a.size() + " Miss Count:" + this.c + " Hit Count:" + this.d;
    }
  }
  
  private static enum c
  {
    private c() {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */