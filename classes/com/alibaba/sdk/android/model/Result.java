package com.alibaba.sdk.android.model;

import com.alibaba.sdk.android.ResultCode;

public class Result<T>
{
  public int code;
  public T data;
  public String message;
  
  public Result() {}
  
  public Result(int paramInt, String paramString, T paramT)
  {
    this.code = paramInt;
    this.message = paramString;
    this.data = paramT;
  }
  
  public static <T> Result<T> result(int paramInt, String paramString)
  {
    return result(paramInt, paramString, null);
  }
  
  public static <T> Result<T> result(int paramInt, String paramString, T paramT)
  {
    return new Result(paramInt, paramString, paramT);
  }
  
  public static <T> Result<T> result(Result paramResult)
  {
    return result(paramResult.code, paramResult.message);
  }
  
  public static <T> Result<T> result(T paramT)
  {
    return result(ResultCode.SUCCESS.code, null, paramT);
  }
  
  public boolean isSuccess()
  {
    return this.code < 1000;
  }
  
  public String toString()
  {
    return "Result [code=" + this.code + ", message=" + this.message + ", data=" + this.data + "]";
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\model\Result.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */