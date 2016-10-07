package com.jiomoney.snapbizz.ui.orders.adapter;

import java.util.List;

public class OrderDetails {

    private List<OrdersListBean> ordersList;

    public List<OrdersListBean> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<OrdersListBean> ordersList) {
        this.ordersList = ordersList;
    }

    public static class OrdersListBean {
        private int orderId;
        private String distributorName;
        private String date;
        private int noOfItems;
        private String deliveryDate;
        private double amount;
        private boolean paymentStatus;
        private int paymentType;
        private String paymentDescription;

        public int getOrderId() {
            return orderId;
        }

        public void setOrderId(int orderId) {
            this.orderId = orderId;
        }

        public String getDistributorName() {
            return distributorName;
        }

        public void setDistributorName(String distributorName) {
            this.distributorName = distributorName;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public int getNoOfItems() {
            return noOfItems;
        }

        public void setNoOfItems(int noOfItems) {
            this.noOfItems = noOfItems;
        }

        public String getDeliveryDate() {
            return deliveryDate;
        }

        public void setDeliveryDate(String deliveryDate) {
            this.deliveryDate = deliveryDate;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public boolean isPaymentStatus() {
            return paymentStatus;
        }

        public void setPaymentStatus(boolean paymentStatus) {
            this.paymentStatus = paymentStatus;
        }

        public int getPaymentType() {
            return paymentType;
        }

        public void setPaymentType(int paymentType) {
            this.paymentType = paymentType;
        }

        public String getPaymentDescription() {
            return paymentDescription;
        }

        public void setPaymentDescription(String paymentDescription) {
            this.paymentDescription = paymentDescription;
        }
    }
}
