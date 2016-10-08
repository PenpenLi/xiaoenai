package com.alibaba.mtl.appmonitor.a;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.mtl.appmonitor.c.a;
import com.alibaba.mtl.appmonitor.c.e;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.Measure;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValue;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.alibaba.mtl.appmonitor.model.Metric;
import com.alibaba.mtl.appmonitor.model.MetricRepo;
import com.alibaba.mtl.log.e.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class g
  extends d
{
  private Metric a;
  private Map<DimensionValueSet, a> j;
  
  public JSONObject a()
  {
    JSONObject localJSONObject1;
    JSONArray localJSONArray;
    for (;;)
    {
      try
      {
        localJSONObject1 = super.a();
        if (this.a != null) {
          localJSONObject1.put("isCommitDetail", String.valueOf(this.a.isCommitDetail()));
        }
        localJSONArray = (JSONArray)a.a().a(com.alibaba.mtl.appmonitor.c.d.class, new Object[0]);
        if (this.j == null) {
          break;
        }
        Iterator localIterator = this.j.entrySet().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        Object localObject4 = (Map.Entry)localIterator.next();
        JSONObject localJSONObject2 = (JSONObject)a.a().a(e.class, new Object[0]);
        Object localObject1 = (DimensionValueSet)((Map.Entry)localObject4).getKey();
        localObject4 = (a)((Map.Entry)localObject4).getValue();
        int i = a.a((a)localObject4);
        int k = a.b((a)localObject4);
        localJSONObject2.put("count", Integer.valueOf(i));
        localJSONObject2.put("noise", Integer.valueOf(k));
        if (localObject1 != null)
        {
          localObject1 = new HashMap(((DimensionValueSet)localObject1).getMap());
          localJSONObject2.put("dimensions", localObject1);
          localJSONObject2.put("measures", ((a)localObject4).a());
          localJSONArray.add(localJSONObject2);
        }
        else
        {
          Object localObject3 = null;
        }
      }
      finally {}
    }
    localJSONObject1.put("values", localJSONArray);
    return localJSONObject1;
  }
  
  public void a(DimensionValueSet paramDimensionValueSet, MeasureValueSet paramMeasureValueSet)
  {
    DimensionValueSet localDimensionValueSet1 = paramDimensionValueSet;
    if (paramDimensionValueSet == null) {}
    for (;;)
    {
      boolean bool;
      try
      {
        localDimensionValueSet1 = (DimensionValueSet)a.a().a(DimensionValueSet.class, new Object[0]);
        localDimensionValueSet1.addValues(paramDimensionValueSet);
        if (this.j.containsKey(localDimensionValueSet1))
        {
          paramDimensionValueSet = (a)this.j.get(localDimensionValueSet1);
          if (this.a == null) {
            break label207;
          }
          bool = this.a.valid(localDimensionValueSet1, paramMeasureValueSet);
          if (bool)
          {
            paramDimensionValueSet.i();
            paramDimensionValueSet.a(paramMeasureValueSet);
            i.a("StatEvent", new Object[] { "entity  count:", Integer.valueOf(a.a(paramDimensionValueSet)), " noise:", Integer.valueOf(a.b(paramDimensionValueSet)) });
          }
        }
        else
        {
          DimensionValueSet localDimensionValueSet2 = (DimensionValueSet)a.a().a(DimensionValueSet.class, new Object[0]);
          localDimensionValueSet2.addValues(localDimensionValueSet1);
          paramDimensionValueSet = new a();
          this.j.put(localDimensionValueSet2, paramDimensionValueSet);
          continue;
        }
        paramDimensionValueSet.j();
      }
      finally {}
      if (this.a.isCommitDetail())
      {
        paramDimensionValueSet.a(paramMeasureValueSet);
        continue;
        label207:
        bool = false;
      }
    }
  }
  
  public void clean()
  {
    try
    {
      super.clean();
      this.a = null;
      Iterator localIterator = this.j.keySet().iterator();
      while (localIterator.hasNext())
      {
        DimensionValueSet localDimensionValueSet = (DimensionValueSet)localIterator.next();
        a.a().a(localDimensionValueSet);
      }
      this.j.clear();
    }
    finally {}
  }
  
  public void fill(Object... paramVarArgs)
  {
    super.fill(paramVarArgs);
    if (this.j == null) {
      this.j = new HashMap();
    }
    this.a = MetricRepo.getRepo().getMetric(this.o, this.p);
  }
  
  public class a
  {
    private List<MeasureValueSet> b = new ArrayList();
    private int count = 0;
    private int l = 0;
    
    public a() {}
    
    private MeasureValueSet a(MeasureValueSet paramMeasureValueSet)
    {
      MeasureValueSet localMeasureValueSet = (MeasureValueSet)a.a().a(MeasureValueSet.class, new Object[0]);
      if ((g.a(g.this) != null) && (g.a(g.this).getMeasureSet() != null))
      {
        List localList = g.a(g.this).getMeasureSet().getMeasures();
        if (localList != null)
        {
          int j = localList.size();
          int i = 0;
          while (i < j)
          {
            Measure localMeasure = (Measure)localList.get(i);
            if (localMeasure != null)
            {
              MeasureValue localMeasureValue1 = (MeasureValue)a.a().a(MeasureValue.class, new Object[0]);
              MeasureValue localMeasureValue2 = paramMeasureValueSet.getValue(localMeasure.getName());
              if (localMeasureValue2.getOffset() != null) {
                localMeasureValue1.setOffset(localMeasureValue2.getOffset().doubleValue());
              }
              localMeasureValue1.setValue(localMeasureValue2.getValue());
              localMeasureValueSet.setValue(localMeasure.getName(), localMeasureValue1);
            }
            i += 1;
          }
        }
      }
      return localMeasureValueSet;
    }
    
    public List<Map<String, Map<String, Double>>> a()
    {
      if ((this.b == null) || (this.b.isEmpty())) {
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      int j = this.b.size();
      int i = 0;
      if (i < j)
      {
        Object localObject1 = (MeasureValueSet)this.b.get(i);
        Object localObject2;
        if (localObject1 != null)
        {
          localObject2 = ((MeasureValueSet)localObject1).getMap();
          if ((localObject2 != null) && (!((Map)localObject2).isEmpty())) {
            break label96;
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label96:
          localObject1 = new HashMap();
          localObject2 = ((Map)localObject2).entrySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Object localObject3 = (Map.Entry)((Iterator)localObject2).next();
            HashMap localHashMap = new HashMap();
            String str = (String)((Map.Entry)localObject3).getKey();
            localObject3 = (MeasureValue)((Map.Entry)localObject3).getValue();
            localHashMap.put("value", Double.valueOf(((MeasureValue)localObject3).getValue()));
            if (((MeasureValue)localObject3).getOffset() != null) {
              localHashMap.put("offset", ((MeasureValue)localObject3).getOffset());
            }
            ((Map)localObject1).put(str, localHashMap);
          }
          localArrayList.add(localObject1);
        }
      }
      return localArrayList;
    }
    
    public void a(MeasureValueSet paramMeasureValueSet)
    {
      if (paramMeasureValueSet != null)
      {
        if ((g.a(g.this) != null) && (g.a(g.this).isCommitDetail())) {
          this.b.add(a(paramMeasureValueSet));
        }
      }
      else {
        return;
      }
      if (this.b.isEmpty())
      {
        this.b.add(a(paramMeasureValueSet));
        return;
      }
      ((MeasureValueSet)this.b.get(0)).merge(paramMeasureValueSet);
    }
    
    public void i()
    {
      this.count += 1;
    }
    
    public void j()
    {
      this.l += 1;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */