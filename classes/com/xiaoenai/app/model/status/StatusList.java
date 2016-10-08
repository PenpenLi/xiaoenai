package com.xiaoenai.app.model.status;

import com.xiaoenai.app.classes.chat.messagelist.message.b.o;
import com.xiaoenai.app.d.an;
import java.util.Vector;
import org.json.JSONObject;

public class StatusList
{
  public static final String JSON_KEY_STATUS = "status";
  public static final String JSON_KEY_TIME = "timestamp";
  private static StatusList instance = null;
  private an db;
  private Vector<Status> mStatusList;
  
  private StatusList()
  {
    initAllStatus();
  }
  
  private void doWorkInBg(JSONObject paramJSONObject)
  {
    new Thread(new StatusList.1(this, paramJSONObject)).start();
  }
  
  public static StatusList getInstance()
  {
    if (instance == null) {}
    try
    {
      instance = new StatusList();
      return instance;
    }
    finally {}
  }
  
  private void initAllStatus()
  {
    this.mStatusList = new Vector();
    initEmbededStatus();
    this.db = new an();
    loadCurstomStatus();
  }
  
  private void initEmbededStatus()
  {
    Status localStatus = new Status();
    localStatus.setType("001");
    localStatus.setContent(o.b(1));
    this.mStatusList.add(localStatus);
    localStatus = new Status();
    localStatus.setContent(o.b(4));
    localStatus.setType("004");
    this.mStatusList.add(localStatus);
    localStatus = new Status();
    localStatus.setContent(o.b(6));
    localStatus.setType("006");
    this.mStatusList.add(localStatus);
    localStatus = new Status();
    localStatus.setContent(o.b(26));
    localStatus.setType("026");
    this.mStatusList.add(localStatus);
    localStatus = new Status();
    localStatus.setContent(o.b(10));
    localStatus.setType("010");
    this.mStatusList.add(localStatus);
    localStatus = new Status();
    localStatus.setContent(o.b(25));
    localStatus.setType("025");
    this.mStatusList.add(localStatus);
    localStatus = new Status();
    localStatus.setContent(o.b(27));
    localStatus.setType("027");
    this.mStatusList.add(localStatus);
  }
  
  private void loadCurstomStatus()
  {
    this.mStatusList.addAll(this.db.b());
  }
  
  public static void release()
  {
    instance = null;
  }
  
  public void addStatus(String paramString)
  {
    addStatus(paramString, System.currentTimeMillis());
  }
  
  public void addStatus(String paramString, long paramLong)
  {
    Status localStatus = new Status();
    localStatus.setCreateAt(paramLong);
    localStatus.setContent(paramString);
    localStatus.setType("030");
    this.mStatusList.add(localStatus);
    this.db.a(localStatus);
  }
  
  public void clear()
  {
    this.db.a();
    this.mStatusList.clear();
    initEmbededStatus();
  }
  
  public void deleteStatus(Status paramStatus)
  {
    this.mStatusList.remove(paramStatus);
    this.db.b(paramStatus);
  }
  
  public Vector<Status> getList()
  {
    return this.mStatusList;
  }
  
  public void getStatusFromJson(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("onekey_status")) {
      doWorkInBg(paramJSONObject);
    }
  }
  
  public boolean hasDIYStatus()
  {
    return this.mStatusList.size() > 7;
  }
  
  public int size()
  {
    return this.mStatusList.size();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\model\status\StatusList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */