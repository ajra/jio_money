package com.jiomoney.snapbizz.ui.orders.model;

import java.util.List;

public class TodayOrder {

    public List<OrderList> orderList;

    public static class OrderList {
        public String customerName;
        public String orderDate;
        public int orderId;
        public String orderTime;
        public int orderStatusId;
        public String orderStatusDescription;
        public String customerMobileNo;
        public String customerAddress;
        public String deliveryTime;
        public int total;
        public String paymentMode;
        public int totalQuantity;
        public int totalItem;

        public List<ItemList> itemList;

        public static class ItemList {
            public String productName;
            public int productQuantity;
            public int productRate;
            public int productAmount;

            public String getProductName() {
                return productName;
            }

            public void setProductName(String productName) {
                this.productName = productName;
            }

            public int getProductQuantity() {
                return productQuantity;
            }

            public void setProductQuantity(int productQuantity) {
                this.productQuantity = productQuantity;
            }

            public int getProductRate() {
                return productRate;
            }

            public void setProductRate(int productRate) {
                this.productRate = productRate;
            }

            public int getProductAmount() {
                return productAmount;
            }

            public void setProductAmount(int productAmount) {
                this.productAmount = productAmount;
            }
        }
    }
}
