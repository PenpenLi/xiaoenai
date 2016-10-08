package b;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

final class v
  implements u
{
  public List<InetAddress> a(String paramString)
  {
    if (paramString == null) {
      throw new UnknownHostException("hostname == null");
    }
    return Arrays.asList(InetAddress.getAllByName(paramString));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\b\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */