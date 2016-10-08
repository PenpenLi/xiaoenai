package com.xiaoenai.app.utils.f.c;

public class a
{
  public static a a = new a(null);
  private String b;
  private Throwable c;
  private Object[] d;
  
  public a(String paramString)
  {
    this(paramString, null, null);
  }
  
  public a(String paramString, Object[] paramArrayOfObject, Throwable paramThrowable)
  {
    this.b = paramString;
    this.c = paramThrowable;
    if (paramThrowable == null)
    {
      this.d = paramArrayOfObject;
      return;
    }
    this.d = a(paramArrayOfObject);
  }
  
  static Object[] a(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length == 0)) {
      throw new IllegalStateException("non-sensical empty or null argument array");
    }
    int i = paramArrayOfObject.length - 1;
    Object[] arrayOfObject = new Object[i];
    System.arraycopy(paramArrayOfObject, 0, arrayOfObject, 0, i);
    return arrayOfObject;
  }
  
  public String a()
  {
    return this.b;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\utils\f\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */