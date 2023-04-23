package com.charisma.shipping;

import com.charisma.shipping.dao.DispatchingRepository;
import com.charisma.shipping.enums.DispatchingStatus;
import com.charisma.shipping.exceptions.DispatchingCodeNotFoundException;
import com.charisma.shipping.valueobject.Dispatch;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class SimpleDispatchService implements IDispatch{

    private final DispatchingRepository repository;
    @Override
    public void changeStatus(String reference, DispatchingStatus status) {
        var dispatch = repository.findByDispatchReference(reference).orElseThrow(
                () -> new DispatchingCodeNotFoundException("Reference Not Found")
        );
        dispatch.setStatus(status);
        repository.save(dispatch);
    }

    @Override
    public void createTask(Dispatch dispatch) {
        List<com.charisma.shipping.entities.Dispatch> array = new ArrayList<>();
        dispatch.getPackReference().getPackReferences().forEach(x->{
            var newTask = new com.charisma.shipping.entities.Dispatch();
            newTask.setAddress(dispatch.getAddress());
            newTask.setTrackingCode(dispatch.getTrackingCode());
            array.add(newTask);}
        );
        repository.saveAll(array);
    }

    @Override
    public DispatchingStatus getStatus(@NotBlank @NotNull String reference) {
        var dispatch = repository.findByDispatchReference(reference).orElseThrow(
                () -> new DispatchingCodeNotFoundException("Reference Not Found")
        );
        return dispatch.getStatus();
    }
}
