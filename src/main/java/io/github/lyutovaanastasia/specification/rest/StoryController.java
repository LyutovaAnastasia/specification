package io.github.lyutovaanastasia.specification.rest;

import io.github.lyutovaanastasia.specification.domain.model.dto.StoryDto;
import io.github.lyutovaanastasia.specification.domain.model.request.StoryRequest;
import io.github.lyutovaanastasia.specification.domain.model.response.StoryResponse;
import io.github.lyutovaanastasia.specification.domain.service.StoryService;
import io.github.lyutovaanastasia.specification.persistence.entity.StoryEntity;
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
@RequestMapping("/api/story")
public class StoryController {

    private final StoryService storyService;

    @GetMapping("/{id}")
    public ResponseEntity<StoryDto> getStory(@PathVariable("id") Long id)
        throws MethodArgumentTypeMismatchException, EntityNotFoundException {
        return ResponseEntity.ok(storyService.getStory(id));
    }

    @GetMapping()
    public ResponseEntity<List<StoryDto>> getAll() {
        return ResponseEntity.ok(storyService.getAll());
    }

    @PostMapping()
    public ResponseEntity<Long> addStory(@RequestBody StoryRequest storyRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(storyService.addStory(storyRequest));
    }

    @PutMapping()
    public ResponseEntity<Void> updateStory(@RequestBody StoryEntity storyEntity) {
        storyService.updateStory(storyEntity);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStory(@PathVariable("id") Long id) {
        storyService.deleteStory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Get a list of all news and type",
            description = "Possibility to get a list of all news with types")
    @GetMapping("/response")
    public ResponseEntity<List<StoryResponse>> getStoryResponse() {
        return ResponseEntity.ok(storyService.getStoryResponse());
    }
}
