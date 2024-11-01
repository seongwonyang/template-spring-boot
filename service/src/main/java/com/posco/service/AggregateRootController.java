forEach: Aggregate
representativeFor: Aggregate
fileName: {{namePascalCase}}Controller.java
path: {{boundedContext.name}}/s20a01-service/src/main/java/com/posco/{{boundedContext.name}}/s20a01/service
---
package com.posco.{{boundedContext.name}}.s20a01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/{{namePlural}}")
public class {{namePascalCase}}Controller {

    private final {{namePascalCase}}Service {{nameCamelCase}}Service;

    @Autowired
    public {{namePascalCase}}Controller({{namePascalCase}}Service {{nameCamelCase}}Service) {
        this.{{nameCamelCase}}Service = {{nameCamelCase}}Service;
    }

    {{#commands}}
    {{#if isRestRepository}}
    {{else}}
    @PostMapping("/{id}/{{nameCamelCase}}")
    public ResponseEntity<{{../namePascalCase}}> {{nameCamelCase}}(
        @PathVariable("id") {{../keyFieldDescriptor.className}} id,
        @RequestBody {{namePascalCase}}Command command) {
        return ResponseEntity.ok({{../nameCamelCase}}Service.{{nameCamelCase}}(id, command));
    }
    {{/if}}
    {{/commands}}
}