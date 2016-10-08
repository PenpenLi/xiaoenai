package com.alimama.config;

public class Ration
  implements Comparable<Ration>
{
  public String attr = "";
  public int first = 0;
  public int id = 0;
  public boolean isS2s = false;
  public String k = "";
  public String n = "";
  public int p = 0;
  public String roundId = "";
  public String sid = "";
  public boolean t = false;
  public int ty = 0;
  public int w = 0;
  
  public Ration clone()
  {
    Ration localRation = new Ration();
    localRation.id = this.id;
    localRation.ty = this.ty;
    localRation.n = this.n;
    localRation.w = this.w;
    localRation.p = this.p;
    localRation.k = this.k;
    localRation.t = this.t;
    localRation.first = this.first;
    localRation.attr = this.attr;
    localRation.sid = this.sid;
    localRation.roundId = this.roundId;
    return localRation;
  }
  
  public int compareTo(Ration paramRation)
  {
    int i = paramRation.p;
    if (this.p < i) {
      return -1;
    }
    if (this.p > i) {
      return 1;
    }
    return 0;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\config\Ration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */