package com.alibaba.sdk.android.rpc.codec;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class DynamicByteBuffer
{
  private ByteBuffer buffer;
  
  public DynamicByteBuffer(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramInt);; localByteBuffer = ByteBuffer.allocate(paramInt))
    {
      this.buffer = localByteBuffer;
      return;
    }
  }
  
  public DynamicByteBuffer(ByteBuffer paramByteBuffer)
  {
    this.buffer = paramByteBuffer;
  }
  
  public DynamicByteBuffer(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {}
    for (paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);; paramArrayOfByte = ByteBuffer.allocate(0))
    {
      this.buffer = paramArrayOfByte;
      return;
    }
  }
  
  public DynamicByteBuffer(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.buffer = ByteBuffer.wrap(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static DynamicByteBuffer allocate(int paramInt)
  {
    return new DynamicByteBuffer(paramInt, false);
  }
  
  private void check()
  {
    if (this.buffer == null) {
      throw new IllegalStateException("Buffer is closed!");
    }
  }
  
  private void ensureSize(int paramInt)
  {
    check();
    if (this.buffer.remaining() < paramInt)
    {
      paramInt = Math.max(this.buffer.limit() << 1, this.buffer.limit() + paramInt);
      if (!this.buffer.isDirect()) {
        break label87;
      }
    }
    label87:
    for (ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramInt);; localByteBuffer = ByteBuffer.allocate(paramInt))
    {
      localByteBuffer.order(this.buffer.order());
      this.buffer.flip();
      localByteBuffer.put(this.buffer);
      this.buffer = localByteBuffer;
      return;
    }
  }
  
  public byte[] array()
  {
    check();
    int i = this.buffer.position();
    int j = this.buffer.limit();
    try
    {
      this.buffer.flip();
      byte[] arrayOfByte = new byte[this.buffer.limit()];
      this.buffer.get(arrayOfByte);
      return arrayOfByte;
    }
    finally
    {
      this.buffer.position(i);
      this.buffer.limit(j);
    }
  }
  
  public ByteBuffer asBuffer()
  {
    return this.buffer.asReadOnlyBuffer();
  }
  
  public int capacity()
  {
    check();
    return this.buffer.capacity();
  }
  
  public Buffer clear()
  {
    check();
    return this.buffer.clear();
  }
  
  public void close()
  {
    this.buffer.clear();
    this.buffer = null;
  }
  
  public DynamicByteBuffer compact()
  {
    this.buffer.compact();
    return this;
  }
  
  public DynamicByteBuffer duplicate()
  {
    check();
    return new DynamicByteBuffer(this.buffer.duplicate());
  }
  
  public Buffer flip()
  {
    check();
    return this.buffer.flip();
  }
  
  public byte get()
  {
    return this.buffer.get();
  }
  
  public byte get(int paramInt)
  {
    return this.buffer.get(paramInt);
  }
  
  public DynamicByteBuffer get(byte[] paramArrayOfByte)
  {
    this.buffer.get(paramArrayOfByte);
    return this;
  }
  
  public DynamicByteBuffer get(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.buffer.get(paramArrayOfByte, paramInt1, paramInt2);
    return this;
  }
  
  public char getChar()
  {
    check();
    return this.buffer.getChar();
  }
  
  public char getChar(int paramInt)
  {
    check();
    return this.buffer.getChar(paramInt);
  }
  
  public double getDouble()
  {
    check();
    return this.buffer.getDouble();
  }
  
  public double getDouble(int paramInt)
  {
    check();
    return this.buffer.getDouble(paramInt);
  }
  
  public float getFloat()
  {
    check();
    return this.buffer.getFloat();
  }
  
  public float getFloat(int paramInt)
  {
    check();
    return this.buffer.getFloat(paramInt);
  }
  
  public int getInt()
  {
    check();
    return this.buffer.getInt();
  }
  
  public int getInt(int paramInt)
  {
    check();
    return this.buffer.getInt(paramInt);
  }
  
  public long getLong()
  {
    check();
    return this.buffer.getLong();
  }
  
  public long getLong(int paramInt)
  {
    check();
    return this.buffer.getLong(paramInt);
  }
  
  public Buffer getRealBuffer()
  {
    return this.buffer;
  }
  
  public short getShort()
  {
    check();
    return this.buffer.getShort();
  }
  
  public short getShort(int paramInt)
  {
    check();
    return this.buffer.getShort(paramInt);
  }
  
  public boolean hasRemaining()
  {
    check();
    return this.buffer.hasRemaining();
  }
  
  public int limit()
  {
    check();
    return this.buffer.limit();
  }
  
  public Buffer limit(int paramInt)
  {
    check();
    return this.buffer.limit(paramInt);
  }
  
  public Buffer mark()
  {
    check();
    return this.buffer.mark();
  }
  
  public ByteBuffer order(ByteOrder paramByteOrder)
  {
    check();
    return this.buffer.order(paramByteOrder);
  }
  
  public ByteOrder order()
  {
    check();
    return this.buffer.order();
  }
  
  public int position()
  {
    check();
    return this.buffer.position();
  }
  
  public Buffer position(int paramInt)
  {
    check();
    return this.buffer.position(paramInt);
  }
  
  public DynamicByteBuffer put(byte paramByte)
  {
    ensureSize(1);
    this.buffer.put(paramByte);
    return this;
  }
  
  public DynamicByteBuffer put(int paramInt, byte paramByte)
  {
    ensureSize(1);
    this.buffer.put(paramInt, paramByte);
    return this;
  }
  
  public DynamicByteBuffer put(DynamicByteBuffer paramDynamicByteBuffer)
  {
    ensureSize(paramDynamicByteBuffer.remaining());
    this.buffer.put(paramDynamicByteBuffer.asBuffer());
    return this;
  }
  
  public DynamicByteBuffer put(ByteBuffer paramByteBuffer)
  {
    ensureSize(paramByteBuffer.remaining());
    this.buffer.put(paramByteBuffer);
    return this;
  }
  
  public DynamicByteBuffer put(byte[] paramArrayOfByte)
  {
    ensureSize(paramArrayOfByte.length);
    this.buffer.put(paramArrayOfByte);
    return this;
  }
  
  public DynamicByteBuffer put(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    ensureSize(paramInt2);
    this.buffer.put(paramArrayOfByte, paramInt1, paramInt2);
    return this;
  }
  
  public DynamicByteBuffer putChar(char paramChar)
  {
    ensureSize(2);
    this.buffer.putChar(paramChar);
    return this;
  }
  
  public DynamicByteBuffer putChar(int paramInt, char paramChar)
  {
    ensureSize(2);
    this.buffer.putChar(paramInt, paramChar);
    return this;
  }
  
  public DynamicByteBuffer putDouble(double paramDouble)
  {
    ensureSize(8);
    this.buffer.putDouble(paramDouble);
    return this;
  }
  
  public DynamicByteBuffer putDouble(int paramInt, double paramDouble)
  {
    ensureSize(8);
    this.buffer.putDouble(paramInt, paramDouble);
    return this;
  }
  
  public DynamicByteBuffer putFloat(float paramFloat)
  {
    ensureSize(4);
    this.buffer.putFloat(paramFloat);
    return this;
  }
  
  public DynamicByteBuffer putFloat(int paramInt, float paramFloat)
  {
    ensureSize(4);
    this.buffer.putFloat(paramInt, paramFloat);
    return this;
  }
  
  public DynamicByteBuffer putInt(int paramInt)
  {
    ensureSize(4);
    this.buffer.putInt(paramInt);
    return this;
  }
  
  public DynamicByteBuffer putInt(int paramInt1, int paramInt2)
  {
    ensureSize(4);
    this.buffer.putInt(paramInt1, paramInt2);
    return this;
  }
  
  public DynamicByteBuffer putLong(int paramInt, long paramLong)
  {
    ensureSize(8);
    this.buffer.putLong(paramInt, paramLong);
    return this;
  }
  
  public DynamicByteBuffer putLong(long paramLong)
  {
    ensureSize(8);
    this.buffer.putLong(paramLong);
    return this;
  }
  
  public DynamicByteBuffer putShort(int paramInt, short paramShort)
  {
    ensureSize(2);
    this.buffer.putShort(paramInt, paramShort);
    return this;
  }
  
  public DynamicByteBuffer putShort(short paramShort)
  {
    ensureSize(2);
    this.buffer.putShort(paramShort);
    return this;
  }
  
  public int remaining()
  {
    check();
    return this.buffer.remaining();
  }
  
  public Buffer reset()
  {
    check();
    return this.buffer.reset();
  }
  
  public Buffer rewind()
  {
    check();
    return this.buffer.rewind();
  }
  
  public DynamicByteBuffer slice()
  {
    check();
    return new DynamicByteBuffer(this.buffer.slice());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("DynamicByteBuffer{");
    if (this.buffer != null)
    {
      localStringBuilder.append("position=").append(this.buffer.position());
      localStringBuilder.append(", limit=").append(this.buffer.limit());
      localStringBuilder.append(", capacity=").append(this.buffer.capacity());
      localStringBuilder.append(", order=").append(this.buffer.order());
      localStringBuilder.append(", direct=").append(this.buffer.isDirect());
    }
    for (;;)
    {
      localStringBuilder.append('}');
      return localStringBuilder.toString();
      localStringBuilder.append("<CLOSED>");
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\rpc\codec\DynamicByteBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */