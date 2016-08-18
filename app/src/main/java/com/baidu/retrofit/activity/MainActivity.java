package com.baidu.retrofit.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.baidu.retrofit.Constant;
import com.baidu.retrofit.R;
import com.baidu.retrofit.bean.FamousInfo;
import com.baidu.retrofit.bean.FamousInfoReq;
import com.baidu.retrofit.model.FamousInfoModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

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

        Log.d(TAG,"onclick");
        if(view.getId() == R.id.button_search) {

            famousInfoModel.queryLookUp(initParams()).enqueue(new Callback<FamousInfo>() {
                @Override
                public void onResponse(Call<FamousInfo> call, Response<FamousInfo> response) {

                    FamousInfo result = response.body();
                    if(null != result) {
                        List<FamousInfo.ResultEntity> entity = result.getResult();
                        mTxtContent.setText("1、"+entity.get(0).getFamous_saying()+"\n---"+entity.get(0).getFamous_name()+"\n 2、"
                                +entity.get(1).getFamous_saying()+"\n---"+entity.get(1).getFamous_name());
                    }

                }

                @Override
                public void onFailure(Call<FamousInfo> call, Throwable t) {

                }
            });



        }
    }

    private FamousInfoReq initParams() {
        FamousInfoReq mFamousInfoReq=null;
        mFamousInfoReq= new FamousInfoReq();
        mFamousInfoReq.apiKey= Constant.APIKEY;
        mFamousInfoReq.keyword =mEditKeyWord.getText().toString();
        mFamousInfoReq.page=1;
        mFamousInfoReq.rows=5;
        return  mFamousInfoReq;

    }

    private List list = new ArrayList();

    private void initData(){
        for (int i = 0; i < 90; i++) {
            list.add(i);
        }
    }


    private List getData(int position) {
        return list.subList(position,position+10);
    }
}
