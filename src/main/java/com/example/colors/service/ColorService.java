package com.example.colors.service;

import org.springframework.stereotype.Service;

@Service
public class ColorService {

    private static final int NUMBER_OF_COLORS = 4;

    public int[] solveColoring(int[][] adjacencyMatrix) {
        int numberOfRegions = adjacencyMatrix.length;
        int[] colors = new int[numberOfRegions];

        if (!solve(adjacencyMatrix, colors, 0)) {
            throw new IllegalStateException("No solution exists");
        }
        return colors;
    }

    private boolean solve(int[][] adjacencyMatrix, int[] colors, int region) {
        if (region == colors.length) {
            return true;
        }

        for (int color = 1; color <= NUMBER_OF_COLORS; color++) {
            if (isSafe(adjacencyMatrix, colors, region, color)) {
                colors[region] = color;

                if (solve(adjacencyMatrix, colors, region + 1)) {
                    return true;
                }

                // Backtrack
                colors[region] = 0;
            }
        }
        return false;
    }

    private boolean isSafe(int[][] adjacencyMatrix, int[] colors, int region, int color) {
        for (int neighbor = 0; neighbor < adjacencyMatrix.length; neighbor++) {
            if (adjacencyMatrix[region][neighbor] == 1 && colors[neighbor] == color) {
                return false;
            }
        }
        return true;
    }
}
