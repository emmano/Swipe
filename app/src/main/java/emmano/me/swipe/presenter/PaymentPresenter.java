package emmano.me.swipe.presenter;

import emmano.me.swipe.model.Payment;
import emmano.me.swipe.view.RowItemView;

/**
 * Created by emmanuelortiguela on 1/31/15.
 */
public class PaymentPresenter {
    
    public void bindData(Payment model, RowItemView view){
        
        view.setPaymentDescription(model.getDescription());
        
    }

}
