package ua.goit.petStore.httpUtils;

import com.google.gson.Gson;
import ua.goit.petStore.model.petModel.Pet;
import ua.goit.petStore.model.petModel.PetStatus;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PetHttpUtil {

    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    private static final Gson GSON = new Gson();

    private static final String URL = "https://petstore.swagger.io/v2/";

    public static void createPet(Pet pet) throws IOException, InterruptedException {
        final String requestBody = GSON.toJson(pet);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s%s", URL, "pet")))
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .header("Content-type", "application/json")
                .build();
        final HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

    public static void getPetById(int id) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s%s%s", URL, "pet/", id)))
                .GET()
                .header("Content-type", "application/json")
                .build();
        final HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

    public static void updatePet(Pet pet) throws IOException, InterruptedException {
        final String requestBody = GSON.toJson(pet);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s%s", URL, "pet")))
                .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
                .header("Content-type", "application/json")
                .build();
        final HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

    public static void getPetByStatus(PetStatus status) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s%s", URL, "pet/findByStatus?status=" + status.toString().toLowerCase())))
                .GET()
                .build();
        final HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

    public static void deletePetById(int id) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s%s%s", URL, "pet/", id)))
                .DELETE()
                .header("Content-type", "application/json")
                .build();
        final HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
