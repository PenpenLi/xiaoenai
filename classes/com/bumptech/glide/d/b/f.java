package com.bumptech.glide.d.b;

import com.bumptech.glide.d.b;
import com.bumptech.glide.d.e;
import com.bumptech.glide.d.g;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

class f
  implements com.bumptech.glide.d.c
{
  private final String a;
  private final int b;
  private final int c;
  private final e d;
  private final e e;
  private final g f;
  private final com.bumptech.glide.d.f g;
  private final com.bumptech.glide.d.d.f.c h;
  private final b i;
  private final com.bumptech.glide.d.c j;
  private String k;
  private int l;
  private com.bumptech.glide.d.c m;
  
  public f(String paramString, com.bumptech.glide.d.c paramc, int paramInt1, int paramInt2, e parame1, e parame2, g paramg, com.bumptech.glide.d.f paramf, com.bumptech.glide.d.d.f.c paramc1, b paramb)
  {
    this.a = paramString;
    this.j = paramc;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = parame1;
    this.e = parame2;
    this.f = paramg;
    this.g = paramf;
    this.h = paramc1;
    this.i = paramb;
  }
  
  public com.bumptech.glide.d.c a()
  {
    if (this.m == null) {
      this.m = new j(this.a, this.j);
    }
    return this.m;
  }
  
  public void a(MessageDigest paramMessageDigest)
  {
    Object localObject = ByteBuffer.allocate(8).putInt(this.b).putInt(this.c).array();
    this.j.a(paramMessageDigest);
    paramMessageDigest.update(this.a.getBytes("UTF-8"));
    paramMessageDigest.update((byte[])localObject);
    if (this.d != null)
    {
      localObject = this.d.a();
      paramMessageDigest.update(((String)localObject).getBytes("UTF-8"));
      if (this.e == null) {
        break label193;
      }
      localObject = this.e.a();
      label95:
      paramMessageDigest.update(((String)localObject).getBytes("UTF-8"));
      if (this.f == null) {
        break label199;
      }
      localObject = this.f.a();
      label122:
      paramMessageDigest.update(((String)localObject).getBytes("UTF-8"));
      if (this.g == null) {
        break label205;
      }
      localObject = this.g.a();
      label149:
      paramMessageDigest.update(((String)localObject).getBytes("UTF-8"));
      if (this.i == null) {
        break label211;
      }
    }
    label193:
    label199:
    label205:
    label211:
    for (localObject = this.i.a();; localObject = "")
    {
      paramMessageDigest.update(((String)localObject).getBytes("UTF-8"));
      return;
      localObject = "";
      break;
      localObject = "";
      break label95;
      localObject = "";
      break label122;
      localObject = "";
      break label149;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    int n;
    label117:
    label126:
    label180:
    label189:
    label243:
    label252:
    label306:
    label315:
    label369:
    label378:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  do
                                  {
                                    return bool1;
                                    bool1 = bool2;
                                  } while (paramObject == null);
                                  bool1 = bool2;
                                } while (getClass() != paramObject.getClass());
                                paramObject = (f)paramObject;
                                bool1 = bool2;
                              } while (!this.a.equals(((f)paramObject).a));
                              bool1 = bool2;
                            } while (!this.j.equals(((f)paramObject).j));
                            bool1 = bool2;
                          } while (this.c != ((f)paramObject).c);
                          bool1 = bool2;
                        } while (this.b != ((f)paramObject).b);
                        if (this.f != null) {
                          break;
                        }
                        n = 1;
                        if (((f)paramObject).f != null) {
                          break label493;
                        }
                        i1 = 1;
                        bool1 = bool2;
                      } while ((n ^ i1) != 0);
                      if (this.f == null) {
                        break;
                      }
                      bool1 = bool2;
                    } while (!this.f.a().equals(((f)paramObject).f.a()));
                    if (this.e != null) {
                      break label498;
                    }
                    n = 1;
                    if (((f)paramObject).e != null) {
                      break label503;
                    }
                    i1 = 1;
                    bool1 = bool2;
                  } while ((n ^ i1) != 0);
                  if (this.e == null) {
                    break;
                  }
                  bool1 = bool2;
                } while (!this.e.a().equals(((f)paramObject).e.a()));
                if (this.d != null) {
                  break label508;
                }
                n = 1;
                if (((f)paramObject).d != null) {
                  break label513;
                }
                i1 = 1;
                bool1 = bool2;
              } while ((n ^ i1) != 0);
              if (this.d == null) {
                break;
              }
              bool1 = bool2;
            } while (!this.d.a().equals(((f)paramObject).d.a()));
            if (this.g != null) {
              break label518;
            }
            n = 1;
            if (((f)paramObject).g != null) {
              break label523;
            }
            i1 = 1;
            bool1 = bool2;
          } while ((n ^ i1) != 0);
          if (this.g == null) {
            break;
          }
          bool1 = bool2;
        } while (!this.g.a().equals(((f)paramObject).g.a()));
        if (this.h != null) {
          break label528;
        }
        n = 1;
        if (((f)paramObject).h != null) {
          break label533;
        }
        i1 = 1;
        bool1 = bool2;
      } while ((n ^ i1) != 0);
      if (this.h == null) {
        break;
      }
      bool1 = bool2;
    } while (!this.h.a().equals(((f)paramObject).h.a()));
    if (this.i == null)
    {
      n = 1;
      label432:
      if (((f)paramObject).i != null) {
        break label543;
      }
    }
    label493:
    label498:
    label503:
    label508:
    label513:
    label518:
    label523:
    label528:
    label533:
    label543:
    for (int i1 = 1;; i1 = 0)
    {
      bool1 = bool2;
      if ((n ^ i1) != 0) {
        break;
      }
      if (this.i != null)
      {
        bool1 = bool2;
        if (!this.i.a().equals(((f)paramObject).i.a())) {
          break;
        }
      }
      return true;
      n = 0;
      break label117;
      i1 = 0;
      break label126;
      n = 0;
      break label180;
      i1 = 0;
      break label189;
      n = 0;
      break label243;
      i1 = 0;
      break label252;
      n = 0;
      break label306;
      i1 = 0;
      break label315;
      n = 0;
      break label369;
      i1 = 0;
      break label378;
      n = 0;
      break label432;
    }
  }
  
  public int hashCode()
  {
    int i1 = 0;
    int i2;
    if (this.l == 0)
    {
      this.l = this.a.hashCode();
      this.l = (this.l * 31 + this.j.hashCode());
      this.l = (this.l * 31 + this.b);
      this.l = (this.l * 31 + this.c);
      i2 = this.l;
      if (this.d == null) {
        break label288;
      }
      n = this.d.a().hashCode();
      this.l = (n + i2 * 31);
      i2 = this.l;
      if (this.e == null) {
        break label293;
      }
      n = this.e.a().hashCode();
      label131:
      this.l = (n + i2 * 31);
      i2 = this.l;
      if (this.f == null) {
        break label298;
      }
      n = this.f.a().hashCode();
      label166:
      this.l = (n + i2 * 31);
      i2 = this.l;
      if (this.g == null) {
        break label303;
      }
      n = this.g.a().hashCode();
      label201:
      this.l = (n + i2 * 31);
      i2 = this.l;
      if (this.h == null) {
        break label308;
      }
    }
    label288:
    label293:
    label298:
    label303:
    label308:
    for (int n = this.h.a().hashCode();; n = 0)
    {
      this.l = (n + i2 * 31);
      i2 = this.l;
      n = i1;
      if (this.i != null) {
        n = this.i.a().hashCode();
      }
      this.l = (i2 * 31 + n);
      return this.l;
      n = 0;
      break;
      n = 0;
      break label131;
      n = 0;
      break label166;
      n = 0;
      break label201;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder;
    if (this.k == null)
    {
      localStringBuilder = new StringBuilder().append("EngineKey{").append(this.a).append('+').append(this.j).append("+[").append(this.b).append('x').append(this.c).append("]+").append('\'');
      if (this.d == null) {
        break label307;
      }
      str = this.d.a();
      localStringBuilder = localStringBuilder.append(str).append('\'').append('+').append('\'');
      if (this.e == null) {
        break label313;
      }
      str = this.e.a();
      label128:
      localStringBuilder = localStringBuilder.append(str).append('\'').append('+').append('\'');
      if (this.f == null) {
        break label319;
      }
      str = this.f.a();
      label166:
      localStringBuilder = localStringBuilder.append(str).append('\'').append('+').append('\'');
      if (this.g == null) {
        break label325;
      }
      str = this.g.a();
      label204:
      localStringBuilder = localStringBuilder.append(str).append('\'').append('+').append('\'');
      if (this.h == null) {
        break label331;
      }
      str = this.h.a();
      label242:
      localStringBuilder = localStringBuilder.append(str).append('\'').append('+').append('\'');
      if (this.i == null) {
        break label337;
      }
    }
    label307:
    label313:
    label319:
    label325:
    label331:
    label337:
    for (String str = this.i.a();; str = "")
    {
      this.k = (str + '\'' + '}');
      return this.k;
      str = "";
      break;
      str = "";
      break label128;
      str = "";
      break label166;
      str = "";
      break label204;
      str = "";
      break label242;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\b\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */