package emmano.me.swipe.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import emmano.me.swipe.model.Payment;
import emmano.me.swipe.presenter.PaymentPresenter;
import emmano.me.swipe.view.RowItemView;

/**
 * Created by emmanuelortiguela on 1/31/15.
 */
public class StrikeThroughAdapter extends BaseAdapter {

    private List<Payment> list;
    
    private PaymentPresenter presenter;

    public StrikeThroughAdapter(List<Payment> list){

        this.list = list;
        presenter = new PaymentPresenter();
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Payment getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RowItemView row = (RowItemView)convertView;
        
        if(row == null) {
            row = new RowItemView(parent.getContext());
        }
        
        presenter.bindData(getItem(position), row);
            
        return row;
    }
}
