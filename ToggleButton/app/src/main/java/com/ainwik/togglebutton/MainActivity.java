package com.ainwik.togglebutton;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity
{
        ToggleButton tb;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tb=findViewById(R.id.toggleButton);
        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    torch(true);
                    Toast.makeText(MainActivity.this, "Torch On", Toast.LENGTH_SHORT).show();
                    tb.setBackgroundResource(R.drawable.on_icon);
                }
                else
                {
                    torch(false);
                    Toast.makeText(MainActivity.this, "Torch Off", Toast.LENGTH_SHORT).show();
                    tb.setBackgroundResource(R.drawable.off_icon);
                }
            }
        });

    }

    public void torch(boolean mode)
    {
        try
        {
            CameraManager cm=(CameraManager) getSystemService(CAMERA_SERVICE);
            String cameraid = cm.getCameraIdList()[0];
            cm.setTorchMode(cameraid,mode);
        }
        catch (Exception e)
        {

        }
    }
}