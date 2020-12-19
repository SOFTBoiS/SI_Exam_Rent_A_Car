package models;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Document
public class Order {
    @Getter
    @Id String id;

    @Getter
    @NonNull String username;
    @Getter
    @NonNull long carId;
    @Getter
    @NonNull String startDate;
    @Getter
    @NonNull String endDate;
    @Getter
    @NonNull long price;

}
