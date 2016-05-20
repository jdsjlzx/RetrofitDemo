package com.baidu.retrofit.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.baidu.retrofit.R;
import com.baidu.retrofit.bean.IpInfo;
import com.baidu.retrofit.model.IpInfoRxModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class IpInfoRxAndroidActivity extends AppCompatActivity implements View.OnClickListener{

    public final String TAG= this.getClass().getName();
    private IpInfoRxModel infoModel;

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

        infoModel = IpInfoRxModel.getInstance(this);
    }

    /**
     * 初始化View
     */
    private void initView() {
        mEditKeyWord.setText("63.223.108.42");
    }

    @Override
    @OnClick({ R.id.button_search })
    public void onClick(View view) {

        Log.d(TAG,"onclick");
        if(view.getId() == R.id.button_search) {

            infoModel.queryIpInfo("63.223.108.42")
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<IpInfo>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onNext(IpInfo ipInfo) {
                            IpInfo.Info entity = ipInfo.data;
                            Log.d(TAG,"entity " + entity.toString());
                            mTxtContent.setText("county : " + entity.country);
                        }
                    });

        }
    }

}
