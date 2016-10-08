package android.support.v7.app;

import android.support.v7.widget.ContentFrameLayout.OnAttachListener;

class t
  implements ContentFrameLayout.OnAttachListener
{
  t(AppCompatDelegateImplV7 paramAppCompatDelegateImplV7) {}
  
  public void onAttachedFromWindow() {}
  
  public void onDetachedFromWindow()
  {
    AppCompatDelegateImplV7.b(this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\app\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */