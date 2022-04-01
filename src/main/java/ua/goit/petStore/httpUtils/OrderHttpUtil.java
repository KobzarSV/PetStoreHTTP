package ua.goit.petStore.httpUtils;

import com.google.gson.Gson;
import ua.goit.petStore.model.orderModel.Order;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class OrderHttpUtil {

    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    private static final Gson GSON = new Gson();

    private static final String URL = "https://petstore.swagger.io/v2/";

    public static String id = "";

    public static void createOrder(Order order) throws IOException, InterruptedException {
        final String requestBody = GSON.toJson(order);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s%s", URL, "store/order")))
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .header("Content-type", "application/json")
                .build();
        final HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        String[] responseArr = response.body().split(",");
        id = id + responseArr[0];
    }

    public static void getOrderById(long id) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s%s%d", URL, "store/order/", id)))
                .GET()
                .header("Content-type", "application/json")
                .build();
        final HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

    public static void deleteOrder(long id) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s%s%d", URL, "store/order/", id)))
                .DELETE()
                .header("Content-type", "application/json")
                .build();
        final HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
