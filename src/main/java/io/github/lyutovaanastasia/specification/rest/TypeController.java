package io.github.lyutovaanastasia.specification.rest;

import io.github.lyutovaanastasia.specification.domain.model.dto.TypeDto;
import io.github.lyutovaanastasia.specification.domain.model.request.TypeRequest;
import io.github.lyutovaanastasia.specification.domain.model.response.TypeResponse;
import io.github.lyutovaanastasia.specification.domain.service.TypeService;
import io.github.lyutovaanastasia.specification.persistence.entity.TypeEntity;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/type")
public class TypeController {

    private final TypeService typeService;

    @GetMapping("/{id}")
    public ResponseEntity<TypeDto> getType(@PathVariable("id") Long id)
        throws MethodArgumentTypeMismatchException, EntityNotFoundException {
        return ResponseEntity.ok(typeService.getType(id));
    }

    @GetMapping()
    public ResponseEntity<List<TypeDto>> getAll() {
        return ResponseEntity.ok(typeService.getAll());
    }

    @PostMapping()
    public ResponseEntity<Long> addType(@RequestBody TypeRequest typeRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(typeService.addType(typeRequest));
    }

    @PutMapping()
    public ResponseEntity<Void> updateType(@RequestBody TypeEntity typeEntity) {
        typeService.updateType(typeEntity);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteType(@PathVariable("id") Long id) {
        typeService.deleteType(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Get a list of news of a specific type",
            description = "Possibility to get a list of news of with type id")
    @GetMapping("/response/{id}")
    public ResponseEntity<TypeResponse> getTypeResponse(@PathVariable("id") Long id)
            throws MethodArgumentTypeMismatchException, EntityNotFoundException {
        return ResponseEntity.ok(typeService.getTypeResponse(id));
    }

    @Operation(summary = "Geе list of all types of news",
            description = "Possibility to get the list of all types of news")
    @GetMapping("/active")
    public ResponseEntity<List<TypeDto>> getTypeActive() {
        return ResponseEntity.ok(typeService.getTypesActive());
    }
}
