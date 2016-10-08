package c;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

final class s
  extends a
{
  s(Socket paramSocket) {}
  
  protected IOException a(IOException paramIOException)
  {
    SocketTimeoutException localSocketTimeoutException = new SocketTimeoutException("timeout");
    if (paramIOException != null) {
      localSocketTimeoutException.initCause(paramIOException);
    }
    return localSocketTimeoutException;
  }
  
  protected void a()
  {
    try
    {
      this.a.close();
      return;
    }
    catch (Exception localException)
    {
      p.a().log(Level.WARNING, "Failed to close timed out socket " + this.a, localException);
      return;
    }
    catch (AssertionError localAssertionError)
    {
      if ((localAssertionError.getCause() != null) && (localAssertionError.getMessage() != null) && (localAssertionError.getMessage().contains("getsockname failed")))
      {
        p.a().log(Level.WARNING, "Failed to close timed out socket " + this.a, localAssertionError);
        return;
      }
      throw localAssertionError;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\c\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */