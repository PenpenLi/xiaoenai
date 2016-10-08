package com.meiqia.core.a.a.d;

import com.meiqia.core.a.a.f.b;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class e
  implements c
{
  protected static byte[] b = new byte[0];
  private ByteBuffer a;
  protected boolean c;
  protected d.a d;
  protected boolean e;
  
  public e() {}
  
  public e(d.a parama)
  {
    this.d = parama;
    this.a = ByteBuffer.wrap(b);
  }
  
  public e(d paramd)
  {
    this.c = paramd.d();
    this.d = paramd.f();
    this.a = paramd.c();
    this.e = paramd.e();
  }
  
  public void a(d.a parama)
  {
    this.d = parama;
  }
  
  public void a(ByteBuffer paramByteBuffer)
  {
    this.a = paramByteBuffer;
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void b(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public ByteBuffer c()
  {
    return this.a;
  }
  
  public boolean d()
  {
    return this.c;
  }
  
  public boolean e()
  {
    return this.e;
  }
  
  public d.a f()
  {
    return this.d;
  }
  
  public String toString()
  {
    return "Framedata{ optcode:" + f() + ", fin:" + d() + ", payloadlength:[pos:" + this.a.position() + ", len:" + this.a.remaining() + "], payload:" + Arrays.toString(b.a(new String(this.a.array()))) + "}";
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\meiqia\core\a\a\d\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */