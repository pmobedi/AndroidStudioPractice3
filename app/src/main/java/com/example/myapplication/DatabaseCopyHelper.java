package com.example.myapplication;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DatabaseCopyHelper {
    private static final String TAG = "DatabaseCopyHelper";
    private Context context;
    private static final String DATABASE_NAME = "Bus.db"; // نام صحیح پایگاه داده

    public DatabaseCopyHelper(Context context) {
        this.context = context;
    }

    public void copyDatabase() {
        File dbFile = context.getDatabasePath(DATABASE_NAME);

        if (!dbFile.exists()) {
            Log.d(TAG, "Database file does not exist. Copying from assets...");

            // Make sure the database path exists, if not create it
            File dbDir = dbFile.getParentFile();
            if (!dbDir.exists()) {
                dbDir.mkdirs();
            }

            try {
                InputStream inputStream = context.getAssets().open(DATABASE_NAME);
                OutputStream outputStream = new FileOutputStream(dbFile);

                byte[] buffer = new byte[1024];
                int length;
                while ((length = inputStream.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, length);
                }

                outputStream.flush();
                outputStream.close();
                inputStream.close();

                Log.d(TAG, "Database copied successfully to " + dbFile.getAbsolutePath());
            } catch (IOException e) {
                Log.e(TAG, "Error copying database", e);
            }
        } else {
            Log.d(TAG, "Database already exists. No need to copy.");
        }
    }
}
