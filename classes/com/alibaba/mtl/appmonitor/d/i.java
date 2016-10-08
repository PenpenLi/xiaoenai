package com.alibaba.mtl.appmonitor.d;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.mtl.appmonitor.f.b;
import com.alibaba.mtl.appmonitor.model.ConfigMetric;
import com.alibaba.mtl.appmonitor.model.Measure;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.Metric;
import com.alibaba.mtl.appmonitor.model.MetricRepo;
import java.util.HashMap;
import java.util.Map;

class i
  extends a<JSONObject>
{
  private String o;
  protected Map<String, j> p;
  
  public i(String paramString, int paramInt)
  {
    super(paramInt);
    this.o = paramString;
    this.p = new HashMap();
  }
  
  public boolean a(int paramInt, String paramString, Map<String, String> paramMap)
  {
    if (this.p != null)
    {
      paramString = (j)this.p.get(paramString);
      if (paramString != null) {
        return paramString.a(paramInt, paramMap);
      }
    }
    return a(paramInt);
  }
  
  public void b(JSONObject paramJSONObject)
  {
    a(paramJSONObject);
    JSONArray localJSONArray = paramJSONObject.getJSONArray("monitorPoints");
    if (localJSONArray != null)
    {
      int i = 0;
      while (i < localJSONArray.size())
      {
        Object localObject2 = localJSONArray.getJSONObject(i);
        String str = ((JSONObject)localObject2).getString("monitorPoint");
        Object localObject3 = ((JSONObject)localObject2).getString("metric_comment_detail");
        if (b.d(str))
        {
          Object localObject1 = (j)this.p.get(str);
          paramJSONObject = (JSONObject)localObject1;
          if (localObject1 == null)
          {
            paramJSONObject = new j(str, this.n);
            this.p.put(str, paramJSONObject);
          }
          paramJSONObject.b((JSONObject)localObject2);
          paramJSONObject = MetricRepo.getRepo().getMetric(this.o, str);
          if (paramJSONObject != null) {
            paramJSONObject.setCommitDetailFromConfig((String)localObject3);
          }
          paramJSONObject = ((JSONObject)localObject2).get("measures");
          if ((paramJSONObject instanceof JSONArray))
          {
            localObject1 = (JSONArray)paramJSONObject;
            paramJSONObject = MeasureSet.create();
            int k = ((JSONArray)localObject1).size();
            int j = 0;
            while (j < k)
            {
              Object localObject4 = ((JSONArray)localObject1).getJSONObject(j);
              if (localObject4 != null)
              {
                localObject2 = ((JSONObject)localObject4).getString("name");
                localObject3 = ((JSONObject)localObject4).getDouble("min");
                localObject4 = Double.valueOf(((JSONObject)localObject4).getDoubleValue("max"));
                if ((localObject2 != null) && (localObject3 != null) && (localObject4 != null)) {
                  paramJSONObject.addMeasure(new Measure((String)localObject2, Double.valueOf(0.0D), (Double)localObject3, (Double)localObject4));
                }
              }
              j += 1;
            }
            localObject1 = MetricRepo.getRepo().getMetric("config_prefix" + this.o, "config_prefix" + str);
            if (localObject1 != null) {
              MetricRepo.getRepo().remove((Metric)localObject1);
            }
            paramJSONObject = new ConfigMetric("config_prefix" + this.o, "config_prefix" + str, paramJSONObject);
            MetricRepo.getRepo().add(paramJSONObject);
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\d\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */