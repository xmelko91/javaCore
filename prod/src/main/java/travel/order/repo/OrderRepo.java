package travel.order.repo;

import travel.common.solutions.repo.BaseRepo;
import travel.order.domain.Order;
import travel.order.search.OrderSearchCondition;

import java.util.List;

public interface OrderRepo extends BaseRepo<Order, Long> {

    List<Order> search(OrderSearchCondition searchCondition);

}
