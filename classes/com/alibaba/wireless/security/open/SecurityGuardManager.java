package com.alibaba.wireless.security.open;

import android.content.Context;
import com.alibaba.wireless.security.open.atlasencrypt.IAtlasEncryptComponent;
import com.alibaba.wireless.security.open.datacollection.IDataCollectionComponent;
import com.alibaba.wireless.security.open.dynamicdataencrypt.IDynamicDataEncryptComponent;
import com.alibaba.wireless.security.open.dynamicdatastore.IDynamicDataStoreComponent;
import com.alibaba.wireless.security.open.initialize.IInitializeComponent;
import com.alibaba.wireless.security.open.initialize.b;
import com.alibaba.wireless.security.open.maldetection.IMalDetect;
import com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent;
import com.alibaba.wireless.security.open.opensdk.IOpenSDKComponent;
import com.alibaba.wireless.security.open.pkgvaliditycheck.IPkgValidityCheckComponent;
import com.alibaba.wireless.security.open.securesignature.ISecureSignatureComponent;
import com.alibaba.wireless.security.open.simulatordetect.ISimulatorDetectComponent;
import com.alibaba.wireless.security.open.staticdataencrypt.IStaticDataEncryptComponent;
import com.alibaba.wireless.security.open.staticdatastore.IStaticDataStoreComponent;
import com.alibaba.wireless.security.open.statickeyencrypt.IStaticKeyEncryptComponent;
import com.alibaba.wireless.security.open.umid.IUMIDComponent;

public class SecurityGuardManager
{
  private static volatile SecurityGuardManager b;
  private static volatile IInitializeComponent c;
  private static final Object d = new Object();
  private a a;
  
  private SecurityGuardManager(Context paramContext)
  {
    this.a = a.a(paramContext);
  }
  
  private IComponent a(int paramInt)
  {
    return this.a.a(paramInt);
  }
  
  public static IInitializeComponent getInitializer()
  {
    if (c == null) {}
    synchronized (d)
    {
      if (c == null) {
        c = new b();
      }
      return c;
    }
  }
  
  public static SecurityGuardManager getInstance(Context paramContext)
  {
    if (b == null) {
      if (paramContext == null) {
        return null;
      }
    }
    try
    {
      if ((b == null) && (getInitializer().initialize(paramContext) == 0)) {
        b = new SecurityGuardManager(paramContext);
      }
      return b;
    }
    finally {}
  }
  
  public IAtlasEncryptComponent getAtlasEncryptComp()
  {
    IAtlasEncryptComponent localIAtlasEncryptComponent = (IAtlasEncryptComponent)a(13);
    if (localIAtlasEncryptComponent == null) {
      new SecException(1098).printStackTrace();
    }
    return localIAtlasEncryptComponent;
  }
  
  public IDataCollectionComponent getDataCollectionComp()
  {
    return (IDataCollectionComponent)a(5);
  }
  
  public IDynamicDataEncryptComponent getDynamicDataEncryptComp()
  {
    return (IDynamicDataEncryptComponent)a(7);
  }
  
  public IDynamicDataStoreComponent getDynamicDataStoreComp()
  {
    return (IDynamicDataStoreComponent)a(2);
  }
  
  public IMalDetect getMalDetectionComp()
  {
    IMalDetect localIMalDetect = (IMalDetect)a(14);
    if (localIMalDetect == null) {
      new SecException(1398).printStackTrace();
    }
    return localIMalDetect;
  }
  
  public INoCaptchaComponent getNoCaptchaComp()
  {
    INoCaptchaComponent localINoCaptchaComponent = (INoCaptchaComponent)a(15);
    if (localINoCaptchaComponent == null) {
      new SecException(1299).printStackTrace();
    }
    return localINoCaptchaComponent;
  }
  
  public IOpenSDKComponent getOpenSDKComp()
  {
    return (IOpenSDKComponent)a(10);
  }
  
  public IPkgValidityCheckComponent getPackageValidityCheckComp()
  {
    return (IPkgValidityCheckComponent)a(12);
  }
  
  public String getSDKVerison()
  {
    return "3.1.27";
  }
  
  public ISecureSignatureComponent getSecureSignatureComp()
  {
    return (ISecureSignatureComponent)a(1);
  }
  
  public ISimulatorDetectComponent getSimulatorDetectComp()
  {
    ISimulatorDetectComponent localISimulatorDetectComponent = (ISimulatorDetectComponent)a(8);
    if (localISimulatorDetectComponent == null) {
      new SecException(1598).printStackTrace();
    }
    return localISimulatorDetectComponent;
  }
  
  public IStaticDataEncryptComponent getStaticDataEncryptComp()
  {
    return (IStaticDataEncryptComponent)a(6);
  }
  
  public IStaticDataStoreComponent getStaticDataStoreComp()
  {
    return (IStaticDataStoreComponent)a(3);
  }
  
  public IStaticKeyEncryptComponent getStaticKeyEncryptComp()
  {
    return (IStaticKeyEncryptComponent)a(9);
  }
  
  public IUMIDComponent getUMIDComp()
  {
    return (IUMIDComponent)a(11);
  }
  
  public Boolean isOpen()
  {
    return Boolean.valueOf(true);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\wireless\security\open\SecurityGuardManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */