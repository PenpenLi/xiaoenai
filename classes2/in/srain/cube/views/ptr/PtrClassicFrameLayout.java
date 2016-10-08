package in.srain.cube.views.ptr;

import android.content.Context;
import android.util.AttributeSet;

public class PtrClassicFrameLayout
  extends PtrFrameLayout
{
  private PtrClassicDefaultHeader d;
  
  public PtrClassicFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    i();
  }
  
  public PtrClassicFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    i();
  }
  
  private void i()
  {
    this.d = new PtrClassicDefaultHeader(getContext());
    setHeaderView(this.d);
    a(this.d);
  }
  
  public PtrClassicDefaultHeader getHeader()
  {
    return this.d;
  }
  
  public void setLastUpdateTimeKey(String paramString)
  {
    if (this.d != null) {
      this.d.setLastUpdateTimeKey(paramString);
    }
  }
  
  public void setLastUpdateTimeRelateObject(Object paramObject)
  {
    if (this.d != null) {
      this.d.setLastUpdateTimeRelateObject(paramObject);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\in\srain\cube\views\ptr\PtrClassicFrameLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */