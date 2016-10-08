package com.alibaba.sdk.android.event;

import com.alibaba.sdk.android.executor.ExecutorService;
import com.alibaba.sdk.android.impl.KernelContext;
import com.alibaba.sdk.android.trace.AliSDKLogger;
import java.util.Iterator;
import java.util.List;

class EventBus$1
  implements Runnable
{
  EventBus$1(EventBus paramEventBus, List paramList, Event paramEvent) {}
  
  public void run()
  {
    Iterator localIterator = this.val$curEventListeners.iterator();
    while (localIterator.hasNext())
    {
      EventListener localEventListener = (EventListener)localIterator.next();
      int i = localEventListener.getThreadModel();
      if (i == 2) {
        try
        {
          localEventListener.onEvent(this.val$event);
        }
        catch (Throwable localThrowable)
        {
          AliSDKLogger.e("eventBus", "fail to execute the event " + this.val$event.name + " the error message is " + localThrowable.getMessage(), localThrowable);
        }
      } else if (i == 1) {
        KernelContext.executorService.postUITask(new EventBus.EventListenerTask(localThrowable, this.val$event));
      } else {
        AliSDKLogger.e("eventBus", "No support for thread model " + i + ", fail to dispatch the event " + this.val$event.name);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\event\EventBus$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */