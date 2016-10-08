package android.support.v7.widget.helper;

import android.graphics.Canvas;
import android.support.v4.view.ViewCompat;
import android.support.v7.b.a.b;
import android.support.v7.widget.RecyclerView;
import android.view.View;

class i
{
  static class a
    implements ItemTouchUIUtil
  {
    private void a(Canvas paramCanvas, RecyclerView paramRecyclerView, View paramView, float paramFloat1, float paramFloat2)
    {
      paramCanvas.save();
      paramCanvas.translate(paramFloat1, paramFloat2);
      paramRecyclerView.drawChild(paramCanvas, paramView, 0L);
      paramCanvas.restore();
    }
    
    public void clearView(View paramView)
    {
      paramView.setVisibility(0);
    }
    
    public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, View paramView, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
    {
      if (paramInt != 2) {
        a(paramCanvas, paramRecyclerView, paramView, paramFloat1, paramFloat2);
      }
    }
    
    public void onDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView, View paramView, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
    {
      if (paramInt == 2) {
        a(paramCanvas, paramRecyclerView, paramView, paramFloat1, paramFloat2);
      }
    }
    
    public void onSelected(View paramView)
    {
      paramView.setVisibility(4);
    }
  }
  
  static class b
    implements ItemTouchUIUtil
  {
    public void clearView(View paramView)
    {
      ViewCompat.setTranslationX(paramView, 0.0F);
      ViewCompat.setTranslationY(paramView, 0.0F);
    }
    
    public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, View paramView, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
    {
      ViewCompat.setTranslationX(paramView, paramFloat1);
      ViewCompat.setTranslationY(paramView, paramFloat2);
    }
    
    public void onDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView, View paramView, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean) {}
    
    public void onSelected(View paramView) {}
  }
  
  static class c
    extends i.b
  {
    private float a(RecyclerView paramRecyclerView, View paramView)
    {
      int j = paramRecyclerView.getChildCount();
      int i = 0;
      float f1 = 0.0F;
      if (i < j)
      {
        View localView = paramRecyclerView.getChildAt(i);
        float f2;
        if (localView == paramView) {
          f2 = f1;
        }
        for (;;)
        {
          i += 1;
          f1 = f2;
          break;
          float f3 = ViewCompat.getElevation(localView);
          f2 = f1;
          if (f3 > f1) {
            f2 = f3;
          }
        }
      }
      return f1;
    }
    
    public void clearView(View paramView)
    {
      Object localObject = paramView.getTag(a.b.item_touch_helper_previous_elevation);
      if ((localObject != null) && ((localObject instanceof Float))) {
        ViewCompat.setElevation(paramView, ((Float)localObject).floatValue());
      }
      paramView.setTag(a.b.item_touch_helper_previous_elevation, null);
      super.clearView(paramView);
    }
    
    public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, View paramView, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
    {
      if ((paramBoolean) && (paramView.getTag(a.b.item_touch_helper_previous_elevation) == null))
      {
        float f = ViewCompat.getElevation(paramView);
        ViewCompat.setElevation(paramView, 1.0F + a(paramRecyclerView, paramView));
        paramView.setTag(a.b.item_touch_helper_previous_elevation, Float.valueOf(f));
      }
      super.onDraw(paramCanvas, paramRecyclerView, paramView, paramFloat1, paramFloat2, paramInt, paramBoolean);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\helper\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */