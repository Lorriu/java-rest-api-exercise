package com.cbfacademy.restapiexercise.ious;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbfacademy.restapiexercise.core.PersistenceException;


@Service
public class ListIOUService implements IOUService {

    private final IOURepository iouRepository;

    @Autowired
    public ListIOUService(IOURepository iouRepository) {
        this.iouRepository = iouRepository;
    }

    @Override
    public List<IOU> getAllIOUs() {
        try {
            return iouRepository.retrieveAll();
        } catch (PersistenceException e) {
            // Handle exception or return an empty list
            return new ArrayList<>();
        }
    }

    @Override
    public IOU getIOU(UUID id) {
        try {
            return iouRepository.retrieve(id);
        } catch (IllegalArgumentException e) {
            // Handle exception or return null if not found
            return null;
        } catch (Exception e) {
            // Handle other exceptions
            return null;
        }
    }

    @Override
    public IOU createIOU(IOU iou) {
        try {
            return iouRepository.create(iou);
        } catch (IllegalArgumentException | PersistenceException e) {
            // Handle exception or return null
            e.getMessage();
            return null;
        }
    }

    @Override
    public IOU updateIOU(UUID id, IOU updatedIOU) {
        try {
            return iouRepository.update(updatedIOU);
        } catch (IllegalArgumentException | PersistenceException e) {
            // Handle exception or return null
            return null;
        }
    }

    @Override
    public void deleteIOU(UUID id) {
        IOU iouToDelete = getIOU(id);
        if (iouToDelete != null) {
            try {
                iouRepository.delete(iouToDelete);
            } catch (IllegalArgumentException | PersistenceException e) {
                // Handle exception
                e.getMessage();
            }
        }
    }
}
