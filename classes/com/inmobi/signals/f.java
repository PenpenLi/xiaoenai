package com.inmobi.signals;

import com.inmobi.commons.core.network.NetworkRequest;
import com.inmobi.commons.core.network.NetworkRequest.RequestType;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

public class f
  extends NetworkRequest
{
  private int d;
  private int e;
  private c f;
  private List<d> g;
  
  public f(String paramString, int paramInt1, int paramInt2, com.inmobi.commons.core.utilities.uid.d paramd, List<d> paramList, c paramc)
  {
    super(NetworkRequest.RequestType.POST, paramString, true, paramd);
    this.d = paramInt1;
    this.e = paramInt2;
    this.g = paramList;
    this.f = paramc;
    this.c.put("req_id", this.f.c());
    this.c.put("i_till", Integer.toString(this.f.d()));
    this.c.put("p_a_apps", d());
  }
  
  private String d()
  {
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    while (i < this.g.size())
    {
      localJSONArray.put(((d)this.g.get(i)).b());
      i += 1;
    }
    return localJSONArray.toString();
  }
  
  public int b()
  {
    return this.d;
  }
  
  public int c()
  {
    return this.e;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\signals\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */