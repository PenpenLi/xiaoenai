package com.xiaoenai.app.model.album;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PhotoImageList
{
  private static PhotoImageList instance = null;
  private com.xiaoenai.app.d.a db = new com.xiaoenai.app.d.a();
  private ArrayList<Photo> photosList = new ArrayList();
  
  public static PhotoImageList getInstance()
  {
    if (instance == null) {}
    try
    {
      instance = new PhotoImageList();
      return instance;
    }
    finally {}
  }
  
  public static void release()
  {
    instance = null;
  }
  
  public void addPhoto(Photo paramPhoto)
  {
    com.xiaoenai.app.utils.f.a.c("====={} {}", new Object[] { Integer.valueOf(paramPhoto.getId()), Integer.valueOf(paramPhoto.getCreateAt()) });
    if (!this.photosList.contains(paramPhoto))
    {
      this.photosList.add(paramPhoto);
      this.db.a(paramPhoto);
    }
  }
  
  public void addPhoto(Photo paramPhoto, int paramInt)
  {
    if (!this.photosList.contains(paramPhoto))
    {
      this.photosList.add(0, paramPhoto);
      this.db.a(paramPhoto);
    }
  }
  
  public void clearPhotos()
  {
    this.photosList.clear();
    this.db.a();
  }
  
  public void delPhotos(List<Photo> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      removePhoto((Photo)paramList.next());
    }
  }
  
  public Photo getPhoto(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.photosList.size())) {
      return (Photo)this.photosList.get(paramInt);
    }
    return null;
  }
  
  public int getPhotoLength()
  {
    return this.photosList.size();
  }
  
  public final ArrayList<Photo> getPhotoList()
  {
    return this.photosList;
  }
  
  public void loadPhotosFromDB()
  {
    this.photosList.addAll(this.db.b());
  }
  
  public void removePhoto(int paramInt)
  {
    Photo localPhoto = getPhoto(paramInt);
    if (localPhoto != null) {
      removePhoto(localPhoto);
    }
  }
  
  public void removePhoto(Photo paramPhoto)
  {
    this.photosList.remove(paramPhoto);
    this.db.c(paramPhoto);
  }
  
  public int size()
  {
    return this.photosList.size();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\model\album\PhotoImageList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */