package a.a.a.d;

import a.a.a.d;
import a.a.a.f;

abstract class a<T>
{
  protected final a.a.a.a<T, ?> a;
  protected final f<T> b;
  protected final String c;
  protected final String[] d;
  protected final Thread e;
  
  protected a(a.a.a.a<T, ?> parama, String paramString, String[] paramArrayOfString)
  {
    this.a = parama;
    this.b = new f(parama);
    this.c = paramString;
    this.d = paramArrayOfString;
    this.e = Thread.currentThread();
  }
  
  protected static String[] a(Object[] paramArrayOfObject)
  {
    int j = paramArrayOfObject.length;
    String[] arrayOfString = new String[j];
    int i = 0;
    if (i < j)
    {
      Object localObject = paramArrayOfObject[i];
      if (localObject != null) {
        arrayOfString[i] = localObject.toString();
      }
      for (;;)
      {
        i += 1;
        break;
        arrayOfString[i] = null;
      }
    }
    return arrayOfString;
  }
  
  protected void a()
  {
    if (Thread.currentThread() != this.e) {
      throw new d("Method may be called only in owner thread, use forCurrentThread to get an instance for this thread");
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\a\a\a\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */