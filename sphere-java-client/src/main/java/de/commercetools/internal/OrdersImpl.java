package de.commercetools.internal;

import de.commercetools.sphere.client.shop.model.*;
import de.commercetools.sphere.client.shop.Orders;
import de.commercetools.sphere.client.model.QueryResult;
import de.commercetools.sphere.client.ProjectEndpoints;
import de.commercetools.sphere.client.QueryRequest;
import de.commercetools.sphere.client.CommandRequest;

import org.codehaus.jackson.type.TypeReference;

public class OrdersImpl implements Orders {
    private ProjectEndpoints endpoints;
    private RequestFactory requestFactory;

    public OrdersImpl(RequestFactory requestFactory, ProjectEndpoints endpoints) {
        this.requestFactory = requestFactory;
        this.endpoints = endpoints;
    }

    /** {@inheritDoc}  */
    public QueryRequest<Order> byId(String id) {
        return requestFactory.createQueryRequest(endpoints.orders.byId(id), new TypeReference<Order>() {});
    }

    /** {@inheritDoc}  */
    public QueryRequest<QueryResult<Order>> all() {
        return requestFactory.createQueryRequest(endpoints.orders.root(), new TypeReference<QueryResult<Order>>() {});
    }

    /** {@inheritDoc}  */
    public RequestBuilder<QueryResult<Order>> byCustomerId(String customerId) {
        return requestFactory.createQueryRequest(
                endpoints.orders.queryByCustomerId(customerId),
                new TypeReference<QueryResult<Order>>() {});
    }

    /** Helper to save some repetitive code in this class. */
    private CommandRequest<Order> createCommandRequest(String url, Command command) {
        return requestFactory.<Order>createCommandRequest(url, command, new TypeReference<Order>() {});
    }

    /** {@inheritDoc}  */
    public CommandRequest<Order> updatePaymentState(String orderId, int orderVersion, PaymentState paymentState) {
        return createCommandRequest(
                endpoints.orders.updatePaymentState(),
                new OrderCommands.UpdatePaymentState(orderId, orderVersion, paymentState));
    }


    /** {@inheritDoc}  */
    public CommandRequest<Order> updateShipmentState(String orderId, int orderVersion, ShipmentState shipmentState) {
        return createCommandRequest(
                endpoints.orders.updateShipmentState(),
                new OrderCommands.UpdateShipmentState(orderId, orderVersion, shipmentState));
    }

}
