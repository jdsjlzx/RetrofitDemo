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
import com.baidu.retrofit.model.IpInfoModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IpInfoActivity extends AppCompatActivity implements View.OnClickListener{

    public final String TAG= this.getClass().getName();
    private IpInfoModel infoModel;

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

        infoModel = IpInfoModel.getInstance(this);
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

            infoModel.queryIpInfo(mEditKeyWord.getText().toString()).enqueue(new Callback<IpInfo>() {
                @Override
                public void onResponse(Call<IpInfo> call, Response<IpInfo> response) {
                    if(response.isSuccess()) {
                        IpInfo result = response.body();
                        if(null != result) {
                            Log.d(TAG,"code " + result.code);

                            IpInfo.Info entity = result.data;
                            Log.d(TAG,"entity " + entity.toString());
                            mTxtContent.setText("county : " + entity.country);
                        }
                    }
                }

                @Override
                public void onFailure(Call<IpInfo> call, Throwable t) {

                }
            });
        }
    }

}
