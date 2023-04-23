package com.charisma.sales.catalog.web;

import com.charisma.sales.catalog.CatalogMapper;
import com.charisma.sales.catalog.ICatalog;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.charisma.sales.catalog.web.CatalogUrlMapping.CATALOGS;

/**
 * @author nima
 * @version 1.0.1
 * @implNote this class used for handling the user or admin endpoints
 * @since 1.0.1
 */
@RestController
@RequiredArgsConstructor
public class CatalogController {

    private final ICatalog catalogService;

    private final CatalogMapper catalogMapper;

    /**
     * @apiNote used for return our catalog that may be it doesn't have any authentication
     * @return
     */
    @GetMapping(CATALOGS)
    public ResponseEntity<List<CatalogDTO>> getAllCatalogs(){
        var catalogs = catalogService.getAllCatalogs();
        var response = catalogMapper.toRequestModel(catalogs);
        return ResponseEntity.ok(response);
    }
}
