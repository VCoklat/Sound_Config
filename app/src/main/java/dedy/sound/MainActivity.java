package dedy.sound;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends Activity {
    Button b;
    TextView t;
    SeekBar s;
    EditText e;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = (Button)findViewById(R.id.button1);
        s = (SeekBar)findViewById(R.id.seekBar1);
        e = (EditText)findViewById(R.id.editText1);

        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                finish();
            }
        });
        final AudioManager audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        int a = audioManager.getStreamMaxVolume(AudioManager.STREAM_RING);
        int c = audioManager.getStreamVolume(AudioManager.STREAM_RING);
        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                audioManager.setStreamVolume(AudioManager.STREAM_RING, (int)(Integer.parseInt(e.getText().toString().trim())), 0);
                s.setProgress((int)(Integer.parseInt(e.getText().toString().trim())));
            }
        });

        s.setMax(a);
        s.setProgress(c);
        e.setText(""+c);
        s.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar arg0) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar arg0) {
            }

            @Override
            public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
                audioManager.setStreamVolume(AudioManager.STREAM_RING, arg1, 0);
                e.setText(""+s.getProgress());
            }
        });
    }
}