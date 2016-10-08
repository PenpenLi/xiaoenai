package com.baidu.location;

import java.util.List;

class at
  implements ax
{
  public static String kt = null;
  private int kA = 0;
  private boolean kB = false;
  private int kC = 0;
  private int kD = 0;
  private String kE = "";
  private String kF = "";
  private boolean kG = false;
  public int ko = 0;
  private int kp = 1;
  private List kq = null;
  private final boolean kr = false;
  private double ks = 0.0D;
  private String ku = "";
  private boolean kv = false;
  private double kw = 0.0D;
  private char kx = 'N';
  private String ky = "";
  private boolean kz = false;
  
  public at(List paramList, String paramString1, String paramString2, String paramString3)
  {
    this.kq = paramList;
    this.ky = paramString1;
    this.kE = paramString2;
    this.kF = paramString3;
    cS();
  }
  
  private void cS()
  {
    int i = 0;
    if (t(this.kF))
    {
      Object localObject = this.kF.substring(0, this.kF.length() - 3);
      int k;
      for (int j = 0; i < ((String)localObject).length(); j = k)
      {
        k = j;
        if (((String)localObject).charAt(i) == ',') {
          k = j + 1;
        }
        i += 1;
      }
      localObject = ((String)localObject).split(",", j + 1);
      if (localObject.length < 6) {
        return;
      }
      if ((!localObject[2].equals("")) && (!localObject[(localObject.length - 3)].equals("")) && (!localObject[(localObject.length - 2)].equals("")) && (!localObject[(localObject.length - 1)].equals("")))
      {
        this.kp = Integer.valueOf(localObject[2]).intValue();
        this.kw = Double.valueOf(localObject[(localObject.length - 3)]).doubleValue();
        this.ks = Double.valueOf(localObject[(localObject.length - 2)]).doubleValue();
        this.kB = true;
      }
    }
    this.kz = this.kB;
  }
  
  private boolean t(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.length() > 8)
      {
        int i = 1;
        int j = 0;
        while (i < paramString.length() - 3)
        {
          j ^= paramString.charAt(i);
          i += 1;
        }
        bool1 = bool2;
        if (Integer.toHexString(j).equalsIgnoreCase(paramString.substring(paramString.length() - 2, paramString.length()))) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public double cT()
  {
    return this.ks;
  }
  
  public String cU()
  {
    return this.ku;
  }
  
  public boolean cV()
  {
    return this.kz;
  }
  
  public double cW()
  {
    return this.kw;
  }
  
  public int cX()
  {
    return this.kA;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\baidu\location\at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */