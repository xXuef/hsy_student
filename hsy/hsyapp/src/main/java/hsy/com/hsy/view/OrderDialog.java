package hsy.com.hsy.view;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import hsy.com.hsy.R;

public class OrderDialog extends Dialog {
    public OrderDialog(@NonNull Context context) {
        super(context);
    }

    public OrderDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected OrderDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }
    public static class Builder {
        private Context context;
        private String time;

        public Builder(Context context) {
            this.context = context;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public OrderDialog create() {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final OrderDialog dialog = new OrderDialog(context, R.style.MyDialog);
            View layout = inflater.inflate(R.layout.dialog_order, null);
            dialog.addContentView(layout, new LinearLayout.LayoutParams(
                    android.view.ViewGroup.LayoutParams.WRAP_CONTENT
                    , android.view.ViewGroup.LayoutParams.WRAP_CONTENT));
            dialog.setContentView(layout);


            TextView time = (TextView) layout.findViewById(R.id.time);
            time.setText(getTime());
            return dialog;
        }
    }

}
