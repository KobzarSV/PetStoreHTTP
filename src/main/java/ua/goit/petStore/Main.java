package ua.goit.petStore;

import ua.goit.petStore.httpUtils.OrderHttpUtil;
import ua.goit.petStore.httpUtils.PetHttpUtil;
import ua.goit.petStore.httpUtils.UserHttpUtil;
import ua.goit.petStore.model.orderModel.CreatedOrders;
import ua.goit.petStore.model.petModel.CreatedPets;
import ua.goit.petStore.model.petModel.PetStatus;
import ua.goit.petStore.model.userModel.CreatedUsers;
import ua.goit.petStore.model.userModel.User;

import java.io.IOException;
import java.util.*;

import static ua.goit.petStore.model.orderModel.CreatedOrders.ordersList;
import static ua.goit.petStore.model.petModel.CreatedPets.petsList;
import static ua.goit.petStore.model.userModel.CreatedUsers.usersList;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        CreatedUsers.addUsers();
        CreatedPets.addPets();
        CreatedOrders.addOrders();

        System.out.println("---Create new order---");
        OrderHttpUtil.createOrder(ordersList.get(0));

        System.out.println("---Get order---");
        OrderHttpUtil.getOrderById(1);

        System.out.println("---Delete order---");
        OrderHttpUtil.deleteOrder(1);

//        System.out.println("---Create new pet---");
//        PetHttpUtil.createPet(petsList.get(0));
//
//        System.out.println("---Upload image pet---");
//        PetHttpUtil.uploadImagePet(1);
//
//        System.out.println("---Get pet---");
//        PetHttpUtil.getPetById(1);
//
//        System.out.println("---Update pet---");
//        PetHttpUtil.updatePet(petsList.get(1));
//
//        System.out.println("---Get pet by status---");
//        PetHttpUtil.getPetByStatus(PetStatus.SOLD);
//
//        System.out.println("---Delete pet---");
//        PetHttpUtil.deletePetById(1);

//        List<User> userList = new ArrayList<>();
//        userList.add(usersList.get(0));
//
//        System.out.println("---Create new user---");
//        UserHttpUtil.createUserWithList(userList);
//
//        System.out.println("---Log in user---");
//        UserHttpUtil.userLogin("AP", "12345678");
//
//        System.out.println("---Update user---");
//        UserHttpUtil.updateUserPut("AP", usersList.get(2));
//
//        System.out.println("---Create new user---");
//        UserHttpUtil.createUser(usersList.get(1));
//
//        System.out.println("---Get user---");
//        UserHttpUtil.getUserByUsername("AP");
//        UserHttpUtil.getUserByUsername("VS");
//
//        System.out.println("---Log out user---");
//        UserHttpUtil.userLogout();
//
//        System.out.println("---Delete user---");
//        UserHttpUtil.deleteUserByUsername("AP");
    }
}
