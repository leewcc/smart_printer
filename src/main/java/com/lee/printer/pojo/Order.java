package com.lee.printer.pojo;

/**
 * 订单类，描述订单的详细信息
 *
 * @author leewcc
 */
public final class Order {
    /**
     * 订单编号 id，在用户订单列表中，该编号值唯一
     */
    private final Integer orderid;

    /**
     * 订单相关联的用户
     */
    private final User user;

    /**
     * 订单的详细信息
     */
    private OrderDetail orderDetail;

    public Order(Integer orderid, User user, OrderDetail orderDetail) {
        this.orderid = orderid;
        this.user = user;
        this.orderDetail = orderDetail;
    }


    /**
     * 订单内容显示
     * 订单样式：
     * <p>
     * 用户店铺
     * ------------------------
     * 订单编号：id （已支付）
     * 下单时间：time
     * 预计送达时间：time
     * 备注：
     * ------------------------
     * 菜名     数量     小计
     * XXX        X        X
     * XXX        X        X
     * ------------------------
     * 餐盒费：
     * 配送费：
     * 优惠额：
     * 合计  ：
     * ------------------------
     * 顾客姓名：xxxxx
     * 送餐地址：xxxxxxx
     * 电话：xxxxxxx
     * ------------------------
     * 商家地址：
     * 商家电话：
     * ------------------------
     *
     * @return
     */
    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * 当用户相等且订单编号相等，返回 true，否则返回 false
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;

        if (!(obj instanceof Order))
            return false;

        Order order = (Order) obj;
        return order.user.equals(this.user) && order.orderid.equals(this.orderid);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result * 31 + user.hashCode();
        result = result * 31 + orderid;
        return result;
    }

    /**
     * 订单内容内部类，封装了订单具体内容
     */
    private static class OrderDetail {
        /**
         * 下单用户名字
         */
        private final String userName;

        /**
         * 下单用户地址
         */
        private final String userAddress;

        /**
         * 下单用户电话
         */
        private final String userPhone;

        /**
         * 用户下单时间
         */
        private final String orderTime;

        /**
         * 下单点菜具体内容
         */
        private final String orderContent;

        /**
         * 预期送达时间
         */
        private final String expectTime;

        /**
         * 订单备注
         */
        private final String orderRemark;

        /**
         * 餐盒费
         */
        private final Integer orderMealFee;

        /**
         * 已支付状态 false-未支付 true-已支付
         */
        private final Boolean paid;

        /**
         * 配送费
         */
        private final Integer orderDisFee;

        /**
         * 优惠额
         */
        private final Integer orderPreAmount;

        /**
         * 订单总金额
         */
        private final Integer orderSum;

        /**
         * 通过建造者来创建订单内容
         *
         * @param orderBuilder
         */
        private OrderDetail(OrderBuilder orderBuilder) {
            this.userName = orderBuilder.userName;
            this.userAddress = orderBuilder.userAddress;
            this.userPhone = orderBuilder.userPhone;
            this.orderTime = orderBuilder.orderTime;
            this.orderContent = orderBuilder.orderContent;
            this.expectTime = orderBuilder.expectTime;
            this.orderRemark = orderBuilder.orderRemark;
            this.paid = orderBuilder.paid;
            this.orderMealFee = orderBuilder.orderMealFee;
            this.orderDisFee = orderBuilder.orderDisFee;
            this.orderPreAmount = orderBuilder.orderPreAmount;
            this.orderSum = orderBuilder.orderSum;
        }

        /**
         * 由于订单内容创建存在多个可选参数，此处采用 builder 模式创建订单内容
         * username、 userAddress、 userPhone、 orderTIme、 orderContent 是必要属性
         * 其他为可选属性
         */
        public static class OrderBuilder {
            private String userName;

            private String userAddress;

            private String userPhone;

            private String orderTime;

            private String orderContent;

            private String expectTime = "";

            private String orderRemark = "";

            private Boolean paid = false;

            private Integer orderMealFee;

            private Integer orderDisFee;

            private Integer orderPreAmount;

            private Integer orderSum;

            public OrderBuilder(String userName, String userAddress, String userPhone, String orderTime, String orderContent) {
                this.userName = userName;
                this.userAddress = userAddress;
                this.userPhone = userPhone;
                this.orderTime = orderTime;
                this.orderContent = orderContent;
            }

            public OrderBuilder setExpectTime(String expectTime) {
                this.expectTime = expectTime;
                return this;
            }

            public OrderBuilder setOrderRemark(String orderRemark) {
                this.orderRemark = orderRemark;
                return this;
            }

            public OrderBuilder setPaid(Boolean paid) {
                this.paid = paid;
                return this;
            }

            public OrderBuilder setOrderMealFee(Integer orderMealFee) {
                this.orderMealFee = orderMealFee;
                return this;
            }

            public OrderBuilder setOrderDisFee(Integer orderDisFee) {
                this.orderDisFee = orderDisFee;
                return this;
            }

            public OrderBuilder setOrderPreAmount(Integer orderPreAmount) {
                this.orderPreAmount = orderPreAmount;
                return this;
            }

            public OrderDetail build(OrderBuilder orderBuilder) {
                return new OrderDetail(orderBuilder);
            }
        }
    }

}
