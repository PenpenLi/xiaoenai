package com.xiaoenai.app.ui.photoview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.xiaoenai.app.utils.d.t;
import java.lang.ref.WeakReference;
import uk.co.senab.photoview.a.e;
import uk.co.senab.photoview.a.f;
import uk.co.senab.photoview.a.g;

public class c
  implements View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener, b, f
{
  static final Interpolator a = new AccelerateDecelerateInterpolator();
  private static final boolean c = Log.isLoggable("IPhotoView", 3);
  private boolean A;
  private ImageView.ScaleType B = ImageView.ScaleType.FIT_CENTER;
  int b = 200;
  private float d = 1.0F;
  private float e = 1.75F;
  private float f = 3.0F;
  private boolean g = true;
  private View.OnClickListener h = null;
  private WeakReference<ImageView> i;
  private GestureDetector j;
  private e k;
  private final Matrix l = new Matrix();
  private final Matrix m = new Matrix();
  private final Matrix n = new Matrix();
  private final RectF o = new RectF();
  private final float[] p = new float[9];
  private c q;
  private d r;
  private e s;
  private View.OnLongClickListener t;
  private int u;
  private int v;
  private int w;
  private int x;
  private b y;
  private int z = 2;
  
  public c(ImageView paramImageView)
  {
    this.i = new WeakReference(paramImageView);
    paramImageView.setDrawingCacheEnabled(true);
    paramImageView.setOnTouchListener(this);
    ViewTreeObserver localViewTreeObserver = paramImageView.getViewTreeObserver();
    if (localViewTreeObserver != null) {
      localViewTreeObserver.addOnGlobalLayoutListener(this);
    }
    b(paramImageView);
    if (paramImageView.isInEditMode()) {
      return;
    }
    this.k = g.a(paramImageView.getContext(), this);
    this.j = new GestureDetector(paramImageView.getContext(), new d(this));
    this.j.setOnDoubleTapListener(new a(this));
    b(true);
  }
  
  private float a(Matrix paramMatrix, int paramInt)
  {
    paramMatrix.getValues(this.p);
    return this.p[paramInt];
  }
  
  private RectF a(Matrix paramMatrix)
  {
    Object localObject = c();
    if (localObject != null)
    {
      localObject = ((ImageView)localObject).getDrawable();
      if (localObject != null)
      {
        this.o.set(0.0F, 0.0F, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
        paramMatrix.mapRect(this.o);
        return this.o;
      }
    }
    return null;
  }
  
  private void a(Drawable paramDrawable)
  {
    Object localObject = c();
    if ((localObject == null) || (paramDrawable == null)) {
      return;
    }
    float f1 = c((ImageView)localObject);
    float f2 = d((ImageView)localObject);
    int i1 = paramDrawable.getIntrinsicWidth();
    int i2 = paramDrawable.getIntrinsicHeight();
    this.l.reset();
    float f3 = f1 / i1;
    float f4 = f2 / i2;
    if (this.B == ImageView.ScaleType.CENTER) {
      this.l.postTranslate((f1 - i1) / 2.0F, (f2 - i2) / 2.0F);
    }
    for (;;)
    {
      s();
      return;
      if (this.B == ImageView.ScaleType.CENTER_CROP)
      {
        f2 = Math.max(f3, f4);
        this.l.postScale(f2, f2);
        this.l.postTranslate((f1 - f2 * i1) / 2.0F, 0.0F);
      }
      else if (this.B == ImageView.ScaleType.CENTER_INSIDE)
      {
        f3 = Math.min(1.0F, Math.min(f3, f4));
        this.l.postScale(f3, f3);
        this.l.postTranslate((f1 - i1 * f3) / 2.0F, (f2 - i2 * f3) / 2.0F);
      }
      else
      {
        paramDrawable = new RectF(0.0F, 0.0F, i1, i2);
        localObject = new RectF(0.0F, 0.0F, f1, f2);
        switch (e.a[this.B.ordinal()])
        {
        default: 
          break;
        case 2: 
          this.l.setRectToRect(paramDrawable, (RectF)localObject, Matrix.ScaleToFit.START);
          break;
        case 4: 
          this.l.setRectToRect(paramDrawable, (RectF)localObject, Matrix.ScaleToFit.CENTER);
          break;
        case 3: 
          this.l.setRectToRect(paramDrawable, (RectF)localObject, Matrix.ScaleToFit.END);
          break;
        case 5: 
          this.l.setRectToRect(paramDrawable, (RectF)localObject, Matrix.ScaleToFit.FILL);
        }
      }
    }
  }
  
  private static boolean a(ImageView paramImageView)
  {
    return (paramImageView != null) && (paramImageView.getDrawable() != null);
  }
  
  private static void b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 >= paramFloat2) {
      throw new IllegalArgumentException("MinZoom has to be less than MidZoom");
    }
    if (paramFloat2 >= paramFloat3) {
      throw new IllegalArgumentException("MidZoom has to be less than MaxZoom");
    }
  }
  
  private void b(Matrix paramMatrix)
  {
    ImageView localImageView = c();
    if (localImageView != null)
    {
      q();
      localImageView.setImageMatrix(paramMatrix);
      if (this.q != null)
      {
        paramMatrix = a(paramMatrix);
        if (paramMatrix != null) {
          this.q.a(paramMatrix);
        }
      }
    }
  }
  
  private static void b(ImageView paramImageView)
  {
    if ((paramImageView != null) && (!(paramImageView instanceof b)) && (!ImageView.ScaleType.MATRIX.equals(paramImageView.getScaleType()))) {
      paramImageView.setScaleType(ImageView.ScaleType.MATRIX);
    }
  }
  
  private static boolean b(ImageView.ScaleType paramScaleType)
  {
    if (paramScaleType == null) {
      return false;
    }
    switch (e.a[paramScaleType.ordinal()])
    {
    default: 
      return true;
    }
    throw new IllegalArgumentException(paramScaleType.name() + " is not supported in PhotoView");
  }
  
  private int c(ImageView paramImageView)
  {
    if (paramImageView == null) {
      return 0;
    }
    return paramImageView.getWidth() - paramImageView.getPaddingLeft() - paramImageView.getPaddingRight();
  }
  
  private int d(ImageView paramImageView)
  {
    if (paramImageView == null) {
      return 0;
    }
    return paramImageView.getHeight() - paramImageView.getPaddingTop() - paramImageView.getPaddingBottom();
  }
  
  private void o()
  {
    if (this.y != null)
    {
      this.y.a();
      this.y = null;
    }
  }
  
  private void p()
  {
    if (r()) {
      b(l());
    }
  }
  
  private void q()
  {
    ImageView localImageView = c();
    if ((localImageView != null) && (!(localImageView instanceof b)) && (!ImageView.ScaleType.MATRIX.equals(localImageView.getScaleType()))) {
      throw new IllegalStateException("The ImageView's ScaleType has been changed since attaching a IPhotoView");
    }
  }
  
  private boolean r()
  {
    float f2 = 0.0F;
    ImageView localImageView = c();
    if (localImageView == null) {
      return false;
    }
    RectF localRectF = a(l());
    if (localRectF == null) {
      return false;
    }
    float f1 = localRectF.height();
    float f3 = localRectF.width();
    int i1 = d(localImageView);
    if (f1 <= i1) {
      switch (e.a[this.B.ordinal()])
      {
      default: 
        f1 = (i1 - f1) / 2.0F - localRectF.top;
      }
    }
    for (;;)
    {
      i1 = c(localImageView);
      if (f3 <= i1) {
        switch (e.a[this.B.ordinal()])
        {
        default: 
          f2 = (i1 - f3) / 2.0F - localRectF.left;
          label170:
          this.z = 2;
        }
      }
      for (;;)
      {
        this.n.postTranslate(f2, f1);
        return true;
        f1 = -localRectF.top;
        break;
        f1 = i1 - f1 - localRectF.top;
        break;
        if (localRectF.top > 0.0F)
        {
          f1 = -localRectF.top;
          break;
        }
        if (localRectF.bottom >= i1) {
          break label345;
        }
        f1 = i1 - localRectF.bottom;
        break;
        f2 = -localRectF.left;
        break label170;
        f2 = i1 - f3 - localRectF.left;
        break label170;
        if (localRectF.left > 0.0F)
        {
          this.z = 0;
          f2 = -localRectF.left;
        }
        else if (localRectF.right < i1)
        {
          f2 = i1 - localRectF.right;
          this.z = 1;
        }
        else
        {
          this.z = -1;
        }
      }
      label345:
      f1 = 0.0F;
    }
  }
  
  private void s()
  {
    this.n.reset();
    b(l());
    r();
  }
  
  public void a()
  {
    if (this.i == null) {
      return;
    }
    ImageView localImageView = (ImageView)this.i.get();
    if (localImageView != null)
    {
      ViewTreeObserver localViewTreeObserver = localImageView.getViewTreeObserver();
      if ((localViewTreeObserver != null) && (localViewTreeObserver.isAlive())) {
        localViewTreeObserver.removeGlobalOnLayoutListener(this);
      }
      localImageView.setOnTouchListener(null);
      o();
    }
    if (this.j != null) {
      this.j.setOnDoubleTapListener(null);
    }
    this.q = null;
    this.r = null;
    this.s = null;
    this.i = null;
  }
  
  public void a(float paramFloat)
  {
    this.n.setRotate(paramFloat % 360.0F);
    p();
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (this.k.a()) {}
    Object localObject;
    do
    {
      do
      {
        return;
        if (c) {
          uk.co.senab.photoview.b.a.a().a("IPhotoView", String.format("onDrag: dx: %.2f. dy: %.2f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) }));
        }
        localObject = c();
        this.n.postTranslate(paramFloat1, paramFloat2);
        p();
        localObject = ((ImageView)localObject).getParent();
        if ((!this.g) || (this.k.a())) {
          break;
        }
      } while (((this.z != 2) && ((this.z != 0) || (paramFloat1 < 1.0F)) && ((this.z != 1) || (paramFloat1 > -1.0F))) || (localObject == null));
      ((ViewParent)localObject).requestDisallowInterceptTouchEvent(false);
      return;
    } while (localObject == null);
    ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (c) {
      uk.co.senab.photoview.b.a.a().a("IPhotoView", String.format("onScale: scale: %.2f. fX: %.2f. fY: %.2f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3) }));
    }
    if ((g() < this.f) || (paramFloat1 < 1.0F))
    {
      this.n.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
      p();
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (c) {
      uk.co.senab.photoview.b.a.a().a("IPhotoView", "onFling. sX: " + paramFloat1 + " sY: " + paramFloat2 + " Vx: " + paramFloat3 + " Vy: " + paramFloat4);
    }
    ImageView localImageView = c();
    this.y = new b(localImageView.getContext());
    this.y.a(c(localImageView), d(localImageView), (int)paramFloat3, (int)paramFloat4);
    localImageView.post(this.y);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean)
  {
    ImageView localImageView = c();
    if (localImageView != null)
    {
      if ((paramFloat1 < this.d) || (paramFloat1 > this.f)) {
        uk.co.senab.photoview.b.a.a().b("IPhotoView", "Scale must be within the range of minScale and maxScale");
      }
    }
    else {
      return;
    }
    if (paramBoolean)
    {
      localImageView.post(new a(g(), paramFloat1, paramFloat2, paramFloat3));
      return;
    }
    this.n.setScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
    p();
  }
  
  public void a(float paramFloat, boolean paramBoolean)
  {
    ImageView localImageView = c();
    if (localImageView != null) {
      a(paramFloat, localImageView.getRight() / 2, localImageView.getBottom() / 2, paramBoolean);
    }
  }
  
  public void a(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt < 0) {
      i1 = 200;
    }
    this.b = i1;
  }
  
  public void a(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener)
  {
    if (paramOnDoubleTapListener != null)
    {
      this.j.setOnDoubleTapListener(paramOnDoubleTapListener);
      return;
    }
    this.j.setOnDoubleTapListener(new a(this));
  }
  
  public void a(MotionEvent paramMotionEvent) {}
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.h = paramOnClickListener;
  }
  
  public void a(View.OnLongClickListener paramOnLongClickListener)
  {
    this.t = paramOnLongClickListener;
  }
  
  public void a(ImageView.ScaleType paramScaleType)
  {
    if ((b(paramScaleType)) && (paramScaleType != this.B))
    {
      this.B = paramScaleType;
      k();
    }
  }
  
  public void a(c paramc)
  {
    this.q = paramc;
  }
  
  public void a(d paramd)
  {
    this.r = paramd;
  }
  
  public void a(e parame)
  {
    this.s = parame;
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public RectF b()
  {
    r();
    return a(l());
  }
  
  public void b(float paramFloat)
  {
    this.n.postRotate(paramFloat % 360.0F);
    p();
  }
  
  public void b(MotionEvent paramMotionEvent)
  {
    if (this.h != null) {
      this.h.onClick(null);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.A = paramBoolean;
    k();
  }
  
  public ImageView c()
  {
    ImageView localImageView = null;
    if (this.i != null) {
      localImageView = (ImageView)this.i.get();
    }
    if (localImageView == null)
    {
      a();
      Log.i("IPhotoView", "ImageView no longer exists. You should not use this IPhotoView any more.");
    }
    return localImageView;
  }
  
  public void c(float paramFloat)
  {
    b(paramFloat, this.e, this.f);
    this.d = paramFloat;
  }
  
  public float d()
  {
    return this.d;
  }
  
  public void d(float paramFloat)
  {
    b(this.d, paramFloat, this.f);
    this.e = paramFloat;
  }
  
  public float e()
  {
    return this.e;
  }
  
  public void e(float paramFloat)
  {
    b(this.d, this.e, paramFloat);
    this.f = paramFloat;
  }
  
  public float f()
  {
    return this.f;
  }
  
  public void f(float paramFloat)
  {
    a(paramFloat, false);
  }
  
  public float g()
  {
    return (float)Math.sqrt((float)Math.pow(a(this.n, 0), 2.0D) + (float)Math.pow(a(this.n, 3), 2.0D));
  }
  
  public ImageView.ScaleType h()
  {
    return this.B;
  }
  
  public d i()
  {
    return this.r;
  }
  
  public e j()
  {
    return this.s;
  }
  
  public void k()
  {
    ImageView localImageView = c();
    if (localImageView != null)
    {
      if (this.A)
      {
        b(localImageView);
        a(localImageView.getDrawable());
      }
    }
    else {
      return;
    }
    s();
  }
  
  public Matrix l()
  {
    this.m.set(this.l);
    this.m.postConcat(this.n);
    return this.m;
  }
  
  public Bitmap m()
  {
    ImageView localImageView = c();
    if (localImageView == null) {
      return null;
    }
    return localImageView.getDrawingCache();
  }
  
  public void onGlobalLayout()
  {
    ImageView localImageView = c();
    if (localImageView != null)
    {
      if (!this.A) {
        break label175;
      }
      int i1 = localImageView.getTop();
      int i2 = localImageView.getRight();
      int i3 = localImageView.getBottom();
      int i4 = localImageView.getLeft();
      RectF localRectF = b();
      if ((localRectF != null) && (localRectF.width() != 0.0F))
      {
        com.xiaoenai.app.utils.f.a.c("w={}", new Object[] { Float.valueOf(localRectF.width()) });
        float f1 = t.b(localImageView.getContext()) / localRectF.width();
        if (f1 > f()) {
          e(f1);
        }
      }
      if ((i1 != this.u) || (i3 != this.w) || (i4 != this.x) || (i2 != this.v))
      {
        a(localImageView.getDrawable());
        this.u = i1;
        this.v = i2;
        this.w = i3;
        this.x = i4;
      }
    }
    return;
    label175:
    a(localImageView.getDrawable());
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool1 = bool4;
    Object localObject;
    if (this.A)
    {
      bool1 = bool4;
      if (a((ImageView)paramView))
      {
        localObject = paramView.getParent();
        bool1 = bool3;
        switch (paramMotionEvent.getAction())
        {
        default: 
          bool1 = bool3;
        }
      }
    }
    for (;;)
    {
      try
      {
        if (this.k == null) {
          break label245;
        }
        bool3 = this.k.c(paramMotionEvent);
        if (!bool3) {
          break label245;
        }
        bool1 = true;
      }
      catch (IllegalArgumentException paramView)
      {
        label107:
        paramView.printStackTrace();
        return bool1;
      }
      try
      {
        if (this.j == null) {
          break label242;
        }
        bool3 = this.j.onTouchEvent(paramMotionEvent);
        if (!bool3) {
          break label242;
        }
        bool1 = bool2;
      }
      catch (IllegalArgumentException paramView)
      {
        continue;
        continue;
      }
      return bool1;
      if (localObject != null)
      {
        ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
        o();
        bool1 = bool3;
      }
      else
      {
        Log.i("IPhotoView", "onTouch getParent() returned null");
        continue;
        bool1 = bool3;
        if (g() < this.d)
        {
          localObject = b();
          if (localObject == null) {
            break label248;
          }
          paramView.post(new a(g(), this.d, ((RectF)localObject).centerX(), ((RectF)localObject).centerY()));
        }
      }
    }
    label242:
    label245:
    label248:
    for (bool1 = true;; bool1 = false)
    {
      break;
      break label107;
    }
  }
  
  private class a
    implements Runnable
  {
    private final float b;
    private final float c;
    private final long d;
    private final float e;
    private final float f;
    
    public a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      this.b = paramFloat3;
      this.c = paramFloat4;
      this.d = System.currentTimeMillis();
      this.e = paramFloat1;
      this.f = paramFloat2;
    }
    
    private float a()
    {
      float f1 = Math.min(1.0F, (float)(System.currentTimeMillis() - this.d) * 1.0F / c.this.b);
      return c.a.getInterpolation(f1);
    }
    
    public void run()
    {
      ImageView localImageView = c.this.c();
      if (localImageView == null) {}
      float f1;
      do
      {
        return;
        f1 = a();
        float f2 = (this.e + (this.f - this.e) * f1) / c.this.g();
        c.b(c.this).postScale(f2, f2, this.b, this.c);
        c.c(c.this);
      } while (f1 >= 1.0F);
      uk.co.senab.photoview.a.a(localImageView, this);
    }
  }
  
  private class b
    implements Runnable
  {
    private final uk.co.senab.photoview.c.d b;
    private int c;
    private int d;
    
    public b(Context paramContext)
    {
      this.b = uk.co.senab.photoview.c.d.a(paramContext);
    }
    
    public void a()
    {
      if (c.n()) {
        uk.co.senab.photoview.b.a.a().a("IPhotoView", "Cancel Fling");
      }
      this.b.a(true);
    }
    
    public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      RectF localRectF = c.this.b();
      if (localRectF == null) {
        return;
      }
      int i = Math.round(-localRectF.left);
      int j;
      label52:
      int k;
      int m;
      if (paramInt1 < localRectF.width())
      {
        j = Math.round(localRectF.width() - paramInt1);
        paramInt1 = 0;
        k = Math.round(-localRectF.top);
        if (paramInt2 >= localRectF.height()) {
          break label215;
        }
        m = Math.round(localRectF.height() - paramInt2);
      }
      for (paramInt2 = 0;; paramInt2 = k)
      {
        this.c = i;
        this.d = k;
        if (c.n()) {
          uk.co.senab.photoview.b.a.a().a("IPhotoView", "fling. StartX:" + i + " StartY:" + k + " MaxX:" + j + " MaxY:" + m);
        }
        if ((i == j) && (k == m)) {
          break;
        }
        this.b.a(i, k, paramInt3, paramInt4, paramInt1, j, paramInt2, m, 0, 0);
        return;
        j = i;
        paramInt1 = i;
        break label52;
        label215:
        m = k;
      }
    }
    
    public void run()
    {
      if (this.b.b()) {}
      ImageView localImageView;
      do
      {
        return;
        localImageView = c.this.c();
      } while ((localImageView == null) || (!this.b.a()));
      int i = this.b.c();
      int j = this.b.d();
      if (c.n()) {
        uk.co.senab.photoview.b.a.a().a("IPhotoView", "fling run(). CurrentX:" + this.c + " CurrentY:" + this.d + " NewX:" + i + " NewY:" + j);
      }
      c.b(c.this).postTranslate(this.c - i, this.d - j);
      c.a(c.this, c.this.l());
      this.c = i;
      this.d = j;
      uk.co.senab.photoview.a.a(localImageView, this);
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(RectF paramRectF);
  }
  
  public static abstract interface d
  {
    public abstract void a(View paramView, float paramFloat1, float paramFloat2);
  }
  
  public static abstract interface e
  {
    public abstract void a(View paramView, float paramFloat1, float paramFloat2);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\ui\photoview\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */