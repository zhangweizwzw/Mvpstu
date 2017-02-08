package wholesale.lizi.com.mvpstu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import wholesale.lizi.com.mvpstu.adapter.CoinAdapter;
import wholesale.lizi.com.mvpstu.bean.CoinBean;
import wholesale.lizi.com.mvpstu.presenter.CoinPresenter;
import wholesale.lizi.com.mvpstu.view.CoinView;
import wholesale.lizi.com.mvpstu.widget.RecycleViewDivider;

public class MainActivity extends AppCompatActivity implements CoinView{
    private RecyclerView mRecycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecycleView = (RecyclerView) findViewById(R.id.coinRecycle);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));
        mRecycleView.setHasFixedSize(true);
        /**
         * 添加分割线
         */
        //添加默认分割线：高度为2px，颜色为灰色
        // mRecycleView.addItemDecoration(new RecycleViewDivider(this, LinearLayoutManager.HORIZONTAL))
        //添加自定义分割线：可自定义分割线drawable
        //mRecycleView.addItemDecoration(new RecycleViewDivider(this, LinearLayoutManager.HORIZONTAL, R.drawable.divider_recyclerview));
        //添加自定义分割线：可自定义分割线高度和颜色(有bug)
        mRecycleView.addItemDecoration(new RecycleViewDivider(this, LinearLayoutManager.HORIZONTAL, 2, getResources().getColor(R.color.colorBlack)));


        new CoinPresenter(this).fetch();

    }

    @Override
    public void showCoins(List<CoinBean> coins) {
        Toast.makeText(this,coins.size()+"",Toast.LENGTH_SHORT).show();
        mRecycleView.setAdapter(new CoinAdapter(this,coins));
    }
}
