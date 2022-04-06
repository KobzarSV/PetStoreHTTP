package ua.goit.petStore.httpUtils;

import com.google.gson.Gson;
import ua.goit.petStore.model.userModel.User;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class UserHttpUtil {

    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    private static final Gson GSON = new Gson();

    private static final String URL = "https://petstore.swagger.io/v2/";

    public static void createUserWithList(List<User> user) throws IOException, InterruptedException {
        final String requestBody = GSON.toJson(user);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s%s", URL, "user/createWithList")))
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .header("Content-type", "application/json")
                .build();
        final HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

    public static void createUser(User user) throws IOException, InterruptedException {
        final String requestBody = GSON.toJson(user);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s%s", URL, "user")))
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .header("Content-type", "application/json")
                .build();
        final HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

    public static void updateUserPut(String userName, User user) throws IOException, InterruptedException {
        final String requestBody = GSON.toJson(user);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s%s%s", URL, "user/", userName)))
                .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
                .header("Content-type", "application/json")
                .build();
        final HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

    public static void getUserByUsername(String userName) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s%s%s", URL, "user/", userName)))
                .GET()
                .header("Content-type", "application/json")
                .build();
        final HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

    public static void userLogin(String userName, String password) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s%s%s%s%s", URL, "user/login?username=", userName, "&password=", password)))
                .GET()
                .header("Content-type", "application/json")
                .build();
        final HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

    public static void userLogout() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s%s", URL, "user/logout")))
                .GET()
                .header("Content-type", "application/json")
                .build();
        final HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

    public static void deleteUserByUsername(String userName) throws IOException, InterruptedException {
        final String requestBody = GSON.toJson(userName);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s%s%s", URL, "user/", userName)))
                .header("Content-type", "application/json")
                .method("DELETE", HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
        final HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

    public static String id = "";
    public static String username = "";
    public static String firstName = "";
    public static String lastName = "";
    public static String email = "";
    public static String password = "";
    public static String phone = "";
    public static String status = "";

    public static void getUserForUpdate(String userName) throws IOException, InterruptedException {
        id = "";
        username = "";
        firstName = "";
        lastName = "";
        email = "";
        password = "";
        phone = "";
        status = "";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s%s%s", URL, "user/", userName)))
                .GET()
                .header("Content-type", "application/json")
                .build();
        final HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        String[] responseArr = response.body().split(",");
        id = id + responseArr[0];
        username = username + responseArr[1];
        firstName = firstName + responseArr[2];
        lastName = lastName + responseArr[3];
        email = email + responseArr[4];
        password = password + responseArr[5];
        phone = phone + responseArr[6];
        status = status + responseArr[7];
    }
}
