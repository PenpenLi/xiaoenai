package com.google.gson.a;

import com.google.gson.a.a.v;
import com.google.gson.af;
import com.google.gson.c.d;
import com.google.gson.u;
import java.io.Writer;

public final class ab
{
  public static Writer a(Appendable paramAppendable)
  {
    if ((paramAppendable instanceof Writer)) {
      return (Writer)paramAppendable;
    }
    return new a(paramAppendable, null);
  }
  
  public static void a(u paramu, d paramd)
  {
    v.X.a(paramd, paramu);
  }
  
  private static final class a
    extends Writer
  {
    private final Appendable a;
    private final a b = new a();
    
    private a(Appendable paramAppendable)
    {
      this.a = paramAppendable;
    }
    
    public void close() {}
    
    public void flush() {}
    
    public void write(int paramInt)
    {
      this.a.append((char)paramInt);
    }
    
    public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    {
      this.b.a = paramArrayOfChar;
      this.a.append(this.b, paramInt1, paramInt1 + paramInt2);
    }
    
    static class a
      implements CharSequence
    {
      char[] a;
      
      public char charAt(int paramInt)
      {
        return this.a[paramInt];
      }
      
      public int length()
      {
        return this.a.length;
      }
      
      public CharSequence subSequence(int paramInt1, int paramInt2)
      {
        return new String(this.a, paramInt1, paramInt2 - paramInt1);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\google\gson\a\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */