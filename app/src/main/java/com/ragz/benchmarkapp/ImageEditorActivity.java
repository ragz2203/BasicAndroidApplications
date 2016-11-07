package com.ragz.benchmarkapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;

public class ImageEditorActivity extends AppCompatActivity {

    Bitmap originalImage;
    Button btnGrayScale;
    Button btnSepia, btnBW, btnSat;

    private static final int CAMERA_REQUEST = 1888;
    private ImageView imageView;
    private int PICK_IMAGE_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_editor);

        imageView = (ImageView) findViewById(R.id.imageView);
        btnGrayScale = (Button) findViewById(R.id.btnGrayScale);
        btnGrayScale.setAlpha(0);
        btnGrayScale.setEnabled(false);

        btnSepia = (Button) findViewById(R.id.btnSepia);
        btnSepia.setAlpha(0);
        btnSepia.setEnabled(false);

        btnBW = (Button) findViewById(R.id.btnBW);
        btnBW.setAlpha(0);
        btnBW.setEnabled(false);

        btnSat = (Button) findViewById(R.id.btnSat);
        btnSat.setAlpha(0);
        btnSat.setEnabled(false);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(bitmap);
            Effects();
            Button();
        }

        else
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {

            Uri uri = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                ImageView imageView = (ImageView) findViewById(R.id.imageView);
                imageView.setImageBitmap(bitmap);
                Effects();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Button();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.image_effect_menu, menu);
        return true;
    }

    public void Button(){
        btnGrayScale.setAlpha(1);
        btnGrayScale.setEnabled(true);

        btnSepia.setAlpha(1);
        btnSepia.setEnabled(true);

        btnBW.setAlpha(1);
        btnBW.setEnabled(true);

        btnSat.setAlpha(1);
        btnSat.setEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.camera_id:
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
                break;

            case R.id.gallery_id:
                Intent galleryintent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                galleryintent.setType("image/*");

                startActivityForResult(Intent.createChooser(galleryintent, "Select Picture"), PICK_IMAGE_REQUEST);
                break;

        }
        return true;
    }


    public void Effects(){
        //imageView.setDrawingCacheEnabled(false);
                /*imageView.measure(
                        View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                        View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
                imageView.layout(0, 0, imageView.getMeasuredWidth(), imageView.getMeasuredHeight());*/

        imageView.buildDrawingCache(false);


        originalImage = Bitmap.createBitmap(imageView.getDrawingCache());
        imageView.setDrawingCacheEnabled(false);
    }


    public void doImageProcessing(View view) {
        switch (view.getId()) {
            case R.id.btnGrayScale:
                Bitmap grayImage = toGrayScale(originalImage);
                imageView.setImageBitmap(grayImage);
                break;

            case R.id.btnSepia:
                Bitmap sepia = toSepia(originalImage);
                imageView.setImageBitmap(sepia);
                break;

            case R.id.btnBW:
                Bitmap BW = toBW(originalImage);
                imageView.setImageBitmap(BW);
                break;

            case R.id.btnSat:
                Bitmap saturation = toSaturation(originalImage);
                imageView.setImageBitmap(saturation);
                break;
        }
    }

    private Bitmap toGrayScale(Bitmap originalImage) {

        int width, height;
        height = originalImage.getHeight();
        width = originalImage.getWidth();

        Bitmap bmpGrayscale = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        Canvas c = new Canvas(bmpGrayscale);
        Paint paint = new Paint();
        ColorMatrix cm = new ColorMatrix();
        cm.setSaturation(0);
        ColorMatrixColorFilter f = new ColorMatrixColorFilter(cm);
        paint.setColorFilter(f);
        c.drawBitmap(originalImage, 0, 0, paint);
        return bmpGrayscale;
    }

    public Bitmap toBW(Bitmap bitmapOriginal) {
        int width, height;
        height = bitmapOriginal.getHeight();
        width = bitmapOriginal.getWidth();
        Bitmap bmpMonochrome = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bmpMonochrome);
        ColorMatrix ma = new ColorMatrix();
        ma.setSaturation(0);
        ma.setSaturation(2);
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(ma));
        canvas.drawBitmap(bitmapOriginal,0,0,paint);
        return bmpMonochrome;
    }
    public Bitmap toSaturation(Bitmap bitmapOriginal) {
        int width, height;
        height = bitmapOriginal.getHeight();
        width = bitmapOriginal.getWidth();
        Bitmap bmpMonochrome = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bmpMonochrome);
        ColorMatrix ma = new ColorMatrix();
        ma.setSaturation(2);
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(ma));
        canvas.drawBitmap(bitmapOriginal,0,0,paint);
        return bmpMonochrome;
    }

    public Bitmap toSepia(Bitmap bmpOriginal) {

        float[] sepMat = {
                0.3930000066757202f,
                0.7689999938011169f,
                0.1889999955892563f,
                0,
                0,
                0.3490000069141388f,
                0.6859999895095825f,
                0.1679999977350235f,
                0,
                0,
                0.2720000147819519f,
                0.5339999794960022f,
                0.1309999972581863f,
                0,
                0,
                0,
                0,
                0,
                1,
                0,
                0,
                0,
                0,
                0,
                1,0,0,0,0,1,1,1,1};

        ColorMatrix sepiaMatrix = new ColorMatrix();
        sepiaMatrix.set(sepMat);

        ColorMatrixColorFilter colorFilter = new ColorMatrixColorFilter(sepiaMatrix);
        Bitmap rBitmap = bmpOriginal.copy(Bitmap.Config.ARGB_8888, true);

        Paint paint = new Paint();
        paint.setColorFilter(colorFilter);

        Canvas myCanvas = new Canvas(rBitmap);
        myCanvas.drawBitmap(rBitmap, 0, 0, paint);
        return rBitmap;
    }

}
