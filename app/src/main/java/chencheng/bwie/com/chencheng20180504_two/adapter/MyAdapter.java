package chencheng.bwie.com.chencheng20180504_two.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import chencheng.bwie.com.chencheng20180504_two.R;
import chencheng.bwie.com.chencheng20180504_two.bean.ProuductsBean;

/**
 * Created by dell on 2018/5/4.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
   private Context context;
   private List<ProuductsBean.DataBean> list;
     OnClickfl onClickfl;
    public interface OnClickfl{
        void onClickxq(int position);
    }

    public void setOnclickSpflAdpter(OnClickfl onClickfl) {
        this.onClickfl = onClickfl;
    }

    public MyAdapter(Context context, List<ProuductsBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(context).inflate(R.layout.list_item,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyViewHolder holder1= (MyViewHolder) holder;
        holder1.title.setText(list.get(position).getTitle());
        holder1.name.setText(list.get(position).getSubhead());
        String images = list.get(position).getImages();
        String[] split = images.split("\\|");
        Glide.with(context).load(split[0]).into(holder1.iv);
        holder1.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pid = list.get(position).getPid();
                onClickfl.onClickxq(pid);

            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView title;
        private TextView name;
        LinearLayout ll;
        public MyViewHolder(View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.iv_list);
            title=itemView.findViewById(R.id.title);
            name=itemView.findViewById(R.id.name);
            ll=itemView.findViewById(R.id.ll);
        }
    }
}
