package com.alibaba.mtl.appmonitor.d;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.mtl.appmonitor.f.b;
import java.util.Map;

public class f
  extends h
{
  String TAG = "AlarmSampling";
  private int o;
  private int p = 0;
  
  public f(com.alibaba.mtl.appmonitor.a.f paramf, int paramInt)
  {
    super(paramf, paramInt);
    this.jdField_o_of_type_Int = 0;
    this.jdField_o_of_type_Int = paramInt;
    this.p = paramInt;
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    this.jdField_o_of_type_Int = this.n;
    this.p = this.n;
    Integer localInteger = paramJSONObject.getInteger("successSampling");
    if (localInteger != null) {
      this.jdField_o_of_type_Int = localInteger.intValue();
    }
    paramJSONObject = paramJSONObject.getInteger("failSampling");
    if (paramJSONObject != null) {
      this.p = paramJSONObject.intValue();
    }
  }
  
  public boolean a(int paramInt, String paramString1, String paramString2, Boolean paramBoolean, Map<String, String> paramMap)
  {
    boolean bool = true;
    com.alibaba.mtl.log.e.i.a(this.TAG, new Object[] { "samplingSeed:", Integer.valueOf(paramInt), "isSuccess:", paramBoolean, "successSampling:", Integer.valueOf(this.jdField_o_of_type_Int), "failSampling:" + this.p });
    if (this.jdField_o_of_type_JavaUtilMap != null)
    {
      paramString1 = (i)this.jdField_o_of_type_JavaUtilMap.get(paramString1);
      if ((paramString1 != null) && ((paramString1 instanceof d))) {
        return ((d)paramString1).a(paramInt, paramString2, paramBoolean, paramMap);
      }
    }
    if (paramBoolean.booleanValue()) {
      return paramInt < this.jdField_o_of_type_Int;
    }
    if (paramInt < this.p) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public void b(JSONObject paramJSONObject)
  {
    a(paramJSONObject);
    c(paramJSONObject);
    this.jdField_o_of_type_JavaUtilMap.clear();
    JSONArray localJSONArray = paramJSONObject.getJSONArray("metrics");
    if (localJSONArray != null)
    {
      int i = 0;
      while (i < localJSONArray.size())
      {
        JSONObject localJSONObject = localJSONArray.getJSONObject(i);
        String str = localJSONObject.getString("module");
        if (b.d(str))
        {
          i locali = (i)this.jdField_o_of_type_JavaUtilMap.get(str);
          paramJSONObject = locali;
          if (locali == null)
          {
            paramJSONObject = new d(str, this.jdField_o_of_type_Int, this.p);
            this.jdField_o_of_type_JavaUtilMap.put(str, paramJSONObject);
          }
          paramJSONObject.b(localJSONObject);
        }
        i += 1;
      }
    }
  }
  
  public void setSampling(int paramInt)
  {
    super.setSampling(paramInt);
    this.jdField_o_of_type_Int = paramInt;
    this.p = paramInt;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\d\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */