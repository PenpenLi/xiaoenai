package android.support.v7.widget;

import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;

class s
  extends r
{
  private static final int[] b = { 16843074 };
  private final SeekBar c;
  
  s(SeekBar paramSeekBar, AppCompatDrawableManager paramAppCompatDrawableManager)
  {
    super(paramSeekBar, paramAppCompatDrawableManager);
    this.c = paramSeekBar;
  }
  
  void a(AttributeSet paramAttributeSet, int paramInt)
  {
    super.a(paramAttributeSet, paramInt);
    paramAttributeSet = TintTypedArray.obtainStyledAttributes(this.c.getContext(), paramAttributeSet, b, paramInt, 0);
    Drawable localDrawable = paramAttributeSet.getDrawableIfKnown(0);
    if (localDrawable != null) {
      this.c.setThumb(localDrawable);
    }
    paramAttributeSet.recycle();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */