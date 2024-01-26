package custom.usingJsonTypeInfo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ExistClaimRequest extends TranscribeQueue {

    private String claimId;
}
