package com.example.hcse.ui;

import com.example.hcse.components.LabelComponent;
import com.example.hcse.components.SetValueComponent;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CanvasControllerTest {

    @Test
    void shouldInitializeLabelAndButtonWithCorrectProperties() {
        // Given
        String appType = "Builder";
        CanvasController controller = new CanvasController(appType);

        // When
        var components = controller.getManager().getComponents();

        // Then
        assertEquals(2, components.size(), "Expected 2 components to be added");

        // Check LabelComponent
        assertTrue(
                components.stream().anyMatch(c -> c instanceof LabelComponent &&
                        "Welcome to your Builder".equals(((LabelComponent) c).getProperties().get("text"))),
                "LabelComponent should have welcome message with correct app type"
        );

        // Check SetValueComponent
        assertTrue(
                components.stream().anyMatch(c -> c instanceof SetValueComponent),
                "Should contain a SetValueComponent"
        );
    }
}
