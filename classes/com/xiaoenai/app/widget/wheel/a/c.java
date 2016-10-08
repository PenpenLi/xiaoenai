package com.xiaoenai.app.widget.wheel.a;

import android.content.Context;

public class c<T>
  extends b
{
  private T[] a;
  private String g;
  
  public c(Context paramContext, T[] paramArrayOfT)
  {
    super(paramContext);
    this.a = paramArrayOfT;
  }
  
  public int a()
  {
    return this.a.length;
  }
  
  public CharSequence a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.length))
    {
      Object localObject = this.a[paramInt];
      if ((localObject instanceof CharSequence))
      {
        if (this.g != null) {
          return String.format(this.g, new Object[] { (CharSequence)localObject });
        }
        return (CharSequence)localObject;
      }
      if (this.g != null) {
        return String.format(this.g, new Object[] { localObject.toString() });
      }
      return localObject.toString();
    }
    return null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\widget\wheel\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */