package com.alibaba.mtl.appmonitor.d;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.mtl.appmonitor.f.b;
import java.util.Map;

public class d
  extends i
{
  private int o = this.n;
  private int p;
  
  public d(String paramString, int paramInt1, int paramInt2)
  {
    super(paramString, 0);
    this.jdField_p_of_type_Int = this.n;
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    this.o = this.n;
    this.jdField_p_of_type_Int = this.n;
    Integer localInteger1 = paramJSONObject.getInteger("successSampling");
    if (localInteger1 != null) {
      this.o = localInteger1.intValue();
    }
    Integer localInteger2 = paramJSONObject.getInteger("failSampling");
    if (localInteger2 != null) {
      this.jdField_p_of_type_Int = localInteger2.intValue();
    }
    com.alibaba.mtl.log.e.i.a("AlarmModuleSampling", new Object[] { "[updateSelfSampling]", paramJSONObject, "successSampling:", localInteger1, "failSampling" });
  }
  
  public boolean a(int paramInt, String paramString, Boolean paramBoolean, Map<String, String> paramMap)
  {
    com.alibaba.mtl.log.e.i.a("AlarmModuleSampling", new Object[] { "samplingSeed:", Integer.valueOf(paramInt), "isSuccess:", paramBoolean, "successSampling:", Integer.valueOf(this.o), "failSampling:", Integer.valueOf(this.jdField_p_of_type_Int) });
    if (this.jdField_p_of_type_JavaUtilMap != null)
    {
      paramString = (j)this.jdField_p_of_type_JavaUtilMap.get(paramString);
      if ((paramString != null) && ((paramString instanceof e))) {
        return ((e)paramString).a(paramInt, paramBoolean, paramMap);
      }
    }
    return a(paramInt, paramBoolean.booleanValue());
  }
  
  protected boolean a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      if (paramInt >= this.o) {}
    }
    while (paramInt < this.jdField_p_of_type_Int)
    {
      return true;
      return false;
    }
    return false;
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
        JSONObject localJSONObject = localJSONArray.getJSONObject(i);
        String str = localJSONObject.getString("monitorPoint");
        if (b.d(str))
        {
          j localj = (j)this.jdField_p_of_type_JavaUtilMap.get(str);
          paramJSONObject = localj;
          if (localj == null)
          {
            paramJSONObject = new e(str, this.o, this.jdField_p_of_type_Int);
            this.jdField_p_of_type_JavaUtilMap.put(str, paramJSONObject);
          }
          paramJSONObject.b(localJSONObject);
        }
        i += 1;
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\d\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */