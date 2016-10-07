package com.jiomoney.snapbizz.ui.billing.model;

import java.util.List;

/**
 * Created by araja on 6/10/16.
 */

public class BillingCheckOutPojo {
    /**
     * orderId : 1222
     * productName : Reliance Cash & carry
     * quantity : 2
     * rate : 40
     * couponOffers : Xcoupon Applied
     * amount : 700
     */

    private List<OrdersListBean> ordersList;

    public List<OrdersListBean> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<OrdersListBean> ordersList) {
        this.ordersList = ordersList;
    }

    public static class OrdersListBean {
        private int orderId;
        private String productName;
        private int quantity;
        private String rate;
        private String couponOffers;
        private int amount;

        public int getOrderId() {
            return orderId;
        }

        public void setOrderId(int orderId) {
            this.orderId = orderId;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public String getRate() {
            return rate;
        }

        public void setRate(String rate) {
            this.rate = rate;
        }

        public String getCouponOffers() {
            return couponOffers;
        }

        public void setCouponOffers(String couponOffers) {
            this.couponOffers = couponOffers;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }
    }
}
