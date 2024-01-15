package com.cbfacademy.restapiexercise.ious;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.cbfacademy.restapiexercise.core.PersistenceException;

@Repository
public class ListIOURepository implements IOURepository {

    // List to store IOUs
    private final List<IOU> ious = new ArrayList<>();

    // Retrieve all IOUs
    @Override
    public List<IOU> retrieveAll() throws PersistenceException {
        // Return a copy of the list to prevent external modification
        return new ArrayList<>(ious);
    }

    // Retrieve by ID
    public IOU retrieve(UUID id) throws IllegalArgumentException, PersistenceException {
        // Check if the list contains an IOU with the given ID
        for (IOU iou : ious) {
            if (iou.getId().equals(id)) {
                return iou;
            }
        }
        throw new IllegalArgumentException("IOU with ID " + id + " not found.");
    }

    // Create a new IOU
    @Override
    public IOU create(IOU entity) throws IllegalArgumentException, PersistenceException {
        // Check if an IOU with the same ID already exists
        try{
            if (ious.contains(entity)) {
            throw new IllegalArgumentException("IOU with ID " + entity.getId() + " already exists.");
        }
        ious.add(entity);
        } catch(PersistenceException e){

            e.getMessage();
        } catch(Exception e){

            e.getMessage();
         }
        return entity;
    }

    // Delete an IOU
    @Override
    public void delete(IOU entity) throws IllegalArgumentException, PersistenceException {
        
        // Check if the list contains the specified IOU and remove it
        try{
            if(!ious.contains(entity)) {
                throw new IllegalArgumentException("IOU ID does not exists.");
            }
            ious.remove(entity);
        } catch (PersistenceException e)
        {

            e.getMessage();
        } catch(Exception e){

            e.getMessage();
         }
    }

    // Update an existing IOU
    @Override
    public IOU update(IOU updatedIOU) throws IllegalArgumentException, PersistenceException {
        // Find the index of the existing IOU and replace it with the updated IOU
        int index = ious.indexOf(updatedIOU);
        if (index == -1) {

            throw new IllegalArgumentException("IOU not found for update.");
            
        }
        return ious.set(index, updatedIOU);
    }

    // Search for IOUs by borrower's name
    @Override
    public List<IOU> searchByBorrower(String name) {

        //create a new List of borrows
        List<IOU> result = new ArrayList<>();

        //loop through the IOU object 
        for (IOU iou : ious) {


            if (iou.getBorrower().equals(name)) {
                result.add(iou);
            }
        }
        return result;
    }

    // Search for IOUs by lender's name
    @Override
    public List<IOU> searchByLender(String name) {
        
        List<IOU> result = new ArrayList<>();
        for (IOU iou : ious) {
            if (iou.getLender().equals(name)) {
                result.add(iou);
            }
        }
        return result;
    }
}

