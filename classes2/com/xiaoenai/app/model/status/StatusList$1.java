package com.xiaoenai.app.model.status;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class StatusList$1
  implements Runnable
{
  StatusList$1(StatusList paramStatusList, JSONObject paramJSONObject) {}
  
  public void run()
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = new JSONObject(this.val$json.getString("onekey_status"));
        long l = ((JSONObject)localObject1).getLong("timestamp");
        localObject1 = ((JSONObject)localObject1).getJSONArray("status");
        Object localObject2 = new ArrayList();
        i = 0;
        if (i < ((JSONArray)localObject1).length())
        {
          String str = ((JSONArray)localObject1).getString(i);
          Iterator localIterator = StatusList.access$000(this.this$0).iterator();
          if (localIterator.hasNext())
          {
            if (!((Status)localIterator.next()).getContent().equals(str)) {
              continue;
            }
            j = 1;
            if (j != 0) {
              break label175;
            }
            ((List)localObject2).add(str);
            break label175;
          }
        }
        else
        {
          localObject1 = ((List)localObject2).iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            this.this$0.addStatus((String)localObject2, 1000L * l);
            continue;
          }
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      int j = 0;
      continue;
      label175:
      i += 1;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\model\status\StatusList$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */