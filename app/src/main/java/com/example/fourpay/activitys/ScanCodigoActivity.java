package com.example.fourpay.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.navigation.fragment.NavHostFragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.fourpay.R;
import com.example.fourpay.databinding.ActivityScanCodigoBinding;
import com.example.fourpay.fragments.HomeFragment;

public class ScanCodigoActivity extends AppCompatActivity {

    private static final int CAMERA_PERMISSION_CODE = 1;

    private ActivityScanCodigoBinding binding = null;

    private Camera mCamera;
    private CameraPreview mPreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityScanCodigoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        requestCameraPermission();

        binding.voltar.setOnClickListener(view -> {
            finish();
        });
    }

    private void openCamera() {
        // Create an instance of Camera
        mCamera = getCameraInstance();

        // Create our Preview view and set it as the content of our activity.
        mPreview = new CameraPreview(this, mCamera);
        FrameLayout preview = (FrameLayout) findViewById(R.id.previeww);
        preview.addView(mPreview);
    }

    private void requestCameraPermission() {
        ActivityCompat.requestPermissions(
                this,
                new String[]{Manifest.permission.CAMERA}, CAMERA_PERMISSION_CODE);
    }

    public static Camera getCameraInstance() {
        Camera c = null;
        try {
            c = Camera.open(); // attempt to get a Camera instance
        } catch (Exception e) {
            // Camera is not available (in use or does not exist)
        }
        return c; // returns null if camera is unavailable
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == CAMERA_PERMISSION_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permissão OK", Toast.LENGTH_SHORT).show();
                openCamera();
            } else {
                Toast.makeText(this, "Permissão obrigatória", Toast.LENGTH_SHORT).show();
                requestCameraPermission();
            }
        }
    }
}