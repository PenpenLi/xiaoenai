package com.alibaba.wireless.security.open.opensdk;

import com.alibaba.wireless.security.open.IComponent;
import com.alibaba.wireless.security.open.SecException;
import com.taobao.wireless.security.adapter.JNICLibrary;
import java.nio.ByteBuffer;

public final class a
  implements IComponent, IOpenSDKComponent
{
  public final Long analyzeOpenId(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte, String paramString4)
  {
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramString2 == null) || (paramString2.length() == 0) || (paramString3 == null) || (paramString2.length() == 0) || (paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      throw new SecException(1101);
    }
    paramString1 = (byte[])JNICLibrary.a().doCommandNative(1401, null, new String[] { paramString1, paramString2, paramString3, paramString4 }, new byte[][] { paramArrayOfByte }, null);
    if ((paramString1 == null) || (paramString1.length > 8) || (paramString1.length <= 0)) {
      return null;
    }
    paramString2 = ByteBuffer.allocate(8);
    paramString2.put(paramString1, 0, paramString1.length);
    paramString2.flip();
    return Long.valueOf(paramString2.getLong());
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\wireless\security\open\opensdk\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */