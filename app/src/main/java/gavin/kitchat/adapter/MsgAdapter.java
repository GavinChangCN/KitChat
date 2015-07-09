package gavin.kitchat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import gavin.kitchat.R;
import gavin.kitchat.bean.MsgBean;

/**
 * Created by Administrator on 2015/7/9 0009.
 */
public class MsgAdapter extends BaseAdapter{
    private Context context ;
    private List<MsgBean> datas ;
    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int i) {
        return datas.get(i) ;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder ;

        if ( view == null ) {
            view = LayoutInflater.from(context).inflate(R.layout.message_list_item, null) ;
            holder = new ViewHolder() ;
            holder.msg_title = (TextView) view.findViewById(R.id.msg_title) ;
            holder.msg_desc = (TextView) view.findViewById(R.id.msg_desc) ;
            holder.msg_datetime = (TextView) view.findViewById(R.id.msg_datetime) ;
            view.setTag(holder) ;
        } else {
            holder = (ViewHolder) view.getTag() ;
        }

        holder.msg_title.setText( datas.get(i).getTitle() ) ;
        if ( datas.get(i).getUniverName().isEmpty() ) {
            holder.msg_desc.setVisibility( View.GONE ) ;
        } else {
            holder.msg_desc.setText( datas.get(i).getUniverName()
                    + "  " + datas.get(i).getCollegeName() ) ;
        }
        holder.msg_datetime.setText( datas.get(i).getTime() ) ;

        return view ;
    }
     public static class ViewHolder {
         TextView msg_title ;
         TextView msg_desc ;
         TextView msg_datetime ;
     }
}
