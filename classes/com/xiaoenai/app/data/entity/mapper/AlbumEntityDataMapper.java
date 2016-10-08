package com.xiaoenai.app.data.entity.mapper;

import com.xiaoenai.app.data.entity.album.AlbumCapacityEntity;
import com.xiaoenai.app.data.entity.album.AlbumEntity;
import com.xiaoenai.app.data.entity.album.AlbumGroupEntity;
import com.xiaoenai.app.data.entity.album.AlbumImageEntity;
import com.xiaoenai.app.database.bean.AlbumData;
import com.xiaoenai.app.domain.PhotoAlbum;
import com.xiaoenai.app.domain.internal.di.PerActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

@PerActivity
public class AlbumEntityDataMapper
{
  public int transform(AlbumCapacityEntity paramAlbumCapacityEntity)
  {
    return paramAlbumCapacityEntity.getUsed();
  }
  
  public List<PhotoAlbum> transform(AlbumEntity paramAlbumEntity)
  {
    ArrayList localArrayList1 = new ArrayList();
    paramAlbumEntity = paramAlbumEntity.getTimeLines();
    int k = paramAlbumEntity.size();
    int i = 0;
    while (i < k)
    {
      ArrayList localArrayList2 = ((AlbumGroupEntity)paramAlbumEntity.get(i)).getAlbumImageEntity();
      int m = localArrayList2.size();
      int j = 0;
      while (j < m)
      {
        PhotoAlbum localPhotoAlbum = new PhotoAlbum();
        localPhotoAlbum.setFeeling(((AlbumGroupEntity)paramAlbumEntity.get(i)).getFeeling());
        localPhotoAlbum.setUrl(((AlbumImageEntity)localArrayList2.get(j)).getUrl());
        localPhotoAlbum.setGroupId(Long.valueOf(((AlbumGroupEntity)paramAlbumEntity.get(i)).getGroupId()));
        localPhotoAlbum.setWidth(Integer.valueOf(((AlbumImageEntity)localArrayList2.get(j)).getWidth()));
        localPhotoAlbum.setCreatedTs(Long.valueOf(((AlbumGroupEntity)paramAlbumEntity.get(i)).getCreatedTs() * 1000L));
        localPhotoAlbum.setHeight(Integer.valueOf(((AlbumImageEntity)localArrayList2.get(j)).getHeight()));
        localPhotoAlbum.setId(Long.valueOf(((AlbumImageEntity)localArrayList2.get(j)).getId()));
        localPhotoAlbum.setIsOrigin(Boolean.valueOf(((AlbumImageEntity)localArrayList2.get(j)).getIsOrigin()));
        localPhotoAlbum.setSize(Integer.valueOf(((AlbumImageEntity)localArrayList2.get(j)).getSize()));
        localPhotoAlbum.setIsSelected(Boolean.valueOf(false));
        localPhotoAlbum.setIsDelete(Boolean.valueOf(false));
        localArrayList1.add(localPhotoAlbum);
        j += 1;
      }
      i += 1;
    }
    return localArrayList1;
  }
  
  public List<PhotoAlbum> transform(AlbumGroupEntity paramAlbumGroupEntity)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = paramAlbumGroupEntity.getAlbumImageEntity();
    int j = localArrayList2.size();
    int i = 0;
    while (i < j)
    {
      PhotoAlbum localPhotoAlbum = new PhotoAlbum();
      localPhotoAlbum.setFeeling(paramAlbumGroupEntity.getFeeling());
      localPhotoAlbum.setUrl(((AlbumImageEntity)localArrayList2.get(i)).getUrl());
      localPhotoAlbum.setGroupId(Long.valueOf(paramAlbumGroupEntity.getGroupId()));
      localPhotoAlbum.setWidth(Integer.valueOf(((AlbumImageEntity)localArrayList2.get(i)).getWidth()));
      localPhotoAlbum.setCreatedTs(Long.valueOf(paramAlbumGroupEntity.getCreatedTs() * 1000L));
      localPhotoAlbum.setHeight(Integer.valueOf(((AlbumImageEntity)localArrayList2.get(i)).getHeight()));
      localPhotoAlbum.setId(Long.valueOf(((AlbumImageEntity)localArrayList2.get(i)).getId()));
      localPhotoAlbum.setIsOrigin(Boolean.valueOf(((AlbumImageEntity)localArrayList2.get(i)).getIsOrigin()));
      localPhotoAlbum.setSize(Integer.valueOf(((AlbumImageEntity)localArrayList2.get(i)).getSize()));
      localPhotoAlbum.setIsSelected(Boolean.valueOf(false));
      localPhotoAlbum.setIsDelete(Boolean.valueOf(false));
      localArrayList1.add(localPhotoAlbum);
      i += 1;
    }
    return localArrayList1;
  }
  
  public List<AlbumData> transformToDB(List<PhotoAlbum> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      PhotoAlbum localPhotoAlbum = (PhotoAlbum)paramList.next();
      AlbumData localAlbumData = new AlbumData();
      localAlbumData.setWidth(localPhotoAlbum.getWidth());
      localAlbumData.setIsOrigin(localPhotoAlbum.getIsOrigin());
      localAlbumData.setId(localPhotoAlbum.getId());
      localAlbumData.setHeight(localPhotoAlbum.getHeight());
      localAlbumData.setSize(localPhotoAlbum.getSize());
      localAlbumData.setGroupId(localPhotoAlbum.getGroupId());
      localAlbumData.setUrl(localPhotoAlbum.getUrl());
      localAlbumData.setFeeling(localPhotoAlbum.getFeeling());
      localAlbumData.setCreatedTs(localPhotoAlbum.getCreatedTs());
      localArrayList.add(localAlbumData);
    }
    return localArrayList;
  }
  
  public List<AlbumData> transformToDB(String[] paramArrayOfString)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      AlbumData localAlbumData = new AlbumData();
      localAlbumData.setId(Long.valueOf(paramArrayOfString[i]));
      localArrayList.add(localAlbumData);
      i += 1;
    }
    return localArrayList;
  }
  
  public List<PhotoAlbum> transformToModule(List<AlbumData> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      AlbumData localAlbumData = (AlbumData)paramList.next();
      PhotoAlbum localPhotoAlbum = new PhotoAlbum();
      localPhotoAlbum.setWidth(localAlbumData.getWidth());
      localPhotoAlbum.setIsOrigin(localAlbumData.getIsOrigin());
      localPhotoAlbum.setId(localAlbumData.getId());
      localPhotoAlbum.setHeight(localAlbumData.getHeight());
      localPhotoAlbum.setSize(localAlbumData.getSize());
      localPhotoAlbum.setGroupId(localAlbumData.getGroupId());
      localPhotoAlbum.setUrl(localAlbumData.getUrl());
      localPhotoAlbum.setFeeling(localAlbumData.getFeeling());
      localPhotoAlbum.setCreatedTs(localAlbumData.getCreatedTs());
      localPhotoAlbum.setIsSelected(Boolean.valueOf(false));
      localPhotoAlbum.setIsDelete(Boolean.valueOf(false));
      localArrayList.add(localPhotoAlbum);
    }
    return localArrayList;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\data\entity\mapper\AlbumEntityDataMapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */