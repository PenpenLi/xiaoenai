package com.adhoc;

import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

final class fa
  extends ek
{
  fa(Socket paramSocket) {}
  
  protected void a()
  {
    try
    {
      this.a.close();
      return;
    }
    catch (Throwable localThrowable)
    {
      ex.a().log(Level.WARNING, "Failed to close timed out socket " + this.a, localThrowable);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\fa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */