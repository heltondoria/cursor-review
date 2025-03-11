package com.codereview.mcp.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public record ReviewOptions(@JsonProperty("minSeverity") int minSeverity, 
                            @JsonProperty("categories") List<String> categories, 
                            @JsonProperty("customPrompt") String customPrompt) {
}