package saphoracle.application.com;

import android.content.pm.PackageManager;
import android.graphics.Color;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

public class MyActivity extends AppCompatActivity {

    private Camera camera = Camera.open();

    private RelativeLayout layout;

    private Switch swtToggle;
    private TextView tvToggle;
    private ImageView ivArrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        layout = (RelativeLayout) findViewById(R.id.layout);
        swtToggle = (Switch) findViewById(R.id.swtToggle);
        tvToggle = (TextView) findViewById(R.id.tvToggle);
        ivArrow = (ImageView) findViewById(R.id.imageView);

        swtToggle.setChecked(false);
        tvToggle.setText("I am currently off");

        swtToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ivArrow.getVisibility() == View.VISIBLE)
                    ivArrow.setVisibility(View.INVISIBLE);
                if (swtToggle.isChecked()) {
                    tvToggle.setText("I am currently on");
                    layout.setBackgroundColor(Color.YELLOW);
                    if (getPackageManager().hasSystemFeature
                            (PackageManager.FEATURE_CAMERA_FLASH)) {
                        Camera.Parameters param = camera.getParameters();
                        param.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                        camera.setParameters(param);
                        camera.startPreview();
                        tvToggle.setText("Torch is now on");
                    }
                } else {
                    tvToggle.setText("I am currently off");
                    layout.setBackgroundColor(Color.DKGRAY);
                    if (getPackageManager().hasSystemFeature
                            (PackageManager.FEATURE_CAMERA_FLASH)) {
                        camera.stopPreview();
                        camera.release();
                    }
                }

            }
        });

    }


}
