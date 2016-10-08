package org.cocos2dx.lib;

class Cocos2dxDownloader$2
  implements Runnable
{
  Cocos2dxDownloader$2(Cocos2dxDownloader paramCocos2dxDownloader, int paramInt1, int paramInt2, String paramString, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    this.this$0.nativeOnFinish(Cocos2dxDownloader.access$000(this.this$0), this.val$id, this.val$errCode, this.val$errStr, this.val$data);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\org\cocos2dx\lib\Cocos2dxDownloader$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */