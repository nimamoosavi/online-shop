package com.charisma.payment.contradiction;

import com.charisma.payment.contradiction.dao.ContradictionRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SimpleContradictionService implements IContradiction{

    private final ContradictionRepository contradictionRepository;

    private final ContradictionMapper contradictionMapper;

    @Override
    public void create(Contradiction request) {
        var contradiction = contradictionMapper.toRequestModel(request);
        contradictionRepository.save(contradiction);
    }

    @Override
    public void resolve(String reference) {
        // TODO: 4/22/23 this method must try in scajule to resolve or manually
    }
}
