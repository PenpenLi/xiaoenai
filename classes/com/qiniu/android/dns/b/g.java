package com.qiniu.android.dns.b;

import com.qiniu.android.dns.a;
import com.qiniu.android.dns.d;
import com.qiniu.android.dns.h;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Random;

public final class g
  implements d
{
  private static final Random b = new Random();
  final InetAddress a;
  
  public g(InetAddress paramInetAddress)
  {
    this.a = paramInetAddress;
  }
  
  private byte[] a(byte[] paramArrayOfByte)
  {
    DatagramSocket localDatagramSocket;
    try
    {
      localDatagramSocket = new DatagramSocket();
      if (localDatagramSocket == null) {
        break label84;
      }
    }
    finally
    {
      try
      {
        paramArrayOfByte = new DatagramPacket(paramArrayOfByte, paramArrayOfByte.length, this.a, 53);
        localDatagramSocket.setSoTimeout(5000);
        localDatagramSocket.send(paramArrayOfByte);
        paramArrayOfByte = new DatagramPacket(new byte['ל'], 1500);
        localDatagramSocket.receive(paramArrayOfByte);
        paramArrayOfByte = paramArrayOfByte.getData();
        if (localDatagramSocket != null) {
          localDatagramSocket.close();
        }
        return paramArrayOfByte;
      }
      finally {}
      paramArrayOfByte = finally;
      localDatagramSocket = null;
    }
    localDatagramSocket.close();
    label84:
    throw paramArrayOfByte;
  }
  
  public h[] a(com.qiniu.android.dns.c paramc, com.qiniu.android.dns.g arg2)
  {
    int i;
    synchronized (b)
    {
      i = b.nextInt() & 0xFF;
      ??? = a(c.a(paramc.a, i));
      if (??? == null) {
        throw new a(paramc.a, "cant get answer");
      }
    }
    return c.a(???, i, paramc.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\qiniu\android\dns\b\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */