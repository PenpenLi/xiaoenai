package com.xiaoenai.app.feature.photoalbum.d.a.a;

import com.xiaoenai.app.common.internal.di.a.a;
import com.xiaoenai.app.domain.internal.di.PerActivity;
import com.xiaoenai.app.feature.photoalbum.preview.PhotoPreviewActivity;
import com.xiaoenai.app.feature.photoalbum.view.activity.PhotoAlbumActivity;
import com.xiaoenai.app.feature.photoalbum.view.activity.PostPhotoActivity;
import dagger.Component;

@PerActivity
@Component
public abstract interface y
  extends a
{
  public abstract void a(PhotoPreviewActivity paramPhotoPreviewActivity);
  
  public abstract void a(PhotoAlbumActivity paramPhotoAlbumActivity);
  
  public abstract void a(PostPhotoActivity paramPostPhotoActivity);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\feature\photoalbum\d\a\a\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */