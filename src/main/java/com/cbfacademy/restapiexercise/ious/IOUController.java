package com.cbfacademy.restapiexercise.ious;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Controller for handling HTTP request
@RestController
//base URI path for mappings
@RequestMapping("/api/ious")
public class IOUController {
    
    //IOU service dependency
    private final IOUService iouService;

    @Autowired
    // Constructor for the IOUController, receiving an IOUService instance
    public IOUController(IOUService iouService) {
        this.iouService = iouService;
    }

    // Handling HTTP GET request to retrieve all IOUs
    @GetMapping
    public List<IOU> getAllIOUs() {
        return iouService.getAllIOUs();
    }

    // Handling HTTP GET request to retrieve a specific IOU by its ID
    @GetMapping("/{id}")
    // Extracting the ID from the URI path and passing it as a method parameter
    public IOU getIOUById(@PathVariable UUID id) throws IOUNotFoundException {
        return iouService.getIOU(id);
    }

    // Handling HTTP POST request to add a new IOU
    @PostMapping
    // Deserializing the request body (JSON) into an IOU object
    public void addIOU(@RequestBody IOU iou) throws IOUNotFoundException {
        ((IOUController) iouService).addIOU(iou);
    }

    // Handling HTTP PUT request to update an existing IOU by its ID
    @PutMapping("/{id}")
    // Extracting the ID from the URI path and updating the corresponding IOU
    public void updateIOU(@PathVariable UUID id, @RequestBody IOU updatedIOU) throws IOUNotFoundException {
        updatedIOU.setId(id); // Ensure the ID is set to the correct value
        iouService.updateIOU(id, updatedIOU);
    }

    // Handling HTTP DELETE request to delete an IOU by its ID
    @DeleteMapping("/{id}")
    // Extracting the ID from the URI path and deleting the corresponding IOU
    public void deleteIOU(@PathVariable UUID id) throws IOUNotFoundException {
        iouService.deleteIOU(id);
    }
}


