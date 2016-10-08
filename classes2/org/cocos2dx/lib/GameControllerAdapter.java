package org.cocos2dx.lib;

import java.util.ArrayList;

public class GameControllerAdapter
{
  private static ArrayList<Runnable> sRunnableFrameStartList = null;
  
  public static void addRunnableToFrameStartList(Runnable paramRunnable)
  {
    if (sRunnableFrameStartList == null) {
      sRunnableFrameStartList = new ArrayList();
    }
    sRunnableFrameStartList.add(paramRunnable);
  }
  
  private static native void nativeControllerAxisEvent(String paramString, int paramInt1, int paramInt2, float paramFloat, boolean paramBoolean);
  
  private static native void nativeControllerButtonEvent(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, float paramFloat, boolean paramBoolean2);
  
  private static native void nativeControllerConnected(String paramString, int paramInt);
  
  private static native void nativeControllerDisconnected(String paramString, int paramInt);
  
  public static void onAxisEvent(String paramString, int paramInt1, int paramInt2, float paramFloat, boolean paramBoolean)
  {
    Cocos2dxHelper.runOnGLThread(new GameControllerAdapter.4(paramString, paramInt1, paramInt2, paramFloat, paramBoolean));
  }
  
  public static void onButtonEvent(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, float paramFloat, boolean paramBoolean2)
  {
    Cocos2dxHelper.runOnGLThread(new GameControllerAdapter.3(paramString, paramInt1, paramInt2, paramBoolean1, paramFloat, paramBoolean2));
  }
  
  public static void onConnected(String paramString, int paramInt)
  {
    Cocos2dxHelper.runOnGLThread(new GameControllerAdapter.1(paramString, paramInt));
  }
  
  public static void onDisconnected(String paramString, int paramInt)
  {
    Cocos2dxHelper.runOnGLThread(new GameControllerAdapter.2(paramString, paramInt));
  }
  
  public static void onDrawFrameStart()
  {
    if (sRunnableFrameStartList != null)
    {
      int j = sRunnableFrameStartList.size();
      int i = 0;
      while (i < j)
      {
        ((Runnable)sRunnableFrameStartList.get(i)).run();
        i += 1;
      }
    }
  }
  
  public static void removeRunnableFromFrameStartList(Runnable paramRunnable)
  {
    if (sRunnableFrameStartList != null) {
      sRunnableFrameStartList.remove(paramRunnable);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\org\cocos2dx\lib\GameControllerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */