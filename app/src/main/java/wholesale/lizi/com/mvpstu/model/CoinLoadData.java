package wholesale.lizi.com.mvpstu.model;

import java.util.ArrayList;
import java.util.List;

import wholesale.lizi.com.mvpstu.bean.CoinBean;

/**
 * Created by admin on 2017/2/7.
 */

public class CoinLoadData implements CoinModel {
    @Override
    public void loadCoin(CoinOnLoadListener listener) {
        List<CoinBean> coins=new ArrayList<CoinBean>();
        for (int i=0;i<10;i++){
            CoinBean coin=new CoinBean();
            coin.setDrivecoinnum(i+"");
            coin.setOperationdate("2017-2-4 17:03:40");
            coin.setRemark("每天首次发表话题赠送"+i+"驾币");

            coins.add(coin);
        }
        listener.onComplete(coins);
    }
}
