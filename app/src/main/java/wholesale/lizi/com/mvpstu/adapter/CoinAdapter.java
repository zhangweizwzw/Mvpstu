package wholesale.lizi.com.mvpstu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import wholesale.lizi.com.mvpstu.R;
import wholesale.lizi.com.mvpstu.bean.CoinBean;

/**
 * Created by WuXiaolong on 2015/7/2.
 */
public class CoinAdapter extends RecyclerView.Adapter<CoinAdapter.ViewHolder> {

    private Context mContext;
    private List<CoinBean> dataList;

    public List<CoinBean> getDataList() {
        return dataList;
    }

    public void removeAllDataList() {
        this.dataList.removeAll(dataList);
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public CoinAdapter(Context context, List<CoinBean> dataList) {
        this.dataList = dataList;
        mContext = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tcoin;

        public ViewHolder(View itemView) {
            super(itemView);
            tcoin = (TextView) itemView.findViewById(R.id.tcoin);
//                ButterKnife.inject(this, view);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.coin_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.tcoin.setText(dataList.get(position).getRemark());
        if (onItemClickListener != null) {
            holder.tcoin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getLayoutPosition();
                    onItemClickListener.onItemClick(holder.itemView, position);
                }
            });

            holder.tcoin.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int position = holder.getLayoutPosition();
                    onItemClickListener.onItemLongClick(holder.itemView, position);
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

}