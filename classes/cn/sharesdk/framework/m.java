package cn.sharesdk.framework;

import java.util.Comparator;

class m
  implements Comparator<Platform>
{
  m(l paraml) {}
  
  public int a(Platform paramPlatform1, Platform paramPlatform2)
  {
    if (paramPlatform1.getSortId() != paramPlatform2.getSortId()) {
      return paramPlatform1.getSortId() - paramPlatform2.getSortId();
    }
    return paramPlatform1.getPlatformId() - paramPlatform2.getPlatformId();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\cn\sharesdk\framework\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */