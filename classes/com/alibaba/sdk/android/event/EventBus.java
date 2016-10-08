package com.alibaba.sdk.android.event;

import android.text.TextUtils;
import com.alibaba.sdk.android.executor.ExecutorService;
import com.alibaba.sdk.android.impl.KernelContext;
import com.alibaba.sdk.android.trace.AliSDKLogger;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class EventBus
{
  private static final EventBus INSTANCE = new EventBus();
  private ConcurrentHashMap<String, List<EventListener>> eventListeners = new ConcurrentHashMap();
  private Map<String, Event> persistentEvents = Collections.synchronizedMap(new LinkedHashMap());
  
  public static EventBus getDefault()
  {
    return INSTANCE;
  }
  
  private void sendEvent(Event paramEvent)
  {
    List localList = (List)this.eventListeners.get(paramEvent.name);
    if ((localList == null) || (localList.size() == 0))
    {
      this.persistentEvents.put(paramEvent.name, paramEvent);
      return;
    }
    KernelContext.executorService.postTask(new EventBus.1(this, localList, paramEvent));
  }
  
  public void registerEventListener(String paramString, EventListener paramEventListener)
  {
    int j = 1;
    int i;
    if (paramString == null)
    {
      i = 1;
      if (paramEventListener != null) {
        break label29;
      }
      label14:
      if ((j | i) == 0) {
        break label35;
      }
    }
    label29:
    label35:
    do
    {
      return;
      i = 0;
      break;
      j = 0;
      break label14;
      List localList2 = (List)this.eventListeners.get(paramString);
      List localList1 = localList2;
      if (localList2 == null)
      {
        this.eventListeners.putIfAbsent(paramString, new CopyOnWriteArrayList());
        localList1 = (List)this.eventListeners.get(paramString);
      }
      localList1.add(paramEventListener);
    } while ((Event)this.persistentEvents.get(paramString) == null);
    sendEvent(paramString);
  }
  
  public void registerEventListener(String[] paramArrayOfString, EventListener paramEventListener)
  {
    if ((paramArrayOfString == null) || (paramEventListener == null)) {}
    for (;;)
    {
      return;
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        registerEventListener(paramArrayOfString[i], paramEventListener);
        i += 1;
      }
    }
  }
  
  public void sendEvent(String paramString)
  {
    sendEvent(paramString, null);
  }
  
  public void sendEvent(String paramString, Map<String, Object> paramMap)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    sendEvent(Event.newEvent(paramString, paramMap));
  }
  
  public void unregisterEventListener(String paramString, EventListener paramEventListener)
  {
    paramString = (List)this.eventListeners.get(paramString);
    if (paramString == null) {
      return;
    }
    paramString.remove(paramEventListener);
  }
  
  private static class EventListenerTask
    implements Runnable
  {
    private Event event;
    private EventListener eventListener;
    
    public EventListenerTask(EventListener paramEventListener, Event paramEvent)
    {
      this.event = paramEvent;
      this.eventListener = paramEventListener;
    }
    
    public void run()
    {
      try
      {
        this.eventListener.onEvent(this.event);
        return;
      }
      catch (Throwable localThrowable)
      {
        AliSDKLogger.e("eventBus", "fail to execute the event " + this.event.name + " the error message is " + localThrowable.getMessage(), localThrowable);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\event\EventBus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */