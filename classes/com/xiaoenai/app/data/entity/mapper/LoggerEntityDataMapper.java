package com.xiaoenai.app.data.entity.mapper;

import com.xiaoenai.app.database.bean.LogEntity;
import com.xiaoenai.app.domain.d;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class LoggerEntityDataMapper
{
  public List<d> transform(List<LogEntity> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramList.size();
    if (j > 0)
    {
      int i = 0;
      while (i < j)
      {
        d locald = new d();
        locald.a(((LogEntity)paramList.get(i)).getMessage());
        locald.a(((LogEntity)paramList.get(i)).getPriority().intValue());
        locald.a(((LogEntity)paramList.get(i)).getTs().longValue());
        localArrayList.add(locald);
        i += 1;
      }
    }
    return localArrayList;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\data\entity\mapper\LoggerEntityDataMapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */