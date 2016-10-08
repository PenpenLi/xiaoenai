package com.xiaoenai.app.classes.common.image.croper;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class CropImageView
  extends ImageViewTouchBase
{
  ArrayList<l> a = new ArrayList();
  l b = null;
  float c;
  float d;
  int e;
  private Context q;
  
  public CropImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.q = paramContext;
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    int k = 0;
    int i = 0;
    int j;
    l locall;
    for (;;)
    {
      j = k;
      if (i >= this.a.size()) {
        break;
      }
      locall = (l)this.a.get(i);
      locall.a(false);
      locall.c();
      i += 1;
    }
    do
    {
      j += 1;
      if (j >= this.a.size()) {
        break;
      }
      locall = (l)this.a.get(j);
    } while (locall.a(paramMotionEvent.getX(), paramMotionEvent.getY()) == 1);
    if (!locall.a())
    {
      locall.a(true);
      locall.c();
    }
    invalidate();
  }
  
  private void b(l paraml)
  {
    paraml = paraml.d;
    int i = Math.max(0, this.l - paraml.left);
    int m = Math.min(0, this.m - paraml.right);
    int j = Math.max(0, this.n - paraml.top);
    int k = Math.min(0, this.o - paraml.bottom);
    if (i != 0) {
      if (j == 0) {
        break label94;
      }
    }
    for (;;)
    {
      if ((i != 0) || (j != 0)) {
        b(i, j);
      }
      return;
      i = m;
      break;
      label94:
      j = k;
    }
  }
  
  private void c(l paraml)
  {
    Object localObject = paraml.d;
    float f1 = ((Rect)localObject).width();
    float f2 = ((Rect)localObject).height();
    float f3 = getWidth();
    float f4 = getHeight();
    f1 = Math.max(1.0F, Math.min(f3 / f1 * 0.6F, f4 / f2 * 0.6F) * getScale());
    if (Math.abs(f1 - getScale()) / f1 > 0.1D)
    {
      localObject = new float[2];
      localObject[0] = paraml.e.centerX();
      localObject[1] = paraml.e.centerY();
      getImageMatrix().mapPoints((float[])localObject);
      a(f1, localObject[0], localObject[1], 300.0F);
    }
    b(paraml);
  }
  
  protected void a(float paramFloat1, float paramFloat2)
  {
    super.a(paramFloat1, paramFloat2);
    int i = 0;
    while (i < this.a.size())
    {
      l locall = (l)this.a.get(i);
      locall.f.postTranslate(paramFloat1, paramFloat2);
      locall.c();
      i += 1;
    }
  }
  
  protected void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super.a(paramFloat1, paramFloat2, paramFloat3);
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      l locall = (l)localIterator.next();
      locall.f.set(getImageMatrix());
      locall.c();
    }
  }
  
  public void a(l paraml)
  {
    this.a.add(paraml);
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = 0;
    while (i < this.a.size())
    {
      ((l)this.a.get(i)).a(paramCanvas);
      i += 1;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.h.b() != null)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        l locall = (l)localIterator.next();
        locall.f.set(getImageMatrix());
        locall.c();
        if (locall.b) {
          c(locall);
        }
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject = (CropImage)this.q;
    if (((CropImage)localObject).b) {
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    default: 
      switch (paramMotionEvent.getAction())
      {
      }
      break;
    }
    for (;;)
    {
      return true;
      if (((CropImage)localObject).a)
      {
        a(paramMotionEvent);
        break;
      }
      int i = 0;
      int j;
      l locall;
      while (i < this.a.size())
      {
        localObject = (l)this.a.get(i);
        j = ((l)localObject).a(paramMotionEvent.getX(), paramMotionEvent.getY());
        if (j != 1)
        {
          this.e = j;
          this.b = ((l)localObject);
          this.c = paramMotionEvent.getX();
          this.d = paramMotionEvent.getY();
          locall = this.b;
          if (j == 32) {}
          for (localObject = l.a.b;; localObject = l.a.c)
          {
            locall.a((l.a)localObject);
            break;
          }
        }
        i += 1;
      }
      if (((CropImage)localObject).a)
      {
        i = 0;
        while (i < this.a.size())
        {
          locall = (l)this.a.get(i);
          if (locall.a())
          {
            ((CropImage)localObject).c = locall;
            j = 0;
            if (j < this.a.size())
            {
              if (j == i) {}
              for (;;)
              {
                j += 1;
                break;
                ((l)this.a.get(j)).b(true);
              }
            }
            c(locall);
            ((CropImage)this.q).a = false;
            return true;
          }
          i += 1;
        }
      }
      if (this.b != null)
      {
        c(this.b);
        this.b.a(l.a.a);
      }
      this.b = null;
      break;
      if (((CropImage)localObject).a)
      {
        a(paramMotionEvent);
        break;
      }
      if (this.b == null) {
        break;
      }
      this.b.a(this.e, paramMotionEvent.getX() - this.c, paramMotionEvent.getY() - this.d);
      this.c = paramMotionEvent.getX();
      this.d = paramMotionEvent.getY();
      b(this.b);
      break;
      a(true, true);
      continue;
      if (getScale() == 1.0F) {
        a(true, true);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\image\croper\CropImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */