package cn.sharesdk.wechat.utils;

import android.os.Bundle;

public class WXWebpageObject
  implements WXMediaMessage.IMediaObject
{
  public String webpageUrl;
  
  public WXWebpageObject() {}
  
  public WXWebpageObject(String paramString)
  {
    this.webpageUrl = paramString;
  }
  
  public boolean checkArgs()
  {
    if ((this.webpageUrl == null) || (this.webpageUrl.length() == 0) || (this.webpageUrl.length() > 10240))
    {
      cn.sharesdk.framework.utils.d.a().w("checkArgs fail, webpageUrl is invalid", new Object[0]);
      return false;
    }
    return true;
  }
  
  public void serialize(Bundle paramBundle)
  {
    paramBundle.putString("_wxwebpageobject_webpageUrl", this.webpageUrl);
  }
  
  public int type()
  {
    return 5;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    this.webpageUrl = paramBundle.getString("_wxwebpageobject_webpageUrl");
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\cn\sharesdk\wechat\utils\WXWebpageObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */