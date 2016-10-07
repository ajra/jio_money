package com.jiomoney.snapbizz.ui.orders.model;

import java.util.List;


public class SupplierOrderDetails {

    private List<MonthlyOrdersListBean> monthlyOrdersList;

    private List<WeeklyOrdersListBean> weeklyOrdersList;

    private List<DayOrdersListBean> dayOrdersList;

    public List<MonthlyOrdersListBean> getMonthlyOrdersList() {
        return monthlyOrdersList;
    }

    public void setMonthlyOrdersList(List<MonthlyOrdersListBean> monthlyOrdersList) {
        this.monthlyOrdersList = monthlyOrdersList;
    }

    public List<WeeklyOrdersListBean> getWeeklyOrdersList() {
        return weeklyOrdersList;
    }

    public void setWeeklyOrdersList(List<WeeklyOrdersListBean> weeklyOrdersList) {
        this.weeklyOrdersList = weeklyOrdersList;
    }

    public List<DayOrdersListBean> getDayOrdersList() {
        return dayOrdersList;
    }

    public void setDayOrdersList(List<DayOrdersListBean> dayOrdersList) {
        this.dayOrdersList = dayOrdersList;
    }

    public static class MonthlyOrdersListBean {
        private int orderId;
        private String distributorName;
        private String date;
        private int noOfItems;
        private String deliveryDate;
        private int amount;
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

        public int getAmount() {
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

    public static class WeeklyOrdersListBean {
        private int orderId;
        private String distributorName;
        private String date;
        private int noOfItems;
        private String deliveryDate;
        private int amount;
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

        public int getAmount() {
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

    public static class DayOrdersListBean {
        private int orderId;
        private String distributorName;
        private String date;
        private int noOfItems;
        private String deliveryDate;
        private int amount;
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

        public int getAmount() {
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
