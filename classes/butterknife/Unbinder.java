package butterknife;

import android.support.annotation.UiThread;

public abstract interface Unbinder
{
  public static final Unbinder EMPTY = new Unbinder.1();
  
  @UiThread
  public abstract void unbind();
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\butterknife\Unbinder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */