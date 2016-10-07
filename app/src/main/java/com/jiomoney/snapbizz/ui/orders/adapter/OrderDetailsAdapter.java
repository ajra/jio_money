package com.jiomoney.snapbizz.ui.orders.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiomoney.snapbizz.R;
import com.jiomoney.snapbizz.ui.orders.OrderQty;
import com.jiomoney.snapbizz.ui.orders.OrderTotal;
import com.jiomoney.snapbizz.ui.orders.model.TodayOrder;
import com.jiomoney.snapbizz.utils.AppLog;
import com.jiomoney.snapbizz.utils.Common;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by VKrishnasamy on 06-10-2016.
 */


public class OrderDetailsAdapter extends RecyclerView.Adapter<OrderDetailsAdapter.OrderDetailsHolder> {


    List<TodayOrder.OrderList.ItemList> orderList = new ArrayList<TodayOrder.OrderList.ItemList>();
    Context context;

    int pos;

    String TAG = "Order Deatils";

    private EventBus bus = EventBus.getDefault();


    public OrderDetailsAdapter(Context context, List<TodayOrder.OrderList.ItemList> orderList) {
        this.context = context;
        this.orderList = orderList;

    }

    @Override
    public OrderDetailsHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemview = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_order_details, viewGroup, false);
        return new OrderDetailsHolder(itemview);
    }

    @Override
    public void onBindViewHolder(final OrderDetailsHolder holder, final int i) {

        try {
            holder.itemNameText.setText(orderList.get(i).productName);
            holder.qtyText.setText(orderList.get(i).productQuantity + "");
            holder.rateText.setText(orderList.get(i).productRate + "");

            holder.amountText.setText(orderList.get(i).getProductQuantity() * orderList.get(i).getProductRate() + "");
            orderList.get(i).setProductAmount(orderList.get(i).getProductQuantity() * orderList.get(i).getProductRate());


            holder.addQtyImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {


                        if (orderList.get(i).productQuantity > 0) {

                            orderList.get(i).setProductQuantity(orderList.get(i).getProductQuantity() + 1);
                            orderList.get(i).setProductAmount(orderList.get(i).getProductQuantity() * orderList.get(i).getProductRate());
                            notifyItemChanged(i);

                            try {


                                JSONObject jsonObject = totalCOunt();

                                bus.post(new OrderTotal(jsonObject.getInt("totalAmt")));
                                bus.post(new OrderQty(jsonObject.getInt("totalQty")));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }


                    } catch (Exception e) {
                        AppLog.handleException(TAG, e);
                    }
                }
            });
            holder.removeQtyImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    System.out.println("orderList.get(i).getProductQuantity()" + orderList.get(i).getProductQuantity());

                    System.out.println("orderList.get(i).getProductQuantity()" + orderList.get(i).getProductQuantity());

                    if (orderList.get(i).getProductQuantity() > 1) {
                        orderList.get(i).setProductQuantity(orderList.get(i).getProductQuantity() - 1);
                        orderList.get(i).setProductAmount(orderList.get(i).getProductQuantity() * orderList.get(i).getProductRate());
                        notifyItemChanged(i);


                        try {


                            JSONObject jsonObject = totalCOunt();

                            bus.post(new OrderTotal(jsonObject.getInt("totalAmt")));
                            bus.post(new OrderQty(jsonObject.getInt("totalQty")));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    } else {
                        Common.showToastMessage(context, "you can't reduce ");
                    }


                }
            });


            holder.modifyText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (!holder.addQtyImage.isShown()) {
                        holder.addQtyImage.setVisibility(View.VISIBLE);
                        holder.removeQtyImage.setVisibility(View.VISIBLE);
                    } else {
                        holder.addQtyImage.setVisibility(View.GONE);
                        holder.removeQtyImage.setVisibility(View.GONE);

                    }
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JSONObject totalCOunt() {
        int totalAmt = 0;
        int totalQty = 0;


        for (int i = 0; i < orderList.size(); i++) {
            totalAmt += orderList.get(i).getProductAmount();

            totalQty += orderList.get(i).getProductQuantity();

        }

        JSONObject totalJson = new JSONObject();
        try {
            totalJson.put("totalAmt", totalAmt);

            totalJson.put("totalQty", totalQty);


        } catch (JSONException e) {
            e.printStackTrace();
        }


        return totalJson;
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public class OrderDetailsHolder extends RecyclerView.ViewHolder {

        TextView itemNameText, qtyText, rateText, amountText, acceptText, modifyText;
        ImageView addQtyImage, removeQtyImage;

        public OrderDetailsHolder(View v) {
            super(v);


            itemNameText = (TextView) v.findViewById(R.id.itemNameText);
            qtyText = (TextView) v.findViewById(R.id.qtyText);
            rateText = (TextView) v.findViewById(R.id.rateText);
            amountText = (TextView) v.findViewById(R.id.amountText);
            acceptText = (TextView) v.findViewById(R.id.acceptText);
            modifyText = (TextView) v.findViewById(R.id.modifyText);
            addQtyImage = (ImageView) v.findViewById(R.id.addQtyImage);
            removeQtyImage = (ImageView) v.findViewById(R.id.removeQtyImage);


        }
    }
}
