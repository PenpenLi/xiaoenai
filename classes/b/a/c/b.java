package b.a.c;

import java.io.File;
import java.io.IOException;

final class b
  implements a
{
  public void a(File paramFile)
  {
    if ((!paramFile.delete()) && (paramFile.exists())) {
      throw new IOException("failed to delete " + paramFile);
    }
  }
  
  public void a(File paramFile1, File paramFile2)
  {
    a(paramFile2);
    if (!paramFile1.renameTo(paramFile2)) {
      throw new IOException("failed to rename " + paramFile1 + " to " + paramFile2);
    }
  }
  
  public boolean b(File paramFile)
  {
    return paramFile.exists();
  }
  
  public long c(File paramFile)
  {
    return paramFile.length();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\b\a\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */