package com.jiomoney.snapbizz.ui.inventory.model;

import java.util.List;

public class InventoryManagementList {

    private List<ZeroInventoryListBean> zeroInventoryList;

    private List<LowStockListBean> lowStockList;

    private List<LowSalesListBean> lowSalesList;

    public List<ZeroInventoryListBean> getZeroInventoryList() {
        return zeroInventoryList;
    }

    public void setZeroInventoryList(List<ZeroInventoryListBean> zeroInventoryList) {
        this.zeroInventoryList = zeroInventoryList;
    }

    public List<LowStockListBean> getLowStockList() {
        return lowStockList;
    }

    public void setLowStockList(List<LowStockListBean> lowStockList) {
        this.lowStockList = lowStockList;
    }

    public List<LowSalesListBean> getLowSalesList() {
        return lowSalesList;
    }

    public void setLowSalesList(List<LowSalesListBean> lowSalesList) {
        this.lowSalesList = lowSalesList;
    }

    public static class ZeroInventoryListBean {
        private String productName;

        private List<SupplierProductListBean> supplierProductList;

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public List<SupplierProductListBean> getSupplierProductList() {
            return supplierProductList;
        }

        public void setSupplierProductList(List<SupplierProductListBean> supplierProductList) {
            this.supplierProductList = supplierProductList;
        }

        public static class SupplierProductListBean {
            private String supplierName;
            private int sellingPrice;
            private int quantity;

            public String getSupplierName() {
                return supplierName;
            }

            public void setSupplierName(String supplierName) {
                this.supplierName = supplierName;
            }

            public int getSellingPrice() {
                return sellingPrice;
            }

            public void setSellingPrice(int sellingPrice) {
                this.sellingPrice = sellingPrice;
            }

            public int getQuantity() {
                return quantity;
            }

            public void setQuantity(int quantity) {
                this.quantity = quantity;
            }
        }
    }

    public static class LowStockListBean {
        private String productName;
        private int quantity;

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
    }

    public static class LowSalesListBean {
        private String productName;
        private int quantityInStock;
        private int salesLast3Days;

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public int getQuantityInStock() {
            return quantityInStock;
        }

        public void setQuantityInStock(int quantityInStock) {
            this.quantityInStock = quantityInStock;
        }

        public int getSalesLast3Days() {
            return salesLast3Days;
        }

        public void setSalesLast3Days(int salesLast3Days) {
            this.salesLast3Days = salesLast3Days;
        }
    }
}
