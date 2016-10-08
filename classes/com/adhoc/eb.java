package com.adhoc;

import java.io.IOException;

public final class eb
  extends Exception
{
  public eb(IOException paramIOException)
  {
    super(paramIOException);
  }
  
  public IOException a()
  {
    return (IOException)super.getCause();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\eb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */