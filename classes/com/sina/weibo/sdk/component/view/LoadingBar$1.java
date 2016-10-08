package com.sina.weibo.sdk.component.view;

class LoadingBar$1
  implements Runnable
{
  LoadingBar$1(LoadingBar paramLoadingBar) {}
  
  public void run()
  {
    LoadingBar localLoadingBar = this.this$0;
    LoadingBar.access$1(localLoadingBar, LoadingBar.access$0(localLoadingBar) + 1);
    this.this$0.drawProgress(LoadingBar.access$0(this.this$0));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\component\view\LoadingBar$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */