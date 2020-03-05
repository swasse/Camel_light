package be.ehb.camellight;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import be.ehb.camellight.util.CamelTask;

public class MainActivity extends AppCompatActivity {

    private ProgressBar p1, p2, p3;
    private Button btn;
    private View.OnClickListener goListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            CamelTask ct1 = new CamelTask(p1);
            CamelTask ct2 = new CamelTask(p2);
            CamelTask ct3 = new CamelTask(p3);

            ct1.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
            ct2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
            ct3.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        p1 = findViewById(R.id.camel_wan);
        p2 = findViewById(R.id.camel_toe);
        p3 = findViewById(R.id.camel_tree);

        btn = findViewById(R.id.btn_run);
        btn.setOnClickListener(goListener);
    }
}
