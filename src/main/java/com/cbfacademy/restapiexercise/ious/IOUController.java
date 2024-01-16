package com.cbfacademy.restapiexercise.ious;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

//Controller for handling HTTP request
@RestController
//create global exception
@ControllerAdvice
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
    public ResponseEntity<List<IOU>> getAllIOUs() {

        List<IOU> ious = iouService.getAllIOUs();
        return ResponseEntity.ok().body(ious);
    }

    // Handling HTTP GET request to retrieve a specific IOU by its ID
    @GetMapping("/{id}")
    // Extracting the ID from the URI path and passing it as a method parameter
    public ResponseEntity<IOU> getIOU(@PathVariable("id") UUID id) {
        
        try {

            IOU iou = iouService.getIOU(id);
            return ResponseEntity.ok().body(iou);

        } catch (IOUNotFoundException e) {

            //return ResponseEntity.notFound().build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            
        }
       
    }

    // Handling HTTP POST request to add a new IOU
    @PostMapping
    // Deserializing the request body (JSON) into an IOU object
    public ResponseEntity<IOU> createIOU(@RequestBody IOU iou) {
       
        try {

            IOU created = iouService.createIOU(iou);
            URI endpoint = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(endpoint).body(created);

        } catch (IOUNotFoundException e) {

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Handling HTTP PUT request to update an existing IOU by its ID
    @PutMapping("/{id}")
    // Extracting the ID from the URI path and updating the corresponding IOU
    public ResponseEntity<IOU> updateIOU(@PathVariable UUID id, @RequestBody IOU updatedIOU) {
        
            try {
                
                updatedIOU.setId(id); // Ensure the ID is set to the correct value
                
                return new ResponseEntity<>(iouService.updateIOU(id, updatedIOU), HttpStatus.OK);

            } catch (IOUNotFoundException e) {

                //return ResponseEntity.notFound().build();
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
               
    }

    // Handling HTTP DELETE request to delete an IOU by its ID
    @DeleteMapping("/{id}")
    // Extracting the ID from the URI path and deleting the corresponding IOU
    public ResponseEntity<IOU> deleteIOU(@PathVariable UUID id) {

        try {

            iouService.deleteIOU(id);

            return ResponseEntity.noContent().build();

        } catch (IOUNotFoundException e) {

            e.getMessage();
            //return ResponseEntity.notFound().build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        }
    }
}


