package com.ta.utdid2.c.a;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import org.xmlpull.v1.XmlSerializer;

class a
  implements XmlSerializer
{
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "&quot;", null, null, null, "&amp;", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "&lt;", null, "&gt;", null };
  private OutputStream jdField_a_of_type_JavaIoOutputStream;
  private Writer jdField_a_of_type_JavaIoWriter;
  private ByteBuffer jdField_a_of_type_JavaNioByteBuffer = ByteBuffer.allocate(8192);
  private CharsetEncoder jdField_a_of_type_JavaNioCharsetCharsetEncoder;
  private final char[] jdField_a_of_type_ArrayOfChar = new char[' '];
  private boolean f;
  private int mPos;
  
  private void a(String paramString)
  {
    int j = 0;
    int m = paramString.length();
    int n = (char)jdField_a_of_type_ArrayOfJavaLangString.length;
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int i = 0;
    if (i < m)
    {
      int k = paramString.charAt(i);
      if (k >= n) {
        k = j;
      }
      for (;;)
      {
        i += 1;
        j = k;
        break;
        String str = arrayOfString[k];
        k = j;
        if (str != null)
        {
          if (j < i) {
            a(paramString, j, i - j);
          }
          k = i + 1;
          append(str);
        }
      }
    }
    if (j < i) {
      a(paramString, j, i - j);
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    int j;
    int i;
    if (paramInt2 > 8192)
    {
      j = paramInt1 + paramInt2;
      if (paramInt1 < j)
      {
        i = paramInt1 + 8192;
        if (i < j) {}
        for (paramInt2 = 8192;; paramInt2 = j - paramInt1)
        {
          a(paramString, paramInt1, paramInt2);
          paramInt1 = i;
          break;
        }
      }
    }
    else
    {
      j = this.mPos;
      i = j;
      if (j + paramInt2 > 8192)
      {
        flush();
        i = this.mPos;
      }
      paramString.getChars(paramInt1, paramInt1 + paramInt2, this.jdField_a_of_type_ArrayOfChar, i);
      this.mPos = (i + paramInt2);
    }
  }
  
  private void a(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int m = (char)jdField_a_of_type_ArrayOfJavaLangString.length;
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int j = paramInt1;
    int i = paramInt1;
    int k = i;
    if (k < paramInt1 + paramInt2)
    {
      i = paramArrayOfChar[k];
      if (i >= m) {
        i = j;
      }
      for (;;)
      {
        k += 1;
        j = i;
        i = k;
        break;
        String str = arrayOfString[i];
        i = j;
        if (str != null)
        {
          if (j < k) {
            append(paramArrayOfChar, j, k - j);
          }
          i = k + 1;
          append(str);
        }
      }
    }
    if (j < k) {
      append(paramArrayOfChar, j, k - j);
    }
  }
  
  private void append(char paramChar)
  {
    int j = this.mPos;
    int i = j;
    if (j >= 8191)
    {
      flush();
      i = this.mPos;
    }
    this.jdField_a_of_type_ArrayOfChar[i] = paramChar;
    this.mPos = (i + 1);
  }
  
  private void append(String paramString)
  {
    a(paramString, 0, paramString.length());
  }
  
  private void append(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int j;
    int i;
    if (paramInt2 > 8192)
    {
      j = paramInt1 + paramInt2;
      if (paramInt1 < j)
      {
        i = paramInt1 + 8192;
        if (i < j) {}
        for (paramInt2 = 8192;; paramInt2 = j - paramInt1)
        {
          append(paramArrayOfChar, paramInt1, paramInt2);
          paramInt1 = i;
          break;
        }
      }
    }
    else
    {
      j = this.mPos;
      i = j;
      if (j + paramInt2 > 8192)
      {
        flush();
        i = this.mPos;
      }
      System.arraycopy(paramArrayOfChar, paramInt1, this.jdField_a_of_type_ArrayOfChar, i, paramInt2);
      this.mPos = (i + paramInt2);
    }
  }
  
  private void b()
  {
    int i = this.jdField_a_of_type_JavaNioByteBuffer.position();
    if (i > 0)
    {
      this.jdField_a_of_type_JavaNioByteBuffer.flip();
      this.jdField_a_of_type_JavaIoOutputStream.write(this.jdField_a_of_type_JavaNioByteBuffer.array(), 0, i);
      this.jdField_a_of_type_JavaNioByteBuffer.clear();
    }
  }
  
  public XmlSerializer attribute(String paramString1, String paramString2, String paramString3)
  {
    append(' ');
    if (paramString1 != null)
    {
      append(paramString1);
      append(':');
    }
    append(paramString2);
    append("=\"");
    a(paramString3);
    append('"');
    return this;
  }
  
  public void cdsect(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public void comment(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public void docdecl(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public void endDocument()
  {
    flush();
  }
  
  public XmlSerializer endTag(String paramString1, String paramString2)
  {
    if (this.f) {
      append(" />\n");
    }
    for (;;)
    {
      this.f = false;
      return this;
      append("</");
      if (paramString1 != null)
      {
        append(paramString1);
        append(':');
      }
      append(paramString2);
      append(">\n");
    }
  }
  
  public void entityRef(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public void flush()
  {
    if (this.mPos > 0)
    {
      if (this.jdField_a_of_type_JavaIoOutputStream == null) {
        break label105;
      }
      CharBuffer localCharBuffer = CharBuffer.wrap(this.jdField_a_of_type_ArrayOfChar, 0, this.mPos);
      for (CoderResult localCoderResult = this.jdField_a_of_type_JavaNioCharsetCharsetEncoder.encode(localCharBuffer, this.jdField_a_of_type_JavaNioByteBuffer, true);; localCoderResult = this.jdField_a_of_type_JavaNioCharsetCharsetEncoder.encode(localCharBuffer, this.jdField_a_of_type_JavaNioByteBuffer, true))
      {
        if (localCoderResult.isError()) {
          throw new IOException(localCoderResult.toString());
        }
        if (!localCoderResult.isOverflow()) {
          break;
        }
        b();
      }
      b();
      this.jdField_a_of_type_JavaIoOutputStream.flush();
    }
    for (;;)
    {
      this.mPos = 0;
      return;
      label105:
      this.jdField_a_of_type_JavaIoWriter.write(this.jdField_a_of_type_ArrayOfChar, 0, this.mPos);
      this.jdField_a_of_type_JavaIoWriter.flush();
    }
  }
  
  public int getDepth()
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean getFeature(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public String getName()
  {
    throw new UnsupportedOperationException();
  }
  
  public String getNamespace()
  {
    throw new UnsupportedOperationException();
  }
  
  public String getPrefix(String paramString, boolean paramBoolean)
  {
    throw new UnsupportedOperationException();
  }
  
  public Object getProperty(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public void ignorableWhitespace(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public void processingInstruction(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public void setFeature(String paramString, boolean paramBoolean)
  {
    if (paramString.equals("http://xmlpull.org/v1/doc/features.html#indent-output")) {
      return;
    }
    throw new UnsupportedOperationException();
  }
  
  public void setOutput(OutputStream paramOutputStream, String paramString)
  {
    if (paramOutputStream == null) {
      throw new IllegalArgumentException();
    }
    try
    {
      this.jdField_a_of_type_JavaNioCharsetCharsetEncoder = Charset.forName(paramString).newEncoder();
      this.jdField_a_of_type_JavaIoOutputStream = paramOutputStream;
      return;
    }
    catch (IllegalCharsetNameException paramOutputStream)
    {
      throw ((UnsupportedEncodingException)new UnsupportedEncodingException(paramString).initCause(paramOutputStream));
    }
    catch (UnsupportedCharsetException paramOutputStream)
    {
      throw ((UnsupportedEncodingException)new UnsupportedEncodingException(paramString).initCause(paramOutputStream));
    }
  }
  
  public void setOutput(Writer paramWriter)
  {
    this.jdField_a_of_type_JavaIoWriter = paramWriter;
  }
  
  public void setPrefix(String paramString1, String paramString2)
  {
    throw new UnsupportedOperationException();
  }
  
  public void setProperty(String paramString, Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  public void startDocument(String paramString, Boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("<?xml version='1.0' encoding='utf-8' standalone='");
    if (paramBoolean.booleanValue()) {}
    for (paramString = "yes";; paramString = "no")
    {
      append(paramString + "' ?>\n");
      return;
    }
  }
  
  public XmlSerializer startTag(String paramString1, String paramString2)
  {
    if (this.f) {
      append(">\n");
    }
    append('<');
    if (paramString1 != null)
    {
      append(paramString1);
      append(':');
    }
    append(paramString2);
    this.f = true;
    return this;
  }
  
  public XmlSerializer text(String paramString)
  {
    if (this.f)
    {
      append(">");
      this.f = false;
    }
    a(paramString);
    return this;
  }
  
  public XmlSerializer text(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (this.f)
    {
      append(">");
      this.f = false;
    }
    a(paramArrayOfChar, paramInt1, paramInt2);
    return this;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\ta\utdid2\c\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */