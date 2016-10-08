package org.apache.http.entity.mime.content;

import java.io.OutputStream;

public abstract interface ContentBody
  extends ContentDescriptor
{
  public abstract String getFilename();
  
  public abstract void writeTo(OutputStream paramOutputStream);
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\org\apache\http\entity\mime\content\ContentBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */