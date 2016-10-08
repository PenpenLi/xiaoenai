package com.adhoc;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class cw
  implements di
{
  private static final Logger a = Logger.getLogger(b.class.getName());
  private static final er b = er.a("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
  
  private static int b(int paramInt, byte paramByte, short paramShort)
  {
    short s = paramInt;
    if ((paramByte & 0x8) != 0) {
      s = paramInt - 1;
    }
    if (paramShort > s) {
      throw d("PROTOCOL_ERROR padding %s > remaining length %s", new Object[] { Short.valueOf(paramShort), Integer.valueOf(s) });
    }
    return (short)(s - paramShort);
  }
  
  private static int b(eq parameq)
  {
    return (parameq.h() & 0xFF) << 16 | (parameq.h() & 0xFF) << 8 | parameq.h() & 0xFF;
  }
  
  private static void b(ep paramep, int paramInt)
  {
    paramep.h(paramInt >>> 16 & 0xFF);
    paramep.h(paramInt >>> 8 & 0xFF);
    paramep.h(paramInt & 0xFF);
  }
  
  private static IllegalArgumentException c(String paramString, Object... paramVarArgs)
  {
    throw new IllegalArgumentException(String.format(paramString, paramVarArgs));
  }
  
  private static IOException d(String paramString, Object... paramVarArgs)
  {
    throw new IOException(String.format(paramString, paramVarArgs));
  }
  
  public cf a(eq parameq, boolean paramBoolean)
  {
    return new c(parameq, 4096, paramBoolean);
  }
  
  public cg a(ep paramep, boolean paramBoolean)
  {
    return new d(paramep, paramBoolean);
  }
  
  static final class a
    implements fg
  {
    int a;
    byte b;
    int c;
    int d;
    short e;
    private final eq f;
    
    public a(eq parameq)
    {
      this.f = parameq;
    }
    
    private void b()
    {
      int i = this.c;
      int j = cw.a(this.f);
      this.d = j;
      this.a = j;
      byte b1 = (byte)(this.f.h() & 0xFF);
      this.b = ((byte)(this.f.h() & 0xFF));
      if (cw.b().isLoggable(Level.FINE)) {
        cw.b().fine(cw.b.a(true, this.c, this.a, b1, this.b));
      }
      this.c = (this.f.j() & 0x7FFFFFFF);
      if (b1 != 9) {
        throw cw.a("%s != TYPE_CONTINUATION", new Object[] { Byte.valueOf(b1) });
      }
      if (this.c != i) {
        throw cw.a("TYPE_CONTINUATION streamId changed", new Object[0]);
      }
    }
    
    public long a(eo parameo, long paramLong)
    {
      if (this.d == 0)
      {
        this.f.g(this.e);
        this.e = 0;
        if ((this.b & 0x4) == 0) {}
      }
      do
      {
        return -1L;
        b();
        break;
        paramLong = this.f.a(parameo, Math.min(paramLong, this.d));
      } while (paramLong == -1L);
      this.d = ((int)(this.d - paramLong));
      return paramLong;
    }
    
    public fh a()
    {
      return this.f.a();
    }
    
    public void close() {}
  }
  
  static final class b
  {
    private static final String[] a;
    private static final String[] b;
    private static final String[] c;
    
    static
    {
      int k = 0;
      a = new String[] { "DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION" };
      b = new String[64];
      c = new String['Ā'];
      int i = 0;
      while (i < c.length)
      {
        c[i] = String.format("%8s", new Object[] { Integer.toBinaryString(i) }).replace(' ', '0');
        i += 1;
      }
      b[0] = "";
      b[1] = "END_STREAM";
      int[] arrayOfInt1 = new int[1];
      arrayOfInt1[0] = 1;
      b[8] = "PADDED";
      int j = arrayOfInt1.length;
      i = 0;
      while (i < j)
      {
        m = arrayOfInt1[i];
        b[(m | 0x8)] = (b[m] + "|PADDED");
        i += 1;
      }
      b[4] = "END_HEADERS";
      b[32] = "PRIORITY";
      b[36] = "END_HEADERS|PRIORITY";
      int[] arrayOfInt2 = new int[3];
      int[] tmp240_239 = arrayOfInt2;
      tmp240_239[0] = 4;
      int[] tmp244_240 = tmp240_239;
      tmp244_240[1] = 32;
      int[] tmp249_244 = tmp244_240;
      tmp249_244[2] = 36;
      tmp249_244;
      int m = arrayOfInt2.length;
      i = 0;
      for (;;)
      {
        j = k;
        if (i >= m) {
          break;
        }
        int n = arrayOfInt2[i];
        int i1 = arrayOfInt1.length;
        j = 0;
        while (j < i1)
        {
          int i2 = arrayOfInt1[j];
          b[(i2 | n)] = (b[i2] + '|' + b[n]);
          b[(i2 | n | 0x8)] = (b[i2] + '|' + b[n] + "|PADDED");
          j += 1;
        }
        i += 1;
      }
      while (j < b.length)
      {
        if (b[j] == null) {
          b[j] = c[j];
        }
        j += 1;
      }
    }
    
    static String a(byte paramByte1, byte paramByte2)
    {
      Object localObject;
      if (paramByte2 == 0) {
        localObject = "";
      }
      String str;
      do
      {
        do
        {
          return (String)localObject;
          switch (paramByte1)
          {
          case 5: 
          default: 
            if (paramByte2 >= b.length) {
              break;
            }
          }
          for (str = b[paramByte2]; (paramByte1 == 5) && ((paramByte2 & 0x4) != 0); str = c[paramByte2])
          {
            return str.replace("HEADERS", "PUSH_PROMISE");
            if (paramByte2 == 1) {
              return "ACK";
            }
            return c[paramByte2];
            return c[paramByte2];
          }
          localObject = str;
        } while (paramByte1 != 0);
        localObject = str;
      } while ((paramByte2 & 0x20) == 0);
      return str.replace("PRIORITY", "COMPRESSED");
    }
    
    static String a(boolean paramBoolean, int paramInt1, int paramInt2, byte paramByte1, byte paramByte2)
    {
      String str1;
      String str3;
      if (paramByte1 < a.length)
      {
        str1 = a[paramByte1];
        str3 = a(paramByte1, paramByte2);
        if (!paramBoolean) {
          break label91;
        }
      }
      label91:
      for (String str2 = "<<";; str2 = ">>")
      {
        return String.format("%s 0x%08x %5d %-13s %s", new Object[] { str2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str1, str3 });
        str1 = String.format("0x%02x", new Object[] { Byte.valueOf(paramByte1) });
        break;
      }
    }
  }
  
  static final class c
    implements cf
  {
    final cv.a a;
    private final eq b;
    private final cw.a c;
    private final boolean d;
    
    c(eq parameq, int paramInt, boolean paramBoolean)
    {
      this.b = parameq;
      this.d = paramBoolean;
      this.c = new cw.a(this.b);
      this.a = new cv.a(paramInt, this.c);
    }
    
    private List<ct> a(int paramInt1, short paramShort, byte paramByte, int paramInt2)
    {
      cw.a locala = this.c;
      this.c.d = paramInt1;
      locala.a = paramInt1;
      this.c.e = paramShort;
      this.c.b = paramByte;
      this.c.c = paramInt2;
      this.a.a();
      return this.a.b();
    }
    
    private void a(cf.a parama, int paramInt)
    {
      int i = this.b.j();
      if ((0x80000000 & i) != 0) {}
      for (boolean bool = true;; bool = false)
      {
        parama.a(paramInt, i & 0x7FFFFFFF, (this.b.h() & 0xFF) + 1, bool);
        return;
      }
    }
    
    private void a(cf.a parama, int paramInt1, byte paramByte, int paramInt2)
    {
      if (paramInt2 == 0) {
        throw cw.a("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
      }
      boolean bool;
      if ((paramByte & 0x1) != 0)
      {
        bool = true;
        if ((paramByte & 0x8) == 0) {
          break label108;
        }
      }
      label108:
      for (short s = (short)(this.b.h() & 0xFF);; s = 0)
      {
        int i = paramInt1;
        if ((paramByte & 0x20) != 0)
        {
          a(parama, paramInt2);
          i = paramInt1 - 5;
        }
        parama.a(false, bool, paramInt2, -1, a(cw.a(i, paramByte, s), s, paramByte, paramInt2), cu.d);
        return;
        bool = false;
        break;
      }
    }
    
    private void b(cf.a parama, int paramInt1, byte paramByte, int paramInt2)
    {
      int i = 1;
      short s = 0;
      boolean bool;
      if ((paramByte & 0x1) != 0)
      {
        bool = true;
        if ((paramByte & 0x20) == 0) {
          break label43;
        }
      }
      for (;;)
      {
        if (i == 0) {
          break label49;
        }
        throw cw.a("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        bool = false;
        break;
        label43:
        i = 0;
      }
      label49:
      if ((paramByte & 0x8) != 0) {
        s = (short)(this.b.h() & 0xFF);
      }
      paramInt1 = cw.a(paramInt1, paramByte, s);
      parama.a(bool, paramInt2, this.b, paramInt1);
      this.b.g(s);
    }
    
    private void c(cf.a parama, int paramInt1, byte paramByte, int paramInt2)
    {
      if (paramInt1 != 5) {
        throw cw.a("TYPE_PRIORITY length: %d != 5", new Object[] { Integer.valueOf(paramInt1) });
      }
      if (paramInt2 == 0) {
        throw cw.a("TYPE_PRIORITY streamId == 0", new Object[0]);
      }
      a(parama, paramInt2);
    }
    
    private void d(cf.a parama, int paramInt1, byte paramByte, int paramInt2)
    {
      if (paramInt1 != 4) {
        throw cw.a("TYPE_RST_STREAM length: %d != 4", new Object[] { Integer.valueOf(paramInt1) });
      }
      if (paramInt2 == 0) {
        throw cw.a("TYPE_RST_STREAM streamId == 0", new Object[0]);
      }
      paramInt1 = this.b.j();
      ce localce = ce.b(paramInt1);
      if (localce == null) {
        throw cw.a("TYPE_RST_STREAM unexpected error code: %d", new Object[] { Integer.valueOf(paramInt1) });
      }
      parama.a(paramInt2, localce);
    }
    
    private void e(cf.a parama, int paramInt1, byte paramByte, int paramInt2)
    {
      if (paramInt2 != 0) {
        throw cw.a("TYPE_SETTINGS streamId != 0", new Object[0]);
      }
      if ((paramByte & 0x1) != 0)
      {
        if (paramInt1 != 0) {
          throw cw.a("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
        }
        parama.a();
      }
      dg localdg;
      label255:
      do
      {
        return;
        if (paramInt1 % 6 != 0) {
          throw cw.a("TYPE_SETTINGS length %% 6 != 0: %s", new Object[] { Integer.valueOf(paramInt1) });
        }
        localdg = new dg();
        paramByte = 0;
        if (paramByte < paramInt1)
        {
          int i = this.b.i();
          int j = this.b.j();
          paramInt2 = i;
          switch (i)
          {
          default: 
            throw cw.a("PROTOCOL_ERROR invalid settings id: %s", new Object[] { Short.valueOf(i) });
          case 2: 
            paramInt2 = i;
            if (j != 0)
            {
              paramInt2 = i;
              if (j != 1) {
                throw cw.a("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
              }
            }
            break;
          case 3: 
            paramInt2 = 4;
          }
          do
          {
            do
            {
              localdg.a(paramInt2, 0, j);
              paramByte += 6;
              break;
              paramInt2 = 7;
            } while (j >= 0);
            throw cw.a("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
            if (j < 16384) {
              break label255;
            }
            paramInt2 = i;
          } while (j <= 16777215);
          throw cw.a("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", new Object[] { Integer.valueOf(j) });
        }
        parama.a(false, localdg);
      } while (localdg.c() < 0);
      this.a.a(localdg.c());
    }
    
    private void f(cf.a parama, int paramInt1, byte paramByte, int paramInt2)
    {
      short s = 0;
      if (paramInt2 == 0) {
        throw cw.a("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
      }
      if ((paramByte & 0x8) != 0) {
        s = (short)(this.b.h() & 0xFF);
      }
      parama.a(paramInt2, this.b.j() & 0x7FFFFFFF, a(cw.a(paramInt1 - 4, paramByte, s), s, paramByte, paramInt2));
    }
    
    private void g(cf.a parama, int paramInt1, byte paramByte, int paramInt2)
    {
      boolean bool = true;
      if (paramInt1 != 8) {
        throw cw.a("TYPE_PING length != 8: %s", new Object[] { Integer.valueOf(paramInt1) });
      }
      if (paramInt2 != 0) {
        throw cw.a("TYPE_PING streamId != 0", new Object[0]);
      }
      paramInt1 = this.b.j();
      paramInt2 = this.b.j();
      if ((paramByte & 0x1) != 0) {}
      for (;;)
      {
        parama.a(bool, paramInt1, paramInt2);
        return;
        bool = false;
      }
    }
    
    private void h(cf.a parama, int paramInt1, byte paramByte, int paramInt2)
    {
      if (paramInt1 < 8) {
        throw cw.a("TYPE_GOAWAY length < 8: %s", new Object[] { Integer.valueOf(paramInt1) });
      }
      if (paramInt2 != 0) {
        throw cw.a("TYPE_GOAWAY streamId != 0", new Object[0]);
      }
      paramByte = this.b.j();
      paramInt2 = this.b.j();
      paramInt1 -= 8;
      ce localce = ce.b(paramInt2);
      if (localce == null) {
        throw cw.a("TYPE_GOAWAY unexpected error code: %d", new Object[] { Integer.valueOf(paramInt2) });
      }
      er localer = er.b;
      if (paramInt1 > 0) {
        localer = this.b.c(paramInt1);
      }
      parama.a(paramByte, localce, localer);
    }
    
    private void i(cf.a parama, int paramInt1, byte paramByte, int paramInt2)
    {
      if (paramInt1 != 4) {
        throw cw.a("TYPE_WINDOW_UPDATE length !=4: %s", new Object[] { Integer.valueOf(paramInt1) });
      }
      long l = this.b.j() & 0x7FFFFFFF;
      if (l == 0L) {
        throw cw.a("windowSizeIncrement was 0", new Object[] { Long.valueOf(l) });
      }
      parama.a(paramInt2, l);
    }
    
    public void a()
    {
      if (this.d) {}
      er localer;
      do
      {
        return;
        localer = this.b.c(cw.a().f());
        if (cw.b().isLoggable(Level.FINE)) {
          cw.b().fine(String.format("<< CONNECTION %s", new Object[] { localer.d() }));
        }
      } while (cw.a().equals(localer));
      throw cw.a("Expected a connection header but was %s", new Object[] { localer.a() });
    }
    
    public boolean a(cf.a parama)
    {
      int i;
      try
      {
        this.b.a(9L);
        i = cw.a(this.b);
        if ((i < 0) || (i > 16384)) {
          throw cw.a("FRAME_SIZE_ERROR: %s", new Object[] { Integer.valueOf(i) });
        }
      }
      catch (IOException parama)
      {
        return false;
      }
      byte b1 = (byte)(this.b.h() & 0xFF);
      byte b2 = (byte)(this.b.h() & 0xFF);
      int j = this.b.j() & 0x7FFFFFFF;
      if (cw.b().isLoggable(Level.FINE)) {
        cw.b().fine(cw.b.a(true, j, i, b1, b2));
      }
      switch (b1)
      {
      default: 
        this.b.g(i);
        return true;
      case 0: 
        b(parama, i, b2, j);
        return true;
      case 1: 
        a(parama, i, b2, j);
        return true;
      case 2: 
        c(parama, i, b2, j);
        return true;
      case 3: 
        d(parama, i, b2, j);
        return true;
      case 4: 
        e(parama, i, b2, j);
        return true;
      case 5: 
        f(parama, i, b2, j);
        return true;
      case 6: 
        g(parama, i, b2, j);
        return true;
      case 7: 
        h(parama, i, b2, j);
        return true;
      }
      i(parama, i, b2, j);
      return true;
    }
    
    public void close()
    {
      this.b.close();
    }
  }
  
  static final class d
    implements cg
  {
    private final ep a;
    private final boolean b;
    private final eo c;
    private final cv.b d;
    private int e;
    private boolean f;
    
    d(ep paramep, boolean paramBoolean)
    {
      this.a = paramep;
      this.b = paramBoolean;
      this.c = new eo();
      this.d = new cv.b(this.c);
      this.e = 16384;
    }
    
    private void b(int paramInt, long paramLong)
    {
      if (paramLong > 0L)
      {
        int i = (int)Math.min(this.e, paramLong);
        paramLong -= i;
        if (paramLong == 0L) {}
        for (byte b1 = 4;; b1 = 0)
        {
          a(paramInt, i, (byte)9, b1);
          this.a.a_(this.c, i);
          break;
        }
      }
    }
    
    public void a()
    {
      try
      {
        if (this.f) {
          throw new IOException("closed");
        }
      }
      finally {}
      boolean bool = this.b;
      if (!bool) {}
      for (;;)
      {
        return;
        if (cw.b().isLoggable(Level.FINE)) {
          cw.b().fine(String.format(">> CONNECTION %s", new Object[] { cw.a().d() }));
        }
        this.a.c(cw.a().g());
        this.a.flush();
      }
    }
    
    void a(int paramInt1, byte paramByte, eo parameo, int paramInt2)
    {
      a(paramInt1, paramInt2, (byte)0, paramByte);
      if (paramInt2 > 0) {
        this.a.a_(parameo, paramInt2);
      }
    }
    
    void a(int paramInt1, int paramInt2, byte paramByte1, byte paramByte2)
    {
      if (cw.b().isLoggable(Level.FINE)) {
        cw.b().fine(cw.b.a(false, paramInt1, paramInt2, paramByte1, paramByte2));
      }
      if (paramInt2 > this.e) {
        throw cw.b("FRAME_SIZE_ERROR length > %d: %d", new Object[] { Integer.valueOf(this.e), Integer.valueOf(paramInt2) });
      }
      if ((0x80000000 & paramInt1) != 0) {
        throw cw.b("reserved bit set: %s", new Object[] { Integer.valueOf(paramInt1) });
      }
      cw.a(this.a, paramInt2);
      this.a.h(paramByte1 & 0xFF);
      this.a.h(paramByte2 & 0xFF);
      this.a.f(0x7FFFFFFF & paramInt1);
    }
    
    public void a(int paramInt1, int paramInt2, List<ct> paramList)
    {
      try
      {
        if (this.f) {
          throw new IOException("closed");
        }
      }
      finally {}
      this.d.a(paramList);
      long l = this.c.b();
      int i = (int)Math.min(this.e - 4, l);
      if (l == i) {}
      for (byte b1 = 4;; b1 = 0)
      {
        a(paramInt1, i + 4, (byte)5, b1);
        this.a.f(0x7FFFFFFF & paramInt2);
        this.a.a_(this.c, i);
        if (l > i) {
          b(paramInt1, l - i);
        }
        return;
      }
    }
    
    public void a(int paramInt, long paramLong)
    {
      try
      {
        if (this.f) {
          throw new IOException("closed");
        }
      }
      finally {}
      if ((paramLong == 0L) || (paramLong > 2147483647L)) {
        throw cw.b("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", new Object[] { Long.valueOf(paramLong) });
      }
      a(paramInt, 4, (byte)8, (byte)0);
      this.a.f((int)paramLong);
      this.a.flush();
    }
    
    public void a(int paramInt, ce paramce)
    {
      try
      {
        if (this.f) {
          throw new IOException("closed");
        }
      }
      finally {}
      if (paramce.s == -1) {
        throw new IllegalArgumentException();
      }
      a(paramInt, 4, (byte)3, (byte)0);
      this.a.f(paramce.s);
      this.a.flush();
    }
    
    public void a(int paramInt, ce paramce, byte[] paramArrayOfByte)
    {
      try
      {
        if (this.f) {
          throw new IOException("closed");
        }
      }
      finally {}
      if (paramce.s == -1) {
        throw cw.b("errorCode.httpCode == -1", new Object[0]);
      }
      a(0, paramArrayOfByte.length + 8, (byte)7, (byte)0);
      this.a.f(paramInt);
      this.a.f(paramce.s);
      if (paramArrayOfByte.length > 0) {
        this.a.c(paramArrayOfByte);
      }
      this.a.flush();
    }
    
    public void a(dg paramdg)
    {
      try
      {
        if (this.f) {
          throw new IOException("closed");
        }
      }
      finally {}
      this.e = paramdg.d(this.e);
      a(0, 0, (byte)4, (byte)1);
      this.a.flush();
    }
    
    public void a(boolean paramBoolean, int paramInt1, int paramInt2)
    {
      byte b1 = 0;
      try
      {
        if (this.f) {
          throw new IOException("closed");
        }
      }
      finally {}
      if (paramBoolean) {
        b1 = 1;
      }
      a(0, 8, (byte)6, b1);
      this.a.f(paramInt1);
      this.a.f(paramInt2);
      this.a.flush();
    }
    
    public void a(boolean paramBoolean, int paramInt1, eo parameo, int paramInt2)
    {
      try
      {
        if (this.f) {
          throw new IOException("closed");
        }
      }
      finally {}
      byte b1 = 0;
      if (paramBoolean) {
        b1 = (byte)1;
      }
      a(paramInt1, b1, parameo, paramInt2);
    }
    
    void a(boolean paramBoolean, int paramInt, List<ct> paramList)
    {
      if (this.f) {
        throw new IOException("closed");
      }
      this.d.a(paramList);
      long l = this.c.b();
      int i = (int)Math.min(this.e, l);
      if (l == i) {}
      for (byte b1 = 4;; b1 = 0)
      {
        byte b2 = b1;
        if (paramBoolean) {
          b2 = (byte)(b1 | 0x1);
        }
        a(paramInt, i, (byte)1, b2);
        this.a.a_(this.c, i);
        if (l > i) {
          b(paramInt, l - i);
        }
        return;
      }
    }
    
    public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, List<ct> paramList)
    {
      if (paramBoolean2) {
        try
        {
          throw new UnsupportedOperationException();
        }
        finally {}
      }
      if (this.f) {
        throw new IOException("closed");
      }
      a(paramBoolean1, paramInt1, paramList);
    }
    
    public void b()
    {
      try
      {
        if (this.f) {
          throw new IOException("closed");
        }
      }
      finally {}
      this.a.flush();
    }
    
    public void b(dg paramdg)
    {
      int i = 0;
      try
      {
        if (this.f) {
          throw new IOException("closed");
        }
      }
      finally {}
      a(0, paramdg.b() * 6, (byte)4, (byte)0);
      if (i < 10) {
        if (paramdg.a(i)) {
          break label110;
        }
      }
      for (;;)
      {
        label57:
        this.a.g(j);
        this.a.f(paramdg.b(i));
        break label103;
        this.a.flush();
        return;
        label103:
        label110:
        do
        {
          j = i;
          break label57;
          i += 1;
          break;
          if (i == 4)
          {
            j = 3;
            break label57;
          }
        } while (i != 7);
        int j = 4;
      }
    }
    
    public int c()
    {
      return this.e;
    }
    
    public void close()
    {
      try
      {
        this.f = true;
        this.a.close();
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\cw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */