package com.ta.utdid2.b.a;

import java.io.UnsupportedEncodingException;

public class b
{
  static
  {
    if (!b.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public static byte[] decode(String paramString, int paramInt)
  {
    return decode(paramString.getBytes(), paramInt);
  }
  
  public static byte[] decode(byte[] paramArrayOfByte, int paramInt)
  {
    return decode(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt);
  }
  
  public static byte[] decode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    b localb = new b(paramInt3, new byte[paramInt2 * 3 / 4]);
    if (!localb.a(paramArrayOfByte, paramInt1, paramInt2, true)) {
      throw new IllegalArgumentException("bad base-64");
    }
    if (localb.jdField_a_of_type_Int == localb.jdField_a_of_type_ArrayOfByte.length) {
      return localb.jdField_a_of_type_ArrayOfByte;
    }
    paramArrayOfByte = new byte[localb.jdField_a_of_type_Int];
    System.arraycopy(localb.jdField_a_of_type_ArrayOfByte, 0, paramArrayOfByte, 0, localb.jdField_a_of_type_Int);
    return paramArrayOfByte;
  }
  
  public static byte[] encode(byte[] paramArrayOfByte, int paramInt)
  {
    return encode(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt);
  }
  
  public static byte[] encode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    c localc = new c(paramInt3, null);
    int i = paramInt2 / 3 * 4;
    int j;
    if (localc.b)
    {
      paramInt3 = i;
      if (paramInt2 % 3 > 0) {
        paramInt3 = i + 4;
      }
      i = paramInt3;
      if (localc.c)
      {
        i = paramInt3;
        if (paramInt2 > 0)
        {
          j = (paramInt2 - 1) / 57;
          if (!localc.d) {
            break label186;
          }
        }
      }
    }
    label186:
    for (i = 2;; i = 1)
    {
      i = paramInt3 + i * (j + 1);
      localc.jdField_a_of_type_ArrayOfByte = new byte[i];
      localc.a(paramArrayOfByte, paramInt1, paramInt2, true);
      if ((a) || (localc.jdField_a_of_type_Int == i)) {
        break label192;
      }
      throw new AssertionError();
      paramInt3 = i;
      switch (paramInt2 % 3)
      {
      case 0: 
      default: 
        paramInt3 = i;
        break;
      case 1: 
        paramInt3 = i + 2;
        break;
      case 2: 
        paramInt3 = i + 3;
        break;
      }
    }
    label192:
    return localc.jdField_a_of_type_ArrayOfByte;
  }
  
