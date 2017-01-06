package com.example.testing.readlocalfile;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private File sdDir = Environment.getExternalStorageDirectory();
    private String partStr="AFi";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ini();
        getPath();
    }

    private File getPath() {
        File aFile = new File(sdDir, "AFile");
        if(!aFile.exists()){
           aFile.mkdirs();
        }
        return aFile;
    }

    private void ini() {
        Button deleteBtn = (Button) findViewById(R.id.btn_delete);
        deleteBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_delete:
                getDeletePath();
                FileUtils.deleteAllFiles(getDeletePath());
                Toast.makeText(this,"删除成功",Toast.LENGTH_SHORT).show();
        }
    }

    private File getDeletePath() {
        File file=null;
        String[] list = sdDir.list();
        for(int i=0;i<list.length;i++){
            if(list[i].contains(partStr)){
//                Toast.makeText(this,"包含AFile",Toast.LENGTH_SHORT).show();
                file = new File(sdDir, list[i]);
            }
        }
        return file;
    }
}
