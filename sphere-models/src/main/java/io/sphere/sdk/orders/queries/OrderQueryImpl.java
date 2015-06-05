package io.sphere.sdk.orders.queries;

import io.sphere.sdk.orders.Order;
import io.sphere.sdk.orders.expansion.OrderExpansionModel;
import io.sphere.sdk.queries.UltraQueryDslBuilder;
import io.sphere.sdk.queries.UltraQueryDslImpl;

final class OrderQueryImpl extends UltraQueryDslImpl<Order, OrderQuery, OrderQueryModel<Order>, OrderExpansionModel<Order>> implements OrderQuery {
    OrderQueryImpl(){
        super(OrderEndpoint.ENDPOINT.endpoint(), OrderQuery.resultTypeReference(), OrderQueryModel.of(), OrderExpansionModel.of(), OrderQueryImpl::new);
    }

    private OrderQueryImpl(final UltraQueryDslBuilder<Order, OrderQuery, OrderQueryModel<Order>, OrderExpansionModel<Order>> builder) {
        super(builder);
    }
}