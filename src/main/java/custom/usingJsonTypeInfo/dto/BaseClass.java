package custom.usingJsonTypeInfo.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.NoArgsConstructor;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = AssociateQueue.class, name = "pta_associate"),
        @JsonSubTypes.Type(value = ExistClaimRequest.class, name = "ptt_exist"),
        @JsonSubTypes.Type(value = CreateClaimRequest.class, name = "ptt_create"),
        @JsonSubTypes.Type(value = CreateForm7.class, name = "ptf_form7"),
        @JsonSubTypes.Type(value = CreateForm7A.class, name = "ptf_form7a"),
        @JsonSubTypes.Type(value = CreateForm8.class, name = "ptf_form8")
})
@NoArgsConstructor
public class BaseClass {
}
