package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.example.model.Dish;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api/practice")
public class PracticeController {

    private static final Logger logger = LoggerFactory.getLogger(PracticeController.class);

    @Operation(summary = "get the dish by id", description = "get the dish by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the dish by id"),
            @ApiResponse(responseCode = "404", description = "No Dishes found")
    })
    @GetMapping("array")
    public void getArray() {
        logger.info("Retrieving all the dishes from the menu");
        // 1. Initialize
        int[] a0 = new int[5];
        int[] a1 = {1, 2, 3};
        // 2. Get Length
        logger.info("The size of a1 is: " + a1.length);
        // 3. Access Element
        logger.info("The first element is: " + a1[0]);
        // 4. Iterate all Elements
        logger.info("[Version 1] The contents of a1 are:");
        for (int i = 0; i < a1.length; ++i) {
            System.out.print(" " + a1[i]);
        }
        System.out.println();
        logger.info("[Version 2] The contents of a1 are:");
        for (int item: a1) {
            logger.info(" " + item);
        }
        System.out.println();
        // 5. Modify Element
        a1[0] = 4;
        // 6. Sort
        Arrays.sort(a1);
        System.out.println("Sorted array: " + Arrays.toString(a1));
    }

    @Operation(summary = "get the dish by id", description = "get the dish by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the dish by id"),
            @ApiResponse(responseCode = "404", description = "No Dishes found")
    })
    @GetMapping("dynamicArray")
    public void getDynamicArray() {
        // 1. initialize
        List<Integer> v0 = new ArrayList<>();
        List<Integer> v1;                   // v1==null
        // 2. cast an array to a vector
        Integer[] a = {0, 1, 2, 3, 4};
        v1 = new ArrayList<>(Arrays.asList(a));
        // 3. make a copy
        List<Integer> v2 = v1; // another reference to v1
        List<Integer> v3 = new ArrayList<>(v1); // make an actual copy of v1
        // 4. get length
        System.out.println("The size of v1 is: " + v1.size());
        // 5. access element
        System.out.println("The first element in v1 is: " + v1.get(0));
        // 6. Iterate the vector
        System.out.print("[Version 1] The contents of v1 are:");
        for(int i = 0; i < v1.size(); i++){
            System.out.print(" " + v1.get(i));
        }
        System.out.println();
        System.out.print("[Version 2] The contents of v1 are:");
        for (int item : v1) {
            System.out.print(" " + item);
        }
        // 7. modify element
        v2.set(0, 5); // modify v2 will actually modify v1
        System.out.println("The first element in v1 is: " + v1.get(0));
        v3.set(0, -1);
        System.out.println("The first element in v1 is: " + v1.get(0));
        // 8. sort
        Collections.sort(v1);
        // 9. add new element at the end of the vector
        v1.add(-1);
        v1.add(1, 6);
        // 10. delete the last element
        v1.remove(v1.size() - 1);
        Collections.sort(v1);
        for (int item : v1) {
            System.out.print(" " + item);
        }
    }
}
