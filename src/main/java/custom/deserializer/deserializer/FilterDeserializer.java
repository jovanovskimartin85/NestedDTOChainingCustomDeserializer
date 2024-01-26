package custom.deserializer.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import custom.deserializer.dto.*;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public final class FilterDeserializer extends JsonDeserializer<BaseClass> {
    @Override
    public BaseClass deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {

        ObjectCodec codec = jsonParser.getCodec();
        JsonNode node = codec.readTree(jsonParser);


        String promoteTo = node.get("promoteTo").asText();

        switch (promoteTo) {
            case "associate":
                return codec.treeToValue(node, AssociateQueue.class);
            case "transcribe":
                String claimType = node.get("claim").asText();
                switch (claimType) {
                    case "exist":
                        return codec.treeToValue(node, ExistClaimRequest.class);
                    case "nonexist":
                        return codec.treeToValue(node, CreateClaimRequest.class);
                    default:
                        throw new IllegalArgumentException("Unknown claim type");
                }
            case "finalized":
                String formType = node.get("formType").asText();
                switch (formType) {
                    case "form7":
                        return codec.treeToValue(node, CreateForm7.class);
                    case "form7A":
                        return codec.treeToValue(node, CreateForm7A.class);
                    case "form8":
                        return codec.treeToValue(node, CreateForm8.class);
                    default:
                        throw new IllegalArgumentException("Unknown claim type");
                }
            default:
                throw new IllegalArgumentException("Unknown promoteTo type");
        }
    }
}