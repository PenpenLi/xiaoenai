package com.sina.weibo.sdk.cmd;

abstract interface CmdExecutor<T extends BaseCmd>
{
  public abstract boolean doExecutor(T paramT);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\cmd\CmdExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */