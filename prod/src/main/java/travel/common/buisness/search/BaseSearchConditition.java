package travel.common.buisness.search;

public abstract class BaseSearchConditition {
    protected Long id;
    protected OrderType orderType = OrderType.SIMPLE;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    protected boolean needOrdering() {return orderType!= null;}
}
