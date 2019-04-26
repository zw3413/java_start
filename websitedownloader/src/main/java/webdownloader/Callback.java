package webdownloader;

/**
 * Created by Dajavu on 20/04/2017.
 */

public interface Callback {
    void onDownloadFinished();
    void onDownloadFailed();
}
