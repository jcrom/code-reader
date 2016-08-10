package com.loopeer.codereader.sync;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class DownloadCompletedReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.hasExtra(DownloadManager.EXTRA_DOWNLOAD_ID)) {
            long downloadId = intent.getLongExtra(
                    DownloadManager.EXTRA_DOWNLOAD_ID, 0);
            if (downloadId > 0) {
                Intent i = new Intent(context, DownloadRepoService.class);
                i.putExtra(DownloadManager.EXTRA_DOWNLOAD_ID, downloadId);
                context.startService(i);
            }
        }
    }

}
