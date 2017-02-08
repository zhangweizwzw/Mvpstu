package wholesale.lizi.com.mvpstu.model;

import java.util.List;

import wholesale.lizi.com.mvpstu.bean.CoinBean;

/**
 * Created by admin on 2017/2/7.
 */

public interface CoinModel {

    void loadCoin(CoinOnLoadListener listener);

    interface  CoinOnLoadListener{
        void onComplete(List<CoinBean> coins);
    }
}
