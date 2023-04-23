package com.charisma.warehouse.packing.web;

import com.charisma.warehouse.packing.IPack;
import com.charisma.warehouse.packing.PackMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static com.charisma.warehouse.packing.web.PackingUrlMapping.PACK;

@RestController
@RequiredArgsConstructor
public class PackingController {

    private final IPack packService;

    private final PackMapper packMapper;



    @GetMapping(PACK)
    public ResponseEntity<PackDTO> findByPackReference(@PathVariable String reference){
        var pack = packService.findByPackReference(reference);
        var packDTO = packMapper.mapToPackDTO(pack);
        return ResponseEntity.ok(packDTO);
    }
}
