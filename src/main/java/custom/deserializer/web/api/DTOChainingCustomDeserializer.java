package custom.deserializer.web.api;

import custom.deserializer.dto.BaseClass;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customDeserializer")
public class DTOChainingCustomDeserializer {

    @PostMapping(value = "/execute", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseClass> execute(@RequestBody BaseClass baseClass)
    {
        ResponseEntity<BaseClass> ok = ResponseEntity.ok(baseClass);
        return ok;
    }
}
