package com.xiaoenai.app.classes.extentions.reward.model;

import android.content.Context;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.annotation.json.JsonParser;
import com.xiaoenai.app.annotation.json.a;
import com.xiaoenai.app.utils.ak;
import com.xiaoenai.app.utils.d.f;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

@JsonParser(a={@com.xiaoenai.app.annotation.json.JsonElement(a="id", b="task_id"), @com.xiaoenai.app.annotation.json.JsonElement(a="title", b="task_title"), @com.xiaoenai.app.annotation.json.JsonElement(a="desc", b="task_desc"), @com.xiaoenai.app.annotation.json.JsonElement(a="count", b="task_count"), @com.xiaoenai.app.annotation.json.JsonElement(a="done", b="task_done"), @com.xiaoenai.app.annotation.json.JsonElement(a="reward", b="task_reward"), @com.xiaoenai.app.annotation.json.JsonElement(a="icon_url", b="icon_url"), @com.xiaoenai.app.annotation.json.JsonElement(a="status", b="task_status")})
public class BaseTask
  extends a
  implements Serializable
{
  public static final int STATE_EXCUTE = 1;
  public static final int STATE_REWARD = 0;
  public static final int STATE_REWARDED = 2;
  public static final String TASK_FILE_NAME = "task_serializable";
  public static final int TASK_FOLLOW = 6;
  public static final int TASK_FORUM_REPLY = 7;
  public static final int TASK_FORUM_SHARE = 9;
  public static final int TASK_INVALID = -1;
  public static final int TASK_LOVE_TIME = 4;
  public static final int TASK_RATE = 5;
  public static final int TASK_RECOMMEND = 11;
  public static final int TASK_SPACE_REPLY = 8;
  public static final int TASK_SPACE_SHARE = 10;
  private int count;
  private int cycle_type;
  private String desc;
  private int done;
  private int endTime;
  private String icon_url;
  private int id;
  private int reward;
  private int startTime;
  private int status;
  private String title;
  
  public static void doTaskAction(int paramInt1, int paramInt2, Context paramContext)
  {
    if (hasTaskRight(paramInt1)) {
      new com.xiaoenai.app.net.l(paramContext).a(paramInt1, paramInt2);
    }
  }
  
  public static File getTaskFile()
  {
    File localFile = new File(f.a(Xiaoenai.j()), "task_serializable");
    if (localFile.exists()) {}
    try
    {
      localFile.createNewFile();
      return localFile;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return localFile;
  }
  
  public static boolean hasTaskRight(int paramInt)
  {
    Object localObject = new File(f.a(Xiaoenai.j()), "task_serializable");
    if (!((File)localObject).exists()) {}
    do
    {
      return false;
      localObject = f.b((File)localObject);
    } while (localObject == null);
    localObject = com.xiaoenai.app.utils.l.a((JSONObject)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      BaseTask localBaseTask = (BaseTask)((Iterator)localObject).next();
      if ((localBaseTask.getCycle_type() == 0) || (ak.b() <= localBaseTask.getEndTime())) {}
      for (int i = 1; (localBaseTask.getId() == paramInt) && (i != 0) && (localBaseTask.getStatus() != 2); i = 0) {
        return true;
      }
    }
  }
  
  public void fromJson(JSONObject paramJSONObject)
  {
    try
    {
      fromJson(BaseTask.class, paramJSONObject, this);
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public int getCount()
  {
    return this.count;
  }
  
  public int getCycle_type()
  {
    return this.cycle_type;
  }
  
  public String getDesc()
  {
    return this.desc;
  }
  
  public int getDone()
  {
    return this.done;
  }
  
  public int getEndTime()
  {
    return this.endTime;
  }
  
  public String getIcon_url()
  {
    return this.icon_url;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public int getReward()
  {
    return this.reward;
  }
  
  public int getStartTime()
  {
    return this.startTime;
  }
  
  public int getStatus()
  {
    return this.status;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public boolean isShow()
  {
    boolean bool = false;
    if (getEndTime() <= ak.b()) {
      bool = true;
    }
    return bool;
  }
  
  public void setCount(int paramInt)
  {
    this.count = paramInt;
  }
  
  public void setCycle_type(int paramInt)
  {
    this.cycle_type = paramInt;
  }
  
  public void setDesc(String paramString)
  {
    this.desc = paramString;
  }
  
  public void setDone(int paramInt)
  {
    this.done = paramInt;
  }
  
  public void setEndTime(int paramInt)
  {
    this.endTime = paramInt;
  }
  
  public void setIcon_url(String paramString)
  {
    this.icon_url = paramString;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setReward(int paramInt)
  {
    this.reward = paramInt;
  }
  
  public void setStartTime(int paramInt)
  {
    this.startTime = paramInt;
  }
  
  public void setStatus(int paramInt)
  {
    this.status = paramInt;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\reward\model\BaseTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */