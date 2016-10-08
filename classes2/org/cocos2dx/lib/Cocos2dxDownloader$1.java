package org.cocos2dx.lib;

class Cocos2dxDownloader$1
  implements Runnable
{
  Cocos2dxDownloader$1(Cocos2dxDownloader paramCocos2dxDownloader, int paramInt, long paramLong1, long paramLong2, long paramLong3) {}
  
  public void run()
  {
    this.this$0.nativeOnProgress(Cocos2dxDownloader.access$000(this.this$0), this.val$id, this.val$downloadBytes, this.val$downloadNow, this.val$downloadTotal);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\org\cocos2dx\lib\Cocos2dxDownloader$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */