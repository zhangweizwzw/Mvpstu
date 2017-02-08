package wholesale.lizi.com.mvpstu.presenter;

import java.util.List;

import wholesale.lizi.com.mvpstu.bean.CoinBean;
import wholesale.lizi.com.mvpstu.model.CoinLoadData;
import wholesale.lizi.com.mvpstu.model.CoinModel;
import wholesale.lizi.com.mvpstu.view.CoinView;

/**
 * Created by admin on 2017/2/7.
 */

public class CoinPresenter {
    //view
    CoinView mCoinView;
    //model
    CoinModel mCoinModel=new CoinLoadData();

    /**
     * 构造方法实例化view
     * @param mCoinView
     */
    public CoinPresenter(CoinView mCoinView) {
        super();
        this.mCoinView = mCoinView;
    }

    //绑定view和model
    public void fetch(){
        if(mCoinModel!=null){
            mCoinModel.loadCoin(new CoinModel.CoinOnLoadListener() {
                @Override
                public void onComplete(List<CoinBean> coins) {
                    mCoinView.showCoins(coins);
                }
            });

        }
    }
}
