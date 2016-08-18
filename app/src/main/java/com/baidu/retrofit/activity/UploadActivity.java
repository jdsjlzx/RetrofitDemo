package com.baidu.retrofit.activity;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.baidu.retrofit.R;
import com.baidu.retrofit.bean.HttpResponse;
import com.baidu.retrofit.model.FamousInfoModel;
import com.baidu.retrofit.model.IpInfoRxModel;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class UploadActivity extends AppCompatActivity implements View.OnClickListener{

    public final String TAG= this.getClass().getName();
    private FamousInfoModel famousInfoModel;

    @BindView(R.id.edit_keyword)
    EditText mEditKeyWord;
    @BindView(R.id.button_search)
    Button mSerachBtn;
    @BindView(R.id.txt_content)
    TextView mTxtContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();

        famousInfoModel = FamousInfoModel.getInstance(this);
    }

    /**
     * 初始化View
     */
    private void initView() {

    }

    @Override
    @OnClick({ R.id.button_search })
    public void onClick(View view) {

        if(view.getId() == R.id.button_search) {
            String path = Environment.getExternalStorageDirectory() + File.separator + "test.png";
            String path2 = Environment.getExternalStorageDirectory() + File.separator + "test.jpg";

            ArrayList<String> paths = new ArrayList<>();
            paths.add(path);
            paths.add(path2);

            Map<String,RequestBody> photos = new HashMap<>();

            if (paths.size() > 0) {
                for (int i = 0; i < paths.size(); i++) {
                    File file = new File(paths.get(i));
                    Log.e("lzx",file.getName());
                    photos.put("file" + i + "\"; filename=\"" + file.getName(), RequestBody.create(MediaType.parse("image/png"), file));
                }
            }

            IpInfoRxModel.getInstance(this).uploadFile("jdsjlzx",photos)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<HttpResponse<String>>() {
                        @Override
                        public void onCompleted() {
                            Log.e("lzx","onCompleted");
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.e("lzx","onError " + e.toString());
                        }

                        @Override
                        public void onNext(HttpResponse<String> response) {
                            Log.e("lzx","onNext");

                        }
                    });


        }
    }


}
