package com.example.colors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.colors.service.ColorService;

@RestController
@RequestMapping("/color")
public class ColorController {

    @Autowired
    private ColorService coloringService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public ResponseEntity<?> colorMap(@RequestBody int[][] adjacencyMatrix) {
        int[] response = coloringService.solveColoring(adjacencyMatrix);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
