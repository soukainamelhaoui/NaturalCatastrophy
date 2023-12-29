package ma.fstt.donation.util;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SaveInDistributionRequest {
    private Long distributionId;
    private List<Long> itemIds;
}
