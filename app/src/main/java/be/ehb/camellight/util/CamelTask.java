package be.ehb.camellight.util;

import android.os.AsyncTask;
import android.widget.ProgressBar;

import java.lang.ref.WeakReference;
import java.util.Random;

/**
 * Created by Banaan on 20/01/2038. ;)
 */
public class CamelTask extends AsyncTask<Void, Integer, Void> {

    private WeakReference<ProgressBar> pb;

    public CamelTask(ProgressBar pb) {
        this.pb = new WeakReference<>(pb);
    }

    @Override
    protected Void doInBackground(Void... voids) {
        Random rand = new Random();

        for (int i = 0; i <= 20 ; i++) {
            try {
                Thread.sleep(rand.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            publishProgress(i);
        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        pb.get().setProgress(values[0]);
    }
}
