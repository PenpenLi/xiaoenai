package com.alibaba.sdk.android.event;

import java.util.Map;

public class Event
{
  public String name;
  public Map<String, Object> params;
  
  public static Event newEvent(String paramString, Map<String, Object> paramMap)
  {
    Event localEvent = new Event();
    localEvent.name = paramString;
    localEvent.params = paramMap;
    return localEvent;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (Event)paramObject;
        if (this.name != null) {
          break;
        }
      } while (((Event)paramObject).name == null);
      return false;
    } while (this.name.equals(((Event)paramObject).name));
    return false;
  }
  
  public int hashCode()
  {
    if (this.name == null) {}
    for (int i = 0;; i = this.name.hashCode()) {
      return i + 31;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\event\Event.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */