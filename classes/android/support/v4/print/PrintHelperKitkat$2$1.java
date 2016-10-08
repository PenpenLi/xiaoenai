package android.support.v4.print;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.CancellationSignal;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter.LayoutResultCallback;
import android.print.PrintDocumentInfo.Builder;
import java.io.FileNotFoundException;

class PrintHelperKitkat$2$1
  extends AsyncTask<Uri, Boolean, Bitmap>
{
  PrintHelperKitkat$2$1(PrintHelperKitkat.2 param2, CancellationSignal paramCancellationSignal, PrintAttributes paramPrintAttributes1, PrintAttributes paramPrintAttributes2, PrintDocumentAdapter.LayoutResultCallback paramLayoutResultCallback) {}
  
  protected Bitmap doInBackground(Uri... paramVarArgs)
  {
    try
    {
      paramVarArgs = PrintHelperKitkat.access$300(this.this$1.this$0, this.this$1.val$imageFile, 3500);
      return paramVarArgs;
    }
    catch (FileNotFoundException paramVarArgs) {}
    return null;
  }
  
  protected void onCancelled(Bitmap paramBitmap)
  {
    this.val$layoutResultCallback.onLayoutCancelled();
    this.this$1.mLoadBitmap = null;
  }
  
  protected void onPostExecute(Bitmap paramBitmap)
  {
    boolean bool = true;
    super.onPostExecute(paramBitmap);
    this.this$1.mBitmap = paramBitmap;
    if (paramBitmap != null)
    {
      paramBitmap = new PrintDocumentInfo.Builder(this.this$1.val$jobName).setContentType(1).setPageCount(1).build();
      if (!this.val$newPrintAttributes.equals(this.val$oldPrintAttributes)) {
        this.val$layoutResultCallback.onLayoutFinished(paramBitmap, bool);
      }
    }
    for (;;)
    {
      this.this$1.mLoadBitmap = null;
      return;
      bool = false;
      break;
      this.val$layoutResultCallback.onLayoutFailed(null);
    }
  }
  
  protected void onPreExecute()
  {
    this.val$cancellationSignal.setOnCancelListener(new PrintHelperKitkat.2.1.1(this));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v4\print\PrintHelperKitkat$2$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */