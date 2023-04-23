package com.charisma.shipping;

import com.charisma.shipping.enums.DispatchingStatus;
import com.charisma.shipping.valueobject.Dispatch;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public interface IDispatch {

    void changeStatus(@NotBlank String reference, @NotNull DispatchingStatus status);

    DispatchingStatus getStatus(@NotBlank String reference);

    void createTask(Dispatch dispatch);
}
