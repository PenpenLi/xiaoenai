package cn.sharesdk.framework.authorize;

import cn.sharesdk.framework.Platform;

public abstract interface AuthorizeHelper
{
  public abstract AuthorizeListener getAuthorizeListener();
  
  public abstract String getAuthorizeUrl();
  
  public abstract b getAuthorizeWebviewClient(g paramg);
  
  public abstract Platform getPlatform();
  
  public abstract String getRedirectUri();
  
  public abstract SSOListener getSSOListener();
  
  public abstract f getSSOProcessor(e parame);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\cn\sharesdk\framework\authorize\AuthorizeHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */