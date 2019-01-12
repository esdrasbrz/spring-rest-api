package payroll.assemblers;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;
import payroll.controllers.OrderController;
import payroll.models.Order;
import payroll.models.Status;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class OrderResourceAssembler implements ResourceAssembler<Order, Resource<Order>> {

    @Override
    public Resource<Order> toResource(Order order) {
        Resource<Order> orderResource = new Resource<>(order,
                linkTo(methodOn(OrderController.class).one(order.getId())).withSelfRel(),
                linkTo(methodOn(OrderController.class).all()).withRel("orders"));

        // conditional links based on state of the order
        if (order.getStatus() == Status.IN_PROGRESS) {
            orderResource.add(
                    linkTo(methodOn(OrderController.class)
                        .cancel(order.getId())).withRel("cancel"));
            orderResource.add(
                    linkTo(methodOn(OrderController.class)
                        .complete(order.getId())).withRel("complete"));
        }

        return orderResource;
    }
}
