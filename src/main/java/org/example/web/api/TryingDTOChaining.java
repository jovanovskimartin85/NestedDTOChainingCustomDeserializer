package org.example.web.api;

import org.example.dto.BaseClass;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trying")
public class TryingDTOChaining {

    @PostMapping(value = "/post", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseClass> dtoChaining(@RequestBody BaseClass baseClass)
    {
        ResponseEntity<BaseClass> ok = ResponseEntity.ok(baseClass);
        return ok;
    }
}