  public static String encodeToString(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      paramArrayOfByte = new String(encode(paramArrayOfByte, paramInt), "US-ASCII");
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      throw new AssertionError(paramArrayOfByte);
    }
  }
  
  static abstract class a
  {
    public int a;
    public byte[] a;
  }
  
  static class b
    extends b.a
  {
    private static final int[] a;
    private static final int[] b = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
    private final int[] c;
    private int state;
    private int value;
    
    static
    {
      jdField_a_of_type_ArrayOfInt = new int[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
    }
    
    public b(int paramInt, byte[] paramArrayOfByte)
    {
      this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      if ((paramInt & 0x8) == 0) {}
      for (paramArrayOfByte = jdField_a_of_type_ArrayOfInt;; paramArrayOfByte = b)
      {
        this.c = paramArrayOfByte;
        this.state = 0;
        this.value = 0;
        return;
      }
    }
    
    public boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      if (this.state == 6) {
        return false;
      }
      int i2 = paramInt2 + paramInt1;
      int j = this.state;
      paramInt2 = this.value;
      int i = 0;
      byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      int[] arrayOfInt = this.c;
      int k;
      int m;
      int i1;
      if (paramInt1 < i2)
      {
        k = i;
        m = paramInt2;
        i1 = paramInt1;
        if (j == 0)
        {
          int n = paramInt1;
          for (paramInt1 = paramInt2; n + 4 <= i2; paramInt1 = paramInt2)
          {
            paramInt2 = arrayOfInt[(paramArrayOfByte[n] & 0xFF)] << 18 | arrayOfInt[(paramArrayOfByte[(n + 1)] & 0xFF)] << 12 | arrayOfInt[(paramArrayOfByte[(n + 2)] & 0xFF)] << 6 | arrayOfInt[(paramArrayOfByte[(n + 3)] & 0xFF)];
            paramInt1 = paramInt2;
            if (paramInt2 < 0) {
              break;
            }
            arrayOfByte[(i + 2)] = ((byte)paramInt2);
            arrayOfByte[(i + 1)] = ((byte)(paramInt2 >> 8));
            arrayOfByte[i] = ((byte)(paramInt2 >> 16));
            i += 3;
            n += 4;
          }
          k = i;
          m = paramInt1;
          i1 = n;
          if (n >= i2) {
            paramInt2 = paramInt1;
          }
        }
      }
      for (;;)
      {
        if (!paramBoolean)
        {
          this.state = j;
          this.value = paramInt2;
          this.jdField_a_of_type_Int = i;
          return true;
          paramInt2 = arrayOfInt[(paramArrayOfByte[i1] & 0xFF)];
          switch (j)
          {
          }
          label292:
          label577:
          do
          {
            do
            {
              paramInt1 = j;
              paramInt2 = m;
              i = k;
              for (;;)
              {
                j = paramInt1;
                paramInt1 = i1 + 1;
                break;
                if (paramInt2 >= 0)
                {
                  paramInt1 = j + 1;
                  i = k;
                }
                else
                {
                  if (paramInt2 == -1) {
                    break label292;
                  }
                  this.state = 6;
                  return false;
                  if (paramInt2 >= 0)
                  {
                    paramInt2 = m << 6 | paramInt2;
                    paramInt1 = j + 1;
                    i = k;
                  }
                  else
                  {
                    if (paramInt2 == -1) {
                      break label292;
                    }
                    this.state = 6;
                    return false;
                    if (paramInt2 >= 0)
                    {
                      paramInt2 = m << 6 | paramInt2;
                      paramInt1 = j + 1;
                      i = k;
                    }
                    else if (paramInt2 == -2)
                    {
                      arrayOfByte[k] = ((byte)(m >> 4));
                      paramInt1 = 4;
                      i = k + 1;
                      paramInt2 = m;
                    }
                    else
                    {
                      if (paramInt2 == -1) {
                        break label292;
                      }
                      this.state = 6;
                      return false;
                      if (paramInt2 >= 0)
                      {
                        paramInt2 = m << 6 | paramInt2;
                        arrayOfByte[(k + 2)] = ((byte)paramInt2);
                        arrayOfByte[(k + 1)] = ((byte)(paramInt2 >> 8));
                        arrayOfByte[k] = ((byte)(paramInt2 >> 16));
                        i = k + 3;
                        paramInt1 = 0;
                      }
                      else if (paramInt2 == -2)
                      {
                        arrayOfByte[(k + 1)] = ((byte)(m >> 2));
                        arrayOfByte[k] = ((byte)(m >> 10));
                        i = k + 2;
                        paramInt1 = 5;
                        paramInt2 = m;
                      }
                      else
                      {
                        if (paramInt2 == -1) {
                          break label292;
                        }
                        this.state = 6;
                        return false;
                        if (paramInt2 != -2) {
                          break label577;
                        }
                        paramInt1 = j + 1;
                        i = k;
                        paramInt2 = m;
                      }
                    }
                  }
                }
              }
            } while (paramInt2 == -1);
            this.state = 6;
            return false;
          } while (paramInt2 == -1);
          this.state = 6;
          return false;
        }
        paramInt1 = i;
        switch (j)
        {
        default: 
          paramInt1 = i;
        case 0: 
        case 1: 
        case 2: 
        case 3: 
          for (;;)
          {
            this.state = j;
            this.jdField_a_of_type_Int = paramInt1;
            return true;
            this.state = 6;
            return false;
            arrayOfByte[i] = ((byte)(paramInt2 >> 4));
            paramInt1 = i + 1;
            continue;
            k = i + 1;
            arrayOfByte[i] = ((byte)(paramInt2 >> 10));
            paramInt1 = k + 1;
            arrayOfByte[k] = ((byte)(paramInt2 >> 2));
          }
        }
        this.state = 6;
        return false;
      }
    }
  }
  
  static class c
    extends b.a
  {
    private static final byte[] jdField_b_of_type_ArrayOfByte;
    private static final byte[] c;
    int jdField_b_of_type_Int;
    public final boolean b;
    public final boolean c;
    private int count;
    public final boolean d;
    private final byte[] d;
    private final byte[] e;
    
    static
    {
      if (!b.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        jdField_a_of_type_Boolean = bool;
        jdField_b_of_type_ArrayOfByte = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
        jdField_c_of_type_ArrayOfByte = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
        return;
      }
    }
    
    public c(int paramInt, byte[] paramArrayOfByte)
    {
      this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      boolean bool1;
      if ((paramInt & 0x1) == 0)
      {
        bool1 = true;
        this.jdField_b_of_type_Boolean = bool1;
        if ((paramInt & 0x2) != 0) {
          break label101;
        }
        bool1 = true;
        label33:
        this.jdField_c_of_type_Boolean = bool1;
        if ((paramInt & 0x4) == 0) {
          break label106;
        }
        bool1 = bool2;
        label47:
        this.jdField_d_of_type_Boolean = bool1;
        if ((paramInt & 0x8) != 0) {
          break label111;
        }
        paramArrayOfByte = jdField_b_of_type_ArrayOfByte;
        label63:
        this.e = paramArrayOfByte;
        this.jdField_d_of_type_ArrayOfByte = new byte[2];
        this.jdField_b_of_type_Int = 0;
        if (!this.jdField_c_of_type_Boolean) {
          break label118;
        }
      }
      label101:
      label106:
      label111:
      label118:
      for (paramInt = 19;; paramInt = -1)
      {
        this.count = paramInt;
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label33;
        bool1 = false;
        break label47;
        paramArrayOfByte = jdField_c_of_type_ArrayOfByte;
        break label63;
      }
    }
    
    public boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      byte[] arrayOfByte1 = this.e;
      byte[] arrayOfByte2 = this.jdField_a_of_type_ArrayOfByte;
      int i = 0;
      int m = this.count;
      int i1 = paramInt2 + paramInt1;
      int k = -1;
      label62:
      int j;
      switch (this.jdField_b_of_type_Int)
      {
      default: 
        paramInt2 = paramInt1;
        paramInt1 = m;
        j = paramInt2;
        if (k != -1)
        {
          arrayOfByte2[0] = arrayOfByte1[(k >> 18 & 0x3F)];
          arrayOfByte2[1] = arrayOfByte1[(k >> 12 & 0x3F)];
          arrayOfByte2[2] = arrayOfByte1[(k >> 6 & 0x3F)];
          i = 4;
          arrayOfByte2[3] = arrayOfByte1[(k & 0x3F)];
          k = m - 1;
          paramInt1 = k;
          j = paramInt2;
          if (k == 0)
          {
            if (!this.jdField_d_of_type_Boolean) {
              break label1226;
            }
            paramInt1 = 5;
            arrayOfByte2[4] = 13;
          }
        }
        break;
      }
      for (;;)
      {
        arrayOfByte2[paramInt1] = 10;
        j = 19;
        paramInt1 += 1;
        for (;;)
        {
          label180:
          if (paramInt2 + 3 <= i1)
          {
            i = (paramArrayOfByte[paramInt2] & 0xFF) << 16 | (paramArrayOfByte[(paramInt2 + 1)] & 0xFF) << 8 | paramArrayOfByte[(paramInt2 + 2)] & 0xFF;
            arrayOfByte2[paramInt1] = arrayOfByte1[(i >> 18 & 0x3F)];
            arrayOfByte2[(paramInt1 + 1)] = arrayOfByte1[(i >> 12 & 0x3F)];
            arrayOfByte2[(paramInt1 + 2)] = arrayOfByte1[(i >> 6 & 0x3F)];
            arrayOfByte2[(paramInt1 + 3)] = arrayOfByte1[(i & 0x3F)];
            paramInt2 += 3;
            k = paramInt1 + 4;
            m = j - 1;
            paramInt1 = m;
            i = k;
            j = paramInt2;
            if (m != 0) {
              break label1210;
            }
            if (!this.jdField_d_of_type_Boolean) {
              break label1204;
            }
            paramInt1 = k + 1;
            arrayOfByte2[k] = 13;
          }
          for (;;)
          {
            arrayOfByte2[paramInt1] = 10;
            j = 19;
            paramInt1 += 1;
            break label180;
            paramInt2 = paramInt1;
            break label62;
            if (paramInt1 + 2 > i1) {
              break;
            }
            j = this.jdField_d_of_type_ArrayOfByte[0];
            paramInt2 = paramInt1 + 1;
            k = (j & 0xFF) << 16 | (paramArrayOfByte[paramInt1] & 0xFF) << 8 | paramArrayOfByte[paramInt2] & 0xFF;
            this.jdField_b_of_type_Int = 0;
            paramInt2 += 1;
            break label62;
            if (paramInt1 + 1 > i1) {
              break;
            }
            j = this.jdField_d_of_type_ArrayOfByte[0];
            k = this.jdField_d_of_type_ArrayOfByte[1];
            paramInt2 = paramInt1 + 1;
            k = (j & 0xFF) << 16 | (k & 0xFF) << 8 | paramArrayOfByte[paramInt1] & 0xFF;
            this.jdField_b_of_type_Int = 0;
            break label62;
            label742:
            int n;
            if (paramBoolean)
            {
              if (paramInt2 - this.jdField_b_of_type_Int == i1 - 1)
              {
                if (this.jdField_b_of_type_Int > 0)
                {
                  paramArrayOfByte = this.jdField_d_of_type_ArrayOfByte;
                  i = 1;
                  k = paramArrayOfByte[0];
                }
                for (;;)
                {
                  k = (k & 0xFF) << 4;
                  this.jdField_b_of_type_Int -= i;
                  m = paramInt1 + 1;
                  arrayOfByte2[paramInt1] = arrayOfByte1[(k >> 6 & 0x3F)];
                  i = m + 1;
                  arrayOfByte2[m] = arrayOfByte1[(k & 0x3F)];
                  paramInt1 = i;
                  if (this.jdField_b_of_type_Boolean)
                  {
                    k = i + 1;
                    arrayOfByte2[i] = 61;
                    paramInt1 = k + 1;
                    arrayOfByte2[k] = 61;
                  }
                  i = paramInt1;
                  if (this.jdField_c_of_type_Boolean)
                  {
                    i = paramInt1;
                    if (this.jdField_d_of_type_Boolean)
                    {
                      arrayOfByte2[paramInt1] = 13;
                      i = paramInt1 + 1;
                    }
                    arrayOfByte2[i] = 10;
                    i += 1;
                  }
                  k = paramInt2;
                  if ((jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Int == 0)) {
                    break;
                  }
                  throw new AssertionError();
                  k = paramArrayOfByte[paramInt2];
                  paramInt2 += 1;
                  i = 0;
                }
              }
              if (paramInt2 - this.jdField_b_of_type_Int == i1 - 2) {
                if (this.jdField_b_of_type_Int > 1)
                {
                  byte[] arrayOfByte3 = this.jdField_d_of_type_ArrayOfByte;
                  m = 1;
                  k = arrayOfByte3[0];
                  i = paramInt2;
                  paramInt2 = m;
                  if (this.jdField_b_of_type_Int <= 0) {
                    break label946;
                  }
                  m = this.jdField_d_of_type_ArrayOfByte[paramInt2];
                  n = paramInt2 + 1;
                  paramInt2 = i;
                  i = n;
                  label769:
                  k = (m & 0xFF) << 2 | (k & 0xFF) << 10;
                  this.jdField_b_of_type_Int -= i;
                  i = paramInt1 + 1;
                  arrayOfByte2[paramInt1] = arrayOfByte1[(k >> 12 & 0x3F)];
                  m = i + 1;
                  arrayOfByte2[i] = arrayOfByte1[(k >> 6 & 0x3F)];
                  paramInt1 = m + 1;
                  arrayOfByte2[m] = arrayOfByte1[(k & 0x3F)];
                  if (!this.jdField_b_of_type_Boolean) {
                    break label1201;
                  }
                  i = paramInt1 + 1;
                  arrayOfByte2[paramInt1] = 61;
                  paramInt1 = i;
                }
              }
            }
            label946:
            label1123:
            label1201:
            for (;;)
            {
              i = paramInt1;
              if (this.jdField_c_of_type_Boolean)
              {
                i = paramInt1;
                if (this.jdField_d_of_type_Boolean)
                {
                  arrayOfByte2[paramInt1] = 13;
                  i = paramInt1 + 1;
                }
                arrayOfByte2[i] = 10;
                i += 1;
              }
              k = paramInt2;
              break;
              k = paramArrayOfByte[paramInt2];
              i = paramInt2 + 1;
              paramInt2 = 0;
              break label742;
              m = paramArrayOfByte[i];
              n = i + 1;
              i = paramInt2;
              paramInt2 = n;
              break label769;
              k = paramInt2;
              i = paramInt1;
              if (!this.jdField_c_of_type_Boolean) {
                break;
              }
              k = paramInt2;
              i = paramInt1;
              if (paramInt1 <= 0) {
                break;
              }
              k = paramInt2;
              i = paramInt1;
              if (j == 19) {
                break;
              }
              if (this.jdField_d_of_type_Boolean)
              {
                i = paramInt1 + 1;
                arrayOfByte2[paramInt1] = 13;
                paramInt1 = i;
              }
              for (;;)
              {
                i = paramInt1 + 1;
                arrayOfByte2[paramInt1] = 10;
                k = paramInt2;
                break;
                m = i;
                if (!jdField_a_of_type_Boolean)
                {
                  m = i;
                  if (k != i1)
                  {
                    throw new AssertionError();
                    if (paramInt2 != i1 - 1) {
                      break label1123;
                    }
                    arrayOfByte1 = this.jdField_d_of_type_ArrayOfByte;
                    i = this.jdField_b_of_type_Int;
                    this.jdField_b_of_type_Int = (i + 1);
                    arrayOfByte1[i] = paramArrayOfByte[paramInt2];
                    m = paramInt1;
                  }
                }
                for (;;)
                {
                  this.jdField_a_of_type_Int = m;
                  this.count = j;
                  return true;
                  m = paramInt1;
                  if (paramInt2 == i1 - 2)
                  {
                    arrayOfByte1 = this.jdField_d_of_type_ArrayOfByte;
                    i = this.jdField_b_of_type_Int;
                    this.jdField_b_of_type_Int = (i + 1);
                    arrayOfByte1[i] = paramArrayOfByte[paramInt2];
                    arrayOfByte1 = this.jdField_d_of_type_ArrayOfByte;
                    i = this.jdField_b_of_type_Int;
                    this.jdField_b_of_type_Int = (i + 1);
                    arrayOfByte1[i] = paramArrayOfByte[(paramInt2 + 1)];
                    m = paramInt1;
                  }
                }
              }
            }
            label1204:
            paramInt1 = k;
          }
          label1210:
          k = paramInt1;
          paramInt1 = i;
          paramInt2 = j;
          j = k;
        }
        label1226:
        paramInt1 = 4;
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\ta\utdid2\b\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */