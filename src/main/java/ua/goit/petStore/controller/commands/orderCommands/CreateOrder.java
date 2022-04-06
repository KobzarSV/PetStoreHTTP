package ua.goit.petStore.controller.commands.orderCommands;

import ua.goit.petStore.controller.commands.Command;
import ua.goit.petStore.httpUtils.OrderHttpUtil;
import ua.goit.petStore.model.orderModel.Order;
import ua.goit.petStore.model.orderModel.OrderStatus;
import ua.goit.petStore.view.View;

import java.io.IOException;
import java.time.LocalDateTime;

import static ua.goit.petStore.controller.commands.Commands.CREATE_ORDER;

public class CreateOrder implements Command {

    public static LocalDateTime data = LocalDateTime.now();
    public static String dateStr = data.toString();

    private final View view;

    public CreateOrder(View view) {
        this.view = view;
    }

    @Override
    public boolean canProcess(String input) {
        return input.equals(CREATE_ORDER.getName());
    }

    @Override
    public void process() {
        view.write("Enter pet id:");
        long petId = Integer.parseInt(view.read());
        view.write("Enter quantity:");
        int quantity = Integer.parseInt(view.read());

        String shipDate = dateStr;
        OrderStatus status = OrderStatus.PLACED;
        Boolean complete = true;

        Order order = new Order(petId, quantity, shipDate, status, complete);
        try {
            OrderHttpUtil.createOrder(order);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        view.write("Order is accepted.\n" +
                "Order number: " + OrderHttpUtil.id.substring(6) + "\n" +
                "Order date: " + dateStr + "\n" +
                "Thanks for your order!");
    }
}
