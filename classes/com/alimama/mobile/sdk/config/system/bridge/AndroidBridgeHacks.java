package com.alimama.mobile.sdk.config.system.bridge;

import android.content.res.AssetManager;
import android.content.res.Resources.Theme;
import com.alimama.mobile.sdk.config.system.BridgeSystem.GROUP;
import com.alimama.mobile.sdk.config.system.BridgeSystem.GroupType;
import com.alimama.mobile.sdk.config.system.BridgeSystem.HackCollection;
import com.alimama.mobile.sdk.hack.Hack;
import com.alimama.mobile.sdk.hack.Hack.HackedClass;
import com.alimama.mobile.sdk.hack.Hack.HackedField;

@BridgeSystem.GROUP(TYPE=BridgeSystem.GroupType.OS)
public class AndroidBridgeHacks
  implements BridgeSystem.HackCollection
{
  public static Hack.HackedClass<Resources.Theme> THeme;
  public static Hack.HackedField<Resources.Theme, AssetManager> THeme_mAssets;
  
  public void allClasses()
  {
    THeme = Hack.into(Resources.Theme.class);
  }
  
  public void allFields() {}
  
  public void allMethods() {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\mobile\sdk\config\system\bridge\AndroidBridgeHacks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */